package com.sdp.withdraw.dao.mapper;

import com.sdp.withdraw.dao.MerchantSettleAttrDO;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample;
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

public interface MerchantSettleAttrMapper {
    /**
     * 根据Example对象取得业务首次开通时间配置信息【MerchantSettleAttrDO】对象count信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @SelectProvider(type=MerchantSettleAttrSqlProvider.class, method="countByExample")
    int countByExample(MerchantSettleAttrDOExample example);

    /**
     * 根据Example对象删除业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @DeleteProvider(type=MerchantSettleAttrSqlProvider.class, method="deleteByExample")
    int deleteByExample(MerchantSettleAttrDOExample example);

    /**
     * 根据主键删除业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Delete({
        "delete from FW_MERCHANT_SETTLE_ATTR",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Insert({
        "insert into FW_MERCHANT_SETTLE_ATTR (ID, BIZ_TYPE, ",
        "FIRST_OPEN_TIME, MERCHANT_NO, ",
        "MERCHANT_TYPE, CREATE_TIME, ",
        "UPDATE_TIME, BIZ_ID, ",
        "EXT1, EXT2)",
        "values (#{id,jdbcType=DECIMAL}, #{bizType,jdbcType=DECIMAL}, ",
        "#{firstOpenTime,jdbcType=TIMESTAMP}, #{merchantNo,jdbcType=VARCHAR}, ",
        "#{merchantType,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{bizId,jdbcType=DECIMAL}, ",
        "#{ext1,jdbcType=VARCHAR}, #{ext2,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_FW_MERCHANT_SETTLE_ATTR.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(MerchantSettleAttrDO record);

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @InsertProvider(type=MerchantSettleAttrSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_FW_MERCHANT_SETTLE_ATTR.nextval from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(MerchantSettleAttrDO record);

    /**
     * 根据Example对象查询得到业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @SelectProvider(type=MerchantSettleAttrSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FIRST_OPEN_TIME", property="firstOpenTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<MerchantSettleAttrDO> selectByExample(MerchantSettleAttrDOExample example);

    /**
     * 根据Query对象分页查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @SelectProvider(type=MerchantSettleAttrSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FIRST_OPEN_TIME", property="firstOpenTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    List<MerchantSettleAttrDO> selectByQuery(MerchantSettleAttrDOExample example);

    /**
     * 根据主键查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Select({
        "select",
        "ID, BIZ_TYPE, FIRST_OPEN_TIME, MERCHANT_NO, MERCHANT_TYPE, CREATE_TIME, UPDATE_TIME, ",
        "BIZ_ID, EXT1, EXT2",
        "from FW_MERCHANT_SETTLE_ATTR",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="FIRST_OPEN_TIME", property="firstOpenTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_TYPE", property="merchantType", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="EXT1", property="ext1", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXT2", property="ext2", jdbcType=JdbcType.VARCHAR)
    })
    MerchantSettleAttrDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @UpdateProvider(type=MerchantSettleAttrSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MerchantSettleAttrDO record, @Param("example") MerchantSettleAttrDOExample example);

    /**
     * 根据Example对象更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @UpdateProvider(type=MerchantSettleAttrSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MerchantSettleAttrDO record, @Param("example") MerchantSettleAttrDOExample example);

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @UpdateProvider(type=MerchantSettleAttrSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MerchantSettleAttrDO record);

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    @Update({
        "update FW_MERCHANT_SETTLE_ATTR",
        "set BIZ_TYPE = #{bizType,jdbcType=DECIMAL},",
          "FIRST_OPEN_TIME = #{firstOpenTime,jdbcType=TIMESTAMP},",
          "MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR},",
          "MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "BIZ_ID = #{bizId,jdbcType=DECIMAL},",
          "EXT1 = #{ext1,jdbcType=VARCHAR},",
          "EXT2 = #{ext2,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MerchantSettleAttrDO record);
}