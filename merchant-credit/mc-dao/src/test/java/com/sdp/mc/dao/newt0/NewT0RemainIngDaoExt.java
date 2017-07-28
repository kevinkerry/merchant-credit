package com.sdp.mc.dao.newt0;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.dao.test.MCBaseTest;
import com.sdp.mc.newt0.dao.daointerface.ext.ExtNewt0SdpRemainBalanceDAO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.newt0.manager.impl.Newt0SdpRemainBalanceManagerImpl;

public class NewT0RemainIngDaoExt extends MCBaseTest {

	@Autowired
	private ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;

	@Test
	public void test() {
		Map<String, Object> tx = new HashMap<String, Object>();
		tx.put("id", 1);
		tx.put("amount", 500);
		boolean rowNum = extNewt0SdpRemainBalanceManager.updateSdpFrozenAmount(tx);
		System.out.println(rowNum);
	}

}
