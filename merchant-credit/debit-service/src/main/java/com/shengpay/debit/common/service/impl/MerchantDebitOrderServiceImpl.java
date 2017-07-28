package com.shengpay.debit.common.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.AccountStatus;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.fos.dto.request.DebitTransferRequestDTO;
import com.sdp.mc.integration.ma.dto.MerchantBaseBalanceDTO;
import com.sdp.mc.ma.wrapper.AccountQueryFacadeWrapper;
import com.sdp.mc.ma.wrapper.MaOsrFullServiceWrapper;
import com.sdp.mc.verify.VerifyQueryServiceClient;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.service.MerchantDebitInfoService;
import com.shengpay.debit.common.service.MerchantDebitOrderService;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoPO;
import com.shengpay.debit.dal.dataobject.DoBorrowMoneyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;
import com.shengpay.debit.daointerface.DmMerchantDebitLogInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantDebitOrderDAO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;
import com.shengpay.debit.merchant.account.enums.MerchantDebitLogOperateTypeEnum;
import com.shengpay.facade.fos.FOSFacade4Debit;
import com.shengpay.verify.common.facade.enums.IdCardStatus;
import com.shengpay.verify.common.facade.model.VerifyInfo;

@Service
public class MerchantDebitOrderServiceImpl implements MerchantDebitOrderService {

	private static final Logger log = LoggerFactory.getLogger(MerchantDebitOrderServiceImpl.class);

	@Autowired
	private ExtDoMerchantDebitOrderDAO extDoMerchantDebitOrderDAO;

	@Autowired
	private DmMerchantDebitLogInfoDAO dmMerchantDebitLogInfoDAO;

	@Autowired
	private MaOsrFullServiceWrapper maOsrFullServiceWrapper;

	@Autowired
	private AccountQueryFacadeWrapper accountQueryFacadeWrapper;

	@Autowired
	private MerchantDebitInfoService merchantDebitInfoService;

	@Autowired
	private FOSFacade4Debit FOSFacade4Debit;
	@Autowired
	private VerifyQueryServiceClient verifyQueryServiceClient;
	

	/**
	 * 分页查询商户借款订单
	 * **/
	public List<DoMerchantDebitOrderPO> pageQueryMerchantDebitOrder(ExtDoMerchantDebitOrderExample query) {
		log.info("MerchantDebitOrderServiceImpl.pageQueryMerchantDebitOrder,query=" + ToStringBuilder.reflectionToString(query));
		return this.extDoMerchantDebitOrderDAO.pageQueryMerchantDebitOrder(query);
	}

	public DoMerchantDebitOrderPO selectByPrimerykey(Long id) {
		return this.extDoMerchantDebitOrderDAO.selectByPrimaryKey(id);
	}

	/**
	 * 逾期还款逻辑处理,可重复调用 <br>
	 * step1:解冻止出[商户+个人]<br>
	 * step2:扣款[本金+利息]<br>
	 * step3:恢复借款申请权限、恢复贷款额度<br>
	 * step4:更新借款订单表至还款完成<br>
	 * step5:插入负债变更流水<br>
	 *
	 * @param id
	 *            商户借款订单表id
	 * **/
	public ErrorMessageVO overdueRepayment(Long id) {
		try {
			// 查询借款订单
			final DoMerchantDebitOrderPO merchantDebitOrder = this.selectByPrimerykey(id);
			if (merchantDebitOrder == null) {
				return new ErrorMessageVO(false, "-1", "该借款申请记录不存在");
			}
			MerchantDebitOrderStatusEnums currentStatus = MerchantDebitOrderStatusEnums.parse(merchantDebitOrder.getStatus());
			// 排除还款成功和借款失败的状态,还款失败的可以进行补单处理
			if (MerchantDebitOrderStatusEnums.OVERDUEING != currentStatus) {
				return new ErrorMessageVO(false, "-1", "借款状态不正确");
			}
			// 根据商户号查询负债关系表
			DmMerchantDebitInfoPO merchantDebitInfo = this.merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(merchantDebitOrder.getMerchantNo(),
					DebitOrganizationEnum.SFT);
			// 查询余额
			MerchantBaseBalanceDTO personalAccount = this.accountQueryFacadeWrapper.queryAccountBalanceByAccountType(merchantDebitInfo.getLendMemberId(),
					AccountType.C_BASE_ACCOUNT);
			if (AccountStatus.AccountStatusLock.getCode() == personalAccount.getAccountStatus()) {
				return new ErrorMessageVO(false, "-1", "提示钱包状态异常，请联系客服处理");
			}
			// 还款总金额=放款金额+逾期滞纳金
			BigDecimal totalRepaymentAmount = merchantDebitOrder.getDebitAmount().add(merchantDebitOrder.getOverDueAmount()).setScale(2, BigDecimal.ROUND_HALF_UP);

			// 扩大100倍用long型比较,bigdecimal算术运算后直接比较会有无穷小数的极限
			long _totalRepaymentAmount = totalRepaymentAmount.multiply(BigDecimal.valueOf(100)).longValue();
			// 个人基本户账户余额放大100倍
			long banlance = personalAccount.getAccountBalance().multiply(BigDecimal.valueOf(100)).longValue();
			if (_totalRepaymentAmount > banlance) {
				return new ErrorMessageVO(false, "-1", "基本户余额不足，请先充值");
			}

			// step1-1:解冻出款服务,商户[企业和个人商户]
			try {
				ErrorMessageVO errorMessage1 = this.maOsrFullServiceWrapper.reset2Normal(merchantDebitInfo.getMerchantMemberId(), merchantDebitInfo.getMerchantWallerAccount(),
						AccountType.B_BASE_ACCOUNT);
				log.info("MerchantDebitOrderServiceImpl.overdueRepayment.bmerchant.reset2Normal,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
						+ ToStringBuilder.reflectionToString(errorMessage1));
				ErrorMessageVO errorMessage2 = this.maOsrFullServiceWrapper.reset2Normal(merchantDebitInfo.getMerchantMemberId(), merchantDebitInfo.getMerchantWallerAccount(),
						AccountType.C_BASE_ACCOUNT);
				log.info("MerchantDebitOrderServiceImpl.overdueRepayment.cmerchant.reset2Normal,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
						+ ToStringBuilder.reflectionToString(errorMessage2));
				if (!errorMessage1.isSuccess() && !errorMessage2.isSuccess()) {
					return new ErrorMessageVO(false, "-1", "商户帐号解冻失败");
				}
			} catch (Exception e) {
				log.error("MerchantDebitOrderServiceImpl.overdueRepayment.reset2Normal.merchant.error", e);
				return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
			}
			// step1-2:解冻出款服务,个人
			try {
				if (personalAccount.getAccountStatus() == AccountStatus.AccountStatusDeniedFundOut.getCode()) {
					ErrorMessageVO errorMessage = this.maOsrFullServiceWrapper.reset2Normal(merchantDebitInfo.getLendMemberId(), merchantDebitInfo.getLendWalletAccount(),
							AccountType.C_BASE_ACCOUNT);
					log.info("MerchantDebitOrderServiceImpl.overdueRepayment.reset2Normal,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
							+ ToStringBuilder.reflectionToString(errorMessage));
					if (!errorMessage.isSuccess()) {
						return new ErrorMessageVO(false, "-1", "个人帐号解冻失败");
					}
				}
			} catch (Exception e) {
				log.error("MerchantDebitOrderServiceImpl.overdueRepayment.reset2Normal.personal.error", e);
				return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
			}
			// step2:还本金+滞纳金
			DebitTransferRequestDTO debitTransferRequest = new DebitTransferRequestDTO();
			debitTransferRequest.setBizId(merchantDebitOrder.getId().toString());
			debitTransferRequest.setBatchNo(UUID.randomUUID().toString().replace("-", ""));
			debitTransferRequest.setMemberId(merchantDebitInfo.getLendMemberId());
			debitTransferRequest.setCreditAccountId(merchantDebitInfo.getCreditAccount());
			debitTransferRequest.setPublicAccountId(merchantDebitInfo.getLendWalletAccount());
			debitTransferRequest.setInterestAccountId(merchantDebitInfo.getInterestAccount());
			// 本金
			debitTransferRequest.setDebitLimitAmount(merchantDebitOrder.getDebitAmount());
			// 滞纳金
			debitTransferRequest.setInterest(merchantDebitOrder.getOverDueAmount());
			try {
				ErrorMessageVO errorMessage = this.FOSFacade4Debit.overdueRepayment(debitTransferRequest);
				if (FosPaymentStateEnums.S.code.equals(errorMessage.getErrorCode())) {
					// 不做任何处理
				} else if (FosPaymentStateEnums.P.code.equals(errorMessage.getErrorCode())) {
					this.checkOut(merchantDebitInfo);
					return new ErrorMessageVO(false, "-1", "逾期还款处理中，请稍后");
				} else if (FosPaymentStateEnums.E.code.equals(errorMessage.getErrorCode())) {
					this.checkOut(merchantDebitInfo);
					return new ErrorMessageVO(false, "-1", "请去个人钱包户查收资金，若有疑问请致电021-20575188-807755");
				} else {
					this.checkOut(merchantDebitInfo);
					return new ErrorMessageVO(false, "-1", "逾期还款失败");
				}
			} catch (Exception e) {
				log.error("MerchantDebitOrderServiceImpl.overdueRepayment.payback.principal.error", e);
				return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
			}
			// 变更前可用余额
			BigDecimal beforeAmount = merchantDebitInfo.getCanUseAmount();
			// step3:恢复借款申请权限,将负债表状态置为[正常使用],当前可用额度、总贷款额度、逾期滞纳金相应调整,还有负债表状态[要统计逾期利息总金额来判断负债表状态]
			boolean flag = this.merchantDebitInfoService.recoverBorrowMoney(merchantDebitInfo.getMerchantNo(), DebitOrganizationEnum.SFT, merchantDebitOrder.getDebitAmount(),
					merchantDebitOrder.getOverDueAmount());
			// 刷新最新的负债状态,判断是否还有逾期未还款的订单，如果有则再次冻结账户
			merchantDebitInfo = this.merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(merchantDebitOrder.getMerchantNo(), DebitOrganizationEnum.SFT);
			if (DebitAccountEnums.DEBIT_OVER_DUE.getKey().equals(merchantDebitInfo.getStatus())) {
				this.checkOut(merchantDebitInfo);
			}
			if (!flag) {
				return new ErrorMessageVO(false, "-1", "借款申请权限恢复失败");
			}
			// 变更后可用余额
			BigDecimal afterAmount = merchantDebitInfo.getCanUseAmount();
			// step4:更新借款订单表至还款完成
			int rows = this.extDoMerchantDebitOrderDAO.updateDebitOrder2Success(merchantDebitOrder.getId(), merchantDebitOrder.getStatus(),
					MerchantDebitOrderStatusEnums.OVERDUEING_PAYBACK_SUCCESS.getKey());
			if (rows != 1) {
				return new ErrorMessageVO(false, "-1", "逾期还款失败");
			} else {
				// step5:插入负债变更流水
				this.createMerchantDebitLog(beforeAmount, afterAmount, merchantDebitOrder);
				return new ErrorMessageVO(true, "0", "逾期还款成功");
			}
		} catch (Exception e) {
			// 此处不把借款单状态更新为失败,可以重试还款
			log.error("MerchantDebitOrderServiceImpl.overdueRepayment.error", e);
			return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
		}
	}

	private void checkOut(DmMerchantDebitInfoPO merchantDebitInfo) {
		// 止出商户钱包账户
		ErrorMessageVO errorMessage1 = this.maOsrFullServiceWrapper.checkOut(merchantDebitInfo.getMerchantMemberId(), merchantDebitInfo.getMerchantWallerAccount(), AccountType.B_BASE_ACCOUNT);
		log.info("MerchantDebitOrderServiceImpl.overdueRepayment.bmerchant.checkOut,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
				+ ToStringBuilder.reflectionToString(errorMessage1));
		ErrorMessageVO errorMessage2 = this.maOsrFullServiceWrapper.checkOut(merchantDebitInfo.getMerchantMemberId(), merchantDebitInfo.getMerchantWallerAccount(), AccountType.C_BASE_ACCOUNT);
		log.info("MerchantDebitOrderServiceImpl.overdueRepayment.cmerchant.checkOut,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
				+ ToStringBuilder.reflectionToString(errorMessage2));
		// 止出个人钱包账户
		ErrorMessageVO errorMessage3 = this.maOsrFullServiceWrapper.checkOut(merchantDebitInfo.getLendMemberId(), merchantDebitInfo.getLendWalletAccount(), AccountType.C_BASE_ACCOUNT);
		log.info("MerchantDebitOrderServiceImpl.overdueRepayment.personal.checkOut,memberId=" + merchantDebitInfo.getLendMemberId() + ",errorMessage="
				+ ToStringBuilder.reflectionToString(errorMessage3));
	}
	/**
	 * 插入可用额度变更记录
	 * **/
	private boolean createMerchantDebitLog(BigDecimal beforeAmount, BigDecimal afterAmount, DoMerchantDebitOrderPO merchantDebitOrder) {
		// 可用额度变更记录
		DmMerchantDebitLogInfoPO record = new DmMerchantDebitLogInfoPO();
		record.setMerchantNo(merchantDebitOrder.getMerchantNo());
		record.setOrganizationCode(merchantDebitOrder.getOrganizationCode());
		record.setOperateType(MerchantDebitLogOperateTypeEnum.OVERDUE_PAYBACK.code);
		// 变更前额度
		record.setBeforeAmount(beforeAmount);
		// 变更额度
		record.setAmount(merchantDebitOrder.getDebitAmount());
		// 变更后额度
		record.setAfterAmount(afterAmount);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		log.info("MerchantDebitOrderServiceImpl.createMerchantDebitLog.debitOrderId=" + merchantDebitOrder.getId() + ",debitLogInfo=" + ToStringBuilder.reflectionToString(record));
		Long id = this.dmMerchantDebitLogInfoDAO.insert(record);
		log.info("MerchantDebitOrderServiceImpl.createMerchantDebitLog.id=" + id + ",debitOrderId=" + merchantDebitOrder.getId());
		return true;
	}

	/**
	 * 统计未还款总额
	 * **/
	public BigDecimal sumDebitAmount(String merchantNo) {
		return this.extDoMerchantDebitOrderDAO.sumDebitAmount(merchantNo);
	}

	public BigDecimal sumDebitAmountInLast5Days(String merchantNo) {
		return this.extDoMerchantDebitOrderDAO.sumDebitAmountInLast5Days(merchantNo);
	}

	public Integer countDebitAmountInLast5Days(String merchantNo) {
		return this.extDoMerchantDebitOrderDAO.countDebitAmountInLast5Days(merchantNo);
	}

	@Override
	public List<DoBorrowMoneyPO> pageQueryBorrowMonery(ExtDoMerchantDebitOrderExample queryParam) throws Exception {
		log.info("MerchantDebitOrderServiceImpl.pageQueryBorrowMonery,queryParam=" + ToStringBuilder.reflectionToString(queryParam));
		return this.extDoMerchantDebitOrderDAO.pageQueryBorrowMonery(queryParam);
	}

	@Override
	public DoBorrowMoneyPO borrowMoneyDetail(String merchantNo,String id) throws Exception {
		return this.extDoMerchantDebitOrderDAO.borrowMoneyDetail(merchantNo,id);
	}

	public List<LoanDebitOrderDTO> pageQueryLoanDebitOrder(ExtDoMerchantDebitOrderExample query){
		log.info("MerchantDebitOrderServiceImpl.pageQueryLoanDebitOrder,query=" + ToStringBuilder.reflectionToString(query));
		List<LoanDebitOrderDTO> list = this.extDoMerchantDebitOrderDAO.pageQueryLoanDebitOrder(query);
		for(LoanDebitOrderDTO loanDebitOrderDTO : list){
			VerifyInfo verifyInfo = verifyQueryServiceClient.queryVerifyInfoByMemberid(loanDebitOrderDTO.getLendMemberId());
			if(verifyInfo != null && verifyInfo.getIdCardStatus() == IdCardStatus.IDENTITY_INFO_VERIFIED) {
					loanDebitOrderDTO.setRealLendLoginName(verifyInfo.getTrueName());
				}
		}
		return list;
	}

	/**
	 * 查询商户借款出款信息
	 * @param query
	 * @return
	 */
	public BigDecimal totalAmount(ExtDoMerchantDebitOrderExample query){
		log.info("MerchantDebitOrderServiceImpl.totalAmount,query=" + ToStringBuilder.reflectionToString(query));
		 BigDecimal totalAmount = this.extDoMerchantDebitOrderDAO.totalAmount(query);
		 if(totalAmount == null || totalAmount.compareTo(BigDecimal.ZERO) < 0){
			 return new BigDecimal("0.00");
		 }
		 return totalAmount;
	}

	/**
	 * 查询商户借款订单详情
	 * @param query
	 * @return
	 */
	public DoMerchantDebitOrderPO loanOrderDetail(Long id){
		log.info("MerchantDebitOrderServiceImpl.loanOrderDetail,id=" + id );
		return extDoMerchantDebitOrderDAO.selectByPrimaryKey(id);
	}

}
