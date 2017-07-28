package com.sdp.mc.dataobjct;

import com.sdp.mc.newt0.dao.WhiteListInfoDO;

public class WhiteListInfoPO extends WhiteListInfoDO {

	private static final long serialVersionUID = 1L;
   
	private String workdayFees;
	
	private String holidayFees;
	
	private String contentLabel;
	
	private String createTimeStr;

	public String getWorkdayFees() {
		return workdayFees;
	}

	public void setWorkdayFees(String workdayFees) {
		this.workdayFees = workdayFees;
	}

	public String getHolidayFees() {
		return holidayFees;
	}

	public void setHolidayFees(String holidayFees) {
		this.holidayFees = holidayFees;
	}

	public String getContentLabel() {
		return contentLabel;
	}

	public void setContentLabel(String contentLabel) {
		this.contentLabel = contentLabel;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
	
	
	
	
	
}
