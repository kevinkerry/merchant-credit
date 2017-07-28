package com.sdp.mc.newt0.manager;

import java.util.List;
import java.util.Map;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;

/**
 * 扩展类
 * @author heyi.alex
 *
 */
public interface ExtNewt0SdpRemainBalanceManager extends Newt0SdpRemainBalanceManager{

	public boolean updateSdpFrozenAmount(Map<String, Object> updateMap);

	public boolean frozenAmountSuccess(Map<String, Object> updateMap);

	public boolean frozenAmountFail(Map<String, Object> updateMap);

	public Newt0SdpRemainBalanceDO getNowRemainBalance();

	public boolean updateCanUseQuota(Map<String, Object> updateMap);

	/**
	 * 加数据库锁 查询盛付通电子出款总额度
	 * 冻结、解冻、还原额度使用
	 * @return
	 */
	public List<Newt0SdpRemainBalanceDO> selectNowRemainBalanceForUpdate();
}
