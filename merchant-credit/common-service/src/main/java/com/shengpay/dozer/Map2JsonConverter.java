package com.shengpay.dozer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

import org.dozer.CustomConverter;

public class Map2JsonConverter implements CustomConverter {

	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {

		if (sourceFieldValue != null) {
			if (sourceFieldValue instanceof String) {
				String val = (String) sourceFieldValue;
				return parserToMap(val);
			} else if (sourceFieldValue instanceof Map) {
				String val = JSONObject.fromObject(sourceFieldValue).toString();
				return val;
			}
		}
		return sourceFieldValue;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map parserToMap(String s) {
		Map map = new HashMap();
		JSONObject json = JSONObject.fromObject(s);
		Iterator keys = json.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String value = json.get(key).toString();
			if (value.startsWith("{") && value.endsWith("}")) {
				map.put(key, parserToMap(value));
			} else {
				map.put(key, value);
			}
		}
		return map;
	}
}
