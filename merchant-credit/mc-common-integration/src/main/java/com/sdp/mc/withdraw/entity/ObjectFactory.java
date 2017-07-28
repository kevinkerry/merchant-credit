
package com.sdp.mc.withdraw.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.sdp.mc.withdraw.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfintstring;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.shengpay.mpos.integration.withdraw.entity package.
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

    private final static QName _IResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "IResponse");
    private final static QName _BatchCardPayResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardPayResponse");
    private final static QName _TargetAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetAccountType");
    private final static QName _ArrayOfSinglePaymentAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ArrayOfSinglePaymentAccount");
    private final static QName _WithdrawRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawRequest");
    private final static QName _BatchCardRequestMTC_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardRequestMTC");
    private final static QName _TransferQueryRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TransferQueryRequest");
    private final static QName _WithdrawResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawResponse");
    private final static QName _TransferQueryResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TransferQueryResponse");
    private final static QName _IRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "IRequest");
    private final static QName _WithdrawQueryResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawQueryResult");
    private final static QName _BatchPaymentResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchPaymentResponse");
    private final static QName _UserType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "UserType");
    private final static QName _BatchCheckResponseMTC_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCheckResponseMTC");
    private final static QName _WithdrawQueryResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawQueryResponse");
    private final static QName _BatchCardCheckRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardCheckRequest");
    private final static QName _SinglePaymentBase_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SinglePaymentBase");
    private final static QName _PaymentType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PaymentType");
    private final static QName _TransferResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TransferResponse");
    private final static QName _BatchCardCheckResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardCheckResponse");
    private final static QName _TargetBankAccountType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankAccountType");
    private final static QName _SinglePaymentCard_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SinglePaymentCard");
    private final static QName _NeedCheckFundFlow_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "NeedCheckFundFlow");
    private final static QName _SinglePaymentAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SinglePaymentAccount");
    private final static QName _BatchCheckRequestMTC_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCheckRequestMTC");
    private final static QName _NeedInsertRecord_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "NeedInsertRecord");
    private final static QName _BatchCardPayRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardPayRequest");
    private final static QName _CheckPaymentResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "CheckPaymentResponse");
    private final static QName _WithdrawType_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawType");
    private final static QName _SinglePaymentResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SinglePaymentResponse");
    private final static QName _BatchCardResponseMTC_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchCardResponseMTC");
    private final static QName _ArrayOfSinglePaymentCard_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ArrayOfSinglePaymentCard");
    private final static QName _TransferRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TransferRequest");
    private final static QName _BatchPaymentRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchPaymentRequest");
    private final static QName _ArrayOfWithdrawQueryResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ArrayOfWithdrawQueryResult");
    private final static QName _BankCardInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BankCardInfo");
    private final static QName _WithdrawQueryRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawQueryRequest");
    private final static QName _BatchCardResponseMTCExt1_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Ext1");
    private final static QName _BatchCardResponseMTCExt2_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Ext2");
    private final static QName _BatchCardResponseMTCBatchNO_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchNO");
    private final static QName _BatchCardResponseMTCPayerSFTAccountNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayerSFTAccountNo");
    private final static QName _BatchCardResponseMTCUserID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "UserID");
    private final static QName _BatchCardResponseMTCProductCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ProductCode");
    private final static QName _BatchCardResponseMTCPayOrderAmount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayOrderAmount");
    private final static QName _BatchCardResponseMTCPayerMemberID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayerMemberID");
    private final static QName _BatchCardResponseMTCMerchantBatchNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MerchantBatchNo");
    private final static QName _SinglePaymentAccountTargetUserAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetUserAccount");
    private final static QName _BatchPaymentRequestRemark_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Remark");
    private final static QName _BatchPaymentRequestPayeeSFTAccountNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayeeSFTAccountNo");
    private final static QName _BatchPaymentRequestPayeeMemberid_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayeeMemberid");
    private final static QName _BatchPaymentRequestPayerMemberid_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayerMemberid");
    private final static QName _BatchPaymentRequestServerFileName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ServerFileName");
    private final static QName _BatchPaymentRequestMerchantBatchNO_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MerchantBatchNO");
    private final static QName _BatchPaymentRequestMerchantPtID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MerchantPtID");
    private final static QName _BatchPaymentRequestMerchantID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MerchantID");
    private final static QName _BatchPaymentRequestPaymentStream_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PaymentStream");
    private final static QName _BatchPaymentRequestFileName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "FileName");
    private final static QName _IResponseMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Message");
    private final static QName _WithdrawQueryResponseResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Result");
    private final static QName _SinglePaymentCardTargetBankName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankName");
    private final static QName _SinglePaymentCardTargetBankBranchCityName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranchCityName");
    private final static QName _SinglePaymentCardTargetBankBranchProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranchProvince");
    private final static QName _SinglePaymentCardWithdrawBankCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "WithdrawBankCode");
    private final static QName _SinglePaymentCardTargetBankBranchProvinceName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranchProvinceName");
    private final static QName _SinglePaymentCardTargetBankID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankID");
    private final static QName _SinglePaymentCardTargetBankBranchName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranchName");
    private final static QName _SinglePaymentCardTargetBankBranch_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranch");
    private final static QName _SinglePaymentCardTargetBankBranchCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetBankBranchCity");
    private final static QName _BatchCardCheckRequestCallFrom_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "CallFrom");
    private final static QName _WithdrawQueryResultBankInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BankInfo");
    private final static QName _WithdrawQueryResultMerchantOrderID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MerchantOrderID");
    private final static QName _WithdrawQueryResultBankAccountNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BankAccountNo");
    private final static QName _WithdrawQueryResultOrderNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "OrderNo");
    private final static QName _WithdrawQueryResultAccountID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "AccountID");
    private final static QName _WithdrawQueryResultPrefix6_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Prefix6");
    private final static QName _WithdrawQueryResultPaymentNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PaymentNo");
    private final static QName _WithdrawQueryResultSuffix4_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Suffix4");
    private final static QName _WithdrawQueryResultPayStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayStatus");
    private final static QName _BatchCheckRequestMTCStoreKey_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "StoreKey");
    private final static QName _BatchCheckRequestMTCFileUrl_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "FileUrl");
    private final static QName _BatchCheckRequestMTCMACString_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "MACString");
    private final static QName _BatchCardPayRequestFileKey_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "FileKey");
    private final static QName _BankCardInfoProvince_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Province");
    private final static QName _BankCardInfoBankName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BankName");
    private final static QName _BankCardInfoCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "City");
    private final static QName _BankCardInfoBankAccountName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BankAccountName");
    private final static QName _BankCardInfoBranch_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "Branch");
    private final static QName _SinglePaymentBasePayMerchantID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayMerchantID");
    private final static QName _SinglePaymentBasePaymentSeqNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PaymentSeqNo");
    private final static QName _SinglePaymentBaseItemID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ItemID");
    private final static QName _SinglePaymentBaseExceptionInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ExceptionInfo");
    private final static QName _SinglePaymentBasePayChannel_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayChannel");
    private final static QName _SinglePaymentBaseTargetUserName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetUserName");
    private final static QName _SinglePaymentBaseRealMerchantID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "RealMerchantID");
    private final static QName _SinglePaymentBaseTargetAccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "TargetAccount");
    private final static QName _BatchPaymentResponseBatchMerchantNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchMerchantNo");
    private final static QName _BatchPaymentResponseErrorList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ErrorList");
    private final static QName _BatchPaymentResponseUploadFileName_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "UploadFileName");
    private final static QName _BatchPaymentResponseSingleCardList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SingleCardList");
    private final static QName _BatchPaymentResponseSingleAccountList_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "SingleAccountList");
    private final static QName _BatchPaymentResponsePayPtID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayPtID");
    private final static QName _BatchCardRequestMTCCallbackAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "CallbackAddress");
    private final static QName _TransferRequestPayerAccountID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayerAccountID");
    private final static QName _TransferRequestPayeeAccountID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayeeAccountID");
    private final static QName _TransferRequestPayeeMerchantID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "PayeeMerchantID");
    private final static QName _WithdrawQueryRequestBatchNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BatchNo");
    private final static QName _WithdrawQueryRequestEndTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "EndTime");
    private final static QName _WithdrawQueryRequestBeginTime_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "BeginTime");
    private final static QName _CheckPaymentResponseErrorMsg_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ErrorMsg");
    private final static QName _IRequestAppID_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "AppID");
    private final static QName _IRequestClientIP_QNAME = new QName("http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", "ClientIP");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.shengpay.mpos.integration.withdraw.entity
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IRequest }
     *
     */
    public IRequest createIRequest() {
        return new IRequest();
    }

    /**
     * Create an instance of {@link IResponse }
     *
     */
    public IResponse createIResponse() {
        return new IResponse();
    }

    /**
     * Create an instance of {@link ArrayOfSinglePaymentAccount }
     *
     */
    public ArrayOfSinglePaymentAccount createArrayOfSinglePaymentAccount() {
        return new ArrayOfSinglePaymentAccount();
    }

    /**
     * Create an instance of {@link SinglePaymentAccount }
     *
     */
    public SinglePaymentAccount createSinglePaymentAccount() {
        return new SinglePaymentAccount();
    }

    /**
     * Create an instance of {@link BatchCardPayResponse }
     *
     */
    public BatchCardPayResponse createBatchCardPayResponse() {
        return new BatchCardPayResponse();
    }

    /**
     * Create an instance of {@link BatchCheckRequestMTC }
     *
     */
    public BatchCheckRequestMTC createBatchCheckRequestMTC() {
        return new BatchCheckRequestMTC();
    }

    /**
     * Create an instance of {@link SinglePaymentCard }
     *
     */
    public SinglePaymentCard createSinglePaymentCard() {
        return new SinglePaymentCard();
    }

    /**
     * Create an instance of {@link BatchCardCheckResponse }
     *
     */
    public BatchCardCheckResponse createBatchCardCheckResponse() {
        return new BatchCardCheckResponse();
    }

    /**
     * Create an instance of {@link SinglePaymentResponse }
     *
     */
    public SinglePaymentResponse createSinglePaymentResponse() {
        return new SinglePaymentResponse();
    }

    /**
     * Create an instance of {@link WithdrawRequest }
     *
     */
    public WithdrawRequest createWithdrawRequest() {
        return new WithdrawRequest();
    }

    /**
     * Create an instance of {@link BatchCardRequestMTC }
     *
     */
    public BatchCardRequestMTC createBatchCardRequestMTC() {
        return new BatchCardRequestMTC();
    }

    /**
     * Create an instance of {@link TransferQueryRequest }
     *
     */
    public TransferQueryRequest createTransferQueryRequest() {
        return new TransferQueryRequest();
    }

    /**
     * Create an instance of {@link CheckPaymentResponse }
     *
     */
    public CheckPaymentResponse createCheckPaymentResponse() {
        return new CheckPaymentResponse();
    }

    /**
     * Create an instance of {@link BatchCardPayRequest }
     *
     */
    public BatchCardPayRequest createBatchCardPayRequest() {
        return new BatchCardPayRequest();
    }

    /**
     * Create an instance of {@link BatchCheckResponseMTC }
     *
     */
    public BatchCheckResponseMTC createBatchCheckResponseMTC() {
        return new BatchCheckResponseMTC();
    }

    /**
     * Create an instance of {@link ArrayOfWithdrawQueryResult }
     *
     */
    public ArrayOfWithdrawQueryResult createArrayOfWithdrawQueryResult() {
        return new ArrayOfWithdrawQueryResult();
    }

    /**
     * Create an instance of {@link BatchPaymentResponse }
     *
     */
    public BatchPaymentResponse createBatchPaymentResponse() {
        return new BatchPaymentResponse();
    }

    /**
     * Create an instance of {@link WithdrawQueryResult }
     *
     */
    public WithdrawQueryResult createWithdrawQueryResult() {
        return new WithdrawQueryResult();
    }

    /**
     * Create an instance of {@link TransferRequest }
     *
     */
    public TransferRequest createTransferRequest() {
        return new TransferRequest();
    }

    /**
     * Create an instance of {@link BatchPaymentRequest }
     *
     */
    public BatchPaymentRequest createBatchPaymentRequest() {
        return new BatchPaymentRequest();
    }

    /**
     * Create an instance of {@link BatchCardResponseMTC }
     *
     */
    public BatchCardResponseMTC createBatchCardResponseMTC() {
        return new BatchCardResponseMTC();
    }

    /**
     * Create an instance of {@link ArrayOfSinglePaymentCard }
     *
     */
    public ArrayOfSinglePaymentCard createArrayOfSinglePaymentCard() {
        return new ArrayOfSinglePaymentCard();
    }

    /**
     * Create an instance of {@link WithdrawResponse }
     *
     */
    public WithdrawResponse createWithdrawResponse() {
        return new WithdrawResponse();
    }

    /**
     * Create an instance of {@link TransferQueryResponse }
     *
     */
    public TransferQueryResponse createTransferQueryResponse() {
        return new TransferQueryResponse();
    }

    /**
     * Create an instance of {@link WithdrawQueryRequest }
     *
     */
    public WithdrawQueryRequest createWithdrawQueryRequest() {
        return new WithdrawQueryRequest();
    }

    /**
     * Create an instance of {@link TransferResponse }
     *
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link BankCardInfo }
     *
     */
    public BankCardInfo createBankCardInfo() {
        return new BankCardInfo();
    }

    /**
     * Create an instance of {@link SinglePaymentBase }
     *
     */
    public SinglePaymentBase createSinglePaymentBase() {
        return new SinglePaymentBase();
    }

    /**
     * Create an instance of {@link BatchCardCheckRequest }
     *
     */
    public BatchCardCheckRequest createBatchCardCheckRequest() {
        return new BatchCardCheckRequest();
    }

    /**
     * Create an instance of {@link WithdrawQueryResponse }
     *
     */
    public WithdrawQueryResponse createWithdrawQueryResponse() {
        return new WithdrawQueryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "IResponse")
    public JAXBElement<IResponse> createIResponse(IResponse value) {
        return new JAXBElement<IResponse>(_IResponse_QNAME, IResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardPayResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardPayResponse")
    public JAXBElement<BatchCardPayResponse> createBatchCardPayResponse(BatchCardPayResponse value) {
        return new JAXBElement<BatchCardPayResponse>(_BatchCardPayResponse_QNAME, BatchCardPayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetAccountType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetAccountType")
    public JAXBElement<TargetAccountType> createTargetAccountType(TargetAccountType value) {
        return new JAXBElement<TargetAccountType>(_TargetAccountType_QNAME, TargetAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentAccount }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ArrayOfSinglePaymentAccount")
    public JAXBElement<ArrayOfSinglePaymentAccount> createArrayOfSinglePaymentAccount(ArrayOfSinglePaymentAccount value) {
        return new JAXBElement<ArrayOfSinglePaymentAccount>(_ArrayOfSinglePaymentAccount_QNAME, ArrayOfSinglePaymentAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawRequest")
    public JAXBElement<WithdrawRequest> createWithdrawRequest(WithdrawRequest value) {
        return new JAXBElement<WithdrawRequest>(_WithdrawRequest_QNAME, WithdrawRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardRequestMTC }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardRequestMTC")
    public JAXBElement<BatchCardRequestMTC> createBatchCardRequestMTC(BatchCardRequestMTC value) {
        return new JAXBElement<BatchCardRequestMTC>(_BatchCardRequestMTC_QNAME, BatchCardRequestMTC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferQueryRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TransferQueryRequest")
    public JAXBElement<TransferQueryRequest> createTransferQueryRequest(TransferQueryRequest value) {
        return new JAXBElement<TransferQueryRequest>(_TransferQueryRequest_QNAME, TransferQueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawResponse")
    public JAXBElement<WithdrawResponse> createWithdrawResponse(WithdrawResponse value) {
        return new JAXBElement<WithdrawResponse>(_WithdrawResponse_QNAME, WithdrawResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferQueryResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TransferQueryResponse")
    public JAXBElement<TransferQueryResponse> createTransferQueryResponse(TransferQueryResponse value) {
        return new JAXBElement<TransferQueryResponse>(_TransferQueryResponse_QNAME, TransferQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "IRequest")
    public JAXBElement<IRequest> createIRequest(IRequest value) {
        return new JAXBElement<IRequest>(_IRequest_QNAME, IRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawQueryResult }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawQueryResult")
    public JAXBElement<WithdrawQueryResult> createWithdrawQueryResult(WithdrawQueryResult value) {
        return new JAXBElement<WithdrawQueryResult>(_WithdrawQueryResult_QNAME, WithdrawQueryResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchPaymentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchPaymentResponse")
    public JAXBElement<BatchPaymentResponse> createBatchPaymentResponse(BatchPaymentResponse value) {
        return new JAXBElement<BatchPaymentResponse>(_BatchPaymentResponse_QNAME, BatchPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserType")
    public JAXBElement<UserType> createUserType(UserType value) {
        return new JAXBElement<UserType>(_UserType_QNAME, UserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCheckResponseMTC }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCheckResponseMTC")
    public JAXBElement<BatchCheckResponseMTC> createBatchCheckResponseMTC(BatchCheckResponseMTC value) {
        return new JAXBElement<BatchCheckResponseMTC>(_BatchCheckResponseMTC_QNAME, BatchCheckResponseMTC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawQueryResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawQueryResponse")
    public JAXBElement<WithdrawQueryResponse> createWithdrawQueryResponse(WithdrawQueryResponse value) {
        return new JAXBElement<WithdrawQueryResponse>(_WithdrawQueryResponse_QNAME, WithdrawQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardCheckRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardCheckRequest")
    public JAXBElement<BatchCardCheckRequest> createBatchCardCheckRequest(BatchCardCheckRequest value) {
        return new JAXBElement<BatchCardCheckRequest>(_BatchCardCheckRequest_QNAME, BatchCardCheckRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SinglePaymentBase }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SinglePaymentBase")
    public JAXBElement<SinglePaymentBase> createSinglePaymentBase(SinglePaymentBase value) {
        return new JAXBElement<SinglePaymentBase>(_SinglePaymentBase_QNAME, SinglePaymentBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentType")
    public JAXBElement<PaymentType> createPaymentType(PaymentType value) {
        return new JAXBElement<PaymentType>(_PaymentType_QNAME, PaymentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TransferResponse")
    public JAXBElement<TransferResponse> createTransferResponse(TransferResponse value) {
        return new JAXBElement<TransferResponse>(_TransferResponse_QNAME, TransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardCheckResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardCheckResponse")
    public JAXBElement<BatchCardCheckResponse> createBatchCardCheckResponse(BatchCardCheckResponse value) {
        return new JAXBElement<BatchCardCheckResponse>(_BatchCardCheckResponse_QNAME, BatchCardCheckResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetBankAccountType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankAccountType")
    public JAXBElement<TargetBankAccountType> createTargetBankAccountType(TargetBankAccountType value) {
        return new JAXBElement<TargetBankAccountType>(_TargetBankAccountType_QNAME, TargetBankAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SinglePaymentCard }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SinglePaymentCard")
    public JAXBElement<SinglePaymentCard> createSinglePaymentCard(SinglePaymentCard value) {
        return new JAXBElement<SinglePaymentCard>(_SinglePaymentCard_QNAME, SinglePaymentCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeedCheckFundFlow }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "NeedCheckFundFlow")
    public JAXBElement<NeedCheckFundFlow> createNeedCheckFundFlow(NeedCheckFundFlow value) {
        return new JAXBElement<NeedCheckFundFlow>(_NeedCheckFundFlow_QNAME, NeedCheckFundFlow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SinglePaymentAccount }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SinglePaymentAccount")
    public JAXBElement<SinglePaymentAccount> createSinglePaymentAccount(SinglePaymentAccount value) {
        return new JAXBElement<SinglePaymentAccount>(_SinglePaymentAccount_QNAME, SinglePaymentAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCheckRequestMTC }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCheckRequestMTC")
    public JAXBElement<BatchCheckRequestMTC> createBatchCheckRequestMTC(BatchCheckRequestMTC value) {
        return new JAXBElement<BatchCheckRequestMTC>(_BatchCheckRequestMTC_QNAME, BatchCheckRequestMTC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NeedInsertRecord }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "NeedInsertRecord")
    public JAXBElement<NeedInsertRecord> createNeedInsertRecord(NeedInsertRecord value) {
        return new JAXBElement<NeedInsertRecord>(_NeedInsertRecord_QNAME, NeedInsertRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardPayRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardPayRequest")
    public JAXBElement<BatchCardPayRequest> createBatchCardPayRequest(BatchCardPayRequest value) {
        return new JAXBElement<BatchCardPayRequest>(_BatchCardPayRequest_QNAME, BatchCardPayRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckPaymentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "CheckPaymentResponse")
    public JAXBElement<CheckPaymentResponse> createCheckPaymentResponse(CheckPaymentResponse value) {
        return new JAXBElement<CheckPaymentResponse>(_CheckPaymentResponse_QNAME, CheckPaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawType")
    public JAXBElement<WithdrawType> createWithdrawType(WithdrawType value) {
        return new JAXBElement<WithdrawType>(_WithdrawType_QNAME, WithdrawType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SinglePaymentResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SinglePaymentResponse")
    public JAXBElement<SinglePaymentResponse> createSinglePaymentResponse(SinglePaymentResponse value) {
        return new JAXBElement<SinglePaymentResponse>(_SinglePaymentResponse_QNAME, SinglePaymentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchCardResponseMTC }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchCardResponseMTC")
    public JAXBElement<BatchCardResponseMTC> createBatchCardResponseMTC(BatchCardResponseMTC value) {
        return new JAXBElement<BatchCardResponseMTC>(_BatchCardResponseMTC_QNAME, BatchCardResponseMTC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentCard }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ArrayOfSinglePaymentCard")
    public JAXBElement<ArrayOfSinglePaymentCard> createArrayOfSinglePaymentCard(ArrayOfSinglePaymentCard value) {
        return new JAXBElement<ArrayOfSinglePaymentCard>(_ArrayOfSinglePaymentCard_QNAME, ArrayOfSinglePaymentCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransferRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TransferRequest")
    public JAXBElement<TransferRequest> createTransferRequest(TransferRequest value) {
        return new JAXBElement<TransferRequest>(_TransferRequest_QNAME, TransferRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchPaymentRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchPaymentRequest")
    public JAXBElement<BatchPaymentRequest> createBatchPaymentRequest(BatchPaymentRequest value) {
        return new JAXBElement<BatchPaymentRequest>(_BatchPaymentRequest_QNAME, BatchPaymentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWithdrawQueryResult }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ArrayOfWithdrawQueryResult")
    public JAXBElement<ArrayOfWithdrawQueryResult> createArrayOfWithdrawQueryResult(ArrayOfWithdrawQueryResult value) {
        return new JAXBElement<ArrayOfWithdrawQueryResult>(_ArrayOfWithdrawQueryResult_QNAME, ArrayOfWithdrawQueryResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankCardInfo }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankCardInfo")
    public JAXBElement<BankCardInfo> createBankCardInfo(BankCardInfo value) {
        return new JAXBElement<BankCardInfo>(_BankCardInfo_QNAME, BankCardInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawQueryRequest }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawQueryRequest")
    public JAXBElement<WithdrawQueryRequest> createWithdrawQueryRequest(WithdrawQueryRequest value) {
        return new JAXBElement<WithdrawQueryRequest>(_WithdrawQueryRequest_QNAME, WithdrawQueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = BatchCardResponseMTC.class)
    public JAXBElement<Object> createBatchCardResponseMTCExt1(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt1_QNAME, Object.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = BatchCardResponseMTC.class)
    public JAXBElement<Object> createBatchCardResponseMTCExt2(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt2_QNAME, Object.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCPayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ProductCode", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCProductCode(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCProductCode_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayOrderAmount", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCPayOrderAmount(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayOrderAmount_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberID", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCPayerMemberID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerMemberID_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNo", scope = BatchCardResponseMTC.class)
    public JAXBElement<String> createBatchCardResponseMTCMerchantBatchNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCMerchantBatchNo_QNAME, String.class, BatchCardResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetUserAccount", scope = SinglePaymentAccount.class)
    public JAXBElement<String> createSinglePaymentAccountTargetUserAccount(String value) {
        return new JAXBElement<String>(_SinglePaymentAccountTargetUserAccount_QNAME, String.class, SinglePaymentAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeSFTAccountNo", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestPayeeSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeSFTAccountNo_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeMemberid", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestPayeeMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeMemberid_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestPayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberid", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestPayerMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayerMemberid_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ServerFileName", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestServerFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestServerFileName_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNO", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestMerchantBatchNO(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantBatchNO_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantPtID", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestMerchantPtID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantPtID_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantID", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestMerchantID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantID_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentStream", scope = BatchPaymentRequest.class)
    public JAXBElement<byte[]> createBatchPaymentRequestPaymentStream(byte[] value) {
        return new JAXBElement<byte[]>(_BatchPaymentRequestPaymentStream_QNAME, byte[].class, BatchPaymentRequest.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileName", scope = BatchPaymentRequest.class)
    public JAXBElement<String> createBatchPaymentRequestFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestFileName_QNAME, String.class, BatchPaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Message", scope = IResponse.class)
    public JAXBElement<String> createIResponseMessage(String value) {
        return new JAXBElement<String>(_IResponseMessage_QNAME, String.class, IResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = WithdrawQueryResponse.class)
    public JAXBElement<Object> createWithdrawQueryResponseExt1(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt1_QNAME, Object.class, WithdrawQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = WithdrawQueryResponse.class)
    public JAXBElement<Object> createWithdrawQueryResponseExt2(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt2_QNAME, Object.class, WithdrawQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfWithdrawQueryResult }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Result", scope = WithdrawQueryResponse.class)
    public JAXBElement<ArrayOfWithdrawQueryResult> createWithdrawQueryResponseResult(ArrayOfWithdrawQueryResult value) {
        return new JAXBElement<ArrayOfWithdrawQueryResult>(_WithdrawQueryResponseResult_QNAME, ArrayOfWithdrawQueryResult.class, WithdrawQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankName", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankName(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankName_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranchCityName", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranchCityName(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranchCityName_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranchProvince", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranchProvince(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranchProvince_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "WithdrawBankCode", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardWithdrawBankCode(String value) {
        return new JAXBElement<String>(_SinglePaymentCardWithdrawBankCode_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranchProvinceName", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranchProvinceName(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranchProvinceName_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankID", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankID(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankID_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranchName", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranchName(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranchName_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranch", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranch(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranch_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetBankBranchCity", scope = SinglePaymentCard.class)
    public JAXBElement<String> createSinglePaymentCardTargetBankBranchCity(String value) {
        return new JAXBElement<String>(_SinglePaymentCardTargetBankBranchCity_QNAME, String.class, SinglePaymentCard.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeSFTAccountNo", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestPayeeSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeSFTAccountNo_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "CallFrom", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestCallFrom(String value) {
        return new JAXBElement<String>(_BatchCardCheckRequestCallFrom_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestPayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ServerFileName", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestServerFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestServerFileName_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantPtID", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestMerchantPtID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantPtID_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentStream", scope = BatchCardCheckRequest.class)
    public JAXBElement<byte[]> createBatchCardCheckRequestPaymentStream(byte[] value) {
        return new JAXBElement<byte[]>(_BatchPaymentRequestPaymentStream_QNAME, byte[].class, BatchCardCheckRequest.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeMemberid", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestPayeeMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeMemberid_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberid", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestPayerMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayerMemberid_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNO", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestMerchantBatchNO(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantBatchNO_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantID", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestMerchantID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantID_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileName", scope = BatchCardCheckRequest.class)
    public JAXBElement<String> createBatchCardCheckRequestFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestFileName_QNAME, String.class, BatchCardCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankCardInfo }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankInfo", scope = WithdrawQueryResult.class)
    public JAXBElement<BankCardInfo> createWithdrawQueryResultBankInfo(BankCardInfo value) {
        return new JAXBElement<BankCardInfo>(_WithdrawQueryResultBankInfo_QNAME, BankCardInfo.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantOrderID", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultMerchantOrderID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultMerchantOrderID_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankAccountNo", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultBankAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultBankAccountNo_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "AccountID", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultAccountID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultAccountID_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Prefix6", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultPrefix6(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPrefix6_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentNo", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultPaymentNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPaymentNo_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Suffix4", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultSuffix4(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultSuffix4_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = WithdrawQueryResult.class)
    public JAXBElement<String> createWithdrawQueryResultPayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, WithdrawQueryResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "StoreKey", scope = BatchCheckRequestMTC.class)
    public JAXBElement<String> createBatchCheckRequestMTCStoreKey(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCStoreKey_QNAME, String.class, BatchCheckRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNO", scope = BatchCheckRequestMTC.class)
    public JAXBElement<String> createBatchCheckRequestMTCMerchantBatchNO(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantBatchNO_QNAME, String.class, BatchCheckRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = BatchCheckRequestMTC.class)
    public JAXBElement<String> createBatchCheckRequestMTCUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, BatchCheckRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileUrl", scope = BatchCheckRequestMTC.class)
    public JAXBElement<String> createBatchCheckRequestMTCFileUrl(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCFileUrl_QNAME, String.class, BatchCheckRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = BatchCheckRequestMTC.class)
    public JAXBElement<String> createBatchCheckRequestMTCMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, BatchCheckRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeSFTAccountNo", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestPayeeSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeSFTAccountNo_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "CallFrom", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestCallFrom(String value) {
        return new JAXBElement<String>(_BatchCardCheckRequestCallFrom_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestPayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantPtID", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestMerchantPtID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantPtID_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentStream", scope = BatchCardPayRequest.class)
    public JAXBElement<byte[]> createBatchCardPayRequestPaymentStream(byte[] value) {
        return new JAXBElement<byte[]>(_BatchPaymentRequestPaymentStream_QNAME, byte[].class, BatchCardPayRequest.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileKey", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestFileKey(String value) {
        return new JAXBElement<String>(_BatchCardPayRequestFileKey_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "StoreKey", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestStoreKey(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCStoreKey_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeMemberid", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestPayeeMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeMemberid_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberid", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestPayerMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayerMemberid_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNO", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestMerchantBatchNO(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantBatchNO_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantID", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestMerchantID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantID_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileName", scope = BatchCardPayRequest.class)
    public JAXBElement<String> createBatchCardPayRequestFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestFileName_QNAME, String.class, BatchCardPayRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = TransferResponse.class)
    public JAXBElement<String> createTransferResponseUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, TransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = TransferResponse.class)
    public JAXBElement<String> createTransferResponseOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, TransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = TransferResponse.class)
    public JAXBElement<String> createTransferResponsePayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, TransferResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Province", scope = BankCardInfo.class)
    public JAXBElement<String> createBankCardInfoProvince(String value) {
        return new JAXBElement<String>(_BankCardInfoProvince_QNAME, String.class, BankCardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankName", scope = BankCardInfo.class)
    public JAXBElement<String> createBankCardInfoBankName(String value) {
        return new JAXBElement<String>(_BankCardInfoBankName_QNAME, String.class, BankCardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "City", scope = BankCardInfo.class)
    public JAXBElement<String> createBankCardInfoCity(String value) {
        return new JAXBElement<String>(_BankCardInfoCity_QNAME, String.class, BankCardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankAccountName", scope = BankCardInfo.class)
    public JAXBElement<String> createBankCardInfoBankAccountName(String value) {
        return new JAXBElement<String>(_BankCardInfoBankAccountName_QNAME, String.class, BankCardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Branch", scope = BankCardInfo.class)
    public JAXBElement<String> createBankCardInfoBranch(String value) {
        return new JAXBElement<String>(_BankCardInfoBranch_QNAME, String.class, BankCardInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeSFTAccountNo", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayeeSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeSFTAccountNo_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantPtID", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseMerchantPtID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantPtID_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Message", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseMessage(String value) {
        return new JAXBElement<String>(_IResponseMessage_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayMerchantID", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayMerchantID(String value) {
        return new JAXBElement<String>(_SinglePaymentBasePayMerchantID_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentSeqNo", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePaymentSeqNo(String value) {
        return new JAXBElement<String>(_SinglePaymentBasePaymentSeqNo_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ItemID", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseItemID(String value) {
        return new JAXBElement<String>(_SinglePaymentBaseItemID_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ExceptionInfo", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseExceptionInfo(String value) {
        return new JAXBElement<String>(_SinglePaymentBaseExceptionInfo_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayChannel", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayChannel(String value) {
        return new JAXBElement<String>(_SinglePaymentBasePayChannel_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetUserName", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseTargetUserName(String value) {
        return new JAXBElement<String>(_SinglePaymentBaseTargetUserName_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "RealMerchantID", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseRealMerchantID(String value) {
        return new JAXBElement<String>(_SinglePaymentBaseRealMerchantID_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeMemberid", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayeeMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayeeMemberid_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberid", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayerMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayerMemberid_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantID", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseMerchantID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantID_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "TargetAccount", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseTargetAccount(String value) {
        return new JAXBElement<String>(_SinglePaymentBaseTargetAccount_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBaseMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = SinglePaymentBase.class)
    public JAXBElement<String> createSinglePaymentBasePayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, SinglePaymentBase.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchCardCheckResponse.class)
    public JAXBElement<String> createBatchCardCheckResponseBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchCardCheckResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileKey", scope = BatchCardCheckResponse.class)
    public JAXBElement<String> createBatchCardCheckResponseFileKey(String value) {
        return new JAXBElement<String>(_BatchCardPayRequestFileKey_QNAME, String.class, BatchCardCheckResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchMerchantNo", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponseBatchMerchantNo(String value) {
        return new JAXBElement<String>(_BatchPaymentResponseBatchMerchantNo_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNO", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponseBatchNO(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCBatchNO_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponsePayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerMemberid", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponsePayerMemberid(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestPayerMemberid_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintstring }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ErrorList", scope = BatchPaymentResponse.class)
    public JAXBElement<ArrayOfKeyValueOfintstring> createBatchPaymentResponseErrorList(ArrayOfKeyValueOfintstring value) {
        return new JAXBElement<ArrayOfKeyValueOfintstring>(_BatchPaymentResponseErrorList_QNAME, ArrayOfKeyValueOfintstring.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantID", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponseMerchantID(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestMerchantID_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ProductCode", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponseProductCode(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCProductCode_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UploadFileName", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponseUploadFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentResponseUploadFileName_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentCard }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SingleCardList", scope = BatchPaymentResponse.class)
    public JAXBElement<ArrayOfSinglePaymentCard> createBatchPaymentResponseSingleCardList(ArrayOfSinglePaymentCard value) {
        return new JAXBElement<ArrayOfSinglePaymentCard>(_BatchPaymentResponseSingleCardList_QNAME, ArrayOfSinglePaymentCard.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfSinglePaymentAccount }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "SingleAccountList", scope = BatchPaymentResponse.class)
    public JAXBElement<ArrayOfSinglePaymentAccount> createBatchPaymentResponseSingleAccountList(ArrayOfSinglePaymentAccount value) {
        return new JAXBElement<ArrayOfSinglePaymentAccount>(_BatchPaymentResponseSingleAccountList_QNAME, ArrayOfSinglePaymentAccount.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayPtID", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponsePayPtID(String value) {
        return new JAXBElement<String>(_BatchPaymentResponsePayPtID_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayChannel", scope = BatchPaymentResponse.class)
    public JAXBElement<String> createBatchPaymentResponsePayChannel(String value) {
        return new JAXBElement<String>(_SinglePaymentBasePayChannel_QNAME, String.class, BatchPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "StoreKey", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCStoreKey(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCStoreKey_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCExt1(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt1_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCExt2(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt2_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerSFTAccountNo", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCPayerSFTAccountNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCPayerSFTAccountNo_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "CallbackAddress", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCCallbackAddress(String value) {
        return new JAXBElement<String>(_BatchCardRequestMTCCallbackAddress_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "FileUrl", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCFileUrl(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCFileUrl_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantBatchNo", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCMerchantBatchNo(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCMerchantBatchNo_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = BatchCardRequestMTC.class)
    public JAXBElement<String> createBatchCardRequestMTCMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, BatchCardRequestMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestExt1(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt1_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantOrderID", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestMerchantOrderID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultMerchantOrderID_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestExt2(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt2_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayerAccountID", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestPayerAccountID(String value) {
        return new JAXBElement<String>(_TransferRequestPayerAccountID_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeAccountID", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestPayeeAccountID(String value) {
        return new JAXBElement<String>(_TransferRequestPayeeAccountID_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayeeMerchantID", scope = TransferRequest.class)
    public JAXBElement<String> createTransferRequestPayeeMerchantID(String value) {
        return new JAXBElement<String>(_TransferRequestPayeeMerchantID_QNAME, String.class, TransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = BatchCheckResponseMTC.class)
    public JAXBElement<Object> createBatchCheckResponseMTCExt1(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt1_QNAME, Object.class, BatchCheckResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = BatchCheckResponseMTC.class)
    public JAXBElement<Object> createBatchCheckResponseMTCExt2(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt2_QNAME, Object.class, BatchCheckResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = BatchCheckResponseMTC.class)
    public JAXBElement<String> createBatchCheckResponseMTCUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, BatchCheckResponseMTC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankName", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestBankName(String value) {
        return new JAXBElement<String>(_BankCardInfoBankName_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Province", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestProvince(String value) {
        return new JAXBElement<String>(_BankCardInfoProvince_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "City", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestCity(String value) {
        return new JAXBElement<String>(_BankCardInfoCity_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "AccountID", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestAccountID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultAccountID_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Branch", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestBranch(String value) {
        return new JAXBElement<String>(_BankCardInfoBranch_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestExt1(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt1_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestExt2(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCExt2_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantOrderID", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestMerchantOrderID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultMerchantOrderID_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankAccountNo", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestBankAccountNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultBankAccountNo_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BankAccountName", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestBankAccountName(String value) {
        return new JAXBElement<String>(_BankCardInfoBankAccountName_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = WithdrawRequest.class)
    public JAXBElement<String> createWithdrawRequestMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, WithdrawRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = WithdrawResponse.class)
    public JAXBElement<String> createWithdrawResponseUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, WithdrawResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = WithdrawResponse.class)
    public JAXBElement<String> createWithdrawResponseOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, WithdrawResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = WithdrawResponse.class)
    public JAXBElement<String> createWithdrawResponsePayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, WithdrawResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BatchNo", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestBatchNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryRequestBatchNo_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "EndTime", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestEndTime(String value) {
        return new JAXBElement<String>(_WithdrawQueryRequestEndTime_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "BeginTime", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestBeginTime(String value) {
        return new JAXBElement<String>(_WithdrawQueryRequestBeginTime_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = WithdrawQueryRequest.class)
    public JAXBElement<String> createWithdrawQueryRequestPayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, WithdrawQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Remark", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponseRemark(String value) {
        return new JAXBElement<String>(_BatchPaymentRequestRemark_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext1", scope = TransferQueryResponse.class)
    public JAXBElement<Object> createTransferQueryResponseExt1(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt1_QNAME, Object.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantOrderID", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponseMerchantOrderID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultMerchantOrderID_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "Ext2", scope = TransferQueryResponse.class)
    public JAXBElement<Object> createTransferQueryResponseExt2(Object value) {
        return new JAXBElement<Object>(_BatchCardResponseMTCExt2_QNAME, Object.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponseUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponseOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "AccountID", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponseAccountID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultAccountID_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PaymentNo", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponsePaymentNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPaymentNo_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "PayStatus", scope = TransferQueryResponse.class)
    public JAXBElement<String> createTransferQueryResponsePayStatus(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultPayStatus_QNAME, String.class, TransferQueryResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfintstring }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ErrorList", scope = CheckPaymentResponse.class)
    public JAXBElement<ArrayOfKeyValueOfintstring> createCheckPaymentResponseErrorList(ArrayOfKeyValueOfintstring value) {
        return new JAXBElement<ArrayOfKeyValueOfintstring>(_BatchPaymentResponseErrorList_QNAME, ArrayOfKeyValueOfintstring.class, CheckPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ErrorMsg", scope = CheckPaymentResponse.class)
    public JAXBElement<String> createCheckPaymentResponseErrorMsg(String value) {
        return new JAXBElement<String>(_CheckPaymentResponseErrorMsg_QNAME, String.class, CheckPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UploadFileName", scope = CheckPaymentResponse.class)
    public JAXBElement<String> createCheckPaymentResponseUploadFileName(String value) {
        return new JAXBElement<String>(_BatchPaymentResponseUploadFileName_QNAME, String.class, CheckPaymentResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "AppID", scope = IRequest.class)
    public JAXBElement<String> createIRequestAppID(String value) {
        return new JAXBElement<String>(_IRequestAppID_QNAME, String.class, IRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ClientIP", scope = IRequest.class)
    public JAXBElement<String> createIRequestClientIP(String value) {
        return new JAXBElement<String>(_IRequestClientIP_QNAME, String.class, IRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "ProductCode", scope = IRequest.class)
    public JAXBElement<String> createIRequestProductCode(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCProductCode_QNAME, String.class, IRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MerchantOrderID", scope = TransferQueryRequest.class)
    public JAXBElement<String> createTransferQueryRequestMerchantOrderID(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultMerchantOrderID_QNAME, String.class, TransferQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "UserID", scope = TransferQueryRequest.class)
    public JAXBElement<String> createTransferQueryRequestUserID(String value) {
        return new JAXBElement<String>(_BatchCardResponseMTCUserID_QNAME, String.class, TransferQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "OrderNo", scope = TransferQueryRequest.class)
    public JAXBElement<String> createTransferQueryRequestOrderNo(String value) {
        return new JAXBElement<String>(_WithdrawQueryResultOrderNo_QNAME, String.class, TransferQueryRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/Sdo.Payment.MCS.Entity", name = "MACString", scope = TransferQueryRequest.class)
    public JAXBElement<String> createTransferQueryRequestMACString(String value) {
        return new JAXBElement<String>(_BatchCheckRequestMTCMACString_QNAME, String.class, TransferQueryRequest.class, value);
    }

}
