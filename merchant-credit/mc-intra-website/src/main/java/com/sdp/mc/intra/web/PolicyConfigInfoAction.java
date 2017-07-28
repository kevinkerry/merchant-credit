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
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.entity.PolicyConfigInfoDTO;
import com.sdp.withdraw.entity.PolicyConfigInfoPO;
import com.shengpay.service.withdraw.PolicyConfigInfoService;

@Controller
@RequestMapping("/policyconfig")
public class PolicyConfigInfoAction {

	private static final Logger log = LoggerFactory.getLogger(PolicyConfigInfoAction.class);

	@Autowired
	private PolicyConfigInfoService policyConfigInfoService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/policyconfig/index";
	}

	@RequestMapping(value = "/list")
	public String whiteList(@ModelAttribute("query") PolicyConfigInfoDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		List<PolicyConfigInfoDO> list = this.policyConfigInfoService.selectByQuery(query);
		if (list != null) {
			List<PolicyConfigInfoPO> listPo = new ArrayList<PolicyConfigInfoPO>();
			for (PolicyConfigInfoDO info : list) {
				PolicyConfigInfoPO po = beanMapper.map(info, PolicyConfigInfoPO.class);
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/policyconfig/list";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") PolicyConfigInfoDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		log.info("PolicyConfigInfoAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			PolicyConfigInfoDO info = this.policyConfigInfoService.selectByPrimaryKey(query.getPo().getId());
			PolicyConfigInfoPO po = beanMapper.map(info, PolicyConfigInfoPO.class);
			model.put("config", po);
		} else {
			PolicyConfigInfoPO po = new PolicyConfigInfoPO();
			po.setAutoFastSettleFlag(1);
			po.setFastSettleFlag(1);
			po.setWorkdayRatio(BigDecimal.ZERO);
			po.setHolidayRatio(BigDecimal.ZERO);
			po.setFastSettleLimit(new BigDecimal(100000));
			model.put("config", po);
		}
		return "/policyconfig/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(PolicyConfigInfoPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) { return new ErrorMessageVO<Object>(false, "-1", "校验不通过"); }
		if (this.check(config)) { return new ErrorMessageVO<Object>(false, "-1", "政策配置已经存在"); }
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName() + ":" + user.getRealName();
		try {
			boolean bValid = false;
			if (config.getId() != null) {
				PolicyConfigInfoDO policyConfigInfoDO = this.policyConfigInfoService.selectByPrimaryKey(config.getId());
				config.setCreateTime(policyConfigInfoDO.getCreateTime());
				config.setCreateOperator(policyConfigInfoDO.getCreateOperator());
				config.setUpdateTime(new Date());
				config.setUpdateOperator(operatorId);
				int rows = this.policyConfigInfoService.updateByPrimaryKey(config);
				bValid = rows == 1;
			} else {
				config.setCreateOperator(operatorId);
				config.setCreateTime(new Date());
				if (config.getPolicyId().indexOf(",") > 0) {
					log.info("saveEdit more policyId value:{}",config.getPolicyId());
					for (String policyId : config.getPolicyId().split(",")) {
						config.setPolicyId(policyId);
						Long id = this.policyConfigInfoService.insert(config);
						log.info("saveEdit save policyId:{},id:{}",new Object[]{policyId,id});
					}
					bValid=true;
				} else {
					Long id = this.policyConfigInfoService.insert(config);
					bValid = id != null && id > 0;
				}
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

	private boolean check(PolicyConfigInfoDO config) {
		PolicyConfigInfoDO info = this.policyConfigInfoService.queryPolicyConfigInfo(config.getPolicyType(),config.getPolicyId());
		return info == null || (config.getId() != null && config.getId().intValue() == info.getId().intValue()) ? false : true;
	}

	private boolean validate(PolicyConfigInfoDO config) {
		boolean bValid = config != null;
		bValid = bValid && config.getAutoFastSettleFlag() != null;
		bValid = bValid && config.getFastSettleFlag() != null;
		bValid = bValid && config.getDependCreditAuthFlag() != null;
		bValid = bValid && config.getPromoterModifyFlag() != null;
		// bValid = bValid && config.getQuotaType()!= null;
		// bValid = bValid && config.getWithdrawCost()!= null;
		// bValid = bValid && config.getWorkdayRatio()!= null;
		// bValid = bValid && config.getHolidayRatio()!= null;
		// bValid = bValid && config.getFastSettleLimit()!= null;
		bValid = bValid && StringUtils.isNotBlank(config.getPolicyId());
		return bValid;
	}
}
