package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseResponse;

/**
 * <p>退款响应</p>
 * @author Eric.fu
 * @version $Id: RefundResponse.java, v 0.1 2012-3-16 上午10:10:33 fuyangbiao Exp $
 */
@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundResponse extends BaseResponse {
    private static final long serialVersionUID = -4837541186082332869L;

    /** 批次号，非空  */
    private String            batchNo;
    /** 原订单号，非空 */
    private String            origOrderNo;
    /** 退款订单号，非空 */
    private String            refundNo;
    /** 退款流水号，可空 */
    private String            refundSeqNo;
    /** 原备注，可空 */
    private String            origMemo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getOrigOrderNo() {
        return origOrderNo;
    }

    public void setOrigOrderNo(String origOrderNo) {
        this.origOrderNo = origOrderNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getRefundSeqNo() {
        return refundSeqNo;
    }

    public void setRefundSeqNo(String refundSeqNo) {
        this.refundSeqNo = refundSeqNo;
    }

    public String getOrigMemo() {
        return origMemo;
    }

    public void setOrigMemo(String origMemo) {
        this.origMemo = origMemo;
    }

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "batchNo", batchNo);
        buildSignProperty(sb, "origOrderNo", origOrderNo);
        buildSignProperty(sb, "refundNo", refundNo);
        buildSignProperty(sb, "resultCode", resultCode);
        buildSignProperty(sb, "resultMessage", resultMessage);
        buildSignProperty(sb, "refundSeqNo", refundSeqNo);
        buildSignProperty(sb, "origMemo", origMemo);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
