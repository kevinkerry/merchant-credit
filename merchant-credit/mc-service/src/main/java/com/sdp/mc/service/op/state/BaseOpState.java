package com.sdp.mc.service.op.state;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.fos.model.RemitTransferRequest;
import com.sdp.fos.model.TransferOrderOrigApplication;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.MarginTransEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import com.sdp.mc.fos.manager.MarginTransManager;
import com.sdp.mc.fos.wrapper.utils.FOSTransferUtil;
import com.sdp.mc.integration.fos.dto.response.RemitTransferResponseDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import com.sdp.mc.ma.manager.MarginAccountRequestManager;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.manager.MarginOpReqManager;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.manager.NewT0UserOperaRecordManager;
import com.shengpay.facade.fos.FOSFacade;

public abstract class BaseOpState implements OpState {

	// protected RemitTransferServiceWrapper transferServiceWrapper;
	@Autowired
	protected FOSFacade fosFacade;
	@Autowired
	protected MarginOpReqManager marginOpReqManager;
	@Autowired
	protected MarginTransManager marginTransManager;
	@Autowired
	protected MspFacade mspFacade;
	@Autowired
	protected FsConfigChangeManager fsConfigChangeManager;
	
	@Autowired
	protected MarginAccountRequestManager marginAccountRequestManager;
	
	@Autowired
	protected NewT0UserOperaRecordManager newT0UserOperaRecordManager;

	public int handler(OpContext context,String operatorId) {
		int handlerStatus = handlerOpState(context ,operatorId);
		context.setHandlerStatus(handlerStatus);
		return changeState(context, handlerStatus);
	}

	public abstract int handlerOpState(OpContext context,String operatorId);

	public abstract int changeState(OpContext context, int handlerOpStatus);

	protected int modifyMarginOpReqStatus(long morId, int targetStatus, int sourceStatus) {
		MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
		marginOpReqDO.setStatus(targetStatus);
		marginOpReqDO.setUpdateTime(new Date());
		MarginOpReqDOExample example = new MarginOpReqDOExample();
		example.createCriteria().andMorIdEqualTo(morId).andStatusEqualTo(sourceStatus);
		return marginOpReqManager.updateByExampleSelective(marginOpReqDO, example);
	}

	protected void modifyMarginOpReqMtIdHis(long morId, long mtId) {
		MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
		marginOpReqDO.setMtId(mtId + "");
		if (marginOpReqDO.getMtIdHis() == null)
			marginOpReqDO.setMtIdHis(mtId + ",");
		else
			marginOpReqDO.setMtIdHis(marginOpReqDO.getMtIdHis() + mtId + ",");
		marginOpReqManager.updateByPrimaryKeySelective(marginOpReqDO);
	}

	protected void modifyMarginOpReqFcmIdHis(long morId, long fcmId) {
		MarginOpReqDO marginOpReqDO = marginOpReqManager.selectByPrimaryKey(morId);
		marginOpReqDO.setFcmId(fcmId);
		if (marginOpReqDO.getFcmIdHis() == null)
			marginOpReqDO.setFcmIdHis(fcmId + ",");
		else
			marginOpReqDO.setFcmIdHis(marginOpReqDO.getFcmIdHis() + fcmId + ",");
		marginOpReqManager.updateByPrimaryKeySelective(marginOpReqDO);
	}

	protected int modifyMarginTransStatus(MarginTransDO record, int sourceStatus) {
		MarginTransDOExample example = new MarginTransDOExample();
		example.setMtId(record.getMtId());
		record.setStatus(sourceStatus);
		record.setUpdateTime(new Date());
		return marginTransManager.updateByExampleSelective(record, example);
	}

	protected MarginOpReqDO createMarginOpReq(OpContext context, int status) {
		MarginOpReqDO record = new MarginOpReqDO();
		record.setAmount(context.getAmount());
		record.setOpType(context.getOpType());
		record.setPromoterId(context.getPromoterId());
		record.setCreateTime(new Date());
		record.setStatus(status);
		record.setRedeemedTime(context.getRedeemedTime());
		Long morId = marginOpReqManager.insert(record);
		record.setMorId(morId);
		return record;
	}

	//添加操作记录
	protected NewT0UserOperaRecordDO createNewT0UserOperaRecord(MarginOpReqDO marginDo,OpContext context, int status){
		NewT0UserOperaRecordDO record = new NewT0UserOperaRecordDO();
		
		record.setBizId(marginDo.getMorId());
		record.setBizType(Long.parseLong(context.getOpType()+""));
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		Long id = newT0UserOperaRecordManager.insert(record);
		record.setId(id);
		return record;
	}
	
	
	protected MarginTransDO createMarginTransDO(OpContext context) {
		MarginTransDO marginTransDO = RemitTransferRequest2MarginTransDO(context);
		marginTransDO.setStatus(MarginTransEnum.INIT.code);
		marginTransDO.setCreateTime(new Date());
		Long mtId = marginTransManager.insert(marginTransDO);
		marginTransDO.setMtId(mtId);
		return marginTransDO;
	}
	
	

	protected MarginTransDO RemitTransferRequest2MarginTransDO(OpContext context) {
		RemitTransferRequest transferRequest = FOSTransferUtil.buildRemitTransferRequest(context.getRemitTransferRequest());
		MarginTransDO marginTransDO = new MarginTransDO();
		TransferOrderOrigApplication transferOrder = transferRequest.getTransferOrder();
		// transferOrder.get
		marginTransDO.setProductCode(transferOrder.getProductCode());
		marginTransDO.setAppId(context.getAppId());
		marginTransDO.setPaymentCode(transferOrder.getPaymentCode());
		marginTransDO.setRemitVoucherNo(transferOrder.getRemitVoucherNo());
		marginTransDO.setPayerMemberId(transferOrder.getPayerMemberId());
		marginTransDO.setPayeeMemberId(transferOrder.getPayeeMemberId());
		marginTransDO.setIsNeedCountFee(transferOrder.isNeedCountFee() ? MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_TRUE : MerchantCreditConstant.FOS_REQUEST_IS_NEED_COUNT_FEE_FALSE);// 是否需要计费,1：计费；0：不计费
		marginTransDO.setPayeeFee(transferOrder.getPayeeFee() != null ? transferOrder.getPayeeFee().toString() : "0");
		marginTransDO.setPayerFee(transferOrder.getPayerFee() != null ? transferOrder.getPayerFee().toString() : "0");

		marginTransDO.setPayerAccountType(transferOrder.getPayerAccountType() + "");
		marginTransDO.setPayerAccountNo(transferOrder.getPayerAccountNo());
		marginTransDO.setPayeeAccountNo(transferOrder.getPayeeAccountNo());

		marginTransDO.setGmtBizInitiate(DateUtil.date2Str(transferOrder.getGmtBizInitiate(), DateUtil.fosOrderFormat));// 20071117020101
		marginTransDO.setGmtPaymentInitiate(DateUtil.date2Str(transferOrder.getGmtPaymentInitiate(), DateUtil.fosOrderFormat));
		if (transferOrder.getRemitAmount() != null)
			marginTransDO.setRemitAmount(transferOrder.getRemitAmount().toString());
		marginTransDO.setCallbackAddress(transferOrder.getCallbackAddress());
		marginTransDO.setMemo(transferOrder.getMemo() == null ? "" : transferOrder.getMemo());
		marginTransDO.setCurrency(transferOrder.getCurrency());
		// marginTransDO.setExtention(transferOrder.getExtension());
		// BeanUtils.copyProperties(transferRequest.getTransferOrder(),
		// marginTransDO);

		return marginTransDO;
	}

	protected MarginTransDO RemitTransferResponseDTO2MarginTransDO(RemitTransferResponseDTO transferResponseDTO, Long mtId) {
		MarginTransDO marginTransDO = marginTransManager.selectByPrimaryKey(mtId);
		BeanUtils.copyProperties(transferResponseDTO, marginTransDO, new String[] { "productCode", "paymentCode", "remitVoucherNo", "payerMemberId", "payeeMemberId" });
		return marginTransDO;
	}

	/**
	 * 查询代理商保证金追加/退回记录状态
	 * 
	 * @param promoterId
	 * @param opType
	 * @param status
	 * @return
	 */
	protected List<MarginOpReqDO> queryMarginOpReq(Long promoterId, Integer opType, Integer status) {
		return marginOpReqManager.queryMarginOpReq(promoterId, opType, status);
	}

	/**
	 * 更新代理商保证金追加/退回记录状态
	 * 
	 * @param list
	 * @param targetStatus
	 * @param sourceStatus
	 * @return
	 */
	protected int modifyMarginOpReqStatus(List<MarginOpReqDO> list, int targetStatus, int sourceStatus) {
		int rows = 0;
		if (list != null) {
			for (MarginOpReqDO marginOpReqDO : list) {
				MarginOpReqDO record = new MarginOpReqDO();
				record.setStatus(targetStatus);
				record.setUpdateTime(new Date());
				MarginOpReqDOExample example = new MarginOpReqDOExample();
				example.createCriteria().andMorIdEqualTo(marginOpReqDO.getMorId()).andStatusEqualTo(sourceStatus);
				marginOpReqManager.updateByExampleSelective(record, example);
			}
		}
		return rows;
	}

	/**
	 * 更新代理商保证金追加/退回记录的
	 * 
	 * @param list
	 * @param fcmId
	 * @return
	 */
	protected int modifyMarginOpReqFcmIdHis(List<MarginOpReqDO> list, long fcmId) {
		int rows = 0;
		if (list != null) {
			for (MarginOpReqDO marginOpReqDO : list) {
				MarginOpReqDO record = new MarginOpReqDO();
				record.setFcmId(fcmId);
				record.setFcmIdHis((marginOpReqDO.getFcmIdHis() == null ? "" : marginOpReqDO.getFcmIdHis()) + fcmId + ",");
				marginOpReqManager.updateByPrimaryKeySelective(record);
			}
		}
		return rows;
	}
}
