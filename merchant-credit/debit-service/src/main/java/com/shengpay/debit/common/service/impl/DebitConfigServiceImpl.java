package com.shengpay.debit.common.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.cache.util.MemCacheUtil;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.dal.dataobject.DbNormalSettingExample;
import com.shengpay.debit.dal.dataobject.DbNormalSettingPO;
import com.shengpay.debit.dal.ext.dataobject.DbNormalSettingDTO;
import com.shengpay.debit.ext.daointerface.ExtDbNormalSettingDAO;

/**
 * 查询配置文件信息
 *
 * @author heyi.alex
 *
 */
@Service
public class DebitConfigServiceImpl implements DebitConfigService {
	private static final Logger log = LoggerFactory.getLogger( DebitConfigServiceImpl.class );
	private Integer memcacheTime= Integer.parseInt(GlobalConfig.getString("ttd.memcache.time","120"));
	@Autowired
	private ExtDbNormalSettingDAO dbNormalSettingDAO;

	/**
	 * 获取参数配置
	 *
	 * @param enums
	 * @return
	 */
	public String getByKey(ConfigEnums enums) {
		try {
			log.info("DebitConfigServiceImpl.getKey.start");
			Object obj = MemCacheUtil.getValueFromMemCache(enums.getKey());
			if (obj != null){
				log.info("DebitConfigServiceImpl.getKey.obj="+obj);
				return obj.toString();
			}
			DbNormalSettingExample example = new DbNormalSettingExample();
			DbNormalSettingExample.Criteria criteria = example.createCriteria();
			criteria.andSettingKeyEqualTo(enums.getKey());
			List<DbNormalSettingPO> list = null;
			list = this.dbNormalSettingDAO.selectByExample(example);
			log.info("DebitConfigServiceImpl.getKey.list"+ToStringBuilder.reflectionToString(list));
			if (list != null && list.size() > 0) {
				log.info("DebitConfigServiceImpl.getKey.list is not null");
				MemCacheUtil.putValueIntoMemCache(enums.getKey(), memcacheTime, list.get(0).getSettingValue());
				return list.get(0).getSettingValue();
			}
		} catch (Exception e) {
			log.info("DebitConfigServiceImpl.getKey.error",e);
			return null;
		}
		return null;



	}

	/**
	 * 分页查询
	 */
	@Override
	public void selectByQuery(DbNormalSettingDTO query) {
		this.setCriteria(query.getExample(), query.getPo());
		this.dbNormalSettingDAO.selectByQuery(query);
	}

	@Override
	public DbNormalSettingPO selectByPrimaryKey(Long id) {
		return this.dbNormalSettingDAO.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(DbNormalSettingPO config) {
		return this.dbNormalSettingDAO.updateByPrimaryKeySelective(config);
	}

	@Override
	public Long insert(DbNormalSettingPO config) {
		return this.dbNormalSettingDAO.insert(config);

	}

	/**
	 * 设置查询条件
	 *
	 * @param example
	 * @param po
	 */
	private void setCriteria(DbNormalSettingExample example, DbNormalSettingPO po) {
		DbNormalSettingExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(po.getSettingKey())) {
			criteria.andSettingKeyEqualTo(po.getSettingKey());
		}
	}

}
