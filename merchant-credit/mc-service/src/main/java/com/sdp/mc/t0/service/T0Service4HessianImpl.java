package com.sdp.mc.t0.service;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.facade.msp.FastSettleHessianInterface;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.msp.api.MposHessianApi;
import com.sdp.mc.msp.api.vo.ApplyResult;
import com.sdp.mc.msp.api.vo.MCFastSettleCfg;
import com.sdp.mc.msp.api.vo.MposFastSettleInfo;
import com.sdp.mc.msp.api.vo.ValidOrderResult;
import com.sdp.mc.msp.api.vo.enums.StraightlySettleResultAPIEnums;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.shengpay.pos.pcs.api.settle.StraightlySettleResult;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleCfg;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleService;

@Service("t0Service4Hessian")
public class T0Service4HessianImpl implements MposHessianApi  {
	private FastSettleService fastSettleService;
	
//	@Autowired
//	private MspPosMerchantDAO mspPosMerchantDAO;

	private FastSettleService getFastSettleService() {
		if (fastSettleService == null) {
			fastSettleService = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.NEWT0_SETTLE_MODULE,
					FastSettleService.class);
		}
		return fastSettleService;
	}

	private static final Logger logger = LoggerFactory.getLogger(T0Service4HessianImpl.class);
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private LoaningCongfigService loaningCongfigService;
	@Autowired
	private FastSettleHessianInterface fastSettleHessianInterfaceProxy;
	@Autowired
	private FastSettle fastSettle;
/*	@Autowired
	private MspTxnDAO mspTxnDAO;*/

	/**
	 * 3.1. 获取MPOS T0业务信息
	 *
	 * @param merchantNo
	 *            商户号(6位)
	 * @param posMerchantNo
	 *            Pos商户号
	 * @return
	 */
	public MposFastSettleInfo getMposFastSettleInfo(String merchantNo, String posMerchantNo) {
		logger.info("T0Service4HessianImpl#getMposFastSettleInfo.start merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
	/*	MposFastSettleInfo fastSettleInfo = new MposFastSettleInfo();
		try {
			MerchantInfoDTO merchantInfoDTO = queryDTOInfo(merchantNo, posMerchantNo);
			if(null==merchantInfoDTO){
				fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				fastSettleInfo.setErrorMsg("商户"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return fastSettleInfo;

			}
			//查询代理商是否开通快速结算
			Long promoterId = merchantInfoDTO.getPromoterId();
			FastSettleCfg promoterfsc = getFastSettleService().getPromoterFastSettleCfg(promoterId);
			//查询商户是否开通快速算
			FastSettleCfg fsc = getFastSettleService().getMerchantFastSettleCfg(merchantNo, posMerchantNo);
			if (null == fsc) {
				fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				fastSettleInfo.setErrorMsg("快速结算"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return fastSettleInfo;
			}

			if(null==promoterfsc){
				fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_13.code);
				fastSettleInfo.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_13.msg);
				return fastSettleInfo;

			}else{
				if(false==promoterfsc.isFastSettleFlag()){
					//代理商未开通快速结算-->对应商户快速结算返回关闭
					fastSettleInfo.setFastSettleFlag("0");
				}
			}

			fastSettleInfo.setMerchantNo(merchantNo);
			String msg="";
			fastSettleInfo.setPosMerchantNo(posMerchantNo);
			if (StraightlySettleResult.MERCHANT_HAS_NO_RIGHT.getCode().equals(fsc.getCheckResultCode())) {
				fastSettleInfo.setFastSettleFlag("0");
				msg="商户无权限或配置错误";
			}

			if ("12".equals(fsc.getCheckResultCode())){
				fastSettleInfo.setFastSettleFlag("0");
				msg="商户快速结算规则未配置或已失效";
			}
			if(StringUtils.isBlank(fastSettleInfo.getFastSettleFlag())){
				fastSettleInfo.setFastSettleFlag(fsc.isFastSettleFlag() == true ? "1" : "0");
			}else{
				if(!fastSettleInfo.getFastSettleFlag().equals("0")){
					fastSettleInfo.setFastSettleFlag(fsc.isFastSettleFlag() == true ? "1" : "0");
				}
			}

			// 自动快速结算
			String autoFastSettleFlag="";
			MspPosMerchantEO mspPosMerchantEO = mspPosMerchantDAO.selectPosMerchantInfoByMerchantNo(merchantNo);
//			Long merchantId = Long.parseLong(merchantInfoDTO.getMerchantId());
//			FastSettleConfigDO fastSettleConfigDO = fastSettle.getFastSettleConfig(merchantId, OpObjTypeEnums.MERCHANT.code);
//			if (null == fastSettleConfigDO) {
//				 autoFastSettleFlag=null;
//			}else{
//				 autoFastSettleFlag = String.valueOf(fastSettleConfigDO.getAutoFastSettle());
//				 if(autoFastSettleFlag.equals("2"))autoFastSettleFlag="1";
//			}
			if(mspPosMerchantEO != null && mspPosMerchantEO.getAutoFastSettleFlag() != null){
				fastSettleInfo.setAutoFastSettleFlag(mspPosMerchantEO.getAutoFastSettleFlag().toString());
			}
			// 最小限额

			fastSettleInfo.setFastSettleMinLimit(fsc.getFloorAmt());

			// 结算开始时间
			// 垫资方
			LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(newt0PromoterService.getLoaningTypeByPromoterId(merchantInfoDTO
					.getPromoterId()));
			if (loaningTypeEnum == null) {
				fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				fastSettleInfo.setErrorMsg("垫资方"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return fastSettleInfo;

			}
			// 查询垫资方基础信息
			LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(loaningTypeEnum);
			if(loaningConfigBean!=null){
				fastSettleInfo.setFastSettleStartTime(loaningConfigBean.getFsBeginTime());
				// 结算结束时间
				fastSettleInfo.setFastSettleEndTIme(loaningConfigBean.getFsEndTime());
			}

			// 获取垫资类型
			Integer loaningType = newt0PromoterService.getLoaningTypeByPromoterId(promoterId);
			fastSettleInfo.setLoaningType(loaningType.toString());
			// code&msg
			fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
			if(!StringUtils.isBlank(msg)){
				fastSettleInfo.setErrorMsg(msg);
			}else{
			    fastSettleInfo.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_00.msg);
			}
			return fastSettleInfo;
		} catch (Exception e) {
			logger.info("T0Service4HessianImpl#getMposFastSettleInfo.error merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo, e);
			fastSettleInfo.setCode(StraightlySettleResultAPIEnums.RESULT_ERROR.code);
			fastSettleInfo.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_ERROR.msg);
			return fastSettleInfo;
		}*/
		return null;

	}

	/**
	 * 3.2. MPOS T0交易申请
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @param txnIds
	 *            申请T0交易Id
	 *
	 * @return
	 */
	public ApplyResult applyMposFastSettle(String merchantNo, String posMerchantNo, String[] txnIds) {
			logger.info("T0Service4HessianImpl#applyMposFastSettle.start txnids=:" + ToStringBuilder.reflectionToString(txnIds)+"merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
			/*ApplyResult result = new ApplyResult();
			try {
				result.setMerchantNo(merchantNo);
				result.setPosMerchantNo(posMerchantNo);
				MerchantFastSettleVO fastSettleVO = new MerchantFastSettleVO();
				MerchantInfoDTO merchantInfoDTO = queryDTOInfo(merchantNo, posMerchantNo);
				if(null==merchantInfoDTO){
					result.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
					result.setErrorMsg("商户"+StraightlySettleResultAPIEnums.RESULT_15.msg);
					return result;

				}
				// 通过商户号获取商户ID
				Long merchantId = null;
				if (StringUtils.isNotBlank(merchantInfoDTO.getMerchantId()))
					merchantId = Long.parseLong(merchantInfoDTO.getMerchantId());
				// 验证商户快速结算配置
				StraightlyCfg straightlyCfg = mspFacade.queryStraightlyCfg(merchantId);
				if(straightlyCfg==null){
					logger.info("T0Service4HessianImpl#applyMposFastSettle.straightlyCfg.isStraightFlag false merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
					result.setCode(StraightlySettleResultAPIEnums.RESULT_12.code);
					result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_12.msg);
					return result;
				}
				if (!straightlyCfg.isStraightFlag()) {
					logger.info("T0Service4HessianImpl#applyMposFastSettle.straightlyCfg.isStraightFlag false merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
					result.setCode(StraightlySettleResultAPIEnums.RESULT_12.code);
					result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_12.msg);
					return result;
				}
				*//**
				 * 新T0增加时间判断
				 *//*
				// 垫资方
				Long promoterId = merchantInfoDTO.getPromoterId();
				Integer loaningType = newt0PromoterService.getLoaningTypeByPromoterId(promoterId);
				LoaningTypeEnum loaningTypeEnum = LoaningTypeEnum.getLoaningTypeEnum(loaningType);
				if (loaningTypeEnum == null) {
					logger.info("T0Service4HessianImpl#applyMposFastSettle getLoaningTypeEnum is null merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
					result.setCode("垫资方"+StraightlySettleResultAPIEnums.RESULT_15.code);
					result.setErrorMsg("垫资方"+StraightlySettleResultAPIEnums.RESULT_15.msg);
					return result;
				}
				// 查询垫资方基础信息
				LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBeanByLoaningType(loaningTypeEnum);
				if(loaningConfigBean==null){
					logger.info("T0Service4HessianImpl#applyMposFastSettle.getLoaningConfigBeanByLoaningType loaningConfigBean is null" + loaningTypeEnum+" merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
					result.setCode("垫资方"+StraightlySettleResultAPIEnums.RESULT_15.code);
					result.setErrorMsg("垫资方"+StraightlySettleResultAPIEnums.RESULT_15.msg);
					return result;
				}
				fastSettleVO.setFeeRate(straightlyCfg.getFeeRate()+"");
				Date currentDate = new Date();
				if (currentDate.compareTo(loaningConfigBean.findFsBeginDate()) == -1 || currentDate.compareTo(loaningConfigBean.findFsEndDate()) == 1) {
					logger.info("T0Service4HessianImpl#applyMposFastSettle is not allowed" + promoterId+"merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
					result.setCode(StraightlySettleResultAPIEnums.RESULT_11.code);
					result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_11.msg);
					return result;

				}
				merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(merchantId);
				if(null==merchantInfoDTO){
					result.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
					result.setErrorMsg("商户"+StraightlySettleResultAPIEnums.RESULT_15.msg);
					return result;

				}
				//这需要对账号进行判断，如果是MPOS则走
				// 盛付通全资校验商户是否是实时出款银行
				if(merchantInfoDTO.getMcType().equals(MerchantContractCst.TYPE_MPOS_MERCHANT)){
					//TODO:待确认接口
					ErrorMessageVO eroVo =this.mspFacade.authQuery(merchantInfoDTO.getMerchantNo(),"ZF910");
					if (!eroVo.isSuccess()) {
						logger.info("T0Service4HessianImpl#applyMposFastSettle authQuery is not sucess merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
						result.setCode(StraightlySettleResultAPIEnums.RESULT_14.code);
						result.setErrorMsg(eroVo.getErrorMessage());
						return result;
					}

				}else{
					if (LoaningTypeEnum.SHENGPAY == loaningTypeEnum && merchantInfoDTO.getFastSettleFlag() != null
							&& MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(merchantInfoDTO.getFastSettleFlag().toString())) {
						ErrorMessageVO errorMessage = this.mspFacade.isSupportDirect2Bank4ShengPay(merchantInfoDTO.getMerchantNo());
						logger.info("T0Service4HessianImpl#applyMposFastSettle isSupportDirect2Bank4ShengPay.vo"
								+ ToStringBuilder.reflectionToString(errorMessage)+" merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
						if (!errorMessage.isSuccess()) {
							logger.info("T0Service4HessianImpl#applyMposFastSettle isSupportDirect2Bank4ShengPay is not sucess  merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo);
							result.setCode(StraightlySettleResultAPIEnums.RESULT_14.code);
							result.setErrorMsg(errorMessage.getErrorMessage());
							return result;
						}
					}
				}

				List<Long> ids = new ArrayList<Long>();
				String[] txnOrderNosArr = txnIds;
				for (String txnOrderNoStr : txnOrderNosArr) {
					ids.add(Long.parseLong(txnOrderNoStr));
				}

				logger.info("promoterId"+promoterId);
				logger.info("merchantNo"+merchantNo);
				logger.info("posMerchantNo"+posMerchantNo);
				logger.info("merchantId"+merchantId);
				List<McSettFastTxnRO> mcSettFastTxnROs=new ArrayList<McSettFastTxnRO>();
				mcSettFastTxnROs=this.queryMPOSMerchantValidFsOrders(ids,merchantNo);
				ErrorMessageVO vo = mspFacade.straightlySettleMPOS(promoterId, merchantNo, posMerchantNo, merchantId.toString(),
						MerchantCreditConstant.MERCHANT_FASTSETTLE_TYPE_MANUAL, ids, fastSettleVO.getFeeRate(), mcSettFastTxnROs);
				if(vo.isSuccess()){
					result.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
					result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_00.msg);
				}else{
					result.setCode(vo.getErrorCode());
					result.setErrorMsg(vo.getErrorMessage());
				}

				return result;
			} catch (Exception e) {
				logger.error("T0Service4HessianImpl #applyMposFastSettle.error", e);
				result.setCode(StraightlySettleResultAPIEnums.RESULT_ERROR.code);
				result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_ERROR.msg);
				return result;
			}*/
			return null;


	}

	/**
	 * 3.2.查询可发起快速结算的订单编号
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return 订单号结果信息
	 */
	public ValidOrderResult queryValidOrderList(String merchantNo, String posMerchantNo) {
		logger.info("T0Service4HessianImpl#queryValidOrderList.start.merchantNo=" + merchantNo + " posMerchantNo="
				+ posMerchantNo);
		/*ValidOrderResult result = new ValidOrderResult();
		try {
			List<ValidOrders> results = fastSettleHessianInterfaceProxy.queryValidOrderList(merchantNo, posMerchantNo);
			if (results == null) {
				logger.info("T0Service4HessianImpl#queryValidOrderList.list is null");
				result.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_15.msg);
				return result;
			}
			logger.info("T0Service4HessianImpl#queryValidOrderList.list"
					+ ToStringBuilder.reflectionToString(results)+" merchantNo=" + merchantNo + " posMerchantNo="+posMerchantNo);
			List<MCValidOrders> returnResults = new ArrayList<MCValidOrders>();
			for (ValidOrders or : results) {
				logger.info("T0Service4HessianImpl#queryValidOrderList.result.ValidOrders"
						+ ToStringBuilder.reflectionToString(or)+" merchantNo=" + merchantNo + " posMerchantNo="+posMerchantNo);
				MCValidOrders reOrder = new MCValidOrders();
				reOrder.setOrderId(or.getOrderId());
				reOrder.setSelected(or.isSelected());
				returnResults.add(reOrder);
			}
			result.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
			result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_00.msg);
			result.setResults(returnResults);
			return result;
		} catch (Exception e) {
			logger.error("T0Service4HessianImpl#queryValidOrderList.Error while validate orders  merchantNo=" + merchantNo+" posMerchantNo="+posMerchantNo, e);
			result.setCode(StraightlySettleResultAPIEnums.RESULT_ERROR.code);
			result.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_ERROR.msg);
			return result;

		}*/
		return null;

	}

	/**
	 * 3.4. 商户快速结算信息
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return
	 */
	public MCFastSettleCfg getMerchantFastSettleCfg(String merchantNo, String posMerchantNo) {
		MCFastSettleCfg mcFcif = new MCFastSettleCfg();
		try {
			//查询商户是否开通快速算
			FastSettleCfg fsc = getFastSettleService().getMerchantFastSettleCfg(merchantNo, posMerchantNo);
			if (null == fsc) {
				mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				mcFcif.setErrorMsg("对应商户快速结算"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return mcFcif;
			}
			MerchantInfoDTO merchantInfoDTO=this.queryDTOInfo(merchantNo, posMerchantNo);
			mcFcif.setMerchantNo(fsc.getMerchantNo());
			mcFcif.setPosMerchantNo(fsc.getPosMerchantNo());
			mcFcif.setPromoterId(String.valueOf(fsc.getPromoterId()));
			//查询代理商是否开通快速结算
			if(merchantInfoDTO==null){
				mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				mcFcif.setErrorMsg("对应商户"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return mcFcif;
			}
			Long promoterId = merchantInfoDTO.getPromoterId();
			FastSettleCfg promoterfsc = getFastSettleService().getPromoterFastSettleCfg(promoterId);

			if(null==promoterfsc){
				mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_15.code);
				mcFcif.setErrorMsg("对应代理商快速结算"+StraightlySettleResultAPIEnums.RESULT_15.msg);
				return mcFcif;

			}else{
				if(false==promoterfsc.isFastSettleFlag()){
					//代理商未开通快速结算-->对应商户快速结算返回关闭
					mcFcif.setFastSettleFlag(promoterfsc.isFastSettleFlag());
				}else{
					mcFcif.setFastSettleFlag(fsc.isFastSettleFlag());
				}

			}


			if(mcFcif.isFastSettleFlag()){
				if (StraightlySettleResult.MERCHANT_HAS_NO_RIGHT.getCode().equals(fsc.getCheckResultCode())) {
					mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
					mcFcif.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_01.msg);
					mcFcif.setCredit(new BigDecimal(0));
					mcFcif.setValidCredit(new BigDecimal(0));
					mcFcif.setFeeRate(new BigDecimal(0));
					mcFcif.setFloorAmt(new BigDecimal(0));
					mcFcif.setFastSettleFlag(false);
					return mcFcif;
				}

				if ("12".equals(fsc.getCheckResultCode())){
					mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
					mcFcif.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_12.msg);
					mcFcif.setCredit(new BigDecimal(0));
					mcFcif.setValidCredit(new BigDecimal(0));
					mcFcif.setFeeRate(new BigDecimal(0));
					mcFcif.setFloorAmt(new BigDecimal(0));
					mcFcif.setFastSettleFlag(false);
					return mcFcif;
				}
				mcFcif.setCredit(fsc.getCredit());
				mcFcif.setValidCredit(fsc.getValidCredit());
				mcFcif.setFeeRate(fsc.getFeeRate());
				mcFcif.setFloorAmt(fsc.getFloorAmt());

			}else{
				mcFcif.setCredit(new BigDecimal(0));
				mcFcif.setValidCredit(new BigDecimal(0));
				mcFcif.setFeeRate(new BigDecimal(0));
				mcFcif.setFloorAmt(new BigDecimal(0));

			}
			mcFcif.setCheckResultCode(fsc.getCheckResultCode());
			mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_00.code);
			mcFcif.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_00.msg);
			return mcFcif;
		} catch (Exception e) {
			logger.error("T0Service4HessianImpl.getMerchantFastSettleCfg.Error", e);
			mcFcif.setCode(StraightlySettleResultAPIEnums.RESULT_ERROR.code);
			mcFcif.setErrorMsg(StraightlySettleResultAPIEnums.RESULT_ERROR.msg);
			return mcFcif;
		}

	}

	protected MerchantInfoDTO queryDTOInfo(String merchantNo, String posMerchantNo) {
		try {
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNoPosMerchantNo(merchantNo, posMerchantNo);
			return merchantInfoDTO;
		} catch (Exception e) {
			logger.error("queryDTOInfo is error mspFacade.findMerchantInfoByMerchantNoPosMerchantNo merchantNo="+merchantNo+"posMerchantNo="+posMerchantNo,e);
			return null;
		}

	}
	/**
	 * MPOS快速結算
	 * @param ids
	 * @param merchantNo
	 * @return
	 */
	/*public List<McSettFastTxnRO> queryMPOSMerchantValidFsOrders(List<Long>ids,String merchantNo) {
		List<McSettFastTxnRO> roList=new ArrayList<McSettFastTxnRO>();
		StringBuffer sb = new StringBuffer();
		for (Long id : ids) {
			sb.append(id).append(",");
		}
		String orderNos = sb.toString();
		if (orderNos.lastIndexOf(",") > 0)
			orderNos = orderNos.substring(0, orderNos.length() - 1);
		long start = System.currentTimeMillis();
		logger.info("MspFacadeImpl #queryMPOSMerchantValidFsOrders startTime  ="+merchantNo+"ids="+ids);
		List<McMspTxnVO> list = mspTxnDAO.mcQueryMspTxnByOrderNos(orderNos);
		long end = System.currentTimeMillis();
		logger.info("MspFacadeImpl #queryMPOSMerchantValidFsOrders time  ="+String.valueOf(end-start));
		if (list == null || list.isEmpty()) {
			logger.info("MspFacadeImpl #queryMPOSMerchantValidFsOrders mcMspTxnVOList is empty.merchantNo="+merchantNo);
			return roList;
		}
		// 以msp系统里的交易为准
		for (McMspTxnVO mcMspTxnVO : list) {
			logger.info("MspFacadeImpl #queryMerchantValidFsOrders mcMspTxnVO" + ToStringBuilder.reflectionToString(mcMspTxnVO));
			McSettFastTxnRO mcSettFastTxnRO = new McSettFastTxnRO(mcMspTxnVO, true);
			roList.add(mcSettFastTxnRO);
			mcSettFastTxnRO.setTxnStatusName(DictionaryHelper.getValue(DictionaryHelper.LABEL_TXN_STATUS, mcSettFastTxnRO.getTxnStatus()));
			mcSettFastTxnRO.setStlStatusName(DictionaryHelper.getValue(DictionaryHelper.LABEL_STL_STATUS, String.valueOf(mcSettFastTxnRO.getStlStatus())));
			mcSettFastTxnRO.setTxnTypeName(DictionaryHelper.getValue(DictionaryHelper.LABEL_TXN_TYPE, String.valueOf(mcSettFastTxnRO.getTxnType())));
			mcSettFastTxnRO.setCurName(DictionaryHelper.getValue(DictionaryHelper.LABEL_CUR, String.valueOf(mcSettFastTxnRO.getCur())));
			mcSettFastTxnRO.setCardTypeName(DictionaryHelper.getValue(DictionaryHelper.LABEL_CARD_TYPE, String.valueOf(mcSettFastTxnRO.getCardType())));
			mcSettFastTxnRO.setSrvEntryModeName(DictionaryHelper.getValue(DictionaryHelper.LABEL_SRV_ENTRY_MODE, String.valueOf(mcSettFastTxnRO.getSrvEntryMode())));
			mcSettFastTxnRO.setRespCodeName(DictionaryHelper.getValue(DictionaryHelper.LABEL_RESP_CODE, String.valueOf(mcSettFastTxnRO.getRespCode())));
			mcSettFastTxnRO.setIssuerName(MspCardIssuerHelper.getCardIssuerName(mcSettFastTxnRO.getIssuerId()));

		}

		return roList;
	}*/

}
