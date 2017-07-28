package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.MerchantLimitRuleDO;
import com.sdp.withdraw.dao.MerchantLimitRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MerchantLimitRuleMapper {
    /**
     * 根据Example对象取得null【MerchantLimitRuleDO】对象count信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @SelectProvider(type=MerchantLimitRuleSqlProvider.class, method="countByExample")
    int countByExample(MerchantLimitRuleDOExample example);

    /**
     * 根据Example对象删除null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @DeleteProvider(type=MerchantLimitRuleSqlProvider.class, method="deleteByExample")
    int deleteByExample(MerchantLimitRuleDOExample example);

    /**
     * 根据主键删除null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Delete({
        "delete from FW_MERCHANT_LIMIT_RULE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Insert({
        "insert into FW_MERCHANT_LIMIT_RULE (ID, TYPE, ",
        "MERCHANT_TYPE, MERCHANT_NO, ",
        "LIMIT, STATUS, OPERATOR_ID, ",
        "OPERATOR_NAME, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{type,jdbcType=DECIMAL}, ",
        "#{merchantType,jdbcType=VARCHAR}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{limit,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, #{operatorId,jdbcType=VARCHAR}, ",
        "#{operatorName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_FW_MERCHANT_LIMIT_RULE.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(MerchantLimitRuleDO record);

    /**
     * 添加null【MerchantLimitRuleDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @InsertProvider(type=MerchantLimitRuleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_MERCHANT_LIMIT_RULE.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(MerchantLimitRuleDO record);

    /**
     * 根据Example对象查询得到null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @SelectProvider(type=MerchantLimitRuleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIMIT", property="limit", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MerchantLimitRuleDO> selectByExample(MerchantLimitRuleDOExample example);

    /**
     * 根据Query对象分页查询null【MerchantLimitRuleDO】对象列表信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @SelectProvider(type=MerchantLimitRuleSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIMIT", property="limit", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<MerchantLimitRuleDO> selectByQuery(MerchantLimitRuleDOExample example);

    /**
     * 根据主键查询null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Select({
        "select",
        "ID, TYPE, MERCHANT_TYPE, MERCHANT_NO, LIMIT, STATUS, OPERATOR_ID, OPERATOR_NAME, ",
        "CREATE_TIME, UPDATE_TIME",
        "from FW_MERCHANT_LIMIT_RULE",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="LIMIT", property="limit", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="OPERATOR_ID", property="operatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="OPERATOR_NAME", property="operatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    MerchantLimitRuleDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新null【MerchantLimitRuleDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @UpdateProvider(type=MerchantLimitRuleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MerchantLimitRuleDO record, @Param("example") MerchantLimitRuleDOExample example);

    /**
     * 根据Example对象更新null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @UpdateProvider(type=MerchantLimitRuleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MerchantLimitRuleDO record, @Param("example") MerchantLimitRuleDOExample example);

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @UpdateProvider(type=MerchantLimitRuleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MerchantLimitRuleDO record);

    /**
     * 根据主键更新null【MerchantLimitRuleDO】对象信息
     *
     * @mbggenerated Wed Jul 19 14:41:21 CST 2017
     */
    @Update({
        "update FW_MERCHANT_LIMIT_RULE",
        "set TYPE = #{type,jdbcType=DECIMAL},",
          "MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "LIMIT = #{limit,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "OPERATOR_ID = #{operatorId,jdbcType=VARCHAR},",
          "OPERATOR_NAME = #{operatorName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MerchantLimitRuleDO record);
}