package com.sdp.mc.mcbizaccount.manager;

import java.util.List;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDO;
import com.sdp.mc.mcbizaccount.dao.BizApplyOpenAccountDOExample;

public interface BizApplyOpenAccountManager {
    /**
     * 根据主键删除代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    Long insert(BizApplyOpenAccountDO record);

    /**
     * 添加代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    Long insertSelective(BizApplyOpenAccountDO record);

    /**
     * 根据Example对象查询得到代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    List<BizApplyOpenAccountDO> selectByExample(BizApplyOpenAccountDOExample example);

    /**
     * 根据主键查询代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    BizApplyOpenAccountDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    int updateByPrimaryKeySelective(BizApplyOpenAccountDO record);

    /**
     * 根据主键更新代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    int updateByPrimaryKey(BizApplyOpenAccountDO record);

    /**
     * 根据Query对象分页查询代理商快速结算 开通/关闭【BizApplyOpenAccountDO】对象列表信息
     *
     * @mbggenerated Mon Jun 01 12:21:16 CST 2015
     */
    List<BizApplyOpenAccountDO> selectByQuery(BizApplyOpenAccountDOExample example);
    
    int updateByExample(BizApplyOpenAccountDO record,BizApplyOpenAccountDOExample example);
    
    int updateByExampleSelective(BizApplyOpenAccountDO record,BizApplyOpenAccountDOExample example);
    
	BizApplyOpenAccountDO getByPromoterIdAndAccountType(Long promoterId, AccountType accountType);
}