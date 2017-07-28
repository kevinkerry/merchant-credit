package com.sdp.mc.newt0.dao.mapper.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.newt0.dao.AuditInfoDTO;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;

public interface ExtNewT0AuditInfoMapper {
    /**
     * 根据Example对象取得审核表【NewT0AuditInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=ExtNewT0AuditInfoSqlProvider.class, method="countByExample")
    int countByExample(ExtNewT0AuditInfoDOExample example);

   
    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=ExtNewT0AuditInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_NO", property="objNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQUEST_LOG", property="requestLog", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MCTYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUDIT_TIME", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR)
    })
    List<AuditInfoDTO> selectByExample(ExtNewT0AuditInfoDOExample example);

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SelectProvider(type=ExtNewT0AuditInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="OBJ_NO", property="objNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="OBJ_ID", property="objId", jdbcType=JdbcType.DECIMAL),
        @Result(column="OBJ_TYPE", property="objType", jdbcType=JdbcType.DECIMAL),
        @Result(column="OP_TYPE", property="opType", jdbcType=JdbcType.DECIMAL),
        @Result(column="REQUEST_LOG", property="requestLog", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="OPERATOR", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPIRE_TIME", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MCTYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUDIT_TIME", property="auditTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR)
    })
    List<AuditInfoDTO> selectByQuery(ExtNewT0AuditInfoDOExample example);

  
}