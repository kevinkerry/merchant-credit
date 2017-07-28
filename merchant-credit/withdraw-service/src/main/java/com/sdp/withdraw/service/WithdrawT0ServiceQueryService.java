package com.sdp.withdraw.service;

import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;


/**

 */
public interface WithdrawT0ServiceQueryService {

	WithdrawT0QueryResponseDTO queryWithdrawInfo(String remitVoucherNo);

	String dealwithFosWithdrawQueryResponse(WithdrawT0QueryResponseDTO responseDTO, WithdrawReqDO withdrawReqDO, WithdrawReqFosDetailDO detailDo);

	WithdrawT0QueryResponseDTO queryWithdrawInfo(WithdrawReqFosDetailDO detailDo);
	

	
}
