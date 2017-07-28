package com.sdp.mc.intra.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shengpay.debit.common.service.BatchConfigService;
import com.shengpay.debit.dal.ext.dataobject.DbThreadBatchDTO;

@Controller
@RequestMapping("/batchConfig")
public class BatchConfigAction {

	//private static final Logger log = LoggerFactory.getLogger(BatchConfigAction.class);

	@Autowired
	private BatchConfigService batchConfigService;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/batch/index";
	}

	@RequestMapping(value = "/ajaxPaging/configList")
	public String configList(@ModelAttribute("query") DbThreadBatchDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		this.batchConfigService.selectByQuery(query);
		model.put("query", query);
		return "/config/batch/configList";
	}
}
