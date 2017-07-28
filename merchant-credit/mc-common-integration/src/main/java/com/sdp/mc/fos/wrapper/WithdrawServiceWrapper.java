package com.sdp.mc.fos.wrapper;

import com.sdp.mc.integration.fos.dto.request.WithdrawT0QueryRequestDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0QueryResponseDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawT0ResponseDTO;

/**
 * 出款服务
 * @author wangmindong
 *
 */
public interface WithdrawServiceWrapper {

	/**
	 * FOS出款
	 * @param request
	 * @return
	 */
	public WithdrawT0ResponseDTO withdraw(WithdrawT0RequestDTO request);

	/**
	 * FOS状态查询
	 * @param request
	 * @return
	 */
	public WithdrawT0QueryResponseDTO withdrawQuery(WithdrawT0QueryRequestDTO request);
}
