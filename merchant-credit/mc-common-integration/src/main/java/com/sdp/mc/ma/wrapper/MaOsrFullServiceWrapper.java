package com.sdp.mc.ma.wrapper;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.ContactType;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.request.MACreateAccountRequestDTO;
import com.sdp.mc.integration.ma.dto.response.MACreateAccountResponseDTO;
import com.sdp.mc.integration.ma.dto.response.MAGetContactResponseDTO;

public interface MaOsrFullServiceWrapper {

	/**
	 * 创建储值帐号,帐号类型216表示保证金
	 * 
	 * @param memberId
	 * @param userIp
	 * **/
	public MACreateAccountResponseDTO createAccount(MACreateAccountRequestDTO requestDTO);

	/**
	 * 基本户止出
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO checkOut(String memberId, String accountId, AccountType accountType);
	/**
	 * 基本户止入
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO checkIn(String memberId, String accountId, AccountType accountType);

	/**
	 * 设置201账户正常使用
	 * 
	 * @param memberId
	 *            盛付通会员号
	 * @param accountId
	 *            储值帐号id
	 * @param accountType
	 *            储值帐号类型
	 * **/
	public ErrorMessageVO reset2Normal(String memberId, String accountId, AccountType accountType);
	
	/**
	 * 通过 MaOsr 获得会员联系方式
	 * 
	 * @param requestDTO
	 *            memberId contactType
	 * @return
	 */
	public MAGetContactResponseDTO getContactByMemberId(final String memberId, final ContactType contactType) ;
}
