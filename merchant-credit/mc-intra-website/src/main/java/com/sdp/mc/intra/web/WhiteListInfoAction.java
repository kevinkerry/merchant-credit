package com.sdp.mc.intra.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.dataobjct.WhiteListInfoDTO;
import com.sdp.mc.dataobjct.WhiteListInfoPO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.shengpay.service.whitelist.WhiteListInfoService;

@Controller
@RequestMapping("/whitelist")
public class WhiteListInfoAction {

	private static final Logger log = LoggerFactory.getLogger(WhiteListInfoAction.class);

	@Autowired
	private WhiteListInfoService whiteListInfoService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
//		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
//		System.out.println(ToStringBuilder.reflectionToString(user));
		initWhiteType(model);
		return "/whitelist/index";
	}
	@RequestMapping(value = "/minusProfitsIndex")
	public String minusIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/whitelist/minusProfitsIndex";
	}

	private void initWhiteType(ModelMap model) {
		Map<String, String> whiteType = new LinkedHashMap<String, String>();
		for (WhiteTypeEnums temp : WhiteTypeEnums.values()) {
			whiteType.put(temp.code.toString(), temp.desc);
		}
		model.put("whiteType", whiteType);
	}

	@RequestMapping(value = "/whiteList")
	public String whiteList(@ModelAttribute("query") WhiteListInfoDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		List<WhiteListInfoDO> list = this.whiteListInfoService.selectByQuery(query);
		if (list != null) {
			List<WhiteListInfoPO> listPo = new ArrayList<WhiteListInfoPO>();
			for (WhiteListInfoDO info : list) {
				WhiteListInfoPO po = beanMapper.map(info, WhiteListInfoPO.class);
				buildShowContent(po);
				if(!StringUtils.isNotBlank(po.getTypeName())&&WhiteTypeEnums.getEnumsByCode(po.getType())!=null){
					po.setTypeName(WhiteTypeEnums.getEnumsByCode(po.getType()).desc);
				}
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/whitelist/whiteList";
	}
	@RequestMapping(value = "/minusProfitsWhiteList")
	public String minusProfitsWhiteList(@ModelAttribute("query") WhiteListInfoDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		query.getPo().setType(WhiteTypeEnums.MINUS_PROFITS_PROMOTER.code);
		List<WhiteListInfoDO> list = this.whiteListInfoService.selectByQuery(query);
		if (list != null) {
			List<WhiteListInfoPO> listPo = new ArrayList<WhiteListInfoPO>();
			for (WhiteListInfoDO info : list) {
				WhiteListInfoPO po = beanMapper.map(info, WhiteListInfoPO.class);
				buildShowContent(po);
				if(!StringUtils.isNotBlank(po.getTypeName())&&WhiteTypeEnums.getEnumsByCode(po.getType())!=null){
					po.setTypeName(WhiteTypeEnums.getEnumsByCode(po.getType()).desc);
				}
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/whitelist/minusProfitsWhiteList";
	}

	private void buildShowContent(WhiteListInfoPO po) {
		StringBuffer buffer = new StringBuffer();
		if (WhiteTypeEnums.FEE.code.intValue() == po.getType()) {
			WhiteListFeeBean bean = WhiteListFeeBean.json2Bean(po.getContent());
			if (bean.getWorkdayFees() != null) {
				po.setWorkdayFees(com.shengpay.commons.core.utils.StringUtils.getString(bean.getWorkdayFees()));
				buffer.append("工作日费率：" + po.getWorkdayFees());
			}
			if (bean.getHolidayFees() != null) {
				po.setHolidayFees(com.shengpay.commons.core.utils.StringUtils.getString(bean.getHolidayFees()));
				buffer.append(";节假日费率：" + po.getHolidayFees());
			}
		}
		po.setContentLabel(buffer.toString());

	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(@ModelAttribute("query") WhiteListInfoDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		log.info("WhiteListInfoAction.initEdit.query.po.id=" + query.getPo().getId());
		if (query.getPo().getId() != null) {
			WhiteListInfoDO info = this.whiteListInfoService.selectByPrimaryKey(query.getPo().getId());
			WhiteListInfoPO po = beanMapper.map(info, WhiteListInfoPO.class);
			buildShowContent(po);
			model.put("config", po);
		}
		initWhiteType(model);
		if(WhiteTypeEnums.MINUS_PROFITS_PROMOTER.code.equals(query.getPo().getType())){
			return "/whitelist/minusProfitsEdit";
		}
		return "/whitelist/edit";
	}

	@RequestMapping(value = "/saveEdit")
	@ResponseBody
	public ErrorMessageVO saveEdit(WhiteListInfoPO config, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		if (!this.validate(config)) { return new ErrorMessageVO<Object>(false, "-1", "校验不通过"); }
		if (this.check(config)) { return new ErrorMessageVO<Object>(false, "-1", "白名单已经存在"); }
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName();
		config.setUpdateTime(new Date());
		config.setUpdateUser(operatorId);
		buildWhiteContent(config);
		try {
			boolean bValid = false;
			if (config.getId() != null) {
				int rows = this.whiteListInfoService.updateByPrimaryKeySelective(config);
				bValid = rows == 1;
			} else {
				config.setCreateUser(operatorId);
				config.setCreateTime(new Date());
				Long id = this.whiteListInfoService.insert(config);
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
			log.error("#saveEdit Exception",e);
			error.setSuccess(false);
			error.setErrorCode("-1");
			error.setErrorMessage("保存发生异常");
		}
		return error;
	}

	private void buildWhiteContent(WhiteListInfoPO config) {
		if (config.getType() != null && WhiteTypeEnums.FEE.code.intValue() == config.getType()) {
			WhiteListFeeBean bean = new WhiteListFeeBean();
			String  holidayFees=config.getHolidayFees();
			if (holidayFees != null) {
				holidayFees=holidayFees.replaceAll("，", ",").replaceAll(" ", "");
				bean.setHolidayFees(holidayFees.split(","));
			}
			String  workdayFees=config.getWorkdayFees();
			if (workdayFees != null) {
				workdayFees=workdayFees.replaceAll("，", ",").replaceAll(" ", "");
				bean.setWorkdayFees(workdayFees.split(","));
			}
			config.setContent(WhiteListFeeBean.bean2Json(bean));
			config.setTypeName(WhiteTypeEnums.FEE.desc);
		}else{
			config.setContent(config.getContent()==null?"":config.getContent().trim());
			config.setTypeName(WhiteTypeEnums.getEnumsByCode(config.getType())==null?"":WhiteTypeEnums.getEnumsByCode(config.getType()).desc);
		}

	}

	private boolean check(WhiteListInfoDO config) {
		WhiteListInfoDO info = this.whiteListInfoService.queryWhiteListInfo(config.getType(), config.getMerchantNo(), config.getMerchantType());
		return info == null || (config.getId() != null && config.getId().intValue() == info.getId().intValue()) ? false : true;
	}

	private boolean validate(WhiteListInfoDO config) {
		boolean bValid = config != null;
		bValid = bValid && config.getType() != null;
		bValid = bValid && StringUtils.isNotBlank(config.getMerchantNo());
		bValid = bValid && StringUtils.isNotBlank(config.getMerchantType());
		return bValid;
	}
}
