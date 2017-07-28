package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDO;
import com.sdp.mc.newt0.dao.Newt0LimitRuleInfoDOExample;
import java.util.List;

public interface Newt0LimitRuleInfoManager {
    /**
     * 根据主键删除商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    Long insert(Newt0LimitRuleInfoDO record);

    /**
     * 添加商户额度规则信息【Newt0LimitRuleInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    Long insertSelective(Newt0LimitRuleInfoDO record);

    /**
     * 根据Example对象查询得到商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    List<Newt0LimitRuleInfoDO> selectByExample(Newt0LimitRuleInfoDOExample example);

    /**
     * 根据主键查询商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    Newt0LimitRuleInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    int updateByPrimaryKeySelective(Newt0LimitRuleInfoDO record);

    /**
     * 根据主键更新商户额度规则信息【Newt0LimitRuleInfoDO】对象信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    int updateByPrimaryKey(Newt0LimitRuleInfoDO record);

    /**
     * 根据Query对象分页查询商户额度规则信息【Newt0LimitRuleInfoDO】对象列表信息
     *
     * @mbggenerated Sun Dec 20 09:53:28 CST 2015
     */
    List<Newt0LimitRuleInfoDO> selectByQuery(Newt0LimitRuleInfoDOExample example);
}