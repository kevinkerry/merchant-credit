package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface Newt0LimitRuleInfoMapper {
    /**
     * 根据Example对象取得商户额度规则信息【Newt0LimitRuleInfoDO】对象count信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @SelectProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="countByExample")
    int countByExample(Newt0LimitRuleInfoDOExample example);

    /**
     * 根据Example对象删除商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @DeleteProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0LimitRuleInfoDOExample example);

    /**
     * 根据主键删除商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Delete({
        "delete from NEWT0_LIMIT_RULE_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Insert({
        "insert into NEWT0_LIMIT_RULE_INFO (RULE_NAME, RULE_LAMBDA, ",
        "LAMBDA_DESC, STATUS, ",
        "CREATE_DATE, UPDATE_DATE)",
        "values (#{ruleName,jdbcType=VARCHAR}, #{ruleLambda,jdbcType=VARCHAR}, ",
        "#{lambdaDesc,jdbcType=VARCHAR}, #{status,jdbcType=DECIMAL}, ",
        "#{createDate,jdbcType=TIMESTAMP}, #{updateDate,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    Long insert(Newt0LimitRuleInfoDO record);

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @InsertProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    Long insertSelective(Newt0LimitRuleInfoDO record);

    /**
     * 根据Example对象查询得到商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @SelectProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RULE_NAME", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RULE_LAMBDA", property="ruleLambda", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAMBDA_DESC", property="lambdaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_DATE", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0LimitRuleInfoDO> selectByExample(Newt0LimitRuleInfoDOExample example);

    /**
     * 根据Query对象分页查询商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @SelectProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RULE_NAME", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RULE_LAMBDA", property="ruleLambda", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAMBDA_DESC", property="lambdaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_DATE", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0LimitRuleInfoDO> selectByQuery(Newt0LimitRuleInfoDOExample example);

    /**
     * 根据主键查询商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Select({
        "select",
        "ID, RULE_NAME, RULE_LAMBDA, LAMBDA_DESC, STATUS, CREATE_DATE, UPDATE_DATE",
        "from NEWT0_LIMIT_RULE_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="RULE_NAME", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="RULE_LAMBDA", property="ruleLambda", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAMBDA_DESC", property="lambdaDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_DATE", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_DATE", property="updateDate", jdbcType=JdbcType.TIMESTAMP)
    })
    Newt0LimitRuleInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @UpdateProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0LimitRuleInfoDO record, @Param("example") Newt0LimitRuleInfoDOExample example);

    /**
     * 根据Example对象更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @UpdateProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0LimitRuleInfoDO record, @Param("example") Newt0LimitRuleInfoDOExample example);

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @UpdateProvider(type=Newt0LimitRuleInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0LimitRuleInfoDO record);

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    @Update({
        "update NEWT0_LIMIT_RULE_INFO",
        "set RULE_NAME = #{ruleName,jdbcType=VARCHAR},",
          "RULE_LAMBDA = #{ruleLambda,jdbcType=VARCHAR},",
          "LAMBDA_DESC = #{lambdaDesc,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "CREATE_DATE = #{createDate,jdbcType=TIMESTAMP},",
          "UPDATE_DATE = #{updateDate,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0LimitRuleInfoDO record);
}