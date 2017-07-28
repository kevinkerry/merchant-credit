package com.shengpay.debit.common.service;

import java.util.List;

import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbOrgCreditSettingDTO;

/**
 * 机构放款额度配置
 * @author wangjingao.william
 * **/
public interface OrgCreditSettingService {

	/**
	 * 获得机构下所有的评级
	 * @param orgCode机构码
	 * **/
	public List<DbOrgCreditSettingPO> getAllRiskLevelByOrgCode(String orgCode);

	public DbOrgCreditSettingPO selectByRiskLevel(String riskLevel);

	/**
	 * 分页查询
	 */
	public void selectByQuery(DbOrgCreditSettingDTO query);

	public DbOrgCreditSettingPO selectByPrimaryKey(Long id);

	public int updateByPrimaryKeySelective(DbOrgCreditSettingPO config);

	public Long insert(DbOrgCreditSettingPO config);
}
