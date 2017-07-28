package com.sdp.mc.service.authorize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.authorize.AuthDAO;
import com.sdp.mc.dao.authorize.RoleEO;
import com.sdp.mc.dao.authorize.RoleQueryCond;
import com.sdp.mc.dao.authorize.RuleEO;
import com.shengpay.commons.core.base.PaginationBaseObject;

/**
 * 权限操作service
 * 
 * @author zhangmeng.michael
 *
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AuthDAO dao;

	@Override
	public void init() {
		logger.info("------init auth start....");
		loadAuthInfo();
		AuthHelper.timerUpdate();
		logger.info("------init auth end....");
	}

	@Override
	public void loadAuthInfo() {
		logger.info("------loadAuthInfo start....");
		AuthHelper.initRuleType(this.getAllRuleTypes());
		AuthHelper.initRule(this.getAllRules());
		AuthHelper.initRuleURL(this.getAllRuleUrl());
		logger.info("------ loadAuthInfo end....");
	}


	@Override
	public List<RuleEO> getAllRules() {
		return dao.getAllRules();
	}

	@Override
	public Map<String, Set<String>> getAllRuleUrl() {
		Map<String, Set<String>> resMap = new HashMap<String, Set<String>>();
		List<Map<String, String>> list = dao.getAllRuleUrl();
		for (Map<String, String> map : list) {
			String code = map.get("rule_code_v");
			String value = map.get("url_value_v");
			if (value != null && value.indexOf(".") > 0) {
				value = value.substring(0, value.indexOf("."));
			}

			if (!resMap.containsKey(value)) {
				resMap.put(value, new HashSet<String>());
			}
			resMap.get(value).add(code);
		}
		return resMap;
	}

	@Override
	public void saveRole(RoleTO to) {
		RoleEO eo = new RoleEO();
		BeanUtils.copyProperties(to, eo);
		long roleId = dao.saveRole(eo);
		saveOther(roleId, to);
	}

	/**
	 * 保存权限及操作者
	 * 
	 * @param roleId
	 * @param to
	 */
	private void saveOther(long roleId, RoleTO to) {
		String rules = to.getRuleCbx();
		String opers = to.getOperCbx();
		String[] arrRules = rules.split(",");
		String[] arrOpers = opers.split(",");

		Map<String, Object> tmpMap = new HashMap<String, Object>();

		for (String ruleId : arrRules) {
			tmpMap.put("roleId", roleId);
			tmpMap.put("memberId", to.getMemberId());
			tmpMap.put("ruleId", ruleId);
			dao.saveRoleRule(tmpMap);
		}
		for (String operId : arrOpers) {
			tmpMap.put("roleId", roleId);
			tmpMap.put("memberId", to.getMemberId());
			tmpMap.put("operId", operId);
			dao.saveRoleOper(tmpMap);
		}
	}

	@Override
	public void deleteRole(long roleId) {
		dao.deleteRoleRule(roleId);
		dao.deleteRoleOper(roleId);
		dao.deleteRole(roleId);
	}

	@Override
	public boolean isRoleExist(RoleEO eo) {
		int count = dao.getRoleCountByName(eo);
		return count == 0 ? false : true;
	}

	@Override
	public PaginationBaseObject<RoleEO> getRoles(RoleQueryCond cond) {
		PaginationBaseObject<RoleEO> pbo = new PaginationBaseObject<RoleEO>();

		int count = dao.getRoleCount(cond);
		if (count == 0) {
			pbo.setDataList(new ArrayList<RoleEO>());
		} else {
			int maxPageNo = (count / cond.getPageSize()) + (count % cond.getPageSize() > 0 ? 1 : 0);
			if (cond.getPageNo() > maxPageNo) {
				cond.setPageNo(maxPageNo);
			}
			pbo.setDataList(dao.getRoles(cond));
		}
		pbo.setPagination(count, cond.getPageSize(), cond.getPageNo());
		return pbo;
	}

	@Override
	public RoleEO getRoleById(long roleId) {
		return dao.getRoleById(roleId);
	}

	@Override
	public List<Long> getRuleListByRoleId(long roleId) {
		return dao.getRuleListByRoleId(roleId);
	}

	@Override
	public List<String> getOperListByRoleId(long roleId) {
		return dao.getOperListByRoleId(roleId);
	}

	@Override
	public void updateRole(RoleTO to) {
		RoleEO eo = new RoleEO();
		BeanUtils.copyProperties(to, eo);
		dao.updateRole(eo);
		long roleId = eo.getId();
		dao.deleteRoleOper(roleId);
		dao.deleteRoleRule(roleId);
		saveOther(roleId, to);
	}

	@Override
	public Map<String, String> getAllRules(String operaterId) {
		Map<String, String> map = new HashMap<String, String>();
		List<Map<String, String>> res = dao.getAllRules(operaterId);
		if (res != null) {
			for (Map<String, String> m : res) {
				String menuCode = m.get("menu_code");
				String subCode = m.get("sub_code");
				map.put(menuCode, "menu");
				map.put(subCode, "sub");
			}
		}
		return map;
	}

	@Override
	public List<String> getAllRuleTypes() {
		List<String> list = new ArrayList<String>();
		List<Map<String, String>> rList = dao.getAllRuleTypes();
		if (rList != null) {
			for (Map<String, String> map : rList) {
				list.add(map.get("type"));
			}
		}
		return list;
	}
}
