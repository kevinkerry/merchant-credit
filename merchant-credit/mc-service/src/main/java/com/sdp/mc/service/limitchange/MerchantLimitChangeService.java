package com.sdp.mc.service.limitchange;

import java.util.List;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;



public interface MerchantLimitChangeService {

	List<Newt0McLimitChangeReqDO> queryMarchatLimitChange(Newt0McLimitChangeReqDOExample query);

	List<Newt0McLimitChangeDtlDO> queryMarchatLimitChangeDetailByReqId(Long reqId);

	Long createMarchatLimitChangeReq(String fileName,
			List<String[]> marchatInfoList);

	Newt0McLimitChangeReqDO getReqDoByReqId(Long reqId);

	void updateReqDo(Newt0McLimitChangeReqDO reqDo);

	void updateDetailDo(Newt0McLimitChangeDtlDO detailDo);

	long changeMerchantLimit(Newt0McLimitChangeDtlDO detailDo, String operatorId) throws Exception;

	Newt0McLimitChangeReqDO createAutoChangeMarchatLimitChangeReq(
			List<PromoterFastSettleSwitchDOExt> list);

	void createReqDetailDo(Newt0McLimitChangeDtlDO detailDo);
   
	
}
