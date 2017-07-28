package com.sdp.withdraw.dao.ext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OpLogRecordVO implements Serializable{

	private static final long serialVersionUID = -3127153225786890298L;
	private Long id;
    private Integer limitationType;
    private Long bizId;
    private Integer bizType;
    private BigDecimal limitation;
    private BigDecimal forzenLimitation;
    private BigDecimal usedLimitation;
    private Date createTime;
    private Date updateTime;
	private String beginTime;
	private String endTime;



	@Override
	public String toString() {
		String json = "{\"bizId\":\""+bizId+"\""
				+ ", \"bizType\":\"" + bizType+"\""
				+ ", \"id\":\"" + id +"\""
				+ ", \"limitationType\":\"" + limitationType +"\""
				+ ", \"limitation\":\"" + limitation +"\""
				+ ", \"forzenLimitation\":\"" + forzenLimitation +"\""
				+ ", \"usedLimitation\":\"" + usedLimitation +"\""
				+ ", \"createTime\":\"" + createTime +"\""
				+ ", \"updateTime\":\"" + updateTime +"\""
				+ ", \"beginTime\":\"" + beginTime +"\""
				+ ", \"endTime\":\"" + endTime +"\"" + "}";

		return json;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
}
