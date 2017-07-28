package com.sdp.withdraw.dao.daointerface.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.withdraw.dao.daointerface.WithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtRefoundReqVO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.mapper.ext.ExtRefoundReqSqlProvider;

/**
 * 退款查询
 * @author liutao
 *
 */
public interface ExtRefoundReqDAO extends WithdrawReqDAO{
	@SelectProvider(type = ExtRefoundReqSqlProvider.class, method = "countRefoundByQuery")
	int countRefoundByQuery(ExtWithdrawReqDOExample example);

	/**
	 * 根据Query对象分页查询出款列表信息
	 * @param example
	 * @return
	 */
    @SelectProvider(type=ExtRefoundReqSqlProvider.class, method="selectRefoundByQuery")
    @Results({
    	 @Result(column="REQ_ID", property="reqId", jdbcType=JdbcType.DECIMAL, id=true),
         @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="MERCHANT_NO", property="merchantNo", jdbcType=JdbcType.VARCHAR),
         @Result(column="MC_TYPE", property="mcType", jdbcType=JdbcType.VARCHAR),
         @Result(column="withdraw_amount", property="withdrawAmount", jdbcType=JdbcType.DECIMAL),
         @Result(column="WITHDRAW_COST", property="withdrawCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="WD_COST", property="wdCost", jdbcType=JdbcType.DECIMAL),
         @Result(column="TOTAL_COST", property="totalCost", jdbcType=JdbcType.DECIMAL),

         @Result(column="STATUS", property="status", jdbcType=JdbcType.DECIMAL),
         @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="WITHDRAW_TIME", property="withdrawTime", jdbcType=JdbcType.TIMESTAMP),
         @Result(column="remitStatus", property="remitStatus", jdbcType=JdbcType.TIMESTAMP),

    })
    List<ExtRefoundReqVO> selectRefoundByQuery(ExtWithdrawReqDOExample example);

}
