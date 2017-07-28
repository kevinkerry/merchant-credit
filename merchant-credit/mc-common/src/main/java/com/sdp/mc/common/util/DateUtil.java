package com.sdp.mc.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DateUtil {
	private static Logger log = LoggerFactory.getLogger(DateUtil.class);
	
	public static final String default_pattern = "yyyy-MM-dd HH:mm:ss";
	public static final String date_pattern = "yyyy-MM-dd";
	public static final String date_pattern_begin = " 00:00:00";
	public static final String date_pattern_end = " 23:59:59";
	public final static String  monthFormat = "yyyy-MM";
	/**
	 * yyyy/MM/dd
	 */
	public static final SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
	/**
	 * yyyy-MM-dd
	 */
	public static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * yyyyMMdd
	 */
	public static final SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd");

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final SimpleDateFormat fosOrderFormat = new SimpleDateFormat("yyyyMMddHHmmss");

	public static final SimpleDateFormat mothFormat = new SimpleDateFormat("yyyy-MM");
	public static final String dateFormat5 = "yyyy/MM/dd HH:mm";
	/**
	 * yyyyMMddHHmmss
	 */
	public static String forOrderFormat = "yyyyMMddHHmmss";
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String dateFormat4Format = "yyyy-MM-dd HH:mm:ss";
	/**
	 * yyyy-MM-dd
	 */
	public static String dateFormat2Format = "yyyy-MM-dd";

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static String dateFormat5Format = "yyyy-MM-dd HH:mm";

	/**
	 * yyyy-M-dd HH:mm
	 */
	public static String dateFormat6Format = "yyyy-M-dd HH:mm";
	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static String dateFormat7Format = "yyyy-MM-dd HH:mm:ss.SSS";

	public static String date2Str(Date date, SimpleDateFormat format) {
		return format.format(date);
	}

	public static String date2Str(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 返回 yyyy-MM-dd 格式
	 *
	 * @param date
	 * @return
	 */
	public static String date2DateStr(Date date) {
		return dateFormat2.format(date);
	}

	public static String date1DateStr(String dateStr) {
		return dateFormat1.format(dateStr);
	}

	/**
	 * 生成传入时间的 凌晨时间，yyyy-MM-dd 00:00:00
	 *
	 * @param date
	 * @return
	 */
	public static Date generateDawnTimeStamp(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		// System.out.println(dateFormat4.format(calendar.getTime()));
		return calendar.getTime();
	}

	/**
	 * 生成传入时间的 午夜时间，yyyy-MM-dd 23:59:59
	 *
	 * @param date
	 * @return
	 */
	public static Date generateMidnightTimeStamp(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		// System.out.println(dateFormat4.format(calendar.getTime()));
		return calendar.getTime();
	}

	/**
	 * 获取当天是星期几
	 *
	 * @return
	 */
	public static int getToday2Week(Date time) {
		Calendar now = Calendar.getInstance();
		now.setTime(time);
		boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
		int weekDay = now.get(Calendar.DAY_OF_WEEK);
		if (isFirstSunday) {
			weekDay = weekDay - 1;
			if (weekDay == 0) {
				weekDay = 7;
			}
		}
		return weekDay;

	}

	public static String getDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	
	public static String getStringTime(String str) {
		String strDate = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(str);
			strDate = dateFormat.format(date);
		} catch (ParseException e) {
			return null;
		}
		return strDate;
	}

	/**
	 * 获取特定时间
	 *
	 * @param date
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date getSpecialDate(Date date, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取特定时间
	 *
	 * @param date
	 * @return
	 */
	public static Date formatWithNoTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 是否有效
	 *
	 * @param requestTime
	 *            请求时间
	 * @param effectTime
	 *            生效时间
	 * @param expiredTime
	 *            失效时间
	 * @return
	 */
	public static boolean isValidate(Date requestTime, Date effectTime, Date expiredTime) {
		if (requestTime == null || effectTime == null || expiredTime == null) { return false; }
		return effectTime.compareTo(requestTime) <= 0 && expiredTime.compareTo(requestTime) >= 0;
	}

	public static Date str2Date(String sDate) {
		Date d = null;
		try {
			d = new SimpleDateFormat(dateFormat4Format).parse(sDate);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}

	public static String dateFormat4(Date date){
		return dateFormat4.format(date);
	}

	public static Date parse2Date(String sDate) {
		Date d = null;
		try {
			d = new SimpleDateFormat(dateFormat2Format).parse(sDate);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}
	
	public static String parse2StringFormatString(String sDate) {
		String str = "";
		try {
			str = dateFormat3.format(new SimpleDateFormat(dateFormat2Format).parse(sDate));
		} catch (ParseException ex) {
			return null;
		}
		return str;
	}

	public static Date parse1Date(String sDate) {
		Date d = null;
		try {
			d = dateFormat1.parse(sDate);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}
	/**
	 * 参数  yyyy-MM-dd HH:mm
	 * @param str yyyy-MM-dd HH:mm
	 * @return
	 */
	public static Date parse2DateFormat5Date(String str){
		Date d = null;
		try {
			d = new SimpleDateFormat(dateFormat5Format).parse(str);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}
	/**
	 * 参数  yyyy-MM-dd HH:mm:ss.SSS
	 * @param str  yyyy-MM-dd HH:mm:ss.SSS
	 * @return
	 */
	public static Date parse2DateFormat7Date(String str){
		Date d = null;
		try {
			d = new SimpleDateFormat(dateFormat7Format).parse(str);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}
	/**
	 * 加减天数
	 */
	public static final Date increaseDate(Date aDate, int days) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(aDate);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 加减月份
	 *
	 * @param aDate
	 * @param cnt
	 * @return
	 */
	public static final Date increaseMonthDate(Date aDate, int cnt) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(aDate);
		cal.add(Calendar.MONTH, cnt);
		return cal.getTime();
	}

	/**
	 * 计算目标日期与当前时间之间的天数
	 * **/
	public static int daysBetween(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long time1 = cal.getTimeInMillis();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date());
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		long time2 = cal2.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	public static final Date increaseYearDate(Date aDate, int cnt) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(aDate);
		cal.add(Calendar.YEAR, cnt);
		return cal.getTime();
	}
	public static String datefosOrderFormat(Date date){
        return fosOrderFormat.format(date);
    }

	/**
	 * 计算两个日期之间相差的天数
	 *
	 * @param smdate 较小的时间
	 * @param bdate 较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (Exception e) {
			log.error("DateUtil.daysBetween.error" + e.getMessage(), e);
			return 0;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}


	/**
	 * 得到当前时间指定月数前后的开始时间
	 * @param month	月数，正数则为之后，负数为之前
	 * @return
	 */
	public static Date getBeginTimeOfMonth(int month){
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MONTH, month);
		time.set(Calendar.DAY_OF_MONTH, 1);
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		time.set(Calendar.MILLISECOND, 0);

		return time.getTime();
	}

	/**
	 * 得到当前时间指定月数前后的结束时间
	 * @param month	月数，正数则为之后，负数为之前
	 * @return
	 */
	public static Date getEndTimeOfMonth(int month){
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MONTH, month+1);
		time.set(Calendar.DAY_OF_MONTH, 1);
		time.set(Calendar.HOUR_OF_DAY, 23);
		time.set(Calendar.MINUTE, 59);
		time.set(Calendar.SECOND, 59);
		time.set(Calendar.MILLISECOND, 999);
		time.add(Calendar.DATE, -1);
		return time.getTime();
	}
	/**
	 * 比较时间
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	public static  int compareDate(Date dt1,Date dt2){
        if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {//相等
            return 0;
        }
	}
	public static void main(String[] args) throws ParseException {

		String datestr="2016/11/14 10:44:00";
		//System.out.println(compareDate(new Date("2016/11/14 10:44"), new Date("2016/11/14 10:44:00")));
		
		/*System.out.println(daysBetween(DateUtil.parse2Date("2017-01-24")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-25")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-26")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-27")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-28")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-29")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-30")));
		System.out.println(daysBetween(DateUtil.parse2Date("2017-01-31")));*/
		System.out.println(dateFormat4(getMothFirstDay(-1)));
		System.out.println(dateFormat4(getMothFirstDay(-2)));
		System.out.println(dateFormat4(getMothFirstDay(-3)));
		System.out.println(dateFormat4(getMothFirstDay(-4)));
		System.out.println(dateFormat4(getMothFirstDay(-12)));
		System.out.println(dateFormat4(getMothFirstDay(-13)));
		System.out.println(dateFormat4(getMothFirstDay(-25)));
		System.out.println(dateFormat4(getMothLastDay(-1)));
		System.out.println(dateFormat4(getMothLastDay(-2)));
		System.out.println(dateFormat4(getMothLastDay(-3)));
		System.out.println(dateFormat4(getMothLastDay(-4)));
		System.out.println(dateFormat4(getMothLastDay(-12)));
		System.out.println(dateFormat4(getMothLastDay(-13)));
		System.out.println(dateFormat4(getMothLastDay(-25)));
		

	}
	/**
	 * 得到传入日期的天最开始时间0时0分0秒。
	 *
	 * @param date
	 * @return
	 */
	public static String getCurrentDayStrFristTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return formatDate(c.getTime(), date_pattern + date_pattern_begin);
	}

	/**
	 * 得到传入日期的天最开始时间23时59分59秒。
	 *
	 * @param date
	 * @return
	 */
	public static String getCurrentDayStrEndTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return formatDate(c.getTime(), date_pattern + date_pattern_end);
	}

	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String getCurrentDayStr(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return formatDate(c.getTime(), date_pattern);
	}

	public static String formatDate(Date date, String pattern) {
		if (null == date)
			return null;
		if (StringUtils.isBlank(pattern))
			return null;
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}
	public static Date parseDate(String dates, String pattern) {
		if (StringUtils.isBlank(dates))
			return null;
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(dates);
		} catch (ParseException e) {
			log.error("DateUtil.formatDate.error" + e.getMessage(), e);
		}
		return null;
	}


	/**
	 *  判断日期是否跨天 true:跨天 false：不跨天
	 * @param begin
	 * @param end
	 * @return true:跨天
	 * @throws ParseException
	 */
	public static boolean whetherEveryDay(Date begin,Date end){
		int day = daysBetween(begin, end) >=1 ? 1 : 0;
		if (day==0){
			return false;
		}else if (day==1) {
			return true;
		}
		return false;
	}
	/**
	 * 日期转时间 再转date
	 * @param dates
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(Date dates, String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			String  dateStr=dateFormat.format(dates);
			return dateFormat.parse(dateStr);
		} catch (ParseException e) {
			log.error("DateUtil.parseDate.error" + e.getMessage(), e);
		}
		return null;
	}

	public static String convertDate(String date, String format1, String format2) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		SimpleDateFormat fmt1 = new SimpleDateFormat(format1);
		SimpleDateFormat fmt2 = new SimpleDateFormat(format2);
		String rtnStr = null;
		try {
			Date d = fmt1.parse(date);
			rtnStr = fmt2.format(d);
		} catch (Exception e) {
			log.error("DateUtil.convertDate.error" + e.getMessage(), e);
		}
		return rtnStr;
	}
	/**
     * 判断当前日期是星期几
     * @param pTime 修要判断的时间
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
	 public static int dayForWeek(String pTime) throws Exception {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  Calendar c = Calendar.getInstance();
		  c.setTime(format.parse(pTime));
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
			  dayForWeek = 7;
		  }else{
			  dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  }
		  return dayForWeek;
	 }
	 /**
	  * 获取自然月最后一天
	  * @return
	  */
	 public static Date getMonthMaxDate(){
		 // 获取Calendar
	        Calendar calendar = Calendar.getInstance();
	        // 设置时间,当前时间不用设置
	        // calendar.setTime(new Date());
	        // 设置日期为本月最大日期
	        calendar.set(Calendar.HOUR_OF_DAY, 23);
	        calendar.set(Calendar.MINUTE, 59);
	        calendar.set(Calendar.SECOND, 59);
	        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
	        return calendar.getTime();
	 }
	 /**
	  * 获取自然月第一天
	  * @return
	  */
	 public static Date getMonthMinDate(){
		 // 获取Calendar
	        Calendar calendar = Calendar.getInstance();
	        // 设置时间,当前时间不用设置
	        // calendar.setTime(new Date());
	        // 设置日期为本月最大日期
	        calendar.set(Calendar.HOUR_OF_DAY, 00);
	        calendar.set(Calendar.MINUTE, 00);
	        calendar.set(Calendar.SECOND, 00);
	        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
	        return calendar.getTime();
	 }

	 /**
	  * 取某月第一天 00:00:00
	  * @param date
	  * @param moth
	  * @return
	  */
	 public static Date getMothFirstDay(int moth) {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.set(Calendar.HOUR_OF_DAY, 00);
		cal_1.set(Calendar.MINUTE, 00);
		cal_1.set(Calendar.SECOND, 00);
		cal_1.set(Calendar.MILLISECOND, 000);
		cal_1.add(Calendar.MONTH, moth);
		cal_1.getActualMinimum(Calendar.DATE);
		cal_1.set(Calendar.DATE, cal_1.getActualMinimum(Calendar.DATE));
		return cal_1.getTime();
	}
	 /**
	  * 取某月的最后一天 59:59:59
	  * @return
	  */
	public static Date getMothLastDay(int moth) {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.set(Calendar.HOUR_OF_DAY, 23);
		cal_1.set(Calendar.MINUTE, 59);
		cal_1.set(Calendar.SECOND, 59);
		cal_1.set(Calendar.MILLISECOND, 999);
		cal_1.add(Calendar.MONTH, moth);
		cal_1.set(Calendar.DATE, cal_1.getActualMaximum(Calendar.DATE));
		return cal_1.getTime();
	}

	/**
	 * 取 月份的第一天 00:00:00
	 * @param moth
	 * @return
	 */
	public static Date formartMoth2MothFirstDay(String moth) {
		Date d = null;
		try {
			d = new SimpleDateFormat(monthFormat).parse(moth);
		} catch (ParseException ex) {
			return null;
		}
		return d;
	}

	/**
	 * 根据月份第一天取月份最后一天 23:59:59
	 * @param firstDay
	 * @return
	 */
	public static Date getLastDayFromMothFirstDay(Date firstDay) {
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.setTime(firstDay);
		cal_1.set(Calendar.HOUR_OF_DAY, 23);
		cal_1.set(Calendar.MINUTE, 59);
		cal_1.set(Calendar.SECOND, 59);
		cal_1.set(Calendar.DATE, cal_1.getActualMaximum(Calendar.DATE));
		cal_1.getActualMinimum(Calendar.DATE);
		return cal_1.getTime();
	}


	/**
	 * 比较当前日期和生效失效日期是否有交叉
	 * @param current
	 * @param expireTime 失效日期
	 * @return true:有交叉 false:无交叉
	 */
	public static boolean isCrossBetweenTime(Date current , Date expireTime) {
		Date cureentDay = parseDateNewFormat(dateFormat4(current));
		if (expireTime==null) {
			return true;
		}
		if (expireTime.compareTo(cureentDay)>0) {
			return true;
		}
		return false;
	}

	 public static Date parseDateNewFormat(String sDate) {
	        DateFormat dateFormat = new SimpleDateFormat(default_pattern);
	        Date d = null;
	        if ((sDate != null) && (sDate.length() == default_pattern.length())) {
	            try {
	                d = dateFormat.parse(sDate);
	            } catch (ParseException ex) {
	                return null;
	            }
	        }
	        return d;
	    }

	 
	
}
