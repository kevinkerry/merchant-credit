package com.sdp.mc.promoter.dao.mapper;

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
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

public interface PromoterFastSettleSwitchMapper {
    /**
     * 根据Example对象取得代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象count信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @SelectProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="countByExample")
    int countByExample(PromoterFastSettleSwitchDOExample example);

    /**
     * 根据Example对象删除代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @DeleteProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="deleteByExample")
    int deleteByExample(PromoterFastSettleSwitchDOExample example);

    /**
     * 根据主键删除代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @Delete({
        "delete from TB_PROMOTER_FS_REQ",
        "where PFR_ID = #{pfrId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long pfrId);

    /**
     * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @Insert({
        "insert into TB_PROMOTER_FS_REQ (PFR_ID, PROMOTER_ID, ",
        "TYPE, STATUS, MARGIN_ACCOUNT, ",
        "MAQ_ID, FCM_ID, CREATE_TIME, ",
        "UPDATE_TIME, MARGIN_MEMBER_ID)",
        "values (#{pfrId,jdbcType=DECIMAL}, #{promoterId,jdbcType=DECIMAL}, ",
        "#{type,jdbcType=DECIMAL}, #{status,jdbcType=DECIMAL}, #{marginAccount,jdbcType=VARCHAR}, ",
        "#{maqId,jdbcType=DECIMAL}, #{fcmId,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{marginMemberId,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_PROMOTER_FS_REQ.nextval from dual", keyProperty="pfrId", before=true, resultType=Long.class)
    Long insert(PromoterFastSettleSwitchDO record);

    /**
     * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @InsertProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_PROMOTER_FS_REQ.nextval from dual", keyProperty="pfrId", before=true, resultType=Long.class)
    Long insertSelective(PromoterFastSettleSwitchDO record);

    /**
     * 根据Example对象查询得到代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @SelectProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PFR_ID", property="pfrId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_ACCOUNT", property="marginAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAQ_ID", property="maqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR)
    })
    List<PromoterFastSettleSwitchDO> selectByExample(PromoterFastSettleSwitchDOExample example);

    /**
     * 根据Query对象分页查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @SelectProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="PFR_ID", property="pfrId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_ACCOUNT", property="marginAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAQ_ID", property="maqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR)
    })
    List<PromoterFastSettleSwitchDO> selectByQuery(PromoterFastSettleSwitchDOExample example);

    /**
     * 根据主键查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @Select({
        "select",
        "PFR_ID, PROMOTER_ID, TYPE, STATUS, MARGIN_ACCOUNT, MAQ_ID, FCM_ID, CREATE_TIME, ",
        "UPDATE_TIME, MARGIN_MEMBER_ID",
        "from TB_PROMOTER_FS_REQ",
        "where PFR_ID = #{pfrId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="PFR_ID", property="pfrId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="TYPE", property="type", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
        @Result(column="MARGIN_ACCOUNT", property="marginAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="MAQ_ID", property="maqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="FCM_ID", property="fcmId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MARGIN_MEMBER_ID", property="marginMemberId", jdbcType=JdbcType.VARCHAR)
    })
    PromoterFastSettleSwitchDO selectByPrimaryKey(Long pfrId);

    /**
     * 根据Example对象更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @UpdateProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PromoterFastSettleSwitchDO record, @Param("example") PromoterFastSettleSwitchDOExample example);

    /**
     * 根据Example对象更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @UpdateProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PromoterFastSettleSwitchDO record, @Param("example") PromoterFastSettleSwitchDOExample example);

    /**
     * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @UpdateProvider(type=PromoterFastSettleSwitchSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PromoterFastSettleSwitchDO record);

    /**
     * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    @Update({
        "update TB_PROMOTER_FS_REQ",
        "set PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "TYPE = #{type,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=DECIMAL},",
          "MARGIN_ACCOUNT = #{marginAccount,jdbcType=VARCHAR},",
          "MAQ_ID = #{maqId,jdbcType=DECIMAL},",
          "FCM_ID = #{fcmId,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "MARGIN_MEMBER_ID = #{marginMemberId,jdbcType=VARCHAR}",
        "where PFR_ID = #{pfrId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(PromoterFastSettleSwitchDO record);
}