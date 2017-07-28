package com.sdp.mc.dao.authorize;

import java.util.Date;

/**
 * 角色EO
 * @author zhangmeng.michael
 *
 */
public class RoleEO {

	/**
	 * id
	 */
	private long id;
	/**
	 * 会员id
	 */
	private String memberId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色备注说明
	 */
	private String roleRemark;
	/**
	 * 创建者操作员id
	 */
	private String createOperatorId;
	
	/**
	 * 版本
	 */
	private Long version;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public String getCreateOperatorId() {
		return createOperatorId;
	}

	public void setCreateOperatorId(String createOperatorId) {
		this.createOperatorId = createOperatorId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	

}
