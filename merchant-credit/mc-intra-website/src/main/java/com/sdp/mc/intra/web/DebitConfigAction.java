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
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbNormalSettingDTO;

@Controller
@RequestMapping("/debitConfig")
public class DebitConfigAction {

	private static final Logger log = LoggerFactory.getLogger(DebitConfigAction.class);

	@Autowired
	private DebitConfigService debitConfigService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/debit/index";
	}

	@RequestMapping(value = "/ajaxPaging/configList")
	public String configList(@ModelAttribute("query") DbNormalSettingDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		this.debitConfigService.selectByQuery(query);
		model.put("query", query);
		return "/config/debit/configList";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") DbNormalSettingDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("DebitConfigAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			model.put("config", this.debitConfigService.selectByPrimaryKey(query.getPo().getId()));
		}
		return "/config/debit/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(DbNormalSettingPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) {
			error.setErrorCode("-1");
			error.setErrorMessage("校验不通过");
			return error;
		}
		config.setUpdateTime(new Date());
		boolean bValid = false;
		if (config.getId() != null) {
			int rows = this.debitConfigService.updateByPrimaryKeySelective(config);
			bValid = rows == 1;
		} else {
			config.setCreateTime(new Date());
			Long id = this.debitConfigService.insert(config);
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

	private boolean validate(DbNormalSettingPO config) {
		boolean bValid = config != null;
		bValid = bValid && StringUtils.isNotBlank(config.getSettingKey());
		bValid = bValid && StringUtils.isNotBlank(config.getSettingValue());
		bValid = bValid && StringUtils.isNotBlank(config.getSettingDesc());
		return bValid;
	}
}
