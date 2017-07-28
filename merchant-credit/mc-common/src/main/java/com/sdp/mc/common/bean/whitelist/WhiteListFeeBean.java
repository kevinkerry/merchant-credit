package com.sdp.mc.common.bean.whitelist;

import net.sf.json.JSONObject;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

public class WhiteListFeeBean {

	private static Logger logger = LoggerFactory.getLogger(WhiteListFeeBean.class);

	// private SimpleDateFormat dateFormat ;
	/**
	 * 2.工作日费率 3.非工作日费率 
	 */

	
	/**
	 * 2.工作日费率
	 */
	private String[] workdayFees;
	/**
	 * 3.非工作日费率
	 */
	private String[] holidayFees;


	

	public WhiteListFeeBean() {
	}

	public WhiteListFeeBean( String[] workdayFees, String[] holidayFees) {
		this.workdayFees = workdayFees;
		this.holidayFees = holidayFees;
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

	

	public static WhiteListFeeBean json2Bean(String json) {
		return (WhiteListFeeBean) JSONObject.toBean(JSONObject.fromObject(json), WhiteListFeeBean.class);
	}

	public static String bean2Json(WhiteListFeeBean bean) {
		return JSONObject.fromObject(bean).toString();
	}

	

	public static void main(String[] args) {
		String[] s1 = new String[] { "0.002", "0.0025", "0.003" };
		String[] s2 = new String[] { "0.0025", "0.003", "0.003" };
		/**
		 * 盛付通全资
		 */
		WhiteListFeeBean bean = new WhiteListFeeBean(s1, s2);
		System.out.println(WhiteListFeeBean.bean2Json(bean));
		System.out.println(WhiteListFeeBean.json2Bean(WhiteListFeeBean.bean2Json(bean)));

		String[] s3 = new String[] { "0.002", "0.001" };
		String[] s4 = new String[] { "0.0025", "0.005" };

		WhiteListFeeBean bean1 = new WhiteListFeeBean(s3, s4);
		System.out.println(WhiteListFeeBean.bean2Json(bean1));
		System.out.println(WhiteListFeeBean.json2Bean(WhiteListFeeBean.bean2Json(bean)));

		String json = "{\"holidayFees\":[\"0.0025\",\"0.003\",\"0.003\"],\"workdayFees\":[\"0.002\",\"0.0025\",\"0.003\"]}";
		System.out.println(WhiteListFeeBean.json2Bean(json));
		System.out.println();
	}
}
