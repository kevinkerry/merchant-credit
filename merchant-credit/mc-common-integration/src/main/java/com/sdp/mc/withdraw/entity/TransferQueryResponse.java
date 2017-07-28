
package com.sdp.mc.withdraw.entity;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TransferQueryResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferQueryResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse">
 *       &lt;sequence>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Ext1" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Ext2" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FinishTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MerchantOrderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "TransferQueryResponse", propOrder = {
    "accountID",
    "createTime",
    "ext1",
    "ext2",
    "feeAmount",
    "finishTime",
    "merchantOrderID",
    "orderNo",
    "payAmount",
    "payStatus",
    "paymentNo",
    "remark",
    "userID"
})
public class TransferQueryResponse
    extends IResponse
{

    @XmlElementRef(name = "AccountID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> accountID;
    @XmlElement(name = "CreateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createTime;
    @XmlElementRef(name = "Ext1", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext1;
    @XmlElementRef(name = "Ext2", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<Object> ext2;
    @XmlElement(name = "FeeAmount")
    protected BigDecimal feeAmount;
    @XmlElement(name = "FinishTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finishTime;
    @XmlElementRef(name = "MerchantOrderID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantOrderID;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> orderNo;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElementRef(name = "PayStatus", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payStatus;
    @XmlElementRef(name = "PaymentNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> paymentNo;
    @XmlElementRef(name = "Remark", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "UserID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> userID;

    /**
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountID(JAXBElement<String> value) {
        this.accountID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateTime(XMLGregorianCalendar value) {
        this.createTime = value;
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
     * Gets the value of the feeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFeeAmount(BigDecimal value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the finishTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinishTime() {
        return finishTime;
    }

    /**
     * Sets the value of the finishTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinishTime(XMLGregorianCalendar value) {
        this.finishTime = value;
    }

    /**
     * Gets the value of the merchantOrderID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantOrderID() {
        return merchantOrderID;
    }

    /**
     * Sets the value of the merchantOrderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantOrderID(JAXBElement<String> value) {
        this.merchantOrderID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the orderNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the value of the orderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderNo(JAXBElement<String> value) {
        this.orderNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * Sets the value of the payAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayAmount(BigDecimal value) {
        this.payAmount = value;
    }

    /**
     * Gets the value of the payStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayStatus() {
        return payStatus;
    }

    /**
     * Sets the value of the payStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayStatus(JAXBElement<String> value) {
        this.payStatus = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paymentNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentNo() {
        return paymentNo;
    }

    /**
     * Sets the value of the paymentNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentNo(JAXBElement<String> value) {
        this.paymentNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemark(JAXBElement<String> value) {
        this.remark = ((JAXBElement<String> ) value);
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
