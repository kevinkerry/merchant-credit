package com.sdp.mc.intra.web.settle;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
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

import com.sdo.common.lang.StringUtil;
import com.sdo.common.util.DateUtil;
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.enums.StatusAvailableEnums;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.settle.api.dto.ResponseDTO;
import com.sdp.mc.settle.api.dto.ScStairAwardConfigDTO;
import com.sdp.mc.settle.api.dto.req.GroupingInfoQueryRequest;
import com.sdp.mc.settle.api.dto.req.ScStairAwardConfigRequest;
import com.sdp.mc.settle.api.dto.resp.GroupingInfoPagingQueryResponse;
import com.sdp.mc.settle.api.dto.resp.ScStairAwardConfigResponse;
import com.sdp.mc.settle.api.enums.StairsRewardConditionEnums;
import com.sdp.mc.settle.api.enums.WithdrawServiceTypeEnums;
import com.sdp.mc.settle.api.po.ScStairAwardConfigPO;

/**
 * 周期总额阶梯奖惩设置
 *
 * @author wangmindong
 *
 */
@Controller
@RequestMapping("/cycle")
public class ScStairAwardConfigAction extends BaseAction {

	private static final Logger logger = LoggerFactory.getLogger(ScStairAwardConfigAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;

	/**
	 * 周期奖惩
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rewards/punishments/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		return "/settle/stairAward/rewardPunishIndex";
	}

	/**
	 * 周期奖惩分页查询
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/repunList")
	public String queryPage(@ModelAttribute("info") ScStairAwardConfigRequest paramPo, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		try {
			ScStairAwardConfigResponse responseDto = scSettleBaseService.getScStairAwardConfigService().queryScStairAwardConfigPage(paramPo);
			model.put("page", responseDto);
			model.put("dataList", responseDto.getQueryList());
		} catch (Exception e) {
			logger.error("ScStairAwardConfigAction#queryPage error {},{}", new Object[] { e.getMessage(), e });
		}
		return "/settle/stairAward/rewardPunishList";
	}

	@RequestMapping(value = "/rewards/add/view")
	public String splittingAddView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		query.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		model.put("effectiveTime", getEffectiveTime());
		model.put("expireTime", getExpireTime());
		return "/settle/stairAward/rewardPunishAdd";
	}

	@RequestMapping(value = "/rewards/add/opreate")
	@ResponseBody
	public ErrorMessageVO<T> rewardPunishAddOpreate(ScStairAwardConfigPO configPo, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		logger.info("ScStairAwardConfigAction#rewardPunishAddOpreate request {}", ToStringBuilder.reflectionToString(configPo));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(configPo, message)) { return message; }
			// 保存操作
			ScStairAwardConfigRequest addRequest = new ScStairAwardConfigRequest();
			configPo.setOperatorId(getOperatorId());
			configPo.setOperatorName(getOperatorName());
			configPo.setEffectiveTime(com.sdp.mc.common.util.DateUtil.getCurrentDayStrFristTime(com.sdp.mc.common.util.DateUtil.parse2Date(configPo.getEffectiveTime())));
			configPo.setExpireTime(com.sdp.mc.common.util.DateUtil.getCurrentDayStrEndTime(com.sdp.mc.common.util.DateUtil.parse2Date(configPo.getExpireTime())));
			addRequest.setParamPo(configPo);
			ResponseDTO respDto = scSettleBaseService.getScStairAwardConfigService().addScStairAwardConfig(addRequest);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(respDto.getRespCode())) {
				message.setErrorCode(respDto.getRespCode());
				message.setErrorMessage(respDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("添加成功!");
		} catch (Exception e) {
			logger.error("ScStairAwardConfigAction#rewardPunishAddOpreate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	private boolean volidatePara(ScStairAwardConfigPO configPo, ErrorMessageVO<T> message) {
		if (StringUtils.isBlank(configPo.getSplitProfitRoleType())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("分润角色不能为空");
			return false;
		}
		if (StringUtils.isBlank(configPo.getWithdrawType())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("结算类型不能为空");
			return false;
		}

		if (WithdrawServiceTypeEnums.T0_POS_Withdraw.code.equals(configPo.getWithdrawType())
				|| WithdrawServiceTypeEnums.T0_MPOS_Withdraw.code.equals(configPo.getWithdrawType())) {
			if (configPo.getLoaningType() == null || configPo.getLoaningType() == -9999) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("请选择垫资方");
				return false;
			}
		}
		if (configPo.getCondition() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择奖励条件");
			return false;
		}

		if (configPo.getAwardCoefficient()==null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择分润比例");
			return false;
		}

		if (StairsRewardConditionEnums.PEROID_DAY.code.equals(String.valueOf(configPo.getCondition()))) {
			if (configPo.getValueMin() == null || configPo.getValueMax() == null) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("金额范围不能为空");
				return false;
			}
		} else if (StairsRewardConditionEnums.PEROID_MONTH.code.equals(String.valueOf(configPo.getCondition()))) {
			if (configPo.getValueMin() == null || configPo.getValueMax() == null) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("激活量范围不能为空");
				return false;
			}
		}

		if (configPo.getPeriodType() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择周期");
			return false;
		}

		if (StringUtil.isBlank(configPo.getEffectiveTime())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("生效日期不能为空");
			return false;
		}

		if (StringUtil.isBlank(configPo.getExpireTime())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("失效日期不能为空");
			return false;
		}

		try {
			Date effectiveTime;
			effectiveTime = DateUtil.parseDateNoTime(configPo.getEffectiveTime(), DateUtil.webFormat);
			Date expireTime = DateUtil.parseDateNoTime(configPo.getExpireTime(), DateUtil.webFormat);
			if (effectiveTime.compareTo(expireTime) > 0) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("生效日期不能大于失效日期");
				return false;
			}
		} catch (ParseException e) {
			logger.error("prase  effectiveTime or expireTime is error", e);
			return false;
		}

		return true;
	}

	@RequestMapping(value = "/rewards/update/view")
	public String splittingUpdateView(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ScStairAwardConfigDTO configInfo = scSettleBaseService.getScStairAwardConfigService().queryOneConfigInfo(id);
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		model.put("configInfo", configInfo);
		return "/settle/stairAward/rewardPunishEdit";
	}

	@RequestMapping(value = "/rewards/update/opreate")
	@ResponseBody
	public ErrorMessageVO<T> splittingUpdateOpreate(ScStairAwardConfigPO configPo, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		logger.info("ScStairAwardConfigAction#splittingUpdateOpreate request {}", ToStringBuilder.reflectionToString(configPo));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(configPo, message)) { return message; }
			ScStairAwardConfigRequest updateReq = new ScStairAwardConfigRequest();
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			configPo.setOperatorId(user.getUserName());
			configPo.setOperatorName(user.getRealName());
			configPo.setEffectiveTime(com.sdp.mc.common.util.DateUtil.getCurrentDayStrFristTime(com.sdp.mc.common.util.DateUtil.parse2Date(configPo.getEffectiveTime())));
			configPo.setExpireTime(com.sdp.mc.common.util.DateUtil.getCurrentDayStrEndTime(com.sdp.mc.common.util.DateUtil.parse2Date(configPo.getExpireTime())));
			updateReq.setParamPo(configPo);
			ResponseDTO responseDto = scSettleBaseService.getScStairAwardConfigService().updateScStairAwardConfig(updateReq);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("更新成功!");
		} catch (Exception e) {
			logger.error("ScStairAwardConfigAction#splittingUpdateOpreate error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	@RequestMapping(value = "/rewards/export/data")
	@ResponseBody
	public ErrorMessageVO<T> exportRewardsData(@ModelAttribute("configInfo") ScStairAwardConfigPO configInfo, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("ScStairAwardConfigAction#exportRewardsData request {}", ToStringBuilder.reflectionToString(configInfo));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			ScStairAwardConfigRequest exprotReq = new ScStairAwardConfigRequest();
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			configInfo.setOperatorId(user.getUserName());
			configInfo.setOperatorName(user.getRealName());
			exprotReq.setParamPo(configInfo);
			ScStairAwardConfigResponse responseDto = scSettleBaseService.getScStairAwardConfigService().exportScStartAwardConfig(exprotReq);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("导出成功!");
		} catch (Exception e) {
			logger.error("ScStairAwardConfigAction#exportRewardsData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}

		return message;
	}
}
