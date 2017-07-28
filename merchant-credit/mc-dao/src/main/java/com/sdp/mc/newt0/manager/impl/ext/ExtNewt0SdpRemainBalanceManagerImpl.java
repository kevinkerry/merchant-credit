package com.sdp.mc.newt0.manager.impl.ext;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.daointerface.ext.ExtNewt0SdpRemainBalanceDAO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.newt0.manager.impl.Newt0SdpRemainBalanceManagerImpl;

/**
 * 扩展
 * @author heyi.alex
 *
 */
@Service
public class ExtNewt0SdpRemainBalanceManagerImpl extends Newt0SdpRemainBalanceManagerImpl implements ExtNewt0SdpRemainBalanceManager{

	@Autowired
	private ExtNewt0SdpRemainBalanceDAO extNewt0SdpRemainBalanceDAO;

	/**
	 * 冻结资金
	 */
	public boolean updateSdpFrozenAmount(Map<String, Object> updateMap){
		int rowNum = extNewt0SdpRemainBalanceDAO.updateSdpFrozenAmount(updateMap);
		if (rowNum > 0){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * 冻结成功
	 */
	public boolean frozenAmountSuccess(Map<String, Object> updateMap){
		int rowNum = extNewt0SdpRemainBalanceDAO.frozenAmountSuccess(updateMap);
		if (rowNum > 0){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * 冻结失败回滚
	 */
	public boolean frozenAmountFail(Map<String, Object> updateMap){
		int rowNum = extNewt0SdpRemainBalanceDAO.frozenAmountFail(updateMap);
		if (rowNum > 0){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * 获取盛付通全资代理商额度信息
	 */
	public Newt0SdpRemainBalanceDO getNowRemainBalance() {
		return extNewt0SdpRemainBalanceDAO.getNowRemainBalance();
	}

	/**
	 * 更新可用额度
	 */
	public boolean updateCanUseQuota(Map<String, Object> updateMap){
		int rowNum = extNewt0SdpRemainBalanceDAO.updateCanUseQuota(updateMap);
		if (rowNum > 0){
			return true;
		} else{
			return false;
		}
	}

	/**
	 * 加数据库锁 查询盛付通电子出款总额度
	 * 冻结、解冻、还原额度使用
	 * @return
	 */
	@Override
	public List<Newt0SdpRemainBalanceDO> selectNowRemainBalanceForUpdate() {
		// TODO Auto-generated method stub
		return extNewt0SdpRemainBalanceDAO.getNowRemainBalanceForUpdate();
	}


}
