package com.sdp.mc.intra.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.bean.MessageTemplateBean;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.shengpay.service.message.MessageService;

@Controller
@RequestMapping("/msgTemplate")
public class MessageTemplateAction {
	private static final Logger logger = LoggerFactory.getLogger(MessageTemplateAction.class);
	@Autowired
	private MessageService messageService;
	/**
	 * 初始化查询页面
	 * **/
	@RequestMapping(value = "/index")
	public String initTemplateIndex(HttpServletRequest request, ModelMap model) {
		logger.info("MessageTemplateAction#index is start");
		return "/temp/index";
	}

	/**
	 *
	 * 借款查询ajaxPaging/borrowList
	 *
	 * @param queryParam
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/ajaxPaging/tempList")
	public String tempList(MessageTemplateBean queryParam, HttpServletRequest request, ModelMap model) {
		logger.info("MessageTemplateAction#tempList queryParam=" + queryParam);
		List<MessageTemplateDO> dataList = null;
		try {
			queryParam.setPageSize(20);
			dataList=messageService.selectMsgTemplateList(queryParam);
			model.put("dataList", dataList);
		} catch (Exception e) {
			// 用log替换
			logger.error("MessageTemplateAction# tempList is error" + e.getMessage(),e);
			dataList = new ArrayList<MessageTemplateDO>();
			model.put("msg", "查询异常"+e.getMessage());
		}

		model.put("query", queryParam);
		return "/temp/tempList";
	}
	@RequestMapping(value = "/tempDetail")
	public String tempDetail(HttpServletRequest request, ModelMap model){
		String id=request.getParameter("id");
		try {
			MessageTemplateDO tempDo=messageService.selectByPrimaryKey(Long.valueOf(id));
			model.put("tempDo", tempDo);
		} catch (Exception e) {
			logger.error("MessageTemplateAction# tempDetail is error" + e.getMessage(),e);
			model.put("msg", "异常"+e.getMessage());
		}
		return "/temp/tempDetail";
	}
	@RequestMapping(value = "/saveUpdate")
	@ResponseBody
	public ErrorMessageVO<Object> saveUpdate(MessageTemplateDO record,HttpServletRequest request, ModelMap model){
		logger.info("MessageTemplateAction#tempList record=" + record);
		try {
			String operator = SecurityUserHolder.getAuthUser().getUser().getRealName();
			String operatorId = SecurityUserHolder.getAuthUser().getUser().getUserName();
			record.setOperator(operator);
			record.setOperatorId(operatorId);
		    boolean flag=messageService.updateMsgTemplate(record);
		    if(!flag){
		    	model.put("msg", "操作失败");
		    	return new ErrorMessageVO<Object>(false,"操作失败","操作失败");
		    }
		    MessageTemplateDO tempDo=messageService.selectByPrimaryKey(record.getId());
			model.put("data", tempDo);
			return new ErrorMessageVO<Object>(true,"0","保存成功");
		} catch (Exception e) {
		  logger.error("MessageTemplateAction# saveUpdate is error" + e.getMessage(),e);
		  model.put("msg", "保存操作异常"+e.getMessage());
		  return new ErrorMessageVO<Object>(false,"-1","保存操作异常"+e.getMessage());
		}

	}
}
