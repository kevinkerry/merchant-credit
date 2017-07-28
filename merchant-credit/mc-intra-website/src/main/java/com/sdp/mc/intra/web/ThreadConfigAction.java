package com.sdp.mc.intra.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.common.service.ThreadConfigService;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.dal.ext.dataobject.DbThreadConfigDTO;

@Controller
@RequestMapping("/threadConfig")
public class ThreadConfigAction {

	private static final Logger log = LoggerFactory.getLogger(ThreadConfigAction.class);

	@Autowired
	private ThreadConfigService threadConfigService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/thread/index";
	}

	@RequestMapping(value = "/ajaxPaging/configList")
	public String configList(@ModelAttribute("query") DbThreadConfigDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		this.threadConfigService.selectByQuery(query);
		model.put("query", query);
		return "/config/thread/configList";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") DbThreadConfigDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("CreditConfigAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			model.put("config", this.threadConfigService.selectByPrimaryKey(query.getPo().getId()));
		}
		return "/config/thread/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(DbThreadConfigPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) {
			error.setErrorCode("-1");
			error.setErrorMessage("校验不通过");
			return error;
		}
		config.setUpdateTime(new Date());
		boolean bValid = false;
		if (config.getId() != null) {
			int rows = this.threadConfigService.updateByPrimaryKeySelective(config);
			bValid = rows == 1;
		} else {
			config.setCreateTime(new Date());
			Long id = this.threadConfigService.insert(config);
			bValid = id != null && id > 0;
		}
		if (bValid) {
			error.setSuccess(true);
			error.setErrorCode("0");
			error.setErrorMessage("保存成功");
		} else {
			error.setSuccess(true);
			error.setErrorCode("-1");
			error.setErrorMessage("保存失败");
		}
		return error;
	}

	private boolean validate(DbThreadConfigPO config) {
		boolean bValid = config != null;
		bValid = bValid && StringUtils.isNotBlank(config.getBatchCode());
		bValid = bValid && StringUtils.isNotBlank(config.getExecuteExpression());
		bValid = bValid && StringUtils.isNotBlank(config.getOrgnizationCode());
		bValid = bValid && config.getRetryCount() != null;
		bValid = bValid && config.getRetryInterval() != null;
		bValid = bValid && config.getStatus() != null;
		return bValid;
	}
}
