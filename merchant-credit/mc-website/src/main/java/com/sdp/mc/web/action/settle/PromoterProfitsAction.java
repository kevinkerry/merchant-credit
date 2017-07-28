package com.sdp.mc.web.action.settle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.settle.api.dto.DownloadsTaskDTO;
import com.sdp.mc.settle.api.dto.Promoter2MerchantProfitsInfoDTO;
import com.sdp.mc.settle.api.dto.Promoter2MerchantProfitsInfoDplDTO;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.web.action.BaseAction;

/**
 * 代理商(MPOS/POS)结算分润
 */
@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class PromoterProfitsAction extends BaseAction {

	private static Logger logger = LoggerFactory.getLogger(PromoterProfitsAction.class);

	@RequestMapping("/profits/toquery")
	public String promoterProfitsToQuery(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		inputSettleTypeEnums2PageSelect(request, model);
		Map<String, String> page = new HashMap<String, String>();
		page.put("queryStartTime", DateUtil.formatDate(DateUtil.getMonthMinDate(), DateUtil.dateFormat2Format));
		page.put("queryEndTime", DateUtil.formatDate(DateUtil.increaseDate(new Date(), -1), DateUtil.dateFormat2Format));
		model.put("page", page);
		return "/main/settle/promoterpfs/query";
	}

	// 查询
	@RequestMapping("/profits/query")
	public String promoterProfitsQuery(String queryStartTime, String queryEndTime, String merchantName, String merchantNo, String mcc, String settleType,
			Integer pageNum, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("promoterProfitsQuery,queryStartTime:{}, queryEndTime:{}, merchantName:{}, merchantNo:{},settleType:{}", new Object[] {
				queryStartTime, queryEndTime, merchantName, merchantNo, mcc, settleType });
		// inputSettleTypeEnums2PageSelect(request, model);
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		// TODO:queryStartTime queryEndTime 必填

		Promoter2MerchantProfitsInfoDTO profitsInfoDTO = new Promoter2MerchantProfitsInfoDTO();
		profitsInfoDTO.setQueryStartTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parseDate(queryStartTime, DateUtil.dateFormat2Format)));
		if(StringUtils.isNotBlank(queryEndTime)){
			Date endTime=DateUtil.parseDate(queryEndTime, DateUtil.dateFormat2Format);
			endTime=DateUtil.daysBetween(endTime)<=0?DateUtil.increaseDate(new Date(), -1):endTime;
			profitsInfoDTO.setQueryEndTime(DateUtil.getCurrentDayStrEndTime(endTime));
		}
		// profitsInfoDTO.setQueryStartTime(queryStartTime);
		// profitsInfoDTO.setQueryEndTime(queryEndTime);
		profitsInfoDTO.setMerchantName(merchantName);
		profitsInfoDTO.setMerchantNo(merchantNo);
		profitsInfoDTO.setMcc(mcc);
		profitsInfoDTO.setSettleType(settleType);
		profitsInfoDTO.setPageNum(pageNum);

		String promoterNo = user.getMerchantNo();
		profitsInfoDTO.setPromoterNo(promoterNo);
		String promoterPosMerchantId = user.getPromoterId().toString();
		profitsInfoDTO.setPromoterPosMerchantId(promoterPosMerchantId);
		// profitsInfoDTO startTime 查询开始时间,必填 endTime 查询结算时间,必填 merchantNo
		// 商户号,非必填 merchantName 商户名称,非必填 promoterNo 代理商商户号,代理商商户号和代理商合同ID 必填其中一个
		// promoterPosMerchantId 代理商合同ID
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(profitsInfoDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		Promoter2MerchantProfitsInfoDplDTO infoDplDTO = scSettleBaseService.getPromoterProfitsInfoAPI().promoter2MerchantProfitsQuery(profitsInfoDTO);
		logger.info("promoterProfitsQuery,{}", ToStringBuilder.reflectionToString(infoDplDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		model.put("query", infoDplDTO);
		return "/main/settle/promoterpfs/pfsList";
	}

	// 下载
	@RequestMapping("/profits/downloads/view")
	public String promoterProfitsDownloads(String queryStartTime, String queryEndTime, String merchantName, String merchantNo, String mcc, Integer pageNum,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		// TODO:queryStartTime queryEndTime 必填
		Promoter2MerchantProfitsInfoDTO profitsInfoDTO = new Promoter2MerchantProfitsInfoDTO();
		profitsInfoDTO.setQueryStartTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parseDate(queryStartTime, DateUtil.dateFormat2Format)));
		if(StringUtils.isNotBlank(queryEndTime)){
			Date endTime=DateUtil.parseDate(queryEndTime, DateUtil.dateFormat2Format);
			endTime=DateUtil.daysBetween(endTime)<=0?DateUtil.increaseDate(new Date(), -1):endTime;
			profitsInfoDTO.setQueryEndTime(DateUtil.getCurrentDayStrEndTime(endTime));
		}
		// profitsInfoDTO.setQueryStartTime(queryStartTime);
		// profitsInfoDTO.setQueryEndTime(queryEndTime);
		profitsInfoDTO.setMerchantName(merchantName);
		profitsInfoDTO.setMerchantNo(merchantNo);
		String promoterNo = user.getMerchantNo();
		profitsInfoDTO.setPromoterNo(promoterNo);
		String promoterPosMerchantId = user.getPromoterId().toString();
		profitsInfoDTO.setPromoterPosMerchantId(promoterPosMerchantId);
		profitsInfoDTO.setMcc(mcc);
		profitsInfoDTO.setPromoterType(user.getCurrentMcType());

		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(profitsInfoDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		DownloadsTaskDTO taskDTO = scSettleBaseService.getPromoterProfitsInfoAPI().promoter2MerchantProfitsDownloads(profitsInfoDTO);
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(taskDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		if (!ReturnCodeEnums.SUCESS.code.equalsIgnoreCase(taskDTO.getRespCode())) { throw new RuntimeException(taskDTO.getRespMsg()); }
		String fileKey = taskDTO.getFileKey();
		String fileName = taskDTO.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		return null;
	}

	//mpos下载
	@RequestMapping("/profits/mposDownloads/view")
	public String mposPromoterProfitsDownloads(String queryStartTime, String queryEndTime, String merchantName, String merchantNo, String mcc, Integer pageNum,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		// TODO:queryStartTime queryEndTime 必填
		Promoter2MerchantProfitsInfoDTO profitsInfoDTO = new Promoter2MerchantProfitsInfoDTO();
		profitsInfoDTO.setQueryStartTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parseDate(queryStartTime, DateUtil.dateFormat2Format)));
		if(StringUtils.isNotBlank(queryEndTime)){
			Date endTime=DateUtil.parseDate(queryEndTime, DateUtil.dateFormat2Format);
			endTime=DateUtil.daysBetween(endTime)<=0?DateUtil.increaseDate(new Date(), -1):endTime;
			profitsInfoDTO.setQueryEndTime(DateUtil.getCurrentDayStrEndTime(endTime));
		}
		// profitsInfoDTO.setQueryStartTime(queryStartTime);
		// profitsInfoDTO.setQueryEndTime(queryEndTime);
		profitsInfoDTO.setMerchantName(merchantName);
		profitsInfoDTO.setMerchantNo(merchantNo);
		String promoterNo = user.getMerchantNo();
		profitsInfoDTO.setPromoterNo(promoterNo);
		String promoterPosMerchantId = user.getPromoterId().toString();
		profitsInfoDTO.setPromoterPosMerchantId(promoterPosMerchantId);
		profitsInfoDTO.setMcc(mcc);

		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(profitsInfoDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		DownloadsTaskDTO taskDTO = scSettleBaseService.getPromoterProfitsInfoAPI().mposPromoter2MerchantProfitsDownloads(profitsInfoDTO);
		logger.info("promoterProfitsDownloads,{}", ToStringBuilder.reflectionToString(taskDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		if (!ReturnCodeEnums.SUCESS.code.equalsIgnoreCase(taskDTO.getRespCode())) { throw new RuntimeException(taskDTO.getRespMsg()); }
		String fileKey = taskDTO.getFileKey();
		String fileName = taskDTO.getFileName();
		fileDownloadsView(fileKey, fileName, response, CONTENT_TYPE);
		return null;
	}

	// 汇总
	@RequestMapping("/profits/summary")
	public String promoterProfitsSummary(String queryStartTime, String queryEndTime, String merchantName, String merchantNo,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		Promoter2MerchantProfitsInfoDTO profitsInfoDTO = new Promoter2MerchantProfitsInfoDTO();
		profitsInfoDTO.setQueryStartTime(DateUtil.dateFormat4(DateUtil.parseDate(queryStartTime, DateUtil.dateFormat2Format)));
		if(StringUtils.isNotBlank(queryEndTime)){
			Date endTime=DateUtil.parseDate(queryEndTime, DateUtil.dateFormat2Format);
			endTime=DateUtil.daysBetween(endTime)<=0?DateUtil.increaseDate(new Date(), -1):endTime;
			profitsInfoDTO.setQueryEndTime(DateUtil.getCurrentDayStrEndTime(endTime));
		}
//		profitsInfoDTO.setQueryStartTime(queryStartTime);
//		profitsInfoDTO.setQueryEndTime(queryEndTime);

		profitsInfoDTO.setMerchantName(merchantName);
		profitsInfoDTO.setMerchantNo(merchantNo);
		String promoterNo = user.getMerchantNo();
		profitsInfoDTO.setPromoterNo(promoterNo);
		profitsInfoDTO.setPromoterType(user.getCurrentMcType());
		String promoterPosMerchantId = user.getPromoterId().toString();
		profitsInfoDTO.setPromoterPosMerchantId(promoterPosMerchantId);

		logger.info("promoterProfitsSummary,{}", ToStringBuilder.reflectionToString(profitsInfoDTO, ToStringStyle.SHORT_PREFIX_STYLE));
		Promoter2MerchantProfitsInfoDplDTO infoDplDTO = scSettleBaseService.getPromoterProfitsInfoAPI().promoter2MerchantSummayQuery(profitsInfoDTO);
		logger.info("promoterProfitsSummary,{}", ToStringBuilder.reflectionToString(infoDplDTO, ToStringStyle.SHORT_PREFIX_STYLE));

//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		resultMap.put("merchantCnt", infoDplDTO.getMerchantCnt());
//		resultMap.put("settleAmount", infoDplDTO.getSettleAmount());
//		resultMap.put("totalProfits", infoDplDTO.getTotalProfits());
//		ErrorMessageVO<Map<String, String>> msg = new ErrorMessageVO<Map<String, String>>(infoDplDTO.getRespCode().equalsIgnoreCase(
//				ReturnCodeEnums.SUCESS.code) ? true : false, infoDplDTO.getRespCode(), infoDplDTO.getRespMsg(), resultMap);
		
		/*model.put("merchantCnt", StringUtil.isBlank(infoDplDTO.getMerchantCnt())?"0":infoDplDTO.getMerchantCnt());
		model.put("settleAmount", StringUtil.isBlank(infoDplDTO.getSettleAmount())?"0":infoDplDTO.getSettleAmount());
		model.put("totalProfits", StringUtil.isBlank(infoDplDTO.getTotalProfits())?"0":infoDplDTO.getTotalProfits());*/
		model.put("queryList", infoDplDTO.getProfitsInfos());
		return "/main/settle/promoterpfs/popup";
	}

}
