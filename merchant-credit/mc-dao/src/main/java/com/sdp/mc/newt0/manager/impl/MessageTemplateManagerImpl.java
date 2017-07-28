package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample;
import com.sdp.mc.newt0.dao.daointerface.MessageTemplateDAO;
import com.sdp.mc.newt0.manager.MessageTemplateManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageTemplateManager")
public class MessageTemplateManagerImpl implements MessageTemplateManager {
    @Autowired
    private MessageTemplateDAO messageTemplateDAO;

    /**
     * 根据主键删除短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = messageTemplateDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public Long insert(MessageTemplateDO record) {
        Long id = messageTemplateDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public Long insertSelective(MessageTemplateDO record) {
        Long id = messageTemplateDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<MessageTemplateDO> selectByExample(MessageTemplateDOExample example) {
        List<MessageTemplateDO> list = messageTemplateDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public MessageTemplateDO selectByPrimaryKey(Long id) {
        MessageTemplateDO record = messageTemplateDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(MessageTemplateDO record) {
        int rows = messageTemplateDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public int updateByPrimaryKey(MessageTemplateDO record) {
        int rows = messageTemplateDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    @Override
    public List<MessageTemplateDO> selectByQuery(MessageTemplateDOExample example) {
        Integer totalItem = (Integer)messageTemplateDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<MessageTemplateDO> returnList = new ArrayList<MessageTemplateDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<MessageTemplateDO> list =messageTemplateDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}