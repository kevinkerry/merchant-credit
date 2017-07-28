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
import com.sdp.withdraw.dao.WithdrawCostConfigDO;
import com.sdp.withdraw.entity.WithdrawCostConfigDTO;
import com.sdp.withdraw.entity.WithdrawCostConfigPO;
import com.shengpay.service.withdraw.cost.WithdrawCostConfigService;

@Controller
@RequestMapping("/withdrawCost")
public class WithdrawCostConfigAction {

	private static final Logger log = LoggerFactory.getLogger(WithdrawCostConfigAction.class);

	@Autowired
	private WithdrawCostConfigService withdrawCostConfigService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/config/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/withdrawCost/config/index";
	}

	@RequestMapping(value = "/config/list")
	public String whiteList(@ModelAttribute("query") WithdrawCostConfigDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		List<WithdrawCostConfigDO> list = this.withdrawCostConfigService.selectByQuery(query);
		if (list != null) {
			List<WithdrawCostConfigPO> listPo = new ArrayList<WithdrawCostConfigPO>();
			for (WithdrawCostConfigDO info : list) {
				WithdrawCostConfigPO po = beanMapper.map(info, WithdrawCostConfigPO.class);
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/withdrawCost/config/list";
	}

	@RequestMapping(value = "/config/initEdit")
	public String initEdit(@ModelAttribute("query") WithdrawCostConfigDTO query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		log.info("WithdrawCostConfigAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			WithdrawCostConfigDO info = this.withdrawCostConfigService.selectByPrimaryKey(query.getPo().getId());
			WithdrawCostConfigPO po = beanMapper.map(info, WithdrawCostConfigPO.class);
			model.put("config", po);
		}
		return "/withdrawCost/config/edit";
	}

	@RequestMapping(value = "/config/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(WithdrawCostConfigPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
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
				config.setMerchantType("");
			}
			boolean bValid = false;
			if (config.getId() != null) {
				int rows = this.withdrawCostConfigService.updateByPrimaryKeySelective(config);
				bValid = rows == 1;
			} else {
				config.setOperatorId(user.getUserName());
				config.setOperatorName(user.getRealName());
				config.setCreateTime(new Date());
				Long id = this.withdrawCostConfigService.insert(config);
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

	private boolean check(WithdrawCostConfigDO config) {
		WithdrawCostConfigDO info = this.withdrawCostConfigService.queryWithdrawCostConfig(config.getType(), config.getMerchantNo(),
				config.getMerchantType());
		return info == null || (config.getId() != null && config.getId().intValue() == info.getId().intValue()) ? false : true;
	}

	private boolean validate(WithdrawCostConfigDO config) {
		boolean bValid = config != null;
		bValid = bValid && config.getWdCost() != null&&BigDecimal.ZERO.compareTo(config.getWdCost())<=0;
		bValid = bValid && config.getWdPromoterSplittingScale() != null&&BigDecimal.ZERO.compareTo(config.getWdPromoterSplittingScale())<=0&&new BigDecimal(1).compareTo(config.getWdPromoterSplittingScale())>=0;
		bValid = bValid && config.getType() != null;
		if (bValid && WithdrawCostTypeEnums.DEFINITIVE.code == config.getType()) {
			bValid = bValid && StringUtils.isNotBlank(config.getMerchantNo());
			bValid = bValid && StringUtils.isNotBlank(config.getMerchantType());
		}
		return bValid;
	}
}
