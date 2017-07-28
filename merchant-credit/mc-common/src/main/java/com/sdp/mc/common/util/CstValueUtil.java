package com.sdp.mc.common.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.shengpay.commons.core.constants.ConstantTag;
/**
 * 
 * @author zhangguoliang.burt
 * 获取被注解类的相关属性
 */
public class CstValueUtil {
	
	private static Logger logger = LoggerFactory.getLogger(CstValueUtil.class);
	
	/**
	 *  根据注解的类型，变量的值获取中文名称
	 * @param <T>
	 * @param clzz
	 * @param type
	 * @param value
	 * @return
	 */
	public static <T> String getChValue(Class<T> clzz,String type, String value) {
		Field[] fields = clzz.getFields();
		for (Field field : fields) {
			ConstantTag des = (ConstantTag) field.getAnnotation(ConstantTag.class);
			if (des.type().equalsIgnoreCase(type)) {
				try {
					if (field.get(field.getName()).toString().equals(value)) {
						return String.valueOf(des.name());
					}
				} catch (IllegalArgumentException e) {
					logger.error(String.format("Get chValue with type(%s) value (%s) with exception is %s", type,value,e));
					return "";
				} catch (IllegalAccessException e) {
					logger.error(String.format("Get chValue with type(%s) value (%s) with exception is %s", type,value,e));
					return "";
				}
			}
		}
		return "";
	}
	
	public static <T> Map<String,String> getValueChName(Class<T> clzz, String type){
		Map<String,String> map =  new HashMap<String,String>();
		Field[] fields = clzz.getFields();
		for (Field field : fields) {
			ConstantTag des = (ConstantTag) field.getAnnotation(ConstantTag.class);
			if (des.type().equalsIgnoreCase(type)) {
				try {
					map.put(field.get(field.getName()).toString(), String.valueOf(des.name()));
				} catch (IllegalArgumentException e) {
					logger.error(String.format("Get chValue with type(%s) with exception is %s", type,e));
				} catch (IllegalAccessException e) {
					logger.error(String.format("Get chValue with type(%s)  with exception is %s", type,e));
				}
			}else{
				break;
			}
		}
		return map;
	}
}
