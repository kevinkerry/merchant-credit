package com.sdp.mc.ma.wrapper;

import com.sdo.ma.ws.api.model.AccountInfo;
import com.sdo.ma.ws.api.response.online.GetMemberInfoResponse;
import com.sdo.ma.ws.api.response.online.MemberMappingResponse;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.MerchantInfoMADTO;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.ma.dto.request.CheckPayPwdRequestDTO;
import com.shengpay.ues.model.UesResult;

public interface MaOnlineWrapper {
	/**
	 * 根据memberId和accounType查询储值帐号id
	 * **/
	public String queryAccount(final String memberId, final String userIp, final AccountType accountType);

	/**
	 * 根据memberId和accountId查询储值帐号AccountType
	 * **/
	public Long queryAccountType(final String memberId, final String accountId, final String userIp);

	/**
	 * 根据登录用户查询商户号
	 *
	 * @param loginUserMemberId
	 * @param userIp
	 * **/
	public String queryMerchantNoByUserMemberId(final String loginUserMemberId, final String userIp);

	/**
	 * 验证支付密码；如果密码错误返回扩展信息。
	 *
	 * @param requestDTO
	 * @return #ErrorMessageVO
	 */
	@SuppressWarnings("rawtypes")
	public ErrorMessageVO checkPayPwd(CheckPayPwdRequestDTO requestDTO);

	public UesResult getCert();

	/**
	 * 根据商户号查询对应的memberId和默认的操作员id
	 *
	 * @param merchantNo商户号
	 * **/
	public Promoter4MADTO queryPromoterInfoByMerchantNo(String merchantNo);

	/**
	 * 查询到个人用户信息
	 *
	 * @param loginName
	 * @return
	 */
	public PersionalInfoDTO getPersionalMemberId(String loginName);

	/**
	 * 查询商户信息
	 *
	 * @param merchantNo
	 *            商户号
	 * @return
	 */
	public MerchantInfoMADTO queryMAMerchantInfoByMerchantNo(String merchantNo);

	/**
	 * 查询付款账号信息
	 *
	 * @param memberId
	 * @param userIp
	 * @param accountType
	 * @return
	 */
	public AccountInfo queryBaseAccountInfo(final String memberId, final String userIp);

	/**
	 * 会员基本信息查询。memberId和identity二选一。
	 *
	 * @param identity
	 * @param memberId
	 * @return
	 */
	public GetMemberInfoResponse getMemberInfo(final String identity, final String memberId);

	/**
	 * 获得会员标识映射关系。
	 *
	 * @param id
	 * @param idType
	 * 映射关系中会员标识的类型：
	 *  1：会员编号memberId
	 *  2：盛大通行证PT
	 *  3：盛大数字账号SDID
	 *  4：伪盛大通行证VPT
	 *  5：伪盛大数字账号VSDID
	 * @return
	 */
	public MemberMappingResponse getMemberMapping(final String id, final Long idType);
}
