package com.sdp.mc.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成节假日SQL脚本类
 */
public class GenerateCalendarUtil {
	private static final Logger log = LoggerFactory.getLogger(GenerateCalendarUtil.class);
	
	private static List<String> holday = new ArrayList<String>();
	private static List<String> workDay = new ArrayList<String>();
	public static void main(String[] args) {
		try {
			holday.clear();
			workDay.clear();
			holday = holiday();
			workDay = workDay();
			List<String> list = getWeekends(2016);
			for (String dateStr : list) {
				sqlStr(dateStr);
			}
		} catch (Exception e) {
			log.error("GenerateCalendarUtil.error" + e.getMessage(), e);
		}
	}

	private static void sqlStr(String date) throws Exception{
		Thread.sleep(100);
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.parseDate(date, DateUtil.dateFormat2Format));
		int isHoliday = 0;
		int weekDay = DateUtil.dayForWeek(date);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			isHoliday = 1;
		}
		if(holday.contains(date)) {
			isHoliday = 1;
		}
		if(workDay.contains(date)) {
			isHoliday = 0;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO MCREDIT.FW_WORK_CALENDAR VALUES(MCREDIT.SEQ_FW_WORK_CALENDAR.NEXTVAL,TO_DATE('").append(date).append("','YYYY-MM-DD HH24:MI:SS'),").append(weekDay).append(",").append(isHoliday).append(",sysdate,sysdate)");
		if (isHoliday == 0){
			System.out.println(sql.toString());
		}else{
			System.err.println(sql.toString());
		}
	}

	private static List<String> holiday(){
		// ---------------插入节假日时间------------------
		List<String> holidayStr = new ArrayList<String>();
		//元旦
		holidayStr.add("2016-01-01");
		holidayStr.add("2016-01-02");
		holidayStr.add("2016-01-03");

		//春节
		holidayStr.add("2016-02-07");
		holidayStr.add("2016-02-08");
		holidayStr.add("2016-02-09");
		holidayStr.add("2016-02-10");
		holidayStr.add("2016-02-11");
		holidayStr.add("2016-02-12");
		holidayStr.add("2016-02-13");

		//清明节
		holidayStr.add("2016-04-02");
		holidayStr.add("2016-04-03");
		holidayStr.add("2016-04-04");

		//劳动节
		holidayStr.add("2016-04-30");
		holidayStr.add("2016-05-01");
		holidayStr.add("2016-05-02");

		//端午节
		holidayStr.add("2016-06-09");
		holidayStr.add("2016-06-10");
		holidayStr.add("2016-06-11");

		//中秋节
		holidayStr.add("2016-09-15");
		holidayStr.add("2016-09-16");
		holidayStr.add("2016-09-17");

		//国庆节
		holidayStr.add("2016-10-01");
		holidayStr.add("2016-10-02");
		holidayStr.add("2016-10-03");
		holidayStr.add("2016-10-04");
		holidayStr.add("2016-10-05");
		holidayStr.add("2016-10-06");
		holidayStr.add("2016-10-07");
		return holidayStr;
	}

	private static List<String> workDay(){
		// -------------- 剔除补班时间(周末需要补班的)---------------------
		List<String> workDayStr = new ArrayList<String>();

		//补班
		workDayStr.add("2016-02-06");
		workDayStr.add("2016-02-14");
		workDayStr.add("2016-06-12");
		workDayStr.add("2016-09-18");
		workDayStr.add("2016-10-08");
		workDayStr.add("2016-10-09");

		return workDayStr;

	}

	public static List<String> getWeekends(int year) {
		List<String> list = new ArrayList<String>();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(year, 0, 1);

		for (int day = 1; day <= cal.getActualMaximum(Calendar.DAY_OF_YEAR); day++) {
			cal.set(Calendar.DAY_OF_YEAR, day);

//			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
//			if (weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY) {
//				list.add(sdf.format(cal.getTime()));
//			}
			list.add(sdf.format(cal.getTime()));
		}
		return list;
	}

}