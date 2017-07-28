package com.sdp.mc.common.bean.newt0;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

/**
 * 商户类型
 * @author wangmindong
 *
 */
public class PmtMerchantType {

	private static final Logger logger = LoggerFactory.getLogger(PmtMerchantType.class);
	/**
	 * 1.垫资方属性
	 */
	private int loaingType;
	/**
	 * 2.工作日费率
	 */
	private String[] workdayFees;
	/**
	 * 3.非工作日费率
	 */
	private String[] holidayFees;
	/**
	 * 4.快速结算下限 盛付通全资:0.01 代理商全资：5000
	 */
	private BigDecimal floorAmt;

	/**
	 * 5.快速结算开始时间 9:00
	 */
	private String fsBeginTime;
	/**
	 * 6.快速结算结束时间 19:00 21:00
	 */
	private String fsEndTime;

	/**
	 * 商户类型 1：POS代理商 2：MPOS代理商
	 */
	private String mcType;
	/**
	 * 7.保证金杠杆
	 */
	private long minimumMargin;

	/**
	 * 8.保底保证金取回时间（天）
	 */
	private int minimumMarginRedeem;
	/**
	 * 9.浮动保证金取回时间（天）
	 */
	private int marginRedeem;

	/**
	 * 返回当日快速结算开始时间
	 *
	 * @return
	 */
	public Date findFsBeginDate() {
		if (StringUtils.isBlank(this.fsBeginTime)) {
			logger.error("LoningConfigBean fsBeginTime is null.");
			return new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String[] tmp = this.fsBeginTime.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmp[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(tmp[1]));
		return calendar.getTime();
	}

	/**
	 * 返回当日快速结算结束时间
	 *
	 * @return
	 */
	public Date findFsEndDate() {
		if (StringUtils.isBlank(this.fsEndTime)) {
			logger.error("LoningConfigBean fsBeginTime is null.");
			return new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String[] tmp = this.fsEndTime.split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tmp[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(tmp[1]));
		return calendar.getTime();
	}

	public static PmtMerchantType json2Bean(String json) {
		return (PmtMerchantType) JSONObject.toBean(JSONObject.fromObject(json), PmtMerchantType.class);
	}

	public static String bean2Json(PmtMerchantType bean) {
		return JSONObject.fromObject(bean).toString();
	}

	public String getMcType() {
		return mcType;
	}
	public void setMcType(String mcType) {
		this.mcType = mcType;
	}
	public long getMinimumMargin() {
		return minimumMargin;
	}
	public void setMinimumMargin(long minimumMargin) {
		this.minimumMargin = minimumMargin;
	}
	public int getMinimumMarginRedeem() {
		return minimumMarginRedeem;
	}
	public void setMinimumMarginRedeem(int minimumMarginRedeem) {
		this.minimumMarginRedeem = minimumMarginRedeem;
	}
	public int getMarginRedeem() {
		return marginRedeem;
	}
	public void setMarginRedeem(int marginRedeem) {
		this.marginRedeem = marginRedeem;
	}
	public int getLoaingType() {
		return loaingType;
	}
	public void setLoaingType(int loaingType) {
		this.loaingType = loaingType;
	}
	public String[] getWorkdayFees() {
		return workdayFees;
	}
	public void setWorkdayFees(String[] workdayFees) {
		this.workdayFees = workdayFees;
	}
	public String[] getHolidayFees() {
		return holidayFees;
	}
	public void setHolidayFees(String[] holidayFees) {
		this.holidayFees = holidayFees;
	}
	public BigDecimal getFloorAmt() {
		return floorAmt;
	}
	public void setFloorAmt(BigDecimal floorAmt) {
		this.floorAmt = floorAmt;
	}
	public String getFsBeginTime() {
		return fsBeginTime;
	}
	public void setFsBeginTime(String fsBeginTime) {
		this.fsBeginTime = fsBeginTime;
	}
	public String getFsEndTime() {
		return fsEndTime;
	}
	public void setFsEndTime(String fsEndTime) {
		this.fsEndTime = fsEndTime;
	}
}
