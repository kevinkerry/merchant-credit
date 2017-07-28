
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WithdrawType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WithdrawType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NonWithDraw"/>
 *     &lt;enumeration value="SelfWithDraw"/>
 *     &lt;enumeration value="AutoWithDraw"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WithdrawType")
@XmlEnum
public enum WithdrawType {

    @XmlEnumValue("NonWithDraw")
    NON_WITH_DRAW("NonWithDraw"),
    @XmlEnumValue("SelfWithDraw")
    SELF_WITH_DRAW("SelfWithDraw"),
    @XmlEnumValue("AutoWithDraw")
    AUTO_WITH_DRAW("AutoWithDraw");
    private final String value;

    WithdrawType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WithdrawType fromValue(String v) {
        for (WithdrawType c: WithdrawType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
