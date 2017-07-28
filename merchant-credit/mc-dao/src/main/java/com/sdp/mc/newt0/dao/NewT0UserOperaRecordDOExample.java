package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewT0UserOperaRecordDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long id;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long bizId;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private String realname;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private String username;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Long bizType;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date operaTime;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    private Date updateTime;

    /**
     * This field corresponds to the database table NEWT0_USEROPERA_RECORD
     * table comments 保证金赎回放款操作表
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_USEROPERA_RECORD
     * table comments 保证金赎回放款操作表
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_USEROPERA_RECORD
     * table comments 保证金赎回放款操作表
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public NewT0UserOperaRecordDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.ID
     *
     * @return the value of NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.ID
     *
     * @param id the value for NEWT0_USEROPERA_RECORD.ID
     * column comments ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     *
     * @return the value of NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getBizId() {
        return bizId;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.BIZ_ID
     *
     * @param bizId the value for NEWT0_USEROPERA_RECORD.BIZ_ID
     * column comments 业务操作ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.REALNAME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.REALNAME
     *
     * @param realname the value for NEWT0_USEROPERA_RECORD.REALNAME
     * column comments 放款人名称
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.USERNAME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.USERNAME
     *
     * @param username the value for NEWT0_USEROPERA_RECORD.USERNAME
     * column comments 放款人ID
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     *
     * @return the value of NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Long getBizType() {
        return bizType;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.BIZ_TYPE
     *
     * @param bizType the value for NEWT0_USEROPERA_RECORD.BIZ_TYPE
     * column comments 业务操作类型(1:保证金取回操作 1:待定义)
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setBizType(Long bizType) {
        this.bizType = bizType;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getOperaTime() {
        return operaTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.OPERA_TIME
     *
     * @param operaTime the value for NEWT0_USEROPERA_RECORD.OPERA_TIME
     * column comments 操作时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setOperaTime(Date operaTime) {
        this.operaTime = operaTime;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.CREATE_TIME
     *
     * @param createTime the value for NEWT0_USEROPERA_RECORD.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     *
     * @return the value of NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column NEWT0_USEROPERA_RECORD.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_USEROPERA_RECORD.UPDATE_TIME
     * column comments 修改时间
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_USEROPERA_RECORD
     * table comment :保证金赎回放款操作表
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
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

        public Criteria andBizIdIsNull() {
            addCriterion("BIZ_ID is null");
            return (Criteria) this;
        }

        public Criteria andBizIdIsNotNull() {
            addCriterion("BIZ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBizIdEqualTo(Long value) {
            addCriterion("BIZ_ID =", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotEqualTo(Long value) {
            addCriterion("BIZ_ID <>", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThan(Long value) {
            addCriterion("BIZ_ID >", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BIZ_ID >=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThan(Long value) {
            addCriterion("BIZ_ID <", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdLessThanOrEqualTo(Long value) {
            addCriterion("BIZ_ID <=", value, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdIn(List<Long> values) {
            addCriterion("BIZ_ID in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotIn(List<Long> values) {
            addCriterion("BIZ_ID not in", values, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdBetween(Long value1, Long value2) {
            addCriterion("BIZ_ID between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andBizIdNotBetween(Long value1, Long value2) {
            addCriterion("BIZ_ID not between", value1, value2, "bizId");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("REALNAME is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("REALNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("REALNAME =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("REALNAME <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("REALNAME >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("REALNAME >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("REALNAME <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("REALNAME <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("REALNAME like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("REALNAME not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("REALNAME in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("REALNAME not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("REALNAME between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("REALNAME not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNull() {
            addCriterion("BIZ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeIsNotNull() {
            addCriterion("BIZ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeEqualTo(Long value) {
            addCriterion("BIZ_TYPE =", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotEqualTo(Long value) {
            addCriterion("BIZ_TYPE <>", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThan(Long value) {
            addCriterion("BIZ_TYPE >", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("BIZ_TYPE >=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThan(Long value) {
            addCriterion("BIZ_TYPE <", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeLessThanOrEqualTo(Long value) {
            addCriterion("BIZ_TYPE <=", value, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeIn(List<Long> values) {
            addCriterion("BIZ_TYPE in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotIn(List<Long> values) {
            addCriterion("BIZ_TYPE not in", values, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeBetween(Long value1, Long value2) {
            addCriterion("BIZ_TYPE between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andBizTypeNotBetween(Long value1, Long value2) {
            addCriterion("BIZ_TYPE not between", value1, value2, "bizType");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIsNull() {
            addCriterion("OPERA_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIsNotNull() {
            addCriterion("OPERA_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperaTimeEqualTo(Date value) {
            addCriterion("OPERA_TIME =", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotEqualTo(Date value) {
            addCriterion("OPERA_TIME <>", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeGreaterThan(Date value) {
            addCriterion("OPERA_TIME >", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERA_TIME >=", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeLessThan(Date value) {
            addCriterion("OPERA_TIME <", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERA_TIME <=", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIn(List<Date> values) {
            addCriterion("OPERA_TIME in", values, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotIn(List<Date> values) {
            addCriterion("OPERA_TIME not in", values, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeBetween(Date value1, Date value2) {
            addCriterion("OPERA_TIME between", value1, value2, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERA_TIME not between", value1, value2, "operaTime");
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
     * This class corresponds to the database table NEWT0_USEROPERA_RECORD
     *
     * @mbggenerated do_not_delete_during_merge Fri Oct 09 09:50:32 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_USEROPERA_RECORD
     * table comment :保证金赎回放款操作表
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
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