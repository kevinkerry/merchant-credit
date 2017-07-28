package com.shengpay.debit.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.shengpay.debit.common.risk.model.CreditLineApplyRequest;
import com.shengpay.debit.common.service.CreditLineInputItemService;
import com.shengpay.debit.common.service.MerchantCreditLinesApplyService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.daointerface.DmAgentMerchantSettingListDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMeCreditLinesApplyInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;
import com.shengpay.model.fileManager.UploadFileResponse;

/**
 * 申请额度
 *
 * @author heyi.alex
 *
 */
@Service
public class MerchantCreditLinesApplyServiceImpl implements MerchantCreditLinesApplyService {

	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;
	@Autowired
	private ExtDoMeCreditLinesApplyInfoDAO doMeCreditLinesApplyInfoDAO;
	@Autowired
	private DmAgentMerchantSettingListDAO dmAgentMerchantSettingListDAO;
	@Autowired
	private CreditLineInputItemService creditLineInputItemService;

	/**
	 * 获取最新申请的额度
	 *
	 * @param merchantNo
	 * @return
	 */
	public DoMerchantCreditLinesApplyPO getLatestCreditLines(String merchantNo) {
		return doMerchantCreditLinesApplyDAO.getLatestCreditLines(merchantNo);
	}
	/**
	 * 根据传入的时间获取额度申请记录
	 */
	public List<DoMerchantCreditLinesApplyPO> getMerchantApply(Map <String, Object> mps) {
		return doMerchantCreditLinesApplyDAO.getMerchantApply(mps);
	}
	/**
	 * 获取需要删除信息的数据
	 */
	public List<DoMeCreditLinesApplyInfoPO> getCreditLinesApplyInfo(
			Map<String, Object> mps) {
		return doMerchantCreditLinesApplyDAO.getCreditLinesApplyInfo(mps);
	}

	/**
	 * 更新附件记录
	 */
	public int updateCreditLinesApplyInfoByID(Long id){
		return doMeCreditLinesApplyInfoDAO.updateCreditLinesApplyInfoByID(id);
	}
	public DoMerchantCreditLinesApplyPO selectById(Long id) {
		return this.doMerchantCreditLinesApplyDAO.selectByPrimaryKey(id);
	}

	/**
	 * 更新征信文件的上传文件
	 * @param userInputVal
	 * @param applyId
	 */
	@Transactional("debitTransactionManager")
	public void updatereditUploadFile(UploadFileResponse creditReportFileInfo, Long applyId){
		DoMerchantCreditLinesApplyPO applyPO = doMerchantCreditLinesApplyDAO.selectByPrimaryKey(applyId);
		String jsonStr = applyPO.getApplyMerchantInfo();
		CreditLineApplyRequest request = JSONObject.parseObject(jsonStr, CreditLineApplyRequest.class);
		request.setCreditReportFileInfo(creditReportFileInfo);
		DoMerchantCreditLinesApplyPO record = new DoMerchantCreditLinesApplyPO();
		record.setId(applyId);
		record.setApplyMerchantInfo(JSONObject.toJSONString(request));
		doMerchantCreditLinesApplyDAO.updateByPrimaryKeySelective(record);
		creditLineInputItemService.updateDb(doMerchantCreditLinesApplyDAO.selectByPrimaryKey(applyId));
	}

	/**
	 * 校验钱包账户是否已经被绑定过了
	 *
	 * @param loginName登录名
	 * **/
	public boolean existsPersonalWalletBinded(String merchantNo, String loginName) {
		List<String> statusList = new ArrayList<String>();
		statusList.add(CreditLinesApplyStatusEnums.USER_MODIFY.key);
		statusList.add(CreditLinesApplyStatusEnums.APPLY_FAIL.key);
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andMerchantNoNotEqualTo(merchantNo);
		criteria.andLendLoginNameEqualTo(loginName);
		criteria.andApplyStatusNotIn(statusList);
		criteria.andPolicyStartTimeIsNull();
		DoMerchantCreditLinesApplyExample.Criteria criteria2 = example.createCriteria();
		criteria2.andMerchantNoNotEqualTo(merchantNo);
		criteria2.andLendLoginNameEqualTo(loginName);
		criteria2.andApplyStatusNotIn(statusList);
		criteria2.andPolicyStartTimeLessThanOrEqualTo(new Date());
		criteria2.andPolicyEndTimeGreaterThanOrEqualTo(new Date());
		example.or(criteria2);
		List<DoMerchantCreditLinesApplyPO> list = this.doMerchantCreditLinesApplyDAO.selectByExample(example);
		return list != null && list.size() > 0;
	}

	public boolean existsApplyingRecord(String merchantNo) {
		List<String> statusList = new ArrayList<String>();
		statusList.add(CreditLinesApplyStatusEnums.USER_MODIFY.key);
		statusList.add(CreditLinesApplyStatusEnums.READY_AGENT_SUBMIT.key);
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andMerchantNoEqualTo(merchantNo);
		criteria.andApplyStatusIn(statusList);
		List<DoMerchantCreditLinesApplyPO> list = this.doMerchantCreditLinesApplyDAO.selectByExample(example);
		return list != null && list.size() > 0;
	}
	/**
	 * 根据商户号查询代理商是否开通担保资格
	 * @param promoterId
	 * @return
	 */
	public DmAgentMerchantSettingListPO getAgentMerchant(String pro_merchantNo){
		DmAgentMerchantSettingListExample example=new DmAgentMerchantSettingListExample();
		example.createCriteria().andAgentMerchantNoEqualTo(pro_merchantNo);
		List<DmAgentMerchantSettingListPO> list=dmAgentMerchantSettingListDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
