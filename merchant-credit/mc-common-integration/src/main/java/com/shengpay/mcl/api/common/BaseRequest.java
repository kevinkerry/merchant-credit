package com.shengpay.mcl.api.common;

/**
 * <p>基础请求</p>
 * @author Eric.fu
 * @version $Id: BaseRequest.java, v 0.1 2012-3-19 上午09:41:44 fuyangbiao Exp $
 */
public abstract class BaseRequest extends BaseSignedInteraction {
    private static final long serialVersionUID = -2590964479235175958L;

    /** 字符集 */
    protected String          charset;
    /** 商户号，非空  */
    protected String          customerNo;

    public String getCharset() {
        if (charset == null) {
            return null;
        }
        return charset.toLowerCase();
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

}
