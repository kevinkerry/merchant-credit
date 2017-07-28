package com.sdp.mc.service.limitrule.impl;

import java.math.BigDecimal;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.enums.CompareSymbolEnums;
import com.sdp.mc.common.enums.CompareTypeEnums;
import com.sdp.mc.common.enums.ComputeSymbolEnums;
import com.sdp.mc.common.enums.ConditionSymbolEnums;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.manager.Newt0LimitRuleInfoManager;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;
import com.sdp.mc.service.dcreport.MCMerchantTradeService;
import com.sdp.mc.service.limitrule.LimitRuleInfoService;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.api.WithdrawT0ServiceAPI;
import com.sdp.withdraw.api.ratio.MerchantWithdrawRatioAPI;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.shengpay.commons.core.utils.StringUtils;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.withdraw.impl.T0WithdrawServiceImpl;

@Service("limitRuleInfoService")
public class LimitRuleInfoServiceImpl implements LimitRuleInfoService {
	private static Logger logger = LoggerFactory.getLogger(LimitRuleInfoServiceImpl.class);
	
	@Autowired
	private Newt0LimitRuleInfoManager newt0LimitRuleInfoManager;
	@Autowired
	private MCMerchantTradeService merchantTradeService;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private MerchantInfoService merchantInfoService;
	
	@Autowired
	private Newt0PromoterManager newt0PromoterManager;
	@Autowired
	private T0WithdrawServiceImpl withdrawService;
	
	
	@Override
	public List<Newt0LimitRuleInfoDO> queryLimitRuleInfo() {
		Newt0LimitRuleInfoDOExample example = new Newt0LimitRuleInfoDOExample();
		example.setOrderByClause("ID");
		List<Newt0LimitRuleInfoDO> list2=newt0LimitRuleInfoManager.selectByExample(example);
		return list2;
	}

	@Override
	public Newt0LimitRuleInfoDO getLimitRuleInfoById(String id) {
		Newt0LimitRuleInfoDOExample example = new Newt0LimitRuleInfoDOExample();
		if(StringUtils.notBlank(id)){
			example.setId(Long.valueOf(id));
			List<Newt0LimitRuleInfoDO> list=newt0LimitRuleInfoManager.selectByExample(example);
			if(list!=null&&!list.isEmpty()){
				return list.get(0);
			}
		}
		return null;
	}
	@Override
	public Newt0LimitRuleInfoDO getLimitRuleInfoById(Long id) {
		Newt0LimitRuleInfoDOExample example = new Newt0LimitRuleInfoDOExample();
		if(id!=null){
			example.setId(id);
			List<Newt0LimitRuleInfoDO> list=newt0LimitRuleInfoManager.selectByExample(example);
			if(list!=null&&!list.isEmpty()){
				return list.get(0);
			}
		}
		return null;
	}
	/**
	 * 计算快速结算的额度
	 * @param ruleId 计算的规则ID
	 * @param merchantNo 商户号
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BigDecimal cmoputeFastSettleAmount(String ruleId,String merchantNo,String posMerchantType) throws Exception {
		BigDecimal fastSettleAmount=null;
		if(StringUtils.notBlank(ruleId)&&StringUtils.notBlank(merchantNo)&&StringUtils.notBlank(posMerchantType)){
			try {
//				MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(Long.parseLong(merchantNo),posMerchantType);
				ViewMerchantInfoDTO merchantInfoDTO=merchantInfoService.queryMerchantInfoByMerchantNo(merchantNo, posMerchantType);
				if(merchantInfoDTO!=null){
					PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(merchantInfoDTO.getPromoterId());
					if(promoterInfoDTO==null){
						throw new FastSettleLimitException("商户代理商额度信息为空");
					}
//				    StraightlyCfg straightlyCfgPromoter =mspFacade.getPromoterCredit(merchantInfoDTO.getPromoterId());
					//此方法获取的代理商额度是代理商的当日额度 不是工作日额度
//				   BigDecimal credit = withdrawService.getWithdrawT0ServiceAPI().findTotalAmount(promoterInfoDTO.getPromoterNo()+"", promoterInfoDTO.getPromoterType());
				   BigDecimal credit = merchantInfoDTO.getPromoterFsLimit();
					if(credit !=null){
						//代理商的总额度
//						BigDecimal promoterCredit = straightlyCfgPromoter.getCredit();
			//				BigDecimal promoterCredit = new BigDecimal(8000000);
			//			    merchantNo="514017";
						//日均交易额
						BigDecimal dailyAmount= this.merchantTradeService.getDayOfAmount(merchantNo);
//						BigDecimal dailyAmount= new BigDecimal(19000);
						//活跃的天数
						int activeDay=this.merchantTradeService.getActiveDaysOfLastMonth(merchantNo);
//						int activeDay=4;
						fastSettleAmount=cmoputeFastSettleAmount(Long.valueOf(ruleId),dailyAmount,activeDay,credit);
					}else{
						throw new FastSettleLimitException("商户代理商额度信息为空");
					}
				}else{
					throw new FastSettleLimitException("商户信息为空");
				}
			} catch (FastSettleLimitException e) {
				throw e;
			} catch (Exception e) {
				logger.error("计算快速结算的额度：ruleId："+ruleId+"  merchantNo:"+merchantNo+"  posMerchantType:"+posMerchantType+" 发生异常！",e);
			}
		}else{
			logger.error("计算快速结算的额度时传入数据不正确：ruleId："+ruleId+"  merchantNo:"+merchantNo+"  posMerchantType:"+posMerchantType);
		}
		return roundNumbersFastSettleAmount(fastSettleAmount);
	}
	/**
	 * 对快速结算的运算结果取整数  精确到万并向上取整 
	 * @param fastSettleAmount
	 * @return
	 */
	private static BigDecimal roundNumbersFastSettleAmount(BigDecimal fastSettleAmount) {
		if(fastSettleAmount!=null){
			if(fastSettleAmount.compareTo(new BigDecimal(10000))>=0){
			   String fastSettleAmountStr=fastSettleAmount.toString();
			   String fastSettleAmountIntStr =fastSettleAmountStr.split("\\.")[0];
			   if(fastSettleAmountIntStr.length()>4){
				   String preStr=fastSettleAmountIntStr.substring(0,fastSettleAmountIntStr.length()-4);
				   String lastStr=fastSettleAmountStr.substring(preStr.length());
				   if(Float.valueOf(lastStr)>0){
					   return new BigDecimal((Integer.parseInt(preStr)+1)+"0000");
				   }else{
					   return new BigDecimal(preStr+"0000");
				   }
			   }
			}else{
				return new BigDecimal(10000);
			}
		}
		return new BigDecimal(0);
	}

	/**
	 * 计算快速结算的额度
	 * @param ruleId 计算的规则ID
	 * @param dailyAmount 上个月交易日日均刷卡金额：
	 * @param activeDay 上个月活跃天数
	 * @param totalAmount 代理商总额度
	 * @return
	 * @throws FastSettleLimitException 
	 */
	@Override
	public BigDecimal cmoputeFastSettleAmount(Long ruleId,BigDecimal dailyAmount,int activeDay,BigDecimal totalAmount) throws FastSettleLimitException {
		BigDecimal decimal=BigDecimal.ZERO;
		Newt0LimitRuleInfoDO limitRuleDo= getLimitRuleInfoById(ruleId) ;
		if(limitRuleDo!=null){
				decimal = cmoputeFastSettleAmount(limitRuleDo.getRuleLambda(),
						dailyAmount, activeDay, totalAmount);
		}else{
			throw new FastSettleLimitException("商户没有匹配的规则");
		}
		return decimal;
	}
    /**
     * 
     * @param ruleLambda 规则表达式
     * @param dailyAmount 上个月交易日日均刷卡金额：
	 * @param activeDay 上个月活跃天数
	 * @param totalAmount 代理商总额度
     * @return
     */
	private BigDecimal cmoputeFastSettleAmount(String ruleLambda, BigDecimal dailyAmount,
			int activeDay, BigDecimal totalAmount) {
		BigDecimal decimal=BigDecimal.ZERO;
		JSONArray jsonArray=JSONArray.fromObject(ruleLambda);
		int ruleSize=jsonArray.size();
	    for (Object object : jsonArray) {
		  JSONObject jsonObj = JSONObject.fromObject(object);
		  //只有一条规则，并且没有选择条件的关系 且 快速结算额度选择了 复制值，返回固定值
		  if(ruleSize==1&&CompareTypeEnums.CompareTypeEq.getCode().equals(jsonObj.getString("compareType"))
				  &&CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(jsonObj.getString("activeJudgeSymbol"))
				  &&!StringUtils.isBlank(jsonObj.getString("fixedValue"))){
			  return new BigDecimal(jsonObj.getString("fixedValue"));
		  }
		  //是否满足规则的判断条件
		  boolean judgeResult=getJudgeResult(jsonObj,activeDay,dailyAmount);
		  if(judgeResult){
		       String computeType=jsonObj.getString("compareType");
			   if(StringUtils.notBlank(computeType)){
				   //日均的倍数
				  String dailyMultiple=jsonObj.getString("dailyMultiple");
				  //总额的百分比
				  String totalPercent=jsonObj.getString("totalPercent");
				  //固定金额
				  String fixedValue=jsonObj.getString("fixedValue");
				  if(CompareTypeEnums.CompareTypeEq.getCode().equals(computeType)){
					  decimal=new BigDecimal(fixedValue);
				  }else{
					//日均的倍数
					  String dailyComputeSymbol=jsonObj.getString("dailyComputeSymbol");
					  //总额的百分比
					  String totalComputeSymbol=jsonObj.getString("totalComputeSymbol");
					  decimal= computeFastSettleAmount(computeType,dailyMultiple,totalPercent,totalAmount,dailyAmount,dailyComputeSymbol,totalComputeSymbol);
				  }
				  if(decimal!=null){
					 return decimal;
				  }
			  }
		  }
		}
		return decimal;
	}
   
	/**
	 * 计算快速结算的额度
	 * @param computeType 计算类型  
	 * @param dailyMultiple 日均交易额的倍数
	 * @param totalPercent 总额度的百分比
	 * @param totalAmount 总额度
	 * @param totalComputeSymbol 
	 * @param dailyComputeSymbol 
	 * @return
	 */
	private BigDecimal computeFastSettleAmount(String computeType,
			String dailyMultiple, String totalPercent, BigDecimal totalAmount,BigDecimal dailyAmount, String dailyComputeSymbol, String totalComputeSymbol) {
		 BigDecimal fastSettleAmount1=computeFastSettleResult(dailyAmount,dailyMultiple,dailyComputeSymbol);
		 
		 BigDecimal fastSettleAmount2=computeFastSettleResult(totalAmount,totalPercent,totalComputeSymbol);
		 
		 if(CompareTypeEnums.CompareTypeMin.getCode().equals(computeType)){
			 if(fastSettleAmount1.compareTo(fastSettleAmount2)>=0){
				 return fastSettleAmount2;
			 }else{
				 return fastSettleAmount1;
			 }
		 }else if(CompareTypeEnums.CompareTypeMax.getCode().equals(computeType)) {
			 if(fastSettleAmount1.compareTo(fastSettleAmount2)>=0){
				 return fastSettleAmount1;
			 }else{
				 return fastSettleAmount2;
			 }
		 }
		return null;
	}
    
	private BigDecimal computeFastSettleResult(BigDecimal amount,
			String num, String computeSymbol) {
		if(ComputeSymbolEnums.CompareTypePlus.getCode().equals(computeSymbol)){
			return amount.add(new BigDecimal(num));
		}else if(ComputeSymbolEnums.CompareTypeMinus.getCode().equals(computeSymbol)){
			return amount.subtract(new BigDecimal(num));
		}else if(ComputeSymbolEnums.CompareTypeMultiply.getCode().equals(computeSymbol)){
			return amount.multiply(new BigDecimal(num));
		}else if(ComputeSymbolEnums.CompareTypeDivide.getCode().equals(computeSymbol)){
			return amount.divide(new BigDecimal(num));
		}
		return null;
	}

	/**
	 * 判断是否满足设置的规则
	 * @param jsonObj 规则表达式
	 * @param activeDay 活跃的天数
	 * @param dailyAmount 日均交易额
	 * @return
	 */
	private boolean getJudgeResult(JSONObject jsonObj, int activeDay,
			BigDecimal dailyAmount) {
		 String activeJudgeSymbol=jsonObj.getString("activeJudgeSymbol");
		 String activeDayNum=jsonObj.getString("activeDayNum");
		 boolean activeJudge=false;
		 if(StringUtils.notBlank(activeJudgeSymbol)
				  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(activeJudgeSymbol)
				  &&StringUtils.notBlank(activeDayNum)){
			  activeJudge=compareCompute(activeJudgeSymbol,new BigDecimal(activeDay),new BigDecimal(activeDayNum));
		  }
		 
		  String conditionJudgeSymbol=jsonObj.getString("conditionJudgeSymbol");
		 
		  if(ConditionSymbolEnums.ConditionSymbolOr.getCode().equals(conditionJudgeSymbol)&&activeJudge){
			  return true;
		  }
		  if(ConditionSymbolEnums.ConditionSymbolAnd.getCode().equals(conditionJudgeSymbol)&&!activeJudge){
			  return false;
		  }
		  String dailyMaxValue=jsonObj.getString("dailyMaxValue");
		  String dailyMinValue=jsonObj.getString("dailyMinValue");
		  String dailyMaxSymbol=jsonObj.getString("dailyMaxSymbol");
		  String dailyMinSymbol=jsonObj.getString("dailyMinSymbol");
		  boolean dailyJudge=false;
		  if(StringUtils.notBlank(conditionJudgeSymbol)&&!ConditionSymbolEnums.ConditionSymbolEmpty.getCode().equals(conditionJudgeSymbol)
				  &&(StringUtils.notBlank(dailyMaxValue)||StringUtils.notBlank(dailyMinValue))
				  ){
			  if(StringUtils.notBlank(dailyMaxValue)&&StringUtils.notBlank(dailyMaxSymbol)
					  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(dailyMaxSymbol)){
				  dailyJudge=compareCompute(dailyMaxSymbol,dailyAmount,new BigDecimal(dailyMaxValue));
				  if(StringUtils.notBlank(dailyMinValue)&&StringUtils.notBlank(dailyMinSymbol)
						  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(dailyMinSymbol)&&dailyJudge){
					  dailyJudge=compareCompute(dailyMinSymbol,new BigDecimal(dailyMinValue),dailyAmount);
				  }
			  }else{
				  if(StringUtils.notBlank(dailyMinValue)&&StringUtils.notBlank(dailyMinSymbol)
						  &&!CompareSymbolEnums.CompareSymbolEmpty.getCode().equals(dailyMinSymbol)){
					  dailyJudge=compareCompute(dailyMinSymbol,new BigDecimal(dailyMinValue),dailyAmount);
				  }
			  }
			  if(dailyJudge){
				  return true;
			  }
		  }else{
			  if(activeJudge){
				  return true;
			  }
		  }
		return false;
	}
   /**
    * 
    * @param compareSymbol 比较的符号
    * @param sourceDecimal 原值
    * @param compareDecimal 待比较的值
    * @return
    */
	private boolean compareCompute(String compareSymbol,
			BigDecimal sourceDecimal, BigDecimal compareDecimal) {
		if(CompareSymbolEnums.CompareSymbolGt.getCode().equals(compareSymbol)){
			//CompareSymbolGt("gt", " > ","大于"),
			if(sourceDecimal.compareTo(compareDecimal)>0){
				return true;
			}
		}else if(CompareSymbolEnums.CompareSymbolGteq.getCode().equals(compareSymbol)){
			//CompareSymbolGteq("gteq", ">=","大于等于"),
			if(sourceDecimal.compareTo(compareDecimal)>=0){
				return true;
			}
		}else if(CompareSymbolEnums.CompareSymbolLt.getCode().equals(compareSymbol)){
			//CompareSymbolLt("lt", "<","小于"),
			if(sourceDecimal.compareTo(compareDecimal)<0){
				return true;
			}
		}else if(CompareSymbolEnums.CompareSymbolLteq.getCode().equals(compareSymbol)){
			//CompareSymbolLteq("lteq", "<=","小于等于"),
			if(sourceDecimal.compareTo(compareDecimal)<=0){
				return true;
			}
		}else if(CompareSymbolEnums.CompareSymbolEq.getCode().equals(compareSymbol)){
			//CompareSymbolEq("eq", "=","等于");
			if(sourceDecimal.compareTo(compareDecimal)==0){
				return true;
			}
			
		}
		return false;
	}

	@Override
	public int updateByPrimaryKeySelective(Newt0LimitRuleInfoDO entity) {
		return newt0LimitRuleInfoManager.updateByPrimaryKeySelective(entity);
	}

	@Override
	public BigDecimal cmoputeFastSettleAmount(String merchantNo,String posMerchantType,int source) throws FastSettleLimitException {
		MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(merchantNo,posMerchantType);
		//查询代理商信息
//		Newt0PromoterDO newt0PromoterDO = this.newt0PromoterManager.getPromoterByMerchantId(merchantInfoDTO.getPromoterId());
		//垫资方  1 新t0用户  盛付通全资    0：老t0用户 代理商全资
//		int loaningType=newt0PromoterDO.getLoaningType();
		long ruleId=0l;
		if(source==LimitRuleInfoConstant.LIMIT_RULE_COMPUTE_SOURCE_PAGE){
			if(PosMerchantTypeEnums.POS_MERCHANT.code.equals(posMerchantType)){
				ruleId=LimitRuleInfoConstant.POS_OPEN_NEWT0_LIMIT_RULE_ID;
			}else if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(posMerchantType)){
				ruleId=LimitRuleInfoConstant.MPOS_OPEN_NEWT0_LIMIT_RULE_ID;
			}else if(PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(posMerchantType)){
				ruleId=LimitRuleInfoConstant.EASYPAY_OPEN_NEWT0_LIMIT_RULE_ID;
			}
		}else if(source==LimitRuleInfoConstant.LIMIT_RULE_COMPUTE_SOURCE_AOTU_UPDATE){
             if(PosMerchantTypeEnums.POS_MERCHANT.code.equals(posMerchantType)){
            	 ruleId=LimitRuleInfoConstant.POS_NEWT0_UPDATE_LIMIT_RULE_ID;
			}else if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(posMerchantType)){
				 ruleId=LimitRuleInfoConstant.POS_NEWT0_UPDATE_LIMIT_RULE_ID;
			}
		}
		try {
			return cmoputeFastSettleAmount(ruleId+"", merchantNo,posMerchantType);
		} catch (FastSettleLimitException e) {
			throw e;
		} catch (Exception e) {
			logger.error("cmoputeFastSettleAmount error data:merchantNo:"+merchantNo+" posMerchantType:"+posMerchantType+" ruleId:"+ruleId , e);
		}
		return null;
	}

}
