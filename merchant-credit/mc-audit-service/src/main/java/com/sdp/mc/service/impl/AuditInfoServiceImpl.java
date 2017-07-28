package com.sdp.mc.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.model.AuditInfoRequestLog;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import com.sdp.mc.newt0.manager.ExtNewT0AuditInfoManager;
import com.sdp.mc.newt0.manager.NewT0AuditInfoManager;
import com.sdp.mc.service.AuditInfoService;

@Service
public class AuditInfoServiceImpl implements AuditInfoService {

	private static final Logger log = LoggerFactory.getLogger(AuditInfoServiceImpl.class);

	@Autowired
	private NewT0AuditInfoManager newT0AuditInfoManager;
	@Autowired
	private ExtNewT0AuditInfoManager extNewT0AuditInfoManager;

	@Override
	public ErrorMessageVO insertWaitAudit(String objNo, Long objId, Integer merchantType, Integer opType, String reqLog,String mcType) {
		Assert.isTrue(StringUtils.isNotBlank(objNo), "ObjNo can't be null");
		Assert.notNull(objId, "ObjId can't be null");

		List<NewT0AuditInfoDO> list = this.queryAuditing(objNo, objId, opType);
		if (list != null && list.size() > 0) {
			log.info("AuditInfoServiceImpl.insertWaitAudit has auditing list, objNo=" + (StringUtils.isBlank(objNo) ? "null" : objNo) + " objId=" + objId + " list "
					+ ToStringBuilder.reflectionToString(list));
			return new ErrorMessageVO(false, "-2", "正在审核中，不能发起请求");
		}
		NewT0AuditInfoDO po = new NewT0AuditInfoDO();
		po.setObjNo(objNo);
		po.setObjId(objId);
		po.setObjType(merchantType);
		po.setOpType(opType);
		if (reqLog != null) {
			po.setRequestLog(reqLog);
		}
		po.setStatus(AuditInfoStateEnum.WAIT_AUDIT.getStatus());
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());
		po.setMcType(mcType);
//		po.setAuditTime(new Date());
		try {
			po.setExpireTime(DateUtil.dateFormat4.parse(DateUtil.getCurrentDayStrEndTime(new Date())));
			long num = this.newT0AuditInfoManager.insert(po);
			if (num > 0) { // insert success
				return new ErrorMessageVO(true, null, "操作成功");
			}
			return new ErrorMessageVO(false, null, "操作失败");
		} catch (ParseException e) {
			log.error("AuditInfoServiceImpl#insertWaitAudit is error",e);
			return new ErrorMessageVO(false, null, "操作失败");
		}


	}
	@Override
	public ErrorMessageVO insertWaitAudit(String objNo, Long objId, Integer merchantType, Integer opType, AuditInfoRequestLog reqLog) {
		Assert.isTrue(StringUtils.isNotBlank(objNo), "ObjNo can't be null");
		Assert.notNull(objId, "ObjId can't be null");

		List<NewT0AuditInfoDO> list = this.queryAuditing(objNo, objId, opType);
		if (list != null && list.size() > 0) {
			log.info("AuditInfoServiceImpl.insertWaitAudit has auditing list, objNo=" + (StringUtils.isBlank(objNo) ? "null" : objNo) + " objId=" + objId + " list "
					+ ToStringBuilder.reflectionToString(list));
			return new ErrorMessageVO(false, "-2", "正在审核中，不能发起请求");
		}
		NewT0AuditInfoDO po = new NewT0AuditInfoDO();
		po.setObjNo(objNo);
		po.setObjId(objId);
		po.setObjType(merchantType);
		po.setOpType(opType);
		if (reqLog != null) {
			po.setRequestLog(reqLog.convertToJsonString());
		}
		po.setStatus(AuditInfoStateEnum.WAIT_AUDIT.getStatus());
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());

		long num = this.newT0AuditInfoManager.insert(po);
		if (num > 0) { // insert success
			return new ErrorMessageVO(true, null, "操作成功");
		}
		return new ErrorMessageVO(false, null, "操作失败");
	}
    @Deprecated
	@Override
	public ErrorMessageVO updateWaitAuditToAuditing(String objNo, Long objId, String operator, String operatorId) {
		log.info("AuditInfoServiceImpl.updateWaitAuditToAuditing objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId) + " operator="
				+ (operator == null ? "null" : operator) + " operatorId=" + (operatorId == null ? "null" : operatorId));
		Assert.notNull(objId, "ObjId can't be null");

		int rows = this.updateStatus(null,objNo, objId, AuditInfoStateEnum.WAIT_AUDIT.getStatus(), AuditInfoStateEnum.AUDITING.getStatus(), operator, operatorId,null);
		if (rows > 0) { // update success
			return new ErrorMessageVO(true, null, "操作成功");
		}
		return new ErrorMessageVO(false, null, "操作失败");
	}

	@Override
	public ErrorMessageVO updateWaitAuditToAudited(String objNo, Long objId, String operator, String operatorId) {
		log.info("AuditInfoServiceImpl.updateAuditingToAudited objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId) + " operator="
				+ (operator == null ? "null" : operator) + " operatorId=" + (operatorId == null ? "null" : operatorId));
		Assert.notNull(objId, "ObjId can't be null");
		int rows = this.updateStatus(null,objNo, objId, AuditInfoStateEnum.WAIT_AUDIT.getStatus(), AuditInfoStateEnum.AUDITED.getStatus(), operator, operatorId,null);
		if (rows > 0) { // update success
			return new ErrorMessageVO(true, null, "操作成功");
		}
		return new ErrorMessageVO(false, null, "操作失败");
	}
	@Override
	public ErrorMessageVO updateWaitAuditToAudited(Long id,Long objId ,int auditStatus,String operator, String operatorId,String requestLog) {
		log.info("AuditInfoServiceImpl.updateWaitAuditToAudited id=" + (id == null ? "null" : id) + " objId=" + (objId == null ? "null" : objId) + " operator="
				+ (operator == null ? "null" : operator) + " operatorId=" + (operatorId == null ? "null" : operatorId));
		int rows = this.updateStatus(id,null, objId, AuditInfoStateEnum.WAIT_AUDIT.getStatus(), auditStatus, operator, operatorId,requestLog);
		if (rows == 1) { // update success
			return new ErrorMessageVO(true, null, "操作成功");
		}
		return new ErrorMessageVO(false, null, "操作失败");
	}

	@Override
	public List<NewT0AuditInfoDO> queryWaitAudit(String objNo, Long objId, Integer opType) {
		log.info("AuditInfoServiceImpl.queryWaitAudit objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId));
		Assert.notNull(objId, "ObjId can't be null");
		NewT0AuditInfoDOExample example = new NewT0AuditInfoDOExample();
		NewT0AuditInfoDO po = new NewT0AuditInfoDO();
		po.setObjNo(objNo);
		po.setObjId(objId);
		po.setOpType(opType);
		po.setStatus(AuditInfoStateEnum.WAIT_AUDIT.getStatus());
		this.setNewT0AuditInfoDOExample(example, po);
		return newT0AuditInfoManager.selectByExample(example);
	}

	@Override
	public List<NewT0AuditInfoDO> queryAuditing(String objNo, Long objId, Integer opType) {
		log.info("AuditInfoServiceImpl.queryAuditing objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId));
		Assert.notNull(objId, "ObjId can't be null");
		NewT0AuditInfoDOExample example = new NewT0AuditInfoDOExample();
		NewT0AuditInfoDO po = new NewT0AuditInfoDO();
		po.setObjNo(objNo);
		po.setObjId(objId);
		po.setOpType(opType);
		po.setStatus(AuditInfoStateEnum.WAIT_AUDIT.getStatus());
		this.setNewT0AuditInfoDOExample(example, po);
		return newT0AuditInfoManager.selectByExample(example);
	}

	@Override
	public List<NewT0AuditInfoDO> queryNonAudited(String objNo, Long objId, Integer opType) {
		log.info("AuditInfoServiceImpl.queryNonAudited objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId));
		Assert.notNull(objId, "ObjId can't be null");
		NewT0AuditInfoDOExample example = new NewT0AuditInfoDOExample();
		NewT0AuditInfoDOExample.Criteria criteria = example.createCriteria();
		criteria.andObjIdEqualTo(objId).andStatusNotEqualTo(AuditInfoStateEnum.AUDITED.getStatus()).andStatusNotEqualTo(AuditInfoStateEnum.REJECT.getStatus());
		if (StringUtils.isNotBlank(objNo)) {
			criteria.andObjNoEqualTo(objNo);
		}
		if (opType != null) {
			criteria.andOpTypeEqualTo(opType);
		}
		return newT0AuditInfoManager.selectByExample(example);
	}

	@Override
	public boolean hasWaitAudit(String objNo, Long objId, Integer opType) {
		List<NewT0AuditInfoDO> list = this.queryWaitAudit(objNo, objId, opType);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean hasAuditing(String objNo, Long objId, Integer opType) {
		List<NewT0AuditInfoDO> list = this.queryAuditing(objNo, objId, opType);
		if (list == null ||list.isEmpty()|| list.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean hasNonAudited(String objNo, Long objId, Integer opType) {
		List<NewT0AuditInfoDO> list = this.queryNonAudited(objNo, objId, opType);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 更新状态
	 *
	 * @param objNo
	 * @param objId
	 * @param oldStatus
	 * @param newStatus
	 * @return
	 */
	@Override
	public int updateStatus(Long id,String objNo, Long objId, int oldStatus, int newStatus, String operator, String operatorId,String requestLog) {
		log.info("AuditInfoServiceImpl.updateStatus objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId) + " oldStatus" + oldStatus + " newStatus" + newStatus
				+ " operator=" + (operator == null ? "null" : operator) + " operatorId=" + (operatorId == null ? "null" : operatorId));
		NewT0AuditInfoDOExample example = new NewT0AuditInfoDOExample();
		com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criteria criter =example.createCriteria();
		if(id!=null){
			criter.andIdEqualTo(id);
		}
		if(StringUtils.isNotBlank(objNo)){
			criter.andObjNoEqualTo(objNo);
		}
		if(objId!=null){
			criter.andObjIdEqualTo(objId);
		}
		criter.andStatusEqualTo(oldStatus);
		NewT0AuditInfoDO record = new NewT0AuditInfoDO();
		if(AuditInfoStateEnum.REJECT.getStatus()==newStatus||AuditInfoStateEnum.AUDITED.getStatus()==newStatus){
			record.setAuditTime(new Date());
		}
		if(StringUtils.isNotBlank(requestLog)){
			record.setRequestLog(requestLog);
		}
		record.setStatus(newStatus);
		record.setUpdateTime(new Date());
		record.setOperator(operator);
		record.setOperatorId(operatorId);
		int rows = this.extNewT0AuditInfoManager.updateByExampleSelective(record, example);
		log.info("AuditInfoServiceImpl.updateStatus objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId) + " oldStatus=" + oldStatus + " newStatus=" + newStatus
				+ " operator=" + (operator == null ? "null" : operator) + " operatorId=" + (operatorId == null ? "null" : operatorId) + " rows=" + rows);
		return rows;
	}

	private void setNewT0AuditInfoDOExample(NewT0AuditInfoDOExample example, NewT0AuditInfoDO po) {
		NewT0AuditInfoDOExample.Criteria criteria = example.createCriteria();
		criteria.andObjIdEqualTo(po.getObjId());
		if (StringUtils.isNotBlank(po.getObjNo())) {
			criteria.andObjNoEqualTo(po.getObjNo());
		}
		if (po.getObjId()!=null) {
			criteria.andObjIdEqualTo(po.getObjId());
		}
		if (po.getObjType() != null) {
			criteria.andObjTypeEqualTo(po.getObjType());
		}
		if (po.getStatus() != null) {
			criteria.andStatusEqualTo(po.getStatus());
		}
		if (po.getOpType() != null) {
			criteria.andOpTypeEqualTo(po.getOpType());
		}
		if(po.getOpType()!=null&&OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code==po.getOpType())
		   criteria.andExpireTimeGreaterThan(new Date());
	}
	@Override
	public List<AuditInfoDTO> selectAuditInfoByQuery(ExtNewT0AuditInfoDOExample example) {
		return this.extNewT0AuditInfoManager.selectAuditInfoByQuery(example);
	}
	@Override
	public AuditInfoDTO selectAuditInfoById(Long id) {
		ExtNewT0AuditInfoDOExample example=new ExtNewT0AuditInfoDOExample();
		example.setId(id);
		List<AuditInfoDTO> list= extNewT0AuditInfoManager.selectAuditInfoByExample(example);
		if(list!=null&&list.size()==1){
			return list.get(0);
		}
		return null;
	}


	@Override
	public boolean hasAudited(String objNo, Long objId, Integer opType, Integer status) {
		List<NewT0AuditInfoDO> list = this.queryHasAudited(objNo, objId, opType,status);
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}
	@Override
	public List<NewT0AuditInfoDO> queryHasAudited(String objNo, Long objId, Integer opType,Integer status) {
		log.info("AuditInfoServiceImpl.queryHasAudited objNo=" + (objNo == null ? "null" : objNo) + " objId=" + (objId == null ? "null" : objId));
		Assert.notNull(objId, "ObjId can't be null");
		NewT0AuditInfoDOExample example = new NewT0AuditInfoDOExample();
		NewT0AuditInfoDOExample.Criteria criteria = example.createCriteria();
		criteria.andObjIdEqualTo(objId).andStatusEqualTo(status).andCreateTimeBetween(DateUtil.getMonthMinDate(), DateUtil.getMonthMaxDate());

		if (StringUtils.isNotBlank(objNo)) {
			criteria.andObjNoEqualTo(objNo);
		}
		if (opType != null) {
			criteria.andOpTypeEqualTo(opType);
		}
		return newT0AuditInfoManager.selectByExample(example);
	}

}
