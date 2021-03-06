
package com.sdp.mc.withdraw.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSinglePaymentAccount complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ArrayOfSinglePaymentAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SinglePaymentAccount" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}SinglePaymentAccount" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSinglePaymentAccount", propOrder = {
    "singlePaymentAccount"
})
public class ArrayOfSinglePaymentAccount {

    @XmlElement(name = "SinglePaymentAccount", nillable = true)
    protected List<SinglePaymentAccount> singlePaymentAccount;

    /**
     * Gets the value of the singlePaymentAccount property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the singlePaymentAccount property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSinglePaymentAccount().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SinglePaymentAccount }
     *
     *
     */
    public List<SinglePaymentAccount> getSinglePaymentAccount() {
        if (singlePaymentAccount == null) {
            singlePaymentAccount = new ArrayList<SinglePaymentAccount>();
        }
        return this.singlePaymentAccount;
    }

}
