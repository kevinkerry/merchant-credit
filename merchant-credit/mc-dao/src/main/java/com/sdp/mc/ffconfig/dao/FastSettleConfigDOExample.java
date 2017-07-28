package com.sdp.mc.ffconfig.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastSettleConfigDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Long pfcId;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Long objId;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Integer objType;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Integer autoFastSettle;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    private String merchantPhone;

    /**
     * This field corresponds to the database table TB_FAST_SETTLE_CONFIG
     * table comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_FAST_SETTLE_CONFIG
     * table comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_FAST_SETTLE_CONFIG
     * table comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public FastSettleConfigDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Long getPfcId() {
        return pfcId;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.PFC_ID
     *
     * @param pfcId the value for TB_FAST_SETTLE_CONFIG.PFC_ID
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setPfcId(Long pfcId) {
        this.pfcId = pfcId;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Long getObjId() {
        return objId;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_ID
     *
     * @param objId the value for TB_FAST_SETTLE_CONFIG.OBJ_ID
     * column comments 对象(代理商/商户)编号
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setObjId(Long objId) {
        this.objId = objId;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Integer getObjType() {
        return objType;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     *
     * @param objType the value for TB_FAST_SETTLE_CONFIG.OBJ_TYPE
     * column comments 0：代理商
1：商户
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Integer getAutoFastSettle() {
        return autoFastSettle;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     *
     * @param autoFastSettle the value for TB_FAST_SETTLE_CONFIG.AUTO_FAST_SETTLE
     * column comments 自动快速结算(1:是,0否)
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setAutoFastSettle(Integer autoFastSettle) {
        this.autoFastSettle = autoFastSettle;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.CREATE_TIME
     *
     * @param createTime the value for TB_FAST_SETTLE_CONFIG.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     *
     * @param updateTime the value for TB_FAST_SETTLE_CONFIG.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     *
     * @return the value of TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String getMerchantPhone() {
        return merchantPhone;
    }

    /**
     * This method sets the value of the database column TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     *
     * @param merchantPhone the value for TB_FAST_SETTLE_CONFIG.MERCHANT_PHONE
     * column comments null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setMerchantPhone(String merchantPhone) {
        this.merchantPhone = merchantPhone == null ? null : merchantPhone.trim();
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FAST_SETTLE_CONFIG
     * table comment :null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
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

        public Criteria andPfcIdIsNull() {
            addCriterion("PFC_ID is null");
            return (Criteria) this;
        }

        public Criteria andPfcIdIsNotNull() {
            addCriterion("PFC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPfcIdEqualTo(Long value) {
            addCriterion("PFC_ID =", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdNotEqualTo(Long value) {
            addCriterion("PFC_ID <>", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdGreaterThan(Long value) {
            addCriterion("PFC_ID >", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PFC_ID >=", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdLessThan(Long value) {
            addCriterion("PFC_ID <", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdLessThanOrEqualTo(Long value) {
            addCriterion("PFC_ID <=", value, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdIn(List<Long> values) {
            addCriterion("PFC_ID in", values, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdNotIn(List<Long> values) {
            addCriterion("PFC_ID not in", values, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdBetween(Long value1, Long value2) {
            addCriterion("PFC_ID between", value1, value2, "pfcId");
            return (Criteria) this;
        }

        public Criteria andPfcIdNotBetween(Long value1, Long value2) {
            addCriterion("PFC_ID not between", value1, value2, "pfcId");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNull() {
            addCriterion("OBJ_ID is null");
            return (Criteria) this;
        }

        public Criteria andObjIdIsNotNull() {
            addCriterion("OBJ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andObjIdEqualTo(Long value) {
            addCriterion("OBJ_ID =", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotEqualTo(Long value) {
            addCriterion("OBJ_ID <>", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThan(Long value) {
            addCriterion("OBJ_ID >", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID >=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThan(Long value) {
            addCriterion("OBJ_ID <", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdLessThanOrEqualTo(Long value) {
            addCriterion("OBJ_ID <=", value, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdIn(List<Long> values) {
            addCriterion("OBJ_ID in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotIn(List<Long> values) {
            addCriterion("OBJ_ID not in", values, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjIdNotBetween(Long value1, Long value2) {
            addCriterion("OBJ_ID not between", value1, value2, "objId");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNull() {
            addCriterion("OBJ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjTypeIsNotNull() {
            addCriterion("OBJ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjTypeEqualTo(Integer value) {
            addCriterion("OBJ_TYPE =", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotEqualTo(Integer value) {
            addCriterion("OBJ_TYPE <>", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThan(Integer value) {
            addCriterion("OBJ_TYPE >", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJ_TYPE >=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThan(Integer value) {
            addCriterion("OBJ_TYPE <", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLessThanOrEqualTo(Integer value) {
            addCriterion("OBJ_TYPE <=", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeLike(Integer value) {
            addCriterion("OBJ_TYPE like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotLike(Integer value) {
            addCriterion("OBJ_TYPE not like", value, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeIn(List<Integer> values) {
            addCriterion("OBJ_TYPE in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotIn(List<Integer> values) {
            addCriterion("OBJ_TYPE not in", values, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeBetween(Integer value1, Integer value2) {
            addCriterion("OBJ_TYPE between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andObjTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJ_TYPE not between", value1, value2, "objType");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIsNull() {
            addCriterion("AUTO_FAST_SETTLE is null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIsNotNull() {
            addCriterion("AUTO_FAST_SETTLE is not null");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE =", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <>", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleGreaterThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE >", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE >=", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleLessThan(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleLessThanOrEqualTo(Integer value) {
            addCriterion("AUTO_FAST_SETTLE <=", value, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE in", values, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotIn(List<Integer> values) {
            addCriterion("AUTO_FAST_SETTLE not in", values, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE between", value1, value2, "autoFastSettle");
            return (Criteria) this;
        }

        public Criteria andAutoFastSettleNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTO_FAST_SETTLE not between", value1, value2, "autoFastSettle");
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

        public Criteria andMerchantPhoneIsNull() {
            addCriterion("MERCHANT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneIsNotNull() {
            addCriterion("MERCHANT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneEqualTo(String value) {
            addCriterion("MERCHANT_PHONE =", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotEqualTo(String value) {
            addCriterion("MERCHANT_PHONE <>", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneGreaterThan(String value) {
            addCriterion("MERCHANT_PHONE >", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_PHONE >=", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLessThan(String value) {
            addCriterion("MERCHANT_PHONE <", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_PHONE <=", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneLike(String value) {
            addCriterion("MERCHANT_PHONE like", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotLike(String value) {
            addCriterion("MERCHANT_PHONE not like", value, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneIn(List<String> values) {
            addCriterion("MERCHANT_PHONE in", values, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotIn(List<String> values) {
            addCriterion("MERCHANT_PHONE not in", values, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneBetween(String value1, String value2) {
            addCriterion("MERCHANT_PHONE between", value1, value2, "merchantPhone");
            return (Criteria) this;
        }

        public Criteria andMerchantPhoneNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_PHONE not between", value1, value2, "merchantPhone");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated do_not_delete_during_merge Fri Sep 18 14:49:52 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_FAST_SETTLE_CONFIG
     * table comment :null
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
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