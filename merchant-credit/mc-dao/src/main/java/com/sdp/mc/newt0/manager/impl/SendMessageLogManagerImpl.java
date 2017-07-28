package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.SendMessageLogDO;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample;
import com.sdp.mc.newt0.dao.daointerface.SendMessageLogDAO;
import com.sdp.mc.newt0.manager.SendMessageLogManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sendMessageLogManager")
public class SendMessageLogManagerImpl implements SendMessageLogManager {
    @Autowired
    private SendMessageLogDAO sendMessageLogDAO;

    /**
     * 根据主键删除短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = sendMessageLogDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public Long insert(SendMessageLogDO record) {
        Long id = sendMessageLogDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加短信发送日志表【SendMessageLogDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public Long insertSelective(SendMessageLogDO record) {
        Long id = sendMessageLogDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SendMessageLogDO> selectByExample(SendMessageLogDOExample example) {
        List<SendMessageLogDO> list = sendMessageLogDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public SendMessageLogDO selectByPrimaryKey(Long id) {
        SendMessageLogDO record = sendMessageLogDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(SendMessageLogDO record) {
        int rows = sendMessageLogDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新短信发送日志表【SendMessageLogDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int updateByPrimaryKey(SendMessageLogDO record) {
        int rows = sendMessageLogDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询短信发送日志表【SendMessageLogDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public List<SendMessageLogDO> selectByQuery(SendMessageLogDOExample example) {
        Integer totalItem = (Integer)sendMessageLogDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<SendMessageLogDO> returnList = new ArrayList<SendMessageLogDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<SendMessageLogDO> list =sendMessageLogDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}