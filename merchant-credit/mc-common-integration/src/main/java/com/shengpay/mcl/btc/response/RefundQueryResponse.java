package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseResponse;

/**
 * <p>退款查询响应</p>
 * @author Eric.fu
 * @version $Id: RefundQueryResponse.java, v 0.1 2012-3-16 上午11:14:40 fuyangbiao Exp $
 */
@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundQueryResponse extends BaseResponse {
    private static final long serialVersionUID = 1414643836132863163L;

    /** 批次号，可空  */
    private String            batchNo;
    /** 退款订单号，非空 */
    private String            refundNo;
    /** 状态，可空 */
    private String            status;
    /** 退款流水号，可空 */
    private String            refundSeqNo;
    /** 备注，可空 */
    private String            memo;
    /** 原备注，可空 */
    private String            origMemo;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefundSeqNo() {
        return refundSeqNo;
    }

    public void setRefundSeqNo(String refundSeqNo) {
        this.refundSeqNo = refundSeqNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
        buildSignProperty(sb, "refundNo", refundNo);
        buildSignProperty(sb, "resultCode", resultCode);
        buildSignProperty(sb, "resultMessage", resultMessage);
        buildSignProperty(sb, "status", status);
        buildSignProperty(sb, "refundSeqNo", refundSeqNo);
        buildSignProperty(sb, "memo", memo);
        buildSignProperty(sb, "origMemo", origMemo);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
