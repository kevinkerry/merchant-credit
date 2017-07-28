package com.mc.service.api;

import java.util.Date;


public interface McISholidayAPI {
	/**
	 * 是否为节假日（true为节假日，false为工作日）
	 * 
	 * @param time
	 * @return
	 */
	public abstract boolean isHolidayTime(Date time);

	/**
	 * 如果这个日期是节假日，查询出上一个工作日
	 * 
	 * @param flag
	 * @param time
	 * @return
	 */
	public abstract Date lastWorkingDay(Date time);

	/**
	 * 如果这个日期是节假日，查询出下一个工作日
	 * 
	 * @param flag
	 * @param time
	 * @return
	 */
	public abstract Date nextWorkingDay(Date time);
}
