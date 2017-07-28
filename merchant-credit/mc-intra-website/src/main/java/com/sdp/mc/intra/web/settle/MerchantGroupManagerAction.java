package com.sdp.mc.intra.web.settle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.enums.MccInfoCheckFlagEnums;
import com.sdp.mc.common.enums.StatusAvailableEnums;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.ResponseDTO;
import com.sdp.mc.settle.api.dto.ScGroupInfoDto;
import com.sdp.mc.settle.api.dto.ScMerchantGroupDto;
import com.sdp.mc.settle.api.dto.req.GroupingInfoQueryRequest;
import com.sdp.mc.settle.api.dto.req.MccInfoRequest;
import com.sdp.mc.settle.api.dto.req.MerchantGroupPagingQueryRequest;
import com.sdp.mc.settle.api.dto.resp.GroupingInfoPagingQueryResponse;
import com.sdp.mc.settle.api.dto.resp.MccInfoResponse;
import com.sdp.mc.settle.api.dto.resp.MerchantGroupPagingQueryResponse;
import com.sdp.mc.settle.api.dto.resp.MerchantGroupResponse;
import com.sdp.mc.settle.api.enums.MerchantGroupTypeEnums;

@Controller
@RequestMapping("/settle")
public class MerchantGroupManagerAction extends BaseAction {

	private static final Logger logger = LoggerFactory.getLogger(MerchantGroupManagerAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	/**
	 * 商户分组
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/merchant/group/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		query.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		return "/settle/merchantGroup/merchantGroupIndex";
	}

	@RequestMapping(value = "/ajaxPaging/merchantGroupList")
	public String queryPage(@ModelAttribute("query") MerchantGroupPagingQueryRequest query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			MerchantGroupPagingQueryResponse respList = scSettleBaseService.getMerchantGroupService().queryByPaging(query);
			GroupingInfoQueryRequest groupReq = new GroupingInfoQueryRequest();
			// groupReq.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
			GroupingInfoPagingQueryResponse groupResp = scSettleBaseService.getGroupService().queryGroupInfoList(groupReq);
			Map<Long, String> groupMap = new HashMap<Long, String>();
			List<ScGroupInfoDto> grouplist = groupResp.getPageList();
			if (grouplist != null && !grouplist.isEmpty()) {
				for (ScGroupInfoDto group : grouplist) {
					groupMap.put(group.getId(), group.getGroupCode()+"-"+group.getGroupName());
				}
			}
			model.put("groupMap", groupMap);
			model.put("query", query);
			model.put("page", respList);
			model.put("dataList", respList.getPageList());
		} catch (Exception e) {
			logger.error("");
		}
		return "/settle/merchantGroup/merchantGroupList";
	}

	/**
	 * 添加页面
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/merchant/add/view")
	public String merchantAddView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		query.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		MccInfoRequest requestDto = new MccInfoRequest();
		requestDto.setStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		requestDto.setCheckFlag(MccInfoCheckFlagEnums.MCC_CHECK_FLAGE_EFFECTIVE.code);
		MccInfoResponse responseDto = scSettleBaseService.getMccInfoManagerAPI().queryMccInfoList(requestDto);
		model.put("mccList", responseDto.getMccInfoList());
		model.put("effectiveTime", getEffectiveTime());
		model.put("expireTime", getExpireTime());
		return "/settle/merchantGroup/merchantGroupAdd";
	}

	/**
	 * 添加商户分组操作
	 *
	 * @param merchantGroupDto
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/merchant/add/opreate")
	@ResponseBody
	public ErrorMessageVO<T> merchantAddOpreate(ScMerchantGroupDto merchantGroupDto, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		if (StringUtils.isNotBlank(merchantGroupDto.getEffectiveTime())) {
			String effectiveTime = DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(merchantGroupDto.getEffectiveTime()));
			merchantGroupDto.setEffectiveTime(effectiveTime);
		}
		if (StringUtils.isNotBlank(merchantGroupDto.getExpireTime())) {
			String exTimeStr = DateUtil.getCurrentDayStrEndTime(DateUtil.parse2Date(merchantGroupDto.getExpireTime()));
			merchantGroupDto.setExpireTime(exTimeStr);
		}
		logger.info("merchantAddOpreate request {}", ToStringBuilder.reflectionToString(merchantGroupDto, ToStringStyle.SHORT_PREFIX_STYLE));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(merchantGroupDto, message)) { return message; }
			ResponseDTO respDto = scSettleBaseService.getMerchantGroupService().saveMerchantGroup(merchantGroupDto);
			logger.info("merchantAddOpreate respDto {}", ToStringBuilder.reflectionToString(respDto, ToStringStyle.SHORT_PREFIX_STYLE));
			if (!SettleReturnCodeEnums.SUCESS.code.equals(respDto.getRespCode())) {
				message.setErrorCode(respDto.getRespCode());
				message.setErrorMessage(respDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("添加成功!");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#merchantAddOpreate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}

		return message;
	}

	/**
	 * 校验参数
	 *
	 * @param merchantGroupDto
	 * @param message
	 * @return
	 */
	private boolean volidatePara(ScMerchantGroupDto merchantGroupDto, ErrorMessageVO<T> message) {
		if (merchantGroupDto.getGroupId() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择分组");
			return false;
		}
		if (merchantGroupDto.getGroupType() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择分组类型");
			return false;
		}
		if (MerchantGroupTypeEnums.MERCHANT_GROUP_BY_MCC.code.compareTo(merchantGroupDto.getGroupType()) == 0) {
			if (merchantGroupDto.getMccId() == null || merchantGroupDto.getMccId().isEmpty()) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("请选择分组值");
				return false;
			}
		} else {
			if (StringUtils.isBlank(merchantGroupDto.getMccValues())) {
				if (merchantGroupDto.getMccId() == null || merchantGroupDto.getMccId().isEmpty()) {
					message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
					message.setErrorMessage("请填写分组值");
					return false;
				}
			}
		}

		if (merchantGroupDto.getEffectiveTime() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请填写生效时间");
			return false;
		}
		if (merchantGroupDto.getExpireTime() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请填写失效时间");
			return false;
		}
		if (merchantGroupDto.getEffectiveTime().compareTo(merchantGroupDto.getExpireTime()) > 0) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("生效时间不能大于失效时间");
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/merchant/update/view")
	public String merchantUpdateView(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		query.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		MccInfoRequest requestDto = new MccInfoRequest();
		requestDto.setStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		requestDto.setCheckFlag(MccInfoCheckFlagEnums.MCC_CHECK_FLAGE_EFFECTIVE.code);
		MccInfoResponse responseDto = scSettleBaseService.getMccInfoManagerAPI().queryMccInfoList(requestDto);
		model.put("mccList", responseDto.getMccInfoList());

		MerchantGroupResponse groupInfo = scSettleBaseService.getMerchantGroupService().queryMerchantGroupById(id);
		model.put("merchantGroupInfo", groupInfo.getMerchantGroupDto());
		if (groupInfo.getMerchantGroupDto() != null) {
			Map<String, String> mccValuesMap = new HashMap<String, String>();
			String mccValues = groupInfo.getMerchantGroupDto().getMccValues();
			String[] mcc = mccValues.split("\\|");
			for (int i = 0; i < mcc.length; i++) {
				mccValuesMap.put(mcc[i], mcc[i]);
			}
			model.put("mccValuesMap", mccValuesMap);
		}
		return "/settle/merchantGroup/merchantGroupEdit";
	}

	/**
	 * 更新操作
	 *
	 * @param merchantGroupDto
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/merchant/update/opreate")
	@ResponseBody
	public ErrorMessageVO<T> merchantUpdateOpreate(ScMerchantGroupDto merchantGroupDto, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
//		if (StringUtils.isNotBlank(merchantGroupDto.getEffectiveTime())) {
//			String exTimeStr = merchantGroupDto.getEffectiveTime();
//			Date date = DateUtil.generateDawnTimeStamp(DateUtil.parseDateNewFormat(exTimeStr));
//			merchantGroupDto.setEffectiveTime(DateUtil.formatDate(date, DateUtil.default_pattern));
//		}
//		if (StringUtils.isNotBlank(merchantGroupDto.getExpireTime())) {
//			String exTimeStr = merchantGroupDto.getExpireTime();
//			Date date = DateUtil.generateMidnightTimeStamp(DateUtil.parseDateNewFormat(exTimeStr));
//			merchantGroupDto.setExpireTime(DateUtil.formatDate(date, DateUtil.default_pattern));
//		}
		if (StringUtils.isNotBlank(merchantGroupDto.getEffectiveTime())) {
			String effectiveTime = DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(merchantGroupDto.getEffectiveTime()));
			merchantGroupDto.setEffectiveTime(effectiveTime);
		}
		if (StringUtils.isNotBlank(merchantGroupDto.getExpireTime())) {
			String exTimeStr = DateUtil.getCurrentDayStrEndTime(DateUtil.parse2Date(merchantGroupDto.getExpireTime()));
			merchantGroupDto.setExpireTime(exTimeStr);
		}
		logger.info("merchantUpdateOpreate request {}", ToStringBuilder.reflectionToString(merchantGroupDto, ToStringStyle.SHORT_PREFIX_STYLE));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(merchantGroupDto, message)) { return message; }
			ResponseDTO responseDto = scSettleBaseService.getMerchantGroupService().updateMerchantGroupByExample(merchantGroupDto);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("更新成功!");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#merchantUpdateOpreate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 导出当前查询结果
	 *
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/merchant/export/data")
	@ResponseBody
	public ErrorMessageVO<T> exportMerchantGroupData(@ModelAttribute("query") MerchantGroupPagingQueryRequest query, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("MerchantGroupManagerAction#exportMerchantGroupData request {}", ToStringBuilder.reflectionToString(query));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			query.setOperatorId(getOperatorId());
			query.setOperatorName(getOperatorName());
			// TODO:下载无operatorId 无法下载，自测都没有通过,
			ResponseDTO responseDto = scSettleBaseService.getMerchantGroupService().merchantGroupExportByExample(query);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("导出成功,请到下载页面下载.");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#exportMerchantGroupData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}

		return message;
	}
}
