package com.sdp.mc.service.fastsettle.adjustLimit.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.bean.newt0.AdjustLimitBean;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.McBizException;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criteria;
import com.sdp.mc.newt0.manager.NewT0AuditInfoManager;
import com.sdp.mc.service.AuditInfoService;
import com.sdp.mc.service.fastsettle.adjustLimit.AdjustLimitService;
import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
@Service
public class AdjustLimitServiceImpl implements AdjustLimitService{
	@Autowired
	protected Mapper beanMapper;
	@Autowired
	private OpService opService;
	@Autowired
	private AuditInfoService auditInfoService;
	@Autowired
	private NewT0AuditInfoManager newT0AuditInfoManager;
	@Autowired
	private ConfigOptionManager configOptionManager;
	@Override
	public List<AdjustLimitBean> pageQueryAdjustTrans(NewT0AuditInfoDOExample example) {
		Criteria criteria=example.createCriteria();
		criteria.andOpTypeEqualTo(OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
		criteria.andCreateTimeLessThan(new Date());
//		criteria.andExpireTimeGreaterThan(new Date());
		example.setOrderByClause("create_time desc ");
		List<NewT0AuditInfoDO> list=newT0AuditInfoManager.selectByQuery(example);
		List<AdjustLimitBean> dataInfo=new ArrayList<AdjustLimitBean>();
		for (NewT0AuditInfoDO newT0AuditInfoDO : list) {
			AdjustLimitBean adjustBean=beanMapper.map(newT0AuditInfoDO, AdjustLimitBean.class);
			JSONObject jsonObj= JSONObject.fromObject(newT0AuditInfoDO.getRequestLog());
			AuditInfoRequestAdustLog reqLog=(AuditInfoRequestAdustLog) JSONObject.toBean(jsonObj,AuditInfoRequestAdustLog.class);
			adjustBean.setReqBean(reqLog);
			if(AuditInfoStateEnum.WAIT_AUDIT.getStatus()==newT0AuditInfoDO.getStatus()&&newT0AuditInfoDO.getExpireTime().compareTo(new Date())==-1){
				//已过期
				adjustBean.setStatus(AuditInfoStateEnum.OVERDUE.getStatus());
			}
			dataInfo.add(adjustBean);
		}
		return dataInfo;
	}

	@Override
	public void addAuditInfo(AdjustLimitBean adjust,String operatorId) {
		OpContext context = new OpContext();
		context.setAppId(MerchantCreditConstant.MC_WEBSITE_ZF_NO);
		context.setOpType(OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
		context.setPromoterId(adjust.getObjId());
		context.setPromoterNo(adjust.getObjNo());
		context.setLoaningType(adjust.getLoaningType());// 垫资方

		//设置reqlog所需要的参数
		context.setApplyLimit(adjust.getReqBean().getApplyLimit());
		// 申请原因
		context.setApplyCause(adjust.getReqBean().getApplyCause());
		// 附件材料地址
		context.setAttachment(adjust.getReqBean().getAttachment());
		context.setFileName(adjust.getReqBean().getFileName());
		context.setContentType(adjust.getReqBean().getContentType());
		context.setMcType(adjust.getMcType());
		opService.handler(context, AuditInfoStateEnum.WAIT_AUDIT.getStatus(),operatorId);
	}

	@Override
	public boolean isNeedApproval(String merchantNo,Long promoterId,Integer opType) {
		return auditInfoService.hasWaitAudit(merchantNo, promoterId, opType);

	}
	@Override
	public int hasAuditedCount(String objNo,Long objId,Integer opType,Integer status){
		List<NewT0AuditInfoDO> list=auditInfoService.queryHasAudited(objNo, objId, opType,status);
		return list.size();
	}

	@Override
	public int surplusAdjustCount(String objNo, Long objId, Integer opType, Integer status) {
		//已调额成功次数
		Integer hasAdustCount=hasAuditedCount(objNo, objId, opType, status);
		//总次数
		String totalStr=ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.SURPLUS_TEMPORARY_ADJUST_COUNT);
		Integer totalCount = Integer.valueOf(totalStr==null?"0":totalStr);
		return totalCount-hasAdustCount;
	}
	@Override
	public Date queryAdjustTime(String key){
		if(key.equals(MerchantCreditConstant.START))
			key=MerchantCreditConstant.ADJUST_TIME_STARTTIME ;
		else
			key=MerchantCreditConstant.ADJUST_TIME_ENDTIME;

		String startTime=ConfigOptionHelper.getConfigByKey(key);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String[] tmp = startTime.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmp[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(tmp[1]));
		return calendar.getTime();
	}
	@Override
	public double getUseLimitRadio() throws McBizException{
		String keyValue=ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.ADJUST_LIMIIT_USE_RATIO);
		if(StringUtils.isBlank(keyValue)){
			throw new McBizException("请在后台完成对应的配置项：临时调额当日额度使用比例-adjust.limit.use.ratio");
		}
		return Double.valueOf(keyValue);
	}


}
