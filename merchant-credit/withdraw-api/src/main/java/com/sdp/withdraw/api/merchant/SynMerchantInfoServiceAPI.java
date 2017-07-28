package com.sdp.withdraw.api.merchant;

import java.util.List;

import javax.jws.WebService;

import com.sdp.withdraw.vo.merchant.MerchantInfoRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantRequest;
import com.sdp.withdraw.vo.merchant.QueryMerchantResponse;
import com.sdp.withdraw.vo.merchant.QueryPromoterRequest;
import com.sdp.withdraw.vo.merchant.QueryPromoterResponse;
import com.sdp.withdraw.vo.merchant.SynMerchantRequest;
import com.sdp.withdraw.vo.merchant.SynPromoterRequest;
import com.sdp.withdraw.vo.merchant.SynResponse;

@WebService
public interface SynMerchantInfoServiceAPI {

	public SynResponse createOrUpdatePromoter(SynPromoterRequest promoterRequest);

	public SynResponse createOrUpdateMerchant(SynMerchantRequest merchantRequest);
	
	public SynResponse batchUpdatePromoter(List<SynMerchantRequest> merchantRequests );

	public QueryMerchantResponse queryMerchantInfo(QueryMerchantRequest request);
	
	public QueryPromoterResponse queryPromoterInfo(QueryPromoterRequest request);
	
	public SynResponse synchMerchantInfo(MerchantInfoRequest merchantInfoRequest);
}