package com.sdp.mc.service;

import java.util.List;

import com.sdp.mc.common.model.AuditInfoRequestLog;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;

public interface AuditInfoService {

	/**
	 * insert待审核的请求
	 *
	 * @param objNo
	 *            必填
	 * @param objId
	 *            必填
	 * @param merchantType
	 * @param opType
	 * @param reqLog
	 * @return
	 */
	ErrorMessageVO insertWaitAudit(String objNo, Long objId, Integer objType, Integer opType, AuditInfoRequestLog reqLog);
	/**
	 *
	 * @param objNo
	 * @param objId
	 * @param merchantType
	 * @param opType
	 * @param reqLog
	 * @return
	 */
	public ErrorMessageVO insertWaitAudit(String objNo, Long objId, Integer merchantType, Integer opType, String reqLog,String mcType);

	/**
	 * 将待审核update为审核中
	 *
	 * @param objNo
	 * @param objId
	 *            必填
	 * @return
	 */
	 @Deprecated
	ErrorMessageVO updateWaitAuditToAuditing(String objNo, Long objId, String operator, String operatorId);

	/**
	 * 将审核中update为已审核
	 *
	 * @param objNo
	 * @param objId
	 *            必填
	 * @return
	 */
	ErrorMessageVO updateWaitAuditToAudited(String objNo, Long objId, String operator, String operatorId);

	/**
	 * 查询状态为待审核的记录
	 *
	 * @param objNo
	 * @param objId
	 * @return
	 */
	List<NewT0AuditInfoDO> queryWaitAudit(String objNo, Long objId, Integer opType);

	/**
	 * 查询状态为审核中的记录
	 *
	 * @param objNo
	 * @param objId
	 *            必填
	 * @return
	 */
	List<NewT0AuditInfoDO> queryAuditing(String objNo, Long objId, Integer opType);

	/**
	 * 查询是否有待审核的记录
	 *
	 * @param objNo
	 * @param objId
	 *            必填
	 * @return
	 */
	boolean hasWaitAudit(String objNo, Long objId, Integer opType);

	/**
	 * 查询是否有审核中的记录
	 *
	 * @param objNo
	 * @param objId
	 *            必填
	 * @return
	 */
	boolean hasAuditing(String objNo, Long objId, Integer opType);

	/**
	 * 查询所有非已审核状态的记录
	 *
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @return
	 */
	List<NewT0AuditInfoDO> queryNonAudited(String objNo, Long objId, Integer opType);

	/**
	 * 查询是否有非已审核状态的记录
	 *
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @return
	 */
	boolean hasNonAudited(String objNo, Long objId, Integer opType);
	
	public List<AuditInfoDTO> selectAuditInfoByQuery(ExtNewT0AuditInfoDOExample example);
	
	AuditInfoDTO selectAuditInfoById(Long id);

	/**
	 * 查询是否有符合要求的数据
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @param status
	 * @return
	 */
	boolean hasAudited(String objNo, Long objId, Integer opType,Integer status);
	/**
	 * 查询符合要求的记录
	 * @param objNo
	 * @param objId
	 * @param opType
	 * @param status
	 * @return
	 */
	List<NewT0AuditInfoDO> queryHasAudited(String objNo, Long objId, Integer opType, Integer status);
	
	ErrorMessageVO updateWaitAuditToAudited(Long id, Long objId, int auditStatus, String operator, String operatorId, String requestLog);
	int updateStatus(Long id, String objNo, Long objId, int oldStatus, int newStatus, String operator, String operatorId, String requestLog);
}
