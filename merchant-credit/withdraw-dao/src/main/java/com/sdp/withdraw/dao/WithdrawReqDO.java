package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawReqDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.REQ_ID
     * column comments 主键
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.REQ_TYPE
     * column comments 请求类型  1:POS发起出款  2 余额发起出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer reqType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.APP_ID
     * column comments 应用编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String appId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.ORDER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String orderNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String memberId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String mcType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WITHDRAW_TYPE
     * column comments 出款类型  1：实时出款 2 普通出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer withdrawType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 出款金额
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal withdrawAmount;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WITHDRAW_FEE
     * column comments 基本费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal withdrawFee;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WITHDRAW_COST
     * column comments 基本费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal withdrawCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始额度
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal originalAmount;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.SPLITTING_FEE
     * column comments 分润费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal splittingFee;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.SPLITTING_COST
     * column comments 分润费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal splittingCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.PMT_MEMBER_ID
     * column comments 代理ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String pmtMemberId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.PMT_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String pmtMerchantNo;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.STATUS
     * column comments 出款状态  -1 初始  0 出款成功 1 处理中 9出款失败
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer retryTimes;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.ERROR_CODE
     * column comments 请求失败的编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String errorCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.ERROR_MSG
     * column comments 请求失败的原因
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String errorMsg;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 支付结果回调地址
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String callbackAddress;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Date applyTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.SERVICE_TYPE
     * column comments 服务类型 1：T0  2: T1 3:D1
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer serviceType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.PRODUCT_CODE
     * column comments 请求发起调用FOS的产品编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String productCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.PAYMENT_CODE
     * column comments 请求发起调用FOS的支付编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String paymentCode;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WITHDRAW_TIME
     * column comments 出款时间（回掉或者同步状态时出款成功的时间）
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Date withdrawTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Integer loaningType;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private BigDecimal wdCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.MERCHANT_BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Long merchantBizId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.MCC
     * column comments 商户的MCC
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String mcc;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.LAST_LEVEL_PROMOTER_ID
     * column comments 商户直属代理商
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Long lastLevelPromoterId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.LAST_DETAIL_ID
     * column comments 最后请求FOS的ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private Long lastDetailId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.HAS_OA_TXN
     * column comments 是否包含扫码交易 1：是  0:否
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String hasOaTxn;

    /**
     * This field corresponds to the database column FW_WITHDRAW_REQ.REQ_EXTENTION
     * column comments 请求扩展信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    private String reqExtention;

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.REQ_ID
     *
     * @return the value of FW_WITHDRAW_REQ.REQ_ID
     * column comments 主键
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_REQ.REQ_ID
     * column comments 主键
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.REQ_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ.REQ_TYPE
     * column comments 请求类型  1:POS发起出款  2 余额发起出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getReqType() {
        return reqType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.REQ_TYPE
     *
     * @param reqType the value for FW_WITHDRAW_REQ.REQ_TYPE
     * column comments 请求类型  1:POS发起出款  2 余额发起出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.APP_ID
     *
     * @return the value of FW_WITHDRAW_REQ.APP_ID
     * column comments 应用编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getAppId() {
        return appId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.APP_ID
     *
     * @param appId the value for FW_WITHDRAW_REQ.APP_ID
     * column comments 应用编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.ORDER_NO
     *
     * @return the value of FW_WITHDRAW_REQ.ORDER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.ORDER_NO
     *
     * @param orderNo the value for FW_WITHDRAW_REQ.ORDER_NO
     * column comments 请求的业务订单号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.MEMBER_ID
     *
     * @return the value of FW_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.MEMBER_ID
     *
     * @param memberId the value for FW_WITHDRAW_REQ.MEMBER_ID
     * column comments 会员ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.MERCHANT_NO
     *
     * @return the value of FW_WITHDRAW_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.MERCHANT_NO
     *
     * @param merchantNo the value for FW_WITHDRAW_REQ.MERCHANT_NO
     * column comments 商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.MC_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ.MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.MC_TYPE
     *
     * @param mcType the value for FW_WITHDRAW_REQ.MC_TYPE
     * column comments 商户类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setMcType(String mcType) {
        this.mcType = mcType == null ? null : mcType.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WITHDRAW_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ.WITHDRAW_TYPE
     * column comments 出款类型  1：实时出款 2 普通出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getWithdrawType() {
        return withdrawType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WITHDRAW_TYPE
     *
     * @param withdrawType the value for FW_WITHDRAW_REQ.WITHDRAW_TYPE
     * column comments 出款类型  1：实时出款 2 普通出款
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWithdrawType(Integer withdrawType) {
        this.withdrawType = withdrawType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @return the value of FW_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 出款金额
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getWithdrawAmount() {
        return withdrawAmount;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WITHDRAW_AMOUNT
     *
     * @param withdrawAmount the value for FW_WITHDRAW_REQ.WITHDRAW_AMOUNT
     * column comments 出款金额
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWithdrawAmount(BigDecimal withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WITHDRAW_FEE
     *
     * @return the value of FW_WITHDRAW_REQ.WITHDRAW_FEE
     * column comments 基本费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WITHDRAW_FEE
     *
     * @param withdrawFee the value for FW_WITHDRAW_REQ.WITHDRAW_FEE
     * column comments 基本费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WITHDRAW_COST
     *
     * @return the value of FW_WITHDRAW_REQ.WITHDRAW_COST
     * column comments 基本费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getWithdrawCost() {
        return withdrawCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WITHDRAW_COST
     *
     * @param withdrawCost the value for FW_WITHDRAW_REQ.WITHDRAW_COST
     * column comments 基本费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWithdrawCost(BigDecimal withdrawCost) {
        this.withdrawCost = withdrawCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @return the value of FW_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始额度
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.ORIGINAL_AMOUNT
     *
     * @param originalAmount the value for FW_WITHDRAW_REQ.ORIGINAL_AMOUNT
     * column comments 原始额度
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.SPLITTING_FEE
     *
     * @return the value of FW_WITHDRAW_REQ.SPLITTING_FEE
     * column comments 分润费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getSplittingFee() {
        return splittingFee;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.SPLITTING_FEE
     *
     * @param splittingFee the value for FW_WITHDRAW_REQ.SPLITTING_FEE
     * column comments 分润费率
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setSplittingFee(BigDecimal splittingFee) {
        this.splittingFee = splittingFee;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.SPLITTING_COST
     *
     * @return the value of FW_WITHDRAW_REQ.SPLITTING_COST
     * column comments 分润费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getSplittingCost() {
        return splittingCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.SPLITTING_COST
     *
     * @param splittingCost the value for FW_WITHDRAW_REQ.SPLITTING_COST
     * column comments 分润费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setSplittingCost(BigDecimal splittingCost) {
        this.splittingCost = splittingCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.PMT_MEMBER_ID
     *
     * @return the value of FW_WITHDRAW_REQ.PMT_MEMBER_ID
     * column comments 代理ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getPmtMemberId() {
        return pmtMemberId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.PMT_MEMBER_ID
     *
     * @param pmtMemberId the value for FW_WITHDRAW_REQ.PMT_MEMBER_ID
     * column comments 代理ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setPmtMemberId(String pmtMemberId) {
        this.pmtMemberId = pmtMemberId == null ? null : pmtMemberId.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.PMT_MERCHANT_NO
     *
     * @return the value of FW_WITHDRAW_REQ.PMT_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getPmtMerchantNo() {
        return pmtMerchantNo;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.PMT_MERCHANT_NO
     *
     * @param pmtMerchantNo the value for FW_WITHDRAW_REQ.PMT_MERCHANT_NO
     * column comments 代理商商户号
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setPmtMerchantNo(String pmtMerchantNo) {
        this.pmtMerchantNo = pmtMerchantNo == null ? null : pmtMerchantNo.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.STATUS
     *
     * @return the value of FW_WITHDRAW_REQ.STATUS
     * column comments 出款状态  -1 初始  0 出款成功 1 处理中 9出款失败
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.STATUS
     *
     * @param status the value for FW_WITHDRAW_REQ.STATUS
     * column comments 出款状态  -1 初始  0 出款成功 1 处理中 9出款失败
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.RETRY_TIMES
     *
     * @return the value of FW_WITHDRAW_REQ.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getRetryTimes() {
        return retryTimes;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.RETRY_TIMES
     *
     * @param retryTimes the value for FW_WITHDRAW_REQ.RETRY_TIMES
     * column comments 重试次数
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.ERROR_CODE
     *
     * @return the value of FW_WITHDRAW_REQ.ERROR_CODE
     * column comments 请求失败的编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.ERROR_CODE
     *
     * @param errorCode the value for FW_WITHDRAW_REQ.ERROR_CODE
     * column comments 请求失败的编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode == null ? null : errorCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.ERROR_MSG
     *
     * @return the value of FW_WITHDRAW_REQ.ERROR_MSG
     * column comments 请求失败的原因
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.ERROR_MSG
     *
     * @param errorMsg the value for FW_WITHDRAW_REQ.ERROR_MSG
     * column comments 请求失败的原因
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @return the value of FW_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 支付结果回调地址
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getCallbackAddress() {
        return callbackAddress;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.CALLBACK_ADDRESS
     *
     * @param callbackAddress the value for FW_WITHDRAW_REQ.CALLBACK_ADDRESS
     * column comments 支付结果回调地址
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setCallbackAddress(String callbackAddress) {
        this.callbackAddress = callbackAddress == null ? null : callbackAddress.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.APPLY_TIME
     *
     * @return the value of FW_WITHDRAW_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.APPLY_TIME
     *
     * @param applyTime the value for FW_WITHDRAW_REQ.APPLY_TIME
     * column comments 申请时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_REQ.UPDATE_TIME
     * column comments 最后修改时间
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.SERVICE_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ.SERVICE_TYPE
     * column comments 服务类型 1：T0  2: T1 3:D1
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getServiceType() {
        return serviceType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.SERVICE_TYPE
     *
     * @param serviceType the value for FW_WITHDRAW_REQ.SERVICE_TYPE
     * column comments 服务类型 1：T0  2: T1 3:D1
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.PRODUCT_CODE
     *
     * @return the value of FW_WITHDRAW_REQ.PRODUCT_CODE
     * column comments 请求发起调用FOS的产品编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.PRODUCT_CODE
     *
     * @param productCode the value for FW_WITHDRAW_REQ.PRODUCT_CODE
     * column comments 请求发起调用FOS的产品编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.PAYMENT_CODE
     *
     * @return the value of FW_WITHDRAW_REQ.PAYMENT_CODE
     * column comments 请求发起调用FOS的支付编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getPaymentCode() {
        return paymentCode;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.PAYMENT_CODE
     *
     * @param paymentCode the value for FW_WITHDRAW_REQ.PAYMENT_CODE
     * column comments 请求发起调用FOS的支付编码
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode == null ? null : paymentCode.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WITHDRAW_TIME
     *
     * @return the value of FW_WITHDRAW_REQ.WITHDRAW_TIME
     * column comments 出款时间（回掉或者同步状态时出款成功的时间）
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Date getWithdrawTime() {
        return withdrawTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WITHDRAW_TIME
     *
     * @param withdrawTime the value for FW_WITHDRAW_REQ.WITHDRAW_TIME
     * column comments 出款时间（回掉或者同步状态时出款成功的时间）
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.LOANING_TYPE
     *
     * @return the value of FW_WITHDRAW_REQ.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Integer getLoaningType() {
        return loaningType;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.LOANING_TYPE
     *
     * @param loaningType the value for FW_WITHDRAW_REQ.LOANING_TYPE
     * column comments 垫资方类型
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setLoaningType(Integer loaningType) {
        this.loaningType = loaningType;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.WD_COST
     *
     * @return the value of FW_WITHDRAW_REQ.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public BigDecimal getWdCost() {
        return wdCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.WD_COST
     *
     * @param wdCost the value for FW_WITHDRAW_REQ.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setWdCost(BigDecimal wdCost) {
        this.wdCost = wdCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.MERCHANT_BIZ_ID
     *
     * @return the value of FW_WITHDRAW_REQ.MERCHANT_BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Long getMerchantBizId() {
        return merchantBizId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.MERCHANT_BIZ_ID
     *
     * @param merchantBizId the value for FW_WITHDRAW_REQ.MERCHANT_BIZ_ID
     * column comments 商户的业务ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setMerchantBizId(Long merchantBizId) {
        this.merchantBizId = merchantBizId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.MCC
     *
     * @return the value of FW_WITHDRAW_REQ.MCC
     * column comments 商户的MCC
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getMcc() {
        return mcc;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.MCC
     *
     * @param mcc the value for FW_WITHDRAW_REQ.MCC
     * column comments 商户的MCC
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setMcc(String mcc) {
        this.mcc = mcc == null ? null : mcc.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.LAST_LEVEL_PROMOTER_ID
     *
     * @return the value of FW_WITHDRAW_REQ.LAST_LEVEL_PROMOTER_ID
     * column comments 商户直属代理商
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Long getLastLevelPromoterId() {
        return lastLevelPromoterId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.LAST_LEVEL_PROMOTER_ID
     *
     * @param lastLevelPromoterId the value for FW_WITHDRAW_REQ.LAST_LEVEL_PROMOTER_ID
     * column comments 商户直属代理商
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setLastLevelPromoterId(Long lastLevelPromoterId) {
        this.lastLevelPromoterId = lastLevelPromoterId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.LAST_DETAIL_ID
     *
     * @return the value of FW_WITHDRAW_REQ.LAST_DETAIL_ID
     * column comments 最后请求FOS的ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Long getLastDetailId() {
        return lastDetailId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.LAST_DETAIL_ID
     *
     * @param lastDetailId the value for FW_WITHDRAW_REQ.LAST_DETAIL_ID
     * column comments 最后请求FOS的ID
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setLastDetailId(Long lastDetailId) {
        this.lastDetailId = lastDetailId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.HAS_OA_TXN
     *
     * @return the value of FW_WITHDRAW_REQ.HAS_OA_TXN
     * column comments 是否包含扫码交易 1：是  0:否
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getHasOaTxn() {
        return hasOaTxn;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.HAS_OA_TXN
     *
     * @param hasOaTxn the value for FW_WITHDRAW_REQ.HAS_OA_TXN
     * column comments 是否包含扫码交易 1：是  0:否
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setHasOaTxn(String hasOaTxn) {
        this.hasOaTxn = hasOaTxn == null ? null : hasOaTxn.trim();
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_REQ.REQ_EXTENTION
     *
     * @return the value of FW_WITHDRAW_REQ.REQ_EXTENTION
     * column comments 请求扩展信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getReqExtention() {
        return reqExtention;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_REQ.REQ_EXTENTION
     *
     * @param reqExtention the value for FW_WITHDRAW_REQ.REQ_EXTENTION
     * column comments 请求扩展信息
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setReqExtention(String reqExtention) {
        this.reqExtention = reqExtention == null ? null : reqExtention.trim();
    }
}