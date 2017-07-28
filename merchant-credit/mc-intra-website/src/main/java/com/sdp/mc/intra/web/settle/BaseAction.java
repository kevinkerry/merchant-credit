package com.sdp.mc.intra.web.settle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.permission.dao.dataobject.ActAdminRoleDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.settle.SettleApiConstants;
import com.sdp.mc.common.util.DateUtil;

public class BaseAction {

	private final String ROLE_USER = "ROLE_USER";

	@Autowired
	protected ScSettleBaseService settleBaseService;

	public ScSettleBaseService getSettleBaseService() {
		return settleBaseService;
	}

	protected boolean isAdminRole() {
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		List<ActAdminRoleDO> adminRoleDOs = new ArrayList<ActAdminRoleDO>();
		// 由于拦截器中添加了将父角色也加入了user.roleList 中，所以get 0 才是当前用户的角色，详见
		// SysAdminUserDetailService #loadUserByUsername 64行
		adminRoleDOs.add(user.getRoleList().get(0));

		for (ActAdminRoleDO roleDO : adminRoleDOs) {
			String roleCode = roleDO.getRoleCode();
			if (roleCode.equalsIgnoreCase(ROLE_USER)) return true;
		}
		return false;
	}

	protected ActAdminUserDO getSecurityUser() {
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		return user;
	}

	protected String getOperatorId() {
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		return user.getUserName();
	}

	protected String getOperatorName() {
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		return user.getRealName();
	}

	protected String getEffectiveTime() {
		return DateUtil.getCurrentDayStrFristTime(new Date());
	}

	protected String getExpireTime() {
		String expireTime = DateUtil.getCurrentDayStrEndTime(new Date());
		expireTime = DateUtil.getCurrentDayStrEndTime(DateUtil.parseDate(SettleApiConstants.expireTime, DateUtil.date_pattern));
		return expireTime;
	}
	// infoPO.setOperatorId(user.getUserName());
	// infoPO.setOperatorName(user.getRealName());
}
