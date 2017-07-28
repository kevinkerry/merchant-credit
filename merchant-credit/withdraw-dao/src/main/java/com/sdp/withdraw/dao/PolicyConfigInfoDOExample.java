package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PolicyConfigInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String policyId;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer fastSettleFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer autoFastSettleFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal fastSettleLimit;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal holidayRatio;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal workdayRatio;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer promoterModifyFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer status;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String createOperator;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String updateOperator;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private String policyName;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer policyType;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer dependCreditAuthFlag;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal withdrawCost;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private Integer quotaType;

    /**
     * This field corresponds to the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    private BigDecimal oaTxnWithdrawCost;

    /**
     * This field corresponds to the database table FW_POLICY_CONFIG_INFO
     * table comments 政策配置信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table FW_POLICY_CONFIG_INFO
     * table comments 政策配置信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table FW_POLICY_CONFIG_INFO
     * table comments 政策配置信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public PolicyConfigInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.ID
     *
     * @return the value of FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.ID
     *
     * @param id the value for FW_POLICY_CONFIG_INFO.ID
     * column comments 主键
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_ID
     *
     * @param policyId the value for FW_POLICY_CONFIG_INFO.POLICY_ID
     * column comments 政策编码
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyId(String policyId) {
        this.policyId = policyId == null ? null : policyId.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getFastSettleFlag() {
        return fastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     *
     * @param fastSettleFlag the value for FW_POLICY_CONFIG_INFO.FAST_SETTLE_FLAG
     * column comments 快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setFastSettleFlag(Integer fastSettleFlag) {
        this.fastSettleFlag = fastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getAutoFastSettleFlag() {
        return autoFastSettleFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     *
     * @param autoFastSettleFlag the value for FW_POLICY_CONFIG_INFO.AUTO_FAST_SETTLE_FLAG
     * column comments 自动快速结算标示 1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setAutoFastSettleFlag(Integer autoFastSettleFlag) {
        this.autoFastSettleFlag = autoFastSettleFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     *
     * @return the value of FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getFastSettleLimit() {
        return fastSettleLimit;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     *
     * @param fastSettleLimit the value for FW_POLICY_CONFIG_INFO.FAST_SETTLE_LIMIT
     * column comments 快速结算额度
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setFastSettleLimit(BigDecimal fastSettleLimit) {
        this.fastSettleLimit = fastSettleLimit;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     *
     * @return the value of FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getHolidayRatio() {
        return holidayRatio;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     *
     * @param holidayRatio the value for FW_POLICY_CONFIG_INFO.HOLIDAY_RATIO
     * column comments 节假日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setHolidayRatio(BigDecimal holidayRatio) {
        this.holidayRatio = holidayRatio;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     *
     * @return the value of FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getWorkdayRatio() {
        return workdayRatio;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     *
     * @param workdayRatio the value for FW_POLICY_CONFIG_INFO.WORKDAY_RATIO
     * column comments 工作日费率
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setWorkdayRatio(BigDecimal workdayRatio) {
        this.workdayRatio = workdayRatio;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getPromoterModifyFlag() {
        return promoterModifyFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     *
     * @param promoterModifyFlag the value for FW_POLICY_CONFIG_INFO.POMOTER_MODIFY_FLAG
     * column comments 代理商修改标示
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPromoterModifyFlag(Integer promoterModifyFlag) {
        this.promoterModifyFlag = promoterModifyFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.STATUS
     *
     * @return the value of FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.STATUS
     *
     * @param status the value for FW_POLICY_CONFIG_INFO.STATUS
     * column comments 状态  1 有效   0失效
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.CREATE_TIME
     *
     * @param createTime the value for FW_POLICY_CONFIG_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_TIME
     *
     * @param updateTime the value for FW_POLICY_CONFIG_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     *
     * @return the value of FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getCreateOperator() {
        return createOperator;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     *
     * @param createOperator the value for FW_POLICY_CONFIG_INFO.CREATE_OPERATOR
     * column comments 创建者信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setCreateOperator(String createOperator) {
        this.createOperator = createOperator == null ? null : createOperator.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     *
     * @return the value of FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getUpdateOperator() {
        return updateOperator;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     *
     * @param updateOperator the value for FW_POLICY_CONFIG_INFO.UPDATE_OPERATOR
     * column comments 修改最好修改
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setUpdateOperator(String updateOperator) {
        this.updateOperator = updateOperator == null ? null : updateOperator.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_NAME
     *
     * @param policyName the value for FW_POLICY_CONFIG_INFO.POLICY_NAME
     * column comments 政策名称
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyName(String policyName) {
        this.policyName = policyName == null ? null : policyName.trim();
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     *
     * @return the value of FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getPolicyType() {
        return policyType;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.POLICY_TYPE
     *
     * @param policyType the value for FW_POLICY_CONFIG_INFO.POLICY_TYPE
     * column comments 政策类型 1：政策类 2：MCC类
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setPolicyType(Integer policyType) {
        this.policyType = policyType;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     *
     * @return the value of FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getDependCreditAuthFlag() {
        return dependCreditAuthFlag;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     *
     * @param dependCreditAuthFlag the value for FW_POLICY_CONFIG_INFO.DEPEND_CREDIT_AUTH_FLAG
     * column comments 依赖信用认证标示 1：需要 0：不需要
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setDependCreditAuthFlag(Integer dependCreditAuthFlag) {
        this.dependCreditAuthFlag = dependCreditAuthFlag;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     *
     * @return the value of FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getWithdrawCost() {
        return withdrawCost;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     *
     * @param withdrawCost the value for FW_POLICY_CONFIG_INFO.WITHDRAW_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setWithdrawCost(BigDecimal withdrawCost) {
        this.withdrawCost = withdrawCost;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     *
     * @return the value of FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Integer getQuotaType() {
        return quotaType;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     *
     * @param quotaType the value for FW_POLICY_CONFIG_INFO.QUOTA_TYPE
     * column comments 额度类型 1：临时 2：永久
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setQuotaType(Integer quotaType) {
        this.quotaType = quotaType;
    }

    /**
     * This method returns the value of the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     *
     * @return the value of FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public BigDecimal getOaTxnWithdrawCost() {
        return oaTxnWithdrawCost;
    }

    /**
     * This method sets the value of the database column FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     *
     * @param oaTxnWithdrawCost the value for FW_POLICY_CONFIG_INFO.OA_TXN_WITHDRAW_COST
     * column comments 扫码交易提现费
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setOaTxnWithdrawCost(BigDecimal oaTxnWithdrawCost) {
        this.oaTxnWithdrawCost = oaTxnWithdrawCost;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POLICY_CONFIG_INFO
     * table comment :政策配置信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNull() {
            addCriterion("POLICY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("POLICY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("POLICY_ID =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("POLICY_ID <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("POLICY_ID >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_ID >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("POLICY_ID <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("POLICY_ID <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("POLICY_ID like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("POLICY_ID not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("POLICY_ID in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("POLICY_ID not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("POLICY_ID between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("POLICY_ID not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNull() {
            addCriterion("FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIsNotNull() {
            addCriterion("FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG =", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <>", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG >=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThan(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("FAST_SETTLE_FLAG <=", value, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("FAST_SETTLE_FLAG not in", values, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("FAST_SETTLE_FLAG not between", value1, value2, "fastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIsNull() {
            addCriterion("AUTO_FAST_SETTLE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIsNotNull() {
            addCriterion("AUTO_FAST_SETTLE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG =", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <>", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagGreaterThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG >", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG >=", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagLessThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagLessThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE_FLAG <=", value, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE_FLAG in", values, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE_FLAG not in", values, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE_FLAG between", value1, value2, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE_FLAG not between", value1, value2, "autoFastSettleFlag");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNull() {
            addCriterion("FAST_SETTLE_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIsNotNull() {
            addCriterion("FAST_SETTLE_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT =", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <>", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT >=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThan(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FAST_SETTLE_LIMIT <=", value, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotIn(List<BigDecimal> values) {
            addCriterion("FAST_SETTLE_LIMIT not in", values, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andFastSettleLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FAST_SETTLE_LIMIT not between", value1, value2, "fastSettleLimit");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIsNull() {
            addCriterion("HOLIDAY_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIsNotNull() {
            addCriterion("HOLIDAY_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO =", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <>", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioGreaterThan(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO >", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO >=", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioLessThan(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HOLIDAY_RATIO <=", value, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioIn(List<BigDecimal> values) {
            addCriterion("HOLIDAY_RATIO in", values, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotIn(List<BigDecimal> values) {
            addCriterion("HOLIDAY_RATIO not in", values, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLIDAY_RATIO between", value1, value2, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andHolidayRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HOLIDAY_RATIO not between", value1, value2, "holidayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioIsNull() {
            addCriterion("WORKDAY_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioIsNotNull() {
            addCriterion("WORKDAY_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioEqualTo(BigDecimal value) {
            addCriterion("WORKDAY_RATIO =", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioNotEqualTo(BigDecimal value) {
            addCriterion("WORKDAY_RATIO <>", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioGreaterThan(BigDecimal value) {
            addCriterion("WORKDAY_RATIO >", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WORKDAY_RATIO >=", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioLessThan(BigDecimal value) {
            addCriterion("WORKDAY_RATIO <", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WORKDAY_RATIO <=", value, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioIn(List<BigDecimal> values) {
            addCriterion("WORKDAY_RATIO in", values, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioNotIn(List<BigDecimal> values) {
            addCriterion("WORKDAY_RATIO not in", values, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORKDAY_RATIO between", value1, value2, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andWorkdayRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WORKDAY_RATIO not between", value1, value2, "workdayRatio");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagIsNull() {
            addCriterion("POMOTER_MODIFY_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagIsNotNull() {
            addCriterion("POMOTER_MODIFY_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagEqualTo(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG =", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagNotEqualTo(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG <>", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagGreaterThan(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG >", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG >=", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagLessThan(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG <", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagLessThanOrEqualTo(Integer value) {
            addCriterion("POMOTER_MODIFY_FLAG <=", value, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagIn(List<Integer> values) {
            addCriterion("POMOTER_MODIFY_FLAG in", values, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagNotIn(List<Integer> values) {
            addCriterion("POMOTER_MODIFY_FLAG not in", values, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagBetween(Integer value1, Integer value2) {
            addCriterion("POMOTER_MODIFY_FLAG between", value1, value2, "promoterModifyFlag");
            return (Criteria) this;
        }

        public Criteria andPromoterModifyFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("POMOTER_MODIFY_FLAG not between", value1, value2, "promoterModifyFlag");
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

        public Criteria andCreateOperatorIsNull() {
            addCriterion("CREATE_OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNotNull() {
            addCriterion("CREATE_OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorEqualTo(String value) {
            addCriterion("CREATE_OPERATOR =", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotEqualTo(String value) {
            addCriterion("CREATE_OPERATOR <>", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThan(String value) {
            addCriterion("CREATE_OPERATOR >", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_OPERATOR >=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThan(String value) {
            addCriterion("CREATE_OPERATOR <", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThanOrEqualTo(String value) {
            addCriterion("CREATE_OPERATOR <=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLike(String value) {
            addCriterion("CREATE_OPERATOR like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotLike(String value) {
            addCriterion("CREATE_OPERATOR not like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIn(List<String> values) {
            addCriterion("CREATE_OPERATOR in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotIn(List<String> values) {
            addCriterion("CREATE_OPERATOR not in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorBetween(String value1, String value2) {
            addCriterion("CREATE_OPERATOR between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotBetween(String value1, String value2) {
            addCriterion("CREATE_OPERATOR not between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIsNull() {
            addCriterion("UPDATE_OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIsNotNull() {
            addCriterion("UPDATE_OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorEqualTo(String value) {
            addCriterion("UPDATE_OPERATOR =", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotEqualTo(String value) {
            addCriterion("UPDATE_OPERATOR <>", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThan(String value) {
            addCriterion("UPDATE_OPERATOR >", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPERATOR >=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThan(String value) {
            addCriterion("UPDATE_OPERATOR <", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_OPERATOR <=", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorLike(String value) {
            addCriterion("UPDATE_OPERATOR like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotLike(String value) {
            addCriterion("UPDATE_OPERATOR not like", value, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorIn(List<String> values) {
            addCriterion("UPDATE_OPERATOR in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotIn(List<String> values) {
            addCriterion("UPDATE_OPERATOR not in", values, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorBetween(String value1, String value2) {
            addCriterion("UPDATE_OPERATOR between", value1, value2, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andUpdateOperatorNotBetween(String value1, String value2) {
            addCriterion("UPDATE_OPERATOR not between", value1, value2, "updateOperator");
            return (Criteria) this;
        }

        public Criteria andPolicyNameIsNull() {
            addCriterion("POLICY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNameIsNotNull() {
            addCriterion("POLICY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNameEqualTo(String value) {
            addCriterion("POLICY_NAME =", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotEqualTo(String value) {
            addCriterion("POLICY_NAME <>", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameGreaterThan(String value) {
            addCriterion("POLICY_NAME >", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameGreaterThanOrEqualTo(String value) {
            addCriterion("POLICY_NAME >=", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLessThan(String value) {
            addCriterion("POLICY_NAME <", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLessThanOrEqualTo(String value) {
            addCriterion("POLICY_NAME <=", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameLike(String value) {
            addCriterion("POLICY_NAME like", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotLike(String value) {
            addCriterion("POLICY_NAME not like", value, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameIn(List<String> values) {
            addCriterion("POLICY_NAME in", values, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotIn(List<String> values) {
            addCriterion("POLICY_NAME not in", values, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameBetween(String value1, String value2) {
            addCriterion("POLICY_NAME between", value1, value2, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyNameNotBetween(String value1, String value2) {
            addCriterion("POLICY_NAME not between", value1, value2, "policyName");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNull() {
            addCriterion("POLICY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIsNotNull() {
            addCriterion("POLICY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeEqualTo(Integer value) {
            addCriterion("POLICY_TYPE =", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotEqualTo(Integer value) {
            addCriterion("POLICY_TYPE <>", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThan(Integer value) {
            addCriterion("POLICY_TYPE >", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("POLICY_TYPE >=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThan(Integer value) {
            addCriterion("POLICY_TYPE <", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("POLICY_TYPE <=", value, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeIn(List<Integer> values) {
            addCriterion("POLICY_TYPE in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotIn(List<Integer> values) {
            addCriterion("POLICY_TYPE not in", values, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeBetween(Integer value1, Integer value2) {
            addCriterion("POLICY_TYPE between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andPolicyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("POLICY_TYPE not between", value1, value2, "policyType");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagIsNull() {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagIsNotNull() {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagEqualTo(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG =", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagNotEqualTo(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG <>", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagGreaterThan(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG >", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG >=", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagLessThan(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG <", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagLessThanOrEqualTo(Integer value) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG <=", value, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagIn(List<Integer> values) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG in", values, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagNotIn(List<Integer> values) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG not in", values, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagBetween(Integer value1, Integer value2) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG between", value1, value2, "dependCreditAuthFlag");
            return (Criteria) this;
        }

        public Criteria andDependCreditAuthFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPEND_CREDIT_AUTH_FLAG not between", value1, value2, "dependCreditAuthFlag");
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

        public Criteria andQuotaTypeIsNull() {
            addCriterion("QUOTA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeIsNotNull() {
            addCriterion("QUOTA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeEqualTo(Integer value) {
            addCriterion("QUOTA_TYPE =", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeNotEqualTo(Integer value) {
            addCriterion("QUOTA_TYPE <>", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeGreaterThan(Integer value) {
            addCriterion("QUOTA_TYPE >", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUOTA_TYPE >=", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeLessThan(Integer value) {
            addCriterion("QUOTA_TYPE <", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeLessThanOrEqualTo(Integer value) {
            addCriterion("QUOTA_TYPE <=", value, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeIn(List<Integer> values) {
            addCriterion("QUOTA_TYPE in", values, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeNotIn(List<Integer> values) {
            addCriterion("QUOTA_TYPE not in", values, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeBetween(Integer value1, Integer value2) {
            addCriterion("QUOTA_TYPE between", value1, value2, "quotaType");
            return (Criteria) this;
        }

        public Criteria andQuotaTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("QUOTA_TYPE not between", value1, value2, "quotaType");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostIsNull() {
            addCriterion("OA_TXN_WITHDRAW_COST is null");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostIsNotNull() {
            addCriterion("OA_TXN_WITHDRAW_COST is not null");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostEqualTo(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST =", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostNotEqualTo(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST <>", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostGreaterThan(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST >", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST >=", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostLessThan(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST <", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OA_TXN_WITHDRAW_COST <=", value, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostIn(List<BigDecimal> values) {
            addCriterion("OA_TXN_WITHDRAW_COST in", values, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostNotIn(List<BigDecimal> values) {
            addCriterion("OA_TXN_WITHDRAW_COST not in", values, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OA_TXN_WITHDRAW_COST between", value1, value2, "oaTxnWithdrawCost");
            return (Criteria) this;
        }

        public Criteria andOaTxnWithdrawCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OA_TXN_WITHDRAW_COST not between", value1, value2, "oaTxnWithdrawCost");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POLICY_CONFIG_INFO
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 17 13:57:18 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table FW_POLICY_CONFIG_INFO
     * table comment :政策配置信息
     *
     * @mbggenerated Mon Jul 17 13:57:18 CST 2017
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