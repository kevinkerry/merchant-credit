package com.shengpay.mcl.btc.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseRequest;

/**
 * <p>单笔委托代收查询请求</p>
 * @author Eric.fu
 * @version $Id: SingleQueryRequest.java, v 0.1 2012-3-16 上午09:56:07 fuyangbiao Exp $
 */
public class SingleQueryRequest extends BaseRequest {
    private static final long serialVersionUID = -2716133313996112791L;

    /** 批次号，可空  */
    private String            batchNo;
    /** 订单号 */
    private String            orderNo;

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

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "charset", charset);
        buildSignProperty(sb, "customerNo", customerNo);
        buildSignProperty(sb, "batchNo", batchNo);
        buildSignProperty(sb, "orderNo", orderNo);

        return sb.toString();
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
