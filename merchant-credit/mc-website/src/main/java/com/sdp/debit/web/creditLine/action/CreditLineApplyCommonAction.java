package com.sdp.debit.web.creditLine.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.service.DebitApplyService;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;

@RequestMapping(value = {"/posMerchant", "/mposMerchant", "/posPromoter", "/mposPromoter"})
@Controller
public class CreditLineApplyCommonAction extends CreditLinesApplyAction {
	private static Logger log = LoggerFactory.getLogger(CreditLinesApplyAction.class);
	@Autowired
	private DebitApplyService debitApplyService;
	@Autowired
	private PromoterService promoterService;

	/**
	 * 展示申请资料详情
	 * **/
	@RequestMapping(value = {"/showApplyDetailInfo"})
	public String showApplyDetailInfo(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		try {
			// 查询最近一次申购
			DoMerchantCreditLinesApplyPO applyPO = null;
			if (id != null) {
				applyPO = this.merchantCreditLinesApplyService.selectById(id);
			} else {
				applyPO = merchantCreditLinesApplyService.getLatestCreditLines(user.getMerchantNo());
			}
			if (applyPO != null) {
				setUpdateView(model, applyPO);
			} else {
				GetCreditRiskResponseModel riskModel = creditRiskService.getCreditRiskModel();
				model.put("riskModel", riskModel);
			}
			model.put("applyPO", applyPO);

		} catch (Exception e) {
			log.error("CreditLineApplyCommonAction.showApplyDetailInfo.error,merchantNo=" + user.getMerchantNo(), e);
		}
		return "main/debit/apply/applyDetailInfo";
	}

	/**
	 * 获取更新
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/positionApplyDetail" })
	public String positionApplyDetail(Long id,HttpServletRequest request,ModelMap model) throws Exception {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		try {
			log.info("CreditLineApplyCommonAction.positionApplyDetail.start");
			if(id==null){
				log.info("CreditLineApplyCommonAction.positionApplyDetail.error.id is null");
				return "/main/exception/error";
			}
			DoMerchantCreditLinesApplyPO applyPO = debitApplyService.selectApplyById(id);
			if(applyPO==null){
				log.info("CreditLineApplyCommonAction.positionApplyDetail.applyPO is null");
				return "/main/debit/apply/positionApplyDetail";
			}
			// TODO
			//验证权限
			List<PromoterEO> poList=promoterService.queryPromoterListByMerchantNo(applyPO.getMerchantNo());
			if(poList==null||poList.size()==0){
				log.info("CreditLineApplyCommonAction.promoterService.poList applyPO.getMerchantNo="+applyPO.getMerchantNo());
				return "/main/debit/apply/positionApplyDetail";
			}else{
				boolean flag=false;
				for (PromoterEO po : poList) {
						if(po.getPromoterId().equals(user.getPromoterId())){
							log.info("CreditLineApplyCommonAction.po.getPromoterId equals user.getPromoterId po.getPromoterId="+po.getPromoterId()+"---"+" user.getPromoterId="+user.getPromoterId());
							flag=true;
							break;
						}
					}

				if(flag==false){
					log.info("CreditLineApplyCommonAction.promoterService.poList flag false");
					return "/main/debit/apply/positionApplyDetail";
				}

			}

			model.put("applyPo", applyPO);
			CreditLineApplyRequest creditLineApplyRequest= debitApplyService.getCreditLineApplyRequest(applyPO);
			model.put("creditLineApplyRequest", creditLineApplyRequest);
			return "/main/debit/apply/positionApplyDetail";
		} catch (Exception e) {
			log.error("CreditLineApplyCommonAction.positionApplyDetail.error",e);
			return "/main/debit/apply/positionApplyDetail";
		}


	}
}
