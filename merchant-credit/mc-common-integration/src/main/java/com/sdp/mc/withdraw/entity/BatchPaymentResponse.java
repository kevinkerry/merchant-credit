
package com.sdp.mc.withdraw.entity;

import java.math.BigDecimal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.sdp.mc.withdraw.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintstring;


/**
 * <p>Java class for BatchPaymentResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BatchPaymentResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse">
 *       &lt;sequence>
 *         &lt;element name="BatchMerchantNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BatchType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}PaymentType" minOccurs="0"/>
 *         &lt;element name="ErrorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ErrorList" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintstring" minOccurs="0"/>
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MerchantID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayChannel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayPtID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerMemberid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayerSFTAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SingleAccountList" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}ArrayOfSinglePaymentAccount" minOccurs="0"/>
 *         &lt;element name="SingleCardList" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}ArrayOfSinglePaymentCard" minOccurs="0"/>
 *         &lt;element name="TotalCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="UploadFileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchPaymentResponse", propOrder = {
    "batchMerchantNo",
    "batchNO",
    "batchType",
    "errorCount",
    "errorList",
    "feeAmount",
    "merchantID",
    "payAmount",
    "payChannel",
    "payPtID",
    "payerMemberid",
    "payerSFTAccountNo",
    "productCode",
    "singleAccountList",
    "singleCardList",
    "totalCount",
    "uploadFileName"
})
public class BatchPaymentResponse
    extends IResponse
{

    @XmlElementRef(name = "BatchMerchantNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> batchMerchantNo;
    @XmlElementRef(name = "BatchNO", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> batchNO;
    @XmlElement(name = "BatchType")
    protected PaymentType batchType;
    @XmlElement(name = "ErrorCount")
    protected Integer errorCount;
    @XmlElementRef(name = "ErrorList", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintstring> errorList;
    @XmlElement(name = "FeeAmount")
    protected BigDecimal feeAmount;
    @XmlElementRef(name = "MerchantID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantID;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElementRef(name = "PayChannel", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payChannel;
    @XmlElementRef(name = "PayPtID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payPtID;
    @XmlElementRef(name = "PayerMemberid", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerMemberid;
    @XmlElementRef(name = "PayerSFTAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> payerSFTAccountNo;
    @XmlElementRef(name = "ProductCode", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> productCode;
    @XmlElementRef(name = "SingleAccountList", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSinglePaymentAccount> singleAccountList;
    @XmlElementRef(name = "SingleCardList", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSinglePaymentCard> singleCardList;
    @XmlElement(name = "TotalCount")
    protected Integer totalCount;
    @XmlElementRef(name = "UploadFileName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> uploadFileName;

    /**
     * Gets the value of the batchMerchantNo property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getBatchMerchantNo() {
        return batchMerchantNo;
    }

    /**
     * Sets the value of the batchMerchantNo property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setBatchMerchantNo(JAXBElement<String> value) {
        this.batchMerchantNo = ((JAXBElement<String> ) value);
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
     * Gets the value of the errorCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getErrorCount() {
        return errorCount;
    }

    /**
     * Sets the value of the errorCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setErrorCount(Integer value) {
        this.errorCount = value;
    }

    /**
     * Gets the value of the errorList property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintstring }{@code >}
     *
     */
    public JAXBElement<ArrayOfKeyValueOfintstring> getErrorList() {
        return errorList;
    }

    /**
     * Sets the value of the errorList property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintstring }{@code >}
     *
     */
    public void setErrorList(JAXBElement<ArrayOfKeyValueOfintstring> value) {
        this.errorList = ((JAXBElement<ArrayOfKeyValueOfintstring> ) value);
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
     * Gets the value of the payPtID property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getPayPtID() {
        return payPtID;
    }

    /**
     * Sets the value of the payPtID property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setPayPtID(JAXBElement<String> value) {
        this.payPtID = ((JAXBElement<String> ) value);
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
     * Gets the value of the singleAccountList property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentAccount }{@code >}
     *
     */
    public JAXBElement<ArrayOfSinglePaymentAccount> getSingleAccountList() {
        return singleAccountList;
    }

    /**
     * Sets the value of the singleAccountList property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentAccount }{@code >}
     *
     */
    public void setSingleAccountList(JAXBElement<ArrayOfSinglePaymentAccount> value) {
        this.singleAccountList = ((JAXBElement<ArrayOfSinglePaymentAccount> ) value);
    }

    /**
     * Gets the value of the singleCardList property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentCard }{@code >}
     *
     */
    public JAXBElement<ArrayOfSinglePaymentCard> getSingleCardList() {
        return singleCardList;
    }

    /**
     * Sets the value of the singleCardList property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentCard }{@code >}
     *
     */
    public void setSingleCardList(JAXBElement<ArrayOfSinglePaymentCard> value) {
        this.singleCardList = ((JAXBElement<ArrayOfSinglePaymentCard> ) value);
    }

    /**
     * Gets the value of the totalCount property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the value of the totalCount property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

    /**
     * Gets the value of the uploadFileName property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getUploadFileName() {
        return uploadFileName;
    }

    /**
     * Sets the value of the uploadFileName property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setUploadFileName(JAXBElement<String> value) {
        this.uploadFileName = ((JAXBElement<String> ) value);
    }

}
