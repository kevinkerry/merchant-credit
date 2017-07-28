package com.sdp.mc.sars;


/**
 * sars服务封装
 * 
 * @author liuxi.xiliu
 */
public interface SarsService {
	
	/**
	 * T+0风控接入
	 * 
	 * @param json
	 * @return
	 * @throws RuntimeException
	 */
	public boolean sarsClientVerify(String json) throws RuntimeException;
}
