package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.Newt0LoaningConfigDO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDOExample;
import java.util.List;

public interface Newt0LoaningConfigManager {
    /**
     * 根据主键删除null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    Long insert(Newt0LoaningConfigDO record);

    /**
     * 添加null【Newt0LoaningConfigDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    Long insertSelective(Newt0LoaningConfigDO record);

    /**
     * 根据Example对象查询得到null【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    List<Newt0LoaningConfigDO> selectByExample(Newt0LoaningConfigDOExample example);

    /**
     * 根据主键查询null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    Newt0LoaningConfigDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新null【Newt0LoaningConfigDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    int updateByPrimaryKeySelective(Newt0LoaningConfigDO record);

    /**
     * 根据主键更新null【Newt0LoaningConfigDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    int updateByPrimaryKey(Newt0LoaningConfigDO record);

    /**
     * 根据Query对象分页查询null【Newt0LoaningConfigDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:25:02 CST 2015
     */
    List<Newt0LoaningConfigDO> selectByQuery(Newt0LoaningConfigDOExample example);
}