package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WhiteListInfoDOExample extends QueryBase {
    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String typeName;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String content;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String createUser;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String updateUser;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database table TB_WHITE_LIST_INFO
     * table comments 白名单信息表
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table TB_WHITE_LIST_INFO
     * table comments 白名单信息表
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table TB_WHITE_LIST_INFO
     * table comments 白名单信息表
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public WhiteListInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.ID
     *
     * @return the value of TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.ID
     *
     * @param id the value for TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.TYPE
     *
     * @return the value of TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.TYPE
     *
     * @param type the value for TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.TYPE_NAME
     *
     * @return the value of TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.TYPE_NAME
     *
     * @param typeName the value for TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     *
     * @return the value of TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     *
     * @param merchantNo the value for TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     *
     * @return the value of TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     *
     * @param merchantType the value for TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType == null ? null : merchantType.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CONTENT
     *
     * @return the value of TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getContent() {
        return content;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CONTENT
     *
     * @param content the value for TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CREATE_TIME
     *
     * @return the value of TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CREATE_TIME
     *
     * @param createTime the value for TB_WHITE_LIST_INFO.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     *
     * @return the value of TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.UPDATE_TIME
     *
     * @param updateTime the value for TB_WHITE_LIST_INFO.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.CREATE_USER
     *
     * @return the value of TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.CREATE_USER
     *
     * @param createUser the value for TB_WHITE_LIST_INFO.CREATE_USER
     * column comments 创建的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.UPDATE_USER
     *
     * @return the value of TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.UPDATE_USER
     *
     * @param updateUser the value for TB_WHITE_LIST_INFO.UPDATE_USER
     * column comments 更新的用户
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method returns the value of the database column TB_WHITE_LIST_INFO.STATUS
     *
     * @return the value of TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column TB_WHITE_LIST_INFO.STATUS
     *
     * @param status the value for TB_WHITE_LIST_INFO.STATUS
     * column comments 白名单状态 1 生效  0：失效
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_WHITE_LIST_INFO
     * table comment :白名单信息表
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("TYPE_NAME =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("TYPE_NAME <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("TYPE_NAME >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("TYPE_NAME <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("TYPE_NAME <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("TYPE_NAME like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("TYPE_NAME not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("TYPE_NAME in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("TYPE_NAME not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("TYPE_NAME between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("TYPE_NAME not between", value1, value2, "typeName");
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

        public Criteria andMerchantTypeIsNull() {
            addCriterion("MERCHANT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("MERCHANT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(String value) {
            addCriterion("MERCHANT_TYPE =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(String value) {
            addCriterion("MERCHANT_TYPE >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(String value) {
            addCriterion("MERCHANT_TYPE <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT_TYPE <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLike(String value) {
            addCriterion("MERCHANT_TYPE like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotLike(String value) {
            addCriterion("MERCHANT_TYPE not like", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<String> values) {
            addCriterion("MERCHANT_TYPE in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<String> values) {
            addCriterion("MERCHANT_TYPE not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(String value1, String value2) {
            addCriterion("MERCHANT_TYPE not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_WHITE_LIST_INFO
     *
     * @mbggenerated do_not_delete_during_merge Fri Apr 22 15:46:19 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table TB_WHITE_LIST_INFO
     * table comment :白名单信息表
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
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