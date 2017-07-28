package com.sdp.mc.ma.request;


/**
 * <p>请求接口</p>
 * @author wangchanggeng
 * @version $Id: IRequest.java, v 0.1 2010-12-6 上午10:55:58 wangchanggeng Exp $
 */
public interface IRequest {
    
    /**
     * 获取属性值
     * @param key
     * @return
     */
    Object getAttribute(Object key);
    
    /**
     * 设置属性值
     * @param key
     * @param value
     */
    void setAttribute(Object key,Object value);

  
}
