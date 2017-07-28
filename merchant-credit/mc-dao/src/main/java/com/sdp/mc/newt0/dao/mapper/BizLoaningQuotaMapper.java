/*package com.sdp.mc.newt0.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.newt0.LoaningQuotaDO;
import com.sdp.mc.newt0.dao.ext.BizLoaningQuataReqDOExampleExt;

public interface BizLoaningQuotaMapper {

	@Insert({
			"insert into NEWT0_FILE (ID, FILEDATE, QUOTA ,CREATE_TIME, UPDATE_TIME)",
			"values (#{id,jdbcType=DECIMAL}, #{fileDate,jdbcType=VARCHAR}, ",
			"#{quota,jdbcType=DECIMAL}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})" })
	@SelectKey(statement = "select SEQ_NEWT0_FILE.nextval from dual", keyProperty = "id", before = true, resultType = Long.class)
	Long insert(LoaningQuotaDO record);
	
	
	@SelectProvider(type=BizLoaningQuotaProvider.class, method="selectByExample")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="FILEDATE", property="fileDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LoaningQuotaDO> selectByExample(BizLoaningQuataReqDOExampleExt example);
	
	
	@Update({
        "update NEWT0_FILE",
        "set QUOTA = #{quota,jdbcType=DECIMAL},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(LoaningQuotaDO record);
}
*/