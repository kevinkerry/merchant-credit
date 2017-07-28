package com.sdp.mc.service.userloginlog;




/**
 * MSP用户登录日志
 * @author dengxb
 * @date 2014-2-17 上午09:44:25
 */
public interface UserLoginLogService {
	
	/**
	 * 新增用户登录日志
	 * @return
	 */
	public Long addUserLoginLog(UserLoginLogTO to);
}
