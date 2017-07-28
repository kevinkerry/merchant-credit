
package com.sdp.mc.withdraw.entity;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WithdrawRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WithdrawRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}IRequest">
 *       &lt;sequence>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccountType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}TargetAccountType" minOccurs="0"/>
 *         &lt;element name="BankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ext1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ext2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MACString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantOrderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserType" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}UserType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WithdrawRequest", propOrder = {
    "accountID",
    "bankAccountName",
    "bankAccountNo",
    "bankAccountType",
    "bankName",
    "branch",
    "city",
    "ext1",
    "ext2",
    "macString",
    "merchantOrderID",
    "payAmount",
    "province",
    "remark",
    "userID",
    "userType"
})
public class WithdrawRequest
    extends IRequest
{

    @XmlElementRef(name = "AccountID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> accountID;
    @XmlElementRef(name = "BankAccountName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> bankAccountName;
    @XmlElementRef(name = "BankAccountNo", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> bankAccountNo;
    @XmlElement(name = "BankAccountType")
    protected TargetAccountType bankAccountType;
    @XmlElementRef(name = "BankName", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> bankName;
    @XmlElementRef(name = "Branch", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> branch;
    @XmlElementRef(name = "City", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> city;
    @XmlElementRef(name = "Ext1", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> ext1;
    @XmlElementRef(name = "Ext2", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> ext2;
    @XmlElementRef(name = "MACString", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> macString;
    @XmlElementRef(name = "MerchantOrderID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> merchantOrderID;
    @XmlElement(name = "PayAmount")
    protected BigDecimal payAmount;
    @XmlElementRef(name = "Province", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> province;
    @XmlElementRef(name = "Remark", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "UserID", namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", type = JAXBElement.class)
    protected JAXBElement<String> userID;
    @XmlElement(name = "UserType")
    protected UserType userType;

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
     * Gets the value of the bankAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountName() {
        return bankAccountName;
    }

    /**
     * Sets the value of the bankAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountName(JAXBElement<String> value) {
        this.bankAccountName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNo() {
        return bankAccountNo;
    }

    /**
     * Sets the value of the bankAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNo(JAXBElement<String> value) {
        this.bankAccountNo = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link TargetAccountType }
     *     
     */
    public TargetAccountType getBankAccountType() {
        return bankAccountType;
    }

    /**
     * Sets the value of the bankAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetAccountType }
     *     
     */
    public void setBankAccountType(TargetAccountType value) {
        this.bankAccountType = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankName(JAXBElement<String> value) {
        this.bankName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the branch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranch() {
        return branch;
    }

    /**
     * Sets the value of the branch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranch(JAXBElement<String> value) {
        this.branch = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCity(JAXBElement<String> value) {
        this.city = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ext1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExt1() {
        return ext1;
    }

    /**
     * Sets the value of the ext1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExt1(JAXBElement<String> value) {
        this.ext1 = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the ext2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExt2() {
        return ext2;
    }

    /**
     * Sets the value of the ext2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExt2(JAXBElement<String> value) {
        this.ext2 = ((JAXBElement<String> ) value);
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
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProvince(JAXBElement<String> value) {
        this.province = ((JAXBElement<String> ) value);
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

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUserType(UserType value) {
        this.userType = value;
    }

}
