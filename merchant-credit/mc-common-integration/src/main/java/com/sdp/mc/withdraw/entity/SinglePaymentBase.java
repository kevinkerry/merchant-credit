
package com.sdp.mc.withdraw.entity;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SinglePaymentBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SinglePaymentBase">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IRequest">
 *       &lt;sequence>
 *         &lt;element name="BatchNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExceptionInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="IsCheckFlow" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}NeedCheckFundFlow" minOccurs="0"/>
 *         &lt;element name="IsInsertRecord" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}NeedInsertRecord" minOccurs="0"/>
 *         &lt;element name="ItemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MACString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantPtID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayFeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayFeeSide" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="PayMerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayOrderAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="PayeeMemberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayeeSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerMemberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentSeqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RealMerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="TargetAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetAccountType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}TargetAccountType" minOccurs="0"/>
 *         &lt;element name="TargetUserName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SinglePaymentBase", propOrder = {
    "batchNO",
    "exceptionInfo",
    "id",
    "isCheckFlow",
    "isInsertRecord",
    "itemID",
    "macString",
    "merchantID",
    "merchantPtID",
    "message",
    "orderNo",
    "payAmount",
    "payChannel",
    "payFeeAmount",
    "payFeeSide",
    "payMerchantID",
    "payOrderAmount",
    "payStatus",
    "payTime",
    "payeeMemberid",
    "payeeSFTAccountNo",
    "payerMemberid",
    "payerSFTAccountNo",
    "paymentSeqNo",
    "realMerchantID",
    "remark",
    "status",
    "targetAccount",
    "targetAccountType",
    "targetUserName"
})
@XmlSeeAlso({
    SinglePaymentAccount.class,
    SinglePaymentCard.class
})
public class SinglePaymentBase
    extends IRequest
{

    @XmlElementRef(name = "BatchNO", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> batchNO;
    @XmlElementRef(name = "ExceptionInfo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> exceptionInfo;
    @XmlElement(name = "ID")
    protected Integer id;
    @XmlElement(name = "IsCheckFlow")
    protected NeedCheckFundFlow isCheckFlow;
    @XmlElement(name = "IsInsertRecord")
    protected NeedInsertRecord isInsertRecord;
    @XmlElementRef(name = "ItemID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> itemID;
    @XmlElementRef(name = "MACString", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> macString;
    @XmlElementRef(name = "MerchantID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantID;
    @XmlElementRef(name = "MerchantPtID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantPtID;
    @XmlElementRef(name = "Message", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> message;
    @XmlElementRef(name = "OrderNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> orderNo;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElementRef(name = "PayChannel", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payChannel;
    @XmlElement(name = "PayFeeAmount")
    protected BigDecimal payFeeAmount;
    @XmlElement(name = "PayFeeSide")
    protected Integer payFeeSide;
    @XmlElementRef(name = "PayMerchantID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payMerchantID;
    @XmlElement(name = "PayOrderAmount")
    protected BigDecimal payOrderAmount;
    @XmlElementRef(name = "PayStatus", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payStatus;
    @XmlElement(name = "PayTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar payTime;
    @XmlElementRef(name = "PayeeMemberid", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payeeMemberid;
    @XmlElementRef(name = "PayeeSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payeeSFTAccountNo;
    @XmlElementRef(name = "PayerMemberid", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerMemberid;
    @XmlElementRef(name = "PayerSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerSFTAccountNo;
    @XmlElementRef(name = "PaymentSeqNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> paymentSeqNo;
    @XmlElementRef(name = "RealMerchantID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> realMerchantID;
    @XmlElementRef(name = "Remark", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElement(name = "Status")
    protected Integer status;
    @XmlElementRef(name = "TargetAccount", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetAccount;
    @XmlElement(name = "TargetAccountType")
    protected TargetAccountType targetAccountType;
    @XmlElementRef(name = "TargetUserName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetUserName;

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
     * Gets the value of the exceptionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExceptionInfo() {
        return exceptionInfo;
    }

    /**
     * Sets the value of the exceptionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExceptionInfo(JAXBElement<String> value) {
        this.exceptionInfo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setID(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the isCheckFlow property.
     * 
     * @return
     *     possible object is
     *     {@link NeedCheckFundFlow }
     *     
     */
    public NeedCheckFundFlow getIsCheckFlow() {
        return isCheckFlow;
    }

    /**
     * Sets the value of the isCheckFlow property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedCheckFundFlow }
     *     
     */
    public void setIsCheckFlow(NeedCheckFundFlow value) {
        this.isCheckFlow = value;
    }

    /**
     * Gets the value of the isInsertRecord property.
     * 
     * @return
     *     possible object is
     *     {@link NeedInsertRecord }
     *     
     */
    public NeedInsertRecord getIsInsertRecord() {
        return isInsertRecord;
    }

    /**
     * Sets the value of the isInsertRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedInsertRecord }
     *     
     */
    public void setIsInsertRecord(NeedInsertRecord value) {
        this.isInsertRecord = value;
    }

    /**
     * Gets the value of the itemID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getItemID() {
        return itemID;
    }

    /**
     * Sets the value of the itemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setItemID(JAXBElement<String> value) {
        this.itemID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the macString property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMACString() {
        return macString;
    }

    /**
     * Sets the value of the macString property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMACString(JAXBElement<String> value) {
        this.macString = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the merchantID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantID() {
        return merchantID;
    }

    /**
     * Sets the value of the merchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantID(JAXBElement<String> value) {
        this.merchantID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the merchantPtID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantPtID() {
        return merchantPtID;
    }

    /**
     * Sets the value of the merchantPtID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantPtID(JAXBElement<String> value) {
        this.merchantPtID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = ((JAXBElement<String> ) value);
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
     * Gets the value of the payChannel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayChannel() {
        return payChannel;
    }

    /**
     * Sets the value of the payChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayChannel(JAXBElement<String> value) {
        this.payChannel = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayFeeAmount() {
        return payFeeAmount;
    }

    /**
     * Sets the value of the payFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayFeeAmount(BigDecimal value) {
        this.payFeeAmount = value;
    }

    /**
     * Gets the value of the payFeeSide property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPayFeeSide() {
        return payFeeSide;
    }

    /**
     * Sets the value of the payFeeSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPayFeeSide(Integer value) {
        this.payFeeSide = value;
    }

    /**
     * Gets the value of the payMerchantID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayMerchantID() {
        return payMerchantID;
    }

    /**
     * Sets the value of the payMerchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayMerchantID(JAXBElement<String> value) {
        this.payMerchantID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payOrderAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayOrderAmount() {
        return payOrderAmount;
    }

    /**
     * Sets the value of the payOrderAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayOrderAmount(BigDecimal value) {
        this.payOrderAmount = value;
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
     * Gets the value of the payTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPayTime() {
        return payTime;
    }

    /**
     * Sets the value of the payTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPayTime(XMLGregorianCalendar value) {
        this.payTime = value;
    }

    /**
     * Gets the value of the payeeMemberid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayeeMemberid() {
        return payeeMemberid;
    }

    /**
     * Sets the value of the payeeMemberid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayeeMemberid(JAXBElement<String> value) {
        this.payeeMemberid = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payeeSFTAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayeeSFTAccountNo() {
        return payeeSFTAccountNo;
    }

    /**
     * Sets the value of the payeeSFTAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayeeSFTAccountNo(JAXBElement<String> value) {
        this.payeeSFTAccountNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the payerMemberid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPayerMemberid() {
        return payerMemberid;
    }

    /**
     * Sets the value of the payerMemberid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPayerMemberid(JAXBElement<String> value) {
        this.payerMemberid = ((JAXBElement<String> ) value);
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
     * Gets the value of the paymentSeqNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentSeqNo() {
        return paymentSeqNo;
    }

    /**
     * Sets the value of the paymentSeqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentSeqNo(JAXBElement<String> value) {
        this.paymentSeqNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the realMerchantID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRealMerchantID() {
        return realMerchantID;
    }

    /**
     * Sets the value of the realMerchantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRealMerchantID(JAXBElement<String> value) {
        this.realMerchantID = ((JAXBElement<String> ) value);
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the targetAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetAccount() {
        return targetAccount;
    }

    /**
     * Sets the value of the targetAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetAccount(JAXBElement<String> value) {
        this.targetAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetAccountType }
     *     
     */
    public TargetAccountType getTargetAccountType() {
        return targetAccountType;
    }

    /**
     * Sets the value of the targetAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetAccountType }
     *     
     */
    public void setTargetAccountType(TargetAccountType value) {
        this.targetAccountType = value;
    }

    /**
     * Gets the value of the targetUserName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetUserName() {
        return targetUserName;
    }

    /**
     * Sets the value of the targetUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetUserName(JAXBElement<String> value) {
        this.targetUserName = ((JAXBElement<String> ) value);
    }

}
