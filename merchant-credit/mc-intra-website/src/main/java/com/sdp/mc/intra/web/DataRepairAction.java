package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.intra.worker.sync.Constants;
import com.sdp.mc.intra.worker.sync.SyncMerchantHandler;
import com.sdp.mc.service.apply.FastSettleApply;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.shengpay.pos.PosExternalService;
import com.shengpay.service.whitelist.WhiteListInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Controller
@RequestMapping("/repair")
public class DataRepairAction {
	private static final Logger logger = LoggerFactory.getLogger(DataRepairAction.class);

	@Autowired
	private PromoterService promoterService;
	@Autowired
	protected SyncMerchantHandler syncMerchantHandler;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private PosExternalService posExternalService;

	@Autowired
	private ScSettleBaseService scSettleBaseService;
	@Autowired
	private NewT0MerchantFastSettleService newT0MerchantFastSettleService;
	@Autowired
	private WhiteListInfoService whiteListInfoService;
	@Autowired
	private WithdrawReqFosDetailService withdrawReqFosDetailService;
	@Autowired
	private WithdrawReqService withdrawReqService;
	@Autowired
	private FastSettleApply fastSettleApply;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/repair/index";
	}

	@RequestMapping("/distinctMerchant")
	public String distinctMerchant(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.distinctMerchant();
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("distinctMerchant end result:" + resultJson);
		return "/withdraw/resultInfo";
	}

	@RequestMapping("/repairWithdrawData")
	public String repairWithdrawData(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("repairWithdraw end init:");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.repairWithdrawData();
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("repairWithdraw end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/executeUpdate")
	public String executeUpdateSql(HttpServletRequest request, HttpServletResponse response, ModelMap model, String merchantNos) {
		logger.info("executeUpdateSql end init:sql{}", merchantNos);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.executeUpdateSql(merchantNos);
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("executeUpdateSql end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/executeInsert")
	public String executeInsertSql(HttpServletRequest request, HttpServletResponse response, ModelMap model, String merchantNos) {
		logger.info("executeInsertSql end init:sql:{}", merchantNos);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.executeInsertSql(merchantNos);
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("executeInsertSql end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/mposOpen217Account")
	public String mposOpen217Account(HttpServletRequest request, HttpServletResponse response, ModelMap model, String merchantNos) {
		logger.info("mposOpen217Account  init:merchantNos:{}", merchantNos);
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int successNum = 0;
		int failNum = 0;
		if (merchantNos != null && StringUtils.isNotBlank(merchantNos)) {
			for (String merchantNo : merchantNos.split(",")) {
				PosMerchantInfoDO merchantInfo = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(merchantNo,
						PosMerchantTypeEnums.MPOS_PROMOTER.code);
				if (merchantInfo != null) {
					ErrorMessageVO message = this.fastSettleApply.applyOpen4Intra(merchantNo, merchantInfo.getPosMerchantId(),
							PosMerchantTypeEnums.MPOS_PROMOTER.code, "SYSTEM");
					if (message.isSuccess()) {
						successNum++;
					} else {
						failNum++;
					}
				}
			}
		}
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 成功：" + successNum + ",失败：" + failNum;
		model.put("result", resultJson);
		logger.info("mposOpen217Account end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/repairFirstOpenDate")
	public String repairFirstOpenDate(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("repairFirstOpenDate end init:");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		long t = System.currentTimeMillis();
		int num = fwPosMerchantInfoService.repairFirstOpenDate();
		String resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 影响行数：" + num;
		model.put("result", resultJson);
		logger.info("repairFirstOpenDate end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/syncMerchantInfoAll")
	public String syncMerchantInfoAll(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws InterruptedException {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info(" syncMerchantInfoAll user:" + user.getUserName());
		String merchantNos = request.getParameter("merchantNos");
		String resultJson = syncMerchantInfoAll(merchantNos);
		model.put("result", resultJson);
		logger.info("syncMerchantInfoAll end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/syncMerchantOperator")
	public String syncMerchantOperator(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("syncMerchantOperator user:" + user.getUserName());
		String resultJson = fwPosMerchantInfoService.syncMerchantOperator();
		model.put("result", resultJson);
		logger.info("syncMerchantOperator end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/syncPromoterInfo")
	public String syncPromoterInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("syncMerchantOperator user:" + user.getUserName());
		String merchantNos = request.getParameter("merchantNos");
		String resultJson = syncPromoterMerchantInfo(merchantNos);
		model.put("result", resultJson);
		logger.info("syncMerchantOperator end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/mposOpenT0All")
	public String mposOpenT0All(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		long t = System.currentTimeMillis();
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		String merchantNos = request.getParameter("merchantNos");
		String resultJson = mposOpenT0All(merchantNos);
		resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 结果：" + resultJson;
		model.put("result", resultJson);
		logger.info("syncMerchantInfoAll end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/mposBatchUpdateFee")
	public String mposBatchUpdateFee(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		long t = System.currentTimeMillis();
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		String merchantNos = request.getParameter("merchantNos");
		String resultJson = mposBatchUpdateFee(merchantNos);
		resultJson = "use times:" + (System.currentTimeMillis() - t) / 1000 + " 结果：" + resultJson;
		model.put("result", resultJson);
		logger.info("syncMerchantInfoAll end result:" + resultJson);
		return "/repair/resultInfo";
	}

	@RequestMapping("/sc/computeSpitting")
	public String computeSpitting(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String reqId = request.getParameter("reqId");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		logger.info("computeSpitting reqId:" + reqId);
		// Assert.assertNotNull(reqId);
		SimpleOperateResponse res;
		try {
			res = scSettleBaseService.getCalculateProfitAPIService().wdCalcSplitting(Long.parseLong(reqId));
			logger.info("computeSpitting SimpleOperateResponse:" + ToStringBuilder.reflectionToString(res));
			model.put("result", ToStringBuilder.reflectionToString(res));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("computeSpitting", e);
		}

		return "/repair/resultInfo";
	}

	@RequestMapping("/sc/computeStairAward")
	public String computeStairAward(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("computeStairAward init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		try {
			scSettleBaseService.getCalculateProfitAPIService().calcYesterdayStairAward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("computeStairAward", e);
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/sc/buildSettleOrder")
	public String buildSettleOrder(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("buildSettleOrder init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		try {
			String result = scSettleBaseService.getSettleOrderService().createSettleOrder();
			model.put("result", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("buildSettleOrder", e);
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/sc/redoSettleOrder")
	public String redoSettleOrder(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("redoSettleOrder init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		try {
			SimpleOperateResponse res = scSettleBaseService.getCalculateProfitAPIService().retryCalcSplittingDate();
			model.put("result", "计算完成" + ToStringBuilder.reflectionToString(res));
		} catch (Exception e) {
			logger.error("redoSettleOrder", e);
			// TODO Auto-generated catch block
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/sc/redoCurrentSettleOrder")
	public String redoCurrentSettleOrder(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("redoSettleOrder init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		try {
			SimpleOperateResponse res = scSettleBaseService.getCalculateProfitAPIService().retryCalcSplittingDate(new Date());
			model.put("result", "计算完成" + ToStringBuilder.reflectionToString(res));
		} catch (Exception e) {
			logger.error("redoSettleOrder", e);
			// TODO Auto-generated catch block
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/syncWithdrawStatus")
	public String syncWithdrawStatus(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("syncWithdrawStatus init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("syncWithdrawStatus user:" + user.getUserName());
		long t = System.currentTimeMillis();
		try {
			List<WithdrawReqDO> list = withdrawReqService.queryStatusDisagreeInfo();
			StringBuffer result = new StringBuffer();
			if (list != null && list.size() > 0) {
				int i = 0;
				for (WithdrawReqDO reqDo : list) {
					i++;
					String message = "更新成功";
					try {
						WithdrawReqFosDetailDO detail = this.withdrawReqFosDetailService.queryLastDetailByReqId(reqDo.getReqId());
						if (detail != null
								&& (WithdrawOrderStatusEnums.FAIL.code.equals(detail.getWithdrawStatus()) || WithdrawOrderStatusEnums.SUCCESS.code
										.equals(detail.getWithdrawStatus()))) {
							reqDo.setStatus(Integer.parseInt(detail.getWithdrawStatus()));
							reqDo.setErrorCode(detail.getReturnCode());
							reqDo.setErrorMsg(detail.getReturnMsg());
							reqDo.setUpdateTime(detail.getUpdateTime());
							this.withdrawReqService.updateData(reqDo);
							withdrawReqService.initiateCallback(reqDo, detail.getRemitVoucherNo());
						} else {
							message = "无对应的详细信息更新";
						}
					} catch (Exception e) {
						message = "更新失败";
					}
					result.append("记录数：" + i + ",reqId：" + reqDo.getReqId() + ",orderNo：" + reqDo.getOrderNo() + ",结果：" + message + "\n<br/>");
				}

			}
			result.append("耗时：" + (System.currentTimeMillis() - t) / 1000);
			model.put("result", result.toString());
		} catch (Exception e) {
			logger.error("redoSettleOrder", e);
			// TODO Auto-generated catch block
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/syncOpenAccountTime")
	public String syncOpenAccountTime(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("syncOpenAccountTime init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("syncOpenAccountTime user:" + user.getUserName());
		long t = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		int num = this.fwPosMerchantInfoService.syncOpenAccountTime();
		result.append("更新记录数：" + num);
		result.append(",耗时：" + (System.currentTimeMillis() - t) / 1000);
		logger.info("syncOpenAccountTime end。" + result.toString());
		model.put("result", result.toString());
		return "/repair/resultInfo";
	}

	@RequestMapping("/autoBatchChangeMerchantLimit")
	public String autoBatchChangeMerchantLimit(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		logger.info("autoBatchChangeMerchantLimit init");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		try {
			String result = this.newT0MerchantFastSettleService.changMerchantLimit();
			model.put("result", result);
		} catch (Exception e) {
			logger.error("autoBatchChangeMerchantLimit", e);
		}
		return "/repair/resultInfo";
	}

	@RequestMapping("/posAutoOpenT0/save")
	public String posAutoOpenT0(HttpServletRequest request, HttpServletResponse response, ModelMap model, String merchantNos, String workdayFee,
			String holidayFee, BigDecimal fastSettleLimit) {
		logger.info("posAutoOpenT0 start");
		com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		logger.info("user:" + user.getUserName());
		if (StringUtils.isBlank(merchantNos) || StringUtils.isBlank(workdayFee) || StringUtils.isBlank(holidayFee) || fastSettleLimit == null) {
			model.put("result", "请求数据都是必填项，不能有空值！");
			return "/repair/resultInfo";
		}
		long t = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		if (merchantNos != null) {
			String[] merchantNoArr = merchantNos.replaceAll("，", ",").split(",");
			if (merchantNoArr != null && merchantNoArr.length > 0) {
				int i = 0;
				for (String merchantNo : merchantNoArr) {
					i++;
					String message = "更新成功";
					try {
						fwPosMerchantInfoService.posAutoOpenFastSettleAndUpdateLimit(merchantNo, PosMerchantTypeEnums.POS_MERCHANT.code, workdayFee,
								holidayFee, fastSettleLimit);
					} catch (OpenFastSettleException e) {
						logger.info("posAutoOpenFastSettleAndUpdateLimit OpenFastSettleException,merchantNo:{},message{}", new Object[] { merchantNo,
								e.getMessage() });
						message = "更新失败：" + e.getMessage();
					} catch (Exception e) {
						logger.info("posAutoOpenFastSettleAndUpdateLimit Exception,merchantNo:{},message{}",
								new Object[] { merchantNo, e.getMessage() });
						message = "更新失败";
					}
					result.append("记录数：" + i + ",商户号：" + merchantNo + ",结果：" + message + "\n<br/>");
				}
			}

		}
		result.append("耗时：" + (System.currentTimeMillis() - t) / 1000);
		model.put("result", result.toString());
		logger.info("posAutoOpenT0 end result:" + result.toString());
		return "/repair/resultInfo";
	}

	@RequestMapping("/posAutoOpenT0/index")
	public String posAutoOpenT0Index(HttpServletRequest request, HttpServletResponse response, ModelMap model, String merchantNos) {
		return "/repair/posAutoOpenT0Index";
	}

	private String mposOpenT0All(String merchantNos) {
		if (StringUtils.isBlank(merchantNos)) { return "商户号参数必填"; }
		List<PosMerchantInfoDO> list = fwPosMerchantInfoService.mposUnopenT0MerchantInfo(merchantNos);
		int num = 0;
		int success = 0;
		if (list != null) {
			for (PosMerchantInfoDO info : list) {
				num++;
				String merchantNo = info.getMerchantNo();
				int creditCTFCount = posExternalService.queryCreditAuthentication(merchantNo);
				try {
					fwPosMerchantInfoService.mposAutoOpenFastSettleAndUpdateLimit(merchantNo, info.getMerchantType(), creditCTFCount);
					success++;
				} catch (Exception e) {
					logger.info("mposOpenT0All Exception", e);
				}
			}
		}
		return "更新商户数量：" + num + " 成功数量：" + success + " 失败数量：" + (num - success);
	}

	private String mposBatchUpdateFee(String merchantNos) {
		if (StringUtils.isBlank(merchantNos)) { return "商户号参数必填"; }
		long t = System.currentTimeMillis();
		StringBuffer result = new StringBuffer();
		List<PosMerchantInfoDO> list = fwPosMerchantInfoService.mposUnopenT0MerchantInfo(merchantNos);
		int num = 0;
		if (list != null) {
			for (PosMerchantInfoDO info : list) {
				num++;
				String message = "更新成功";
				try {
					message = fwPosMerchantInfoService.mposBatchUpdateFee(info.getMerchantNo(), info.getMerchantType());
				} catch (Exception e) {
					logger.info("mposBatchUpdateFee Exception,merchantNo:{},message{}", new Object[] { info.getMerchantNo(), e.getMessage() });
					message = "更新失败";
				}
				result.append("记录数：" + num + ",商户号：" + info.getMerchantNo() + ",结果：" + message + "\n<br/>");
			}
		}
		result.append("耗时：" + (System.currentTimeMillis() - t) / 1000);
		return result.toString();
	}

	public String syncPromoterMerchantInfo(String merchantNos) {
		logger.info("syncPromoterMerchantInfo start,merchantNos:{}", merchantNos);
		String[] merchantNoArr = merchantNos.replaceAll("，", ",").split(",");
		List<String> merchantNoList = getMerchantNoList(merchantNoArr);
		if (merchantNoList == null || merchantNoList.isEmpty()) { return "商户号不能满足要求！"; }
		StringBuffer buffer = new StringBuffer();
		List<PromoterEO> list = promoterService.queryPromoterInfo(merchantNoList);
		int i = 0;
		for (PromoterEO promoter : list) {
			i++;
			PosMerchantInfoDO data = new PosMerchantInfoDO();
			data.setMerchantNo(promoter.getMcMerchantNo());
			data.setMerchantType(promoter.getMcType());
			data.setMerchantName(promoter.getMcMerchantName());
			Long parentPromoterId = getParentPromoterId(promoter);
			if (parentPromoterId != null) {
				data.setParentPromoterId(parentPromoterId);
			}
			Long promoterBizId = syncMerchantInfo(data);
			buffer.append("记录：" + i + ",id:" + promoterBizId + ",data:" + ToStringBuilder.reflectionToString(data, ToStringStyle.SIMPLE_STYLE)
					+ "<br/>\n");
		}
		logger.info("syncPromoterMerchantInfo end,message:{}", buffer.toString());
		return buffer.toString();
	}

	private List<String> getMerchantNoList(String[] merchantNoArr) {
		if (merchantNoArr != null && merchantNoArr.length > 0) {
			List<String> list = new ArrayList<String>();
			for (String str : merchantNoArr) {
				if (StringUtils.isNotBlank(str)) {
					list.add(str);
				}
			}
			return list;
		}
		return null;
	}

	private Long getParentPromoterId(PromoterEO promot) {
		if (StringUtils.isNotBlank(promot.getPmtParentMerchantNo())) {
			String pmtParentType = PosMerchantTypeEnums.MPOS_PROMOTER.code;
			if (promot.getPmtLevel() != null && promot.getPmtLevel() > 2) {
				pmtParentType = PosMerchantTypeEnums.MPOS_SECOND_LEVEL_PROMOTER.code;
			}
			PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(promot.getPmtParentMerchantNo(), pmtParentType);
			if (info != null) { return info.getId(); }
		}

		return null;
	}

	private Long syncMerchantInfo(PosMerchantInfoDO data) {
		logger.info("syncMerchantInfo PosMerchantInfoDO:" + ToStringBuilder.reflectionToString(data));
		Long bizId = data.getId();
		if (bizId == null) {
			PosMerchantInfoDO info = fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(data.getMerchantNo(), data.getMerchantType());
			if (info == null) {
				data.setCreateTime(new Date());
				data.setUpdateTime(new Date());
				bizId = fwPosMerchantInfoService.createInfo(data);
			} else {
				bizId = info.getId();
				data.setId(bizId);
				PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
				example.createCriteria().andIdEqualTo(bizId);
				data.setUpdateTime(new Date());
				fwPosMerchantInfoService.updateByExample(data, example);
			}
		}
		return bizId;
	}

	public String syncMerchantInfoAll(String merchantNos) throws InterruptedException {
		if (Constants.handleMap.size() > 0) { return "当前有任务执行！"; }
		List<PromoterEO> list = promoterService.queryPromoterAll();
		StringBuffer buffer = new StringBuffer();
		long time = System.currentTimeMillis();
		if (list != null && !list.isEmpty()) {
			buffer.append("Promoter size:" + list.size());
			logger.info("Promoter size:" + list.size());
			int mSize = 0;
			BigDecimal wT1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_WORKDAY_WITHDRAW_RATIO));
			BigDecimal hT1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_T1_HOLDAY_WITHDRAW_RATIO));
			BigDecimal wD1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_WORKDAY_WITHDRAW_RATIO));
			BigDecimal hD1 = new BigDecimal(ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.MPOS_D1_HOLDAY_WITHDRAW_RATIO));
			String configDateStr = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.T0_COST_DATE);
			Date effectiveTime = DateUtil.str2Date(configDateStr);
			for (PromoterEO promoter : list) {
				Constants.handleMap.put(promoter.getPromoterId(), new Date());
				syncMerchantHandler.execute(promoter, wT1, hT1, wD1, hD1, effectiveTime);

			}
			// buffer.append("\n merchants size:"+mSize);
		}
		boolean flag = true;
		while (flag) {
			if (Constants.handleMap.size() < 1) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				logger.info("syncMerchantInfoAll InterruptedException", e);
				throw e;
			}
		}
		buffer.append("\n 用时:" + (System.currentTimeMillis() - time) / 1000);
		logger.info("syncMerchantInfoAll end :" + buffer.toString());
		return buffer.toString();
	}
}
