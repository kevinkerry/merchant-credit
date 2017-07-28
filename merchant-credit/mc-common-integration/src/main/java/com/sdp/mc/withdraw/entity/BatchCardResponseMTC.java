
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BatchCardResponseMTC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchCardResponseMTC">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse">
 *       &lt;sequence>
 *         &lt;element name="BatchNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ext1" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Ext2" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="MerchantBatchNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayOrderAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerMemberID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchCardResponseMTC", propOrder = {
    "batchNO",
    "ext1",
    "ext2",
    "merchantBatchNo",
    "payOrderAmount",
    "payerMemberID",
    "payerSFTAccountNo",
    "processTime",
    "productCode",
    "userID"
})
public class BatchCardResponseMTC
    extends IResponse
{

    @XmlElementRef(name = "BatchNO", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> batchNO;
    @XmlElementRef(name = "Ext1", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext1;
    @XmlElementRef(name = "Ext2", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext2;
    @XmlElementRef(name = "MerchantBatchNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantBatchNo;
    @XmlElementRef(name = "PayOrderAmount", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payOrderAmount;
    @XmlElementRef(name = "PayerMemberID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerMemberID;
    @XmlElementRef(name = "PayerSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerSFTAccountNo;
    @XmlElement(name = "ProcessTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processTime;
    @XmlElementRef(name = "ProductCode", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> productCode;
    @XmlElementRef(name = "UserID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> userID;

    /**
     * Gets the value of the batchNO property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBatchNO() {
        return batchNO;
    }

    /**
     * Sets the value of the batchNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBatchNO(JAXBElement<String> value) {
        this.batchNO = ((JAXBElement<String> ) value);
    }

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
     * Gets the value of the merchantBatchNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantBatchNo() {
        return merchantBatchNo;
    }

    /**
     * Sets the value of the merchantBatchNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantBatchNo(JAXBElement<String> value) {
        this.merchantBatchNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payOrderAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayOrderAmount() {
        return payOrderAmount;
    }

    /**
     * Sets the value of the payOrderAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayOrderAmount(JAXBElement<String> value) {
        this.payOrderAmount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payerMemberID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayerMemberID() {
        return payerMemberID;
    }

    /**
     * Sets the value of the payerMemberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayerMemberID(JAXBElement<String> value) {
        this.payerMemberID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payerSFTAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayerSFTAccountNo() {
        return payerSFTAccountNo;
    }

    /**
     * Sets the value of the payerSFTAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayerSFTAccountNo(JAXBElement<String> value) {
        this.payerSFTAccountNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the processTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessTime() {
        return processTime;
    }

    /**
     * Sets the value of the processTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessTime(XMLGregorianCalendar value) {
        this.processTime = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProductCode(JAXBElement<String> value) {
        this.productCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserID(JAXBElement<String> value) {
        this.userID = ((JAXBElement<String> ) value);
    }

}
