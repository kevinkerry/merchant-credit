
package com.sdp.mc.withdraw;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sdp.mc.withdraw.entity.IResponse;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckResult" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "checkResult"
})
@XmlRootElement(name = "CheckResponse")
public class CheckResponse {

    @XmlElementRef(name = "CheckResult", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<IResponse> checkResult;

    /**
     * Gets the value of the checkResult property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IResponse }{@code >}
     *
     */
    public JAXBElement<IResponse> getCheckResult() {
        return checkResult;
    }

    /**
     * Sets the value of the checkResult property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IResponse }{@code >}
     *
     */
    public void setCheckResult(JAXBElement<IResponse> value) {
        this.checkResult = ((JAXBElement<IResponse> ) value);
    }

}
