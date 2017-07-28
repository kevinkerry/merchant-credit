package com.shengpay.service.withdraw;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.common.exception.OpenFastSettleException;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.withdraw.dao.PolicyConfigInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.shengpay.commons.core.base.PaginationBaseObject;

public interface FwPosMerchantInfoService {
	/**
	 * 查询所有开通快速结算的代理商
	 * 
	 * @return
	 */
	List<PosMerchantInfoDO> selectOpenFastSettlePromoterInfo();

	/**
	 * 查询代理商下所有开通快速结算的商户
	 * 
	 * @param promoterId
	 *            代理的ID
	 * @return
	 */
	List<PosMerchantInfoDO> selectOpenFastSettleMerchantInfoByPromoterId(Long promoterId);

	/**
	 * 根据合同ID查询商户信息（商户或代理商）
	 * 
	 * @param merchantId
	 *            合同ＩＤ
	 * @return
	 */
	PosMerchantInfoDO getPosMerchantInfoByPosMerchantId(Long merchantId);

	/**
	 * 创建商户信息
	 * 
	 * @param info
	 * @return
	 */
	Long createInfo(PosMerchantInfoDO info);

	/**
	 * 更新商户信息
	 * 
	 * @param info
	 *            需要更新的信息
	 * @param example
	 *            过滤的信息
	 * @return
	 */
	int updateByExample(PosMerchantInfoDO info, PosMerchantInfoDOExample example);

	/**
	 * 更新代理商的快速结算信息
	 * 
	 * @param promoterId
	 *            代理商的合同ID
	 * @param fastSettleFlag
	 *            快速结算标示
	 * @param fastSettleLimit
	 *            快速结算的金额
	 * @param fastSettleMargin
	 *            快速结算的保证金
	 * @param loaningType
	 *            代理商的垫资类型
	 * @return
	 */
	int updatePromoterFastSettleInfo(String promoterId, Integer fastSettleFlag, String fastSettleLimit, String fastSettleMargin, Integer loaningType);

	/**
	 * 更新商户的快速结算信息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param merchantType
	 *            商户类型
	 * @param fastSettleFlag
	 *            快速结算标示
	 * @param autoFastSettleFlg
	 *            自动快速结算标示
	 * @param fastSettleLimit
	 *            快速结算的金额
	 * @param fastSettleMinLimit
	 *            快速结算的最低金额
	 * @param phoneNo
	 *            商户手机号
	 * @return
	 */
	int updateMerchantFastSettleInfo(String merchantNo, String merchantType, Integer fastSettleFlag, Integer autoFastSettleFlg,
			String fastSettleLimit, BigDecimal fastSettleMinLimit, String phoneNo);

	/**
	 * 通过商户号和商户类型查询商户信息(如果多条，取第一条)
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param merchantType
	 *            商户类型
	 * @return
	 */
	PosMerchantInfoDO getPosMerchantInfoByMerchantInfo(String merchantNo, String merchantType);

	/**
	 * 通过商户号和商户类型查询商户信息
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param merchantType
	 *            商户类型
	 * @return
	 */
	List<PosMerchantInfoDO> getPosMerchantInfosByMerchantInfo(String merchantNo, String merchantType);

	/**
	 * 商户重复的商户信息
	 * 
	 * @return
	 */
	int distinctMerchant();

	/**
	 * 自动开通商户快速结算产品
	 * 
	 * @param merchantNo
	 * @param merchantType
	 * @param creditCTFCount
	 * @throws OpenFastSettleException
	 */
	void mposAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, int creditCTFCount) throws OpenFastSettleException;

	/**
	 * 通过 会员ID获取开通快速结算的商户信息
	 * 
	 * @param memberIds
	 * @return
	 */
	List<PosMerchantInfoDO> getOpenT0MerchantInfoByMemberIds(List<String> memberIds);

	/**
	 * 通过商户信息查询身份关联的开通快速结算的商户信息
	 * 
	 * @param merchantNo
	 * @param merchantType
	 * @return
	 */
	List<PosMerchantInfoDO> getOpenT0IdentityMerchantInfo(String merchantNo, String merchantType);

	/**
	 * 查询未开通快速结算的MPOS商户
	 * 
	 * @param merchantNos
	 * @return
	 */
	List<PosMerchantInfoDO> mposUnopenT0MerchantInfo(String merchantNos);

	/**
	 * 根据代理商的合同ID查询下级代理商信息
	 * 
	 * @param promoterId
	 *            代理商ID
	 * @return
	 */
	List<PosMerchantInfoDO> queryUnderPromoterInfoByPromoterId(Long promoterId);

	PaginationBaseObject<PosMerchantInfoDO> pagingUnderPromoterInfo(PmtQueryPosMerchantPO po);

	PosMerchantInfoDO selectDataById(Long id);

	int repairWithdrawData();

	int repairFirstOpenDate();

	/**
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param merchantType
	 *            商户类型
	 * @param workdayFee
	 *            工作日费率
	 * @param holidayFee
	 *            节假日费率
	 * @param fastSettleLimit
	 *            快速结算额度
	 * @throws OpenFastSettleException
	 */
	void posAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, String workdayFee, String holidayFee, BigDecimal fastSettleLimit)
			throws OpenFastSettleException;

	String syncMerchantOperator();

	String mposBatchUpdateFee(String merchantNo, String merchantType);

	String mposBatchUpdateFee(String merchantNo, String merchantType, String workdayFee, String holidayFee, Integer merchantFsFlag);

	void posAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, String workdayFee, String holidayFee,
			BigDecimal fastSettleLimit, String fastSettleFlag, String autoFastSettleFlag) throws OpenFastSettleException;

	int syncOpenAccountTime();

	int executeUpdateSql(String updateSql);

	int executeInsertSql(String insertSql);

	int updateMerchantMcc(String merchantNo, String merchantType, String newMccValue);

	void easypayAutoOpenFastSettleAndUpdateLimit(String merchantNo, String merchantType, PolicyConfigInfoDO policyInfo)
			throws OpenFastSettleException;

	/**
	 * 创建新开通商户的额度信息
	 * 
	 * @return
	 */
	int createNewMerchantWithdrawInfo();

	/**
	 * 更新商户的额度信息
	 * 
	 * @return
	 */
	int updateMerchantWithdrawInfo(boolean isSync);

}
