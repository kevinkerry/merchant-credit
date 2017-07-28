package com.shengpay.debit.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shengpay.debit.common.enums.SaveOrUpdateEnum;
import com.shengpay.debit.common.service.CreditLineInputItemService;
import com.shengpay.debit.common.service.CreditLineManager;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.ext.daointerface.ExtDoMeCreditLinesApplyInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;

/**
 * 申请额度页面操作
 *
 * @author heyi.alex
 *
 */
@Service
public class CreditLineManagerImpl implements CreditLineManager {

	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;

	@Autowired
	private ExtDoMeCreditLinesApplyInfoDAO doMeCreditLinesApplyInfoDAO;

	@Autowired
	private CreditLineInputItemService creditLineInputItemService;

	/**
	 * 保存用户申请信息
	 *
	 * @param applyPO
	 * @param applyPOItems
	 */
	@Transactional("debitTransactionManager")
	public void saveDb(DoMerchantCreditLinesApplyPO applyPO,
			List<DoMeCreditLinesApplyInfoPO> applyPOItems) {
		applyPO.setIsAgnetGuarantee("");
		Long applyId = doMerchantCreditLinesApplyDAO.insert(applyPO);
		for (int i = 0; i < applyPOItems.size(); i++) {
			DoMeCreditLinesApplyInfoPO applyPOItem = applyPOItems.get(i);
			applyPOItem.setLineApplyOrderId(applyId);
			doMeCreditLinesApplyInfoDAO.insert(applyPOItems.get(i));
		}
	}

	/**
	 * 更新用户输入信息
	 *
	 * @param applyPO
	 * @param applyPOItems
	 */
	@Transactional("debitTransactionManager")
	public void updateDb(DoMerchantCreditLinesApplyPO dbApplyPO, DoMerchantCreditLinesApplyPO applyPO,
			List<DoMeCreditLinesApplyInfoPO> applyPOItems) {
		long applyId = dbApplyPO.getId();
		applyPO.setId(applyId);
		applyPO.setIsAgnetGuarantee("");
		doMerchantCreditLinesApplyDAO.updateByPrimaryKeySelective(applyPO);
		doMeCreditLinesApplyInfoDAO.deleteByLineApplyOrderId(applyId);
		for (int i = 0; i < applyPOItems.size(); i++) {
			DoMeCreditLinesApplyInfoPO applyItemInfo = applyPOItems.get(i);
			applyItemInfo.setLineApplyOrderId(applyId);
			doMeCreditLinesApplyInfoDAO.insert(applyItemInfo);
		}
	}




	/**
	 * 根据申请额度查询用户输入的基本资料
	 *
	 * @param po
	 * @return
	 */
	public Map<String, DoMeCreditLinesApplyInfoPO> selectByDoApplyPO(
			DoMerchantCreditLinesApplyPO po) {
		Map<String, DoMeCreditLinesApplyInfoPO> map = new HashMap<String, DoMeCreditLinesApplyInfoPO>();
		DoMeCreditLinesApplyInfoExample example = new DoMeCreditLinesApplyInfoExample();
		DoMeCreditLinesApplyInfoExample.Criteria criteria = example
				.createCriteria();
		criteria.andLineApplyOrderIdEqualTo(po.getId());
		List<DoMeCreditLinesApplyInfoPO> list = doMeCreditLinesApplyInfoDAO
				.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			DoMeCreditLinesApplyInfoPO doMeCreditLinesApplyInfoPO = list.get(i);
			String key = doMeCreditLinesApplyInfoPO.getInputKind().replace(" ", "_") + "_"
					+ doMeCreditLinesApplyInfoPO.getInputCode();
			map.put(key, doMeCreditLinesApplyInfoPO);
		}
		return map;
	}

	public String selectOtherInputByInputCode(String merchantNo, String inputCode){
		DoMeCreditLinesApplyInfoExample example = new DoMeCreditLinesApplyInfoExample();
		DoMeCreditLinesApplyInfoExample.Criteria criteria = example
				.createCriteria();
		criteria.andInputKindEqualTo("otherInput");
		criteria.andInputCodeEqualTo(inputCode);
		criteria.andMerchantNoEqualTo(merchantNo);
		 List<DoMeCreditLinesApplyInfoPO>  list = doMeCreditLinesApplyInfoDAO.selectByExample(example);
		 if (list != null && list.size() > 0){
			 return list.get(0).getInputValue();
		 }
		 return null;
	}

	/**
	 * 信息更新或保存
	 */
	@Transactional("debitTransactionManager")
	public void saveOrUpdateDb(DoMerchantCreditLinesApplyPO applyPO,String saveOrUpdateFlag){
		if(StringUtils.isNotBlank(saveOrUpdateFlag) && saveOrUpdateFlag.equals(SaveOrUpdateEnum.SAVE.getCode())){
			doMerchantCreditLinesApplyDAO.insert(applyPO);
			creditLineInputItemService.insertItems(applyPO);
		}else{
			doMerchantCreditLinesApplyDAO.updateByPrimaryKeySelective(applyPO);
			creditLineInputItemService.updateDb(applyPO);
		}
	}

}
