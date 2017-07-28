
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
 * <p>Java class for CheckPaymentResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CheckPaymentResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IResponse">
 *       &lt;sequence>
 *         &lt;element name="AvailbleBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ErrorCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ErrorList" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfintstring" minOccurs="0"/>
 *         &lt;element name="ErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "CheckPaymentResponse", propOrder = {
    "availbleBalance",
    "errorCode",
    "errorCount",
    "errorList",
    "errorMsg",
    "feeAmount",
    "payAmount",
    "totalCount",
    "uploadFileName"
})
public class CheckPaymentResponse
    extends IResponse
{

    @XmlElement(name = "AvailbleBalance")
    protected BigDecimal availbleBalance;
    @XmlElement(name = "ErrorCode")
    protected Integer errorCode;
    @XmlElement(name = "ErrorCount")
    protected Integer errorCount;
    @XmlElementRef(name = "ErrorList", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<ArrayOfKeyValueOfintstring> errorList;
    @XmlElementRef(name = "ErrorMsg", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> errorMsg;
    @XmlElement(name = "FeeAmount")
    protected BigDecimal feeAmount;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElement(name = "TotalCount")
    protected Integer totalCount;
    @XmlElementRef(name = "UploadFileName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> uploadFileName;

    /**
     * Gets the value of the availbleBalance property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getAvailbleBalance() {
        return availbleBalance;
    }

    /**
     * Sets the value of the availbleBalance property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setAvailbleBalance(BigDecimal value) {
        this.availbleBalance = value;
    }

    /**
     * Gets the value of the errorCode property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
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
     * Gets the value of the errorMsg property.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public JAXBElement<String> getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets the value of the errorMsg property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     */
    public void setErrorMsg(JAXBElement<String> value) {
        this.errorMsg = ((JAXBElement<String> ) value);
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
