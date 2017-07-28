package com.shengpay.debit.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.shengpay.debit.common.risk.model.CreditRiskTypes;
import com.shengpay.debit.common.risk.model.CreditRiskTypesItems;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;

/**
 * 对返回的风控模型增加减少输入项
 *
 * @author heyi.alex
 *
 */
public class RiskItemUtil {

	private static Logger log = LoggerFactory.getLogger(RiskItemUtil.class);

	/**
	 * 对返回的风控模型中忽略某些制定的属性
	 *
	 * @param model
	 * @param riskCode
	 *            对输入小项过滤
	 * @return
	 */
	public static GetCreditRiskResponseModel ignoreRisk(
			GetCreditRiskResponseModel model, String[] riskCode) {
		// 数据异常的情况
		if (model == null || model.getTypes() == null) {
			log.error("wrong model:[ getCreditRisk is null]");
			return null;
		}
		// 参数为空的情况
		if (riskCode == null){
			log.warn("not ignore, because risCode is null!");
			return model;
		}
		GetCreditRiskResponseModel returnModel = new GetCreditRiskResponseModel();
		List<CreditRiskTypes> addCreditTypesList = new ArrayList<CreditRiskTypes>();
		// 输入大项
		for (int i = 0; i < model.getTypes().size(); i++) {
			CreditRiskTypes addCreditRiskType = new CreditRiskTypes();
			addCreditRiskType.setCode(model.getTypes().get(i).getCode());
			addCreditRiskType.setDesc(model.getTypes().get(i).getDesc());
			List<CreditRiskTypesItems> addTypes = new ArrayList<CreditRiskTypesItems>();
			CreditRiskTypes creditRiskType = model.getTypes().get(i);
			for (int j = 0; j < creditRiskType.getItems().size(); j++) {
				String code = creditRiskType.getItems().get(j).getCode();
				boolean foundFg = false;
				for (int k = 0; k < riskCode.length; k++) {
					// 如果不是
					if (riskCode[k].equals(code)){
						foundFg = true;
						break;
					}
				}
				if (!foundFg){
					addTypes.add(creditRiskType.getItems().get(j));
				}
			}
			addCreditRiskType.setItems(addTypes);
			addCreditTypesList.add(addCreditRiskType);
		}
		returnModel.setTypes(addCreditTypesList);
		return returnModel;
	}

	//TODO
	public static void addRiskItem() {

	}
}
