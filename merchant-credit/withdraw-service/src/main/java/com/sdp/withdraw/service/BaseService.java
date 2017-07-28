package com.sdp.withdraw.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.MerchantStatusEnums;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.integration.ma.dto.MerchantInfoMADTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.settle.api.enums.PosMerchantTypeEnums;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.OpLogRecordManager;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.shengpay.boss.service.crm.query.api.DelegationPay2CardQueryService;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardInfo;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryResponse;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.mpos.realname.MerchantRealNameMPOS;
import com.shengpay.poss.service.realname.remote.vo.BankAccountQueryInfo;
import com.shengpay.poss.service.realname.remote.vo.PersonalAuthInfo;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.view.PromoterInfoService;

public class BaseService {
	private Logger logger = LoggerFactory.getLogger(BaseService.class);
	@Autowired
	protected Mapper beanMapper;
	@Autowired
	protected MaOnlineWrapper maOnlineWrapper;
	@Autowired
	protected DelegationPay2CardQueryService delegationPay2CardQueryService;
	@Autowired
	protected MerchantRealNameMPOS merchantRealNameMPOS;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Autowired
	private OpLogRecordManager opLogRecordManager;
//	@Autowired
//	protected PromoterDAO promoterDAO;
	@Autowired
	protected PromoterInfoService promoterInfoService;
	@Autowired
	protected MerchantInfoService merchantInfoService;
	// 委托到卡秘钥
	private static final String crMPosMD5Key = GlobalConfig.getString("withdraw.crm.pos.delegate.to.card", "");

	/**
	 * 插入log
	 *
	 * @param jsonContent
	 * @param code
	 * @param opType
	 * @return
	 */
	public boolean insertOpLogRecord(String jsonContent, String recordType, String opType) {
		OpLogRecordDO log = new OpLogRecordDO();
		log.setOpRecord(jsonContent);
		log.setOpType(opType);
		log.setRecordType(recordType);
		log.setCreateTime(new Date());
		log.setUpdateTime(new Date());
		Long id = opLogRecordManager.insert(log);
		if (id > 0) { return true; }
		return false;
	}

	/**
	 * 根据商户号查询memberID
	 *
	 * @param merchantNo
	 * @return
	 */
	protected ErrorMessageVO<Object> queryMemberIdByMerhantNo(String merchantNo) {
		ErrorMessageVO<Object> vo = null;
		try {
			MerchantInfoMADTO merchantInfo = maOnlineWrapper.queryMAMerchantInfoByMerchantNo(merchantNo);
			if (null != merchantInfo) {
				Map<String, Object> params = new HashMap<String, Object>();
				if (StringUtils.isBlank(merchantInfo.getMemberId())) {
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_DATA_FAILS.code, ReturnCodeEnums.FW_MA_DATA_FAILS.msg);
				} else {
					if(!merchantInfo.getMerchantStatus().equals(MerchantStatusEnums.ACTIVE.code)){
						vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.PAYER_MEMBER_STATUS_INACTIVE.code, ReturnCodeEnums.PAYER_MEMBER_STATUS_INACTIVE.msg);
					}
					vo = new ErrorMessageVO<Object>(true);
					params.put("memberId", merchantInfo.getMemberId());
					vo.setParams(params);
				}
			} else {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_DATA_FAILS.code, ReturnCodeEnums.FW_MA_DATA_FAILS.msg);
			}
			return vo;
		} catch (Exception e) {
			logger.error("BaseService#queryMemberIdByMerhantNo is error" + e.getMessage(), e);
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_INTERFACE_EXCEPTION.code, ReturnCodeEnums.FW_MA_INTERFACE_EXCEPTION.msg);
			return vo;
		}
	}

	/**
	 * 查询储值账号ID AccountType.CREDIT_ACCOUNT
	 *
	 * @param memberId
	 * @param dto
	 * @param accountType
	 * @return
	 */
	protected ErrorMessageVO<Object> queryAccount(String memberId, WithdrawCoreServiceDTO dto) {

		ErrorMessageVO<Object> vo = null;
		try {
			AccountInfo accountInfo=maOnlineWrapper.queryBaseAccountInfo(memberId, IPUtils.getLocalIp());
			if(accountInfo==null){
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_DATA_FAILS.code, ReturnCodeEnums.FW_MA_DATA_FAILS.msg+",付款方账户信息不存在");
				return vo;
			}
			logger.info("BaseService#queryAccount  memberId:"+memberId+" accountInfo:" +ToStringBuilder.reflectionToString(accountInfo));
			String payerAccountNo =accountInfo.getAccountId();
			if (StringUtils.isBlank(payerAccountNo)) {
				logger.error("BaseService#queryAccount  memberId:"+memberId+" payerAccountNo is null");
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_DATA_FAILS.code, ReturnCodeEnums.FW_MA_DATA_FAILS.msg);
			} else {
				if(dto!=null){
				    dto.setPayerAccountNo(payerAccountNo);
				}
				logger.info("BaseService#queryAccount  memberId:"+memberId+" accountInfo status:" +accountInfo.getStatus());
				if(accountInfo.getStatus()==0L){
					vo = new ErrorMessageVO<Object>(false,ReturnCodeEnums.FW_PAYER_ACCOUNT_INACTIVE.code,ReturnCodeEnums.FW_PAYER_ACCOUNT_INACTIVE.msg);
					return vo;
				}
				if(accountInfo.getStatus()==2L){
					vo = new ErrorMessageVO<Object>(false,ReturnCodeEnums.FW_PAYER_ACCOUNT_LOCKED.code,ReturnCodeEnums.FW_PAYER_ACCOUNT_LOCKED.msg);
					return vo;
				}
				if(accountInfo.getStatus()==3L){
					vo = new ErrorMessageVO<Object>(false,ReturnCodeEnums.FW_PAYER_ACCOUNT_OUT_FORBIDDEN.code,ReturnCodeEnums.FW_PAYER_ACCOUNT_OUT_FORBIDDEN.msg);
					return vo;
				}
				if(accountInfo.getStatus()==5L){
					vo = new ErrorMessageVO<Object>(false,ReturnCodeEnums.FW_PAYER_ACCOUNT_CANCELED.code,ReturnCodeEnums.FW_PAYER_ACCOUNT_CANCELED.msg);
					return vo;
				}
				vo = new ErrorMessageVO<Object>(true);
			}
			return vo;
		} catch (Exception e) {
			logger.error("BaseService#queryAccount is error memberId:" + memberId + e.getMessage(), e);
			return new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_MA_INTERFACE_EXCEPTION.code, ReturnCodeEnums.FW_MA_INTERFACE_EXCEPTION.msg);
		}
	}

	/**
	 * 根据商户号获取会员号
	 *
	 * @param merchantNo
	 * @return
	 */
	protected String queryMemberIdByMerchantNo(String merchantNo) {
		try {
			return maOnlineWrapper.queryPromoterInfoByMerchantNo(merchantNo).getMemberId();
		} catch (Exception e) {
			logger.error("BaseService#queryMemberIdByMerchantNo is error merchantNo:" + merchantNo + e.getMessage(), e);
			return null;
		}

	}

	/**
	 * mpos 提现银行卡信息
	 *
	 * @param merchantNo
	 * @param zfCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected BankAccountQueryInfo realNamebankInfo(String merchantNo, String zfCode) {
		ErrorMessageVO<Object> vo = merchantRealNameMPOS.authQuery(merchantNo, zfCode);
		if (!vo.isSuccess()) { return null; }
		if (!vo.getParams().containsKey("bankAccountQueryInfo")) {
			return null;
		}
		BankAccountQueryInfo bankInfo = (BankAccountQueryInfo) vo.getParams().get("bankAccountQueryInfo");
		return bankInfo;
	}

	/**
	 * CRM 实名个人信息
	 *
	 * @param merchantNo
	 * @param zfCode
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected PersonalAuthInfo realPersonalInfo(String merchantNo, String zfCode) {
			ErrorMessageVO<Object> vo = merchantRealNameMPOS.authQuery(merchantNo, zfCode);
			if (!vo.isSuccess()) { return null; }
			if (!vo.getParams().containsKey("personalAuthInfo")) { return null; }
			PersonalAuthInfo persona = (PersonalAuthInfo) vo.getParams().get("personalAuthInfo");
			return persona;

	}

	/**
	 * 判断该商户是否支持直连银行
	 *
	 * @param merchantNo商户号
	 * **/
	protected ErrorMessageVO<Object> queryCRMbankInfo(String merchantNo) {
		ErrorMessageVO<Object> vo = null;
		Map<String, Object> params = new HashMap<String, Object>();
		try {

			DelegationPay2CardQueryRequest req = new DelegationPay2CardQueryRequest();
			req.setAppId("ZF946");
			req.setRequestId(UUID.randomUUID().toString().replaceAll("-", ""));
			req.setRequestTime(com.sdo.common.util.DateUtil.getLongDateString(new Date()));
			req.setMerchantid(merchantNo);
			req.setMac(DigestUtils.md5Hex(req.getAppId() + req.getRequestId() + req.getRequestTime() + crMPosMD5Key));// 签名串
			DelegationPay2CardQueryResponse resp = delegationPay2CardQueryService.queryByMerchantid(req);
			if (resp.getHeader().getRetCode() == 0) {
				DelegationPay2CardInfo delegationPay2CardInfo = resp.getDelegationPay2CardInfo();
				if (null == delegationPay2CardInfo) {
					vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.code, ReturnCodeEnums.FW_NOT_BACK_CARD_INFO.msg);
					return vo;
				} else {
					vo = new ErrorMessageVO<Object>(true);
					params.put("delegationPay2CardInfo", delegationPay2CardInfo);
					vo.setParams(params);
					return vo;
				}


			} else {
				vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.code,
						ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.msg);
				return vo;
			}
		} catch (Exception e) {
			logger.error("BaseService#isSupportDirect2Bank4Agent is error merchantNo:" + merchantNo + e.getMessage(), e);
			vo = new ErrorMessageVO<Object>(false, ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.code, ReturnCodeEnums.FW_CRM_INTERFACE_EXCEPTION.msg);
			return vo;
		}

	}
	public boolean validateFastFundOutBank(final String bankCode) {
		if(StringUtils.isBlank(bankCode)) return false;
		// 取出配置的8家快速出款银行
		String fastFundOutBankList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEWT0_FAST_FUND_OUT_BANK_LIST);
		if (fastFundOutBankList != null && !"".equals(fastFundOutBankList)) {
			String[] bankCodes = fastFundOutBankList.split(",");
			for (String string : bankCodes) {
				if (bankCode.equals(string)) {
					return true;
				}
			}
		}
		return false;
	}

	protected void buildDTO(DelegationPay2CardInfo cardInfo) {
		beanMapper.map(cardInfo, WithdrawCoreServiceDTO.class);
	}
	/**
	 * 根据代理商商户号查询 代理商号
	 *
	 * @param merchantNo
	 * @return
	 */
	/*protected ViewPromoterInfoDTO queryPromoterNo(String merchantNo, String mcType) {
		try {
			List<ViewPromoterInfoDTO> list = promoterInfoService.queryPromoterInfoByMerchantInfo(merchantNo, mcType);
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			} else {
				logger.error("WithDrawBaseService#queryPromoterNo promoterNo is  null merchantNo:" + merchantNo);
				return null;
			}
		} catch (Exception e) {
			logger.error("WithDrawBaseService#queryPromoterNo is error:" + merchantNo + " " + e.getMessage(), e);
			return null;
		}
	}*/
	protected WithdrawReqDO buildWithdrawReqDO(WithdrawT0ServiceRequest requestDTO) {
		WithdrawReqDO reqDo= beanMapper.map(requestDTO, WithdrawReqDO.class);
		ViewMerchantInfoDTO proEO=merchantInfoService.queryMerchantInfoByMerchantNo(requestDTO.getMerchantNo(), requestDTO.getMcType());
		if(proEO!=null){
			reqDo.setPmtMemberId(proEO.getPromoterId()==null?"":proEO.getPromoterId().toString());
			reqDo.setPmtMerchantNo(proEO.getPromoterMerchantNo());
			reqDo.setMerchantBizId(proEO.getMerchantBizId());
			reqDo.setLastLevelPromoterId(proEO.getLastLevelPromoterId());
			if(requestDTO.getExtention()!=null){
				reqDo.setReqExtention(JSONObject.fromObject(requestDTO.getExtention()).toString());
				if(requestDTO.getExtention().get(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN)!=null){
					reqDo.setHasOaTxn(requestDTO.getExtention().get(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN).toString());
				}
			}
			//只有mpos商户出款落地mcc
			reqDo.setMcc(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(requestDTO.getMcType())?proEO.getMerchantMcc():"0");
		}else{
			logger.error("#buildWithdrawReqDO proEO is  null, requestDTO:" + ToStringBuilder.reflectionToString(requestDTO));
		}
		return reqDo;
	}

	/**
	 * 计算出款手续费用
	 *
	 * @param amount
	 * @param withdrawFee
	 * @return
	 */
	protected BigDecimal withdrawFee(BigDecimal amount, BigDecimal withdrawRate) {
		try {
			return (amount).multiply(withdrawRate);
		} catch (Exception e) {
			logger.error("BaseService#calculatePoundage is error" + e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 根据商户号分润费率
	 *
	 * @param merchantNo
	 * @return
	 */
	protected BigDecimal splittingRate(String merchantNo) {
		// TODO:等待填充代码
		return BigDecimal.ZERO;
	}

	/**
	 * 计算分润费用
	 *
	 * @param amount
	 * @param withdrawFee
	 * @return
	 */
	protected BigDecimal calculateSplittingFee(BigDecimal amount, BigDecimal splittingRate) {
		try {
			// TODO:等待填充代码
			return (amount).multiply(splittingRate);
		} catch (Exception e) {
			logger.error("BaseService#calculateSplittingFee is error" + e.getMessage(), e);
			return null;
		}

	}

	/**
	 * 获取产品码
	 *
	 * @return
	 */
//	protected String getProductCode() {
//		// TODO:还没确定
//		return "11021";
//	}

	/**
	 * 获取应用ＩＤ　监控ID 出款服务的，
	 *
	 * @return
	 */
	protected String getAppId() {
        String withdrawAppid = GlobalConfig.getString("fos.withdraw.service.appid",WithdrawConstant.FOS_WITHDRAW_SERVICE_APP_ID);
		return withdrawAppid;
	}

	/**
	 * 获取支付编码
	 *
	 * @return
	 */
//	protected String getPaymentCode() {
//		// TODO:还没确定
//		return "3001";
//	}

	/**
	 * 形成支付订单号
	 *
	 * @param productCode
	 *            产品编码
	 * @param paymentCode
	 *            支付编码
	 * @param retryTimes
	 *            重试次数
	 * @param reqId
	 *            请求ID
	 * @return
	 */
	protected String generateRemitVoucherNo(String productCode, String paymentCode, int retryTimes, Long reqId) {
		String key = productCode + paymentCode + String.format("%04d", retryTimes);
		key = key + String.format("%0" + (32 - key.length()) + "d", reqId);
		return key;
	}

	// protected String getRemitVoucheNo(WithdrawReqDO reqdo) {
	// // 获取出款订单号
	// String remitVoucheNo = generateRemitVoucherNo(this.getProductCode(),
	// this.getPaymentCode(), reqdo.getRetryTimes(), reqdo.getReqId());
	// return remitVoucheNo;
	// }

	/**
	 * 查询MA信息
	 * @param record
	 * @param merchantNo
	 * @return
	 */
	public PosMerchantInfoDO initMaPara(PosMerchantInfoDO record,String merchantNo){
		try {
			String memberId = "";
			ErrorMessageVO<Object> vo = queryMemberIdByMerhantNo(merchantNo);
			if (vo.isSuccess()) {
				memberId = vo.getParams().get("memberId").toString();
				AccountInfo accountInfo=maOnlineWrapper.queryBaseAccountInfo(memberId, IPUtils.getLocalIp());
				if (accountInfo!=null) {
					record.setBaseAccountId(accountInfo.getAccountId());// 基本账户
					record.setAccountType(String.valueOf(accountInfo.getAccountType())); // 商户类型
					memberId = accountInfo.getMemberId();
					record.setMerchantMemberId(memberId);
				}
			}
		} catch (Exception e) {
			logger.error("query ma error: ",e);
		}
		return record;
	}

}
