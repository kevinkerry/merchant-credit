package com.sdp.mc.fos.manager;

import com.sdp.mc.fos.dao.MarginTransDO;
import com.sdp.mc.fos.dao.MarginTransDOExample;
import java.util.List;

public interface MarginTransManager {
    /**
     * 根据主键删除保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    int deleteByPrimaryKey(Long mtId);

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    Long insert(MarginTransDO record);

    /**
     * 添加保证金转账记录【MarginTransDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    Long insertSelective(MarginTransDO record);

    /**
     * 根据Example对象查询得到保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    List<MarginTransDO> selectByExample(MarginTransDOExample example);

    /**
     * 根据主键查询保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    MarginTransDO selectByPrimaryKey(Long mtId);

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    int updateByPrimaryKeySelective(MarginTransDO record);

    /**
     * 根据主键更新保证金转账记录【MarginTransDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    int updateByPrimaryKey(MarginTransDO record);

    /**
     * 根据Query对象分页查询保证金转账记录【MarginTransDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    List<MarginTransDO> selectByQuery(MarginTransDOExample example);
    
    /**
     * 根据Example对象更新保证金转账记录【MarginTransDO】对象信息，仅更新非空字段
     *
     * @mbggenerated Mon Mar 30 13:57:58 CST 2015
     */
    public int updateByExampleSelective(MarginTransDO record, MarginTransDOExample example);
}