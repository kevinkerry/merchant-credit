package com.sdp.mc.service.userloginlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sdp.mc.dao.userloginlog.McUserLoginLogDAO;

/**
 * MSP用户登录日志
 * @author dengxb
 * @date 2014-2-17 上午10:10:13
 */
@Service( "mcUserLoginLogService" )
public class UserLoginLogServiceImpl implements UserLoginLogService{
	
	@Autowired
	@Qualifier( "mcUserLoginLogDAO" )
	private McUserLoginLogDAO mcUserLoginLogDAO;
	
	/**
	 * 新增用户登录日志
	 * @return
	 */
	@Override
	public Long addUserLoginLog(UserLoginLogTO to){
		return mcUserLoginLogDAO.insert(to);
	}
}
