package com.sdp.mc.newt0.dao.daointerface.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0SdpRemainBalanceDAO;
import com.sdp.mc.newt0.dao.mapper.ext.ExtNewt0SdpRemainBalanceSqlProvider;

public interface ExtNewt0SdpRemainBalanceDAO extends Newt0SdpRemainBalanceDAO {

	/**
	 * 冻结资金
	 * @param record
	 * @return
	 */
	@Update({ "update NEWT0_SDP_REMAIN_BALANCE set ", "UPDATE_TIME = sysdate,",
			"CAN_USE_QUOTA=CAN_USE_QUOTA-#{amount},",
			"FROZEN_QUOTA=FROZEN_QUOTA+#{amount}",
			" where id=#{id} and CAN_USE_QUOTA -#{amount} >= 0" })
	int updateSdpFrozenAmount(Map<String, Object> record);

	/**
	 * 冻结资金正常
	 * @param record
	 * @return
	 */
	@Update({ "update NEWT0_SDP_REMAIN_BALANCE set UPDATE_TIME = sysdate,",
		" USED_QUOTA=USED_QUOTA+#{amount},",
		" FROZEN_QUOTA=FROZEN_QUOTA-#{amount} ",
		" where #{startTime} BETWEEN START_TIME AND END_TIME AND FROZEN_QUOTA -#{amount} >= 0" })
	int frozenAmountSuccess(Map<String, Object> record);

	/**
	 * 资金冻结失败回滚
	 * @return
	 */
	@Update({ "update NEWT0_SDP_REMAIN_BALANCE set ", "UPDATE_TIME = sysdate,",
		"CAN_USE_QUOTA=CAN_USE_QUOTA+#{amount},",
		"FROZEN_QUOTA=FROZEN_QUOTA-#{amount}",
		" where #{startTime} BETWEEN START_TIME AND END_TIME" })
	int frozenAmountFail(Map<String, Object> record);

	/**
	 * 查询盛付通垫资剩余额度
	 * @return
	 */
	@Select({"select ID,START_TIME,QUOTA,CREATE_TIME,UPDATE_TIME,END_TIME,CAN_USE_QUOTA,FROZEN_QUOTA,USED_QUOTA from newt0_sdp_remain_balance t where trunc(t.start_time)=trunc(sysdate)" })
	 @Results({
	        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
	        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
	        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
	        @Result(column="CAN_USE_QUOTA", property="canUseQuota", jdbcType=JdbcType.DECIMAL),
	        @Result(column="FROZEN_QUOTA", property="frozenQuota", jdbcType=JdbcType.DECIMAL),
	        @Result(column="USED_QUOTA", property="usedQuota", jdbcType=JdbcType.DECIMAL)
	    })
	Newt0SdpRemainBalanceDO getNowRemainBalance();

	/**
	 * 更新可用额度
	 */
	@Update({ "update NEWT0_SDP_REMAIN_BALANCE set UPDATE_TIME = sysdate,",
		" QUOTA = #{quota}, CAN_USE_QUOTA=#{quota}-FROZEN_QUOTA-USED_QUOTA ",
		" where id=#{id}" })
	int updateCanUseQuota(Map<String, Object> record);


	@SelectProvider(type=ExtNewt0SdpRemainBalanceSqlProvider.class, method="selectByExampleByUpdate")
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="START_TIME", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="QUOTA", property="quota", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="END_TIME", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CAN_USE_QUOTA", property="canUseQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="FROZEN_QUOTA", property="frozenQuota", jdbcType=JdbcType.DECIMAL),
        @Result(column="USED_QUOTA", property="usedQuota", jdbcType=JdbcType.DECIMAL)
    })
	List<Newt0SdpRemainBalanceDO> getNowRemainBalanceForUpdate();
}
