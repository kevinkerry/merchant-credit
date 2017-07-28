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
import com.shengpay.debit.common.service.OrgCreditSettingService;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;

@Controller
@RequestMapping("/creditConfig")
public class CreditConfigAction {

	private static final Logger log = LoggerFactory.getLogger(CreditConfigAction.class);

	@Autowired
	private OrgCreditSettingService orgCreditSettingService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/credit/index";
	}

	@RequestMapping(value = "/ajaxPaging/configList")
	public String configList(@ModelAttribute("query") DbOrgCreditSettingDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		this.orgCreditSettingService.selectByQuery(query);
		model.put("query", query);
		return "/config/credit/configList";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") DbOrgCreditSettingDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("CreditConfigAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			model.put("config", this.orgCreditSettingService.selectByPrimaryKey(query.getPo().getId()));
		}
		return "/config/credit/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(DbOrgCreditSettingPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) {
			error.setErrorCode("-1");
			error.setErrorMessage("校验不通过");
			return error;
		}
		config.setUpdateTime(new Date());
		boolean bValid = false;
		if (config.getId() != null) {
			int rows = this.orgCreditSettingService.updateByPrimaryKeySelective(config);
			bValid = rows == 1;
		} else {
			config.setCreateTime(new Date());
			Long id = this.orgCreditSettingService.insert(config);
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

	private boolean validate(DbOrgCreditSettingPO config) {
		boolean bValid = config != null;
		bValid = bValid && StringUtils.isNotBlank(config.getOrgnizationCode());
		bValid = bValid && StringUtils.isNotBlank(config.getRiskLevel());
		bValid = bValid && config.getAmountLimit() != null;
		bValid = bValid && config.getDiscount() != null;
		bValid = bValid && config.getInterestRateDay() != null;
		return bValid;
	}
}
