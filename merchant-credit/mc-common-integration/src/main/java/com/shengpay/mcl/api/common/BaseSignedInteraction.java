package com.shengpay.mcl.api.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * <p>带签名的交互基础对象</p>
 * @author Eric.fu
 * @version $Id: BaseSignedInteraction.java, v 0.1 2012-3-16 上午09:22:55 fuyangbiao Exp $
 */
public abstract class BaseSignedInteraction implements Serializable {
    private static final long  serialVersionUID = -8103443006667802985L;

    public static final String EMPTY_STRING     = "";
    public static final String EQUALS_TAG       = "=";
    public static final String DATE_FORMAT      = "yyyyMMddHHmmss";

    /** 签名类型 */
    protected String           signType;
    /** 签名 */
    protected String           sign;

    /**
     * 获取待签串
     * @return
     */
    public abstract String getSignString();

    /**
     * 组装签名属性
     * @param property
     * @return
     */
    public static void buildSignProperty(StringBuilder sb, String name, Object value) {
        if (value == null) {
            return;
        }
        String formatValue = value.toString();
        if (value instanceof Date) {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            formatValue = dateFormat.format((Date) value);
        } else if (value instanceof String) {
            if (EMPTY_STRING.equals(((String) value).trim())) {
                return;
            }
        }

        sb.append(name).append(EQUALS_TAG).append(formatValue);
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
