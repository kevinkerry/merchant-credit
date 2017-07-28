package com.sdp.mc.web.action.fastsettle;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.util.McBizException;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.settle.api.dto.ScUnderPromoterRuleDTO;
import com.sdp.mc.settle.api.dto.SimpleOperateResponse;
import com.sdp.mc.settle.api.dto.req.ScUnderPromoterRuleRequest;
import com.sdp.mc.settle.api.dto.resp.ScUnderPromoterRuleResponse;
import com.sdp.mc.settle.api.enums.ReturnCodeEnums;
import com.sdp.mc.settle.api.enums.WithdrawServiceTypeEnums;
import com.sdp.mc.settle.api.po.ScUnderPromoterRulePO;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Controller
@RequestMapping(value = { "/posPromoter/underPromoter"
		, "/mposPromoter/underPromoter" 
		, "/mposPartnerPromoter/underPromoter" 
		, "/posPartnerPromoter/underPromoter" 
		})
public class UnderPromoterAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(UnderPromoterAction.class);
	
	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService=null;
	
	@Autowired
	private ScSettleBaseService scSettleBaseService;

	/**
	 * 进入代理商快速结算申请页面
	 *
	 * @throws McBizException
	 * **/
	@RequestMapping(value = "/queryUnderPromoter/index")
	public String queryUnderPromoterIndex(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws McBizException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		log.info("queryUnderPromoterIndex,user"+ToStringBuilder.reflectionToString(user));
		return "/main/underPromoter/queryIndex";
	}
	/**
	 * 进入代理商快速结算申请页面
	 *
	 * @throws McBizException
	 * **/
	@RequestMapping(value = "/ajaxPaging/queryUnderPromoter/list")
	public String queryUnderPromoter(@ModelAttribute("query") PmtQueryPosMerchantPO query,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws McBizException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		query.setPromoterId(user.getPromoterId());
		PaginationBaseObject<PosMerchantInfoDO> page=fwPosMerchantInfoService.pagingUnderPromoterInfo(query);
		model.put("query", page);
		return "/main/underPromoter/underPromoterList";
	}
	@RequestMapping(value = "/config/index")
	public String configIndex(Long bizId,HttpServletRequest request, HttpServletResponse response, ModelMap model) throws McBizException {
		ScUnderPromoterRuleRequest req=new ScUnderPromoterRuleRequest();
		ScUnderPromoterRulePO paramPo=new ScUnderPromoterRulePO();
		paramPo.setBizId(bizId);
		model.put("bizId", bizId);
		req.setParamPo(paramPo);
		try {
			ScUnderPromoterRuleResponse res=scSettleBaseService.getUnderPromoterRuleInfoAPI().queryScUnderPromoterRule(req);
			if(res!=null&&res.getQueryList()!=null&&!res.getQueryList().isEmpty()){
			    for(ScUnderPromoterRuleDTO dto:res.getQueryList()){
			    	dto.setBaseSplittingScale(dto.getBaseSplittingScale().multiply(BigDecimal.valueOf(100)).setScale(3, BigDecimal.ROUND_DOWN));
			    	if(WithdrawServiceTypeEnums.D1_MPOS_Withdraw.code.equals(dto.getWithdrawType())||WithdrawServiceTypeEnums.D1_POS_Withdraw.code.equals(dto.getWithdrawType())){
			    		model.put("ruleD1", dto);
			    	}else if(WithdrawServiceTypeEnums.T1_MPOS_Withdraw.code.equals(dto.getWithdrawType())){
			    		model.put("ruleT1", dto);
			    	}else if(WithdrawServiceTypeEnums.T0_MPOS_Withdraw.code.equals(dto.getWithdrawType())||WithdrawServiceTypeEnums.T0_POS_Withdraw.code.equals(dto.getWithdrawType())){
			    		model.put("ruleT0", dto);
			    	}
			    }
			}
		} catch (Exception e) {
			log.error("configIndex Exception:",e);
		}
		return "/main/underPromoter/configEdit";
	}
	@RequestMapping(value = "/config/save")
	@ResponseBody
	public ErrorMessageVO<Object> configSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,ScUnderPromoterRulePO po) throws McBizException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		log.info("configSave po:"+ToStringBuilder.reflectionToString(po)+"\n user:"+ToStringBuilder.reflectionToString(user));
		ScUnderPromoterRuleRequest req=new ScUnderPromoterRuleRequest();
		Long bizId=po.getBizId();
        if(po.getBaseSplittingScale()==null||po.getWdSplitting()==null){
        	return new ErrorMessageVO<Object>(false,"-1", "分润配置参数必须填写");
		}
        po.setBaseSplittingScale(po.getBaseSplittingScale().divide(BigDecimal.valueOf(100)).setScale(5, BigDecimal.ROUND_DOWN));
		if(bizId==null){
			return new ErrorMessageVO<Object>(false,"-1", "无对应的业务ID");
		}
		PosMerchantInfoDO info=fwPosMerchantInfoService.selectDataById(bizId);
		if(info==null){
			return new ErrorMessageVO<Object>(false,"-1", "无对应的代理商信息");
		}
		po.setOperatorId(user.getOperatorId());
		po.setOperatorName(user.getDisplayUserName());
		po.setPromoterId(info.getPosMerchantId());
		req.setParamPo(po);
		try {
			SimpleOperateResponse res=null;
			if(po.getId()==null){
				res=scSettleBaseService.getUnderPromoterRuleInfoAPI().addScUnderPromoterRule(req);
			}else{
				res=scSettleBaseService.getUnderPromoterRuleInfoAPI().updateScUnderPromoterRule(req);
			}
			if(ReturnCodeEnums.SUCESS.code.equals(res.getRespCode())){
				return new ErrorMessageVO<Object>(true, res.getRespCode(), res.getRespMsg());
			}else{
				return new ErrorMessageVO<Object>(false, res.getRespCode(), res.getRespMsg());
			}
		} catch (Exception e) {
			log.error("configSave Exception", e);
			return new ErrorMessageVO<Object>(false, "-1", "系统繁忙，稍后重试");
		}
		
	}

	

}
