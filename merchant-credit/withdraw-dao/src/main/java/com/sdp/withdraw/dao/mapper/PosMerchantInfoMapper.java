package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
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

public interface PosMerchantInfoMapper {
    /**
     * 根据Example对象取得POS商户信息【PosMerchantInfoDO】对象count信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @SelectProvider(type=PosMerchantInfoSqlProvider.class, method="countByExample")
    int countByExample(PosMerchantInfoDOExample example);

    /**
     * 根据Example对象删除POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @DeleteProvider(type=PosMerchantInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(PosMerchantInfoDOExample example);

    /**
     * 根据主键删除POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @Delete({
        "delete from FW_POS_MERCHANT_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @Insert({
        "insert into FW_POS_MERCHANT_INFO (ID, MERCHANT_NO, ",
        "POS_MERCHANT_ID, MERCHANT_TYPE, ",
        "PARENT_PROMOTER_ID, MERCHANT_MEMBER_ID, ",
        "ACCOUNT_TYPE, BASE_ACCOUNT_ID, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "FAST_SETTLE_LIMIT, FAST_SETTLE_FLAG, ",
        "AUTO_FAST_SETTLE_FLAG, MERCHANT_PHONE, ",
        "FAST_SETTLE_MARGIN, FAST_SETTLE_MIN_LIMIT, ",
        "PMT_BIND_OPERATOR_ID, PMT_BIND_OPERATOR_NAME, ",
        "LOANING_TYPE, STATUS, ",
        "MERCHANT_NAME, MCC, ",
        "LAST_LEVEL_PROMOTER_ID, PMT_LEVEL, ",
        "CERT_TYPE, CERT_NO)",
        "values (#{id,jdbcType=DECIMAL}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{posMerchantId,jdbcType=DECIMAL}, #{merchantType,jdbcType=VARCHAR}, ",
        "#{parentPromoterId,jdbcType=DECIMAL}, #{merchantMemberId,jdbcType=VARCHAR}, ",
        "#{accountType,jdbcType=VARCHAR}, #{baseAccountId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{fastSettleLimit,jdbcType=DECIMAL}, #{fastSettleFlag,jdbcType=DECIMAL}, ",
        "#{autoFastSettleFlag,jdbcType=DECIMAL}, #{merchantPhone,jdbcType=VARCHAR}, ",
        "#{fastSettleMargin,jdbcType=DECIMAL}, #{fastSettleMinLimit,jdbcType=DECIMAL}, ",
        "#{pmtBindOperatorId,jdbcType=VARCHAR}, #{pmtBindOperatorName,jdbcType=VARCHAR}, ",
        "#{loaningType,jdbcType=DECIMAL}, #{status,jdbcType=VARCHAR}, ",
        "#{merchantName,jdbcType=VARCHAR}, #{mcc,jdbcType=VARCHAR}, ",
        "#{lastLevelPromoterId,jdbcType=DECIMAL}, #{pmtLevel,jdbcType=DECIMAL}, ",
        "#{certType,jdbcType=VARCHAR}, #{certNo,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_FW_POS_MERCHANT_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(PosMerchantInfoDO record);

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @InsertProvider(type=PosMerchantInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_POS_MERCHANT_INFO.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(PosMerchantInfoDO record);

    /**
     * 根据Example对象查询得到POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @SelectProvider(type=PosMerchantInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MERCHANT_ID", property="posMerchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARENT_PROMOTER_ID", property="parentPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="BASE_ACCOUNT_ID", property="baseAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_BIND_OPERATOR_ID", property="pmtBindOperatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_BIND_OPERATOR_NAME", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_LEVEL", property="pmtLevel", jdbcType=JdbcType.DECIMAL),
        @Result(column="CERT_TYPE", property="certType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_NO", property="certNo", jdbcType=JdbcType.VARCHAR)
    })
    List<PosMerchantInfoDO> selectByExample(PosMerchantInfoDOExample example);

    /**
     * 根据Query对象分页查询POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @SelectProvider(type=PosMerchantInfoSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MERCHANT_ID", property="posMerchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARENT_PROMOTER_ID", property="parentPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="BASE_ACCOUNT_ID", property="baseAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_BIND_OPERATOR_ID", property="pmtBindOperatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_BIND_OPERATOR_NAME", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_LEVEL", property="pmtLevel", jdbcType=JdbcType.DECIMAL),
        @Result(column="CERT_TYPE", property="certType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_NO", property="certNo", jdbcType=JdbcType.VARCHAR)
    })
    List<PosMerchantInfoDO> selectByQuery(PosMerchantInfoDOExample example);

    /**
     * 根据主键查询POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @Select({
        "select",
        "ID, MERCHANT_NO, POS_MERCHANT_ID, MERCHANT_TYPE, PARENT_PROMOTER_ID, MERCHANT_MEMBER_ID, ",
        "ACCOUNT_TYPE, BASE_ACCOUNT_ID, CREATE_TIME, UPDATE_TIME, FAST_SETTLE_LIMIT, ",
        "FAST_SETTLE_FLAG, AUTO_FAST_SETTLE_FLAG, MERCHANT_PHONE, FAST_SETTLE_MARGIN, ",
        "FAST_SETTLE_MIN_LIMIT, PMT_BIND_OPERATOR_ID, PMT_BIND_OPERATOR_NAME, LOANING_TYPE, ",
        "STATUS, MERCHANT_NAME, MCC, LAST_LEVEL_PROMOTER_ID, PMT_LEVEL, CERT_TYPE, CERT_NO",
        "from FW_POS_MERCHANT_INFO",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="POS_MERCHANT_ID", property="posMerchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARENT_PROMOTER_ID", property="parentPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_MEMBER_ID", property="merchantMemberId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ACCOUNT_TYPE", property="accountType", jdbcType=JdbcType.VARCHAR),
        @Result(column="BASE_ACCOUNT_ID", property="baseAccountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="FAST_SETTLE_LIMIT", property="fastSettleLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_FLAG", property="fastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_PHONE", property="merchantPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="FAST_SETTLE_MARGIN", property="fastSettleMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="FAST_SETTLE_MIN_LIMIT", property="fastSettleMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_BIND_OPERATOR_ID", property="pmtBindOperatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_BIND_OPERATOR_NAME", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="STATUS", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MCC", property="mcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_LEVEL", property="pmtLevel", jdbcType=JdbcType.DECIMAL),
        @Result(column="CERT_TYPE", property="certType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CERT_NO", property="certNo", jdbcType=JdbcType.VARCHAR)
    })
    PosMerchantInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @UpdateProvider(type=PosMerchantInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PosMerchantInfoDO record, @Param("example") PosMerchantInfoDOExample example);

    /**
     * 根据Example对象更新POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @UpdateProvider(type=PosMerchantInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PosMerchantInfoDO record, @Param("example") PosMerchantInfoDOExample example);

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @UpdateProvider(type=PosMerchantInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PosMerchantInfoDO record);

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    @Update({
        "update FW_POS_MERCHANT_INFO",
        "set MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "POS_MERCHANT_ID = #{posMerchantId,jdbcType=DECIMAL},",
          "MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR},",
          "PARENT_PROMOTER_ID = #{parentPromoterId,jdbcType=DECIMAL},",
          "MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR},",
          "ACCOUNT_TYPE = #{accountType,jdbcType=VARCHAR},",
          "BASE_ACCOUNT_ID = #{baseAccountId,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL},",
          "FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL},",
          "AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL},",
          "MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR},",
          "FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL},",
          "FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL},",
          "PMT_BIND_OPERATOR_ID = #{pmtBindOperatorId,jdbcType=VARCHAR},",
          "PMT_BIND_OPERATOR_NAME = #{pmtBindOperatorName,jdbcType=VARCHAR},",
          "LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "STATUS = #{status,jdbcType=VARCHAR},",
          "MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR},",
          "MCC = #{mcc,jdbcType=VARCHAR},",
          "LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL},",
          "PMT_LEVEL = #{pmtLevel,jdbcType=DECIMAL},",
          "CERT_TYPE = #{certType,jdbcType=VARCHAR},",
          "CERT_NO = #{certNo,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(PosMerchantInfoDO record);
}