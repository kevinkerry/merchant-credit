package com.sdp.mc.dao.readonly.merchantsettle;

import java.math.BigDecimal;
import java.util.Date;

public class MerchantSettleEO {
	/**
	 * 主键
	 */
	private Long msId ;//	NUMBER(18)	N			
	/**
	 * 创建时间
	 */
	private Date msCreateTime;		
	/**
	 * 更新时间
	 */
	private Date msUpdateTime;		
	/**
	 * 版本号
	 */
	private Long msVersion;
	/**
	 * 商户号
	 */
	private String msMerchantNo;		
	/**
	 * 是否依赖POS发起结算请求(1:是,0:否)
	 */
	private Long msTerminalSettleFlag;
	/**
	 * 是否支持快速结算
	 */
	private Integer fastSettleFlag;
	
	/**
	 * 快速额度
	 */
	private BigDecimal fastSettleLimit;
	
	/**
	 * POS商户号
	 */
	private Long posMerchantNo;
	
	private BigDecimal fastSettleMinLimit;
	
	/**
	   * 工作日快速提现费率
	   */
	   private String msWorkdayWithdrawFee;
	   
	   /**
	   * 非工作日快速提现费率
	   */
	   private String msHolidayWithdrawFee;
	   

	   /**
	   * 是否自动快速结算(0:否，1:是)
	   * @return
	   */
	   private Integer msAutoFastSettleFlg;

	   /**
	    * 商户手机号
	    */
	   private String msMerchantPhone;
	
	public Long getPosMerchantNo() {
		return posMerchantNo;
	}

	public void setPosMerchantNo(Long posMerchantNo) {
		this.posMerchantNo = posMerchantNo;
	}

	public MerchantSettleEO(){}
		
	public Integer getFastSettleFlag() {
		return fastSettleFlag;
	}
	public void setFastSettleFlag(Integer fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}
	public BigDecimal getFastSettleLimit() {
		return fastSettleLimit;
	}

	public void setFastSettleLimit(BigDecimal fastSettleLimit) {
		this.fastSettleLimit = fastSettleLimit;
	}
	public Long getMsId() {
		return msId;
	}
	public void setMsId(Long msId) {
		this.msId = msId;
	}
	public Date getMsCreateTime() {
		return msCreateTime;
	}
	public void setMsCreateTime(Date msCreateTime) {
		this.msCreateTime = msCreateTime;
	}
	public Date getMsUpdateTime() {
		return msUpdateTime;
	}
	public void setMsUpdateTime(Date msUpdateTime) {
		this.msUpdateTime = msUpdateTime;
	}
	public Long getMsVersion() {
		return msVersion;
	}
	public void setMsVersion(Long msVersion) {
		this.msVersion = msVersion;
	}
	public String getMsMerchantNo() {
		return msMerchantNo;
	}
	public void setMsMerchantNo(String msMerchantNo) {
		this.msMerchantNo = msMerchantNo;
	}
	public Long getMsTerminalSettleFlag() {
		return msTerminalSettleFlag;
	}
	public void setMsTerminalSettleFlag(Long msTerminalSettleFlag) {
		this.msTerminalSettleFlag = msTerminalSettleFlag;
	}



	public BigDecimal getFastSettleMinLimit() {
		return fastSettleMinLimit;
	}



	public void setFastSettleMinLimit(BigDecimal fastSettleMinLimit) {
		this.fastSettleMinLimit = fastSettleMinLimit;
	}

	public String getMsWorkdayWithdrawFee() {
		return msWorkdayWithdrawFee;
	}

	public void setMsWorkdayWithdrawFee(String msWorkdayWithdrawFee) {
		this.msWorkdayWithdrawFee = msWorkdayWithdrawFee;
	}

	public String getMsHolidayWithdrawFee() {
		return msHolidayWithdrawFee;
	}

	public void setMsHolidayWithdrawFee(String msHolidayWithdrawFee) {
		this.msHolidayWithdrawFee = msHolidayWithdrawFee;
	}

	public Integer getMsAutoFastSettleFlg() {
		return msAutoFastSettleFlg;
	}

	public void setMsAutoFastSettleFlg(Integer msAutoFastSettleFlg) {
		this.msAutoFastSettleFlg = msAutoFastSettleFlg;
	}

	public String getMsMerchantPhone() {
		return msMerchantPhone;
	}

	public void setMsMerchantPhone(String msMerchantPhone) {
		this.msMerchantPhone = msMerchantPhone;
	}
	
}
