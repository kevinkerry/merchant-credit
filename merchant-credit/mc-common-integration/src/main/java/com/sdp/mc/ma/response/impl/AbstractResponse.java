package com.sdp.mc.ma.response.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.sdp.mc.ma.response.IResponse;

/**
 * <p>响应抽象类</p>
 * @author wangchanggeng
 * @version $Id: AbstractResponse.java, v 0.1 2010-12-20 下午09:16:01 wangchanggeng Exp $
 */
@SuppressWarnings("rawtypes")
public class AbstractResponse implements IResponse {
    protected ResponseHeader response = new ResponseHeader();

    private Map              map    = new HashMap();

    @Override
    public Object getAttribute(Object key) {

        return map.get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setAttribute(Object key, Object value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);

    }

    public ResponseHeader getResponse() {
        return response;
    }

    public void setResponse(ResponseHeader response) {
        this.response = response;
    }

    @Override
    public String toString() {
        try {
            Map props = BeanUtils.describe(this);
            Iterator iProps = props.keySet().iterator();
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
