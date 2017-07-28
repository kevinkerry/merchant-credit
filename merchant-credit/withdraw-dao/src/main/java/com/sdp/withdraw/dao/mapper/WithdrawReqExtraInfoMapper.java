package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.WithdrawReqExtraInfoDO;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample;
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

public interface WithdrawReqExtraInfoMapper {
    /**
     * 根据Example对象取得出款扩展信息【WithdrawReqExtraInfoDO】对象count信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @SelectProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="countByExample")
    int countByExample(WithdrawReqExtraInfoDOExample example);

    /**
     * 根据Example对象删除出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @DeleteProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(WithdrawReqExtraInfoDOExample example);

    /**
     * 根据主键删除出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Delete({
        "delete from FW_WITHDRAW_REQ_EXTRA_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Insert({
        "insert into FW_WITHDRAW_REQ_EXTRA_INFO (ID, REQ_ID, ",
        "POST_PAID_FLAG, INIT_WITHDRAW_AMOUNT, ",
        "EXTRA_VALUE1, EXTRA_VALUE2, ",
        "EXTRA_VALUE3)",
        "values (#{id,jdbcType=DECIMAL}, #{reqId,jdbcType=DECIMAL}, ",
        "#{postPaidFlag,jdbcType=DECIMAL}, #{initWithdrawAmount,jdbcType=DECIMAL}, ",
        "#{extraValue1,jdbcType=VARCHAR}, #{extraValue2,jdbcType=VARCHAR}, ",
        "#{extraValue3,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ_EXTRA_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(WithdrawReqExtraInfoDO record);

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @InsertProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_WITHDRAW_REQ_EXTRA_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(WithdrawReqExtraInfoDO record);

    /**
     * 根据Example对象查询得到出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @SelectProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="POST_PAID_FLAG", property="postPaidFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="INIT_WITHDRAW_AMOUNT", property="initWithdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTRA_VALUE1", property="extraValue1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE2", property="extraValue2", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE3", property="extraValue3", jdbcType=JdbcType.VARCHAR)
    })
    List<WithdrawReqExtraInfoDO> selectByExample(WithdrawReqExtraInfoDOExample example);

    /**
     * 根据Query对象分页查询出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @SelectProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="POST_PAID_FLAG", property="postPaidFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="INIT_WITHDRAW_AMOUNT", property="initWithdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTRA_VALUE1", property="extraValue1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE2", property="extraValue2", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE3", property="extraValue3", jdbcType=JdbcType.VARCHAR)
    })
    List<WithdrawReqExtraInfoDO> selectByQuery(WithdrawReqExtraInfoDOExample example);

    /**
     * 根据主键查询出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Select({
        "select",
        "ID, REQ_ID, POST_PAID_FLAG, INIT_WITHDRAW_AMOUNT, EXTRA_VALUE1, EXTRA_VALUE2, ",
        "EXTRA_VALUE3",
        "from FW_WITHDRAW_REQ_EXTRA_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="POST_PAID_FLAG", property="postPaidFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="INIT_WITHDRAW_AMOUNT", property="initWithdrawAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXTRA_VALUE1", property="extraValue1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE2", property="extraValue2", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXTRA_VALUE3", property="extraValue3", jdbcType=JdbcType.VARCHAR)
    })
    WithdrawReqExtraInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @UpdateProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WithdrawReqExtraInfoDO record, @Param("example") WithdrawReqExtraInfoDOExample example);

    /**
     * 根据Example对象更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @UpdateProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WithdrawReqExtraInfoDO record, @Param("example") WithdrawReqExtraInfoDOExample example);

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @UpdateProvider(type=WithdrawReqExtraInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WithdrawReqExtraInfoDO record);

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Update({
        "update FW_WITHDRAW_REQ_EXTRA_INFO",
        "set REQ_ID = #{reqId,jdbcType=DECIMAL},",
          "POST_PAID_FLAG = #{postPaidFlag,jdbcType=DECIMAL},",
          "INIT_WITHDRAW_AMOUNT = #{initWithdrawAmount,jdbcType=DECIMAL},",
          "EXTRA_VALUE1 = #{extraValue1,jdbcType=VARCHAR},",
          "EXTRA_VALUE2 = #{extraValue2,jdbcType=VARCHAR},",
          "EXTRA_VALUE3 = #{extraValue3,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(WithdrawReqExtraInfoDO record);
}