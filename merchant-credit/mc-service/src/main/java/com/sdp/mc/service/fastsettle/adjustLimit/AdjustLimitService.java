package com.sdp.mc.service.fastsettle.adjustLimit;

import java.util.Date;
import java.util.List;

import com.sdp.mc.common.bean.newt0.AdjustLimitBean;
import com.sdp.mc.common.util.McBizException;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;

public interface AdjustLimitService {
	/**
	 * 分页查询历史调额交易记录
	 *
	 * **/
	public List<AdjustLimitBean> pageQueryAdjustTrans(NewT0AuditInfoDOExample example);
	/**
	 * 新增调额
	 * @param adjust
	 * @return
	 */
	public void addAuditInfo(AdjustLimitBean adjust,String operatorId);
	/**
	 * 是否有需要审核的数据
	 * @param merchantNo
	 * @param date
	 * @return
	 */
	public boolean isNeedApproval(String merchantNo,Long promoterId,Integer opType);
	/**
	 * 记录数
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @return
	 */
	int hasAuditedCount(String objNo, Long objId, Integer opType,Integer status);
	/**
	 * 本月剩余调额次数
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @param status
	 * @return
	 */
	int surplusAdjustCount(String objNo, Long objId, Integer opType,Integer status);
	/**
	 * 获取临时调额开始/结束时间
	 * @param key(start/end)
	 * @return
	 */
	Date queryAdjustTime(String key);
	/**
	 * 根据key获取配置项
	 * @throws McBizException
	 */
	double getUseLimitRadio() throws McBizException;


}
