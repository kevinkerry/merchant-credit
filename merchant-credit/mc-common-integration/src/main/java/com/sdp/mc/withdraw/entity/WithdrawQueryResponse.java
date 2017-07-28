
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WithdrawQueryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WithdrawQueryResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse">
 *       &lt;sequence>
 *         &lt;element name="Ext1" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Ext2" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Result" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}ArrayOfWithdrawQueryResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WithdrawQueryResponse", propOrder = {
    "ext1",
    "ext2",
    "result"
})
public class WithdrawQueryResponse
    extends IResponse
{

    @XmlElementRef(name = "Ext1", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext1;
    @XmlElementRef(name = "Ext2", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext2;
    @XmlElementRef(name = "Result", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<ArrayOfWithdrawQueryResult> result;

    /**
     * Gets the value of the ext1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getExt1() {
        return ext1;
    }

    /**
     * Sets the value of the ext1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setExt1(JAXBElement<Object> value) {
        this.ext1 = ((JAXBElement<Object> ) value);
    }

    /**
     * Gets the value of the ext2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getExt2() {
        return ext2;
    }

    /**
     * Sets the value of the ext2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setExt2(JAXBElement<Object> value) {
        this.ext2 = ((JAXBElement<Object> ) value);
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWithdrawQueryResult }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWithdrawQueryResult> getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWithdrawQueryResult }{@code >}
     *     
     */
    public void setResult(JAXBElement<ArrayOfWithdrawQueryResult> value) {
        this.result = ((JAXBElement<ArrayOfWithdrawQueryResult> ) value);
    }

}
