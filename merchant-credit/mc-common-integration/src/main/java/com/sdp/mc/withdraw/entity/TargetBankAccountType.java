
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetBankAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TargetBankAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ToPrivate"/>
 *     &lt;enumeration value="ToPublic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TargetBankAccountType")
@XmlEnum
public enum TargetBankAccountType {

    @XmlEnumValue("ToPrivate")
    TO_PRIVATE("ToPrivate"),
    @XmlEnumValue("ToPublic")
    TO_PUBLIC("ToPublic");
    private final String value;

    TargetBankAccountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TargetBankAccountType fromValue(String v) {
        for (TargetBankAccountType c: TargetBankAccountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
