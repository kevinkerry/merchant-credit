package com.sdp.withdraw.manager.ext;

import java.util.List;

import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;

public interface ExtWithdrawInfoManager {

	int updateByExampleSelective(WithdrawInfoDO record,WithdrawInfoDOExample example);

	/**
	 * 加数据库锁 查询
	 * @param example
	 * @return
	 */
	List<WithdrawInfoDO> findWithdrawInfoByExampleForUpdate(WithdrawInfoDOExample example, boolean isForUpdate);

	List<WithdrawInfoDO> findWithdrawInfoByMemberIds(List<Long> bizIds, boolean isForUpdate);

	int repairWithdrawData();
}
