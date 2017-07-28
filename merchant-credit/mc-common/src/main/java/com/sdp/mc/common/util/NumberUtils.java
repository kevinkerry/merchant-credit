package com.sdp.mc.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

/**
 * 数字、金额工具类
 * 
 * @author xuhongbiao.darren
 * @date 2013-7-29 上午10:55:14
 * 
 */
public final class NumberUtils {

	public static final String DECIMAL_PATTERN = "0.00";

	/**
	 * double类型格式化
	 * 
	 * @param number
	 *            double类型数据
	 * @param pattern
	 *            格式，例如："0.00"
	 * @return
	 */
	public static String doubleFormat(double number, String pattern) {
		return new DecimalFormat(pattern).format(number);
	}

	/**
	 * double类型格式化，指定格式："0.00"
	 * 
	 * @param number
	 *            double类型数据
	 * @return
	 */
	public static String doubleFormat(double number) {
		return doubleFormat(number, DECIMAL_PATTERN);
	}

	/**
	 * 两个及多个BigDecimal 相加,相加完成后在四舍五入，保留两位小数
	 * **/
	public static BigDecimal add(BigDecimal... bigDecimals) {
		BigDecimal total = BigDecimal.valueOf(0);
		for (BigDecimal bigDecimal : bigDecimals) {
			if (bigDecimal != null) {
				total = total.add(bigDecimal);
			}
		}
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 格式化BigDecimal，保留两位小数
	 * **/
	public static String format(BigDecimal number) {
		if (number == null) {
			return null;
		}
		return number.setScale(2, BigDecimal.ROUND_FLOOR).toPlainString();
	}

	public static String formatWithComma(Object number) {
		if (number == null) {
			return null;
		}
		if (number instanceof BigDecimal)
			return MessageFormat.format("{0}", ((BigDecimal) number).setScale(2, BigDecimal.ROUND_FLOOR));
		else if (number instanceof String)
			return MessageFormat.format("{0}", new BigDecimal((String) number).setScale(2, BigDecimal.ROUND_FLOOR));
		else
			return MessageFormat.format("{0}", number);
		// DecimalFormat df2 = new DecimalFormat("#.#");
		// return df2.format(number);
	}

	/**
	 * 转换金额单位(分)到(元)，四舍五入精确到分
	 * 
	 * @param amount
	 *            以分为单位的金额
	 * @return
	 */
	public static BigDecimal convertFen2Yuan(long amount) {
		return new BigDecimal(amount).movePointLeft(2).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 转换金额单位(元)到(分)，四舍五入精确到分
	 * 
	 * @param amount
	 *            以元为单位的金额
	 * @return
	 * @throws NumberFormatException
	 *             金额格式错误
	 */
	public static long convertYuan2Fen(String amount) {
		return new BigDecimal(amount).movePointRight(2).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
	}

	/**
	 * 乘以1000得到计算用钱值，四舍五入精确到厘
	 * 
	 * @param money
	 *            以元为单位的金额
	 * @return
	 * @throws NumberFormatException
	 *             金额格式错误
	 */
	public static long multiply1000(String money) {
		return new BigDecimal(money).movePointRight(3).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
	}

	/**
	 * 除1000得到真实钱值，四舍五入精确到厘
	 * 
	 * @param money
	 *            以厘为单位的金额
	 * @return
	 */
	public static BigDecimal divide1000(long money) {
		return new BigDecimal(money).movePointLeft(3).setScale(3, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 除1000得到真实钱值，四舍五入精确到厘
	 * 
	 * @param money
	 * @return
	 */
	public static BigDecimal divide1000(String money) {
		return new BigDecimal(money).movePointLeft(3).setScale(3, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 除1000得到真实钱值，四舍五入精确到厘
	 * 
	 * @param money
	 *            以厘为单位的金额
	 * @return
	 */
	public static BigDecimal divide1000ToFloor(long money) {
		return new BigDecimal(money).movePointLeft(3).setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * 除1000得到真实钱值，四舍五入精确到厘
	 * 
	 * @param money
	 *            以厘为单位的金额
	 * @return
	 */
	public static BigDecimal divide1000ToCeil(long money) {
		return new BigDecimal(money).movePointLeft(3).setScale(2, BigDecimal.ROUND_UP);
	}

	/**
	 * 组合计算：C(n, m)
	 * 
	 * @param n
	 *            总共可供选择的个数
	 * @param m
	 *            目标选择的个数
	 * @return 从n个可供选择的数中选择k个数，有多少种不同的组合方式
	 * @throws 如果组合的选择数m小于0或大于总数n
	 */
	public static long combination(int n, int m) {
		if (m < 0 || m > n) {
			throw new IllegalArgumentException("组合的选择数(" + m + ")不能小于0或大于总数(" + n + ")");
		}
		if (m == 0 || m == n) {
			return 1L;
		}

		if (2 * m > n) {
			m = n - m;
		}

		long result = 1;
		long factor = 1;
		for (int i = m, k = n; i > 0; i--, k--) {
			result *= k;
			factor *= i;
		}

		return result / factor; // 组合计算不会出现小数，所以此处除法肯定能够整除
	}

	/**
	 * 截取,如3.456,保留2位小数,结果是3.45
	 * **/
	public static String truncate(double num, int scale) {
		BigDecimal dd = BigDecimal.valueOf(num);
		return dd.setScale(scale, BigDecimal.ROUND_DOWN).toPlainString();
	}

	/**
	 * String转换为Long
	 * 
	 * @param str
	 * @return
	 */
	public static Long stringToLong(String str) {
		Long value = null;
		if (str != null && str.length() > 0) {
			value = Long.valueOf(str);
		}
		return value;
	}

	public static Integer string2Integer(String number) {
		if (number == null || "".endsWith(number.trim())) {
			return 0;
		}
		if (number.indexOf("+") >= 0) {
			return Integer.valueOf(number.substring(1));
		}
		if (number.indexOf("-") >= 0) {
			return Integer.valueOf(number);
		}
		return Integer.valueOf(number);
	}

	/**
	 * 
	 * 判断是否是数字
	 * ***/
	public static boolean isNumber(String number) {
		try {
			Float.parseFloat(number);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 乘以100得出百分比值
	 */
	public static String multiply100(String money) {
		if (StringUtils.isBlank(money)) {
			return null;
		}
		return new BigDecimal(money).movePointRight(2).toString();
	}
	/**
	 * 乘以100得出百分比值
	 */
	public static String bigDecimalMultiply100(BigDecimal money) {
		if (money==null) {
			return null;
		}
		return money.movePointRight(2).toString();
	}
}
