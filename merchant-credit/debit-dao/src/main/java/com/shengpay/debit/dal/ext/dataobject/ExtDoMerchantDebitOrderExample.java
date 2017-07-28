package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.emall.common.dao.QueryBase;

/**
 * 商户借款订单表分页查询条件
 *
 * @author wangjingao.william
 * **/
public class ExtDoMerchantDebitOrderExample extends QueryBase {

	private static final long serialVersionUID = 1L;
	/* 代理商号 */
	private String promoterNo;
	/* 代理商名称 */
	private String promoterName;
	/* 商户号 */
	private String merchantNo;
	/* 商户名称 */
	private String merchantName;
	/* 状态 */
	private String status;
	/* 状态 */
	private List<String> statusList;
	/* 申请时间 */
	private String startTimeStr;
	private String endTimeStr;
	/*状态 申请中/未到期/到期还款/逾期/逾期还款*/
	/** 借款开始时/结束 时间 ***/
	private String borrowStartTimeStr;
	private String borrowEndTimeStr;
	/** 还款开始/结束时间**/
	private String repaymentStartTimeStr;
	private String repaymentEndTimeStr;

	/* Y或者空 */
	private String queryExpiredFlag;

	//借款申请时间开始/结束
	private String applyTimeStr;
	private String applyTimeEnd;
	//借款到期时间开始/结束
	private String expireTimeStr;
	private String expireTimeEnd;

	private Long bizType;

	public String getRepaymentStartTimeStr() {
		return repaymentStartTimeStr;
	}

	public void setRepaymentStartTimeStr(String repaymentStartTimeStr) {
		this.repaymentStartTimeStr = repaymentStartTimeStr;
	}

	public String getRepaymentEndTimeStr() {
		return repaymentEndTimeStr;
	}

	public void setRepaymentEndTimeStr(String repaymentEndTimeStr) {
		this.repaymentEndTimeStr = repaymentEndTimeStr;
	}

	public String getBorrowStartTimeStr() {
		return borrowStartTimeStr;
	}

	public void setBorrowStartTimeStr(String borrowStartTimeStr) {
		this.borrowStartTimeStr = borrowStartTimeStr;
	}

	public String getBorrowEndTimeStr() {
		return borrowEndTimeStr;
	}

	public void setBorrowEndTimeStr(String borrowEndTimeStr) {
		this.borrowEndTimeStr = borrowEndTimeStr;
	}

	public String getPromoterNo() {
		return promoterNo;
	}

	public void setPromoterNo(String promoterNo) {
		this.promoterNo = promoterNo;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getQueryExpiredFlag() {
		return queryExpiredFlag;
	}

	public void setQueryExpiredFlag(String queryExpiredFlag) {
		this.queryExpiredFlag = queryExpiredFlag;
	}

	public String getApplyTimeStr() {
		return applyTimeStr;
	}

	public void setApplyTimeStr(String applyTimeStr) {
		this.applyTimeStr = applyTimeStr;
	}

	public String getApplyTimeEnd() {
		return applyTimeEnd;
	}

	public void setApplyTimeEnd(String applyTimeEnd) {
		this.applyTimeEnd = applyTimeEnd;
	}

	public String getExpireTimeStr() {
		return expireTimeStr;
	}

	public void setExpireTimeStr(String expireTimeStr) {
		this.expireTimeStr = expireTimeStr;
	}

	public String getExpireTimeEnd() {
		return expireTimeEnd;
	}

	public void setExpireTimeEnd(String expireTimeEnd) {
		this.expireTimeEnd = expireTimeEnd;
	}

    public Long getBizType() {
        return bizType;
    }

    public void setBizType(Long bizType) {
        this.bizType = bizType;
    }

}
