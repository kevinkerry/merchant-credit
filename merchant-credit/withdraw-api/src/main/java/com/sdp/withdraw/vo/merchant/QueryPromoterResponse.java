package com.sdp.withdraw.vo.merchant;

import java.util.List;

import com.sdp.withdraw.vo.BaseResponse;

public class QueryPromoterResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3649337144144157859L;

	private List<PromoterInfo> promoterInfos;

	public List<PromoterInfo> getPromoterInfos() {
		return promoterInfos;
	}

	public void setPromoterInfos(List<PromoterInfo> promoterInfos) {
		this.promoterInfos = promoterInfos;
	}

	public QueryPromoterResponse(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public QueryPromoterResponse() {
		super();
	}
	
	
	

}