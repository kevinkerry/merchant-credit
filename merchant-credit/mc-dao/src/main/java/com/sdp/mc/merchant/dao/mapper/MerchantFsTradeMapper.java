package com.sdp.mc.merchant.dao.mapper;

import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
import com.sdp.mc.merchant.dao.MerchantFsTradeDOExample;
import com.sdp.mc.merchant.dao.mapper.MerchantFsTradeSqlProvider;

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

public interface MerchantFsTradeMapper {
	/**
     * 根据Example对象取得null【MerchantFsTradeDO】对象count信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    @SelectProvider(type=MerchantFsTradeSqlProvider.class, method="countByExample")
    int countByExample(MerchantFsTradeDOExample example);

    /**
     * 根据Example对象删除null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @DeleteProvider(type=MerchantFsTradeSqlProvider.class, method="deleteByExample")
    int deleteByExample(MerchantFsTradeDOExample example);

    /**
     * 根据主键删除null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @Delete({
        "delete from TB_MARCHAT_FS_TRADE",
        "where MFT_ID = #{mftId,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(Long mftId);

    /**
     * 添加null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @Insert({
        "insert into TB_MARCHAT_FS_TRADE (MFT_ID, MFQ_ID, ",
        "ORDER_NO, TRADE_TIME, ",
        "TXN_NO, TRADE_TYPE, ",
        "TRADE_STATUS, TRADE_AMOUNT, ",
        "TRADE_FEE, SETTLE_AMOUNT, ",
        "CARD_TYPE, SHORT_PAN, ",
        "ISSUER_ID, TERMINAL_NO, ",
        "CREATE_TIME, UPDATE_TIME, ",
        "TXN_STATUS, TXN_TYPE, ",
        "TXN_CARD_TYPE, TXN_ISSUER_ID, ",
        "TXN_SHORT_PAN)",
        "values (#{mftId,jdbcType=DECIMAL}, #{mfqId,jdbcType=DECIMAL}, ",
        "#{orderNo,jdbcType=VARCHAR}, #{tradeTime,jdbcType=TIMESTAMP}, ",
        "#{txnNo,jdbcType=VARCHAR}, #{tradeType,jdbcType=VARCHAR}, ",
        "#{tradeStatus,jdbcType=VARCHAR}, #{tradeAmount,jdbcType=DECIMAL}, ",
        "#{tradeFee,jdbcType=DECIMAL}, #{settleAmount,jdbcType=DECIMAL}, ",
        "#{cardType,jdbcType=VARCHAR}, #{shortPan,jdbcType=VARCHAR}, ",
        "#{issuerId,jdbcType=VARCHAR}, #{terminalNo,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{txnStatus,jdbcType=VARCHAR}, #{txnType,jdbcType=VARCHAR}, ",
        "#{txnCardType,jdbcType=VARCHAR}, #{txnIssuerId,jdbcType=VARCHAR}, ",
        "#{txnShortPan,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select SEQ_TB_MARCHAT_FS_TRADE.nextval from dual", keyProperty="mftId", before=true, resultType=Long.class)
    Long insert(MerchantFsTradeDO record);

    /**
     * 添加null【MerchantFsTradeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @InsertProvider(type=MerchantFsTradeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select SEQ_TB_MARCHAT_FS_TRADE.nextval from dual", keyProperty="mftId", before=true, resultType=Long.class)
    Long insertSelective(MerchantFsTradeDO record);

    /**
     * 根据Example对象查询得到null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @SelectProvider(type=MerchantFsTradeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="MFT_ID", property="mftId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TIME", property="tradeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_NO", property="txnNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TYPE", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATUS", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_AMOUNT", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_FEE", property="tradeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_AMOUNT", property="settleAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SHORT_PAN", property="shortPan", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUER_ID", property="issuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TERMINAL_NO", property="terminalNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_STATUS", property="txnStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_TYPE", property="txnType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_CARD_TYPE", property="txnCardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_ISSUER_ID", property="txnIssuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_SHORT_PAN", property="txnShortPan", jdbcType=JdbcType.VARCHAR)
    })
    List<MerchantFsTradeDO> selectByExample(MerchantFsTradeDOExample example);

    /**
     * 根据Query对象分页查询null【MerchantFsTradeDO】对象列表信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    @SelectProvider(type=MerchantFsTradeSqlProvider.class, method="selectByQuery")
    @Results({
        @Result(column="MFT_ID", property="mftId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TIME", property="tradeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_NO", property="txnNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TYPE", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATUS", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_AMOUNT", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_FEE", property="tradeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_AMOUNT", property="settleAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SHORT_PAN", property="shortPan", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUER_ID", property="issuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TERMINAL_NO", property="terminalNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_STATUS", property="txnStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_TYPE", property="txnType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_CARD_TYPE", property="txnCardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_ISSUER_ID", property="txnIssuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_SHORT_PAN", property="txnShortPan", jdbcType=JdbcType.VARCHAR)
    })
    List<MerchantFsTradeDO> selectByQuery(MerchantFsTradeDOExample example);

    /**
     * 根据主键查询null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @Select({
        "select",
        "MFT_ID, MFQ_ID, ORDER_NO, TRADE_TIME, TXN_NO, TRADE_TYPE, TRADE_STATUS, TRADE_AMOUNT, ",
        "TRADE_FEE, SETTLE_AMOUNT, CARD_TYPE, SHORT_PAN, ISSUER_ID, TERMINAL_NO, CREATE_TIME, ",
        "UPDATE_TIME, TXN_STATUS, TXN_TYPE, TXN_CARD_TYPE, TXN_ISSUER_ID, TXN_SHORT_PAN",
        "from TB_MARCHAT_FS_TRADE",
        "where MFT_ID = #{mftId,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="MFT_ID", property="mftId", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="MFQ_ID", property="mfqId", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TIME", property="tradeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_NO", property="txnNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_TYPE", property="tradeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATUS", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_AMOUNT", property="tradeAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="TRADE_FEE", property="tradeFee", jdbcType=JdbcType.DECIMAL),
        @Result(column="SETTLE_AMOUNT", property="settleAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="CARD_TYPE", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="SHORT_PAN", property="shortPan", jdbcType=JdbcType.VARCHAR),
        @Result(column="ISSUER_ID", property="issuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TERMINAL_NO", property="terminalNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TXN_STATUS", property="txnStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_TYPE", property="txnType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_CARD_TYPE", property="txnCardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_ISSUER_ID", property="txnIssuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="TXN_SHORT_PAN", property="txnShortPan", jdbcType=JdbcType.VARCHAR)
    })
    MerchantFsTradeDO selectByPrimaryKey(Long mftId);

    /**
     * 根据Example对象更新null【MerchantFsTradeDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @UpdateProvider(type=MerchantFsTradeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MerchantFsTradeDO record, @Param("example") MerchantFsTradeDOExample example);

    /**
     * 根据Example对象更新null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Wed Apr 15 20:57:54 CST 2015
     */
    @UpdateProvider(type=MerchantFsTradeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MerchantFsTradeDO record, @Param("example") MerchantFsTradeDOExample example);

    /**
     * 根据主键更新null【MerchantFsTradeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    @UpdateProvider(type=MerchantFsTradeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MerchantFsTradeDO record);

    /**
     * 根据主键更新null【MerchantFsTradeDO】对象信息
     *
     * @mbggenerated Tue Dec 29 15:50:27 CST 2015
     */
    @Update({
        "update TB_MARCHAT_FS_TRADE",
        "set MFQ_ID = #{mfqId,jdbcType=DECIMAL},",
          "ORDER_NO = #{orderNo,jdbcType=VARCHAR},",
          "TRADE_TIME = #{tradeTime,jdbcType=TIMESTAMP},",
          "TXN_NO = #{txnNo,jdbcType=VARCHAR},",
          "TRADE_TYPE = #{tradeType,jdbcType=VARCHAR},",
          "TRADE_STATUS = #{tradeStatus,jdbcType=VARCHAR},",
          "TRADE_AMOUNT = #{tradeAmount,jdbcType=DECIMAL},",
          "TRADE_FEE = #{tradeFee,jdbcType=DECIMAL},",
          "SETTLE_AMOUNT = #{settleAmount,jdbcType=DECIMAL},",
          "CARD_TYPE = #{cardType,jdbcType=VARCHAR},",
          "SHORT_PAN = #{shortPan,jdbcType=VARCHAR},",
          "ISSUER_ID = #{issuerId,jdbcType=VARCHAR},",
          "TERMINAL_NO = #{terminalNo,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "TXN_STATUS = #{txnStatus,jdbcType=VARCHAR},",
          "TXN_TYPE = #{txnType,jdbcType=VARCHAR},",
          "TXN_CARD_TYPE = #{txnCardType,jdbcType=VARCHAR},",
          "TXN_ISSUER_ID = #{txnIssuerId,jdbcType=VARCHAR},",
          "TXN_SHORT_PAN = #{txnShortPan,jdbcType=VARCHAR}",
        "where MFT_ID = #{mftId,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(MerchantFsTradeDO record);
}