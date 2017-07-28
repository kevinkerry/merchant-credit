package com.shengpay.service.message;

import java.util.List;
import java.util.Map;

import com.sdp.mc.common.bean.MessageTemplateBean;
import com.sdp.mc.newt0.dao.MessageTemplateDO;
/**
 * 短信服务接口
 * 功能描述：
 * @author zhangyulong
 * time : 2015-9-16 下午7:33:04
 */
public interface MessageService {
    /**
     * 发送短信接口
     * @param toUserList
     * @param templateCode
     * @param paramMap
     * @return
     */
    public void sendMessage(List<String> toUserList, String templateCode, Map<String,String> paramMap);

    /**
     * 发送短信接口，单个手机号
     * @param phone
     * @param templateCode
     * @param paramMap
     * @return
     */
    public void sendOneMessage(String phone, String templateCode, Map<String,String> paramMap);
    /**
     *
     * @param queryParam
     * @return List<MessageTemplateDO>
     * @throws Exception
     */
    public List<MessageTemplateDO> selectMsgTemplateList(MessageTemplateBean queryParam) throws Exception;
	/**
	 *
	 * @param record
	 * @return boolean
	 * @throws Exception
	 */
    public boolean updateMsgTemplate(MessageTemplateDO record) throws Exception;
    /**
     * 查询单个短信模板
     * @param id
     * @return
     * @throws Exception
     */
    public MessageTemplateDO selectByPrimaryKey(Long id) throws Exception;
}
