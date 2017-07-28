package com.sdp.mc.newt0.dao;

import com.sdp.emall.common.dao.QueryBase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Newt0McLimitChangeReqDOExample extends QueryBase {
    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date reqTime;
    
    private Date startTime;
    
    private Date endTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer reqNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer successNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer failNum;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer status;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private String reqFileName;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    private Integer reqType;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     * table comments 商户额度变更请求信息表
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    protected String orderByClause;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     * table comments 商户额度变更请求信息表
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    protected boolean distinct;

    /**
     * This field corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     * table comments 商户额度变更请求信息表
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Newt0McLimitChangeReqDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     *
     * @param reqId the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_ID
     * column comments 请求ID
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getReqTime() {
        return reqTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     *
     * @param reqTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TIME
     * column comments 请求的时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     *
     * @param createTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.CREATE_TIME
     * column comments 创建时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getReqNum() {
        return reqNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     *
     * @param reqNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_NUM
     * column comments 请求变更数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqNum(Integer reqNum) {
        this.reqNum = reqNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getSuccessNum() {
        return successNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     *
     * @param successNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.SUCCESS_NUM
     * column comments 变更成功数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setSuccessNum(Integer successNum) {
        this.successNum = successNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getFailNum() {
        return failNum;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     *
     * @param failNum the value for NEWT0_MC_LIMIT_CHANGE_REQ.FAIL_NUM
     * column comments 变更失败数量
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     *
     * @param status the value for NEWT0_MC_LIMIT_CHANGE_REQ.STATUS
     * column comments 执行状态  0：初始  1：执行中  2：执行完成
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getReqFileName() {
        return reqFileName;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     *
     * @param reqFileName the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_FILE_NAME
     * column comments 请求的文件名
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqFileName(String reqFileName) {
        this.reqFileName = reqFileName == null ? null : reqFileName.trim();
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    
    

    public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     *
     * @param updateTime the value for NEWT0_MC_LIMIT_CHANGE_REQ.UPDATE_TIME
     * column comments 最后更新时间
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     *
     * @return the value of NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Integer getReqType() {
        return reqType;
    }

    /**
     * This method sets the value of the database column NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     *
     * @param reqType the value for NEWT0_MC_LIMIT_CHANGE_REQ.REQ_TYPE
     * column comments 请求类型  0：上传文件  1 :月初自动  
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setReqType(Integer reqType) {
        this.reqType = reqType;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     * table comment :商户额度变更请求信息表
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
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

        public Criteria andReqTimeIsNull() {
            addCriterion("REQ_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReqTimeIsNotNull() {
            addCriterion("REQ_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReqTimeEqualTo(Date value) {
            addCriterion("REQ_TIME =", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotEqualTo(Date value) {
            addCriterion("REQ_TIME <>", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeGreaterThan(Date value) {
            addCriterion("REQ_TIME >", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REQ_TIME >=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeLessThan(Date value) {
            addCriterion("REQ_TIME <", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeLessThanOrEqualTo(Date value) {
            addCriterion("REQ_TIME <=", value, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeIn(List<Date> values) {
            addCriterion("REQ_TIME in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotIn(List<Date> values) {
            addCriterion("REQ_TIME not in", values, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeBetween(Date value1, Date value2) {
            addCriterion("REQ_TIME between", value1, value2, "reqTime");
            return (Criteria) this;
        }

        public Criteria andReqTimeNotBetween(Date value1, Date value2) {
            addCriterion("REQ_TIME not between", value1, value2, "reqTime");
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

        public Criteria andReqNumIsNull() {
            addCriterion("REQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andReqNumIsNotNull() {
            addCriterion("REQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andReqNumEqualTo(Integer value) {
            addCriterion("REQ_NUM =", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotEqualTo(Integer value) {
            addCriterion("REQ_NUM <>", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThan(Integer value) {
            addCriterion("REQ_NUM >", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("REQ_NUM >=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThan(Integer value) {
            addCriterion("REQ_NUM <", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumLessThanOrEqualTo(Integer value) {
            addCriterion("REQ_NUM <=", value, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumIn(List<Integer> values) {
            addCriterion("REQ_NUM in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotIn(List<Integer> values) {
            addCriterion("REQ_NUM not in", values, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumBetween(Integer value1, Integer value2) {
            addCriterion("REQ_NUM between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andReqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("REQ_NUM not between", value1, value2, "reqNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIsNull() {
            addCriterion("SUCCESS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIsNotNull() {
            addCriterion("SUCCESS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessNumEqualTo(Integer value) {
            addCriterion("SUCCESS_NUM =", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotEqualTo(Integer value) {
            addCriterion("SUCCESS_NUM <>", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThan(Integer value) {
            addCriterion("SUCCESS_NUM >", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUCCESS_NUM >=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThan(Integer value) {
            addCriterion("SUCCESS_NUM <", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumLessThanOrEqualTo(Integer value) {
            addCriterion("SUCCESS_NUM <=", value, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumIn(List<Integer> values) {
            addCriterion("SUCCESS_NUM in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotIn(List<Integer> values) {
            addCriterion("SUCCESS_NUM not in", values, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumBetween(Integer value1, Integer value2) {
            addCriterion("SUCCESS_NUM between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andSuccessNumNotBetween(Integer value1, Integer value2) {
            addCriterion("SUCCESS_NUM not between", value1, value2, "successNum");
            return (Criteria) this;
        }

        public Criteria andFailNumIsNull() {
            addCriterion("FAIL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFailNumIsNotNull() {
            addCriterion("FAIL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFailNumEqualTo(Integer value) {
            addCriterion("FAIL_NUM =", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotEqualTo(Integer value) {
            addCriterion("FAIL_NUM <>", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumGreaterThan(Integer value) {
            addCriterion("FAIL_NUM >", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FAIL_NUM >=", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumLessThan(Integer value) {
            addCriterion("FAIL_NUM <", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumLessThanOrEqualTo(Integer value) {
            addCriterion("FAIL_NUM <=", value, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumIn(List<Integer> values) {
            addCriterion("FAIL_NUM in", values, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotIn(List<Integer> values) {
            addCriterion("FAIL_NUM not in", values, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumBetween(Integer value1, Integer value2) {
            addCriterion("FAIL_NUM between", value1, value2, "failNum");
            return (Criteria) this;
        }

        public Criteria andFailNumNotBetween(Integer value1, Integer value2) {
            addCriterion("FAIL_NUM not between", value1, value2, "failNum");
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

        public Criteria andReqFileNameIsNull() {
            addCriterion("REQ_FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReqFileNameIsNotNull() {
            addCriterion("REQ_FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReqFileNameEqualTo(String value) {
            addCriterion("REQ_FILE_NAME =", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameNotEqualTo(String value) {
            addCriterion("REQ_FILE_NAME <>", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameGreaterThan(String value) {
            addCriterion("REQ_FILE_NAME >", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_FILE_NAME >=", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameLessThan(String value) {
            addCriterion("REQ_FILE_NAME <", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameLessThanOrEqualTo(String value) {
            addCriterion("REQ_FILE_NAME <=", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameLike(String value) {
            addCriterion("REQ_FILE_NAME like", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameNotLike(String value) {
            addCriterion("REQ_FILE_NAME not like", value, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameIn(List<String> values) {
            addCriterion("REQ_FILE_NAME in", values, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameNotIn(List<String> values) {
            addCriterion("REQ_FILE_NAME not in", values, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameBetween(String value1, String value2) {
            addCriterion("REQ_FILE_NAME between", value1, value2, "reqFileName");
            return (Criteria) this;
        }

        public Criteria andReqFileNameNotBetween(String value1, String value2) {
            addCriterion("REQ_FILE_NAME not between", value1, value2, "reqFileName");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     *
     * @mbggenerated do_not_delete_during_merge Mon Jan 11 11:09:30 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWT0_MC_LIMIT_CHANGE_REQ
     * table comment :商户额度变更请求信息表
     *
     * @mbggenerated Mon Jan 11 11:09:30 CST 2016
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