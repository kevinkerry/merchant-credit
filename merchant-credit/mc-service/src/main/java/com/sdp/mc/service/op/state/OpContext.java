package com.sdp.mc.service.op.state;

import java.math.BigDecimal;
import java.util.Date;

import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;

public class OpContext {

	/**
	 * 操作类型：(开通/关闭)，(追加/退回)
	 */
	private int opType;
	// /**
	// * 类型：开通/关闭/追加/退回
	// */
	// private int type;
	/**
	 * 业务编号
	 */
	private Long bizId;

	/**
	 * handlerSate 操作状态
	 */
	private int handlerStatus;
	private long promoterId;
	private String promoterNo;
	
	private String promoterType;
	/*** 代理商memberId **/
	private String merchantMemberId;
	/*** 代理商操作员id **/
	private String operatorId;
	private long merchantId;
	private String merchantNo;
	private Date redeemedTime;
	/** 客户端ip **/
	private String userIp;

	private BigDecimal amount;
	private RemitTransferRequestDTO remitTransferRequest;
	private MspModifyRequest mspModifyRequest;
	private String appId;
	private LoaningTypeEnum loaningType;// 垫资方
	private BigDecimal fastSettleLimit;// 快速结算额度

	// private String errorCode;
	// private String errorMsg;
	/**
	 * 存放各个状态机执行的操作
	 */
	private OpStateResponse opStateResponse;
	//文件名
	private String fileName;
	//文件类型
	private String contentType;
	
	private BigDecimal promoterMinMargin;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public OpStateResponse getOpStateResponse() {
		return opStateResponse;
	}

	public void setOpStateResponse(OpStateResponse opStateResponse) {
		this.opStateResponse = opStateResponse;
	}

	public MspModifyRequest getMspModifyRequest() {
		return mspModifyRequest;
	}

	public void setMspModifyRequest(MspModifyRequest mspModifyRequest) {
		this.mspModifyRequest = mspModifyRequest;
	}

	public RemitTransferRequestDTO getRemitTransferRequest() {
		return remitTransferRequest;
	}

	public void setRemitTransferRequest(RemitTransferRequestDTO remitTransferRequest) {
		this.remitTransferRequest = remitTransferRequest;
	}

	public long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(long promoterId) {
		this.promoterId = promoterId;
	}

	public String getMerchantMemberId() {
		return merchantMemberId;
	}

	public void setMerchantMemberId(String merchantMemberId) {
		this.merchantMemberId = merchantMemberId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getHandlerStatus() {
		return handlerStatus;
	}

	protected void setHandlerStatus(int handlerStatus) {
		this.handlerStatus = handlerStatus;
	}

	public Long getBizId() {
		return bizId;
	}

	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	public int getOpType() {
		return opType;
	}
	    // 申请额度
		private BigDecimal applyLimit;
		// 申请原因
		private String applyCause;
		// 附件材料地址
		private String attachment;
		// 结果说明
		private String auditDesc;
		// 审核结果
		private String auditResult;
		// 审批通过额度字段
		private BigDecimal auditLimit;
		//代理商类型
		private String mcType;
		public BigDecimal getApplyLimit() {
			return applyLimit;
		}

		public void setApplyLimit(BigDecimal applyLimit) {
			this.applyLimit = applyLimit;
		}

		public String getApplyCause() {
			return applyCause;
		}

		public void setApplyCause(String applyCause) {
			this.applyCause = applyCause;
		}

		public String getAttachment() {
			return attachment;
		}

		public void setAttachment(String attachment) {
			this.attachment = attachment;
		}

		public String getAuditDesc() {
			return auditDesc;
		}

		public void setAuditDesc(String auditDesc) {
			this.auditDesc = auditDesc;
		}

		public String getAuditResult() {
			return auditResult;
		}

		public void setAuditResult(String auditResult) {
			this.auditResult = auditResult;
		}

		public BigDecimal getAuditLimit() {
			return auditLimit;
		}

		public void setAuditLimit(BigDecimal auditLimit) {
			this.auditLimit = auditLimit;
		}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Date getRedeemedTime() {
		return redeemedTime;
	}

	public void setRedeemedTime(Date redeemedTime) {
		this.redeemedTime = redeemedTime;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public LoaningTypeEnum getLoaningType() {
		return loaningType;
	}

	public void setLoaningType(LoaningTypeEnum loaningType) {
		this.loaningType = loaningType;
	}

	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public BigDecimal getPromoterMinMargin() {
		return promoterMinMargin;
	}

	public void setPromoterMinMargin(BigDecimal promoterMinMargin) {
		this.promoterMinMargin = promoterMinMargin;
	}

	public String getPromoterType() {
		return promoterType;
	}

	public void setPromoterType(String promoterType) {
		this.promoterType = promoterType;
	}
	
	
	

}
