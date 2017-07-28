package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample;
import java.util.List;

public interface MessageTemplateManager {
    /**
     * 根据主键删除短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    Long insert(MessageTemplateDO record);

    /**
     * 添加短信模板表【MessageTemplateDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    Long insertSelective(MessageTemplateDO record);

    /**
     * 根据Example对象查询得到短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    List<MessageTemplateDO> selectByExample(MessageTemplateDOExample example);

    /**
     * 根据主键查询短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    MessageTemplateDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int updateByPrimaryKeySelective(MessageTemplateDO record);

    /**
     * 根据主键更新短信模板表【MessageTemplateDO】对象信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    int updateByPrimaryKey(MessageTemplateDO record);

    /**
     * 根据Query对象分页查询短信模板表【MessageTemplateDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 12:52:14 CST 2015
     */
    List<MessageTemplateDO> selectByQuery(MessageTemplateDOExample example);
}