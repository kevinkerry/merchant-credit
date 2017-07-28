package com.sdp.withdraw.dao.mapper;

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

import com.sdp.withdraw.dao.WithdrawSplittingDO;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample.Criteria;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample.Criterion;
import com.sdp.withdraw.dao.WithdrawSplittingDOExample;
import java.util.List;
import java.util.Map;

public class WithdrawSplittingSqlProvider {

    /**
     * 根据Example对象取得出款分润表【WithdrawSplittingDO】对象count信息
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public String countByExample(WithdrawSplittingDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_WITHDRAW_SPLITTING");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String deleteByExample(WithdrawSplittingDOExample example) {
        BEGIN();
        DELETE_FROM("FW_WITHDRAW_SPLITTING");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加出款分润表【WithdrawSplittingDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String insertSelective(WithdrawSplittingDO record) {
        BEGIN();
        INSERT_INTO("FW_WITHDRAW_SPLITTING");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getReqId() != null) {
            VALUES("REQ_ID", "#{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCost() != null) {
            VALUES("BASE_COST", "#{baseCost,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostSplittingScale() != null) {
            VALUES("BASE_COST_SPLITTING_SCALE", "#{baseCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostShengpaySplitting() != null) {
            VALUES("BASE_COST_SHENGPAY_SPLITTING", "#{baseCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostPromoterSplitting() != null) {
            VALUES("BASE_COST_PROMOTER_SPLITTING", "#{baseCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            VALUES("WD_COST", "#{wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostSplittingScale() != null) {
            VALUES("WD_COST_SPLITTING_SCALE", "#{wdCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostShengpaySplitting() != null) {
            VALUES("WD_COST_SHENGPAY_SPLITTING", "#{wdCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostPromoterSplitting() != null) {
            VALUES("WD_COST_PROMOTER_SPLITTING", "#{wdCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCost() != null) {
            VALUES("PLATFORM_COST", "#{platformCost,jdbcType=DECIMAL}");
        }
        
        if (record.getShengpayTotalCost() != null) {
            VALUES("SHENGPAY_TOTAL_COST", "#{shengpayTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterTotalCost() != null) {
            VALUES("PROMOTER_TOTAL_COST", "#{promoterTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDaySettleAward() != null) {
            VALUES("DAY_SETTLE_AWARD", "#{daySettleAward,jdbcType=DECIMAL}");
        }
        
        if (record.getMonthActiveAward() != null) {
            VALUES("MONTH_ACTIVE_AWARD", "#{monthActiveAward,jdbcType=DECIMAL}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到出款分润表【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String selectByExample(WithdrawSplittingDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("REQ_ID");
        SELECT("BASE_COST");
        SELECT("BASE_COST_SPLITTING_SCALE");
        SELECT("BASE_COST_SHENGPAY_SPLITTING");
        SELECT("BASE_COST_PROMOTER_SPLITTING");
        SELECT("WD_COST");
        SELECT("WD_COST_SPLITTING_SCALE");
        SELECT("WD_COST_SHENGPAY_SPLITTING");
        SELECT("WD_COST_PROMOTER_SPLITTING");
        SELECT("PLATFORM_COST");
        SELECT("SHENGPAY_TOTAL_COST");
        SELECT("PROMOTER_TOTAL_COST");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("DAY_SETTLE_AWARD");
        SELECT("MONTH_ACTIVE_AWARD");
        FROM("FW_WITHDRAW_SPLITTING");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询出款分润表【WithdrawSplittingDO】对象列表信息
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String selectByQuery(WithdrawSplittingDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("REQ_ID");
        SELECT("BASE_COST");
        SELECT("BASE_COST_SPLITTING_SCALE");
        SELECT("BASE_COST_SHENGPAY_SPLITTING");
        SELECT("BASE_COST_PROMOTER_SPLITTING");
        SELECT("WD_COST");
        SELECT("WD_COST_SPLITTING_SCALE");
        SELECT("WD_COST_SHENGPAY_SPLITTING");
        SELECT("WD_COST_PROMOTER_SPLITTING");
        SELECT("PLATFORM_COST");
        SELECT("SHENGPAY_TOTAL_COST");
        SELECT("PROMOTER_TOTAL_COST");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("DAY_SETTLE_AWARD");
        SELECT("MONTH_ACTIVE_AWARD");
        FROM("FW_WITHDRAW_SPLITTING");
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
     * 根据Example对象更新出款分润表【WithdrawSplittingDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        WithdrawSplittingDO record = (WithdrawSplittingDO) parameter.get("record");
        WithdrawSplittingDOExample example = (WithdrawSplittingDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_WITHDRAW_SPLITTING");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCost() != null) {
            SET("BASE_COST = #{record.baseCost,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostSplittingScale() != null) {
            SET("BASE_COST_SPLITTING_SCALE = #{record.baseCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostShengpaySplitting() != null) {
            SET("BASE_COST_SHENGPAY_SPLITTING = #{record.baseCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostPromoterSplitting() != null) {
            SET("BASE_COST_PROMOTER_SPLITTING = #{record.baseCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            SET("WD_COST = #{record.wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostSplittingScale() != null) {
            SET("WD_COST_SPLITTING_SCALE = #{record.wdCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostShengpaySplitting() != null) {
            SET("WD_COST_SHENGPAY_SPLITTING = #{record.wdCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostPromoterSplitting() != null) {
            SET("WD_COST_PROMOTER_SPLITTING = #{record.wdCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCost() != null) {
            SET("PLATFORM_COST = #{record.platformCost,jdbcType=DECIMAL}");
        }
        
        if (record.getShengpayTotalCost() != null) {
            SET("SHENGPAY_TOTAL_COST = #{record.shengpayTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterTotalCost() != null) {
            SET("PROMOTER_TOTAL_COST = #{record.promoterTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDaySettleAward() != null) {
            SET("DAY_SETTLE_AWARD = #{record.daySettleAward,jdbcType=DECIMAL}");
        }
        
        if (record.getMonthActiveAward() != null) {
            SET("MONTH_ACTIVE_AWARD = #{record.monthActiveAward,jdbcType=DECIMAL}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新出款分润表【WithdrawSplittingDO】对象信息
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_WITHDRAW_SPLITTING");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("REQ_ID = #{record.reqId,jdbcType=DECIMAL}");
        SET("BASE_COST = #{record.baseCost,jdbcType=DECIMAL}");
        SET("BASE_COST_SPLITTING_SCALE = #{record.baseCostSplittingScale,jdbcType=DECIMAL}");
        SET("BASE_COST_SHENGPAY_SPLITTING = #{record.baseCostShengpaySplitting,jdbcType=DECIMAL}");
        SET("BASE_COST_PROMOTER_SPLITTING = #{record.baseCostPromoterSplitting,jdbcType=DECIMAL}");
        SET("WD_COST = #{record.wdCost,jdbcType=DECIMAL}");
        SET("WD_COST_SPLITTING_SCALE = #{record.wdCostSplittingScale,jdbcType=DECIMAL}");
        SET("WD_COST_SHENGPAY_SPLITTING = #{record.wdCostShengpaySplitting,jdbcType=DECIMAL}");
        SET("WD_COST_PROMOTER_SPLITTING = #{record.wdCostPromoterSplitting,jdbcType=DECIMAL}");
        SET("PLATFORM_COST = #{record.platformCost,jdbcType=DECIMAL}");
        SET("SHENGPAY_TOTAL_COST = #{record.shengpayTotalCost,jdbcType=DECIMAL}");
        SET("PROMOTER_TOTAL_COST = #{record.promoterTotalCost,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("DAY_SETTLE_AWARD = #{record.daySettleAward,jdbcType=DECIMAL}");
        SET("MONTH_ACTIVE_AWARD = #{record.monthActiveAward,jdbcType=DECIMAL}");
        
        WithdrawSplittingDOExample example = (WithdrawSplittingDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新出款分润表【WithdrawSplittingDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    public String updateByPrimaryKeySelective(WithdrawSplittingDO record) {
        BEGIN();
        UPDATE("FW_WITHDRAW_SPLITTING");
        
        if (record.getReqId() != null) {
            SET("REQ_ID = #{reqId,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCost() != null) {
            SET("BASE_COST = #{baseCost,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostSplittingScale() != null) {
            SET("BASE_COST_SPLITTING_SCALE = #{baseCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostShengpaySplitting() != null) {
            SET("BASE_COST_SHENGPAY_SPLITTING = #{baseCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getBaseCostPromoterSplitting() != null) {
            SET("BASE_COST_PROMOTER_SPLITTING = #{baseCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCost() != null) {
            SET("WD_COST = #{wdCost,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostSplittingScale() != null) {
            SET("WD_COST_SPLITTING_SCALE = #{wdCostSplittingScale,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostShengpaySplitting() != null) {
            SET("WD_COST_SHENGPAY_SPLITTING = #{wdCostShengpaySplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getWdCostPromoterSplitting() != null) {
            SET("WD_COST_PROMOTER_SPLITTING = #{wdCostPromoterSplitting,jdbcType=DECIMAL}");
        }
        
        if (record.getPlatformCost() != null) {
            SET("PLATFORM_COST = #{platformCost,jdbcType=DECIMAL}");
        }
        
        if (record.getShengpayTotalCost() != null) {
            SET("SHENGPAY_TOTAL_COST = #{shengpayTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterTotalCost() != null) {
            SET("PROMOTER_TOTAL_COST = #{promoterTotalCost,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDaySettleAward() != null) {
            SET("DAY_SETTLE_AWARD = #{daySettleAward,jdbcType=DECIMAL}");
        }
        
        if (record.getMonthActiveAward() != null) {
            SET("MONTH_ACTIVE_AWARD = #{monthActiveAward,jdbcType=DECIMAL}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_WITHDRAW_SPLITTING
     *
     * @mbggenerated Mon Jul 18 13:16:36 CST 2016
     */
    protected void applyWhere(WithdrawSplittingDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getId() != null) {
            sb.append(" and  ID = #{id,jdbcType=DECIMAL} ");
        }
        
        if (example.getReqId() != null) {
            sb.append(" and  REQ_ID = #{reqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getBaseCost() != null) {
            sb.append(" and  BASE_COST = #{baseCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getBaseCostSplittingScale() != null) {
            sb.append(" and  BASE_COST_SPLITTING_SCALE = #{baseCostSplittingScale,jdbcType=DECIMAL} ");
        }
        
        if (example.getBaseCostShengpaySplitting() != null) {
            sb.append(" and  BASE_COST_SHENGPAY_SPLITTING = #{baseCostShengpaySplitting,jdbcType=DECIMAL} ");
        }
        
        if (example.getBaseCostPromoterSplitting() != null) {
            sb.append(" and  BASE_COST_PROMOTER_SPLITTING = #{baseCostPromoterSplitting,jdbcType=DECIMAL} ");
        }
        
        if (example.getWdCost() != null) {
            sb.append(" and  WD_COST = #{wdCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getWdCostSplittingScale() != null) {
            sb.append(" and  WD_COST_SPLITTING_SCALE = #{wdCostSplittingScale,jdbcType=DECIMAL} ");
        }
        
        if (example.getWdCostShengpaySplitting() != null) {
            sb.append(" and  WD_COST_SHENGPAY_SPLITTING = #{wdCostShengpaySplitting,jdbcType=DECIMAL} ");
        }
        
        if (example.getWdCostPromoterSplitting() != null) {
            sb.append(" and  WD_COST_PROMOTER_SPLITTING = #{wdCostPromoterSplitting,jdbcType=DECIMAL} ");
        }
        
        if (example.getPlatformCost() != null) {
            sb.append(" and  PLATFORM_COST = #{platformCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getShengpayTotalCost() != null) {
            sb.append(" and  SHENGPAY_TOTAL_COST = #{shengpayTotalCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterTotalCost() != null) {
            sb.append(" and  PROMOTER_TOTAL_COST = #{promoterTotalCost,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getDaySettleAward() != null) {
            sb.append(" and  DAY_SETTLE_AWARD = #{daySettleAward,jdbcType=DECIMAL} ");
        }
        
        if (example.getMonthActiveAward() != null) {
            sb.append(" and  MONTH_ACTIVE_AWARD = #{monthActiveAward,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}