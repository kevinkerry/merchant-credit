package com.shengpay.mcl.btc.request;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.shengpay.mcl.api.common.BaseRequest;

/**
 * <p>批量委托代收请求</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectRequest.java, v 0.1 2012-3-15 下午03:26:02 fuyangbiao Exp $
 */
public class BatchRequest extends BaseRequest {
    private static final long serialVersionUID = -3977641580203034757L;

    /** 批次号，非空 */
    private String            batchNo;
    /** 文件名 ，非空*/
    private String            fileName;
    /** 摘要，非空 */
    private String            digest;
    /** 摘要类型，非空 */
    private String            digestType;
    /** 回调地址，可空 */
    private String            callbackUrl;

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getDigestType() {
        return digestType;
    }

    public void setDigestType(String digestType) {
        this.digestType = digestType;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String getSignString() {
        StringBuilder sb = new StringBuilder();
        buildSignProperty(sb, "charset", charset);
        buildSignProperty(sb, "customerNo", customerNo);
        buildSignProperty(sb, "batchNo", batchNo);
        buildSignProperty(sb, "fileName", fileName);
        buildSignProperty(sb, "digest", digest);
        buildSignProperty(sb, "digestType", digestType);
//        buildSignProperty(sb, "callbackUrl", callbackUrl);

        return sb.toString();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
