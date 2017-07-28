package com.sdp.mc.web.action.settle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.settle.api.dto.DownloadsTaskDTO;
import com.sdp.mc.settle.api.dto.Promoter2MerchantProfitsInfoDTO;
import com.sdp.mc.settle.api.dto.Promoter2MerchantProfitsInfoDplDTO;
import com.sdp.mc.settle.api.dto.inner.PartnerPromfitData;
import com.sdp.mc.settle.api.dto.req.PartnerPromfitQueryRequest;
import com.sdp.mc.settle.api.dto.resp.PartnerPromfitQueryResponse;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.service.view.PromoterInfoService;

/**
 * 代理商(MPOS/POS)结算分润
 */
@Controller
@RequestMapping(value = { "/mposPromoter", "/mposPartnerPromoter" })
public class UnderPromoterProfitsAction extends BaseAction {

	@Autowired
	private PromoterInfoService promoterInfoService;

	private static Logger logger = LoggerFactory.getLogger(UnderPromoterProfitsAction.class);

	/**
	 *  本级分润查询（结算）
	 *
	 * @return
	 */
	@RequestMapping("/oneself/profits/toquery")
	public String oneselfPromoterProfitsToQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		logger.info("oneselfPromoterProfitsToQuery,user" + ToStringBuilder.reflectionToString(user));
		inputSettleTypeEnums2PageSelect(request, model);
		Map<String, String> page = new HashMap<String, String>();
		page.put("queryStartTime", DateUtil.formatDate(DateUtil.getMonthMinDate(), DateUtil.dateFormat2Format));
		page.put("queryEndTime", DateUtil.formatDate(new Date(), DateUtil.dateFormat2Format));
		model.put("page", page);
		return "/main/settle/oneselfpfs/query";
	}




	/**
	 * 下级分润查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/underclerk/profits/toquery")
	public String underclerkPromoterProfitsToQuery(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		inputSettleTypeEnums2PageSelect(request, model);
		Map<String, String> page = new HashMap<String, String>();
		page.put("queryStartTime", DateUtil.formatDate(DateUtil.getMonthMinDate(), DateUtil.dateFormat2Format));
		page.put("queryEndTime", DateUtil.formatDate(new Date(), DateUtil.dateFormat2Format));
		model.put("page", page);
		return "/main/settle/underclerkpfs/query";
	}
	/**
	 * 本级分润分页查询
	 * @return
	 */
	@RequestMapping("/oneself/profits/query")
	public String oneselfPromoterProfitsQuery(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc, String settleType,
			Integer pageNum, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("oneselfPromoterProfitsQuery,queryStartTime:{}, queryEndTime:{}, merchantName:{}, merchantNo:{},settleType:{},mcc:{}", new Object[] {
				queryStartTime, queryEndTime, merchantName, merchantNo, settleType,mcc });
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("oneselfPromoterProfitsQuery,promoterInfo is null");
			return "/main/settle/oneselfpfs/oneselfList";
		}
		PartnerPromfitQueryRequest requestData = getOneselfProfitsRequest(queryStartTime, queryEndTime, merchantName, merchantNo,mcc, settleType,
				pageNum, promoterInfo.getPromoterBizId());
		logger.info("oneselfPromoterProfitsQuery,{}", ToStringBuilder.reflectionToString(requestData));
		PartnerPromfitQueryResponse responseData = scSettleBaseService.getPartnerPromfitQueryAPI().oneselfPromoterProfitsToQuery(requestData);
		logger.info("oneselfPromoterProfitsQuery,{}", ToStringBuilder.reflectionToString(responseData));
		model.put("query", responseData);
		return "/main/settle/oneselfpfs/oneselfList";
	}
	/**
	 * 下级分润分页查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/underclerk/profits/query")
	public String underclerkPromoterProfitsQuery(String queryStartTime, String queryEndTime, String merchantName, String merchantNo, String mcc,
			String underPromoterName, String underPromoterNo, String settleType, Integer pageNum, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("promoterProfitsQuery,queryStartTime:{}, queryEndTime:{}, merchantName:{}, merchantNo:{},settleType:{},mcc:{}", new Object[] {
				queryStartTime, queryEndTime, merchantName, merchantNo, settleType ,mcc});
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("promoterProfitsQuery,promoterInfo is null");
			return "/main/settle/underclerkpfs/underclerkList";
		}
		PartnerPromfitQueryRequest requestData = getUnderclerkRequest(queryStartTime, queryEndTime, merchantName, merchantNo, mcc, underPromoterName,
				underPromoterNo, settleType, pageNum, promoterInfo.getPromoterBizId());
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(requestData));
		PartnerPromfitQueryResponse responseData = scSettleBaseService.getPartnerPromfitQueryAPI().underclerkPromoterProfitsToQuery(requestData);
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(responseData));
		model.put("query", responseData);
		return "/main/settle/underclerkpfs/underclerkList";
	}
	@RequestMapping("/oneself/profits/summary")
	public String oneselfPromoterProfitsSummary(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc, String settleType,
			Integer pageNum, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("oneselfPromoterProfitsQuery,queryStartTime:{}, queryEndTime:{}, merchantName:{}, merchantNo:{},settleType:{},mcc:{}", new Object[] {
				queryStartTime, queryEndTime, merchantName, merchantNo, settleType ,mcc});
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("oneselfPromoterProfitsQuery,promoterInfo is null");
			return "/main/settle/oneselfpfs/summary";
		}
		PartnerPromfitQueryRequest requestData = getOneselfProfitsRequest(queryStartTime, queryEndTime, merchantName, merchantNo,mcc, settleType,
				pageNum, promoterInfo.getPromoterBizId());
		logger.info("oneselfPromoterProfitsQuery,{}", ToStringBuilder.reflectionToString(requestData));
		PartnerPromfitQueryResponse responseData = scSettleBaseService.getPartnerPromfitQueryAPI().oneselfPromoterProfitsToCollect(requestData);
		logger.info("oneselfPromoterProfitsQuery,{}", ToStringBuilder.reflectionToString(responseData));
		model.put("query", responseData);
		return "/main/settle/oneselfpfs/summary";
	}
	/**
	 * 下级分润查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/underclerk/profits/summary")
	public String underclerkPromoterProfitsSummary(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc,
			String underPromoterName, String underPromoterNo, String settleType, Integer pageNum, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("promoterProfitsQuery,queryStartTime:{}, queryEndTime:{}, merchantName:{}, merchantNo:{},settleType:{},mcc:{}", new Object[] {
				queryStartTime, queryEndTime, merchantName, merchantNo, settleType,mcc });
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("promoterProfitsQuery,promoterInfo is null");
			return "/main/settle/underclerkpfs/summary";
		}
		PartnerPromfitQueryRequest requestData = getUnderclerkRequest(queryStartTime, queryEndTime, merchantName, merchantNo, mcc, underPromoterName,
				underPromoterNo, settleType, pageNum, promoterInfo.getPromoterBizId());
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(requestData));
		PartnerPromfitQueryResponse responseData = scSettleBaseService.getPartnerPromfitQueryAPI().underclerkPromoterProfitsToCollect(requestData);
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(responseData));
		model.put("query", responseData);
		List<PartnerPromfitData> PartnerPromfitDataList = responseData.getQueryList();
		BigDecimal withdrawAmount = new BigDecimal(0); 
		BigDecimal totalSplitting = new BigDecimal(0);
		for (PartnerPromfitData partnerPromfitData : PartnerPromfitDataList) {
			withdrawAmount = withdrawAmount.add(new BigDecimal(partnerPromfitData.getWithdrawAmount()));
			totalSplitting = totalSplitting.add(new BigDecimal(partnerPromfitData.getTotalSplitting()));
		}
		model.put("withdrawAmount", withdrawAmount);
		model.put("totalSplitting", totalSplitting);
		return "/main/settle/underclerkpfs/summary";
	}

	// 本级下载
	@RequestMapping("/oneself/profits/downloads/view")
	public String oneselfPromoterProfitsDownloads(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc,
			String settleType, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("oneselfPromoterProfitsQuery,promoterInfo is null");
			return null;
		}
		PartnerPromfitQueryRequest requestData = getOneselfProfitsRequest(queryStartTime, queryEndTime, merchantName, merchantNo,mcc, settleType, null,
				promoterInfo.getPromoterBizId());
		requestData.setPromoterNo(promoterInfo.getPromoterMerchantNo());
		requestData.setPromoterName(promoterInfo.getPromoterName());
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(requestData));
		DownloadsTaskDTO taskDTO = scSettleBaseService.getPartnerPromfitQueryAPI().oneselfPromoterProfitsToDownload(requestData);
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(taskDTO));
		if (!ReturnCodeEnums.SUCESS.code.equalsIgnoreCase(taskDTO.getRespCode())) { throw new RuntimeException(taskDTO.getRespMsg()); }
		String fileKey = taskDTO.getFileKey();
		String fileName = taskDTO.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		return null;
	}

	// 下级下载
	@RequestMapping("/underclerk/profits/downloads/view")
	public String underclerkPromoterProfitsDownloads(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc,
			String underPromoterName, String underPromoterNo, String settleType, Integer pageNum, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		ViewPromoterInfoDTO promoterInfo = promoterInfoService.queryPromoterById(user.getPromoterId());
		if (promoterInfo == null) {
			logger.info("oneselfPromoterProfitsQuery,promoterInfo is null");
			return null;
		}
		PartnerPromfitQueryRequest requestData = getUnderclerkRequest(queryStartTime, queryEndTime, merchantName, merchantNo, mcc, underPromoterName,
				underPromoterNo, settleType, pageNum, promoterInfo.getPromoterBizId());
		requestData.setPromoterNo(promoterInfo.getPromoterMerchantNo());
		requestData.setPromoterName(promoterInfo.getPromoterName());
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(requestData));
		DownloadsTaskDTO taskDTO = scSettleBaseService.getPartnerPromfitQueryAPI().underclerkPromoterProfitsToDownload(requestData);
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(taskDTO));
		if (!ReturnCodeEnums.SUCESS.code.equalsIgnoreCase(taskDTO.getRespCode())) { throw new RuntimeException(taskDTO.getRespMsg()); }
		String fileKey = taskDTO.getFileKey();
		String fileName = taskDTO.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		return null;
	}

	private PartnerPromfitQueryRequest getOneselfProfitsRequest(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,String mcc,
			String settleType, Integer pageNum, Long promoterBizId) {
		PartnerPromfitQueryRequest requestData = new PartnerPromfitQueryRequest();
		if (StringUtils.isNotBlank(queryStartTime)) requestData.setStartSettleTime(DateUtil.parseDate(queryStartTime+DateUtil.date_pattern_begin,DateUtil.dateFormat4Format));
		if (StringUtils.isNotBlank(queryEndTime)) requestData.setEndSettleTime(DateUtil.parseDate(queryEndTime+DateUtil.date_pattern_end,DateUtil.dateFormat4Format));
		if (StringUtils.isNotBlank(merchantName)) requestData.setMerchantName(merchantName);
		if (StringUtils.isNotBlank(mcc)) requestData.setMcc(mcc);
		if (StringUtils.isNotBlank(merchantNo)) requestData.setMerchantNo(merchantNo);
		if (pageNum != null) requestData.setPageNum(pageNum);
		if (StringUtils.isNotBlank(settleType)) requestData.setServiceType(settleType);
		requestData.setPromoterBizId(promoterBizId);
		return requestData;
	}

	private PartnerPromfitQueryRequest getUnderclerkRequest(String queryStartTime, String queryEndTime, String merchantName, String merchantNo, String mcc,
			String underPromoterName, String underPromoterNo, String settleType, Integer pageNum, Long promoterBizId) {
		PartnerPromfitQueryRequest requestData = getOneselfProfitsRequest(queryStartTime, queryEndTime, merchantName, merchantNo,mcc, settleType,
				pageNum, promoterBizId);
		if (StringUtils.isNotBlank(underPromoterName))requestData.setUnderPromoterName(underPromoterName);
		if (StringUtils.isNotBlank(underPromoterNo))requestData.setUnderPromoterNo(underPromoterNo);
		return requestData;
	}

}
