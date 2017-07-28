package com.sdp.mc.newt0.manager.impl.ext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.model.AuditInfoRequestAdustLog;
import com.sdp.mc.common.model.AuditInfoRequestLog;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.daointerface.NewT0AuditInfoDAO;
import com.sdp.mc.newt0.dao.daointerface.ext.ExtNewT0AuditInfoDAO;
import com.sdp.mc.newt0.manager.ExtNewT0AuditInfoManager;
import com.sdp.mc.newt0.manager.NewT0AuditInfoManager;
import com.sdp.mc.newt0.manager.impl.NewT0AuditInfoManagerImpl;

@Service
public class ExtNewT0AuditInfoManagerImpl extends NewT0AuditInfoManagerImpl implements ExtNewT0AuditInfoManager {
	private static final Logger log = LoggerFactory.getLogger(ExtNewT0AuditInfoManagerImpl.class);
	@Autowired
	private NewT0AuditInfoDAO newT0AuditInfoDAO;
	@Autowired
	private ExtNewT0AuditInfoDAO extNewT0AuditInfoDAO;
	@Autowired
	private NewT0AuditInfoManager newT0AuditInfoManager;

	public int updateByExampleSelective(NewT0AuditInfoDO record, NewT0AuditInfoDOExample example) {
		int rows = newT0AuditInfoDAO.updateByExampleSelective(record, example);
		return rows;
	}

	@Override
	public Integer countByExample(NewT0AuditInfoDOExample example) {
		// TODO Auto-generated method stub
		return newT0AuditInfoDAO.countByExample(example);
	}

	@Override
	public List<AuditInfoDTO> selectAuditInfoByQuery(ExtNewT0AuditInfoDOExample example) {
		Integer totalItem = (Integer) extNewT0AuditInfoDAO.countByExample(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<AuditInfoDTO> returnList = new ArrayList<AuditInfoDTO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {
			example.setOrderByClause("ai.CREATE_TIME desc");
			List<AuditInfoDTO> list = extNewT0AuditInfoDAO.selectByQuery(example);
			if (list != null) {
				for (AuditInfoDTO info : list) {
					converAuditInfo(info);
				}
			}
			returnList.addAll(list);
		}
		return returnList;
	}

	@Override
	public List<AuditInfoDTO> selectAuditInfoByExample(ExtNewT0AuditInfoDOExample example) {
		example.setOrderByClause("ai.CREATE_TIME desc");
		List<AuditInfoDTO> list = extNewT0AuditInfoDAO.selectByExample(example);
		if (list != null&&!list.isEmpty()) {
			for (AuditInfoDTO info : list) {
				converAuditInfo(info);
			}
		}
		return list;
	}

	private AuditInfoDTO converAuditInfo(AuditInfoDTO auditInfoDTO) {
		if (auditInfoDTO != null) {
			String requestLog = auditInfoDTO.getRequestLog();
			try {
				if (StringUtils.isNotBlank(requestLog)) {
					if (OpTypeEnums.ADD.code == auditInfoDTO.getOpType()) {
						AuditInfoRequestLog marginInfo = new AuditInfoRequestLog();
						JSONObject obj = JSONObject.fromObject(requestLog);
						marginInfo = (AuditInfoRequestLog) JSONObject.toBean(obj, AuditInfoRequestLog.class);
						auditInfoDTO.setMarginInfo(marginInfo);
					} else if (OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code == auditInfoDTO.getOpType()) {
						AuditInfoRequestAdustLog tempLimitInfo = new AuditInfoRequestAdustLog();
						JSONObject obj = JSONObject.fromObject(requestLog);
						tempLimitInfo = (AuditInfoRequestAdustLog) JSONObject.toBean(obj, AuditInfoRequestAdustLog.class);
						if (tempLimitInfo != null) {
							auditInfoDTO.setAttachmentPath("file/download.htm?" + "key=" + tempLimitInfo.getAttachment() + "&fileName="
									+ tempLimitInfo.getFileName() + "&contentType=" + tempLimitInfo.getContentType());
						}
						if(AuditInfoStateEnum.WAIT_AUDIT.getStatus()==auditInfoDTO.getStatus()&&DateUtil.compareDate(new Date(),auditInfoDTO.getExpireTime())>=0){
							auditInfoDTO.setStatus(AuditInfoStateEnum.OVERDUE.getStatus());
						}
						auditInfoDTO.setEffectivity(auditInfoDTO.getExpireTime().compareTo(new Date())>0?true:false);
						auditInfoDTO.setTempLimitInfo(tempLimitInfo);
					}
				}
			} catch (Exception e) {
				log.error("converAuditInfo Exception", e);
			}
		}
		return auditInfoDTO;
	}

	@Override
	public AuditInfoDTO selectAuditedTempLimitInfoByMerchantInfo(String merchantNo, String mcType) {
		ExtNewT0AuditInfoDOExample example=new ExtNewT0AuditInfoDOExample();
		example.setOpType(OpTypeEnums.SHENGPAY_PROMPTER_ADJUST_LIMIT.code);
		example.setObjNo(merchantNo);
		example.setMcType(mcType);
		example.setAuditStatus(AuditInfoStateEnum.AUDITED.getStatus());
		example.setCreateTimeStart(DateUtil.str2Date(DateUtil.getCurrentDayStrFristTime(new Date())));
		example.setCreateTimeEnd(DateUtil.str2Date(DateUtil.getCurrentDayStrEndTime(new Date())));
		List<AuditInfoDTO> list=selectAuditInfoByExample(example);
		if (list != null&&!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
