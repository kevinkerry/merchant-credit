package com.sdp.mc.intra.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.LimitTypeEnums;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.PolicyTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.NumberUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.vo.MerchantFastSettleVO;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.manager.Newt0LoaningConfigManager;
import com.sdp.mc.service.McManagerService;
import com.sdp.mc.service.fastsettle.FastSettle;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.sdp.mc.service.newt0.loaning.config.LoaningCongfigService;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.WithdrawRatioInfoDOExample;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.manager.WithdrawRatioInfoManager;
import com.sdp.withdraw.vo.ratio.WithdrawRatioResult;
import com.shengpay.pos.PosExternalService;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.MerchantLimitRuleService;
import com.shengpay.service.withdraw.PolicyConfigInfoService;
import com.shengpay.service.withdraw.cost.WithdrawCostConfigService;
import com.shengpay.service.withdraw.cost.impl.WithdrawCostServiceimpl;

/**
 * 快速结算大菜单
 * **/
@Controller
@RequestMapping("/newt0Settle")
public class NewT0SettleIntraAction {
	private static final Logger log = LoggerFactory.getLogger(NewT0SettleIntraAction.class);
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;
	@Autowired
	private Newt0PromoterService newt0PromoterService;
	@Autowired
	private McManagerService mcManagerService;
	@Autowired
	private LoaningCongfigService loaningCongfigService;
	@Autowired
	private FastSettle fastSettle;
	@Autowired
	private WhiteListInfoService whiteListInfoService;
	@Autowired
	private WithdrawCostServiceimpl withdrawCostServiceimpl;
	@Autowired
	private WithdrawCostConfigService withdrawCostConfigService;
	@Autowired
	private FsConfigChangeManager fsConfigChangeManager;
	@Autowired
	private WithdrawRatioInfoManager withdrawRatioInfoManager;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;
	@Autowired
	private Newt0LoaningConfigManager newt0LoaningConfigManager;
	@Autowired
	private PosExternalService posExternalService;
	@Autowired
	private CmPosMerchantDAO cmPosMerchantDAO;
	@Autowired
	private MerchantLimitRuleService merchantLimitRuleService;

	/**
	 * 自动快速结算商户管理--首页
	 * **/
	@RequestMapping(value = "/autoNewt0SettleMerchantIndex")
	public String autoFastSettleMerchantIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/newt0/merchant/index";
	}

	/**
	 * 自动快速结算商户管理--分页查询
	 * **/
	@RequestMapping(value = "/ajaxPaging/autoNewt0SettleMerchantQuery")
	public String autoNewt0SettleMerchantQuery(@ModelAttribute("query") FastSettleConfigDOExampleExt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<FastSettleConfigDOExt> dataList = this.fastSettleConfigManager.selectByQuery4Intra(query);
		model.put("dataList", dataList);
		model.put("query", query);
		return "/newt0/merchant/autoNewt0SettleMerchantList";
	}
	/**
	 * 自动快速结算商户管理--分页查询
	 * **/
	@RequestMapping(value = "/ajax/queryCreditAuthentication")
	@ResponseBody
	public ErrorMessageVO queryCreditAuthentication(String merchantNo,String merchantType, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		StringBuffer buffer=new StringBuffer();
		int num=0;
		String bizType="POS";
		if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantType)){
			num=posExternalService.queryCreditAuthentication(merchantNo);
		}else if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantType)){
			num=mcManagerService.isEasypayMerchantCreditAuthentication(merchantNo)?1:0;
			bizType="云收银";
		}
		buffer.append("当前信用认证卡数："+num+"\n");
		buffer.append("注：该数值为"+bizType+"接口返回，如有疑问，请与"+bizType+"项目组联系。\n");
		return new ErrorMessageVO(true,"1",buffer.toString());
	}

	/**
	 * 自动快速结算商户管理--下载结果
	 *
	 * @throws Exception
	 * **/
	@RequestMapping(value = "/downloadMerchantQueryResult")
	public void downloadMerchantQueryResult(@ModelAttribute("query") FastSettleConfigDOExampleExt query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		query.setNeedQeryTotal(true);
		List<FastSettleConfigDOExt> dataList = this.fastSettleConfigManager.selectByQuery4Intra(query);
		StringBuffer buff = new StringBuffer();
		// ID,
		buff.append("盛付通商户号,商户名称,商户类型类型,自动快速结算,是否开通快速结算,单日最高额度,拓展方商户号,拓展方名称,拓展方保证金,拓展方额度\r\n");
		if (dataList != null) {
			for (FastSettleConfigDOExt doExt : dataList) {
				try {
					String rowStr = getRowInfo(doExt);
					buff.append(rowStr);
					buff.append("\r\n");
				} catch (Exception e) {
					log.error("NewT0IntraAction.getRowInfo error", e);
				}
			}
		}
		String fileName = "merchantlist_" + DateUtil.date2Str(new Date(), DateUtil.forOrderFormat);
		String zipfileName = fileName + ".zip";
		response.setContentType("application/octet-stream;charset=gbk");
		// response.setContentType("application/vnd.ms-excel;charset=gbk");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(zipfileName, "gbk"));
		response.setBufferSize(10240);
		byte[] buffer = new byte[4096];// 缓冲区
		OutputStream out = response.getOutputStream();

		try {
			// 数据字节byteData
			byte[] byteData = buff.toString().getBytes("gbk");
			// 将byteDate 写byteZip
			byte[] byteZip = zip(byteData, fileName);
			// 将byeZip 转IO
			InputStream sbs = new ByteArrayInputStream(byteZip);
			// 将 byteZip 用out输出
			int rc = 0;
			while ((rc = sbs.read(buffer, 0, 4096)) > 0) {
				out.write(buffer, 0, rc);
			}
		} catch (Exception e) {
			log.error("NewT0SettleIntraAction#downloadMerchantQueryResult error" + e.getMessage(), e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				log.error("NewT0SettleIntraAction#downloadMerchantQueryResult final error" + e.getMessage(), e);
			}
		}
	}

	/**
	 * 将byte[]压缩 zip , 并拿到zip的byte[]
	 *
	 * @param data
	 * @param zipfileName
	 * @return
	 */
	private byte[] zip(byte[] data, String zipfileName) {
		byte[] b = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ZipOutputStream zip = new ZipOutputStream(bos);
			ZipEntry entry = new ZipEntry(zipfileName + ".csv");
			zip.setEncoding("gbk");
			entry.setSize(data.length);
			zip.putNextEntry(entry);
			zip.write(data);
			zip.closeEntry();
			zip.close();
			b = bos.toByteArray();
			bos.close();
		} catch (Exception ex) {
			log.error("NewT0SettleIntraAction#zip error" + ex.getMessage(), ex);
		}
		return b;
	}

	private String getRowInfo(FastSettleConfigDOExt doExt) {
		StringBuffer buff = new StringBuffer();
		// buff.append((doExt.getPfcId() == null ? " " : doExt.getPfcId()) +
		// ",");
		buff.append((doExt.getMcMerchantNo() == null ? " " : doExt.getMcMerchantNo()) + ",");
		buff.append((doExt.getMcMerchantName() == null ? " " : doExt.getMcMerchantName()) + ",");
		buff.append(getMcTypeName(doExt.getMcType()) + ",");
		buff.append((doExt.getAutoFastSettle() != null && doExt.getAutoFastSettle() >= 1 ? "是" : "否") + ",");
		buff.append(("1".equals(doExt.getFast_settle_flag())&&"1".equals(doExt.getPmt_fast_settle_flag()) ? "开通" : "关闭") + ",");
		buff.append((NumberUtils.format(doExt.getLimitAmount()) == null ? " " : NumberUtils.format(doExt.getLimitAmount())) + ",");
		buff.append((doExt.getPromoterMerchantNo() == null ? " " : doExt.getPromoterMerchantNo()) + ",");
		buff.append((doExt.getPromoterName() == null ? " " : doExt.getPromoterName()) + ",");
		buff.append((doExt.getPmt_fast_settle_margin() == null ? " " : doExt.getPmt_fast_settle_margin()) + ",");
		buff.append((doExt.getPmt_fast_settle_limit() == null ? " " : doExt.getPmt_fast_settle_limit()) + "");
		return buff.toString();
	}

	private String getMcTypeName(String mcType) {
		if (mcType == null) { return " "; }
		if ("0001".equals(mcType)) {
			return "普通POS商户";
		} else if ("0005".equals(mcType)) {
			return "miniPOS商户";
		} else if ("0006".equals(mcType)) { return "mPOS商户"; }
		return mcType;
	}

	/**
	 * 自动快速结算商户管理--初始化修改页面
	 * **/
	@RequestMapping(value = "/initAutoNewt0Settle")
	public String initAutoNewt0Settle(Long pfcId, Long merchantId, Long promoterId, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		String reqStr = "/newt0/merchant/autoNewt0Settle";
		// 根据商户号查询商户信息
		//MerchantInfoDTO merchantInfo = this.mspFacade.findMerchantInfoByMerchantId(merchantId);
		ViewMerchantInfoDTO merchantInfo = this.merchantInfoService.queryMerchantInfoByMerchantId(merchantId);
		if (null == merchantInfo) return reqStr;
		model.put("o", merchantInfo);
		//查询政策配置信息
		PolicyConfigInfoDO policyConfigInfoDO = null;
		if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())){
			if(!StringUtils.isBlank(merchantInfo.getMerchantMcc())){
				policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.MCC.type, merchantInfo.getMerchantMcc());
				if(policyConfigInfoDO == null){
					model.put("findMccNot", "0");
					return reqStr;
				}
			}
		} else if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())) {
			String policyId = cmPosMerchantDAO.queryPosMerchantPolicyIdByMcId(merchantInfo.getMerchantId());
			if(!StringUtils.isBlank(policyId)){
				policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(policyId);
			}
			//查询额度类型
			WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code,
					merchantInfo.getMerchantNo(), merchantInfo.getMcType());
			if (whiteInfo != null) {
				model.put("limitType", LimitTypeEnums.PERMANENT.code);
			} else {
				model.put("limitType", LimitTypeEnums.TEMPORARY.code);
			}
		} else if (PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())&&StringUtils.isNotBlank(merchantInfo.getMerchantMcc())) {
			policyConfigInfoDO = policyConfigInfoService.queryPolicyConfigInfo(PolicyTypeEnums.EASYPAY.type, merchantInfo.getMerchantMcc());
		}

		//明日生效费率
		WithdrawRatioResult tomorrowEffectiveRatio = fastSettle.getTomorrowEffectiveRatio(merchantInfo.getMerchantNo(), merchantInfo.getMcType());
		if (tomorrowEffectiveRatio != null) {
			model.put("tomorrowEffectiveRatio", tomorrowEffectiveRatio);
		}

		// 根据代理商号查询垫资类型
		Integer loaningType = merchantInfo.getLoaningType();
		model.put("loaningType", loaningType);
		// 根据代理商号沒有查到垫资类型
		if (null == loaningType) return reqStr;
		
		
		// 查询垫资方基础信息

		LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBean(loaningType, merchantInfo.getPromoterType());
		if (loaningConfigBean != null) {
			 if(PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())||PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMcType())){
				if (policyConfigInfoDO != null) {
					if (policyConfigInfoDO.getHolidayRatio() == null
							|| StringUtils.isBlank(policyConfigInfoDO.getHolidayRatio().toString())) {
						String[] holidayFees = loaningConfigBean.getHolidayFees();
						policyConfigInfoDO.setHolidayRatio(new BigDecimal(holidayFees[0]));
					}
					if (policyConfigInfoDO.getWorkdayRatio() == null
							|| StringUtils.isBlank(policyConfigInfoDO.getWorkdayRatio().toString())) {
						String[] workdayFees = loaningConfigBean.getWorkdayFees();
						policyConfigInfoDO.setWorkdayRatio(new BigDecimal(workdayFees[0]));
					}
					String[] strWorkdayRatio = new String[] { policyConfigInfoDO.getWorkdayRatio().toString() };
					String[] strHolidayRatio = new String[] { policyConfigInfoDO.getHolidayRatio().toString() };
					loaningConfigBean.setWorkdayFees(strWorkdayRatio);
					loaningConfigBean.setHolidayFees(strHolidayRatio);
				} else {
					WhiteListFeeBean bean = this.whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
							merchantInfo.getMerchantNo(), merchantInfo.getMcType());
					if (bean == null) {
						bean = this.whiteListInfoService.queryWhiteFee(WhiteTypeEnums.FEE.code,
								merchantInfo.getPromoterMerchantNo() + "", merchantInfo.getPromoterType());
					}
					if (bean != null) {
						loaningConfigBean.setHolidayFees(bean.getHolidayFees());
						loaningConfigBean.setWorkdayFees(bean.getWorkdayFees());
					}
				}
			} else if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())){
				if (policyConfigInfoDO != null) {
					if (policyConfigInfoDO.getHolidayRatio() == null
							|| StringUtils.isBlank(policyConfigInfoDO.getHolidayRatio().toString())) {
						String[] holidayFees = loaningConfigBean.getHolidayFees();
						policyConfigInfoDO.setHolidayRatio(new BigDecimal(holidayFees[0]));
					}
					if (policyConfigInfoDO.getWorkdayRatio() == null
							|| StringUtils.isBlank(policyConfigInfoDO.getWorkdayRatio().toString())) {
						String[] workdayFees = loaningConfigBean.getWorkdayFees();
						policyConfigInfoDO.setWorkdayRatio(new BigDecimal(workdayFees[0]));
					}
					String[] strWorkdayRatio = new String[] { policyConfigInfoDO.getWorkdayRatio().toString() };
					String[] strHolidayRatio = new String[] { policyConfigInfoDO.getHolidayRatio().toString() };
					loaningConfigBean.setWorkdayFees(strWorkdayRatio);
					loaningConfigBean.setHolidayFees(strHolidayRatio);
				}
			}
			model.put("loaningConfigBean", loaningConfigBean);
		}
		// 风控建议额度
		BigDecimal suggestAmount = null;
		try {
			suggestAmount = merchantLimitRuleService.queryMerchantCurrentMerchantLimitRule(merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType());
		} catch (Exception e) {
			log.error("FastSettleIntraAction-->initAutoNewt0Settle-->merchantTradeService.getDayOfAmount 异常");
			suggestAmount = BigDecimal.ZERO;
		}
		model.put("fsLimit", merchantInfo.getMerchantFsLimit()==null
				|| BigDecimal.ZERO.compareTo(merchantInfo.getMerchantFsLimit())==0
						? (policyConfigInfoDO != null && policyConfigInfoDO.getFastSettleLimit() != null
								&& policyConfigInfoDO.getFastSettleLimit().compareTo(BigDecimal.ZERO) > 0
									? policyConfigInfoDO.getFastSettleLimit() 
									: suggestAmount)
						: merchantInfo.getMerchantFsLimit());
		if (policyConfigInfoDO != null && policyConfigInfoDO.getFastSettleLimit() != null && policyConfigInfoDO.getFastSettleLimit().compareTo(BigDecimal.ZERO) > 0) {
			model.put("policyFastSettleLimit", policyConfigInfoDO.getFastSettleLimit());
		}
		
		model.put("suggestAmount", suggestAmount);
		
		
		
		// 查询提现费用
		BigDecimal withdrawCost = withdrawCostConfigService.queryMerchantCurrentWithdrawCostConfig(merchantInfo.getMerchantNo(),
				merchantInfo.getMcType(), merchantInfo.getPromoterMerchantNo(), merchantInfo.getPromoterType(),merchantInfo.getMerchantMcc());
		model.put("wdCost",withdrawCost.compareTo(BigDecimal.ZERO) == 1 ? "+" + withdrawCost + "元" : "");
		
		WithdrawRatioResult currentEffectiveRatio = fastSettle.getCurrentEffectiveRatio(merchantInfo.getMerchantNo(), merchantInfo.getMcType());
		if(currentEffectiveRatio!=null){//当前的费率
			model.put("currentEffectiveRatio", currentEffectiveRatio);
			if(currentEffectiveRatio.getWorkDayWithDrawRatio()!=null&&!isContain(currentEffectiveRatio.getWorkDayWithDrawRatio().toString(),loaningConfigBean.getWorkdayFees())){
				model.put("workdayFee", currentEffectiveRatio.getWorkDayWithDrawRatio());
			}
			if(currentEffectiveRatio.getHolidayWithDrawRatio()!=null&&!isContain(currentEffectiveRatio.getHolidayWithDrawRatio().toString(),loaningConfigBean.getHolidayFees())){
				model.put("holidayFee", currentEffectiveRatio.getHolidayWithDrawRatio());
			}
		}
		FsConfigChangeDOExample example=new FsConfigChangeDOExample();
		example.createCriteria().andObjIdEqualTo(merchantInfo.getMerchantId());
		example.setOrderByClause("CREATE_TIME DESC");
		List<FsConfigChangeDO> dataList = fsConfigChangeManager.selectByExample(example);
		if (dataList != null && dataList.size() > 0) {
			model.put("dataList", dataList);
		}
		WithdrawRatioInfoDOExample exampleRatio=new WithdrawRatioInfoDOExample();
		exampleRatio.setBizId(merchantInfo.getMerchantBizId());
		//仅查询T0的
		exampleRatio.setRatioType(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMcType())?WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code:PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMcType())?WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code:WithdrawRatioTypeEnums.EASYPAY_T0_SETTLE_RATIO.code);
		exampleRatio.setOrderByClause("CRETE_TIME DESC");
		 List<WithdrawRatioInfoDO> dataListRatio= withdrawRatioInfoManager.selectByExample(exampleRatio);
		if (dataListRatio != null && dataListRatio.size() > 0) {
			model.put("dataListRatio", dataListRatio);
		}
		return reqStr;
	}

	private boolean isContain(String fastSettleFee, String[] fees) {
		if(fees!=null&&fees.length>0){
			for(String fee:fees){
				if(fee!=null&&fee.equals(fastSettleFee)){
					return true;
				}
			}
		}
		return false;
	}

	@RequestMapping(value = "/modityAutoNewt0Settle")
	@ResponseBody
	public ErrorMessageVO modityAutoNewt0Settle(MerchantFastSettleVO fastSettleVO, Long merchantId, String merchantNo, Integer autoFastSettle,
			String limitType, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO errorMessage = new ErrorMessageVO(false);
//		MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantId(merchantId);
		ViewMerchantInfoDTO merchantInfoDTO = this.merchantInfoService.queryMerchantInfoByMerchantId(merchantId);
		fastSettleVO.setMerchantNo(merchantInfoDTO.getMerchantNo());
		fastSettleVO.setMcType(merchantInfoDTO.getMcType());
		try {

			// 根据代理商号查询代理商信息
			Integer loaningType = merchantInfoDTO.getLoaningType();
			if (null == loaningType) { return new ErrorMessageVO(false, "-1", "代理商未开通快速结算服务"); }

			if (fastSettleVO.getFastSettleFlag() != null
					&& MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(fastSettleVO.getFastSettleFlag().trim())) {
				LoaningConfigBean loaningConfigBean = loaningCongfigService.getLoaningConfigBean(loaningType, merchantInfoDTO.getPromoterType());
				if (loaningConfigBean == null) { return new ErrorMessageVO(false, "-1", "代理商垫资方类型配置信息不存在"); }
				if (new BigDecimal(fastSettleVO.getFastSettleLimit()).compareTo(loaningConfigBean.getFloorAmt()) < 0) { return new ErrorMessageVO(
						false, "-1", "单日最高额度不能低于" + loaningConfigBean.getFloorAmt() + "元"); }
			}

			if (LoaningTypeEnum.PROMOTER.getCode() == loaningType) {
				// TODO 新增类型判断
				// fastSettleVO.setAutoFastSettle(MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF
				// + "");

			} else if (LoaningTypeEnum.SHENGPAY.getCode() == loaningType) {
				log.info("NewT0SettleIntraAction#modityAutoNewt0Settle.merchantInfoDTO.mcType:" + merchantInfoDTO.getMcType() + "merchantNo:"
						+ merchantInfoDTO.getMerchantNo());
				if (PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfoDTO.getMcType())) {
					// 校验商户是否是直连银行（实时出款银行卡），盛付通全资的情况下是不能让未绑定实时出款银行的商户做快速结算的
					if (fastSettleVO.getFastSettleFlag() != null
							&& MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(fastSettleVO.getFastSettleFlag().trim())) {
						errorMessage = this.mspFacade.isSupportDirect2Bank4ShengPay(merchantInfoDTO.getMerchantNo());
						if (!errorMessage.isSuccess()) { return errorMessage; }
					}
				} else if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfoDTO.getMcType())){
					// MPOS都是手动快速结算的
					if (fastSettleVO.getFastSettleFlag() != null
							&& MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN.equals(fastSettleVO.getFastSettleFlag().trim())) {
						//fastSettleVO.setAutoFastSettle(MerchantCreditConstant.MERCHANT_AUTO_FASTSETTLE_OFF + "");
						ErrorMessageVO eroVo = this.mspFacade.authQuery(merchantInfoDTO.getMerchantNo(), "ZF911");
						if (!eroVo.isSuccess()) { return eroVo; }
						//TODO 信用认证  后台暂时不限制
						/*boolean isCreditAuthentication = mcManagerService.isCreditAuthentication(merchantNo);
						if (!isCreditAuthentication) { return new ErrorMessageVO(false, "-1", "该商户不满足开通条件：未完成信用认证或未绑定提现银行卡。"); }*/
					}
					
				}
			} else {
				return new ErrorMessageVO(false, "-1", "代理商垫资方类型信息不存在");
			}
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			String operatorId = user.getUserName();
			errorMessage = fastSettle.setMerchantFastSettleConfig(fastSettleVO, operatorId);
			WhiteListInfoDO whiteInfo = whiteListInfoService.queryWhiteListInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code,
					merchantInfoDTO.getMerchantNo(), merchantInfoDTO.getMcType());

			if (LimitTypeEnums.PERMANENT.code.equals(limitType)) {
				if (whiteInfo == null) {// 没有白名单，创建白名单
					this.whiteListInfoService.createWhiteInfo(WhiteTypeEnums.AUTO_UPDATE_MERCHANT_LIMIT.code, merchantInfoDTO.getMerchantNo(),
							merchantInfoDTO.getMcType(), LimitRuleInfoConstant.AUTO_UPDATE_MERCHANT_LIMIT_MSG, operatorId);
				}
			} else if (LimitTypeEnums.TEMPORARY.code.equals(limitType)) {
				if (whiteInfo != null) {// 有白名单，关闭白名单
					this.whiteListInfoService.updateLoseEfficacy(whiteInfo.getId(), operatorId);
				}
			}
		} catch (Exception e) {
			log.error("FastSettleIntraAction.modityAutoFastSettle.error,merchantId=" + merchantId + ",autoFastSettle=" + autoFastSettle, e);
			return new ErrorMessageVO(false, "-1", "系统繁忙");
		}

		return errorMessage;
	}
}