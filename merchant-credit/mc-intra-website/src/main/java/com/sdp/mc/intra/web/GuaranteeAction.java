package com.sdp.mc.intra.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.msp.promoter.PromoterPO;
import com.sdp.mc.service.msp.promoter.PromoterRO;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.debit.common.service.GuaranteeService;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;

/**
 * 代理商担保资格查询
 * 代理商担保资格明细查询
 * @author liutao
 *
 */
@Controller
@RequestMapping("/promoter")
public class GuaranteeAction {
	private static final Logger logger = LoggerFactory.getLogger(GuaranteeAction.class);
	@Autowired
	private PromoterService promoterService;
	@Autowired
	private GuaranteeService guaranteeService;
	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/initPromoterGuarantee")
	public String initBorrowMoneryIndex(HttpServletRequest request, ModelMap model) {
	/*	List<DistrictRO> countryList = DistrictHelper.getCountryList();
		model.put("countryList", countryList);*/
		logger.info("GuaranteeAction.initBorrowMoneryIndex.start");
		return "/debit/guarantee/index";
	}

	/**
	 *
	 * 代理商担保资格查询
	 * @param queryParam
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/ajaxPaging/guaranteeList")
	public String promoterQuery(@ModelAttribute("params") PromoterPO params, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		PaginationBaseObject<PromoterRO> query = this.promoterService.queryPromoter(params);
		if(query!=null){
		List<PromoterRO> list=query.getDataList();
		if(list!=null&&list.size()!=0){
			//循环查询开通资格
			for (PromoterRO po : list) {
				DmAgentMerchantSettingListExample example = new DmAgentMerchantSettingListExample();
				example.createCriteria().andAgentMerchantNoEqualTo(po.getMcMerchantNo());
				DmAgentMerchantSettingListPO dmPo=guaranteeService.selectByExample(example);
				if(dmPo==null||dmPo.getStatus()==null||dmPo.getStatus().equals("0")){
					po.setAgentPower("0");
				}else{
					po.setAgentPower("1");
				}
			}
		}
		}
		model.put("query", query);
		return "/debit/guarantee/queryGuaranteeList";
	}
	/**
	 * 开通or关闭代理商担保资格
	 * @param params
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxPaging/openOrCloseAgentPower")
	@ResponseBody
	public ErrorMessageVO openOrCloseAgentPower(@ModelAttribute("params") PromoterPO params, HttpServletRequest request, HttpServletResponse response, ModelMap model){
	   if(StringUtils.isBlank(params.getPromoterNo())){
		   return new ErrorMessageVO(false, "0", "没有代理商");
		}
	   DmAgentMerchantSettingListPO po=new DmAgentMerchantSettingListPO();
	   po.setAgentMerchantNo(params.getPromoterNo());//代理商商户号
	   po.setAgentMerchantName(params.getPromoterName());//代理商商户号
	   po.setStatus(params.getDoFlag());//代理商开通or 关闭
	   ErrorMessageVO vo=guaranteeService.openOrCloseAgentPower(po);
	   if(vo!=null&&vo.isSuccess()){
		   if(params.getDoFlag().equals("1"))
		      vo.setErrorMessage("开通成功");
		   else
			  vo.setErrorMessage("关闭成功");
	   }
	   return vo;
	}

}
