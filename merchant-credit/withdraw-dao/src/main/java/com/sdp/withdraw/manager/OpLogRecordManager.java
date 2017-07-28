package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDOExample;
import java.util.List;

public interface OpLogRecordManager {
    /**
     * 根据主键删除操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    Long insert(OpLogRecordDO record);

    /**
     * 添加操作历史记录【OpLogRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    Long insertSelective(OpLogRecordDO record);

    /**
     * 根据Example对象查询得到操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    List<OpLogRecordDO> selectByExample(OpLogRecordDOExample example);

    /**
     * 根据主键查询操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    OpLogRecordDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    int updateByPrimaryKeySelective(OpLogRecordDO record);

    /**
     * 根据主键更新操作历史记录【OpLogRecordDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    int updateByPrimaryKey(OpLogRecordDO record);

    /**
     * 根据Query对象分页查询操作历史记录【OpLogRecordDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:57 CST 2016
     */
    List<OpLogRecordDO> selectByQuery(OpLogRecordDOExample example);
}