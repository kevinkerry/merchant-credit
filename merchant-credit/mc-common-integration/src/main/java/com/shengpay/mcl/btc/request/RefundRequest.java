package com.shengpay.mcl.btc.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseRequest;

/**
 * <p>退款申请</p>
 * @author Eric.fu
 * @version $Id: RefundRequest.java, v 0.1 2012-3-16 上午10:03:17 fuyangbiao Exp $
 */
public class RefundRequest extends BaseRequest {
    private static final long serialVersionUID = 6650660459092753853L;

    /** 原订单号，非空 */
    private String            origOrderNo;
    /** 退款订单号，非空 */
    private String            refundNo;
    /** 金额，非空 */
    private String            amount;
    /** 回调地址，可空 */
    private String            callbackUrl;
    /** 附言，可空  */
    private String            postScript;
    /** 备注，可空  */
    private String            memo;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
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
        buildSignProperty(sb, "charset", charset);
        buildSignProperty(sb, "customerNo", customerNo);
        buildSignProperty(sb, "origOrderNo", origOrderNo);
        buildSignProperty(sb, "refundNo", refundNo);
        buildSignProperty(sb, "amount", amount);
        buildSignProperty(sb, "callbackUrl", callbackUrl);
        buildSignProperty(sb, "postScript", postScript);
        buildSignProperty(sb, "memo", memo);

        return sb.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
