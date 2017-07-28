package com.sdp.mc.intra.web.settle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.sdo.common.lang.StringUtil;
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.enums.StatusAvailableEnums;
import com.sdp.mc.common.settle.SettleApiConstants;
import com.sdp.mc.common.settle.SettleReturnCodeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.ParseCsvFileUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.intra.web.util.ParseXlsFileUtil;
import com.sdp.mc.service.settleorder.ScSplittingRuleService;
import com.sdp.mc.settle.api.dto.ResponseDTO;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.mc.settle.api.dto.SplittingRuleInfoDTO;
import com.sdp.mc.settle.api.dto.req.GroupingInfoQueryRequest;
import com.sdp.mc.settle.api.dto.req.ScSplittingRuleRequest;
import com.sdp.mc.settle.api.dto.resp.GroupingInfoPagingQueryResponse;
import com.sdp.mc.settle.api.dto.resp.SplittingRuleResponse;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.settle.api.enums.WithdrawServiceTypeEnums;
import com.sdp.mc.settle.api.po.SplittingRuleInfoPO;

/**
 * 结算分润比例设置
 *
 * @author wangmindong
 */
@Controller
@RequestMapping("/splitting")
public class ScSplittingRuleAction extends BaseAction {

	private static final Logger logger = LoggerFactory.getLogger(ScSplittingRuleAction.class);

	@Autowired
	private ScSettleBaseService scSettleBaseService;
	@Autowired
	private ScSplittingRuleService scSplittingRuleService;

	@RequestMapping(value = "/rule/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		return "/settle/splitting/splittingIndex";
	}

	@RequestMapping(value = "/ajaxPaging/splittingList")
	public String queryPage(@ModelAttribute("info") ScSplittingRuleRequest paramPo, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		try {
			SplittingRuleResponse responseDto = scSettleBaseService.getSplittingRuleInfoAPI().querySplittingRuleInfoPage(paramPo);
			model.put("po", paramPo.getParamPo());
			List<SplittingRuleInfoDTO> dataList = responseDto.getQueryList();
			if (paramPo.getParamPo().getStatus() == null) {
				paramPo.getParamPo().setStatus(-1L);
				if (dataList != null && !dataList.isEmpty()) {
					Date current = new Date();
					for (SplittingRuleInfoDTO infoDto : dataList) {
						if (DateUtil.isCrossBetweenTime(current, infoDto.getExpireTime())) {
							infoDto.setStatus(StatusAvailableEnums.AVAILABLE.code);
						} else {
							infoDto.setStatus(StatusAvailableEnums.UNAVAILABLE.code);
						}
						if (infoDto.getFirstOpenTime()!=null && infoDto.getFirstOpenTime().compareTo(DateUtil.parse2Date(SettleApiConstants.firstOpenDefalutTime))==0) {
							infoDto.setFirstOpenTime(null);
						}
					}
				}
			}
			model.put("page", responseDto);
		} catch (Exception e) {
			logger.error("queryPage error {}", e.getMessage(), e);
		}
		return "/settle/splitting/splittingList";
	}

	@RequestMapping(value = "/rule/add/view")
	public String splittingAddView(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		query.setGroupStatus(Long.parseLong(StatusAvailableEnums.AVAILABLE.code));
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		model.put("effectiveTime", getEffectiveTime());
		model.put("expireTime", getExpireTime());
		return "/settle/splitting/splittingAdd";
	}

	/**
	 * 添加操作
	 *
	 * @param infoPO
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule/add/opreate")
	@ResponseBody
	public ErrorMessageVO<T> splittingAddOpreate(SplittingRuleInfoPO infoPO, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("MerchantGroupManagerAction#splittingAddOpreate request {}", ToStringBuilder.reflectionToString(infoPO));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(infoPO, message)) { return message; }
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			ScSplittingRuleRequest addRequest = new ScSplittingRuleRequest();
			infoPO.setOperatorId(user.getUserName());
			infoPO.setOperatorName(user.getRealName());
			infoPO.setEffectiveTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(infoPO.getEffectiveTime())));
			infoPO.setExpireTime(DateUtil.getCurrentDayStrEndTime(DateUtil.parse2Date(infoPO.getExpireTime())));
			if (StringUtil.isNotBlank(infoPO.getFirstOpenTime())) {
				infoPO.setFirstOpenTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(infoPO.getFirstOpenTime())));
			} else {
				infoPO.setFirstOpenTime(SettleApiConstants.firstOpenDefalutTime);
			}
			addRequest.setParamPo(infoPO);
			ResponseDTO respDto = scSettleBaseService.getSplittingRuleInfoAPI().addSplittingRule(addRequest);
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

	private boolean volidatePara(SplittingRuleInfoPO ruleInfo, ErrorMessageVO<T> message) {
		if (StringUtils.isBlank(ruleInfo.getSplitProfitRoleType())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("分润角色不能为空");
			return false;
		}
		if (StringUtils.isBlank(ruleInfo.getWithdrawType())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("结算类型不能为空");
			return false;
		}

		if (ruleInfo.getLoaningDayFlag() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请选择是否按照垫资天数");
			return false;
		}
		if (WithdrawServiceTypeEnums.T0_POS_Withdraw.code.equals(ruleInfo.getWithdrawType())
				|| WithdrawServiceTypeEnums.T0_MPOS_Withdraw.code.equals(ruleInfo.getWithdrawType())) {
			if (ruleInfo.getLoaningType() == null) {
				message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
				message.setErrorMessage("请选择垫资方");
				return false;
			}
		}

		if (ruleInfo.getCostingRate() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请填写成本费率");
			return false;
		}
		if (ruleInfo.getWdSplittingScale() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请填写分润比例");
			return false;
		}
		if (ruleInfo.getWdSplittingScale() == null) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("请填写提现手续费分润比例");
			return false;
		}
		if (StringUtils.isBlank(ruleInfo.getEffectiveTime())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("生效时间不能为空");
			return false;
		}
		if (StringUtils.isBlank(ruleInfo.getExpireTime())) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("失效时间不能为空");
			return false;
		}

		if (ruleInfo.getEffectiveTime().compareTo(ruleInfo.getExpireTime()) > 0) {
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage("生效时间不能大于失效时间");
			return false;
		}
		return true;
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
	@RequestMapping(value = "/rule/update/view")
	public String splittingUpdateView(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		SplittingRuleInfoDTO ruleInfo = scSettleBaseService.getSplittingRuleInfoAPI().queryOneRule(id);
		if (ruleInfo.getFirstOpenTime()!=null && ruleInfo.getFirstOpenTime().compareTo(DateUtil.parseDateNewFormat(SettleApiConstants.firstOpenDefalutTime))==0) {
			ruleInfo.setFirstOpenTime(null);
		}
		GroupingInfoQueryRequest query = new GroupingInfoQueryRequest();
		GroupingInfoPagingQueryResponse groupList = scSettleBaseService.getGroupService().queryGroupInfoList(query);
		model.put("groupList", groupList.getPageList());
		model.put("ruleInfo", ruleInfo);
		return "/settle/splitting/splittingEdit";
	}

	/**
	 * 修改操作
	 *
	 * @param ruleInfo
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule/update/opreate")
	@ResponseBody
	public ErrorMessageVO<T> splittingUpdateOpreate(SplittingRuleInfoPO ruleInfo, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		logger.info("MerchantGroupManagerAction#splittingUpdateOpreate request {}", ToStringBuilder.reflectionToString(ruleInfo));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			if (!volidatePara(ruleInfo, message)) { return message; }
			ScSplittingRuleRequest updateReq = new ScSplittingRuleRequest();
			// 保存操作
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			ruleInfo.setOperatorId(user.getUserName());
			ruleInfo.setOperatorName(user.getRealName());
			ruleInfo.setEffectiveTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(ruleInfo.getEffectiveTime())));
			ruleInfo.setExpireTime(DateUtil.getCurrentDayStrEndTime(DateUtil.parse2Date(ruleInfo.getExpireTime())));
			if (StringUtil.isNotBlank(ruleInfo.getFirstOpenTime())) {
				ruleInfo.setFirstOpenTime(DateUtil.getCurrentDayStrFristTime(DateUtil.parse2Date(ruleInfo.getFirstOpenTime())));
			} else {
				ruleInfo.setFirstOpenTime(SettleApiConstants.firstOpenDefalutTime);
			}
			updateReq.setParamPo(ruleInfo);
			ResponseDTO responseDto = scSettleBaseService.getSplittingRuleInfoAPI().updateSplittingRule(updateReq);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("更新成功!");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#merchantUpdateOpreate error {}",  e.getMessage(), e );
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}
		return message;
	}

	/**
	 * 导出
	 *
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule/export/data")
	@ResponseBody
	public ErrorMessageVO<T> exportSplittingData(@ModelAttribute("info") ScSplittingRuleRequest paramPo, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		logger.info("exportMerchantGroupData request {}", ToStringBuilder.reflectionToString(paramPo, ToStringStyle.SHORT_PREFIX_STYLE));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		try {
			paramPo.setOperatorId(getOperatorId());
			paramPo.setOperatorName(getOperatorName());

			SplittingRuleResponse responseDto = scSettleBaseService.getSplittingRuleInfoAPI().exportSplitingRule(paramPo);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("导出成功!");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#exportMerchantGroupData error {}", e.getMessage(), e);
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}

		return message;
	}

	/**
	 * 批量失效
	 *
	 * @param splittingRuleIds
	 *            结算分润ID
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule/batchCancel/data")
	@ResponseBody
	public ErrorMessageVO<T> batchCancelSplittingGroupData(Long[] splittingRuleIds, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		logger.info("MerchantGroupManagerAction#batchCancelSplittingGroupData request {}", ToStringBuilder.reflectionToString(splittingRuleIds));
		ErrorMessageVO<T> message = new ErrorMessageVO<T>(false);
		if (splittingRuleIds == null || splittingRuleIds.length <= 0) {
			message.setErrorCode(ReturnCodeEnums.PARAM_IS_NULL.code);
			message.setErrorMessage(ReturnCodeEnums.PARAM_IS_NULL.msg);
			return message;
		}
		try {
			List<Long> splittingRuleIdList = Arrays.asList(splittingRuleIds);
			SimpleOperateResponse responseDto = scSettleBaseService.getSplittingRuleInfoAPI().batchFailedRule(splittingRuleIdList);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(responseDto.getRespCode())) {
				message.setErrorCode(responseDto.getRespCode());
				message.setErrorMessage(responseDto.getRespMsg());
				return message;
			}
			message.setSuccess(true);
			message.setErrorCode(SettleReturnCodeEnums.SUCESS.code);
			message.setErrorMessage("批量取消成功!");
		} catch (Exception e) {
			logger.error("MerchantGroupManagerAction#exportMerchantGroupData error {},{}", new Object[] { e.getMessage(), e });
			message.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
			message.setErrorMessage(SettleReturnCodeEnums.SYSTEM_PROCESS.msg);
		}

		return message;
	}

	/**
	 * 下载模板
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/rule/download")
	public void download(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		File file = new File(request.getSession().getServletContext().getRealPath("/") + "/template/settleShareScaleSetTemplate.xls"); // 根据文件路径获得File文件
		response.setContentType("application/msexcel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("settleShareScaleSetTemplate.xls", "UTF-8"));
		response.setContentLength((int) file.length());
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new FileInputStream(file));
			int n;
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
			}
			output.flush(); // 不可少
			response.flushBuffer();// 不可少
		} catch (Exception e) {
			logger.error("NewT0IntraAction.download error", e);
		} finally {
			// 关闭流，不可少
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
		}
	}

	/**
	 * 批量新增
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "/rule/batchAdd")
	public String uploadBatchAddOprate(@RequestParam(value = "file", required = false) MultipartFile mfile,
			@RequestParam(required = true) String splittingStatus, DefaultMultipartHttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws IOException {
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
		error.setErrorCode(ReturnCodeEnums.SYSTEM_EXCEPTION.code);
		try {
			if (mfile == null) {
				error.setErrorMessage("上传文件不能为空!");
				model.put("msg", error);
				return "/settle/splitting/uploadResult";
			}
			String type = mfile.getOriginalFilename().substring(mfile.getOriginalFilename().lastIndexOf(".") + 1);
			if (StringUtils.isBlank(type)) {
				error.setErrorMessage("请选择文件!");
				model.put("msg", error);
				return "/settle/splitting/uploadResult";
			}

			if (!("csv".equals(type.toLowerCase()) || "xls".equals(type.toLowerCase()))) {
				error.setErrorMessage("您上传文件格式不正确!请上传csv或者xls文件");
				model.put("msg", error);
				return "/settle/splitting/uploadResult";
			}
			// 解析文件
			logger.info("ScSplittingRuleAction.uploadBatchAddOprate.readerFileData.start.fileName=" + mfile.getOriginalFilename());
			File tmpFile = File.createTempFile(mfile.getOriginalFilename(), ".tmp");
			FileUtils.copyInputStreamToFile(mfile.getInputStream(), tmpFile);

			List<String[]> ruleInfoList = null;
			if ("csv".equals(type.toLowerCase())) {
				ruleInfoList = ParseCsvFileUtil.readCsvFile(tmpFile, "GBK");
			} else if ("xls".equals(type.toLowerCase())) {
				ruleInfoList = ParseXlsFileUtil.readXlsFile(tmpFile, "GBK");
			}
			error = scSplittingRuleService.buildBatchAddSplittingRule(ruleInfoList);
			if (!SettleReturnCodeEnums.SUCESS.code.equals(error.getErrorCode())) {
				model.put("msg", error);
				return "/settle/splitting/uploadResult";
			}
			@SuppressWarnings("unchecked")
			List<SplittingRuleInfoPO> ruleList = (List<SplittingRuleInfoPO>) error.getParams().get("batchRule");
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			for (SplittingRuleInfoPO ruleInfo : ruleList) {
				ScSplittingRuleRequest addReq = new ScSplittingRuleRequest();
				ruleInfo.setOperatorId(user.getUserName());
				ruleInfo.setOperatorName(user.getRealName());
				addReq.setParamPo(ruleInfo);
				if ("0".equals(splittingStatus)) {
					scSettleBaseService.getSplittingRuleInfoAPI().addSplittingRule(addReq);
				} else if ("1".equals(splittingStatus)) {
					scSettleBaseService.getSplittingRuleInfoAPI().updateSplittingRule(addReq);
				}
			}
			error.setErrorCode(ReturnCodeEnums.SUCESS.code);
			if ("0".equals(splittingStatus)) {
				error.setErrorMessage("批量新增成功");
			} else if ("1".equals(splittingStatus)) {
				error.setErrorMessage("批量失效成功");
			}
		} catch (Exception e) {
			logger.error("ScSplittingRuleAction.uploadBatchAddOprate error {},{}", new Object[] { e.getMessage(), e });
			error.setErrorMessage("上传文件发生异常！");
			error.setErrorCode(SettleReturnCodeEnums.SYSTEM_PROCESS.code);
		}
		model.put("msg", error);
		return "/settle/splitting/uploadResult";
	}
}
