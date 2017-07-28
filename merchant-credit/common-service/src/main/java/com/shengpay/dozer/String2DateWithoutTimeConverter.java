package com.shengpay.dozer;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.CustomConverter;

public class String2DateWithoutTimeConverter implements CustomConverter {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public final static String dateFormat1 = "yyyy/MM/dd";

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		BigDecimal bigDecimal = null;
		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof Date) {
				return new SimpleDateFormat(dateFormat1).format(sourceFieldValue);
			} else {
				try {
					return new SimpleDateFormat(dateFormat1).parse((String) sourceFieldValue);
				} catch (ParseException e) {
					return null;
				}
			}
		}
		return bigDecimal;
	}
}
