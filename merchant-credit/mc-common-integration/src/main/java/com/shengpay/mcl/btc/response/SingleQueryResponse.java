package com.shengpay.mcl.btc.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseResponse;

/**
 * <p>单笔委托代收查询响应</p>
 * @author Eric.fu
 * @version $Id: SingleQueryResponse.java, v 0.1 2012-3-16 上午09:58:07 fuyangbiao Exp $
 */
@XmlType(namespace = "http://response.btc.mcl.shengpay.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class SingleQueryResponse extends BaseResponse {
    private static final long serialVersionUID = -1133813008029689824L;

    /** 批次号，可空  */
    private String            batchNo;
    /** 订单号 */
    private String            orderNo;
    /** 状态，可空  */
    private String            status;
    /** 订单流水号，盛付通生成，可空 */
    private String            orderSeqNo;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderSeqNo() {
        return orderSeqNo;
    }

    public void setOrderSeqNo(String orderSeqNo) {
        this.orderSeqNo = orderSeqNo;
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
        buildSignProperty(sb, "orderNo", orderNo);
        buildSignProperty(sb, "resultCode", resultCode);
        buildSignProperty(sb, "resultMessage", resultMessage);
        buildSignProperty(sb, "status", status);
        buildSignProperty(sb, "orderSeqNo", orderSeqNo);
        buildSignProperty(sb, "memo", memo);
        buildSignProperty(sb, "origMemo", origMemo);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
