package com.sdp.mc.newt0.dao.mapper;

import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0PromoterDOExample;
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

public interface Newt0PromoterMapper {
    /**
     * 根据Example对象取得代理商基础信息【Newt0PromoterDO】对象count信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0PromoterSqlProvider.class, method="countByExample")
    int countByExample(Newt0PromoterDOExample example);

    /**
     * 根据Example对象删除代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @DeleteProvider(type=Newt0PromoterSqlProvider.class, method="deleteByExample")
    int deleteByExample(Newt0PromoterDOExample example);

    /**
     * 根据主键删除代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Delete({
        "delete from NEWT0_PROMOTER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * 添加代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Insert({
        "insert into NEWT0_PROMOTER (ID, PROMOTER_ID, ",
        "PROMOTER_MERCHANT_NO, LOANING_TYPE, ",
        "VALID_CREDIT, CREATE_TIME, ",
        "UPDATE_TIME)",
        "values (#{id,jdbcType=DECIMAL}, #{promoterId,jdbcType=DECIMAL}, ",
        "#{promoterMerchantNo,jdbcType=DECIMAL}, #{loaningType,jdbcType=DECIMAL}, ",
        "#{validCredit,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="select SEQ_NEWT0_PROMOTER.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insert(Newt0PromoterDO record);

    /**
     * 添加代理商基础信息【Newt0PromoterDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @InsertProvider(type=Newt0PromoterSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_NEWT0_PROMOTER.nextval  from dual", keyProperty="id", before=true, resultType=Long.class)
    Long insertSelective(Newt0PromoterDO record);

    /**
     * 根据Example对象查询得到代理商基础信息【Newt0PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0PromoterSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VALID_CREDIT", property="validCredit", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0PromoterDO> selectByExample(Newt0PromoterDOExample example);

    /**
     * 根据Query对象分页查询代理商基础信息【Newt0PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @SelectProvider(type=Newt0PromoterSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VALID_CREDIT", property="validCredit", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Newt0PromoterDO> selectByQuery(Newt0PromoterDOExample example);

    /**
     * 根据主键查询代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Select({
        "select",
        "ID, PROMOTER_ID, PROMOTER_MERCHANT_NO, LOANING_TYPE, VALID_CREDIT, CREATE_TIME, ",
        "UPDATE_TIME",
        "from NEWT0_PROMOTER",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.DECIMAL),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="VALID_CREDIT", property="validCredit", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Newt0PromoterDO selectByPrimaryKey(Long id);

    /**
     * 根据Example对象更新代理商基础信息【Newt0PromoterDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0PromoterSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Newt0PromoterDO record, @Param("example") Newt0PromoterDOExample example);

    /**
     * 根据Example对象更新代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0PromoterSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Newt0PromoterDO record, @Param("example") Newt0PromoterDOExample example);

    /**
     * 根据主键更新代理商基础信息【Newt0PromoterDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @UpdateProvider(type=Newt0PromoterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Newt0PromoterDO record);

    /**
     * 根据主键更新代理商基础信息【Newt0PromoterDO】对象信息
     *
     * @mbggenerated Mon Sep 28 18:15:02 CST 2015
     */
    @Update({
        "update NEWT0_PROMOTER",
        "set PROMOTER_ID = #{promoterId,jdbcType=DECIMAL},",
          "PROMOTER_MERCHANT_NO = #{promoterMerchantNo,jdbcType=DECIMAL},",
          "LOANING_TYPE = #{loaningType,jdbcType=DECIMAL},",
          "VALID_CREDIT = #{validCredit,jdbcType=DECIMAL},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(Newt0PromoterDO record);
}