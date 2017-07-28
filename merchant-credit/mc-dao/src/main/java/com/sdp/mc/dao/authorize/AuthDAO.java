package com.sdp.mc.dao.authorize;

import java.util.List;
import java.util.Map;

/**
 * 权限DAO
 * @author zhangmeng.michael
 *
 */
public interface AuthDAO {
	
	/**
	 * 获取所有的权限
	 * @return RuleEO集合
	 */
	List<RuleEO> getAllRules();
	/**
	 * 获取所有的权限，url对应关系
	 * @return key为权限代码, value 为对应的url
	 */
	List<Map<String, String>>getAllRuleUrl();
	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	long saveRole(RoleEO role);
	/**
	 * 更新角色
	 * @param role
	 */
	void updateRole(RoleEO role);
	/**
	 * 保存角色-权限
	 * @param map
	 */
	void saveRoleRule(Map<String,Object> map);
	/**
	 * 保存角色-操作员
	 * @param map
	 */
	void saveRoleOper(Map<String,Object> map);
	/**
	 * 删除角色对应的权限
	 * @param roleId
	 */
	void deleteRoleRule(long roleId);
	/**
	 * 删除角色对应的操作员
	 * @param roleId
	 */
	void deleteRoleOper(long roleId);
	/**
	 * 删除角色
	 * @param roleId
	 */
	void deleteRole(long roleId);
	/**
	 * 获取指定角色名的角色个数
	 * @param EO
	 * @return
	 */
	int getRoleCountByName(RoleEO EO);
	/**
	 * 获取符合条件的角色个数
	 * @param cond
	 * @return
	 */
	int getRoleCount(RoleQueryCond cond);
	/**
	 * 根据条件获取角色
	 * @param cond
	 * @return
	 */
	List<RoleEO> getRoles(RoleQueryCond cond);
	/**
	 * 根据Id获取角色
	 * @param roleId
	 * @return
	 */
	RoleEO getRoleById(long roleId);
	/**
	 * 根据角色获取对应的权限
	 * @param roleId
	 * @return
	 */
	List<Long>getRuleListByRoleId(long roleId);
	/**
	 * 根据角色获取对应的操作员
	 * @param roleId
	 * @return
	 */
	List<String>getOperListByRoleId(long roleId);
	/**
	 * 获取操作员对应的权限
	 * @param operaterId
	 * @return
	 */
	List<Map<String,String>>getAllRules(String operaterId);
	/**
	 * 获取所有权限分类
	 * @return
	 */
	List<Map<String,String>>getAllRuleTypes();
}
