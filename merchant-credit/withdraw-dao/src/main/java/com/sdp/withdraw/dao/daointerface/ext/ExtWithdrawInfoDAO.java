package com.sdp.withdraw.dao.daointerface.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawInfoDAO;
import com.sdp.withdraw.dao.mapper.OpLogRecordSqlProvider;
import com.sdp.withdraw.dao.mapper.ext.ExtWithdrawInfoSqlProvider;

public interface ExtWithdrawInfoDAO extends WithdrawInfoDAO{

	@SelectProvider(type=ExtWithdrawInfoSqlProvider.class, method="selectWithdrawInfoDOForUpdate")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
        @Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
        @Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<WithdrawInfoDO> selectWithdrawInfoDOForUpdate(WithdrawInfoDOExample example);
	
	@SelectProvider(type=ExtWithdrawInfoSqlProvider.class, method="selectWithdrawInfoByExample")
	@Results({
		@Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
		@Result(column="LIMITATION_TYPE", property="limitationType", jdbcType=JdbcType.DECIMAL),
		@Result(column="BIZ_ID", property="bizId", jdbcType=JdbcType.DECIMAL),
		@Result(column="BIZ_TYPE", property="bizType", jdbcType=JdbcType.DECIMAL),
		@Result(column="LIMITATION", property="limitation", jdbcType=JdbcType.DECIMAL),
		@Result(column="FORZEN_LIMITATION", property="forzenLimitation", jdbcType=JdbcType.DECIMAL),
		@Result(column="USED_LIMITATION", property="usedLimitation", jdbcType=JdbcType.DECIMAL),
		@Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
		@Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
	})
	List<WithdrawInfoDO> selectWithdrawInfoByExample(WithdrawInfoDOExample example);
	 @UpdateProvider(type=ExtWithdrawInfoSqlProvider.class, method="repairWithdrawData")
	int repairWithdrawData();

}
