package com.sdp.mc.config.dao.mapper;

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

import com.sdp.mc.config.dao.ConfigOptionDO;
import com.sdp.mc.config.dao.ConfigOptionDOExample.Criteria;
import com.sdp.mc.config.dao.ConfigOptionDOExample.Criterion;
import com.sdp.mc.config.dao.ConfigOptionDOExample;
import java.util.List;
import java.util.Map;

public class ConfigOptionSqlProvider {

    /**
     * 根据Example对象取得null【ConfigOptionDO】对象count信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String countByExample(ConfigOptionDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("TB_CONFIG_OPTION");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String deleteByExample(ConfigOptionDOExample example) {
        BEGIN();
        DELETE_FROM("TB_CONFIG_OPTION");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加null【ConfigOptionDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String insertSelective(ConfigOptionDO record) {
        BEGIN();
        INSERT_INTO("TB_CONFIG_OPTION");
        
        VALUES("OPTION_ID", "#{optionId,jdbcType=DECIMAL}");
        
        if (record.getOptionKey() != null) {
            VALUES("OPTION_KEY", "#{optionKey,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionValue() != null) {
            VALUES("OPTION_VALUE", "#{optionValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDefValue() != null) {
            VALUES("OPTION_DEF_VALUE", "#{optionDefValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDesc() != null) {
            VALUES("OPTION_DESC", "#{optionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String selectByExample(ConfigOptionDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("OPTION_ID");
        } else {
            SELECT("OPTION_ID");
        }
        SELECT("OPTION_KEY");
        SELECT("OPTION_VALUE");
        SELECT("OPTION_DEF_VALUE");
        SELECT("OPTION_DESC");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("TB_CONFIG_OPTION");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询null【ConfigOptionDO】对象列表信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String selectByQuery(ConfigOptionDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("OPTION_ID");
        } else {
            SELECT("OPTION_ID");
        }
        SELECT("OPTION_KEY");
        SELECT("OPTION_VALUE");
        SELECT("OPTION_DEF_VALUE");
        SELECT("OPTION_DESC");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("TB_CONFIG_OPTION");
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
     * 根据Example对象更新null【ConfigOptionDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ConfigOptionDO record = (ConfigOptionDO) parameter.get("record");
        ConfigOptionDOExample example = (ConfigOptionDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("TB_CONFIG_OPTION");
        
        if (record.getOptionId() != null) {
            SET("OPTION_ID = #{record.optionId,jdbcType=DECIMAL}");
        }
        
        if (record.getOptionKey() != null) {
            SET("OPTION_KEY = #{record.optionKey,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionValue() != null) {
            SET("OPTION_VALUE = #{record.optionValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDefValue() != null) {
            SET("OPTION_DEF_VALUE = #{record.optionDefValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDesc() != null) {
            SET("OPTION_DESC = #{record.optionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新null【ConfigOptionDO】对象信息
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("TB_CONFIG_OPTION");
        
        SET("OPTION_ID = #{record.optionId,jdbcType=DECIMAL}");
        SET("OPTION_KEY = #{record.optionKey,jdbcType=VARCHAR}");
        SET("OPTION_VALUE = #{record.optionValue,jdbcType=VARCHAR}");
        SET("OPTION_DEF_VALUE = #{record.optionDefValue,jdbcType=VARCHAR}");
        SET("OPTION_DESC = #{record.optionDesc,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        ConfigOptionDOExample example = (ConfigOptionDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新null【ConfigOptionDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    public String updateByPrimaryKeySelective(ConfigOptionDO record) {
        BEGIN();
        UPDATE("TB_CONFIG_OPTION");
        
        if (record.getOptionKey() != null) {
            SET("OPTION_KEY = #{optionKey,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionValue() != null) {
            SET("OPTION_VALUE = #{optionValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDefValue() != null) {
            SET("OPTION_DEF_VALUE = #{optionDefValue,jdbcType=VARCHAR}");
        }
        
        if (record.getOptionDesc() != null) {
            SET("OPTION_DESC = #{optionDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("OPTION_ID = #{optionId,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table TB_CONFIG_OPTION
     *
     * @mbggenerated Fri Mar 27 12:41:28 CST 2015
     */
    protected void applyWhere(ConfigOptionDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getOptionId() != null) {
            sb.append(" and  OPTION_ID = #{optionId,jdbcType=DECIMAL} ");
        }
        
        if (example.getOptionKey() != null && !example.getOptionKey().equals("") ) {
            sb.append(" and  OPTION_KEY = #{optionKey,jdbcType=VARCHAR} ");
        }
        
        if (example.getOptionValue() != null && !example.getOptionValue().equals("") ) {
            sb.append(" and  OPTION_VALUE = #{optionValue,jdbcType=VARCHAR} ");
        }
        
        if (example.getOptionDefValue() != null && !example.getOptionDefValue().equals("") ) {
            sb.append(" and  OPTION_DEF_VALUE = #{optionDefValue,jdbcType=VARCHAR} ");
        }
        
        if (example.getOptionDesc() != null && !example.getOptionDesc().equals("") ) {
            sb.append(" and  OPTION_DESC = #{optionDesc,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        WHERE(sb.toString());
    }
}