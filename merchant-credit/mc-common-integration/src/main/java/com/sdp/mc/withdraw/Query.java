
package com.sdp.mc.withdraw;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sdp.mc.withdraw.entity.IRequest;


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
 *         &lt;element name="request" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IRequest" minOccurs="0"/>
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
    "request"
})
@XmlRootElement(name = "Query")
public class Query {

    @XmlElementRef(name = "request", namespace = "http://tempuri.org/", type = JAXBElement.class)
    protected JAXBElement<IRequest> request;

    /**
     * Gets the value of the request property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IRequest }{@code >}
     *
     */
    public JAXBElement<IRequest> getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IRequest }{@code >}
     *
     */
    public void setRequest(JAXBElement<IRequest> value) {
        this.request = ((JAXBElement<IRequest> ) value);
    }

}
