package com.sdp.mc.ffconfig.manager;

import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;

import java.util.List;

public interface FastSettleConfigManager {
	/**
	 * 根据主键删除null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	int deleteByPrimaryKey(Long pfcId);

	/**
	 * 添加null【FastSettleConfigDO】对象信息
//	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	Long insert(FastSettleConfigDO record);

	/**
	 * 添加null【FastSettleConfigDO】对象信息,空值字段不插入
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	Long insertSelective(FastSettleConfigDO record);

	/**
	 * 根据Example对象查询得到null【FastSettleConfigDO】对象列表信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	List<FastSettleConfigDO> selectByExample(FastSettleConfigDOExample example);

	/**
	 * 根据主键查询null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	FastSettleConfigDO selectByPrimaryKey(Long pfcId);

	/**
	 * 根据主键更新null【FastSettleConfigDO】对象信息，仅更新非空对象
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	int updateByPrimaryKeySelective(FastSettleConfigDO record);

	/**
	 * 根据主键更新null【FastSettleConfigDO】对象信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	int updateByPrimaryKey(FastSettleConfigDO record);

	/**
	 * 根据Query对象分页查询null【FastSettleConfigDO】对象列表信息
	 * 
	 * @mbggenerated Fri Sep 18 14:49:52 CST 2015
	 */
	List<FastSettleConfigDO> selectByQuery(FastSettleConfigDOExample example);

	List<FastSettleConfigDOExt> selectByQuery4Intra(FastSettleConfigDOExampleExt example);

	public int updateByExampleSelective(FastSettleConfigDO record, FastSettleConfigDOExample example);
	/**
	 * 根据垫资方修改自动快速结算loaningType1,status2;loaningType0,status1
	 * @param promoterId
	 * @return
	 */
	int updateByPromoterId(Long promoterId);
}