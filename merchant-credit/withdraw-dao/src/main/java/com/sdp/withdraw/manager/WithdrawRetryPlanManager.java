package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawRetryPlanDO;
import com.sdp.withdraw.dao.WithdrawRetryPlanDOExample;
import java.util.List;

public interface WithdrawRetryPlanManager {
    /**
     * 根据主键删除出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    int deleteByPrimaryKey(Long planId);

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    Long insert(WithdrawRetryPlanDO record);

    /**
     * 添加出款服务重试计划表【WithdrawRetryPlanDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    Long insertSelective(WithdrawRetryPlanDO record);

    /**
     * 根据Example对象查询得到出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    List<WithdrawRetryPlanDO> selectByExample(WithdrawRetryPlanDOExample example);

    /**
     * 根据主键查询出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    WithdrawRetryPlanDO selectByPrimaryKey(Long planId);

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawRetryPlanDO record);

    /**
     * 根据主键更新出款服务重试计划表【WithdrawRetryPlanDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    int updateByPrimaryKey(WithdrawRetryPlanDO record);

    /**
     * 根据Query对象分页查询出款服务重试计划表【WithdrawRetryPlanDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:47 CST 2016
     */
    List<WithdrawRetryPlanDO> selectByQuery(WithdrawRetryPlanDOExample example);
}