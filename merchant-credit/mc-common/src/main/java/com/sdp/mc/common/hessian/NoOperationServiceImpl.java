package com.sdp.mc.common.hessian;

import org.springframework.stereotype.Service;


/**
 * Hessian用于检测接口是否可用的Service.
 *
 *
 */
@Service("noOperationService")
public class NoOperationServiceImpl implements NoOperationService {

	/* (non-Javadoc)
	 * @see com.sdo.netbar.netbarsys.common.hessian.NoOperationService#nop()
	 */
	@Override
	public void nop() {
		//不需要实现.
	}

}
