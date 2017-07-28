package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.SendMessageLogDO;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample;
import java.util.List;

public interface SendMessageLogManager {
    /**
     * 根据主键删除短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    Long insert(SendMessageLogDO record);

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    Long insertSelective(SendMessageLogDO record);

    /**
     * 根据Example对象查询得到短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    List<SendMessageLogDO> selectByExample(SendMessageLogDOExample example);

    /**
     * 根据主键查询短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    SendMessageLogDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int updateByPrimaryKeySelective(SendMessageLogDO record);

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int updateByPrimaryKey(SendMessageLogDO record);

    /**
     * 根据Query对象分页查询短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    List<SendMessageLogDO> selectByQuery(SendMessageLogDOExample example);
}