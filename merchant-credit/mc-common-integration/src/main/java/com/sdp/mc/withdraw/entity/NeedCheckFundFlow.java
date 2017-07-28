
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NeedCheckFundFlow.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NeedCheckFundFlow">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Y"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NeedCheckFundFlow")
@XmlEnum
public enum NeedCheckFundFlow {

    Y,
    N;

    public String value() {
        return name();
    }

    public static NeedCheckFundFlow fromValue(String v) {
        return valueOf(v);
    }

}
