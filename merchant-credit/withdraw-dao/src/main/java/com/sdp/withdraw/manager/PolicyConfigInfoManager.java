package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PolicyConfigInfoDOExample;
import java.util.List;

public interface PolicyConfigInfoManager {
    /**
     * 根据主键删除政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    Long insert(PolicyConfigInfoDO record);

    /**
     * 添加政策配置信息【PolicyConfigInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    Long insertSelective(PolicyConfigInfoDO record);

    /**
     * 根据Example对象查询得到政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    List<PolicyConfigInfoDO> selectByExample(PolicyConfigInfoDOExample example);

    /**
     * 根据主键查询政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    PolicyConfigInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    int updateByPrimaryKeySelective(PolicyConfigInfoDO record);

    /**
     * 根据主键更新政策配置信息【PolicyConfigInfoDO】对象信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    int updateByPrimaryKey(PolicyConfigInfoDO record);

    /**
     * 根据Query对象分页查询政策配置信息【PolicyConfigInfoDO】对象列表信息
     *
     * @mbggenerated Thu Nov 17 15:03:01 CST 2016
     */
    List<PolicyConfigInfoDO> selectByQuery(PolicyConfigInfoDOExample example);
}