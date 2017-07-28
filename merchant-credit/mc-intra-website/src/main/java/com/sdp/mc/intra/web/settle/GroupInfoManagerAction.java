package com.sdp.mc.intra.web.settle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.ResponseDTO;
import com.sdp.mc.settle.api.dto.ScGroupInfoDto;
import com.sdp.mc.settle.api.dto.req.GroupingInfoModifyRequest;
import com.sdp.mc.settle.api.dto.req.GroupingInfoQueryRequest;
import com.sdp.mc.settle.api.dto.req.GroupingInfoSaveRequest;
import com.sdp.mc.settle.api.dto.resp.GroupingInfoPagingQueryResponse;
import com.sdp.mc.settle.api.dto.resp.GroupingInfoQueryResponse;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;

@Controller
@RequestMapping("/settle")
public class GroupInfoManagerAction {

	private static final Logger logger = LoggerFactory.getLogger(GroupInfoManagerAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	@RequestMapping(value = "/group/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		return "/settle/group/groupIndex";
	}

	/**
	 * 分页查询
	 * 
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/groupList")
	public String queryPage(@ModelAttribute("query") GroupingInfoQueryRequest query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			GroupingInfoPagingQueryResponse respList = scSettleBaseService.getGroupService().queryByPaging(query);
			model.put("query", query);
			model.put("page", respList);
			model.put("dataList", respList.getPageList());
		} catch (Exception e) {
			logger.error("queryPage error:", e);
		}
		return "/settle/group/groupList";
	}

	@RequestMapping(value = "/group/init/addView")
	public String addView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/settle/group/groupAdd";
	}

	/**
	 * 添加操作
	 * 
	 * @param info
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "/group/init/addOpreate")
	@ResponseBody
	public ErrorMessageVO<T> addOpreate(GroupingInfoSaveRequest info, HttpServletResponse response, ModelMap model) {
		logger.info("addOpreate request {}", ToStringBuilder.reflectionToString(info, ToStringStyle.SHORT_PREFIX_STYLE));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(info.getScGroupInfoDto(), message)) { return message; }
			ResponseDTO respDto = scSettleBaseService.getGroupService().saveGroupInfo(info);
			logger.info("addOpreate,{}", ToStringBuilder.reflectionToString(respDto, ToStringStyle.SHORT_PREFIX_STYLE));
			if (!SettleReturnCodeEnums.SUCESS.code.equals(respDto.getRespCode())) {
				message.setErrorCode(respDto.getRespCode());
				message.setErrorMessage(respDto.getRespMsg());
			} else {
				message.setSuccess(true);
				message.setErrorMessage("添加成功");
			}
		} catch (Exception e) {
			logger.error("GroupInfoManagerAction#addOpreate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 修改页面
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/group/init/update")
	public String updateView(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryResponse responseInfo = scSettleBaseService.getGroupService().queryInfoById(id);
		model.put("responseInfo", responseInfo.getInfoDto());
		return "/settle/group/groupEdit";
	}

	/**
	 * 校验该商户分组下是否存在有效的 正在使用的分润规则
	 * 
	 * @param merchantGroupDto
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/group/exsistSplittingRule")
	@ResponseBody
	public ErrorMessageVO<T> validateGroupIsExsistSplittingRule(GroupingInfoModifyRequest info, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("GroupInfoManagerAction#validateGroupIsExsistSplittingRule request {}", ToStringBuilder.reflectionToString(info));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(info.getScGroupInfoDto(), message)) { return message; }
			if (scSettleBaseService.getGroupService().validateGroupIsExsistSplittingRule(info.getScGroupInfoDto().getId())) {
				message.setErrorCode(ReturnCodeEnums.GROUP_RULE_UNAVAILABLE_EXIST.code);
				message.setErrorMessage(ReturnCodeEnums.GROUP_RULE_UNAVAILABLE_EXIST.msg);
				return message;
			}
			message.setSuccess(true);
		} catch (Exception e) {
			logger.error("GroupInfoManagerAction#validateGroupIsExsistSplittingRule error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	@RequestMapping(value = "/group/update/opreate")
	@ResponseBody
	public ErrorMessageVO<T> updateOprate(GroupingInfoModifyRequest info, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("GroupInfoManagerAction#updateOprate request {}", ToStringBuilder.reflectionToString(info));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(info.getScGroupInfoDto(), message)) { return message; }
			int rows = scSettleBaseService.getGroupService().updateGroupInfo(info);
			if (rows < 0) {
				message.setErrorCode(SettleReturnCodeEnums.FAILL.code);
				message.setErrorMessage("更新失败!");
			} else {
				message.setSuccess(true);
				message.setErrorMessage("更新成功!");
			}
		} catch (Exception e) {
			logger.error("GroupInfoManagerAction#updateOprate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	private boolean volidatePara(ScGroupInfoDto info, ErrorMessageVO<T> message) {
		boolean isValidate = true;
		if (StringUtil.isBlank(info.getGroupCode())) {
			message.setErrorCode(SettleReturnCodeEnums.PARAM_IS_NULL.code);
			message.setErrorMessage("分组号不能为空");
			isValidate = false;
			return isValidate;
		}
		if (StringUtil.isBlank(info.getGroupName())) {
			isValidate = false;
			message.setErrorCode(SettleReturnCodeEnums.PARAM_IS_NULL.code);
			message.setErrorMessage("分组名称不能为空");
			return isValidate;
		}
		if (null == info.getStatus()) {
			message.setErrorCode(SettleReturnCodeEnums.PARAM_IS_NULL.code);
			message.setErrorMessage("分组状态不能为空");
			isValidate = false;
			return isValidate;
		}
		return isValidate;
	}
}
