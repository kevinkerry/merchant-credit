package com.shengpay.service.workcalendar;

import java.util.Date;
import java.util.List;

import com.sdp.withdraw.dao.WorkCalendarDO;

public interface WorkCalendarService {

	/**
	 * 是否满足节假日
	 * true:节假日  false：工作日
	 * @param time
	 * @return
	 */
	public boolean isHolidayTime(Date time);

	/**
	 * 根据WordDate查询
	 * @param beginDate
	 * @return
	 */
	List<WorkCalendarDO> findWorkTimelist(Date beginDate,Date endDate);
}
