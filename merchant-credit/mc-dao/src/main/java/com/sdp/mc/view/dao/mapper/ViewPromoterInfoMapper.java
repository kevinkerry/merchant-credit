package com.sdp.mc.view.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;

public interface ViewPromoterInfoMapper {
    /**
     * 根据Example对象取得null【ViewPromoterInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 18:24:27 CST 2016
     */
    @SelectProvider(type=ViewPromoterInfoSqlProvider.class, method="countByExample")
    int countByExample(ViewPromoterInfoDTOExample example);

    

    /**
     * 根据Example对象查询得到null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 18:24:27 CST 2016
     */
    @SelectProvider(type=ViewPromoterInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_MARGIN", property="promoterFsMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_BIZ_ID", property="promoterBizId", jdbcType=JdbcType.DECIMAL)
    })
    List<ViewPromoterInfoDTO> selectByExample(ViewPromoterInfoDTOExample example);

    /**
     * 根据Query对象分页查询null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 18:24:28 CST 2016
     */
    @SelectProvider(type=ViewPromoterInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_MARGIN", property="promoterFsMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_BIZ_ID", property="promoterBizId", jdbcType=JdbcType.DECIMAL)
    })
    List<ViewPromoterInfoDTO> selectByQuery(ViewPromoterInfoDTOExample example);

   }