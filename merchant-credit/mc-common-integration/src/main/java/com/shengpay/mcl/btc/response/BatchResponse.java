package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseResponse;

/**
 * <p>批量委托代收响应</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectResponse.java, v 0.1 2012-3-15 下午06:06:43 fuyangbiao Exp $
 */
@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchResponse extends BaseResponse {
    private static final long serialVersionUID = 9155046865296713125L;

    /** 批次号，非空  */
    private String            batchNo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "batchNo", batchNo);
        buildSignProperty(sb, "resultCode", resultCode);
        buildSignProperty(sb, "resultMessage", resultMessage);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
