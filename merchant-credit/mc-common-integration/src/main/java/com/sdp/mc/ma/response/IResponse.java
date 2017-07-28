package com.sdp.mc.ma.response;


/**
 * <p>响应接口</p>
 * @author wangchanggeng
 * @version $Id: IResponse.java, v 0.1 2010-12-6 下午01:01:20 wangchanggeng Exp $
 */
public interface IResponse {
    
    /**
     * 获取属性
     * @param key
     * @return
     */
    public Object getAttribute(Object key);
    
    /**
     * 设置属性
     * @param key
     * @param value
     */
    public void setAttribute(Object key,Object value);
    
   
}
