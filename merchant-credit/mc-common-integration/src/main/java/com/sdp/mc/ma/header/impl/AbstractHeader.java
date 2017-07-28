package com.sdp.mc.ma.header.impl;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.sdp.mc.ma.header.IHeader;

/**
 * <p>
 * 抽象头信息
 * </p>
 * 
 * @author wangchanggeng
 * @version $Id: AbstractHeader.java, v 0.1 2010-12-20 下午09:55:07 wangchanggeng
 *          Exp $
 */
public class AbstractHeader implements IHeader {

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
