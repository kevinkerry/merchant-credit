package com.shengpay.debit.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.service.OrgCreditSettingService;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;
import com.shengpay.debit.ext.daointerface.ExtDbOrgCreditSettingDAO;

@Service
public class OrgCreditSettingServiceImpl implements OrgCreditSettingService {

	@Autowired
	private ExtDbOrgCreditSettingDAO orgCreditSettingDAO;

	/**
	 * 获得机构下所有的评级
	 * 
	 * @param orgCode机构码
	 * **/
	public List<DbOrgCreditSettingPO> getAllRiskLevelByOrgCode(String orgCode) {
		DbOrgCreditSettingExample example = new DbOrgCreditSettingExample();
		example.setOrderByClause(" RISK_LEVEL asc ");
		example.createCriteria().andOrgnizationCodeEqualTo(orgCode);
		return this.orgCreditSettingDAO.selectByExample(example);
	}

	public DbOrgCreditSettingPO selectByRiskLevel(String riskLevel) {
		return this.orgCreditSettingDAO.selectByRiskLevel(DebitOrganizationEnum.SFT.code, riskLevel);
	}

	/**
	 * 分页查询
	 */
	@Override
	public void selectByQuery(DbOrgCreditSettingDTO query) {
		this.setCriteria(query.getExample(), query.getPo());
		this.orgCreditSettingDAO.selectByQuery(query);
	}

	@Override
	public DbOrgCreditSettingPO selectByPrimaryKey(Long id) {
		return this.orgCreditSettingDAO.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DbOrgCreditSettingPO config) {
		return this.orgCreditSettingDAO.updateByPrimaryKeySelective(config);
	}

	@Override
	public Long insert(DbOrgCreditSettingPO config) {
		return this.orgCreditSettingDAO.insert(config);
	}

	private void setCriteria(DbOrgCreditSettingExample example, DbOrgCreditSettingPO po) {
		DbOrgCreditSettingExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(po.getRiskLevel())) {
			criteria.andRiskLevelEqualTo(po.getRiskLevel());
		}
	}
}
