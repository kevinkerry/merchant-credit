package com.shengpay.mcl.api.common;


/**
 * <p>基础响应</p>
 * @author Eric.fu
 * @version $Id: BaseResponse.java, v 0.1 2012-3-20 下午03:05:20 fuyangbiao Exp $
 */
public abstract class BaseResponse extends BaseSignedInteraction {
    private static final long serialVersionUID = 2156635008728245707L;

    /** 结果代码，非空  */
    protected String          resultCode;
    /** 结果信息，可空 */
    protected String          resultMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
