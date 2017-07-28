package com.sdp.mc.ma.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.util.Date;

public class MarginAccountRequestDO extends BaseDO {
    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String status;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String sourceId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String memberId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String accountId;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String requestNo;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String appIp;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String requestOperator;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String userIp;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String responseCode;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private String responseMessage;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Date requestTime;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Date responseTime;

    /**
     * This field corresponds to the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    private Long accountType;

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ID
     *
     * @param id the value for TB_MARGIN_ACCOUNT_REQ.ID
     * column comments null
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.STATUS
     *
     * @param status the value for TB_MARGIN_ACCOUNT_REQ.STATUS
     * column comments 0：初始化
1：成功
-1：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     *
     * @param sourceId the value for TB_MARGIN_ACCOUNT_REQ.SOURCE_ID
     * column comments zf号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     *
     * @param merchantNo the value for TB_MARGIN_ACCOUNT_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     *
     * @param memberId the value for TB_MARGIN_ACCOUNT_REQ.MEMBER_ID
     * column comments 商户会员号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     *
     * @param accountId the value for TB_MARGIN_ACCOUNT_REQ.ACCOUNT_ID
     * column comments 储值账户id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     *
     * @param requestNo the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_NO
     * column comments 请求流水号
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getAppIp() {
        return appIp;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.APP_IP
     *
     * @param appIp the value for TB_MARGIN_ACCOUNT_REQ.APP_IP
     * column comments 应用服务器ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAppIp(String appIp) {
        this.appIp = appIp == null ? null : appIp.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getRequestOperator() {
        return requestOperator;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     *
     * @param requestOperator the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_OPERATOR
     * column comments 操作员id
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestOperator(String requestOperator) {
        this.requestOperator = requestOperator == null ? null : requestOperator.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.USER_IP
     *
     * @param userIp the value for TB_MARGIN_ACCOUNT_REQ.USER_IP
     * column comments 用户ip
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     *
     * @param responseCode the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_CODE
     * column comments 0：成功
非0：失败
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode == null ? null : responseCode.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     *
     * @param responseMessage the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_MESSAGE
     * column comments 响应描述
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage == null ? null : responseMessage.trim();
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     *
     * @param requestTime the value for TB_MARGIN_ACCOUNT_REQ.REQUEST_TIME
     * column comments 请求时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Date getResponseTime() {
        return responseTime;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     *
     * @param responseTime the value for TB_MARGIN_ACCOUNT_REQ.RESPONSE_TIME
     * column comments 响应时间
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * This method returns the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     *
     * @return the value of TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public Long getAccountType() {
        return accountType;
    }

    /**
     * This method sets the value of the database column TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     *
     * @param accountType the value for TB_MARGIN_ACCOUNT_REQ.ACCOUNT_TYPE
     * column comments 账户类型
     *
     * @mbggenerated Fri May 29 18:06:19 CST 2015
     */
    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }
}