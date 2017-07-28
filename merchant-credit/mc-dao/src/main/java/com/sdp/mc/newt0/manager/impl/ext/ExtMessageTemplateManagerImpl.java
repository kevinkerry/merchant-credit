package com.sdp.mc.newt0.manager.impl.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.bean.MessageTemplateBean;
import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample.Criteria;
import com.sdp.mc.newt0.dao.daointerface.MessageTemplateDAO;
@Service
public class ExtMessageTemplateManagerImpl {
    @Autowired
    private MessageTemplateDAO messageTemplateDAO;
	public List<MessageTemplateDO> selectByQuery(MessageTemplateBean queryBean) {
		//拼接查询对象
	    MessageTemplateDOExample example=new MessageTemplateDOExample();
	    Criteria criteria=example.createCriteria();
		if(StringUtils.isNotBlank(queryBean.getExt1())){
		  queryBean.setExt1("%"+queryBean.getExt1()+"%");
		  criteria.andExt1Like(queryBean.getExt1());
		}
		if(StringUtils.isNotBlank(queryBean.getTemplateCode())){
		  queryBean.setTemplateCode("%"+queryBean.getTemplateCode()+"%");
		  criteria.andTemplateCodeLike(queryBean.getTemplateCode());
		}
		example.setOrderByClause("id asc");
		example.setPageSize(queryBean.getPageSize());
        Integer totalItem = (Integer)messageTemplateDAO.countByExample(example);
        example.setTotalItem(totalItem);
        queryBean.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
             	queryBean.setPageSize(totalItem);
        }
        List<MessageTemplateDO> returnList = new ArrayList<MessageTemplateDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<MessageTemplateDO> list =messageTemplateDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}
