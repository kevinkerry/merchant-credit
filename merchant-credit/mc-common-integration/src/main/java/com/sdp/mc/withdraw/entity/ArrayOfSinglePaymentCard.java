
package com.sdp.mc.withdraw.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSinglePaymentCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSinglePaymentCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SinglePaymentCard" type="{http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity}SinglePaymentCard" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSinglePaymentCard", propOrder = {
    "singlePaymentCard"
})
public class ArrayOfSinglePaymentCard {

    @XmlElement(name = "SinglePaymentCard", nillable = true)
    protected List<SinglePaymentCard> singlePaymentCard;

    /**
     * Gets the value of the singlePaymentCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the singlePaymentCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSinglePaymentCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SinglePaymentCard }
     * 
     * 
     */
    public List<SinglePaymentCard> getSinglePaymentCard() {
        if (singlePaymentCard == null) {
            singlePaymentCard = new ArrayList<SinglePaymentCard>();
        }
        return this.singlePaymentCard;
    }

}
