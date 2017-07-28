package com.shengpay.mcl.btc.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseRequest;

/**
 * <p>退款查询请求</p>
 * @author Eric.fu
 * @version $Id: RefundQueryRequest.java, v 0.1 2012-3-16 上午10:54:49 fuyangbiao Exp $
 */
public class RefundQueryRequest extends BaseRequest {
    private static final long serialVersionUID = 8680635829206408232L;

    /** 退款订单号，非空 */
    private String            refundNo;

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "charset", charset);
        buildSignProperty(sb, "customerNo", customerNo);
        buildSignProperty(sb, "refundNo", refundNo);

        return sb.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
