package com.sdp.mc.view.dao.mapper;

import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ViewMerchantInfoMapper {
    /**
     * 根据Example对象取得null【ViewMerchantInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    @SelectProvider(type=ViewMerchantInfoSqlProvider.class, method="countByExample")
    int countByExample(ViewMerchantInfoDTOExample example);

    /**
     * 根据Example对象查询得到null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    @SelectProvider(type=ViewMerchantInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MERCHANT_ID", property="merchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_FS_FLAG", property="merchantFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_FS_LIMIT", property="merchantFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_FS_MIN_LIMIT", property="merchantFsMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_PHONE_NO", property="merchantPhoneNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_MCC", property="merchantMcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_BIZ_ID", property="merchantBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_MARGIN", property="promoterFsMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_BIND_OPERATOR_ID", property="pmtBindOperatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_BIND_OPERATOR_NAME", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_BIZ_ID", property="promoterBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewMerchantInfoDTO> selectByExample(ViewMerchantInfoDTOExample example);

    /**
     * 根据Query对象分页查询null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    @SelectProvider(type=ViewMerchantInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MERCHANT_ID", property="merchantId", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_NAME", property="merchantName", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_FS_FLAG", property="merchantFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_FS_LIMIT", property="merchantFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_FS_MIN_LIMIT", property="merchantFsMinLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_PHONE_NO", property="merchantPhoneNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="AUTO_FAST_SETTLE_FLAG", property="autoFastSettleFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="MERCHANT_MCC", property="merchantMcc", jdbcType=JdbcType.VARCHAR),
        @Result(column="MERCHANT_BIZ_ID", property="merchantBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="LAST_LEVEL_PROMOTER_ID", property="lastLevelPromoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_ID", property="promoterId", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_MERCHANT_NO", property="promoterMerchantNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_NAME", property="promoterName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_TYPE", property="promoterType", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTER_FS_FLAG", property="promoterFsFlag", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_LIMIT", property="promoterFsLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_FS_MARGIN", property="promoterFsMargin", jdbcType=JdbcType.DECIMAL),
        @Result(column="PMT_BIND_OPERATOR_ID", property="pmtBindOperatorId", jdbcType=JdbcType.VARCHAR),
        @Result(column="PMT_BIND_OPERATOR_NAME", property="pmtBindOperatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LOANING_TYPE", property="loaningType", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTER_BIZ_ID", property="promoterBizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ViewMerchantInfoDTO> selectByQuery(ViewMerchantInfoDTOExample example);

   }