
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NeedInsertRecord.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NeedInsertRecord">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Y"/>
 *     &lt;enumeration value="N"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NeedInsertRecord")
@XmlEnum
public enum NeedInsertRecord {

    Y,
    N;

    public String value() {
        return name();
    }

    public static NeedInsertRecord fromValue(String v) {
        return valueOf(v);
    }

}
