/*package com.sdp.mc.newt0.dao.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.sdp.mc.newt0.LoaningQuotaDO;
import com.sdp.mc.newt0.dao.ext.BizLoaningQuataReqDOExampleExt;

public class BizLoaningQuotaProvider {

	 public String countByExample(BizLoaningQuataReqDOExampleExt example) {
	        BEGIN();
	        SELECT("count(*)");
	        FROM("NEWT0_FILE");
	        applyWhere(example, false);
	        return SQL();
	    }
	 
	 public String countByExample4Intra(BizLoaningQuataReqDOExampleExt example) {
	        BEGIN();
	        DELETE_FROM("MC_WITH_CAPITAL_4PROMOTER");
	        applyWhere(example, false);
	        return SQL();
	    }
	*//**
	 * @param record
	 * @return
	 *//*
    public String insertSelective(LoaningQuotaDO record) {
        BEGIN();
        INSERT_INTO("NEWT0_FILE");
        
        VALUES("ID", "#{id,jdbcType=DECIMAL}");
        
        if (record.getFileDate() != null) {
            VALUES("FILEDATE", "#{fileDate,jdbcType=VARCHAR}");
        }
        if(record.getQuota() !=null){
        	VALUES("QUOTA", "#{quoat,jdbcType=DECIMAL}");
        }
        if (record.getCreateTime() != null) {
            VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        return SQL();
    }
    
    
    public String selectByExample(BizLoaningQuataReqDOExampleExt example) {
        BEGIN();
        SELECT("ID");
        SELECT("FILEDATE");
        SELECT("QUOTA");
        SELECT("CREATE_TIME");
        SELECT("UPDATE_TIME");
        FROM("NEWT0_FILE");
        applyWhere(example, false);
        
        return SQL();
    }
    
    protected void applyWhere(BizLoaningQuataReqDOExampleExt example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (sb.length() == 0) {
            sb.append(" (1=1) ");
        }
        
        if (example.getId() != null) {
            sb.append(" and  ID = #{id,jdbcType=DECIMAL} ");
        }
        
        if (example.getFileDate() != null) {
            sb.append(" and  FILEDATE = #{fileDate,jdbcType=VARCHAR} ");
        }
        
//        if (example.getQuota() != null) {
//            sb.append(" and  QUOTA = #{quota,jdbcType=DECIMAL} ");
//        }
        
//        if (example.getUpdateTime() != null) {
//            sb.append(" and  UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} ");
//        }
        
        WHERE(sb.toString());
    }
}
*/