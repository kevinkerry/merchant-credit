package com.sdp.mc.common.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StringUtil {
	private static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	 /**
     * 使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
     *
     * @param content 字符串对象
     *
     * @param charset 编码方式
     *
     * @return 所得 byte 数组
     */
    public static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        }
        catch (UnsupportedEncodingException ex) {
            throw new IllegalArgumentException("Not support:" + charset, ex);
        }
    }
	/**
	 * 按字节截取字符串
	 *
	 * @param s
	 *            目标字符串
	 * @param byteLen
	 *            字节长度
	 * **/
	public static String subString(String s, int byteLen) {
		try {
			if(s.getBytes("gbk").length<=byteLen){
				return s;
			}
			byte[] b = s.getBytes("gbk");
			int count = 0, _count = 0;
			for (int i = 0; i < byteLen; i++) {
				if (b[i] < 0) {
					count++;
				} else {
					_count++;
				}
			}
			if (count % 2 != 0) {
				int totalCount = _count + (count - 1) / 2;
				return s.substring(0, totalCount);
			} else {
				int totalCount = _count + count / 2;
				return s.substring(0, totalCount);
			}
		} catch (Exception e) {
			throw new RuntimeException("com.sdp.mc.common.util.StringUtil.subString.error,msg=" + e.getMessage());
		}
	}
	/**
	 * 判断是否为金额
	 * @param str
	 * @return
	 */
	 public static boolean isAmountNumber(String str)
	   {
	       java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,3})?$"); // 判断小数点后2位的数字的正则表达式
	       java.util.regex.Matcher match=pattern.matcher(str);
	       if(match.matches()==false)
	       {
	          return false;
	       }
	       else
	       {
	          return true;
	       }
	   }
	 /**
	  * 四舍 五如
	  * @param srt 输入文件  digital  保留几位
	  * @return
	  */
	 public static BigDecimal bigScaleUP(String srt,int digital){
		 return new BigDecimal(srt).setScale(digital, BigDecimal.ROUND_HALF_UP);
	 }


	public static void main(String[] args) {
//		System.out.println(isAmountNumber("0.1"));
////		System.out.println("四舍五入取整:(2.58)=" + new BigDecimal("2.585").setScale(2, BigDecimal.ROUND_HALF_UP));
//		String s = "2016-08-29 12:00:00";
//		System.err.println(s.split(" ")[0]);
		System.out.println(isNumeric("2.0161E+11"));
	}
	public static boolean isNumeric(String str){
		   Pattern pattern = Pattern.compile("[0-9]*");
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false;
		   }
		   return true;
		}

	public static String formartDate2Str(String strDate) {
		if (StringUtils.isBlank(strDate)) {
			return "";
		}
		if (strDate.length()!=19) {
			return strDate;
		}
		return strDate.split(" ")[0];
	}
	/*
	 * 返回key1=value1&key2=value2字符串
	 */
	public static String joinUrlParams(Object obj){
		StringBuffer sb=new StringBuffer();
		Field[] fields=obj.getClass().getDeclaredFields();
		for(Field field:fields){
			
			if(Modifier.isStatic(field.getModifiers())){
				continue;
			}
			String val=null;
			try {
				val = BeanUtils.getProperty(obj, field.getName());
			} catch (Exception e) {
				log.error("StringUtil.joinUrlParams.error" + e.getMessage(),e);
			} 
			if(StringUtils.isNotBlank(val)){
				sb.append(field.getName()).append("=").append(val).append("&");
			}
		}
		if(sb.length()==0){
			return "";
		}
		sb.deleteCharAt(sb.lastIndexOf("&"));
		return sb.toString();
	}
}
