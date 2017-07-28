package com.sdp.mc.ma.manager;

import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.dao.MarginAccountRequestDOExample;
import java.util.List;

public interface MarginAccountRequestManager {
    /**
     * 根据主键删除保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    Long insert(MarginAccountRequestDO record);

    /**
     * 添加保证金账户开户记录【MarginAccountRequestDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    Long insertSelective(MarginAccountRequestDO record);

    /**
     * 根据Example对象查询得到保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    List<MarginAccountRequestDO> selectByExample(MarginAccountRequestDOExample example);

    /**
     * 根据主键查询保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    MarginAccountRequestDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    int updateByPrimaryKeySelective(MarginAccountRequestDO record);

    /**
     * 根据主键更新保证金账户开户记录【MarginAccountRequestDO】对象信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    int updateByPrimaryKey(MarginAccountRequestDO record);

    /**
     * 根据Query对象分页查询保证金账户开户记录【MarginAccountRequestDO】对象列表信息
     *
     * @mbggenerated Thu Mar 26 16:14:14 CST 2015
     */
    List<MarginAccountRequestDO> selectByQuery(MarginAccountRequestDOExample example);
    
    public int updateByExampleSelective(MarginAccountRequestDO record, MarginAccountRequestDOExample example);
}