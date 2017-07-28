package com.sdp.mc.intra.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WalletWithdrawStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.entity.WalletWithdrawReqDTO;
import com.sdp.withdraw.entity.WalletWithdrawReqPO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.service.WithdrawReqService;
import com.shengpay.service.view.MerchantInfoService;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;
import com.shengpay.service.withdraw.wallet.worker.WalletWithdrawHandler;

@Controller
@RequestMapping("/wallet/withdraw")
public class WalletWithdrawManageAction {

	private static final Logger log = LoggerFactory.getLogger(WalletWithdrawManageAction.class);

	@Autowired
	private WalletWithdrawService walletWithdrawService;
	@Autowired
	private WalletWithdrawHandler walletWithdrawHandler;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private WithdrawReqService withdrawReqService;

	@Autowired
	protected Mapper beanMapper;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/walletwithdraw/index";
	}

	@RequestMapping(value = "/list")
	public String list(@ModelAttribute("query") WalletWithdrawReqDTO query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.getExample().setOrderByClause(" UPDATE_TIME DESC");
		List<WalletWithdrawReqDO> list = this.walletWithdrawService.selectByQuery(query);
		if (list != null) {
			List<WalletWithdrawReqPO> listPo = new ArrayList<WalletWithdrawReqPO>();
			for (WalletWithdrawReqDO info : list) {
				WalletWithdrawReqPO po = beanMapper.map(info, WalletWithdrawReqPO.class);
				listPo.add(po);
			}
			query.setPageList(listPo);
		}
		model.put("query", query.getExample());
		model.put("result", query.getPageList());
		return "/walletwithdraw/list";
	}

	@RequestMapping(value = "/initiateWithdraw")
	@ResponseBody
	public ErrorMessageVO initiateWithdraw(Long reqId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName() + ":" + user.getRealName();
		log.info("initiateWithdraw operator:{},reqId:{}", new Object[] { operatorId, reqId });
		try {
			WalletWithdrawReqDO reqDo = this.walletWithdrawService.queryWalletWithdrawReqByReqId(reqId);
			if (reqDo != null && reqDo.getTraceNo() == null) {
				if (PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(reqDo.getMemberType())
						|| PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(reqDo.getMemberType())) {
					ViewMerchantInfoDTO merchantInfo = merchantInfoService.queryMerchantInfoByMerchantNo(reqDo.getMemberNo(), reqDo.getMemberType());
					if (merchantInfo != null) {
						if (MerchantCreditConstant.FAST_SETTLE_FLAG_OPEN_INT == merchantInfo.getAutoFastSettleFlag()) {
							log.info("applyWithdraw call Wallet withdraw thread");
							walletWithdrawHandler.execute(reqDo, WithdrawConstant.withdrawTypeRealTime);
							return new ErrorMessageVO(true);
						}
					}

				}
			}
			error.setErrorCode("-1");
			error.setErrorMessage("不满足发起出款的条件");
		} catch (Exception e) {
			log.error("#initiateWithdraw Exception", e);
			error.setSuccess(false);
			error.setErrorCode("-1");
			error.setErrorMessage("操作发生异常");
		}
		return error;
	}

	@RequestMapping(value = "/syncStatus")
	@ResponseBody
	public ErrorMessageVO syncStatus(Long reqId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName() + ":" + user.getRealName();
		log.info("initiateWithdraw operator:{},reqId:{}", new Object[] { operatorId, reqId });
		try {
			WalletWithdrawReqDO reqDo = this.walletWithdrawService.queryWalletWithdrawReqByReqId(reqId);
			if (reqDo != null && reqDo.getTraceNo() != null && WalletWithdrawStatusEnums.WAITTING.code == reqDo.getStatus()) {
				WithdrawReqDO withdrawReq = withdrawReqService.queryWithdrawReqByReqId(reqDo.getTraceNo());
				if (withdrawReq != null
						&& (WithdrawReqStatusEnums.FAIL.code.equals(withdrawReq.getStatus()) || WithdrawReqStatusEnums.SUCCESS.code
								.equals(withdrawReq.getStatus()))) {
					withdrawReqService.initiateCallback(reqDo.getTraceNo(), null);
					return new ErrorMessageVO(true);
				}
			}
			error.setErrorCode("-1");
			error.setErrorMessage("不满足同步状态的条件");
		} catch (Exception e) {
			log.error("#initiateWithdraw Exception", e);
			error.setSuccess(false);
			error.setErrorCode("-1");
			error.setErrorMessage("操作发生异常");
		}
		return error;
	}

	@RequestMapping(value = "/updateFailDealWith")
	@ResponseBody
	public ErrorMessageVO updateFailDealWith(Long reqId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		ErrorMessageVO error = new ErrorMessageVO(false);
		ActAdminUserDO user = SecurityUserHolder.getAuthUser().getUser();
		String operatorId = user.getUserName() + ":" + user.getRealName();
		log.info("initiateWithdraw operator:{},reqId:{}", new Object[] { operatorId, reqId });
		try {
			WalletWithdrawReqDO reqDo = this.walletWithdrawService.queryWalletWithdrawReqByReqId(reqId);
			if (WalletWithdrawStatusEnums.FAIL.code == reqDo.getStatus()) {
				int num = walletWithdrawService.updateDataStatus(reqId, WalletWithdrawStatusEnums.FAIL.code,
						WalletWithdrawStatusEnums.FAIL_DEALWITH.code);
				if (num > 0) { return new ErrorMessageVO(true); }
			}
			error.setErrorCode("-1");
			error.setErrorMessage("更新失败");
		} catch (Exception e) {
			log.error("#initiateWithdraw Exception", e);
			error.setSuccess(false);
			error.setErrorCode("-1");
			error.setErrorMessage("操作发生异常");
		}
		return error;
	}

}
