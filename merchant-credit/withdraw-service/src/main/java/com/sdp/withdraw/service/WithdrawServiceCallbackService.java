package com.sdp.withdraw.service;

import com.sdp.mc.integration.fos.dto.response.WithdrawBackOrderStatusDTO;

public interface WithdrawServiceCallbackService {
    /**
     * 处理FOS回掉
     * @param responseDto
     */
	void dealwithFosCallBack(WithdrawBackOrderStatusDTO responseDto);

}
