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

import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample.Criteria;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample.Criterion;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import java.util.List;
import java.util.Map;

public class PosMerchantInfoSqlProvider {

    /**
     * 根据Example对象取得POS商户信息【PosMerchantInfoDO】对象count信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String countByExample(PosMerchantInfoDOExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("FW_POS_MERCHANT_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 根据Example对象删除POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String deleteByExample(PosMerchantInfoDOExample example) {
        BEGIN();
        DELETE_FROM("FW_POS_MERCHANT_INFO");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * 添加POS商户信息【PosMerchantInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String insertSelective(PosMerchantInfoDO record) {
        BEGIN();
        INSERT_INTO("FW_POS_MERCHANT_INFO");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getMerchantNo() != null) {
            VALUES("MERCHANT_NO", "#{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPosMerchantId() != null) {
            VALUES("POS_MERCHANT_ID", "#{posMerchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            VALUES("MERCHANT_TYPE", "#{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getParentPromoterId() != null) {
            VALUES("PARENT_PROMOTER_ID", "#{parentPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantMemberId() != null) {
            VALUES("MERCHANT_MEMBER_ID", "#{merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            VALUES("ACCOUNT_TYPE", "#{accountType,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseAccountId() != null) {
            VALUES("BASE_ACCOUNT_ID", "#{baseAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFastSettleLimit() != null) {
            VALUES("FAST_SETTLE_LIMIT", "#{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            VALUES("FAST_SETTLE_FLAG", "#{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            VALUES("AUTO_FAST_SETTLE_FLAG", "#{autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantPhone() != null) {
            VALUES("MERCHANT_PHONE", "#{merchantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleMargin() != null) {
            VALUES("FAST_SETTLE_MARGIN", "#{fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            VALUES("FAST_SETTLE_MIN_LIMIT", "#{fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtBindOperatorId() != null) {
            VALUES("PMT_BIND_OPERATOR_ID", "#{pmtBindOperatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtBindOperatorName() != null) {
            VALUES("PMT_BIND_OPERATOR_NAME", "#{pmtBindOperatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoaningType() != null) {
            VALUES("LOANING_TYPE", "#{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            VALUES("STATUS", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            VALUES("MERCHANT_NAME", "#{merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getMcc() != null) {
            VALUES("MCC", "#{mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            VALUES("LAST_LEVEL_PROMOTER_ID", "#{lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtLevel() != null) {
            VALUES("PMT_LEVEL", "#{pmtLevel,jdbcType=DECIMAL}");
        }
        
        if (record.getCertType() != null) {
            VALUES("CERT_TYPE", "#{certType,jdbcType=VARCHAR}");
        }
        
        if (record.getCertNo() != null) {
            VALUES("CERT_NO", "#{certNo,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * 根据Example对象查询得到POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String selectByExample(PosMerchantInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("MERCHANT_NO");
        SELECT("POS_MERCHANT_ID");
        SELECT("MERCHANT_TYPE");
        SELECT("PARENT_PROMOTER_ID");
        SELECT("MERCHANT_MEMBER_ID");
        SELECT("ACCOUNT_TYPE");
        SELECT("BASE_ACCOUNT_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("AUTO_FAST_SETTLE_FLAG");
        SELECT("MERCHANT_PHONE");
        SELECT("FAST_SETTLE_MARGIN");
        SELECT("FAST_SETTLE_MIN_LIMIT");
        SELECT("PMT_BIND_OPERATOR_ID");
        SELECT("PMT_BIND_OPERATOR_NAME");
        SELECT("LOANING_TYPE");
        SELECT("STATUS");
        SELECT("MERCHANT_NAME");
        SELECT("MCC");
        SELECT("LAST_LEVEL_PROMOTER_ID");
        SELECT("PMT_LEVEL");
        SELECT("CERT_TYPE");
        SELECT("CERT_NO");
        FROM("FW_POS_MERCHANT_INFO");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询POS商户信息【PosMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String selectByQuery(PosMerchantInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ID");
        } else {
            SELECT("ID");
        }
        SELECT("MERCHANT_NO");
        SELECT("POS_MERCHANT_ID");
        SELECT("MERCHANT_TYPE");
        SELECT("PARENT_PROMOTER_ID");
        SELECT("MERCHANT_MEMBER_ID");
        SELECT("ACCOUNT_TYPE");
        SELECT("BASE_ACCOUNT_ID");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        SELECT("FAST_SETTLE_LIMIT");
        SELECT("FAST_SETTLE_FLAG");
        SELECT("AUTO_FAST_SETTLE_FLAG");
        SELECT("MERCHANT_PHONE");
        SELECT("FAST_SETTLE_MARGIN");
        SELECT("FAST_SETTLE_MIN_LIMIT");
        SELECT("PMT_BIND_OPERATOR_ID");
        SELECT("PMT_BIND_OPERATOR_NAME");
        SELECT("LOANING_TYPE");
        SELECT("STATUS");
        SELECT("MERCHANT_NAME");
        SELECT("MCC");
        SELECT("LAST_LEVEL_PROMOTER_ID");
        SELECT("PMT_LEVEL");
        SELECT("CERT_TYPE");
        SELECT("CERT_NO");
        FROM("FW_POS_MERCHANT_INFO");
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
     * 根据Example对象更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        PosMerchantInfoDO record = (PosMerchantInfoDO) parameter.get("record");
        PosMerchantInfoDOExample example = (PosMerchantInfoDOExample) parameter.get("example");
        
        BEGIN();
        UPDATE("FW_POS_MERCHANT_INFO");
        
        if (record.getId() != null) {
            SET("ID = #{record.id,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPosMerchantId() != null) {
            SET("POS_MERCHANT_ID = #{record.posMerchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getParentPromoterId() != null) {
            SET("PARENT_PROMOTER_ID = #{record.parentPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantMemberId() != null) {
            SET("MERCHANT_MEMBER_ID = #{record.merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseAccountId() != null) {
            SET("BASE_ACCOUNT_ID = #{record.baseAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            SET("AUTO_FAST_SETTLE_FLAG = #{record.autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantPhone() != null) {
            SET("MERCHANT_PHONE = #{record.merchantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleMargin() != null) {
            SET("FAST_SETTLE_MARGIN = #{record.fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            SET("FAST_SETTLE_MIN_LIMIT = #{record.fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtBindOperatorId() != null) {
            SET("PMT_BIND_OPERATOR_ID = #{record.pmtBindOperatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtBindOperatorName() != null) {
            SET("PMT_BIND_OPERATOR_NAME = #{record.pmtBindOperatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            SET("MERCHANT_NAME = #{record.merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getMcc() != null) {
            SET("MCC = #{record.mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            SET("LAST_LEVEL_PROMOTER_ID = #{record.lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtLevel() != null) {
            SET("PMT_LEVEL = #{record.pmtLevel,jdbcType=DECIMAL}");
        }
        
        if (record.getCertType() != null) {
            SET("CERT_TYPE = #{record.certType,jdbcType=VARCHAR}");
        }
        
        if (record.getCertNo() != null) {
            SET("CERT_NO = #{record.certNo,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据Example对象更新POS商户信息【PosMerchantInfoDO】对象信息
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("FW_POS_MERCHANT_INFO");
        
        SET("ID = #{record.id,jdbcType=DECIMAL}");
        SET("MERCHANT_NO = #{record.merchantNo,jdbcType=VARCHAR}");
        SET("POS_MERCHANT_ID = #{record.posMerchantId,jdbcType=DECIMAL}");
        SET("MERCHANT_TYPE = #{record.merchantType,jdbcType=VARCHAR}");
        SET("PARENT_PROMOTER_ID = #{record.parentPromoterId,jdbcType=DECIMAL}");
        SET("MERCHANT_MEMBER_ID = #{record.merchantMemberId,jdbcType=VARCHAR}");
        SET("ACCOUNT_TYPE = #{record.accountType,jdbcType=VARCHAR}");
        SET("BASE_ACCOUNT_ID = #{record.baseAccountId,jdbcType=VARCHAR}");
        SET("CREATE_TIME = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("UPDATE_TIME = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("FAST_SETTLE_LIMIT = #{record.fastSettleLimit,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_FLAG = #{record.fastSettleFlag,jdbcType=DECIMAL}");
        SET("AUTO_FAST_SETTLE_FLAG = #{record.autoFastSettleFlag,jdbcType=DECIMAL}");
        SET("MERCHANT_PHONE = #{record.merchantPhone,jdbcType=VARCHAR}");
        SET("FAST_SETTLE_MARGIN = #{record.fastSettleMargin,jdbcType=DECIMAL}");
        SET("FAST_SETTLE_MIN_LIMIT = #{record.fastSettleMinLimit,jdbcType=DECIMAL}");
        SET("PMT_BIND_OPERATOR_ID = #{record.pmtBindOperatorId,jdbcType=VARCHAR}");
        SET("PMT_BIND_OPERATOR_NAME = #{record.pmtBindOperatorName,jdbcType=VARCHAR}");
        SET("LOANING_TYPE = #{record.loaningType,jdbcType=DECIMAL}");
        SET("STATUS = #{record.status,jdbcType=VARCHAR}");
        SET("MERCHANT_NAME = #{record.merchantName,jdbcType=VARCHAR}");
        SET("MCC = #{record.mcc,jdbcType=VARCHAR}");
        SET("LAST_LEVEL_PROMOTER_ID = #{record.lastLevelPromoterId,jdbcType=DECIMAL}");
        SET("PMT_LEVEL = #{record.pmtLevel,jdbcType=DECIMAL}");
        SET("CERT_TYPE = #{record.certType,jdbcType=VARCHAR}");
        SET("CERT_NO = #{record.certNo,jdbcType=VARCHAR}");
        
        PosMerchantInfoDOExample example = (PosMerchantInfoDOExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * 根据主键更新POS商户信息【PosMerchantInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    public String updateByPrimaryKeySelective(PosMerchantInfoDO record) {
        BEGIN();
        UPDATE("FW_POS_MERCHANT_INFO");
        
        if (record.getMerchantNo() != null) {
            SET("MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR}");
        }
        
        if (record.getPosMerchantId() != null) {
            SET("POS_MERCHANT_ID = #{posMerchantId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantType() != null) {
            SET("MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR}");
        }
        
        if (record.getParentPromoterId() != null) {
            SET("PARENT_PROMOTER_ID = #{parentPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantMemberId() != null) {
            SET("MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountType() != null) {
            SET("ACCOUNT_TYPE = #{accountType,jdbcType=VARCHAR}");
        }
        
        if (record.getBaseAccountId() != null) {
            SET("BASE_ACCOUNT_ID = #{baseAccountId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFastSettleLimit() != null) {
            SET("FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleFlag() != null) {
            SET("FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getAutoFastSettleFlag() != null) {
            SET("AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL}");
        }
        
        if (record.getMerchantPhone() != null) {
            SET("MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getFastSettleMargin() != null) {
            SET("FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL}");
        }
        
        if (record.getFastSettleMinLimit() != null) {
            SET("FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtBindOperatorId() != null) {
            SET("PMT_BIND_OPERATOR_ID = #{pmtBindOperatorId,jdbcType=VARCHAR}");
        }
        
        if (record.getPmtBindOperatorName() != null) {
            SET("PMT_BIND_OPERATOR_NAME = #{pmtBindOperatorName,jdbcType=VARCHAR}");
        }
        
        if (record.getLoaningType() != null) {
            SET("LOANING_TYPE = #{loaningType,jdbcType=DECIMAL}");
        }
        
        if (record.getStatus() != null) {
            SET("STATUS = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchantName() != null) {
            SET("MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR}");
        }
        
        if (record.getMcc() != null) {
            SET("MCC = #{mcc,jdbcType=VARCHAR}");
        }
        
        if (record.getLastLevelPromoterId() != null) {
            SET("LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL}");
        }
        
        if (record.getPmtLevel() != null) {
            SET("PMT_LEVEL = #{pmtLevel,jdbcType=DECIMAL}");
        }
        
        if (record.getCertType() != null) {
            SET("CERT_TYPE = #{certType,jdbcType=VARCHAR}");
        }
        
        if (record.getCertNo() != null) {
            SET("CERT_NO = #{certNo,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=DECIMAL}");
        
        return SQL();
    }

    /**
     * This method corresponds to the database table FW_POS_MERCHANT_INFO
     *
     * @mbggenerated Wed Aug 10 08:42:07 CST 2016
     */
    protected void applyWhere(PosMerchantInfoDOExample example, boolean includeExamplePhrase) {
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
        
        if (example.getMerchantNo() != null && !example.getMerchantNo().equals("") ) {
            sb.append(" and  MERCHANT_NO = #{merchantNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getPosMerchantId() != null) {
            sb.append(" and  POS_MERCHANT_ID = #{posMerchantId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantType() != null && !example.getMerchantType().equals("") ) {
            sb.append(" and  MERCHANT_TYPE = #{merchantType,jdbcType=VARCHAR} ");
        }
        
        if (example.getParentPromoterId() != null) {
            sb.append(" and  PARENT_PROMOTER_ID = #{parentPromoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantMemberId() != null && !example.getMerchantMemberId().equals("") ) {
            sb.append(" and  MERCHANT_MEMBER_ID = #{merchantMemberId,jdbcType=VARCHAR} ");
        }
        
        if (example.getAccountType() != null && !example.getAccountType().equals("") ) {
            sb.append(" and  ACCOUNT_TYPE = #{accountType,jdbcType=VARCHAR} ");
        }
        
        if (example.getBaseAccountId() != null && !example.getBaseAccountId().equals("") ) {
            sb.append(" and  BASE_ACCOUNT_ID = #{baseAccountId,jdbcType=VARCHAR} ");
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getFastSettleLimit() != null) {
            sb.append(" and  FAST_SETTLE_LIMIT = #{fastSettleLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleFlag() != null) {
            sb.append(" and  FAST_SETTLE_FLAG = #{fastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getAutoFastSettleFlag() != null) {
            sb.append(" and  AUTO_FAST_SETTLE_FLAG = #{autoFastSettleFlag,jdbcType=DECIMAL} ");
        }
        
        if (example.getMerchantPhone() != null && !example.getMerchantPhone().equals("") ) {
            sb.append(" and  MERCHANT_PHONE = #{merchantPhone,jdbcType=VARCHAR} ");
        }
        
        if (example.getFastSettleMargin() != null) {
            sb.append(" and  FAST_SETTLE_MARGIN = #{fastSettleMargin,jdbcType=DECIMAL} ");
        }
        
        if (example.getFastSettleMinLimit() != null) {
            sb.append(" and  FAST_SETTLE_MIN_LIMIT = #{fastSettleMinLimit,jdbcType=DECIMAL} ");
        }
        
        if (example.getPmtBindOperatorId() != null && !example.getPmtBindOperatorId().equals("") ) {
            sb.append(" and  PMT_BIND_OPERATOR_ID = #{pmtBindOperatorId,jdbcType=VARCHAR} ");
        }
        
        if (example.getPmtBindOperatorName() != null && !example.getPmtBindOperatorName().equals("") ) {
            sb.append(" and  PMT_BIND_OPERATOR_NAME = #{pmtBindOperatorName,jdbcType=VARCHAR} ");
        }
        
        if (example.getLoaningType() != null) {
            sb.append(" and  LOANING_TYPE = #{loaningType,jdbcType=DECIMAL} ");
        }
        
        if (example.getStatus() != null && !example.getStatus().equals("") ) {
            sb.append(" and  STATUS = #{status,jdbcType=VARCHAR} ");
        }
        
        if (example.getMerchantName() != null && !example.getMerchantName().equals("") ) {
            sb.append(" and  MERCHANT_NAME = #{merchantName,jdbcType=VARCHAR} ");
        }
        
        if (example.getMcc() != null && !example.getMcc().equals("") ) {
            sb.append(" and  MCC = #{mcc,jdbcType=VARCHAR} ");
        }
        
        if (example.getLastLevelPromoterId() != null) {
            sb.append(" and  LAST_LEVEL_PROMOTER_ID = #{lastLevelPromoterId,jdbcType=DECIMAL} ");
        }
        
        if (example.getPmtLevel() != null) {
            sb.append(" and  PMT_LEVEL = #{pmtLevel,jdbcType=DECIMAL} ");
        }
        
        if (example.getCertType() != null && !example.getCertType().equals("") ) {
            sb.append(" and  CERT_TYPE = #{certType,jdbcType=VARCHAR} ");
        }
        
        if (example.getCertNo() != null && !example.getCertNo().equals("") ) {
            sb.append(" and  CERT_NO = #{certNo,jdbcType=VARCHAR} ");
        }
        WHERE(sb.toString());
    }
}