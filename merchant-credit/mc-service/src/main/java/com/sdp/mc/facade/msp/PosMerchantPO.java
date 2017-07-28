package com.sdp.mc.facade.msp;

import com.sdp.mc.dao.readonly.posmerchant.PosMerchantCond;

/**
 * 后台查询Pos商户输入参数
 *
 * @author: wangiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public class PosMerchantPO extends PosMerchantCond {

	/**
	 * 快速结算最小值
	 */
	private String settleMinValue;
	/**
	 * 快速结算最大值
	 */
	private String settleMaxValue;
	
    /**
     * Mcc
     */
    private String mcc;

    /**
     * pos商户创建(起始)时间
     */
    private String createTimeStartStr;

    /**
     * pos商户创建(截止)时间
     */
    private String createTimeEndStr;

    public String getCreateTimeStartStr() {
        return createTimeStartStr;
    }

    public void setCreateTimeStartStr(String createTimeStartStr) {
        this.createTimeStartStr = createTimeStartStr;
    }

    public String getCreateTimeEndStr() {
        return createTimeEndStr;
    }

    public void setCreateTimeEndStr(String createTimeEndStr) {
        this.createTimeEndStr = createTimeEndStr;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

	public String getSettleMinValue() {
		return settleMinValue;
	}

	public void setSettleMinValue(String settleMinValue) {
		this.settleMinValue = settleMinValue;
	}

	public String getSettleMaxValue() {
		return settleMaxValue;
	}

	public void setSettleMaxValue(String settleMaxValue) {
		this.settleMaxValue = settleMaxValue;
	}
    
    
}
