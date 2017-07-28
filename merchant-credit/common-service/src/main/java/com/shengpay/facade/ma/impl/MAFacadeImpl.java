package com.shengpay.facade.ma.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.ContactType;
import com.sdp.mc.common.enums.MarginAccountEnum;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.integration.ma.dto.response.MAGetContactResponseDTO;
import com.sdp.mc.ma.dao.MarginAccountRequestDO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.ma.wrapper.MaOsrFullServiceWrapper;
import com.shengpay.facade.ma.MACreateAccountVO;
import com.shengpay.facade.ma.MAFacade;
import com.shengpay.facade.ma.MAFacadeUtil;
import com.shengpay.service.ma.MAService;

@Service("MAFacade")
public class MAFacadeImpl implements MAFacade {

	private static final Logger log = LoggerFactory.getLogger(MAFacadeImpl.class);

	@Autowired
	private MAService maService;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private MaOsrFullServiceWrapper maOsrFullServiceWrapper;

	private MACreateAccountVO buildMACreateAccountVO(long recordId, boolean flag, String accountId, String responseCode, String responseMessage) {
		MACreateAccountVO errorMessage = new MACreateAccountVO(flag, responseCode, responseMessage);
		errorMessage.setAccountId(accountId);
		errorMessage.setBizAccountId(recordId);
		return errorMessage;
	}

	/**
	 * 配资授信开户、pos贷款开户通用方法
	 * 
	 * @param merchantNo
	 *            商户号
	 * @param memberId
	 *            商户号对应的memberId
	 * @param requestOperator
	 *            操作员
	 * @param accountType
	 *            账户类型
	 * @param userIp
	 *            用户ip
	 * @return errorMessage
	 * **/
	public MACreateAccountVO createAccount(final String merchantNo, final String memberId, final String requestOperator,
			final AccountType accountType, final String userIp) {
		log.info("MAFacadeImpl.createAccount.memberId=" + memberId + ",userIp=" + userIp);
		MACreateAccountRequestDTO req = MAFacadeUtil.buildMACreateAccountRequestDTO(memberId, requestOperator, accountType, userIp);
		MarginAccountRequestDO originalMerchantAccount = this.maService.getMarginAccountByMerchantNo(merchantNo, accountType);
		boolean isFailue = originalMerchantAccount != null && MarginAccountEnum.FAILUE.code.equals(originalMerchantAccount.getStatus());
		if (isFailue) {
			// 修改原有请求信息
			this.maService.update(req, originalMerchantAccount);
		}
		final Long id = originalMerchantAccount != null ? originalMerchantAccount.getId() : this.maService.insert(req, merchantNo);

		log.info("MAFacadeImpl.createAccount.queryMarginAccount.memberId=" + memberId);
		String accountId = this.maOnlineWrapper.queryAccount(memberId, userIp, accountType);
		log.info("MAFacadeImpl.createAccount.queryMarginAccount.memberId=" + memberId + ",accountId=" + accountId);
		if (StringUtils.isNotBlank(accountId)) {
			MACreateAccountResponseDTO res = new MACreateAccountResponseDTO(true);
			res.setResponseCode("0");
			res.setResponseMessage("处理成功");
			res.setAccountId(accountId);
			if (isFailue) {
				this.maService.updateStatusFromFailueById(id, res);
			} else {
				this.maService.updateStatusFromInitById(id, res);
			}
			return this.buildMACreateAccountVO(id, true, res.getAccountId(), res.getResponseCode(), res.getResponseMessage());
		} else {
			log.info("MAFacadeImpl.createAccount.memberId=" + memberId + ",request=" + ToStringBuilder.reflectionToString(req));
			MACreateAccountResponseDTO res = this.maOsrFullServiceWrapper.createAccount(req);
			log.info("MAFacadeImpl.createAccount.memberId=" + memberId + ",response=" + ToStringBuilder.reflectionToString(res));
			if (res != null) {
				boolean isSuccess = isFailue ? this.maService.updateStatusFromFailueById(id, res) : this.maService.updateStatusFromInitById(id, res);
				boolean flag = isSuccess && res.isSuccess() && StringUtils.isNotBlank(res.getAccountId());
				return this.buildMACreateAccountVO(id, flag, res.getAccountId(), res.getResponseCode(), res.getResponseMessage());
			}
		}
		throw new IllegalArgumentException("MAFacadeImpl.createAccount.response is null");
	}

	/**
	 * 根据memberId 获得会员手机号码，如无号码或异常返回 null
	 * 
	 * @param memberId
	 * @return
	 */
	public String getMAMobileByMemberId(final String memberId) {
		MAGetContactResponseDTO contactResponseDTO = maOsrFullServiceWrapper.getContactByMemberId(memberId, ContactType.MEMBER);
		if (contactResponseDTO == null || StringUtils.isEmpty(contactResponseDTO.getMobile())) return null;
		return contactResponseDTO.getMobile();
	}

	/**
	 * 根据商户号查询对应的memberId和默认的操作员id
	 * 
	 * Parameters: merchantNo商户号 merchantNo
	 */
	public Promoter4MADTO queryPromoterInfoByMerchantNo(String merchantNo) {
		return maOnlineWrapper.queryPromoterInfoByMerchantNo(merchantNo);
	}
}
