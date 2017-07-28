package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.enums.WithdrawCostStatusEnums;
import com.sdp.mc.common.enums.WithdrawCostTypeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.entity.MerchantLimitRuleDTO;
import com.sdp.withdraw.entity.MerchantLimitRulePO;
import com.shengpay.service.withdraw.MerchantLimitRuleService;

@Controller
@RequestMapping("/merchant/limitrule")
public class MerchantLimitRuleManageAction {

	private static final Logger log = LoggerFactory.getLogger(MerchantLimitRuleManageAction.class);

	@Autowired
	private MerchantLimitRuleService merchantLimitRuleService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/merchant/limitrule/index";
	}

	@RequestMapping(value = "/list")
	public String queryList(@ModelAttribute("query") MerchantLimitRuleDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		List<MerchantLimitRuleDO> list = this.merchantLimitRuleService.selectByQuery(query);
		if (list != null) {
			List<MerchantLimitRulePO> listPo = new ArrayList<MerchantLimitRulePO>();
			for (MerchantLimitRuleDO info : list) {
				MerchantLimitRulePO po = beanMapper.map(info, MerchantLimitRulePO.class);
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/merchant/limitrule/list";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") MerchantLimitRuleDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		log.info("MerchantLimitRuleAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			MerchantLimitRuleDO info = this.merchantLimitRuleService.selectByPrimaryKey(query.getPo().getId());
			MerchantLimitRulePO po = beanMapper.map(info, MerchantLimitRulePO.class);
			model.put("config", po);
		}
		return "/merchant/limitrule/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(MerchantLimitRulePO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		try {
			if (!this.validate(config)) { return new ErrorMessageVO<Object>(false, "-1", "校验不通过"); }
			if (this.check(config)) { return new ErrorMessageVO<Object>(false, "-1", "商户已经存在提现费用配置"); }
			ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
			config.setUpdateTime(new Date());
			config.setOperatorId(user.getUserName());
			config.setOperatorName(user.getRealName());
			if (WithdrawCostTypeEnums.DEFAULT.code == config.getType()) {
				config.setStatus(WithdrawCostStatusEnums.EFFECTIVITY.code);
				config.setMerchantNo("");
				//config.setMerchantType("");
			}
			boolean bValid = false;
			if (config.getId() != null) {
				int rows = this.merchantLimitRuleService.updateByPrimaryKeySelective(config);
				bValid = rows == 1;
			} else {
				config.setOperatorId(user.getUserName());
				config.setOperatorName(user.getRealName());
				config.setCreateTime(new Date());
				Long id = this.merchantLimitRuleService.insert(config);
				bValid = id != null && id > 0;
			}
			if (bValid) {
				error.setSuccess(true);
				error.setErrorCode("0");
				error.setErrorMessage("保存成功");
			} else {
				error.setSuccess(false);
				error.setErrorCode("-1");
				error.setErrorMessage("保存失败");
			}
		} catch (Exception e) {
			log.error("#saveEdit Exception", e);
			error.setSuccess(false);
			error.setErrorCode("-1");
			error.setErrorMessage("保存发生异常");
		}
		return error;
	}

	private boolean check(MerchantLimitRuleDO config) {
		MerchantLimitRuleDO info = this.merchantLimitRuleService.queryMerchantLimitRule(config.getType(), config.getMerchantNo(),
				config.getMerchantType());
		return info == null || (config.getId() != null && config.getId().intValue() == info.getId().intValue()) ? false : true;
	}

	private boolean validate(MerchantLimitRuleDO config) {
		boolean bValid = config != null;
		bValid = bValid && config.getLimit()!= null&&BigDecimal.ZERO.compareTo(config.getLimit())<=0;
		bValid = bValid && config.getType() != null;
		if (bValid && WithdrawCostTypeEnums.DEFINITIVE.code == config.getType()) {
			bValid = bValid && StringUtils.isNotBlank(config.getMerchantNo());
			bValid = bValid && StringUtils.isNotBlank(config.getMerchantType());
		}
		return bValid;
	}
}
