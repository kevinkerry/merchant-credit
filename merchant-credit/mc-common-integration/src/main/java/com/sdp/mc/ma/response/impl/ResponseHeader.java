package com.sdp.mc.ma.response.impl;

import java.util.Date;

import com.sdp.mc.ma.header.impl.AbstractHeader;

/**
 * <p>响应头信息</p>
 * @author wangchanggeng
 * @version $Id: ResponseHeader.java, v 0.1 2010-12-15 上午10:29:08 wangchanggeng Exp $
 */
public class ResponseHeader extends AbstractHeader{
    private String responseCode;
    private String responseMessage;
    private String version;
    private String requestCode;
    private String requestNo;
    private Date requestTime;
    private Date responseTime;
    private String mac;
    private String extension;
    public String getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getRequestCode() {
        return requestCode;
    }
    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }
    public String getRequestNo() {
        return requestNo;
    }
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }
    public Date getRequestTime() {
        return requestTime;
    }
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
    public Date getResponseTime() {
        return responseTime;
    }
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }

    

}
