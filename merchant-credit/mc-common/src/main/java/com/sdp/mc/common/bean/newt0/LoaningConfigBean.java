package com.sdp.mc.common.bean.newt0;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;

public class LoaningConfigBean {

	private static Logger logger = LoggerFactory.getLogger(LoaningConfigBean.class);

	// private SimpleDateFormat dateFormat ;
	/**
	 * 1.垫资方属性 2.工作日费率 3.非工作日费率 4.保证金杠杆 5.保底保证金取回时间（天） 6.浮动保证金取回时间（天）7.快速结算下限
	 */

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
	 * 4.保证金杠杆
	 */
	private long minimumMargin;
	/**
	 * 5.保底保证金取回时间（天）
	 */
	private int minimumMarginRedeem;
	/**
	 * 6.浮动保证金取回时间（天）
	 */
	private int marginRedeem;
	/**
	 * 7.快速结算下限 盛付通全资:0.01 代理商全资：5000
	 */
	private BigDecimal floorAmt;

	/**
	 * 快速结算开始时间 9:00
	 */
	private String fsBeginTime;
	/**
	 * 快速结算结束时间 19:00 21:00
	 */
	private String fsEndTime;

	/**
	 * 商户类型
	 *
	 */
	private List<PmtMerchantType> ptmMerchantType;

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
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 快速结算开始时间 9:00
	 */
	public String getFsBeginTime() {
		return fsBeginTime;
	}

	public void setFsBeginTime(String fsBeginTime) {
		this.fsBeginTime = fsBeginTime;
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
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public String getFsEndTime() {
		return fsEndTime;
	}

	/**
	 * 快速结算结束时间 19:00 21:00
	 */
	public void setFsEndTime(String fsEndTime) {
		this.fsEndTime = fsEndTime;
	}

	public LoaningConfigBean() {
	}

	public LoaningConfigBean(int loaingType, String[] workdayFees, String[] holidayFees, long minimumMargin, int minimumMarginRedeem, int marginRedeem, BigDecimal floorAmt) {
		this.loaingType = loaingType;
		this.workdayFees = workdayFees;
		this.holidayFees = holidayFees;
		this.minimumMargin = minimumMargin;
		this.minimumMarginRedeem = minimumMarginRedeem;
		this.marginRedeem = marginRedeem;
		this.floorAmt = floorAmt;
	}

	public LoaningConfigBean(int loaingType, String[] workdayFees, String[] holidayFees, long minimumMargin, int minimumMarginRedeem, int marginRedeem, BigDecimal floorAmt, String fsBeginTime,
			String fsEndTime) {
		this.loaingType = loaingType;
		this.workdayFees = workdayFees;
		this.holidayFees = holidayFees;
		this.minimumMargin = minimumMargin;
		this.minimumMarginRedeem = minimumMarginRedeem;
		this.marginRedeem = marginRedeem;
		this.floorAmt = floorAmt;
		this.fsBeginTime = fsBeginTime;
		this.fsEndTime = fsEndTime;
	}

	/**
	 * 7.快速结算下限 盛付通全资:0.01 代理商全资：5000
	 *
	 * @return
	 */
	public BigDecimal getFloorAmt() {
		return floorAmt;
	}

	public void setFloorAmt(BigDecimal floorAmt) {
		this.floorAmt = floorAmt;
	}

	/**
	 * 1.垫资方属性
	 */
	public int getLoaingType() {
		return loaingType;
	}

	public void setLoaingType(int loaingType) {
		this.loaingType = loaingType;
	}

	/**
	 * 2.工作日费率
	 */
	public String[] getWorkdayFees() {
		return workdayFees;
	}

	public void setWorkdayFees(String[] workdayFees) {
		this.workdayFees = workdayFees;
	}

	/**
	 * 3.非工作日费率
	 */
	public String[] getHolidayFees() {
		return holidayFees;
	}

	public void setHolidayFees(String[] holidayFees) {
		this.holidayFees = holidayFees;
	}

	/**
	 * 4.保证金杠杆
	 */
	public long getMinimumMargin() {
		return minimumMargin;
	}

	public void setMinimumMargin(long minimumMargin) {
		this.minimumMargin = minimumMargin;
	}

	/**
	 * 5.保底保证金取回时间（天）
	 */
	public int getMinimumMarginRedeem() {
		return minimumMarginRedeem;
	}

	public void setMinimumMarginRedeem(int minimumMarginRedeem) {
		this.minimumMarginRedeem = minimumMarginRedeem;
	}

	/**
	 * 6.浮动保证金取回时间（天）
	 */
	public int getMarginRedeem() {
		return marginRedeem;
	}

	public void setMarginRedeem(int marginRedeem) {
		this.marginRedeem = marginRedeem;
	}

	public static LoaningConfigBean json2Bean(String json) {
		return (LoaningConfigBean) JSONObject.toBean(JSONObject.fromObject(json), LoaningConfigBean.class);
	}

	public static String bean2Json(LoaningConfigBean bean) {
		return JSONObject.fromObject(bean).toString();
	}

	public List<PmtMerchantType> getPtmMerchantType() {
		return ptmMerchantType;
	}

	public void setPtmMerchantType(List<PmtMerchantType> ptmMerchantType) {
		this.ptmMerchantType = ptmMerchantType;
	}

	public static void main(String[] args) {
		String[] s1 = new String[] { "0.002", "0.0025", "0.003" };
		String[] s2 = new String[] { "0.0025", "0.003", "0.003" };
		// SHENGPAY(1,"盛付通全资"),
		// PROMOTER(0,"代理商全资")
		/**
		 * 盛付通全资
		 */
		LoaningConfigBean bean = new LoaningConfigBean(0, s1, s2, 100000l, 2, 2, new BigDecimal("5000"), "9:00", "21:00");
		System.out.println(LoaningConfigBean.bean2Json(bean));
		System.out.println(LoaningConfigBean.json2Bean(LoaningConfigBean.bean2Json(bean)));

		String[] s3 = new String[] { "0.002", "0.001" };
		String[] s4 = new String[] { "0.0025", "0.005" };

		LoaningConfigBean bean1 = new LoaningConfigBean(1, s3, s4, 100000l, 30, 180, new BigDecimal("0.01"), "9:00", "19:00");
		System.out.println(LoaningConfigBean.bean2Json(bean1));
		System.out.println(LoaningConfigBean.json2Bean(LoaningConfigBean.bean2Json(bean)));

		String json = "{\"floorAmt\":0.01,\"holidayFees\":[\"0.0025\",\"0.003\",\"0.003\"],\"loaingType\":0,\"marginRedeem\":2,\"minimumMargin\":100000,\"minimumMarginRedeem\":2,\"workdayFees\":[\"0.002\",\"0.0025\",\"0.003\"],\"fsBeginTime\":\"9:00\",\"fsEndTime\":\"19:00\"}";
		System.out.println(LoaningConfigBean.json2Bean(json));
		System.out.println();
	}
}
