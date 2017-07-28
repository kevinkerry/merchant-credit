package com.mc.service.api;

import com.mc.service.api.dto.WhiteListDTO;



public interface WhiteListInfoAPI {
	
	public  WhiteListDTO getWhiteListInfo(String merchantNo,String merchantType,int type);

	
}
