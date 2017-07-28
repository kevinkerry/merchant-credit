package com.sdp.withdraw.service;

import java.util.List;

import com.sdp.mc.common.dto.WithdrawFailRetryRuleDTO;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDO;


/**

 */
public interface WithdrawRetryService {
    /**
     * 查询出款请求的未执行的重试计划
     * @param reqId
     * @return
     */
	List<WithdrawRetryPlanDO> queryNonexecutionRetryPlanByReqId(Long reqId);

	/**
	 * 查询出款请求的待执行的重试计划
	 * @param reqId
	 * @return
	 */
	List<WithdrawRetryPlanDO> queryWaitExecutionRetryPlanByReqId(Long reqId);
	/**
	 * 查询出款请求的待执行的重试计划
	 * @return
	 */
	List<WithdrawRetryPlanDO> queryWaitExecutionRetryPlan();
    /**
     * 更新状态
     * @param planId 计划ID
     * @param sourceStatus 源状态
     * @param targetStatus 目标状态
     * @return
     */
	int updateDataStatus(Long planId, Integer sourceStatus, Integer targetStatus);
    /**
     * 创建重试计划信息
     * @param panDo
     */
	void createDate(WithdrawRetryPlanDO panDo);
   /**
    * 构建重试计划信息
    * @param reqDo
    * @param remitVoucherNo
    * @param retryRule
    */
	void buildWithdrawFailRetryPlan(WithdrawReqDO reqDo, String remitVoucherNo, WithdrawFailRetryRuleDTO retryRule);
    /**
     * 执行重试任务
     */
	void executeRetryJob();
    /**
     * 形成手动的重试计划
     * @param reqDo 业务请求数据
     * @param remitVoucherNo 之前执行的调用FOS的业务订单号
     */
	void buildHandRetryPlan(WithdrawReqDO reqDo, String remitVoucherNo);


   /**
    * 形成重试出款
    * @param reqId 
    * @param remitVoucherNo
    * @return
    */
	public ErrorMessageVO<Object> retryWithdraw(Long reqId,String remitVoucherNo);
    /**
     * 根据支付订单号和请求ID查询重试计划
     * @param reqId
     * @param remitVoucherNo
     * @return
     */
	WithdrawRetryPlanDO queryRetryPlanInfoByReqIdAndRemitVoucherNo(Long reqId, String remitVoucherNo);
	/**
	    * 形成重试出款
	    * @param reqId 
	    * @param remitVoucherNo
	    * @return
	    * @throws Exception 
	    */
	ErrorMessageVO<Object> retryWithdraw(Long reqId, String remitVoucherNo, String operator,String operatorId) throws Exception;

}
