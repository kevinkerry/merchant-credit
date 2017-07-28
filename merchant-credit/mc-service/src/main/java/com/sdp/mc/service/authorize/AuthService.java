package com.sdp.mc.service.authorize;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sdp.mc.dao.authorize.RoleEO;
import com.sdp.mc.dao.authorize.RoleQueryCond;
import com.sdp.mc.dao.authorize.RuleEO;
import com.shengpay.commons.core.base.PaginationBaseObject;

/**
 * 权限操作接口
 * 
 * @author zhangmeng.michael
 * 
 */
public interface AuthService {

	/**
	 * 获取所有的权限
	 * 
	 * @return RuleEO集合
	 */
	List<RuleEO> getAllRules();

	/**
	 * 获取所有的权限，url对应关系
	 * 
	 * @return key为权限代码, value 为对应的url
	 */
	Map<String, Set<String>> getAllRuleUrl();

	/**
	 * 保存角色
	 * 
	 * @param to
	 */
	void saveRole(RoleTO to);

	/**
	 * 更新角色
	 * 
	 * @param to
	 */
	void updateRole(RoleTO to);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 */
	void deleteRole(long roleId);

	/**
	 * 判断角色名是否存在
	 * 
	 * @param eo
	 * @return
	 */
	boolean isRoleExist(RoleEO eo);

	/**
	 * 分页查询
	 * 
	 * @param cond
	 * @return
	 */
	PaginationBaseObject<RoleEO> getRoles(RoleQueryCond cond);

	/**
	 * 根据ID获取角色
	 * 
	 * @param roleId
	 * @return
	 */
	RoleEO getRoleById(long roleId);

	/**
	 * 获取角色下对应的rule
	 * 
	 * @param roleId
	 * @return
	 */
	List<Long> getRuleListByRoleId(long roleId);

	/**
	 * 获取角色下的操作员
	 * 
	 * @param roleId
	 * @return
	 */
	List<String> getOperListByRoleId(long roleId);

	/**
	 * 获取操作员对应的权限
	 * 
	 * @param operaterId
	 * @return
	 */
	Map<String, String> getAllRules(String operaterId);

	void init();

	List<String> getAllRuleTypes();

	void loadAuthInfo();

}
