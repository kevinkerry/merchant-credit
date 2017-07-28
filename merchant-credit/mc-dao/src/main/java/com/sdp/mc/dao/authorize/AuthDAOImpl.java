package com.sdp.mc.dao.authorize;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;
/**
 * AuthDAO
 * @author zhangmeng.michael
 *
 */
@Repository("AuthDAO")
public class AuthDAOImpl implements AuthDAO{

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
	
	protected IbatisBaseDAOImpl ibatisTemplete;
	/**
	 * 根据id查询
	 */
	public RoleEO selectById( Long id ){
		Object o = ibatisTemplete.queryForObject( "RoleDAO.selectById", id );
		return o == null? null : ( RoleEO )o;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RuleEO> getAllRules() {
		List<RuleEO> list = ibatisTemplete.queryForList("AuthDAO.getAllRules");
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getAllRuleUrl() {
		List<Map<String,String>> list = ibatisTemplete.queryForList("AuthDAO.getRuleUrl");
		return list;
	}

	@Override
	public long saveRole(RoleEO role) {
		ibatisTemplete.insert("AuthDAO.insertRole",role);
		return role.getId();
	}

	@Override
	public void saveRoleRule(Map<String,Object> map) {
		ibatisTemplete.insert("AuthDAO.insertRoleRule", map);
	}

	@Override
	public void saveRoleOper(Map<String,Object> map) {
		ibatisTemplete.insert("AuthDAO.insertRoleOper", map);
	}

	@Override
	public void deleteRoleRule(long roleId) {
		ibatisTemplete.delete("AuthDAO.deleteRoleRule", roleId);
	}

	@Override
	public void deleteRoleOper(long roleId) {
		ibatisTemplete.delete("AuthDAO.deleteRoleOper", roleId);
	}

	@Override
	public int getRoleCountByName(RoleEO eo) {
		return (Integer)ibatisTemplete.queryForObject("AuthDAO.getRoleNumByName", eo);
	}

	@Override
	public void deleteRole(long roleId) {
		ibatisTemplete.delete("AuthDAO.deleteRole", roleId);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<RoleEO> getRoles(RoleQueryCond cond) {
		return (List<RoleEO>)ibatisTemplete.queryForList( "AuthDAO.getRoles", cond, ( cond.getPageNo() - 1 ) * cond.getPageSize(), cond.getPageSize() );
	}

	@Override
	public int getRoleCount(RoleQueryCond cond) {
		return (Integer)ibatisTemplete.queryForObject("AuthDAO.getRoleCount",cond);
	}

	@Override
	public RoleEO getRoleById(long roleId) {
		return (RoleEO)ibatisTemplete.queryForObject("AuthDAO.getRoleById", roleId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> getRuleListByRoleId(long roleId) {
		return ibatisTemplete.queryForList("AuthDAO.getRuleListByRoleId",roleId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getOperListByRoleId(long roleId) {
		return ibatisTemplete.queryForList("AuthDAO.getOperListByRoleId",roleId);
	}

	@Override
	public void updateRole(RoleEO role) {
		ibatisTemplete.update("AuthDAO.updateRole",role);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getAllRules(String operaterId) {
		List<Map<String,String>> list = ibatisTemplete.queryForList("AuthDAO.getOperatorRule",operaterId);
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> getAllRuleTypes() {
		List<Map<String,String>> list = ibatisTemplete.queryForList("AuthDAO.getAllRuleType");
		return list;
	}
}
