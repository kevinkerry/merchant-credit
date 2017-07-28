
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SinglePaymentCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SinglePaymentCard">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}SinglePaymentBase">
 *       &lt;sequence>
 *         &lt;element name="CurrWithdrawType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}WithdrawType" minOccurs="0"/>
 *         &lt;element name="TargetBankBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankBranchCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankBranchCityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankBranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankBranchProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankBranchProvinceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetBankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WithdrawBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SinglePaymentCard", propOrder = {
    "currWithdrawType",
    "targetBankBranch",
    "targetBankBranchCity",
    "targetBankBranchCityName",
    "targetBankBranchName",
    "targetBankBranchProvince",
    "targetBankBranchProvinceName",
    "targetBankID",
    "targetBankName",
    "withdrawBankCode"
})
public class SinglePaymentCard
    extends SinglePaymentBase
{

    @XmlElement(name = "CurrWithdrawType")
    protected WithdrawType currWithdrawType;
    @XmlElementRef(name = "TargetBankBranch", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranch;
    @XmlElementRef(name = "TargetBankBranchCity", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranchCity;
    @XmlElementRef(name = "TargetBankBranchCityName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranchCityName;
    @XmlElementRef(name = "TargetBankBranchName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranchName;
    @XmlElementRef(name = "TargetBankBranchProvince", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranchProvince;
    @XmlElementRef(name = "TargetBankBranchProvinceName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankBranchProvinceName;
    @XmlElementRef(name = "TargetBankID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankID;
    @XmlElementRef(name = "TargetBankName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> targetBankName;
    @XmlElementRef(name = "WithdrawBankCode", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> withdrawBankCode;

    /**
     * Gets the value of the currWithdrawType property.
     * 
     * @return
     *     possible object is
     *     {@link WithdrawType }
     *     
     */
    public WithdrawType getCurrWithdrawType() {
        return currWithdrawType;
    }

    /**
     * Sets the value of the currWithdrawType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WithdrawType }
     *     
     */
    public void setCurrWithdrawType(WithdrawType value) {
        this.currWithdrawType = value;
    }

    /**
     * Gets the value of the targetBankBranch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranch() {
        return targetBankBranch;
    }

    /**
     * Sets the value of the targetBankBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranch(JAXBElement<String> value) {
        this.targetBankBranch = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankBranchCity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranchCity() {
        return targetBankBranchCity;
    }

    /**
     * Sets the value of the targetBankBranchCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranchCity(JAXBElement<String> value) {
        this.targetBankBranchCity = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankBranchCityName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranchCityName() {
        return targetBankBranchCityName;
    }

    /**
     * Sets the value of the targetBankBranchCityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranchCityName(JAXBElement<String> value) {
        this.targetBankBranchCityName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankBranchName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranchName() {
        return targetBankBranchName;
    }

    /**
     * Sets the value of the targetBankBranchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranchName(JAXBElement<String> value) {
        this.targetBankBranchName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankBranchProvince property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranchProvince() {
        return targetBankBranchProvince;
    }

    /**
     * Sets the value of the targetBankBranchProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranchProvince(JAXBElement<String> value) {
        this.targetBankBranchProvince = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankBranchProvinceName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankBranchProvinceName() {
        return targetBankBranchProvinceName;
    }

    /**
     * Sets the value of the targetBankBranchProvinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankBranchProvinceName(JAXBElement<String> value) {
        this.targetBankBranchProvinceName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankID() {
        return targetBankID;
    }

    /**
     * Sets the value of the targetBankID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankID(JAXBElement<String> value) {
        this.targetBankID = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the targetBankName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetBankName() {
        return targetBankName;
    }

    /**
     * Sets the value of the targetBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetBankName(JAXBElement<String> value) {
        this.targetBankName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the withdrawBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWithdrawBankCode() {
        return withdrawBankCode;
    }

    /**
     * Sets the value of the withdrawBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWithdrawBankCode(JAXBElement<String> value) {
        this.withdrawBankCode = ((JAXBElement<String> ) value);
    }

}
