package com.sdp.mc.view.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;

import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample.Criteria;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample.Criterion;

public class ViewPromoterInfoSqlProvider {

    /**
     * 根据Example对象取得null【ViewPromoterInfoDTO】对象count信息
     *
     * @mbggenerated Tue Jun 07 10:24:13 CST 2016
     */
    public String countByExample(ViewPromoterInfoDTOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("VIEW_PROMOTER_INFO");
        applyWhere(example, false);
        return SQL();
    }

   

    /**
     * 根据Example对象查询得到null【ViewPromoterInfoDTO】对象列表信息
     *
     * @mbggenerated Tue Jun 07 10:24:13 CST 2016
     */
    public String selectByExample(ViewPromoterInfoDTOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PROMOTER_ID");
        } else {
            SELECT("PROMOTER_ID");
        }
        SELECT("PROMOTER_MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("PROMOTER_TYPE");
        SELECT("PROMOTER_FS_FLAG");
        SELECT("PROMOTER_FS_LIMIT");
        SELECT("PROMOTER_FS_MARGIN");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("LOANING_TYPE");
        SELECT("PROMOTER_BIZ_ID");
        FROM("VIEW_PROMOTER_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询null【ViewPromoterInfoDTO】对象列表信息
     *
     * @mbggenerated Tue Jun 07 10:24:13 CST 2016
     */
    public String selectByQuery(ViewPromoterInfoDTOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("PROMOTER_ID");
        } else {
            SELECT("PROMOTER_ID");
        }
        SELECT("PROMOTER_MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("PROMOTER_TYPE");
        SELECT("PROMOTER_FS_FLAG");
        SELECT("PROMOTER_FS_LIMIT");
        SELECT("PROMOTER_FS_MARGIN");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("LOANING_TYPE");
        SELECT("PROMOTER_BIZ_ID");
        FROM("VIEW_PROMOTER_INFO");
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
     * This method corresponds to the database table VIEW_PROMOTER_INFO
     *
     * @mbggenerated Tue Jun 07 10:24:13 CST 2016
     */
    protected void applyWhere(ViewPromoterInfoDTOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterMerchantNo() != null && !example.getPromoterMerchantNo().equals("") ) {
            sb.append(" and  PROMOTER_MERCHANT_NO = #{promoterMerchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterName() != null && !example.getPromoterName().equals("") ) {
            sb.append(" and  PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterType() != null && !example.getPromoterType().equals("") ) {
            sb.append(" and  PROMOTER_TYPE = #{promoterType,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterFsFlag() != null) {
            sb.append(" and  PROMOTER_FS_FLAG = #{promoterFsFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterFsLimit() != null) {
            sb.append(" and  PROMOTER_FS_LIMIT = #{promoterFsLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterFsMargin() != null) {
            sb.append(" and  PROMOTER_FS_MARGIN = #{promoterFsMargin,jdbcType=DECIMAL} ");
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
        
        if (example.getPromoterBizId() != null) {
            sb.append(" and  PROMOTER_BIZ_ID = #{promoterBizId,jdbcType=DECIMAL} ");
        }
        WHERE(sb.toString());
    }
}