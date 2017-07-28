package com.sdp.mc.service.op;

import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpStateResponse;

public interface OpService {

	/**
	 * 請求處理方法
	 * 
	 * @param context
	 *            請求相關數據，如：開通／關閉，追加／退回
	 * @param code
	 *            状态对应枚举的code
	 * @return
	 */

	public abstract OpStateResponse handler(OpContext context, int code,String operatorId);

}