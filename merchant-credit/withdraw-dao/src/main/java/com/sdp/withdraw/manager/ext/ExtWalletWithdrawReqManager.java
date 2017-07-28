package com.sdp.withdraw.manager.ext;

import com.sdp.withdraw.dao.ext.ExtWalletWithdrawReqDTO;
/**
 * 钱包出款申请扩展Manager
 * @author liyantao
 *
 */
public interface ExtWalletWithdrawReqManager{

	ExtWalletWithdrawReqDTO queryWalletWithdrawInfo(Long reqId);

	
}
