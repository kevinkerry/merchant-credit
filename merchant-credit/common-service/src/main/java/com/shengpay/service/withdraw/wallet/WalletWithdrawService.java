package com.shengpay.service.withdraw.wallet;

import java.util.List;

import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.entity.WalletWithdrawReqDTO;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryResponse;
import com.sdp.withdraw.vo.wallet.WalletWithdrawRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawResult;

public interface WalletWithdrawService {

	boolean checkRequestUnqiue(String appId, String orderNo);

	WalletWithdrawReqDO createWalletWithdrawData(WalletWithdrawRequest walletWithdrawRequest);

	WalletWithdrawReqDO queryWalletWithdrawReqByReqId(Long reqId);

	int updateDataStatus(Long reqId, int status, Long traceNo);
	
	int updateDataStatus(Long reqId, int sourceStatus, int targetStatus);

	WalletWithdrawResult queryWalletWithdrawInfo(Long reqId);

	WalletWithdrawQueryResponse queryWalletWithdrawInfo(WalletWithdrawQueryRequest walletWithdrawQueryRequest);

	WalletWithdrawReqDO getWalletWithdrawReqDO(String appId, String orderNo);

	List<WalletWithdrawReqDO> selectByQuery(WalletWithdrawReqDTO query);

	int easypayWalletWithdrawFailRetry();

}
