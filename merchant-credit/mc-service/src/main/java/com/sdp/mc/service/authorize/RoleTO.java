package com.sdp.mc.service.authorize;

import com.sdp.mc.dao.authorize.RoleEO;
/**
 * 角色TO
 * @author zhangmeng.michael
 *
 */
public class RoleTO extends RoleEO{

	/**选中的rule*/
	private String ruleCbx;
	/**选中的操作者*/
	private String operCbx;
	/**编辑类型 1 为增加,2 为修改*/
	private int editType;
	
	public int getEditType() {
		return editType;
	}
	public void setEditType(int editType) {
		this.editType = editType;
	}
	public String getRuleCbx() {
		return ruleCbx;
	}
	public void setRuleCbx(String ruleCbx) {
		this.ruleCbx = ruleCbx;
	}
	public String getOperCbx() {
		return operCbx;
	}
	public void setOperCbx(String operCbx) {
		this.operCbx = operCbx;
	}
}
