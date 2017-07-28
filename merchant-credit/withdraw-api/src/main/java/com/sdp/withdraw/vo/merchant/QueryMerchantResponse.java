package com.sdp.withdraw.vo.merchant;

import java.util.List;

import com.sdp.withdraw.vo.BaseResponse;

public class QueryMerchantResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3649337144144157859L;

	private List<MerchantInfo> merchantInfos;

	public List<MerchantInfo> getMerchantInfos() {
		return merchantInfos;
	}

	public void setMerchantInfos(List<MerchantInfo> merchantInfos) {
		this.merchantInfos = merchantInfos;
	}

	public QueryMerchantResponse() {
		super();
	}

	public QueryMerchantResponse(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}
	

}