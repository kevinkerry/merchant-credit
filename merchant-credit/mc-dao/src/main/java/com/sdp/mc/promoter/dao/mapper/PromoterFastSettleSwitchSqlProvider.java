package com.sdp.mc.promoter.dao.mapper;

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

import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDO;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample.Criteria;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample.Criterion;
import com.sdp.mc.promoter.dao.PromoterFastSettleSwitchDOExample;
import java.util.List;
import java.util.Map;

public class PromoterFastSettleSwitchSqlProvider {

    /**
     * 根据Example对象取得代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象count信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String countByExample(PromoterFastSettleSwitchDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_PROMOTER_FS_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String deleteByExample(PromoterFastSettleSwitchDOExample example) {
        BEGIN();
        DELETE_FROM("TB_PROMOTER_FS_REQ");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String insertSelective(PromoterFastSettleSwitchDO record) {
        BEGIN();
        INSERT_INTO("TB_PROMOTER_FS_REQ");
        
        VALUES("PFR_ID", "#{pfrId,jdbcType=DECIMAL}");
        
        if (record.getPromoterId() != null) {
            VALUES("PROMOTER_ID", "#{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            VALUES("TYPE", "#{type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getMarginAccount() != null) {
            VALUES("MARGIN_ACCOUNT", "#{marginAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMaqId() != null) {
            VALUES("MAQ_ID", "#{maqId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmId() != null) {
            VALUES("FCM_ID", "#{fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMarginMemberId() != null) {
            VALUES("MARGIN_MEMBER_ID", "#{marginMemberId,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String selectByExample(PromoterFastSettleSwitchDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PFR_ID");
        } else {
            SELECT("PFR_ID");
        }
        SELECT("PROMOTER_ID");
        SELECT("TYPE");
        SELECT("STATUS");
        SELECT("MARGIN_ACCOUNT");
        SELECT("MAQ_ID");
        SELECT("FCM_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MARGIN_MEMBER_ID");
        FROM("TB_PROMOTER_FS_REQ");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象列表信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String selectByQuery(PromoterFastSettleSwitchDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PFR_ID");
        } else {
            SELECT("PFR_ID");
        }
        SELECT("PROMOTER_ID");
        SELECT("TYPE");
        SELECT("STATUS");
        SELECT("MARGIN_ACCOUNT");
        SELECT("MAQ_ID");
        SELECT("FCM_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MARGIN_MEMBER_ID");
        FROM("TB_PROMOTER_FS_REQ");
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
     * 根据Example对象更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PromoterFastSettleSwitchDO record = (PromoterFastSettleSwitchDO) parameter.get("record");
        PromoterFastSettleSwitchDOExample example = (PromoterFastSettleSwitchDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_PROMOTER_FS_REQ");
        
        if (record.getPfrId() != null) {
            SET("PFR_ID = #{record.pfrId,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getMarginAccount() != null) {
            SET("MARGIN_ACCOUNT = #{record.marginAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMaqId() != null) {
            SET("MAQ_ID = #{record.maqId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmId() != null) {
            SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMarginMemberId() != null) {
            SET("MARGIN_MEMBER_ID = #{record.marginMemberId,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_PROMOTER_FS_REQ");
        
        SET("PFR_ID = #{record.pfrId,jdbcType=DECIMAL}");
        SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        SET("TYPE = #{record.type,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("MARGIN_ACCOUNT = #{record.marginAccount,jdbcType=VARCHAR}");
        SET("MAQ_ID = #{record.maqId,jdbcType=DECIMAL}");
        SET("FCM_ID = #{record.fcmId,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("MARGIN_MEMBER_ID = #{record.marginMemberId,jdbcType=VARCHAR}");
        
        PromoterFastSettleSwitchDOExample example = (PromoterFastSettleSwitchDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新代理商快速结算 开通/关闭【PromoterFastSettleSwitchDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    public String updateByPrimaryKeySelective(PromoterFastSettleSwitchDO record) {
        BEGIN();
        UPDATE("TB_PROMOTER_FS_REQ");
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getType() != null) {
            SET("TYPE = #{type,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getMarginAccount() != null) {
            SET("MARGIN_ACCOUNT = #{marginAccount,jdbcType=VARCHAR}");
        }
        
        if (record.getMaqId() != null) {
            SET("MAQ_ID = #{maqId,jdbcType=DECIMAL}");
        }
        
        if (record.getFcmId() != null) {
            SET("FCM_ID = #{fcmId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMarginMemberId() != null) {
            SET("MARGIN_MEMBER_ID = #{marginMemberId,jdbcType=VARCHAR}");
        }
        
        WHERE("PFR_ID = #{pfrId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_PROMOTER_FS_REQ
     *
     * @mbggenerated Tue Mar 31 17:37:57 CST 2015
     */
    protected void applyWhere(PromoterFastSettleSwitchDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPfrId() != null) {
            sb.append(" and  PFR_ID = #{pfrId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getType() != null) {
            sb.append(" and  TYPE = #{type,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getMarginAccount() != null && !example.getMarginAccount().equals("") ) {
            sb.append(" and  MARGIN_ACCOUNT = #{marginAccount,jdbcType=VARCHAR} ");
        }
        
        if (example.getMaqId() != null) {
            sb.append(" and  MAQ_ID = #{maqId,jdbcType=DECIMAL} ");
        }
        
        if (example.getFcmId() != null) {
            sb.append(" and  FCM_ID = #{fcmId,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMarginMemberId() != null && !example.getMarginMemberId().equals("") ) {
            sb.append(" and  MARGIN_MEMBER_ID = #{marginMemberId,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}