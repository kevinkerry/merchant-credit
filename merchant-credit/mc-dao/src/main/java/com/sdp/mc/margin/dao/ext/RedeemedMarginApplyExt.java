package com.sdp.mc.margin.dao.ext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 保证金申请
 * 
 * @author wangmindong
 * 
 */
public class RedeemedMarginApplyExt extends MarginOpReqDOExt {

	/**
	 * 代理商会员id
	 */
	private String marginMemberId;
	/**
	 * 保证金金额
	 */
	private BigDecimal fastSettleMargin;

	/**
	 *放款人
	 */
	private String realName;
	
	/**
	 * 申请时间
	 */
	private Date applyTime;
	
	/**
	 * 放款时间
	 */
	private Date operaTime;

	public BigDecimal getFastSettleMargin() {
		return fastSettleMargin;
	}

	public void setFastSettleMargin(BigDecimal fastSettleMargin) {
		this.fastSettleMargin = fastSettleMargin;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getMarginMemberId() {
		return marginMemberId;
	}

	public void setMarginMemberId(String marginMemberId) {
		this.marginMemberId = marginMemberId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getOperaTime() {
		return operaTime;
	}

	public void setOperaTime(Date operaTime) {
		this.operaTime = operaTime;
	}

}
