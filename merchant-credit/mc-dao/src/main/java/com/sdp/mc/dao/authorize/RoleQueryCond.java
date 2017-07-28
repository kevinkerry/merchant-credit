package com.sdp.mc.dao.authorize;

import com.sdp.mc.common.base.dao.BaseCond;


/**
 * 角色列表查询条件
 * @author zhangmeng.michael
 *
 */
public class RoleQueryCond extends BaseCond {

	/**
	 * 角色名
	 */
	protected String roleName;
	
	protected String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
