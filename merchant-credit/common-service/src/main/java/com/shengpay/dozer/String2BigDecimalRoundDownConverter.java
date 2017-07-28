package com.shengpay.dozer;

import java.math.BigDecimal;

import org.dozer.CustomConverter;

public class String2BigDecimalRoundDownConverter implements CustomConverter {

	private final int scale = 2;

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
		BigDecimal bigDecimal = null;
		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof String) {
				String val = (String) sourceFieldValue;
				bigDecimal = new BigDecimal(val);
			} else if (sourceFieldValue instanceof Integer) {
				Integer val = (Integer) sourceFieldValue;
				bigDecimal = new BigDecimal(val);
			} else if (sourceFieldValue instanceof BigDecimal) bigDecimal = (BigDecimal) sourceFieldValue;
			if(bigDecimal!=null)return bigDecimal.setScale(scale, BigDecimal.ROUND_DOWN);
		}
		return bigDecimal;
	}
}
