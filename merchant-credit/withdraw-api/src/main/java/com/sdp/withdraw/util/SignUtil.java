package com.sdp.withdraw.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Date;

public class SignUtil {
	public static String signOrderQueryRequest(byte[] signBytes) {
		try {
			MessageDigest msgDigest = MessageDigest.getInstance("MD5");
			msgDigest.update(signBytes);
			byte[] bytes = msgDigest.digest();
			String md5Str = new String(encodeHex(bytes));

			return md5Str;
		} catch (Exception e) {
		}
		return null;
	}

	public static char[] encodeHex(byte[] data) {
		char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int l = data.length;
		char[] out = new char[l << 1];
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}
		return out;
	}

	public static String testReflect(Object model) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sb = new StringBuffer();
		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			String name = field[j].getName(); // 获取属性的名字
			name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
			String type = field[j].getGenericType().toString(); // 获取属性的类型
			if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
				Method m = model.getClass().getMethod("get" + name);
				String value = (String) m.invoke(model); // 调用getter方法获取属性值
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.lang.Integer")) {
				Method m = model.getClass().getMethod("get" + name);
				Integer value = (Integer) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.lang.Short")) {
				Method m = model.getClass().getMethod("get" + name);
				Short value = (Short) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.lang.Double")) {
				Method m = model.getClass().getMethod("get" + name);
				Double value = (Double) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.lang.Boolean")) {
				Method m = model.getClass().getMethod("get" + name);
				Boolean value = (Boolean) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.util.Date")) {
				Method m = model.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}

			if (type.equals("class java.math.BigDecimal")) {
				Method m = model.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
			if (type.equals("class java.util.Map")) {
				Method m = model.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(model);
				if (value != null) {
					sb.append(value);
					sb.append("|");
				} else {
					sb.append("|");
				}
			}
		}
		return sb.toString();
	}

}
