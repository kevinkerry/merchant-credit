package com.sdp.mc.receipt;

import com.sdp.mc.integration.receipt.dto.request.FundOutReceiptSubmitRequestDTO;
import com.sdp.mc.integration.receipt.dto.response.ReceiptResultDTO;

/**
 * 凭证库提交接口
 * @author zhangyulong
 *
 */
public interface ReceiptRemoteService {
	/**
     * 出款凭证批量接口
     *
     * @param request
     * @return
     */
    public ReceiptResultDTO submitFundOutReceipt(FundOutReceiptSubmitRequestDTO request);
}
