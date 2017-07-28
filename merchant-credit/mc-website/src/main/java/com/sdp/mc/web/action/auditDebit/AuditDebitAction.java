package com.sdp.mc.web.action.auditDebit;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.enums.Result;
import com.sdp.mc.common.util.RequestUtils;
import com.sdp.mc.common.vo.ReturnObj;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.web.action.BaseAction;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantCreditLinesApplyExample;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;

/**
 * 代理商额度审核
 */
@Controller
@RequestMapping(value = {"/posPromoter", "/mposPromoter"})
public class AuditDebitAction extends BaseAction {

	private static Logger log = LoggerFactory.getLogger(AuditDebitAction.class);
	private static final String MESSAGE = "message";

	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;

	@RequestMapping(value = "/auditdebit/queryCreditLinesApply")
	public String auditDebitIndex(ExtDoMerchantCreditLinesApplyExample query, HttpServletRequest request, ModelMap model) throws IOException {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		query.setPromoterNo(user.getMerchantNo());
		query.setPageSize(10);
		/* 这里需要加上状态不等于0 的限制*/
		query.setApplyStatus(CreditLinesApplyStatusEnums.USER_MODIFY.getKey());
		// 需要承诺担保的才能查询出来
		query.setIsNeedAgentGuarantee("1");
		List<DoMerchantCreditLinesApplyPO> dataList = doMerchantCreditLinesApplyDAO.pageQueryDebitApplyMerchants(query);
		/*状态转中文*/
		for (int i = 0; i < dataList.size(); i++) {
			DoMerchantCreditLinesApplyPO datai=dataList.get(i);
			dataList.get(i).setApplyStatus(CreditLinesApplyStatusEnums.parse(datai.getApplyStatus()).getDesc());
		}
		model.put("dataList", dataList);
		model.put("query", query);
		return "/main/debit/audit/audit";
	}

	@RequestMapping(value = "/auditdebit/audit")
	public void auditDebit(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> maps = new HashMap<String, Object>();

		String id = request.getParameter("id");
		String guarantee = request.getParameter("guarantee"); // 是否担保

		if (StringUtils.isEmpty(id) || StringUtils.isEmpty(guarantee)) {
			maps.put(MESSAGE, "无效的参数");
			billReturnObject(response, Result.FAILURE.getState(), maps);
			return;
		}
		try {
			DoMerchantCreditLinesApplyPO record = doMerchantCreditLinesApplyDAO.selectByPrimaryKey(Long.valueOf(id));
			record.setIsAgnetGuarantee(guarantee);
			/**
			 * 不论页面点击是或者否更新状态为2
			 */
			record.setApplyStatus(CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.getKey());
			record.setMerchantApplyAgentTime(new Date());//该字段修改为代理商操作时间
			record.setUpdateTime(new Date());
			// TODO乐观所更新
			int row = doMerchantCreditLinesApplyDAO.updateByPrimaryKeySelective(record);
			if (row > 0) {
				maps.put(MESSAGE, "操作成功");
				billReturnObject(response, Result.OK.getState(), maps);
			} else {
				maps.put(MESSAGE, "操作失败");
				billReturnObject(response, Result.FAILURE.getState(), maps);
			}
			return;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			maps.put(MESSAGE, "系统异常");
			billReturnObject(response, Result.ERROR.getState(), maps);
		}
		return;
	}

	@RequestMapping(value = "/auditdebit/applyInfo")
	public String applyInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		DoMerchantCreditLinesApplyPO doMerchantCreditLinesApplyPO = doMerchantCreditLinesApplyDAO.selectByPrimaryKey(Long.valueOf(id));
		model.put("merchantCreditLinesApplyPO", doMerchantCreditLinesApplyPO);
		return "/main/debit/audit/applyInfo";
	}

	@RequestMapping(value = "/auditdebit/agreement")
	public String agreement(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		DoMerchantCreditLinesApplyPO doMerchantCreditLinesApplyPO = doMerchantCreditLinesApplyDAO.selectByPrimaryKey(Long.valueOf(id));
		model.put("merchantCreditLinesApplyPO", doMerchantCreditLinesApplyPO);
		return "/main/debit/audit/agreement";
	}

	private void billReturnObject(HttpServletResponse response, int code, Map<String, Object> obj) {
		ReturnObj returnObj = new ReturnObj();
		returnObj.setCode(code);
		returnObj.setResult(obj);
		RequestUtils.writeJson(response, returnObj);
	}

}
