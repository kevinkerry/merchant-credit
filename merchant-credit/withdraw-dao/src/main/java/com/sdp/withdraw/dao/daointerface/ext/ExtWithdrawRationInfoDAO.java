package com.sdp.withdraw.dao.daointerface.ext;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.sdp.withdraw.dao.WithdrawRatioInfoDO;
import com.sdp.withdraw.dao.daointerface.WithdrawRatioInfoDAO;
import com.sdp.withdraw.dao.mapper.ext.ExtWithdrawRatioSqlProvider;

public interface ExtWithdrawRationInfoDAO extends WithdrawRatioInfoDAO{
	 @SelectProvider(type=ExtWithdrawRatioSqlProvider.class, method="selectRatioInfo")
	 @Results({ @Result(column="RATIO_TYPE", property="ratioType", jdbcType=JdbcType.DECIMAL)})
    List<WithdrawRatioInfoDO> selectRatioInfo(Long bizId);




}
