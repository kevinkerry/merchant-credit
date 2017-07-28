package com.sdp.mc.cs;

public interface ICSQueryPartyGroup {
	
	/**
	 * 查询是否为后付费
	 * @param memberId 用户ID
	 * @return
	 */
	boolean queryPartyGroupByMemberId(String memberId);
	
}
