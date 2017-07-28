package com.sdp.mc.ffconfig.dao.mapper;

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

import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample.Criteria;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample.Criterion;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
import java.util.List;
import java.util.Map;

public class FastSettleConfigSqlProvider {

    /**
     * 根据Example对象取得null【FastSettleConfigDO】对象count信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String countByExample(FastSettleConfigDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_FAST_SETTLE_CONFIG");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String deleteByExample(FastSettleConfigDOExample example) {
        BEGIN();
        DELETE_FROM("TB_FAST_SETTLE_CONFIG");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加null【FastSettleConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String insertSelective(FastSettleConfigDO record) {
        BEGIN();
        INSERT_INTO("TB_FAST_SETTLE_CONFIG");
        
        VALUES("PFC_ID", "#{pfcId,jdbcType=DECIMAL}");
        
        if (record.getObjId() != null) {
            VALUES("OBJ_ID", "#{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            VALUES("OBJ_TYPE", "#{objType,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoFastSettle() != null) {
            VALUES("AUTO_FAST_SETTLE", "#{autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantPhone() != null) {
            VALUES("MERCHANT_PHONE", "#{merchantPhone,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到null【FastSettleConfigDO】对象列表信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String selectByExample(FastSettleConfigDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PFC_ID");
        } else {
            SELECT("PFC_ID");
        }
        SELECT("OBJ_ID");
        SELECT("OBJ_TYPE");
        SELECT("AUTO_FAST_SETTLE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MERCHANT_PHONE");
        FROM("TB_FAST_SETTLE_CONFIG");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询null【FastSettleConfigDO】对象列表信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String selectByQuery(FastSettleConfigDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PFC_ID");
        } else {
            SELECT("PFC_ID");
        }
        SELECT("OBJ_ID");
        SELECT("OBJ_TYPE");
        SELECT("AUTO_FAST_SETTLE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("MERCHANT_PHONE");
        FROM("TB_FAST_SETTLE_CONFIG");
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
     * 根据Example对象更新null【FastSettleConfigDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        FastSettleConfigDO record = (FastSettleConfigDO) parameter.get("record");
        FastSettleConfigDOExample example = (FastSettleConfigDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_FAST_SETTLE_CONFIG");
        
        if (record.getPfcId() != null) {
            SET("PFC_ID = #{record.pfcId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            SET("OBJ_TYPE = #{record.objType,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoFastSettle() != null) {
            SET("AUTO_FAST_SETTLE = #{record.autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantPhone() != null) {
            SET("MERCHANT_PHONE = #{record.merchantPhone,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新null【FastSettleConfigDO】对象信息
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_FAST_SETTLE_CONFIG");
        
        SET("PFC_ID = #{record.pfcId,jdbcType=DECIMAL}");
        SET("OBJ_ID = #{record.objId,jdbcType=DECIMAL}");
        SET("OBJ_TYPE = #{record.objType,jdbcType=VARCHAR}");
        SET("AUTO_FAST_SETTLE = #{record.autoFastSettle,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("MERCHANT_PHONE = #{record.merchantPhone,jdbcType=VARCHAR}");
        
        FastSettleConfigDOExample example = (FastSettleConfigDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新null【FastSettleConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    public String updateByPrimaryKeySelective(FastSettleConfigDO record) {
        BEGIN();
        UPDATE("TB_FAST_SETTLE_CONFIG");
        
        if (record.getObjId() != null) {
            SET("OBJ_ID = #{objId,jdbcType=DECIMAL}");
        }
        
        if (record.getObjType() != null) {
            SET("OBJ_TYPE = #{objType,jdbcType=VARCHAR}");
        }
        
        if (record.getAutoFastSettle() != null) {
            SET("AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantPhone() != null) {
            SET("MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR}");
        }
        
        WHERE("PFC_ID = #{pfcId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_FAST_SETTLE_CONFIG
     *
     * @mbggenerated Fri Sep 18 14:49:52 CST 2015
     */
    protected void applyWhere(FastSettleConfigDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPfcId() != null) {
            sb.append(" and  PFC_ID = #{pfcId,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjId() != null) {
            sb.append(" and  OBJ_ID = #{objId,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjType() != null) {
            sb.append(" and  OBJ_TYPE = #{objType,jdbcType=VARCHAR} ");
        }
        
        if (example.getAutoFastSettle() != null) {
            sb.append(" and  AUTO_FAST_SETTLE = #{autoFastSettle,jdbcType=DECIMAL} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMerchantPhone() != null && !example.getMerchantPhone().equals("") ) {
            sb.append(" and  MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}