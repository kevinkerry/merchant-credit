package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawReqDOExample extends QueryBase {
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
     * This field corresponds to the database table FW_WITHDRAW_REQ
     * table comments 出款业务请求表
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ
     * table comments 出款业务请求表
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_WITHDRAW_REQ
     * table comments 出款业务请求表
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public WithdrawReqDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

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

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ
     * table comment :出款业务请求表
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andReqIdIsNull() {
            addCriterion("REQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andReqIdIsNotNull() {
            addCriterion("REQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReqIdEqualTo(Long value) {
            addCriterion("REQ_ID =", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotEqualTo(Long value) {
            addCriterion("REQ_ID <>", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThan(Long value) {
            addCriterion("REQ_ID >", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REQ_ID >=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThan(Long value) {
            addCriterion("REQ_ID <", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdLessThanOrEqualTo(Long value) {
            addCriterion("REQ_ID <=", value, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdIn(List<Long> values) {
            addCriterion("REQ_ID in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotIn(List<Long> values) {
            addCriterion("REQ_ID not in", values, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdBetween(Long value1, Long value2) {
            addCriterion("REQ_ID between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqIdNotBetween(Long value1, Long value2) {
            addCriterion("REQ_ID not between", value1, value2, "reqId");
            return (Criteria) this;
        }

        public Criteria andReqTypeIsNull() {
            addCriterion("REQ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReqTypeIsNotNull() {
            addCriterion("REQ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReqTypeEqualTo(Integer value) {
            addCriterion("REQ_TYPE =", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotEqualTo(Integer value) {
            addCriterion("REQ_TYPE <>", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeGreaterThan(Integer value) {
            addCriterion("REQ_TYPE >", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("REQ_TYPE >=", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeLessThan(Integer value) {
            addCriterion("REQ_TYPE <", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeLessThanOrEqualTo(Integer value) {
            addCriterion("REQ_TYPE <=", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeIn(List<Integer> values) {
            addCriterion("REQ_TYPE in", values, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotIn(List<Integer> values) {
            addCriterion("REQ_TYPE not in", values, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeBetween(Integer value1, Integer value2) {
            addCriterion("REQ_TYPE between", value1, value2, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("REQ_TYPE not between", value1, value2, "reqType");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("APP_ID is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("APP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("APP_ID =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("APP_ID <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("APP_ID >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("APP_ID >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("APP_ID <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("APP_ID <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("APP_ID like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("APP_ID not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("APP_ID in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("APP_ID not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("APP_ID between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("APP_ID not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("MEMBER_ID =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("MEMBER_ID <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("MEMBER_ID >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("MEMBER_ID <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("MEMBER_ID <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("MEMBER_ID like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("MEMBER_ID not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("MEMBER_ID in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("MEMBER_ID not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("MEMBER_ID between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("MEMBER_ID not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNull() {
            addCriterion("MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("MERCHANT_NO =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("MERCHANT_NO <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("MERCHANT_NO >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("MERCHANT_NO <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_NO <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("MERCHANT_NO like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("MERCHANT_NO not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("MERCHANT_NO in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("MERCHANT_NO not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_NO not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNull() {
            addCriterion("MC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMcTypeIsNotNull() {
            addCriterion("MC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMcTypeEqualTo(String value) {
            addCriterion("MC_TYPE =", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotEqualTo(String value) {
            addCriterion("MC_TYPE <>", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThan(String value) {
            addCriterion("MC_TYPE >", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MC_TYPE >=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThan(String value) {
            addCriterion("MC_TYPE <", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLessThanOrEqualTo(String value) {
            addCriterion("MC_TYPE <=", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeLike(String value) {
            addCriterion("MC_TYPE like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotLike(String value) {
            addCriterion("MC_TYPE not like", value, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeIn(List<String> values) {
            addCriterion("MC_TYPE in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotIn(List<String> values) {
            addCriterion("MC_TYPE not in", values, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeBetween(String value1, String value2) {
            addCriterion("MC_TYPE between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andMcTypeNotBetween(String value1, String value2) {
            addCriterion("MC_TYPE not between", value1, value2, "mcType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIsNull() {
            addCriterion("WITHDRAW_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIsNotNull() {
            addCriterion("WITHDRAW_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeEqualTo(Integer value) {
            addCriterion("WITHDRAW_TYPE =", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotEqualTo(Integer value) {
            addCriterion("WITHDRAW_TYPE <>", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeGreaterThan(Integer value) {
            addCriterion("WITHDRAW_TYPE >", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("WITHDRAW_TYPE >=", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeLessThan(Integer value) {
            addCriterion("WITHDRAW_TYPE <", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeLessThanOrEqualTo(Integer value) {
            addCriterion("WITHDRAW_TYPE <=", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIn(List<Integer> values) {
            addCriterion("WITHDRAW_TYPE in", values, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotIn(List<Integer> values) {
            addCriterion("WITHDRAW_TYPE not in", values, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeBetween(Integer value1, Integer value2) {
            addCriterion("WITHDRAW_TYPE between", value1, value2, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("WITHDRAW_TYPE not between", value1, value2, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNull() {
            addCriterion("WITHDRAW_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIsNotNull() {
            addCriterion("WITHDRAW_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT =", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <>", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThan(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT >", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT >=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThan(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_AMOUNT <=", value, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_AMOUNT in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_AMOUNT not in", values, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_AMOUNT between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_AMOUNT not between", value1, value2, "withdrawAmount");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNull() {
            addCriterion("WITHDRAW_FEE is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIsNotNull() {
            addCriterion("WITHDRAW_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_FEE =", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_FEE <>", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThan(BigDecimal value) {
            addCriterion("WITHDRAW_FEE >", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_FEE >=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThan(BigDecimal value) {
            addCriterion("WITHDRAW_FEE <", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_FEE <=", value, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_FEE in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_FEE not in", values, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_FEE between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_FEE not between", value1, value2, "withdrawFee");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostIsNull() {
            addCriterion("WITHDRAW_COST is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostIsNotNull() {
            addCriterion("WITHDRAW_COST is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_COST =", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostNotEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_COST <>", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostGreaterThan(BigDecimal value) {
            addCriterion("WITHDRAW_COST >", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_COST >=", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostLessThan(BigDecimal value) {
            addCriterion("WITHDRAW_COST <", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WITHDRAW_COST <=", value, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_COST in", values, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostNotIn(List<BigDecimal> values) {
            addCriterion("WITHDRAW_COST not in", values, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_COST between", value1, value2, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andWithdrawCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WITHDRAW_COST not between", value1, value2, "withdrawCost");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNull() {
            addCriterion("ORIGINAL_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIsNotNull() {
            addCriterion("ORIGINAL_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT =", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <>", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThan(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT >", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT >=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThan(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORIGINAL_AMOUNT <=", value, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_AMOUNT in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotIn(List<BigDecimal> values) {
            addCriterion("ORIGINAL_AMOUNT not in", values, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_AMOUNT between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andOriginalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORIGINAL_AMOUNT not between", value1, value2, "originalAmount");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeIsNull() {
            addCriterion("SPLITTING_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeIsNotNull() {
            addCriterion("SPLITTING_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_FEE =", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeNotEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_FEE <>", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeGreaterThan(BigDecimal value) {
            addCriterion("SPLITTING_FEE >", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_FEE >=", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeLessThan(BigDecimal value) {
            addCriterion("SPLITTING_FEE <", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_FEE <=", value, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeIn(List<BigDecimal> values) {
            addCriterion("SPLITTING_FEE in", values, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeNotIn(List<BigDecimal> values) {
            addCriterion("SPLITTING_FEE not in", values, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPLITTING_FEE between", value1, value2, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPLITTING_FEE not between", value1, value2, "splittingFee");
            return (Criteria) this;
        }

        public Criteria andSplittingCostIsNull() {
            addCriterion("SPLITTING_COST is null");
            return (Criteria) this;
        }

        public Criteria andSplittingCostIsNotNull() {
            addCriterion("SPLITTING_COST is not null");
            return (Criteria) this;
        }

        public Criteria andSplittingCostEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_COST =", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostNotEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_COST <>", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostGreaterThan(BigDecimal value) {
            addCriterion("SPLITTING_COST >", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_COST >=", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostLessThan(BigDecimal value) {
            addCriterion("SPLITTING_COST <", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPLITTING_COST <=", value, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostIn(List<BigDecimal> values) {
            addCriterion("SPLITTING_COST in", values, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostNotIn(List<BigDecimal> values) {
            addCriterion("SPLITTING_COST not in", values, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPLITTING_COST between", value1, value2, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andSplittingCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPLITTING_COST not between", value1, value2, "splittingCost");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdIsNull() {
            addCriterion("PMT_MEMBER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdIsNotNull() {
            addCriterion("PMT_MEMBER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdEqualTo(String value) {
            addCriterion("PMT_MEMBER_ID =", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdNotEqualTo(String value) {
            addCriterion("PMT_MEMBER_ID <>", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdGreaterThan(String value) {
            addCriterion("PMT_MEMBER_ID >", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("PMT_MEMBER_ID >=", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdLessThan(String value) {
            addCriterion("PMT_MEMBER_ID <", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdLessThanOrEqualTo(String value) {
            addCriterion("PMT_MEMBER_ID <=", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdLike(String value) {
            addCriterion("PMT_MEMBER_ID like", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdNotLike(String value) {
            addCriterion("PMT_MEMBER_ID not like", value, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdIn(List<String> values) {
            addCriterion("PMT_MEMBER_ID in", values, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdNotIn(List<String> values) {
            addCriterion("PMT_MEMBER_ID not in", values, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdBetween(String value1, String value2) {
            addCriterion("PMT_MEMBER_ID between", value1, value2, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMemberIdNotBetween(String value1, String value2) {
            addCriterion("PMT_MEMBER_ID not between", value1, value2, "pmtMemberId");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoIsNull() {
            addCriterion("PMT_MERCHANT_NO is null");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoIsNotNull() {
            addCriterion("PMT_MERCHANT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoEqualTo(String value) {
            addCriterion("PMT_MERCHANT_NO =", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoNotEqualTo(String value) {
            addCriterion("PMT_MERCHANT_NO <>", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoGreaterThan(String value) {
            addCriterion("PMT_MERCHANT_NO >", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("PMT_MERCHANT_NO >=", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoLessThan(String value) {
            addCriterion("PMT_MERCHANT_NO <", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("PMT_MERCHANT_NO <=", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoLike(String value) {
            addCriterion("PMT_MERCHANT_NO like", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoNotLike(String value) {
            addCriterion("PMT_MERCHANT_NO not like", value, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoIn(List<String> values) {
            addCriterion("PMT_MERCHANT_NO in", values, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoNotIn(List<String> values) {
            addCriterion("PMT_MERCHANT_NO not in", values, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoBetween(String value1, String value2) {
            addCriterion("PMT_MERCHANT_NO between", value1, value2, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andPmtMerchantNoNotBetween(String value1, String value2) {
            addCriterion("PMT_MERCHANT_NO not between", value1, value2, "pmtMerchantNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNull() {
            addCriterion("RETRY_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIsNotNull() {
            addCriterion("RETRY_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andRetryTimesEqualTo(Integer value) {
            addCriterion("RETRY_TIMES =", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <>", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThan(Integer value) {
            addCriterion("RETRY_TIMES >", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES >=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThan(Integer value) {
            addCriterion("RETRY_TIMES <", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesLessThanOrEqualTo(Integer value) {
            addCriterion("RETRY_TIMES <=", value, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesIn(List<Integer> values) {
            addCriterion("RETRY_TIMES in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotIn(List<Integer> values) {
            addCriterion("RETRY_TIMES not in", values, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andRetryTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("RETRY_TIMES not between", value1, value2, "retryTimes");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNull() {
            addCriterion("ERROR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("ERROR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(String value) {
            addCriterion("ERROR_CODE =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(String value) {
            addCriterion("ERROR_CODE <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(String value) {
            addCriterion("ERROR_CODE >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(String value) {
            addCriterion("ERROR_CODE <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLike(String value) {
            addCriterion("ERROR_CODE like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotLike(String value) {
            addCriterion("ERROR_CODE not like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<String> values) {
            addCriterion("ERROR_CODE in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<String> values) {
            addCriterion("ERROR_CODE not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(String value1, String value2) {
            addCriterion("ERROR_CODE between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(String value1, String value2) {
            addCriterion("ERROR_CODE not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNull() {
            addCriterion("ERROR_MSG is null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNotNull() {
            addCriterion("ERROR_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgEqualTo(String value) {
            addCriterion("ERROR_MSG =", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotEqualTo(String value) {
            addCriterion("ERROR_MSG <>", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThan(String value) {
            addCriterion("ERROR_MSG >", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_MSG >=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThan(String value) {
            addCriterion("ERROR_MSG <", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThanOrEqualTo(String value) {
            addCriterion("ERROR_MSG <=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLike(String value) {
            addCriterion("ERROR_MSG like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotLike(String value) {
            addCriterion("ERROR_MSG not like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIn(List<String> values) {
            addCriterion("ERROR_MSG in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotIn(List<String> values) {
            addCriterion("ERROR_MSG not in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgBetween(String value1, String value2) {
            addCriterion("ERROR_MSG between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotBetween(String value1, String value2) {
            addCriterion("ERROR_MSG not between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIsNull() {
            addCriterion("CALLBACK_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIsNotNull() {
            addCriterion("CALLBACK_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS =", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <>", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThan(String value) {
            addCriterion("CALLBACK_ADDRESS >", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS >=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThan(String value) {
            addCriterion("CALLBACK_ADDRESS <", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLessThanOrEqualTo(String value) {
            addCriterion("CALLBACK_ADDRESS <=", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressLike(String value) {
            addCriterion("CALLBACK_ADDRESS like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotLike(String value) {
            addCriterion("CALLBACK_ADDRESS not like", value, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotIn(List<String> values) {
            addCriterion("CALLBACK_ADDRESS not in", values, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS between", value1, value2, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andCallbackAddressNotBetween(String value1, String value2) {
            addCriterion("CALLBACK_ADDRESS not between", value1, value2, "callbackAddress");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNull() {
            addCriterion("APPLY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIsNotNull() {
            addCriterion("APPLY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTimeEqualTo(Date value) {
            addCriterion("APPLY_TIME =", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotEqualTo(Date value) {
            addCriterion("APPLY_TIME <>", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThan(Date value) {
            addCriterion("APPLY_TIME >", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME >=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThan(Date value) {
            addCriterion("APPLY_TIME <", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_TIME <=", value, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeIn(List<Date> values) {
            addCriterion("APPLY_TIME in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotIn(List<Date> values) {
            addCriterion("APPLY_TIME not in", values, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_TIME not between", value1, value2, "applyTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Integer value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Integer value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Integer> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Integer> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("PRODUCT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("PRODUCT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("PRODUCT_CODE =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("PRODUCT_CODE <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("PRODUCT_CODE >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("PRODUCT_CODE <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_CODE <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("PRODUCT_CODE like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("PRODUCT_CODE not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("PRODUCT_CODE in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("PRODUCT_CODE not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_CODE not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNull() {
            addCriterion("PAYMENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIsNotNull() {
            addCriterion("PAYMENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeEqualTo(String value) {
            addCriterion("PAYMENT_CODE =", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotEqualTo(String value) {
            addCriterion("PAYMENT_CODE <>", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThan(String value) {
            addCriterion("PAYMENT_CODE >", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENT_CODE >=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThan(String value) {
            addCriterion("PAYMENT_CODE <", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLessThanOrEqualTo(String value) {
            addCriterion("PAYMENT_CODE <=", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeLike(String value) {
            addCriterion("PAYMENT_CODE like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotLike(String value) {
            addCriterion("PAYMENT_CODE not like", value, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeIn(List<String> values) {
            addCriterion("PAYMENT_CODE in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotIn(List<String> values) {
            addCriterion("PAYMENT_CODE not in", values, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeBetween(String value1, String value2) {
            addCriterion("PAYMENT_CODE between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andPaymentCodeNotBetween(String value1, String value2) {
            addCriterion("PAYMENT_CODE not between", value1, value2, "paymentCode");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeIsNull() {
            addCriterion("WITHDRAW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeIsNotNull() {
            addCriterion("WITHDRAW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeEqualTo(Date value) {
            addCriterion("WITHDRAW_TIME =", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeNotEqualTo(Date value) {
            addCriterion("WITHDRAW_TIME <>", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeGreaterThan(Date value) {
            addCriterion("WITHDRAW_TIME >", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WITHDRAW_TIME >=", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeLessThan(Date value) {
            addCriterion("WITHDRAW_TIME <", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeLessThanOrEqualTo(Date value) {
            addCriterion("WITHDRAW_TIME <=", value, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeIn(List<Date> values) {
            addCriterion("WITHDRAW_TIME in", values, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeNotIn(List<Date> values) {
            addCriterion("WITHDRAW_TIME not in", values, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeBetween(Date value1, Date value2) {
            addCriterion("WITHDRAW_TIME between", value1, value2, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andWithdrawTimeNotBetween(Date value1, Date value2) {
            addCriterion("WITHDRAW_TIME not between", value1, value2, "withdrawTime");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNull() {
            addCriterion("LOANING_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIsNotNull() {
            addCriterion("LOANING_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeEqualTo(Integer value) {
            addCriterion("LOANING_TYPE =", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <>", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThan(Integer value) {
            addCriterion("LOANING_TYPE >", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE >=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThan(Integer value) {
            addCriterion("LOANING_TYPE <", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeLessThanOrEqualTo(Integer value) {
            addCriterion("LOANING_TYPE <=", value, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeIn(List<Integer> values) {
            addCriterion("LOANING_TYPE in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotIn(List<Integer> values) {
            addCriterion("LOANING_TYPE not in", values, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andLoaningTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("LOANING_TYPE not between", value1, value2, "loaningType");
            return (Criteria) this;
        }

        public Criteria andWdCostIsNull() {
            addCriterion("WD_COST is null");
            return (Criteria) this;
        }

        public Criteria andWdCostIsNotNull() {
            addCriterion("WD_COST is not null");
            return (Criteria) this;
        }

        public Criteria andWdCostEqualTo(BigDecimal value) {
            addCriterion("WD_COST =", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotEqualTo(BigDecimal value) {
            addCriterion("WD_COST <>", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostGreaterThan(BigDecimal value) {
            addCriterion("WD_COST >", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST >=", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostLessThan(BigDecimal value) {
            addCriterion("WD_COST <", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WD_COST <=", value, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostIn(List<BigDecimal> values) {
            addCriterion("WD_COST in", values, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotIn(List<BigDecimal> values) {
            addCriterion("WD_COST not in", values, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST between", value1, value2, "wdCost");
            return (Criteria) this;
        }

        public Criteria andWdCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WD_COST not between", value1, value2, "wdCost");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdIsNull() {
            addCriterion("MERCHANT_BIZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdIsNotNull() {
            addCriterion("MERCHANT_BIZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdEqualTo(Long value) {
            addCriterion("MERCHANT_BIZ_ID =", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdNotEqualTo(Long value) {
            addCriterion("MERCHANT_BIZ_ID <>", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdGreaterThan(Long value) {
            addCriterion("MERCHANT_BIZ_ID >", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MERCHANT_BIZ_ID >=", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdLessThan(Long value) {
            addCriterion("MERCHANT_BIZ_ID <", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdLessThanOrEqualTo(Long value) {
            addCriterion("MERCHANT_BIZ_ID <=", value, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdIn(List<Long> values) {
            addCriterion("MERCHANT_BIZ_ID in", values, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdNotIn(List<Long> values) {
            addCriterion("MERCHANT_BIZ_ID not in", values, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdBetween(Long value1, Long value2) {
            addCriterion("MERCHANT_BIZ_ID between", value1, value2, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMerchantBizIdNotBetween(Long value1, Long value2) {
            addCriterion("MERCHANT_BIZ_ID not between", value1, value2, "merchantBizId");
            return (Criteria) this;
        }

        public Criteria andMccIsNull() {
            addCriterion("MCC is null");
            return (Criteria) this;
        }

        public Criteria andMccIsNotNull() {
            addCriterion("MCC is not null");
            return (Criteria) this;
        }

        public Criteria andMccEqualTo(String value) {
            addCriterion("MCC =", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotEqualTo(String value) {
            addCriterion("MCC <>", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThan(String value) {
            addCriterion("MCC >", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThanOrEqualTo(String value) {
            addCriterion("MCC >=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThan(String value) {
            addCriterion("MCC <", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThanOrEqualTo(String value) {
            addCriterion("MCC <=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLike(String value) {
            addCriterion("MCC like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotLike(String value) {
            addCriterion("MCC not like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccIn(List<String> values) {
            addCriterion("MCC in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotIn(List<String> values) {
            addCriterion("MCC not in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccBetween(String value1, String value2) {
            addCriterion("MCC between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotBetween(String value1, String value2) {
            addCriterion("MCC not between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIsNull() {
            addCriterion("LAST_LEVEL_PROMOTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIsNotNull() {
            addCriterion("LAST_LEVEL_PROMOTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID =", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <>", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdGreaterThan(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID >", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID >=", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdLessThan(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_LEVEL_PROMOTER_ID <=", value, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdIn(List<Long> values) {
            addCriterion("LAST_LEVEL_PROMOTER_ID in", values, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotIn(List<Long> values) {
            addCriterion("LAST_LEVEL_PROMOTER_ID not in", values, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdBetween(Long value1, Long value2) {
            addCriterion("LAST_LEVEL_PROMOTER_ID between", value1, value2, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastLevelPromoterIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_LEVEL_PROMOTER_ID not between", value1, value2, "lastLevelPromoterId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdIsNull() {
            addCriterion("LAST_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdIsNotNull() {
            addCriterion("LAST_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdEqualTo(Long value) {
            addCriterion("LAST_DETAIL_ID =", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdNotEqualTo(Long value) {
            addCriterion("LAST_DETAIL_ID <>", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdGreaterThan(Long value) {
            addCriterion("LAST_DETAIL_ID >", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_DETAIL_ID >=", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdLessThan(Long value) {
            addCriterion("LAST_DETAIL_ID <", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("LAST_DETAIL_ID <=", value, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdIn(List<Long> values) {
            addCriterion("LAST_DETAIL_ID in", values, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdNotIn(List<Long> values) {
            addCriterion("LAST_DETAIL_ID not in", values, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdBetween(Long value1, Long value2) {
            addCriterion("LAST_DETAIL_ID between", value1, value2, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andLastDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("LAST_DETAIL_ID not between", value1, value2, "lastDetailId");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnIsNull() {
            addCriterion("HAS_OA_TXN is null");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnIsNotNull() {
            addCriterion("HAS_OA_TXN is not null");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnEqualTo(String value) {
            addCriterion("HAS_OA_TXN =", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnNotEqualTo(String value) {
            addCriterion("HAS_OA_TXN <>", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnGreaterThan(String value) {
            addCriterion("HAS_OA_TXN >", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnGreaterThanOrEqualTo(String value) {
            addCriterion("HAS_OA_TXN >=", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnLessThan(String value) {
            addCriterion("HAS_OA_TXN <", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnLessThanOrEqualTo(String value) {
            addCriterion("HAS_OA_TXN <=", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnLike(String value) {
            addCriterion("HAS_OA_TXN like", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnNotLike(String value) {
            addCriterion("HAS_OA_TXN not like", value, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnIn(List<String> values) {
            addCriterion("HAS_OA_TXN in", values, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnNotIn(List<String> values) {
            addCriterion("HAS_OA_TXN not in", values, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnBetween(String value1, String value2) {
            addCriterion("HAS_OA_TXN between", value1, value2, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andHasOaTxnNotBetween(String value1, String value2) {
            addCriterion("HAS_OA_TXN not between", value1, value2, "hasOaTxn");
            return (Criteria) this;
        }

        public Criteria andReqExtentionIsNull() {
            addCriterion("REQ_EXTENTION is null");
            return (Criteria) this;
        }

        public Criteria andReqExtentionIsNotNull() {
            addCriterion("REQ_EXTENTION is not null");
            return (Criteria) this;
        }

        public Criteria andReqExtentionEqualTo(String value) {
            addCriterion("REQ_EXTENTION =", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotEqualTo(String value) {
            addCriterion("REQ_EXTENTION <>", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionGreaterThan(String value) {
            addCriterion("REQ_EXTENTION >", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_EXTENTION >=", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLessThan(String value) {
            addCriterion("REQ_EXTENTION <", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLessThanOrEqualTo(String value) {
            addCriterion("REQ_EXTENTION <=", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionLike(String value) {
            addCriterion("REQ_EXTENTION like", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotLike(String value) {
            addCriterion("REQ_EXTENTION not like", value, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionIn(List<String> values) {
            addCriterion("REQ_EXTENTION in", values, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotIn(List<String> values) {
            addCriterion("REQ_EXTENTION not in", values, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionBetween(String value1, String value2) {
            addCriterion("REQ_EXTENTION between", value1, value2, "reqExtention");
            return (Criteria) this;
        }

        public Criteria andReqExtentionNotBetween(String value1, String value2) {
            addCriterion("REQ_EXTENTION not between", value1, value2, "reqExtention");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ
     *
     * @mbggenerated do_not_delete_during_merge Wed Jul 05 10:53:07 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_WITHDRAW_REQ
     * table comment :出款业务请求表
     *
     * @mbggenerated Wed Jul 05 10:53:07 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}