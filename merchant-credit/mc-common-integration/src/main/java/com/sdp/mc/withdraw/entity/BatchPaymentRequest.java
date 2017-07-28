
package com.sdp.mc.withdraw.entity;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BatchPaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchPaymentRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IRequest">
 *       &lt;sequence>
 *         &lt;element name="BatchCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BatchNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}PaymentType" minOccurs="0"/>
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantBatchNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantPtID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayeeMemberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayeeSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerMemberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentStream" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServerFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchPaymentRequest", propOrder = {
    "batchCount",
    "batchNO",
    "batchType",
    "feeAmount",
    "fileName",
    "merchantBatchNO",
    "merchantID",
    "merchantPtID",
    "payAmount",
    "payeeMemberid",
    "payeeSFTAccountNo",
    "payerMemberid",
    "payerSFTAccountNo",
    "paymentStream",
    "remark",
    "serverFileName"
})
public class BatchPaymentRequest
    extends IRequest
{

    @XmlElement(name = "BatchCount")
    protected Integer batchCount;
    @XmlElementRef(name = "BatchNO", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> batchNO;
    @XmlElement(name = "BatchType")
    protected PaymentType batchType;
    @XmlElement(name = "FeeAmount")
    protected BigDecimal feeAmount;
    @XmlElementRef(name = "FileName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> fileName;
    @XmlElementRef(name = "MerchantBatchNO", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantBatchNO;
    @XmlElementRef(name = "MerchantID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantID;
    @XmlElementRef(name = "MerchantPtID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantPtID;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElementRef(name = "PayeeMemberid", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payeeMemberid;
    @XmlElementRef(name = "PayeeSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payeeSFTAccountNo;
    @XmlElementRef(name = "PayerMemberid", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerMemberid;
    @XmlElementRef(name = "PayerSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerSFTAccountNo;
    @XmlElementRef(name = "PaymentStream", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<byte[]> paymentStream;
    @XmlElementRef(name = "Remark", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "ServerFileName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> serverFileName;

    /**
     * Gets the value of the batchCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBatchCount() {
        return batchCount;
    }

    /**
     * Sets the value of the batchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBatchCount(Integer value) {
        this.batchCount = value;
    }

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
     * Gets the value of the batchType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getBatchType() {
        return batchType;
    }

    /**
     * Sets the value of the batchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setBatchType(PaymentType value) {
        this.batchType = value;
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
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFileName(JAXBElement<String> value) {
        this.fileName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the merchantBatchNO property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantBatchNO() {
        return merchantBatchNO;
    }

    /**
     * Sets the value of the merchantBatchNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantBatchNO(JAXBElement<String> value) {
        this.merchantBatchNO = ((JAXBElement<String> ) value);
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
     * Gets the value of the paymentStream property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getPaymentStream() {
        return paymentStream;
    }

    /**
     * Sets the value of the paymentStream property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setPaymentStream(JAXBElement<byte[]> value) {
        this.paymentStream = ((JAXBElement<byte[]> ) value);
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
     * Gets the value of the serverFileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServerFileName() {
        return serverFileName;
    }

    /**
     * Sets the value of the serverFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServerFileName(JAXBElement<String> value) {
        this.serverFileName = ((JAXBElement<String> ) value);
    }

}
