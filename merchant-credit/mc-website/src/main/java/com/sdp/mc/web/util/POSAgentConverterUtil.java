package com.sdp.mc.web.util;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.service.op.state.OpStateResponse;

public class POSAgentConverterUtil {

	public static final ErrorMessageVO buildErrorMessageVO(OpStateResponse reponse) {
		if (reponse == null) {
			return null;
		}
		ErrorMessageVO error = new ErrorMessageVO(reponse.isSuccess());
		error.setErrorCode(reponse.getErrorCode());
		error.setErrorMessage(reponse.getMessage());
		return error;
	}

}
