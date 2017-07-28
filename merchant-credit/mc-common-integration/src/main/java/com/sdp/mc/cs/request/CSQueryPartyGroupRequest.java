package com.sdp.mc.cs.request;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.cs.ICSQueryPartyGroup;
import com.shengpay.cs.facade.PartyGroupFacade;
import com.shengpay.cs.facade.model.PartyGroup;
import com.shengpay.cs.facade.model.req.GroupsByMemberQueryRequest;
import com.shengpay.cs.facade.model.resp.GroupsByMemberQueryResponse;

import net.sf.json.JSONArray;

@Service("CSQueryPartyGroup")
public class CSQueryPartyGroupRequest implements ICSQueryPartyGroup {
	
	private static Logger logger = LoggerFactory.getLogger(CSQueryPartyGroupRequest.class);
	
	@Autowired
	PartyGroupFacade partyGroupFacade;
	
	@Value("${cs.facade.delay_id_pay}")
    private String delayIdPay;
	
	@Value("${cs.facade.delay_id_take}")
    private String delayIdTake;
	
	@Override
	public boolean queryPartyGroupByMemberId(String memberId) {		
		try{
			logger.info("CSQueryPartyGroupRequest.queryPartyGroupByMemberId memberId=" + memberId + " delayIdPay:"+delayIdPay+" delayIdTake:"+delayIdTake);
			GroupsByMemberQueryRequest request = new GroupsByMemberQueryRequest();
			request.setMemberId(memberId);
			GroupsByMemberQueryResponse response;
			response = partyGroupFacade.query(request);
			List<PartyGroup> groups = response.getParyGroup();
			JSONArray jsonArray = JSONArray.fromObject(groups);
			String jsonStr = jsonArray.toString();
			logger.info("CSQueryPartyGroupRequest.queryPartyGroupByMemberId groups:" + jsonStr);
			boolean isPayGroup = false;
			boolean isTakeGroup = false;
			for(PartyGroup group : groups){
				if(group.getId() == Long.parseLong(delayIdPay.trim())&&StringUtils.isNotBlank(delayIdPay)) {
					logger.info("CSQueryPartyGroupRequest.queryPartyGroupByMemberId delayIdPay:" + group.getId() + " name:"+group.getName());
					isPayGroup = true;
				}
				if(group.getId() == Long.parseLong(delayIdTake.trim())&&StringUtils.isNotBlank(delayIdTake)){
					logger.info("CSQueryPartyGroupRequest.queryPartyGroupByMemberId delayIdTake:" + group.getId() + " name:"+group.getName());
					isTakeGroup = true;
				}
				if(isPayGroup && isTakeGroup) return true;
			}
		} catch(Exception e) {
			logger.error("CSQueryPartyGroupRequest.queryPartyGroupByMemberId", e);
		}
		
		return false;
	}
	
	public void setPartyGroupFacade(PartyGroupFacade partyGroupFacade){
		this.partyGroupFacade = partyGroupFacade;
	}
	
}
