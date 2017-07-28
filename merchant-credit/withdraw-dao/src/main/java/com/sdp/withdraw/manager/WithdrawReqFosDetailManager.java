package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import java.util.List;

public interface WithdrawReqFosDetailManager {
    /**
     * 根据主键删除出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    int deleteByPrimaryKey(Long detailId);

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    Long insert(WithdrawReqFosDetailDO record);

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    Long insertSelective(WithdrawReqFosDetailDO record);

    /**
     * 根据Example对象查询得到出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    List<WithdrawReqFosDetailDO> selectByExample(WithdrawReqFosDetailDOExample example);

    /**
     * 根据主键查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    WithdrawReqFosDetailDO selectByPrimaryKey(Long detailId);

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    int updateByPrimaryKeySelective(WithdrawReqFosDetailDO record);

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    int updateByPrimaryKey(WithdrawReqFosDetailDO record);

    /**
     * 根据Query对象分页查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    List<WithdrawReqFosDetailDO> selectByQuery(WithdrawReqFosDetailDOExample example);
}