package com.shengpay.debit.common.service;

import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.model.fileManager.UploadFileResponse;

/**
 * 申请额度
 *
 * @author heyi.alex
 *
 */
public interface MerchantCreditLinesApplyService {

	public DoMerchantCreditLinesApplyPO getLatestCreditLines(String merchantNo);

	public DoMerchantCreditLinesApplyPO selectById(Long id);
	/**
	 * 校验钱包账户是否已经被绑定过了
	 * @param merchantNo商户号
	 * @param loginName登录名
	 * **/
	public boolean existsPersonalWalletBinded(String merchantNo, String loginName);
	/**
	 * 是否存在申请中的记录，状态是0和1
	 * **/
	public boolean existsApplyingRecord(String merchantNo);
	/**
	 * 获取超过时间的数据
	 * 只拿状态是1 且 需要担保代理商没有担保的数据
	 */
	public List<DoMerchantCreditLinesApplyPO> getMerchantApply(Map <String, Object> mps);
	/**
	 *
	 * @param mps
	 * @return
	 */
	public List<DoMeCreditLinesApplyInfoPO> getCreditLinesApplyInfo(Map <String, Object> mps);

	public int updateCreditLinesApplyInfoByID(Long id);
	/**
	 * 查询代理商是否开通担保资格
	 * @param promoterId
	 * @return
	 */
	public DmAgentMerchantSettingListPO getAgentMerchant(String pro_merchantNo);

	/**
	 * 更新用户上传控件
	 * @param creditReportFileInfo
	 * @param applyId
	 */
	public void updatereditUploadFile(UploadFileResponse creditReportFileInfo, Long applyId);
}
