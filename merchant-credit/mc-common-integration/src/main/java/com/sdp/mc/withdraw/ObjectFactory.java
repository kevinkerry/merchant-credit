
package com.sdp.mc.withdraw;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.sdp.mc.withdraw.entity.IRequest;
import com.sdp.mc.withdraw.entity.IResponse;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.shengpay.mpos.integration.withdraw package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryRequest_QNAME = new QName("http://tempuri.org/", "request");
    private final static QName _QueryResponseQueryResult_QNAME = new QName("http://tempuri.org/", "QueryResult");
    private final static QName _PaymentResponsePaymentResult_QNAME = new QName("http://tempuri.org/", "PaymentResult");
    private final static QName _CheckResponseCheckResult_QNAME = new QName("http://tempuri.org/", "CheckResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.shengpay.mpos.integration.withdraw
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Check }
     *
     */
    public Check createCheck() {
        return new Check();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     *
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link Query }
     *
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link CheckResponse }
     *
     */
    public CheckResponse createCheckResponse() {
        return new CheckResponse();
    }

    /**
     * Create an instance of {@link QueryResponse }
     *
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link Payment }
     *
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = Query.class)
    public JAXBElement<IRequest> createQueryRequest(IRequest value) {
        return new JAXBElement<IRequest>(_QueryRequest_QNAME, IRequest.class, Query.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "QueryResult", scope = QueryResponse.class)
    public JAXBElement<IResponse> createQueryResponseQueryResult(IResponse value) {
        return new JAXBElement<IResponse>(_QueryResponseQueryResult_QNAME, IResponse.class, QueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "PaymentResult", scope = PaymentResponse.class)
    public JAXBElement<IResponse> createPaymentResponsePaymentResult(IResponse value) {
        return new JAXBElement<IResponse>(_PaymentResponsePaymentResult_QNAME, IResponse.class, PaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = Payment.class)
    public JAXBElement<IRequest> createPaymentRequest(IRequest value) {
        return new JAXBElement<IRequest>(_QueryRequest_QNAME, IRequest.class, Payment.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "request", scope = Check.class)
    public JAXBElement<IRequest> createCheckRequest(IRequest value) {
        return new JAXBElement<IRequest>(_QueryRequest_QNAME, IRequest.class, Check.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CheckResult", scope = CheckResponse.class)
    public JAXBElement<IResponse> createCheckResponseCheckResult(IResponse value) {
        return new JAXBElement<IResponse>(_CheckResponseCheckResult_QNAME, IResponse.class, CheckResponse.class, value);
    }

}
