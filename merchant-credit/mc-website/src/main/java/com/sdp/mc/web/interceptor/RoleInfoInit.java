package com.sdp.mc.web.interceptor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sdp.mc.service.authorize.AuthService;

@Component
public class RoleInfoInit {
	
	@Autowired
	private AuthService authServce;
	@PostConstruct
	private void initRoleInfo(){
		authServce.init();
	}

}
