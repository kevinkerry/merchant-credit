package com.sdp.mc.msp.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample.Criteria;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample.Criterion;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample;
import java.util.List;
import java.util.Map;

public class FsConfigChangeSqlProvider {

    /**
     * 根据Example对象取得配置更改记录【FsConfigChangeDO】对象count信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String countByExample(FsConfigChangeDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_FS_CONFIG_CHANGE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String deleteByExample(FsConfigChangeDOExample example) {
        BEGIN();
        DELETE_FROM("TB_FS_CONFIG_CHANGE");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加配置更改记录【FsConfigChangeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String insertSelective(FsConfigChangeDO record) {
        BEGIN();
        INSERT_INTO("TB_FS_CONFIG_CHANGE");
        
        VALUES("FCM_ID", "#{fcmId,jdbcType=DECIMAL}");
        
        if (record.getType() != null) {
            VALUES("TYPE", "#{type,jdbcType=DECIMAL}");
        }
        
        if (record.getObjId() != null) {
            VALUES("OBJ_ID", "#{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            VALUES("OP_TYPE", "#{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            VALUES("VERSION", "#{version,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            VALUES("FAST_SETTLE_FLAG", "#{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMargin() != null) {
            VALUES("FAST_SETTLE_MARGIN", "#{fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            VALUES("FAST_SETTLE_LIMIT", "#{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastConfigureLimit() != null) {
            VALUES("FAST_CONFIGURE_LIMIT", "#{fastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleRatio() != null) {
            VALUES("FAST_SETTLE_RATIO", "#{fastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleWorkdayFee() != null) {
            VALUES("FAST_SETTLE_WORKDAY_FEE", "#{fastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleHolidayFee() != null) {
            VALUES("FAST_SETTLE_HOLIDAY_FEE", "#{fastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleFlag() != null) {
            VALUES("BEFORE_FAST_SETTLE_FLAG", "#{beforeFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMargin() != null) {
            VALUES("BEFORE_FAST_SETTLE_MARGIN", "#{beforeFastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleLimit() != null) {
            VALUES("BEFORE_FAST_SETTLE_LIMIT", "#{beforeFastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastConfigureLimit() != null) {
            VALUES("BEFORE_FAST_CONFIGURE_LIMIT", "#{beforeFastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleRatio() != null) {
            VALUES("BEFORE_FAST_SETTLE_RATIO", "#{beforeFastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleWorkdayFee() != null) {
            VALUES("BEFOREFAST_SETTLE_WORKDAY_FEE", "#{beforeFastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleHolidayFee() != null) {
            VALUES("BEFOREFAST_SETTLE_HOLIDAY_FEE", "#{beforeFastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            VALUES("LOANING_TYPE", "#{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            VALUES("FAST_SETTLE_MIN_LIMIT", "#{fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMinLimit() != null) {
            VALUES("BEFORE_FAST_SETTLE_MIN_LIMIT", "#{beforeFastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettle() != null) {
            VALUES("AUTO_FAST_SETTLE", "#{autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeAutoFastSettle() != null) {
            VALUES("BEFORE_AUTO_FAST_SETTLE", "#{beforeAutoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getOperator() != null) {
            VALUES("OPERATOR", "#{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterMinMargin() != null) {
            VALUES("PROMOTER_MIN_MARGIN", "#{promoterMinMargin,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:43 CST 2016
     */
    public String selectByExample(FsConfigChangeDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("FCM_ID");
        } else {
            SELECT("FCM_ID");
        }
        SELECT("TYPE");
        SELECT("OBJ_ID");
        SELECT("OP_TYPE");
        SELECT("VERSION");
        SELECT("STATUS");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("FAST_SETTLE_MARGIN");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("FAST_CONFIGURE_LIMIT");
        SELECT("FAST_SETTLE_RATIO");
        SELECT("FAST_SETTLE_WORKDAY_FEE");
        SELECT("FAST_SETTLE_HOLIDAY_FEE");
        SELECT("BEFORE_FAST_SETTLE_FLAG");
        SELECT("BEFORE_FAST_SETTLE_MARGIN");
        SELECT("BEFORE_FAST_SETTLE_LIMIT");
        SELECT("BEFORE_FAST_CONFIGURE_LIMIT");
        SELECT("BEFORE_FAST_SETTLE_RATIO");
        SELECT("BEFOREFAST_SETTLE_WORKDAY_FEE");
        SELECT("BEFOREFAST_SETTLE_HOLIDAY_FEE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("LOANING_TYPE");
        SELECT("FAST_SETTLE_MIN_LIMIT");
        SELECT("BEFORE_FAST_SETTLE_MIN_LIMIT");
        SELECT("AUTO_FAST_SETTLE");
        SELECT("BEFORE_AUTO_FAST_SETTLE");
        SELECT("OPERATOR");
        SELECT("PROMOTER_MIN_MARGIN");
        FROM("TB_FS_CONFIG_CHANGE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    public String selectByQuery(FsConfigChangeDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("FCM_ID");
        } else {
            SELECT("FCM_ID");
        }
        SELECT("TYPE");
        SELECT("OBJ_ID");
        SELECT("OP_TYPE");
        SELECT("VERSION");
        SELECT("STATUS");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("FAST_SETTLE_MARGIN");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("FAST_CONFIGURE_LIMIT");
        SELECT("FAST_SETTLE_RATIO");
        SELECT("FAST_SETTLE_WORKDAY_FEE");
        SELECT("FAST_SETTLE_HOLIDAY_FEE");
        SELECT("BEFORE_FAST_SETTLE_FLAG");
        SELECT("BEFORE_FAST_SETTLE_MARGIN");
        SELECT("BEFORE_FAST_SETTLE_LIMIT");
        SELECT("BEFORE_FAST_CONFIGURE_LIMIT");
        SELECT("BEFORE_FAST_SETTLE_RATIO");
        SELECT("BEFOREFAST_SETTLE_WORKDAY_FEE");
        SELECT("BEFOREFAST_SETTLE_HOLIDAY_FEE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("LOANING_TYPE");
        SELECT("FAST_SETTLE_MIN_LIMIT");
        SELECT("BEFORE_FAST_SETTLE_MIN_LIMIT");
        SELECT("AUTO_FAST_SETTLE");
        SELECT("BEFORE_AUTO_FAST_SETTLE");
        SELECT("OPERATOR");
        SELECT("PROMOTER_MIN_MARGIN");
        FROM("TB_FS_CONFIG_CHANGE");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String srcSql = SQL();
        StringBuilder sqlStr = new StringBuilder();
        sqlStr.append("select t.* from (select tt.*, ROWNUM rnum from ( ");
        sqlStr.append(srcSql);
        sqlStr.append(") tt) t where   t.rnum <= #{pageLastItem,jdbcType=NUMERIC}  and t.rnum >= #{pageFristItem,jdbcType=NUMERIC}");
        
        
        return sqlStr.toString();
    }

    /**
     * 根据Example对象更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        FsConfigChangeDO record = (FsConfigChangeDO) parameter.get("record");
        FsConfigChangeDOExample example = (FsConfigChangeDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_FS_CONFIG_CHANGE");
        
        if (record.getFcmId() != null) {
            SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        }
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("VERSION = #{record.version,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMargin() != null) {
            SET("FAST_SETTLE_MARGIN = #{record.fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastConfigureLimit() != null) {
            SET("FAST_CONFIGURE_LIMIT = #{record.fastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleRatio() != null) {
            SET("FAST_SETTLE_RATIO = #{record.fastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleWorkdayFee() != null) {
            SET("FAST_SETTLE_WORKDAY_FEE = #{record.fastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleHolidayFee() != null) {
            SET("FAST_SETTLE_HOLIDAY_FEE = #{record.fastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleFlag() != null) {
            SET("BEFORE_FAST_SETTLE_FLAG = #{record.beforeFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMargin() != null) {
            SET("BEFORE_FAST_SETTLE_MARGIN = #{record.beforeFastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleLimit() != null) {
            SET("BEFORE_FAST_SETTLE_LIMIT = #{record.beforeFastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastConfigureLimit() != null) {
            SET("BEFORE_FAST_CONFIGURE_LIMIT = #{record.beforeFastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleRatio() != null) {
            SET("BEFORE_FAST_SETTLE_RATIO = #{record.beforeFastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleWorkdayFee() != null) {
            SET("BEFOREFAST_SETTLE_WORKDAY_FEE = #{record.beforeFastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleHolidayFee() != null) {
            SET("BEFOREFAST_SETTLE_HOLIDAY_FEE = #{record.beforeFastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            SET("FAST_SETTLE_MIN_LIMIT = #{record.fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMinLimit() != null) {
            SET("BEFORE_FAST_SETTLE_MIN_LIMIT = #{record.beforeFastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettle() != null) {
            SET("AUTO_FAST_SETTLE = #{record.autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeAutoFastSettle() != null) {
            SET("BEFORE_AUTO_FAST_SETTLE = #{record.beforeAutoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterMinMargin() != null) {
            SET("PROMOTER_MIN_MARGIN = #{record.promoterMinMargin,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_FS_CONFIG_CHANGE");
        
        SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        SET("OP_TYPE = #{record.opType,jdbcType=DECIMAL}");
        SET("VERSION = #{record.version,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_MARGIN = #{record.fastSettleMargin,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        SET("FAST_CONFIGURE_LIMIT = #{record.fastConfigureLimit,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_RATIO = #{record.fastSettleRatio,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_WORKDAY_FEE = #{record.fastSettleWorkdayFee,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_HOLIDAY_FEE = #{record.fastSettleHolidayFee,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_SETTLE_FLAG = #{record.beforeFastSettleFlag,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_SETTLE_MARGIN = #{record.beforeFastSettleMargin,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_SETTLE_LIMIT = #{record.beforeFastSettleLimit,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_CONFIGURE_LIMIT = #{record.beforeFastConfigureLimit,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_SETTLE_RATIO = #{record.beforeFastSettleRatio,jdbcType=DECIMAL}");
        SET("BEFOREFAST_SETTLE_WORKDAY_FEE = #{record.beforeFastSettleWorkdayFee,jdbcType=DECIMAL}");
        SET("BEFOREFAST_SETTLE_HOLIDAY_FEE = #{record.beforeFastSettleHolidayFee,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_MIN_LIMIT = #{record.fastSettleMinLimit,jdbcType=DECIMAL}");
        SET("BEFORE_FAST_SETTLE_MIN_LIMIT = #{record.beforeFastSettleMinLimit,jdbcType=DECIMAL}");
        SET("AUTO_FAST_SETTLE = #{record.autoFastSettle,jdbcType=DECIMAL}");
        SET("BEFORE_AUTO_FAST_SETTLE = #{record.beforeAutoFastSettle,jdbcType=DECIMAL}");
        SET("OPERATOR = #{record.operator,jdbcType=VARCHAR}");
        SET("PROMOTER_MIN_MARGIN = #{record.promoterMinMargin,jdbcType=DECIMAL}");
        
        FsConfigChangeDOExample example = (FsConfigChangeDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    public String updateByPrimaryKeySelective(FsConfigChangeDO record) {
        BEGIN();
        UPDATE("TB_FS_CONFIG_CHANGE");
        
        if (record.getType() != null) {
            SET("TYPE = #{type,jdbcType=DECIMAL}");
        }
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getOpType() != null) {
            SET("OP_TYPE = #{opType,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("VERSION = #{version,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMargin() != null) {
            SET("FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastConfigureLimit() != null) {
            SET("FAST_CONFIGURE_LIMIT = #{fastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleRatio() != null) {
            SET("FAST_SETTLE_RATIO = #{fastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleWorkdayFee() != null) {
            SET("FAST_SETTLE_WORKDAY_FEE = #{fastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleHolidayFee() != null) {
            SET("FAST_SETTLE_HOLIDAY_FEE = #{fastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleFlag() != null) {
            SET("BEFORE_FAST_SETTLE_FLAG = #{beforeFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMargin() != null) {
            SET("BEFORE_FAST_SETTLE_MARGIN = #{beforeFastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleLimit() != null) {
            SET("BEFORE_FAST_SETTLE_LIMIT = #{beforeFastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastConfigureLimit() != null) {
            SET("BEFORE_FAST_CONFIGURE_LIMIT = #{beforeFastConfigureLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleRatio() != null) {
            SET("BEFORE_FAST_SETTLE_RATIO = #{beforeFastSettleRatio,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleWorkdayFee() != null) {
            SET("BEFOREFAST_SETTLE_WORKDAY_FEE = #{beforeFastSettleWorkdayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleHolidayFee() != null) {
            SET("BEFOREFAST_SETTLE_HOLIDAY_FEE = #{beforeFastSettleHolidayFee,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            SET("FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeFastSettleMinLimit() != null) {
            SET("BEFORE_FAST_SETTLE_MIN_LIMIT = #{beforeFastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettle() != null) {
            SET("AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getBeforeAutoFastSettle() != null) {
            SET("BEFORE_AUTO_FAST_SETTLE = #{beforeAutoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getOperator() != null) {
            SET("OPERATOR = #{operator,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterMinMargin() != null) {
            SET("PROMOTER_MIN_MARGIN = #{promoterMinMargin,jdbcType=DECIMAL}");
        }
        
        WHERE("FCM_ID = #{fcmId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_FS_CONFIG_CHANGE
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    protected void applyWhere(FsConfigChangeDOExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() == 0) {
            sb.append(" (1=1) ");
        }
        
        if (example.getFcmId() != null) {
            sb.append(" and  FCM_ID = #{fcmId,jdbcType=DECIMAL} ");
        }
        
        if (example.getType() != null) {
            sb.append(" and  TYPE = #{type,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjId() != null) {
            sb.append(" and  OBJ_ID = #{objId,jdbcType=DECIMAL} ");
        }
        
        if (example.getOpType() != null) {
            sb.append(" and  OP_TYPE = #{opType,jdbcType=DECIMAL} ");
        }
        
        if (example.getVersion() != null) {
            sb.append(" and  VERSION = #{version,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleFlag() != null) {
            sb.append(" and  FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleMargin() != null) {
            sb.append(" and  FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleLimit() != null) {
            sb.append(" and  FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastConfigureLimit() != null) {
            sb.append(" and  FAST_CONFIGURE_LIMIT = #{fastConfigureLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleRatio() != null) {
            sb.append(" and  FAST_SETTLE_RATIO = #{fastSettleRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleWorkdayFee() != null) {
            sb.append(" and  FAST_SETTLE_WORKDAY_FEE = #{fastSettleWorkdayFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleHolidayFee() != null) {
            sb.append(" and  FAST_SETTLE_HOLIDAY_FEE = #{fastSettleHolidayFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleFlag() != null) {
            sb.append(" and  BEFORE_FAST_SETTLE_FLAG = #{beforeFastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleMargin() != null) {
            sb.append(" and  BEFORE_FAST_SETTLE_MARGIN = #{beforeFastSettleMargin,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleLimit() != null) {
            sb.append(" and  BEFORE_FAST_SETTLE_LIMIT = #{beforeFastSettleLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastConfigureLimit() != null) {
            sb.append(" and  BEFORE_FAST_CONFIGURE_LIMIT = #{beforeFastConfigureLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleRatio() != null) {
            sb.append(" and  BEFORE_FAST_SETTLE_RATIO = #{beforeFastSettleRatio,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleWorkdayFee() != null) {
            sb.append(" and  BEFOREFAST_SETTLE_WORKDAY_FEE = #{beforeFastSettleWorkdayFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleHolidayFee() != null) {
            sb.append(" and  BEFOREFAST_SETTLE_HOLIDAY_FEE = #{beforeFastSettleHolidayFee,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getLoaningType() != null) {
            sb.append(" and  LOANING_TYPE = #{loaningType,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleMinLimit() != null) {
            sb.append(" and  FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeFastSettleMinLimit() != null) {
            sb.append(" and  BEFORE_FAST_SETTLE_MIN_LIMIT = #{beforeFastSettleMinLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getAutoFastSettle() != null) {
            sb.append(" and  AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL} ");
        }
        
        if (example.getBeforeAutoFastSettle() != null) {
            sb.append(" and  BEFORE_AUTO_FAST_SETTLE = #{beforeAutoFastSettle,jdbcType=DECIMAL} ");
        }
        
        if (example.getOperator() != null && !example.getOperator().equals("") ) {
            sb.append(" and  OPERATOR = #{operator,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterMinMargin() != null) {
            sb.append(" and  PROMOTER_MIN_MARGIN = #{promoterMinMargin,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}