package com.sdp.mc.mcbizaccount.dao.mapper;

import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample;
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

public interface BizApplyOpenAccountMapper {
    /**
     * 根据Example对象取得业务层通用开户记录表【BizApplyOpenAccountDO】对象count信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @SelectProvider(type=BizApplyOpenAccountSqlProvider.class, method="countByExample")
    int countByExample(BizApplyOpenAccountDOExample example);

    /**
     * 根据Example对象删除业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @DeleteProvider(type=BizApplyOpenAccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(BizApplyOpenAccountDOExample example);

    /**
     * 根据主键删除业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @Delete({
        "delete from MC_APPLY_OPEN_ACCOUNT",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @Insert({
        "insert into MC_APPLY_OPEN_ACCOUNT (ID, ACCOUNT_TYPE, ",
        "PROMOTER_ID, MERCHANT_NO, ",
        "PROMOTER_NAME, ACCOUNT_ID, ",
        "MEMBER_ID, STATUS, ",
        "BIZ_ID, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{accountType,jdbcType=DECIMAL}, ",
        "#{promoterId,jdbcType=DECIMAL}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{promoterName,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{memberId,jdbcType=VARCHAR}, #{status,jdbcType=DECIMAL}, ",
        "#{bizId,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_MC_APPLY_OPEN_ACCOUNT.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(BizApplyOpenAccountDO record);

    /**
     * 添加业务层通用开户记录表【BizApplyOpenAccountDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @InsertProvider(type=BizApplyOpenAccountSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_MC_APPLY_OPEN_ACCOUNT.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(BizApplyOpenAccountDO record);

    /**
     * 根据Example对象查询得到业务层通用开户记录表【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @SelectProvider(type=BizApplyOpenAccountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyOpenAccountDO> selectByExample(BizApplyOpenAccountDOExample example);

    /**
     * 根据Query对象分页查询业务层通用开户记录表【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @SelectProvider(type=BizApplyOpenAccountSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BizApplyOpenAccountDO> selectByQuery(BizApplyOpenAccountDOExample example);

    /**
     * 根据主键查询业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @Select({
        "select",
        "ID, ACCOUNT_TYPE, PROMOTER_ID, MERCHANT_NO, PROMOTER_NAME, ACCOUNT_ID, MEMBER_ID, ",
        "STATUS, BIZ_ID, CREATE_TIME, UPDATE_TIME",
        "from MC_APPLY_OPEN_ACCOUNT",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_ID", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMBER_ID", property="memberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    BizApplyOpenAccountDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @UpdateProvider(type=BizApplyOpenAccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BizApplyOpenAccountDO record, @Param("example") BizApplyOpenAccountDOExample example);

    /**
     * 根据Example对象更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @UpdateProvider(type=BizApplyOpenAccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BizApplyOpenAccountDO record, @Param("example") BizApplyOpenAccountDOExample example);

    /**
     * 根据主键更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @UpdateProvider(type=BizApplyOpenAccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BizApplyOpenAccountDO record);

    /**
     * 根据主键更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    @Update({
        "update MC_APPLY_OPEN_ACCOUNT",
        "set ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL},",
          "PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR},",
          "ACCOUNT_ID = #{accountId,jdbcType=VARCHAR},",
          "MEMBER_ID = #{memberId,jdbcType=VARCHAR},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "BIZ_ID = #{bizId,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(BizApplyOpenAccountDO record);
}