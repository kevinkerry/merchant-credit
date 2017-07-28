package com.sdp.mc.ma.request.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.beanutils.BeanUtils;

import com.sdp.mc.ma.request.IRequest;

public class AbstractRequest implements IRequest {
	@NotNull
	protected RequestHeader header = new RequestHeader();
	@NotNull
	private Map<Object, Object> map = new HashMap<Object, Object>();

	@Override
	public Object getAttribute(Object key) {

		return map.get(key);
	}

	@Override
	public void setAttribute(Object key, Object value) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
		map.put(key, value);

	}

	public RequestHeader getHeader() {
		return header;
	}

	public void setHeader(RequestHeader header) {
		this.header = header;
	}

	public String toString() {
		try {
			Map<?, ?> props = BeanUtils.describe(this);
			Iterator<?> iProps = props.keySet().iterator();
			StringBuffer retBuffer = new StringBuffer();

			while (iProps.hasNext()) {
				String key = (String) iProps.next();

				// skip false property "class"
				if ("class".equals(key)) {
					continue;
				}

				retBuffer.append(key).append("=[").append(props.get(key)).append("]");

				if (iProps.hasNext()) {
					retBuffer.append(", ");
				}
			}

			return retBuffer.toString();
		} catch (Exception e) {
			return toString();
		}
	}

}
