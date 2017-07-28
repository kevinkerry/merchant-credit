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

import com.sdp.withdraw.dao.MerchantSettleAttrDO;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample.Criteria;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample.Criterion;
import com.sdp.withdraw.dao.MerchantSettleAttrDOExample;
import java.util.List;
import java.util.Map;

public class MerchantSettleAttrSqlProvider {

    /**
     * 根据Example对象取得业务首次开通时间配置信息【MerchantSettleAttrDO】对象count信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String countByExample(MerchantSettleAttrDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_MERCHANT_SETTLE_ATTR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String deleteByExample(MerchantSettleAttrDOExample example) {
        BEGIN();
        DELETE_FROM("FW_MERCHANT_SETTLE_ATTR");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String insertSelective(MerchantSettleAttrDO record) {
        BEGIN();
        INSERT_INTO("FW_MERCHANT_SETTLE_ATTR");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getBizType() != null) {
            VALUES("BIZ_TYPE", "#{bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getFirstOpenTime() != null) {
            VALUES("FIRST_OPEN_TIME", "#{firstOpenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantType() != null) {
            VALUES("MERCHANT_TYPE", "#{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBizId() != null) {
            VALUES("BIZ_ID", "#{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getExt1() != null) {
            VALUES("EXT1", "#{ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            VALUES("EXT2", "#{ext2,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String selectByExample(MerchantSettleAttrDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_TYPE");
        SELECT("FIRST_OPEN_TIME");
        SELECT("MERCHANT_NO");
        SELECT("MERCHANT_TYPE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("BIZ_ID");
        SELECT("EXT1");
        SELECT("EXT2");
        FROM("FW_MERCHANT_SETTLE_ATTR");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询业务首次开通时间配置信息【MerchantSettleAttrDO】对象列表信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String selectByQuery(MerchantSettleAttrDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("BIZ_TYPE");
        SELECT("FIRST_OPEN_TIME");
        SELECT("MERCHANT_NO");
        SELECT("MERCHANT_TYPE");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("BIZ_ID");
        SELECT("EXT1");
        SELECT("EXT2");
        FROM("FW_MERCHANT_SETTLE_ATTR");
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
     * 根据Example对象更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        MerchantSettleAttrDO record = (MerchantSettleAttrDO) parameter.get("record");
        MerchantSettleAttrDOExample example = (MerchantSettleAttrDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_MERCHANT_SETTLE_ATTR");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getBizType() != null) {
            SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getFirstOpenTime() != null) {
            SET("FIRST_OPEN_TIME = #{record.firstOpenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getExt1() != null) {
            SET("EXT1 = #{record.ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            SET("EXT2 = #{record.ext2,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_MERCHANT_SETTLE_ATTR");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("BIZ_TYPE = #{record.bizType,jdbcType=DECIMAL}");
        SET("FIRST_OPEN_TIME = #{record.firstOpenTime,jdbcType=TIMESTAMP}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        SET("EXT1 = #{record.ext1,jdbcType=VARCHAR}");
        SET("EXT2 = #{record.ext2,jdbcType=VARCHAR}");
        
        MerchantSettleAttrDOExample example = (MerchantSettleAttrDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新业务首次开通时间配置信息【MerchantSettleAttrDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    public String updateByPrimaryKeySelective(MerchantSettleAttrDO record) {
        BEGIN();
        UPDATE("FW_MERCHANT_SETTLE_ATTR");
        
        if (record.getBizType() != null) {
            SET("BIZ_TYPE = #{bizType,jdbcType=DECIMAL}");
        }
        
        if (record.getFirstOpenTime() != null) {
            SET("FIRST_OPEN_TIME = #{firstOpenTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getExt1() != null) {
            SET("EXT1 = #{ext1,jdbcType=VARCHAR}");
        }
        
        if (record.getExt2() != null) {
            SET("EXT2 = #{ext2,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_MERCHANT_SETTLE_ATTR
     *
     * @mbggenerated Wed Aug 17 13:25:50 CST 2016
     */
    protected void applyWhere(MerchantSettleAttrDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getBizType() != null) {
            sb.append(" and  BIZ_TYPE = #{bizType,jdbcType=DECIMAL} ");
        }
        
        if (example.getFirstOpenTime() != null) {
            sb.append(" and  FIRST_OPEN_TIME = #{firstOpenTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantType() != null && !example.getMerchantType().equals("") ) {
            sb.append(" and  MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getBizId() != null) {
            sb.append(" and  BIZ_ID = #{bizId,jdbcType=DECIMAL} ");
        }
        
        if (example.getExt1() != null && !example.getExt1().equals("") ) {
            sb.append(" and  EXT1 = #{ext1,jdbcType=VARCHAR} ");
        }
        
        if (example.getExt2() != null && !example.getExt2().equals("") ) {
            sb.append(" and  EXT2 = #{ext2,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}