package com.shengpay.debit.common.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.ma.wrapper.MaOsrFullServiceWrapper;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.service.MerchantAccountService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;
import com.shengpay.facade.ma.MAFacadeUtil;

/**
 * 查询账户资产状态
 * 
 * @author heyi.alex
 * 
 */
@Service
public class MerchantAccountServiceImpl implements MerchantAccountService {
	private static final Logger log = LoggerFactory.getLogger(MerchantAccountServiceImpl.class);
	@Autowired
	private ExtDmMerchantDebitInfoDAO dmMerchantDebitInfoDAO;

	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private MaOsrFullServiceWrapper maOsrFullServiceWrapper;
	/**
	 * 查询商户目前资产信息
	 * 
	 * @param merchantNo
	 * @return
	 */
	public DmMerchantDebitInfoPO selectByMerchantId(String merchantNo) {
		return dmMerchantDebitInfoDAO.selectByMerchantId(merchantNo);
	}

	public DmMerchantDebitInfoPO buildMerchantDebitInfo(DoMerchantCreditLinesApplyPO merchantCreditLineApply) {
		DmMerchantDebitInfoPO merchantDebitInfo = new DmMerchantDebitInfoPO();
		merchantDebitInfo.setStatus(DebitAccountEnums.ACCOUNT_CAN_USE.getKey());
		// 商户号
		merchantDebitInfo.setMerchantNo(merchantCreditLineApply.getMerchantNo());
		// 商户名称
		merchantDebitInfo.setMerchantName(merchantCreditLineApply.getMerchantName());
		// 商户会员号
		merchantDebitInfo.setMerchantMemberId(merchantCreditLineApply.getMerchantMemberid());
		// 代理商商户号
		merchantDebitInfo.setPromoterNo(merchantCreditLineApply.getPromoterNo());
		// 代理商名称
		merchantDebitInfo.setPromoterName(merchantCreditLineApply.getPromoterName());
		// 信用总额度
		merchantDebitInfo.setTotalAmount(merchantCreditLineApply.getLendAmount());
		// 放款机构
		merchantDebitInfo.setOrganizationCode(DebitOrganizationEnum.SFT.code);
		// 信用级别
		merchantDebitInfo.setRiskLevel(merchantCreditLineApply.getRiskLevel());
		// 当前可用总额度
		merchantDebitInfo.setCanUseAmount(merchantCreditLineApply.getLendAmount());
		// 当前贷款总额
		merchantDebitInfo.setUsedAmount(BigDecimal.valueOf(0));
		// 逾期利息
		merchantDebitInfo.setOverDueAmount(BigDecimal.valueOf(0));
		// 冻结金额就是fos转账中的金额
		merchantDebitInfo.setFrozenAmount(BigDecimal.valueOf(0));
		// 当前时间
		merchantDebitInfo.setEffectiveStartTime(merchantCreditLineApply.getPolicyStartTime());
		// 一年有效期
		merchantDebitInfo.setEffectiveEndTime(merchantCreditLineApply.getPolicyEndTime());
		// 放款MEMBER_ID
		merchantDebitInfo.setLendMemberId(merchantCreditLineApply.getLendMemberId());
		// 放款钱包账户
		merchantDebitInfo.setLendWalletAccount(merchantCreditLineApply.getLendWallerAccount());
		// 个人授信户
		merchantDebitInfo.setCreditAccount(null);
		// 个人利息户
		merchantDebitInfo.setInterestAccount(null);
		// 个人账户登录名
		merchantDebitInfo.setLendLoginName(merchantCreditLineApply.getLendLoginName());
		// 创建时间
		merchantDebitInfo.setCreateTime(new Date());
		// 更新时间
		merchantDebitInfo.setEndTime(new Date());
		return merchantDebitInfo;
	}

	/**
	 * 再次进行额度申请的时候把额度、评级、绑定的钱包账户、可用额度、已用额度、逾期金额、冻结金额都修改掉
	 * **/
	public void buildMerchantDebitInfo(DmMerchantDebitInfoPO merchantDebitInfo, DoMerchantCreditLinesApplyPO merchantCreditLineApply) {
		// 信用总额度
		merchantDebitInfo.setTotalAmount(merchantCreditLineApply.getLendAmount());
		// 信用级别
		merchantDebitInfo.setRiskLevel(merchantCreditLineApply.getRiskLevel());
		// 当前可用总额度
		merchantDebitInfo.setCanUseAmount(merchantCreditLineApply.getLendAmount());
		// 当前贷款总额
		merchantDebitInfo.setUsedAmount(BigDecimal.valueOf(0));
		// 逾期利息
		merchantDebitInfo.setOverDueAmount(BigDecimal.valueOf(0));
		// 冻结金额就是fos转账中的金额
		merchantDebitInfo.setFrozenAmount(BigDecimal.valueOf(0));
		// 当前时间
		merchantDebitInfo.setEffectiveStartTime(merchantCreditLineApply.getPolicyStartTime());
		// 一年有效期
		merchantDebitInfo.setEffectiveEndTime(merchantCreditLineApply.getPolicyEndTime());
		// 放款MEMBER_ID
		merchantDebitInfo.setLendMemberId(merchantCreditLineApply.getLendMemberId());
		// 放款钱包账户
		merchantDebitInfo.setLendWalletAccount(merchantCreditLineApply.getLendWallerAccount());
		// 个人授信户
		merchantDebitInfo.setCreditAccount(null);
		// 个人利息户
		merchantDebitInfo.setInterestAccount(null);
		// 个人账户登录名
		merchantDebitInfo.setLendLoginName(merchantCreditLineApply.getLendLoginName());
		// 更新时间
		merchantDebitInfo.setEndTime(new Date());
	}

	/**
	 * 贷款额度预审通过后，运营拿到商户的邮寄资料确认后再开通授信专户和利息户
	 * 
	 * @param applyId
	 *            贷款申请id
	 * **/
	public ErrorMessageVO openAccount(Long applyId) {
		try {
			DoMerchantCreditLinesApplyPO merchantCreditLineApply = this.doMerchantCreditLinesApplyDAO.selectByPrimaryKey(applyId);
			// 申请状态是[用户资料提交中]在能走此流程
			if (!CreditLinesApplyStatusEnums.RISK_NOTIFY.key.equals(merchantCreditLineApply.getApplyStatus())) {
				return new ErrorMessageVO(false, "-1", "状态不正确，请确认用户资料是否已提交信用评级系统");
			}
			// 首先判断插入负债信息记录是否存在，存在则表示授信户和利息户都已经创建完毕
			DmMerchantDebitInfoPO merchantDebitInfo = this.selectByMerchantId(merchantCreditLineApply.getMerchantNo());
			if (merchantDebitInfo == null) {
				merchantDebitInfo = this.buildMerchantDebitInfo(merchantCreditLineApply);
			} else {
				// 更新负债评级、额度、绑定的钱包帐号等
				this.buildMerchantDebitInfo(merchantDebitInfo, merchantCreditLineApply);
			}
			// step1:查询商户的钱包账户,商户分企业商户和个人商户
			if (StringUtils.isBlank(merchantDebitInfo.getMerchantWallerAccount())) {
				String merchantWallerAccount = this.maOnlineWrapper.queryAccount(merchantDebitInfo.getMerchantMemberId(), IPUtils.getServerIp(), AccountType.B_BASE_ACCOUNT);
				if (StringUtils.isBlank(merchantWallerAccount)) {
					merchantWallerAccount = this.maOnlineWrapper.queryAccount(merchantDebitInfo.getMerchantMemberId(), IPUtils.getServerIp(), AccountType.C_BASE_ACCOUNT);
				}
				merchantDebitInfo.setMerchantWallerAccount(merchantWallerAccount);
				if (StringUtils.isBlank(merchantWallerAccount)) {
					return new ErrorMessageVO(false, "-1", "天天贷只支持企业商户和个人商户");
				}
			}

			// step2:获取个人授信账户id
			if (StringUtils.isBlank(merchantDebitInfo.getCreditAccount())) {
				String creditAccount = this.maOnlineWrapper.queryAccount(merchantCreditLineApply.getLendMemberId(), IPUtils.getServerIp(), AccountType.TTD_CREDIT_SPECIAL_ACCOUNT);
				if (StringUtils.isBlank(creditAccount)) {
					// requestOperator，不是必填项
					MACreateAccountRequestDTO req = MAFacadeUtil.buildMACreateAccountRequestDTO(merchantCreditLineApply.getLendMemberId(), MerchantCreditConstant.MC_WEBSITE_ZF_NO,
							AccountType.TTD_CREDIT_SPECIAL_ACCOUNT, IPUtils.getServerIp());
					MACreateAccountResponseDTO response = this.maOsrFullServiceWrapper.createAccount(req);
					if (!response.isSuccess()) {
						return new ErrorMessageVO(false, "-1", "授信账户创建失败");
					} else {
						merchantDebitInfo.setCreditAccount(response.getAccountId());
					}
				} else {
					merchantDebitInfo.setCreditAccount(creditAccount);
				}
			}
			// step3:获取个人利息户id
			if (StringUtils.isBlank(merchantDebitInfo.getInterestAccount())) {
				String interestAccount = this.maOnlineWrapper.queryAccount(merchantCreditLineApply.getLendMemberId(), IPUtils.getServerIp(),
						AccountType.TTD_CREDIT_INTEREST_ACCOUNT);
				if (StringUtils.isBlank(interestAccount)) {
					// requestOperator，不是必填项
					MACreateAccountRequestDTO req = MAFacadeUtil.buildMACreateAccountRequestDTO(merchantCreditLineApply.getLendMemberId(), MerchantCreditConstant.MC_WEBSITE_ZF_NO,
							AccountType.TTD_CREDIT_INTEREST_ACCOUNT, IPUtils.getServerIp());
					MACreateAccountResponseDTO response = this.maOsrFullServiceWrapper.createAccount(req);
					if (!response.isSuccess()) {
						return new ErrorMessageVO(false, "-1", "利息账户创建失败");
					} else {
						merchantDebitInfo.setInterestAccount(response.getAccountId());
					}
				} else {
					merchantDebitInfo.setInterestAccount(interestAccount);
				}
			}
			// step4:插入/修改负债信息表
			if (merchantDebitInfo.getId() == null) {
				log.info("MerchantAccountServiceImpl.openAccount,applyId=" + applyId + ",merchantDebitInfo=" + ToStringBuilder.reflectionToString(merchantDebitInfo));
				Long merchantDebitInfoId = this.dmMerchantDebitInfoDAO.insert(merchantDebitInfo);
				log.info("MerchantAccountServiceImpl.openAccount,applyId=" + applyId + ",merchantDebitInfoId=" + merchantDebitInfoId);
			} else {
				int rows = this.dmMerchantDebitInfoDAO.updateByPrimaryKeySelective(merchantDebitInfo);
				log.info("MerchantAccountServiceImpl.openAccount,applyId=" + applyId + ",merchantDebitInfoId=" + merchantDebitInfo.getId() + ",rows=" + rows);
			}
			// step5:更新贷款额度申请状态到审核成功
			boolean flag = this.updateMerchantCreditLineStatus(merchantCreditLineApply.getId(), CreditLinesApplyStatusEnums.RISK_NOTIFY, CreditLinesApplyStatusEnums.APLY_SUCCESS);
			log.info("MerchantAccountServiceImpl.updateMerchantCreditLineStatus,applyId=" + applyId + ",flag=" + flag);
			return new ErrorMessageVO(true, "0", "借款功能开通成功");
		} catch (Exception e) {
			log.info("MerchantAccountServiceImpl.openAccount.error,applyId=" + applyId, e);
			return new ErrorMessageVO(false, "-1", "天天贷-[开通借款]请求ma失败");
		}
	}
	/**
	 * 更新状态
	 * **/
	private boolean updateMerchantCreditLineStatus(Long id, CreditLinesApplyStatusEnums originalStatus, CreditLinesApplyStatusEnums targetStatus) {
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andApplyStatusEqualTo(originalStatus.key);
		DoMerchantCreditLinesApplyPO record = new DoMerchantCreditLinesApplyPO();
		record.setApplyStatus(targetStatus.key);
		// 拿到商户资料的确认时间
		record.setMerchantSendDataTime(new Date());
		// 后台提交到风控时间
		record.setUpdateTime(new Date());
		int rows = this.doMerchantCreditLinesApplyDAO.updateByExampleSelective(record, example);
		log.info("MerchantAccountServiceImpl.updateMerchantCreditLineStatus,id=" + id + ",rows=" + rows);
		return rows == 1;
	}
}
