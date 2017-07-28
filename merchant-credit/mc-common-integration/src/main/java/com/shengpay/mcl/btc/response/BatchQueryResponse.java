package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseResponse;

/**
 * <p>批量委托代收查询响应</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectQueryResponse.java, v 0.1 2012-3-15 下午06:48:15 fuyangbiao Exp $
 */
@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class BatchQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 6404115738578941757L;

    /** 批次号，非空  */
    private String            batchNo;
    /** 状态，可空  */
    private String            status;
    /** 备注，可空 */
    private String            memo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "batchNo", batchNo);
        buildSignProperty(sb, "resultCode", resultCode);
        buildSignProperty(sb, "resultMessage", resultMessage);
        buildSignProperty(sb, "status", status);
        buildSignProperty(sb, "memo", memo);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
