package com.sdp.mc.verify;

import java.util.List;

import com.shengpay.verify.common.facade.model.VerifyInfo;

public interface VerifyQueryServiceClient {

	/**
	 * 验证查询的信息
	 * 
	 * @param memberId
	 * @return
	 */
	boolean authenticateVerifyInfoByMemberid(String memberId);

	/**
	 * 查询验证信息
	 * 
	 * @param memberId
	 * @return
	 */
	VerifyInfo queryVerifyInfoByMemberid(String memberId);
    /**
     * 通过会员ID获取身份相关的会员信息
     * @param memberId
     * @return
     */
	List<String> getMemberIdsByMercnhantNo(String merchantNo);
    /**
     * 通过身份证号获取身份相关的会员信息
     * @param idcardNo
     * @return
     */
	List<String> getMemberIdsByIdcardNoNew(String idcardNo);


}
