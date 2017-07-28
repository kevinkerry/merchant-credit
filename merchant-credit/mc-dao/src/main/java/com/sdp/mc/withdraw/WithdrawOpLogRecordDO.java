package com.sdp.mc.withdraw;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 操作记录DO
 * @author wangmindong
 * 2016年3月11日 14:54:42
 */
public class WithdrawOpLogRecordDO {
	/** 业务类型 **/
 	private String recordType;
 	/** C：CREATE；U：UPDATE；D：DELETE **/
    private String opType;
    /** 记录详情 **/
    private String opRecord;
    /** 额度类型 **/
    private Integer limitationType;
    /** 业务主见 **/
    private Long bizId;
    /** BizTypeEnums 业务类型 **/
    private Integer bizType;
    /** 总额度 **/
    private BigDecimal limitation;
    /** 冻结额度 **/
    private BigDecimal forzenLimitation;
    /** 已使用额度 **/
    private BigDecimal usedLimitation;
    /** 商户号 **/
    private String merchantNo;
    /** 商户类型 **/
    private String mcType;
    /** 开始时间 **/
    private String beginTime;
    /** 结束时间 **/
	private String endTime;

    private Date createTime;
    private Date updateTime;


	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public String getOpType() {
		return opType;
	}
	public void setOpType(String opType) {
		this.opType = opType;
	}
	public String getOpRecord() {
		return opRecord;
	}
	public void setOpRecord(String opRecord) {
		this.opRecord = opRecord;
	}
	public Integer getLimitationType() {
		return limitationType;
	}
	public void setLimitationType(Integer limitationType) {
		this.limitationType = limitationType;
	}
	public Long getBizId() {
		return bizId;
	}
	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}
	public Integer getBizType() {
		return bizType;
	}
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}
	public BigDecimal getLimitation() {
		return limitation;
	}
	public void setLimitation(BigDecimal limitation) {
		this.limitation = limitation;
	}
	public BigDecimal getForzenLimitation() {
		return forzenLimitation;
	}
	public void setForzenLimitation(BigDecimal forzenLimitation) {
		this.forzenLimitation = forzenLimitation;
	}
	public BigDecimal getUsedLimitation() {
		return usedLimitation;
	}
	public void setUsedLimitation(BigDecimal usedLimitation) {
		this.usedLimitation = usedLimitation;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMcType() {
		return mcType;
	}
	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
