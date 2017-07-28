package com.sdp.mc.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.sdo.common.lang.StringUtil;
import com.sdo.mas.common.api.common.enums.SignType;

@SuppressWarnings("unchecked")
public class JDKEnumUtil {
	private static final Logger logger            = LoggerFactory.getLogger(JDKEnumUtil.class);

    private static final String GET_METHOD_PREFIX = "get";
    private static String[]     enumPackages      = {
    	    "com.sdp.mc.common.enums.",
    	    "com.sdp.mc.integration.fos.enums."
    	};

    /**
     * 获取枚举类
     *
     * @param className
     * @return
     */
    public static Class<Enum<?>> getEnumClass(String className) {
        Class<Enum<?>> clazz = null;
        for (String enumPackage : enumPackages) {
            try {
                if (StringUtil.contains(className, ".")) {// 针对传全路径类名
                    clazz = (Class<Enum<?>>) Class.forName(className);
                    if (clazz != null && clazz.isInstance(Enum.class)) {
                        return clazz;
                    }
                } else {// 针对类名
                    clazz = (Class<Enum<?>>) Class.forName(enumPackage + className);
                    if (clazz != null && clazz.isInstance(Enum.class)) {
                        return clazz;
                    }
                }
            } catch (Exception e) {

            }
        }
        return clazz;
    }

    /**
     * 获取枚举列表
     *
     * @param <T>
     * @param className
     * @return
     */
    public static List<Enum<?>> getEnumList(String className) {
        Class<Enum<?>> clazz = getEnumClass(className);
        List<Enum<?>> enumList = new ArrayList<Enum<?>>();
        try {
            for (Enum<?> e : clazz.getEnumConstants()) {
                enumList.add(e);
            }
        } catch (Exception e) {
            logger.error("JDKEnumUtil.getEnumList.error",e);
        }
        return enumList;
    }

    /**
     * 通过枚举名称获取枚举
     *
     * @param className
     * @param name
     * @return
     */
	public static <T extends Enum<T>> T getByName(String className, String name) {
        Class<T> c = (Class<T>)getEnumClass(className);

        if (c != null) {
            try {
                return Enum.valueOf(c, name);
            } catch (Exception e) {
            	logger.error("JDKEnumUtil.getByName.error",e);
            }
        }

        return null;
    }

    /**
     * 根据枚举键值获取值
     *
     * @param className
     *            ENUM类名称
     * @param compareProperty
     *            比较属性名称
     * @param returnProperty
     *            返回属性名称
     * @param compareValue
     *            比较值
     * @return
     */
    public static Object getValueByKey(String className, String compareProperty,
                                       String returnProperty, Object compareValue) {
        if (compareValue == null) {
            return null;
        }

        Class<Enum<?>> enumClass = getEnumClass(className);
        if (enumClass == null) {
            return null;
        }

        for (Enum<?> enumValue : enumClass.getEnumConstants()) {
            if (compareValue.toString().equals(getEnumPropertyValue(enumValue, compareProperty).toString())) {//wuhaoxiang 2009.11.11
                return getEnumPropertyValue(enumValue, returnProperty);
            }
        }

        return null;
    }

    /**
     * 获取ENUM对象属性值
     *
     * @param enumValue
     *            ENUM对象
     * @param propertyName
     *            属性名称
     * @return
     */
    public static Object getEnumPropertyValue(Enum<?> enumValue, String propertyName) {
        Method propertyGetMethod = ReflectionUtils.findMethod(enumValue.getClass(),propertyGetMethodName(propertyName), new Class[] {});
        if (propertyGetMethod == null) {
            return null;
        }

        try {
            return propertyGetMethod.invoke(enumValue, new Object[] {});
        } catch (Exception e) {
        	logger.error("JDKEnumUtil.getEnumPropertyValue.error",e);
        }

        return null;
    }

    /**
     * 获取属性方法名
     *
     * @param propertyName
     * @return
     */
    private static String propertyGetMethodName(String propertyName) {
        return GET_METHOD_PREFIX + StringUtil.substring(propertyName, 0, 1).toUpperCase()
               + StringUtil.substring(propertyName, 1, propertyName.length());
    }

    public static void main(String[] args) {
        System.out.println(JDKEnumUtil.getByName(SignType.class.getName(), "RSA"));
    }
}
