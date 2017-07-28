package com.sdp.mc.config.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfigOptionDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Long optionId;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionKey;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionValue;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionDefValue;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private String optionDesc;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table TB_CONFIG_OPTION
     * table comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_CONFIG_OPTION
     * table comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_CONFIG_OPTION
     * table comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public ConfigOptionDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_ID
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Long getOptionId() {
        return optionId;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_ID
     *
     * @param optionId the value for TB_CONFIG_OPTION.OPTION_ID
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_KEY
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionKey() {
        return optionKey;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_KEY
     *
     * @param optionKey the value for TB_CONFIG_OPTION.OPTION_KEY
     * column comments 配置项KEY
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey == null ? null : optionKey.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_VALUE
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_VALUE
     *
     * @param optionValue the value for TB_CONFIG_OPTION.OPTION_VALUE
     * column comments 配置项值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue == null ? null : optionValue.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionDefValue() {
        return optionDefValue;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_DEF_VALUE
     *
     * @param optionDefValue the value for TB_CONFIG_OPTION.OPTION_DEF_VALUE
     * column comments 配置默认值
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionDefValue(String optionDefValue) {
        this.optionDefValue = optionDefValue == null ? null : optionDefValue.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.OPTION_DESC
     *
     * @return the value of TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOptionDesc() {
        return optionDesc;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.OPTION_DESC
     *
     * @param optionDesc the value for TB_CONFIG_OPTION.OPTION_DESC
     * column comments 描述
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOptionDesc(String optionDesc) {
        this.optionDesc = optionDesc == null ? null : optionDesc.trim();
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.CREATE_TIME
     *
     * @return the value of TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.CREATE_TIME
     *
     * @param createTime the value for TB_CONFIG_OPTION.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_CONFIG_OPTION.UPDATE_TIME
     *
     * @return the value of TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_CONFIG_OPTION.UPDATE_TIME
     *
     * @param updateTime the value for TB_CONFIG_OPTION.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_CONFIG_OPTION
     * table comment :null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
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

        public Criteria andOptionIdIsNull() {
            addCriterion("OPTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andOptionIdIsNotNull() {
            addCriterion("OPTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOptionIdEqualTo(Long value) {
            addCriterion("OPTION_ID =", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotEqualTo(Long value) {
            addCriterion("OPTION_ID <>", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThan(Long value) {
            addCriterion("OPTION_ID >", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("OPTION_ID >=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThan(Long value) {
            addCriterion("OPTION_ID <", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThanOrEqualTo(Long value) {
            addCriterion("OPTION_ID <=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdIn(List<Long> values) {
            addCriterion("OPTION_ID in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotIn(List<Long> values) {
            addCriterion("OPTION_ID not in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdBetween(Long value1, Long value2) {
            addCriterion("OPTION_ID between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotBetween(Long value1, Long value2) {
            addCriterion("OPTION_ID not between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIsNull() {
            addCriterion("OPTION_KEY is null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIsNotNull() {
            addCriterion("OPTION_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyEqualTo(String value) {
            addCriterion("OPTION_KEY =", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotEqualTo(String value) {
            addCriterion("OPTION_KEY <>", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThan(String value) {
            addCriterion("OPTION_KEY >", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_KEY >=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThan(String value) {
            addCriterion("OPTION_KEY <", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThanOrEqualTo(String value) {
            addCriterion("OPTION_KEY <=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLike(String value) {
            addCriterion("OPTION_KEY like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotLike(String value) {
            addCriterion("OPTION_KEY not like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIn(List<String> values) {
            addCriterion("OPTION_KEY in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotIn(List<String> values) {
            addCriterion("OPTION_KEY not in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyBetween(String value1, String value2) {
            addCriterion("OPTION_KEY between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotBetween(String value1, String value2) {
            addCriterion("OPTION_KEY not between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionValueIsNull() {
            addCriterion("OPTION_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andOptionValueIsNotNull() {
            addCriterion("OPTION_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andOptionValueEqualTo(String value) {
            addCriterion("OPTION_VALUE =", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotEqualTo(String value) {
            addCriterion("OPTION_VALUE <>", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueGreaterThan(String value) {
            addCriterion("OPTION_VALUE >", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_VALUE >=", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLessThan(String value) {
            addCriterion("OPTION_VALUE <", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLessThanOrEqualTo(String value) {
            addCriterion("OPTION_VALUE <=", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueLike(String value) {
            addCriterion("OPTION_VALUE like", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotLike(String value) {
            addCriterion("OPTION_VALUE not like", value, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueIn(List<String> values) {
            addCriterion("OPTION_VALUE in", values, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotIn(List<String> values) {
            addCriterion("OPTION_VALUE not in", values, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueBetween(String value1, String value2) {
            addCriterion("OPTION_VALUE between", value1, value2, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionValueNotBetween(String value1, String value2) {
            addCriterion("OPTION_VALUE not between", value1, value2, "optionValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueIsNull() {
            addCriterion("OPTION_DEF_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueIsNotNull() {
            addCriterion("OPTION_DEF_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueEqualTo(String value) {
            addCriterion("OPTION_DEF_VALUE =", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueNotEqualTo(String value) {
            addCriterion("OPTION_DEF_VALUE <>", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueGreaterThan(String value) {
            addCriterion("OPTION_DEF_VALUE >", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_DEF_VALUE >=", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueLessThan(String value) {
            addCriterion("OPTION_DEF_VALUE <", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueLessThanOrEqualTo(String value) {
            addCriterion("OPTION_DEF_VALUE <=", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueLike(String value) {
            addCriterion("OPTION_DEF_VALUE like", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueNotLike(String value) {
            addCriterion("OPTION_DEF_VALUE not like", value, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueIn(List<String> values) {
            addCriterion("OPTION_DEF_VALUE in", values, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueNotIn(List<String> values) {
            addCriterion("OPTION_DEF_VALUE not in", values, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueBetween(String value1, String value2) {
            addCriterion("OPTION_DEF_VALUE between", value1, value2, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDefValueNotBetween(String value1, String value2) {
            addCriterion("OPTION_DEF_VALUE not between", value1, value2, "optionDefValue");
            return (Criteria) this;
        }

        public Criteria andOptionDescIsNull() {
            addCriterion("OPTION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOptionDescIsNotNull() {
            addCriterion("OPTION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOptionDescEqualTo(String value) {
            addCriterion("OPTION_DESC =", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotEqualTo(String value) {
            addCriterion("OPTION_DESC <>", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescGreaterThan(String value) {
            addCriterion("OPTION_DESC >", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_DESC >=", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLessThan(String value) {
            addCriterion("OPTION_DESC <", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLessThanOrEqualTo(String value) {
            addCriterion("OPTION_DESC <=", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLike(String value) {
            addCriterion("OPTION_DESC like", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotLike(String value) {
            addCriterion("OPTION_DESC not like", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescIn(List<String> values) {
            addCriterion("OPTION_DESC in", values, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotIn(List<String> values) {
            addCriterion("OPTION_DESC not in", values, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescBetween(String value1, String value2) {
            addCriterion("OPTION_DESC between", value1, value2, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotBetween(String value1, String value2) {
            addCriterion("OPTION_DESC not between", value1, value2, "optionDesc");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated do_not_delete_during_merge Fri Mar 27 12:41:28 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_CONFIG_OPTION
     * table comment :null
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
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