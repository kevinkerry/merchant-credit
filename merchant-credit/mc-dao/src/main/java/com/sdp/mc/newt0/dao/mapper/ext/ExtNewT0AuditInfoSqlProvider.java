package com.sdp.mc.newt0.dao.mapper.ext;

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

import com.sdp.mc.common.enums.AuditInfoStateEnum;
import com.sdp.mc.newt0.dao.ExtNewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criteria;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample.Criterion;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class ExtNewT0AuditInfoSqlProvider {

    /**
     * 根据Example对象取得审核表【NewT0AuditInfoDO】对象count信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String countByExample(ExtNewT0AuditInfoDOExample example) {
        BEGIN();
        SELECT("count(1)");
        FROM("NEWT0_AUDIT_INFO ai left join view_promoter_info pi on ai.obj_id=pi.promoter_id");
        applyWhere(example, false);
        return SQL();
    }

    

    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String selectByExample(ExtNewT0AuditInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ai.ID");
        } else {
            SELECT("ai.ID");
        }
        SELECT("ai.OBJ_NO");
        SELECT("ai.OBJ_ID");
        SELECT("ai.OBJ_TYPE");
        SELECT("ai.OP_TYPE");
        SELECT("ai.REQUEST_LOG");
        SELECT("ai.STATUS");
        SELECT("ai.CREATE_TIME");
        SELECT("ai.UPDATE_TIME");
        SELECT("ai.OPERATOR");
        SELECT("ai.OPERATOR_ID");
        SELECT("ai.EXPIRE_TIME");
        SELECT("ai.MCTYPE");
        SELECT("ai.AUDIT_TIME");
        SELECT("PI.PROMOTER_NAME");
        SELECT("PI.PROMOTER_TYPE");
        SELECT("PI.PROMOTER_ID");
        SELECT("PI.LOANING_TYPE");
        SELECT("PI.PROMOTER_MERCHANT_NO");
        SELECT("PI.PROMOTER_FS_FLAG");
        SELECT("PI.PROMOTER_FS_LIMIT");
        FROM("NEWT0_AUDIT_INFO ai left join view_promoter_info pi on ai.obj_id=pi.promoter_id");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    public String selectByQuery(ExtNewT0AuditInfoDOExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("ai.ID");
        } else {
            SELECT("ai.ID");
        }
        SELECT("ai.OBJ_NO");
        SELECT("ai.OBJ_ID");
        SELECT("ai.OBJ_TYPE");
        SELECT("ai.OP_TYPE");
        SELECT("ai.REQUEST_LOG");
        SELECT("ai.STATUS");
        SELECT("ai.CREATE_TIME");
        SELECT("ai.UPDATE_TIME");
        SELECT("ai.OPERATOR");
        SELECT("ai.OPERATOR_ID");
        SELECT("ai.EXPIRE_TIME");
        SELECT("ai.MCTYPE");
        SELECT("ai.AUDIT_TIME");
        SELECT("PI.PROMOTER_NAME");
        SELECT("PI.PROMOTER_TYPE");
        SELECT("PI.PROMOTER_ID");
        SELECT("PI.LOANING_TYPE");
        SELECT("PI.PROMOTER_MERCHANT_NO");
        SELECT("PI.PROMOTER_FS_FLAG");
        SELECT("PI.PROMOTER_FS_LIMIT");
        FROM("NEWT0_AUDIT_INFO ai left join view_promoter_info pi on ai.obj_id=pi.promoter_id");
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
     * This method corresponds to the database table NEWT0_AUDIT_INFO
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    protected void applyWhere(ExtNewT0AuditInfoDOExample example, boolean includeExamplePhrase) {
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
            sb.append(" and  ai.ID = #{id,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjNo() != null && !example.getObjNo().equals("") ) {
            sb.append(" and  ai.OBJ_NO = #{objNo,jdbcType=VARCHAR} ");
        }
        
        if (example.getObjId() != null) {
            sb.append(" and  ai.OBJ_ID = #{objId,jdbcType=DECIMAL} ");
        }
        
        if (example.getObjType() != null) {
            sb.append(" and  ai.OBJ_TYPE = #{objType,jdbcType=DECIMAL} ");
        }
        
        if (example.getOpType() != null) {
            sb.append(" and  ai.OP_TYPE = #{opType,jdbcType=DECIMAL} ");
        }
        
        if (example.getRequestLog() != null && !example.getRequestLog().equals("") ) {
            sb.append(" and  ai.REQUEST_LOG = #{requestLog,jdbcType=VARCHAR} ");
        }
        
        if (example.getStatus() != null) {
        	if(AuditInfoStateEnum.OVERDUE.getStatus()==example.getStatus()){
        		sb.append(" and  ai.STATUS =  "+AuditInfoStateEnum.WAIT_AUDIT.getStatus());
        		sb.append(" and  ai.EXPIRE_TIME < sysdate");
        	}else{
              sb.append(" and  ai.STATUS = #{status,jdbcType=DECIMAL} ");
              sb.append(" and  ((ai.op_type=11 and ai.status=1 and ai.EXPIRE_TIME > sysdate) or ((ai.op_type=11 and ai.status<>1) or(ai.op_type<>11)))");
        	}
        }
        
        if (example.getCreateTime() != null) {
            sb.append(" and  ai.CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getUpdateTime() != null) {
            sb.append(" and  ai.UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getOperator() != null && !example.getOperator().equals("") ) {
            sb.append(" and  ai.OPERATOR = #{operator,jdbcType=VARCHAR} ");
        }
        
        if (example.getOperatorId() != null && !example.getOperatorId().equals("") ) {
            sb.append(" and  ai.OPERATOR_ID = #{operatorId,jdbcType=VARCHAR} ");
        }
        
        if (example.getExpireTime() != null) {
            sb.append(" and  ai.EXPIRE_TIME = #{expireTime,jdbcType=TIMESTAMP} ");
        }
        
        if (example.getMcType() != null && !example.getMcType().equals("") ) {
            sb.append(" and  ai.MCTYPE = #{mcType,jdbcType=VARCHAR} ");
        }
        
        if (example.getAuditTime() != null) {
            sb.append(" and  ai.AUDIT_TIME = #{auditTime,jdbcType=TIMESTAMP} ");
        }

		if (example.getCreateTimeStart() != null) {
			sb.append(" and  ai.CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP} ");
		}

		if (example.getCreateTimeEnd() != null) {
			sb.append(" and  ai.CREATE_TIME < #{createTimeEnd,jdbcType=TIMESTAMP} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterType())) {
			sb.append(" and pi.PROMOTER_TYPE = #{promoterType} ");
		}

		if (StringUtils.isNotBlank(example.getPromoterName())) {
			sb.append(" and pi.PROMOTER_NAME like '%'||#{promoterName}||'%' ");
		}

		if (StringUtils.isNotBlank(example.getPromoterNo())) {
			sb.append(" and pi.PROMOTER_MERCHANT_NO = #{promoterNo} ");
		}

		if (example.getAuditStatus() != null) {//查询在待审核或审核中的记录
			if(AuditInfoStateEnum.OVERDUE.getStatus()==example.getAuditStatus()){
				sb.append(" and ai.STATUS=  "+AuditInfoStateEnum.WAIT_AUDIT.getStatus());
        		sb.append(" and  ai.EXPIRE_TIME < sysdate");
        	}else{
        		sb.append(" and ai.STATUS= #{auditStatus} ");
        		sb.append(" and  ((ai.op_type=11 and ai.status=1 and ai.EXPIRE_TIME > sysdate) or ((ai.op_type=11 and ai.status<>1) or(ai.op_type<>11)))");
        	}
			
		}
        
        
        WHERE(sb.toString());
    }
}