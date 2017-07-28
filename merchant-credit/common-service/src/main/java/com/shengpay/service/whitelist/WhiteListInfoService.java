package com.shengpay.service.whitelist;

import java.util.List;

import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.dataobjct.WhiteListInfoDTO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;

public interface WhiteListInfoService {

	List<WhiteListInfoDO> queryWhiteListInfo(WhiteListInfoDOExample query);

	WhiteListInfoDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(WhiteListInfoDO infoDo);
	
	WhiteListInfoDO queryWhiteListInfo(Integer type,String merchantNo,String merchantType);
	
	WhiteListFeeBean queryWhiteFee(Integer type,String merchantNo,String merchantType);
	
	List<WhiteListInfoDO> queryWhiteListInfo(Integer type);
	
	List<WhiteListInfoDO> queryWhiteListInfo(String merchantNo,String merchantType);
	
	List<WhiteListInfoDO> queryWhiteListInfo(String merchantNo);

	List<WhiteListInfoDO> selectByQuery(WhiteListInfoDTO query);

	Long insert(WhiteListInfoDO config);

	int updateLoseEfficacy(Long id,String opUser);

	Long createWhiteInfo(Integer code, String merchantNo, String mcType,String content,String opUser);

	WhiteListInfoDO queryWhiteListInfo(Integer code, String merchantNo, String merchantType, String promoterMerchantNo, String promoterType);

	int updateWhiteInfo(Long id, String content, String operatorId);


}
