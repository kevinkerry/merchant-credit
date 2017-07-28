package com.sdp.mc.service.dayhelp;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.service.api.McISholidayAPI;
import com.sdp.mc.common.enums.withdraw.WorkDayTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.withdraw.dao.WorkCalendarDO;
import com.sdp.withdraw.dao.WorkCalendarDOExample;
import com.sdp.withdraw.manager.WorkCalendarManager;

@Service("mcIsHolidayService")
public class McIsHolidayServiceImpl implements McISholidayAPI {

	private static final Logger logger = LoggerFactory.getLogger(McIsHolidayServiceImpl.class);

	@Autowired
	private WorkCalendarManager workCalendarManager;

	/**
	 * 是否为节假日 true节假日 false-工作日
	 */
	@Override
	public boolean isHolidayTime(Date time) {
		String dataStr = DateUtil.getCurrentDayStrFristTime(time);
		Date workDate = DateUtil.parseDate(dataStr, DateUtil.default_pattern);
		WorkCalendarDOExample example = new WorkCalendarDOExample();
		WorkCalendarDOExample.Criteria criteria = example.createCriteria();
		criteria.andWordDateEqualTo(workDate);
		List<WorkCalendarDO> list = workCalendarManager.selectByExample(example);
		if (list == null || list.isEmpty()) {
			logger.error("根据 [" + time + "] 查询是否是工作日为空");
			return false;
		}
		if (WorkDayTypeEnums.HOLIDAY.code == list.get(0).getIsHoliday()) {
			return true;
		} else if (WorkDayTypeEnums.UN_HOLIDAY.code == list.get(0).getIsHoliday()) { return false; }
		return false;
	}

	/**
	 * 节假日上一个工作日
	 * 
	 * @param time
	 * @return
	 */
	public Date lastWorkingDay(Date time) {
		Date workDate = DateUtil.increaseDate(time, -1);
		if (isHolidayTime(workDate)) {
			return lastWorkingDay(workDate);
		}
		return workDate;
	}

	/**
	 * 节假日下一个工作日
	 * 
	 * @param time
	 * @return
	 */
	public Date nextWorkingDay(Date time) {
		Date workDate = DateUtil.increaseDate(time, 1);
		if (isHolidayTime(workDate)) {
			return nextWorkingDay(workDate);
		}
		return workDate;
	}

}
