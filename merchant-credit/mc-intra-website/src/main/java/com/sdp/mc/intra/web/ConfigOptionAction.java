package com.sdp.mc.intra.web;

import java.util.Date;
import java.util.List;

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
import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import com.sdp.mc.config.manager.ConfigOptionManager;

@Controller
@RequestMapping("/sysConfig")
public class ConfigOptionAction {

	private static final Logger log = LoggerFactory.getLogger(ConfigOptionAction.class);

	@Autowired
	private ConfigOptionManager configOptionManager;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/index";
	}

	@RequestMapping(value = "/ajaxPaging/configList")
	public String configList(@ModelAttribute("query") ConfigOptionDOExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.setOrderByClause(" CREATE_TIME DESC");
		List<ConfigOptionDO> list = this.configOptionManager.selectByQuery(query);
		model.put("dataList", list);
		model.put("query", query);
		return "/config/configList";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(Long configId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("ConfigOptionAction.initEdit.configId=" + configId);
		if (configId != null) {
			ConfigOptionDO config = this.configOptionManager.selectByPrimaryKey(configId);
			model.put("config", config);
		}
		return "/config/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(ConfigOptionDO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) {
			error.setErrorCode("-1");
			error.setErrorMessage("校验不通过");
			return error;
		}
		config.setUpdateTime(new Date());
		boolean bValid = false;
		if (config.getOptionId() != null) {
			int rows = this.configOptionManager.updateByPrimaryKeySelective(config);
			bValid = rows == 1;
		} else {
			config.setCreateTime(new Date());
			Long id = this.configOptionManager.insert(config);
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

	private boolean validate(ConfigOptionDO config) {
		boolean bValid = config != null;
		// bValid = bValid && config.getOptionId() != null;
		bValid = bValid && StringUtils.isNotBlank(config.getOptionKey());
		bValid = bValid && StringUtils.isNotBlank(config.getOptionValue());
		bValid = bValid && StringUtils.isNotBlank(config.getOptionDefValue());
		bValid = bValid && StringUtils.isNotBlank(config.getOptionDesc());
		return bValid;
	}
}
