package com.sdp.mc.mcbizaccount.dao.mapper;

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

import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample.Criteria;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample.Criterion;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample;
import java.util.List;
import java.util.Map;

public class BizApplyOpenAccountSqlProvider {

    /**
     * 根据Example对象取得业务层通用开户记录表【BizApplyOpenAccountDO】对象count信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String countByExample(BizApplyOpenAccountDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("MC_APPLY_OPEN_ACCOUNT");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String deleteByExample(BizApplyOpenAccountDOExample example) {
        BEGIN();
        DELETE_FROM("MC_APPLY_OPEN_ACCOUNT");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加业务层通用开户记录表【BizApplyOpenAccountDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String insertSelective(BizApplyOpenAccountDO record) {
        BEGIN();
        INSERT_INTO("MC_APPLY_OPEN_ACCOUNT");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getAccountType() != null) {
            VALUES("ACCOUNT_TYPE", "#{accountType,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterId() != null) {
            VALUES("PROMOTER_ID", "#{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            VALUES("PROMOTER_NAME", "#{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            VALUES("ACCOUNT_ID", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            VALUES("MEMBER_ID", "#{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            VALUES("BIZ_ID", "#{bizId,jdbcType=DECIMAL}");
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
     * 根据Example对象查询得到业务层通用开户记录表【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String selectByExample(BizApplyOpenAccountDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("ACCOUNT_TYPE");
        SELECT("PROMOTER_ID");
        SELECT("MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("ACCOUNT_ID");
        SELECT("MEMBER_ID");
        SELECT("STATUS");
        SELECT("BIZ_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("MC_APPLY_OPEN_ACCOUNT");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询业务层通用开户记录表【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String selectByQuery(BizApplyOpenAccountDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("ACCOUNT_TYPE");
        SELECT("PROMOTER_ID");
        SELECT("MERCHANT_NO");
        SELECT("PROMOTER_NAME");
        SELECT("ACCOUNT_ID");
        SELECT("MEMBER_ID");
        SELECT("STATUS");
        SELECT("BIZ_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("MC_APPLY_OPEN_ACCOUNT");
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
     * 根据Example对象更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        BizApplyOpenAccountDO record = (BizApplyOpenAccountDO) parameter.get("record");
        BizApplyOpenAccountDOExample example = (BizApplyOpenAccountDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("MC_APPLY_OPEN_ACCOUNT");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("ACCOUNT_ID = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
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
     * 根据Example对象更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("MC_APPLY_OPEN_ACCOUNT");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=DECIMAL}");
        SET("PROMOTER_ID = #{record.promoterId,jdbcType=DECIMAL}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("PROMOTER_NAME = #{record.promoterName,jdbcType=VARCHAR}");
        SET("ACCOUNT_ID = #{record.accountId,jdbcType=VARCHAR}");
        SET("MEMBER_ID = #{record.memberId,jdbcType=VARCHAR}");
        SET("STATUS = #{record.status,jdbcType=DECIMAL}");
        SET("BIZ_ID = #{record.bizId,jdbcType=DECIMAL}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        
        BizApplyOpenAccountDOExample example = (BizApplyOpenAccountDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新业务层通用开户记录表【BizApplyOpenAccountDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    public String updateByPrimaryKeySelective(BizApplyOpenAccountDO record) {
        BEGIN();
        UPDATE("MC_APPLY_OPEN_ACCOUNT");
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL}");
        }
        
        if (record.getPromoterId() != null) {
            SET("PROMOTER_ID = #{promoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPromoterName() != null) {
            SET("PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("ACCOUNT_ID = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getMemberId() != null) {
            SET("MEMBER_ID = #{memberId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=DECIMAL}");
        }
        
        if (record.getBizId() != null) {
            SET("BIZ_ID = #{bizId,jdbcType=DECIMAL}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table MC_APPLY_OPEN_ACCOUNT
     *
     * @mbggenerated Mon Jun 01 17:30:15 CST 2015
     */
    protected void applyWhere(BizApplyOpenAccountDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getAccountType() != null) {
            sb.append(" and  ACCOUNT_TYPE = #{accountType,jdbcType=DECIMAL} ");
        }
        
        if (example.getPromoterId() != null) {
            sb.append(" and  PROMOTER_ID = #{promoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPromoterName() != null && !example.getPromoterName().equals("") ) {
            sb.append(" and  PROMOTER_NAME = #{promoterName,jdbcType=VARCHAR} ");
        }
        
        if (example.getAccountId() != null && !example.getAccountId().equals("") ) {
            sb.append(" and  ACCOUNT_ID = #{accountId,jdbcType=VARCHAR} ");
        }
        
        if (example.getMemberId() != null && !example.getMemberId().equals("") ) {
            sb.append(" and  MEMBER_ID = #{memberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
            sb.append(" and  STATUS = #{status,jdbcType=DECIMAL} ");
        }
        
        if (example.getBizId() != null) {
            sb.append(" and  BIZ_ID = #{bizId,jdbcType=DECIMAL} ");
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