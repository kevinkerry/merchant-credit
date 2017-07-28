package com.shengpay.mcl.btc.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseRequest;

/**
 * <p>批量委托代收查询请求</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectQueryRequest.java, v 0.1 2012-3-15 下午06:26:13 fuyangbiao Exp $
 */
public class BatchQueryRequest extends BaseRequest {
    private static final long serialVersionUID = -448611521350684510L;

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
        buildSignProperty(sb, "charset", charset);
        buildSignProperty(sb, "customerNo", customerNo);
        buildSignProperty(sb, "batchNo", batchNo);

        return sb.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
