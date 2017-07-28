package com.sdp.mc.withdraw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.1
 * 2012-08-07T17:44:50.099+08:00
 * Generated source version: 2.4.1
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "IPaymentFacade")
@XmlSeeAlso({com.sdp.mc.withdraw.entity.ObjectFactory.class, com.sdp.mc.withdraw.com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, ObjectFactory.class, com.sdp.mc.withdraw.com.microsoft.schemas._2003._10.serialization.arrays.ObjectFactory.class})
public interface IPaymentFacade {

    @WebResult(name = "QueryResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IPaymentFacade/Query", output = "http://tempuri.org/IPaymentFacade/QueryResponse")
    @RequestWrapper(localName = "Query", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.Query")
    @WebMethod(operationName = "Query", action = "http://tempuri.org/IPaymentFacade/Query")
    @ResponseWrapper(localName = "QueryResponse", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.QueryResponse")
    public com.sdp.mc.withdraw.entity.IResponse query(
        @WebParam(name = "request", targetNamespace = "http://tempuri.org/")
        com.sdp.mc.withdraw.entity.IRequest request
    );

    @WebResult(name = "PaymentResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IPaymentFacade/Payment", output = "http://tempuri.org/IPaymentFacade/PaymentResponse")
    @RequestWrapper(localName = "Payment", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.Payment")
    @WebMethod(operationName = "Payment", action = "http://tempuri.org/IPaymentFacade/Payment")
    @ResponseWrapper(localName = "PaymentResponse", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.PaymentResponse")
    public com.sdp.mc.withdraw.entity.IResponse payment(
        @WebParam(name = "request", targetNamespace = "http://tempuri.org/")
        com.sdp.mc.withdraw.entity.IRequest request
    );

    @WebResult(name = "CheckResult", targetNamespace = "http://tempuri.org/")
    @Action(input = "http://tempuri.org/IPaymentFacade/Check", output = "http://tempuri.org/IPaymentFacade/CheckResponse")
    @RequestWrapper(localName = "Check", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.Check")
    @WebMethod(operationName = "Check", action = "http://tempuri.org/IPaymentFacade/Check")
    @ResponseWrapper(localName = "CheckResponse", targetNamespace = "http://tempuri.org/", className = "com.sdp.mc.withdraw.CheckResponse")
    public com.sdp.mc.withdraw.entity.IResponse check(
        @WebParam(name = "request", targetNamespace = "http://tempuri.org/")
        com.sdp.mc.withdraw.entity.IRequest request
    );
}