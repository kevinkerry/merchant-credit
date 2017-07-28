package com.sdp.mc.ma.request.impl;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.sdp.mc.ma.header.impl.AbstractHeader;

/**
 * <p>请求头信息</p>
 * @author wangchanggeng
 * @version $Id: RequestHeader.java, v 0.1 2010-12-13 下午08:27:19 wangchanggeng Exp $
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestHeader extends AbstractHeader {

    @NotBlank
    @Size(min = 2, max = 32)
    @XmlElement(required = true,nillable = false)
    private String version;

    @Size(min = 1, max = 64)
    private String requestCode;

    @NotBlank
    @Size(min = 1, max = 64)
    @XmlElement(required = true,nillable = false)
    private String requestNo;

    @NotNull
    @XmlElement(required = true,nillable = false)
    private Date   requestTime;

    @NotBlank
    @Size(min = 1, max = 32)
    @XmlElement(required = true,nillable = false)
    private String sourceId;

    @Size(min = 1, max = 32)
    private String requestOperator;

    @Size(min = 1, max = 32)
    private String operatorType;

    @Length(min = 0, max = 32)
    private String mac;

    @Size(min = 0, max = 32)
    private String ip;

    @Size(max = 128)
    private String extension;

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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getRequestOperator() {
        return requestOperator;
    }

    public void setRequestOperator(String requestOperator) {
        this.requestOperator = requestOperator;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
