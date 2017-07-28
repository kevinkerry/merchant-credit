package com.sdp.mc.newt0.dao.mapper.ext;

import java.math.BigDecimal;

public class ExtNewt0SdpRemainBalanceSqlProvider {


	public String selectByExampleByUpdate() {
		StringBuffer sql = new StringBuffer();

		sql.append(" select ID,START_TIME,QUOTA,CREATE_TIME,UPDATE_TIME,END_TIME,CAN_USE_QUOTA,FROZEN_QUOTA,USED_QUOTA from NEWT0_SDP_REMAIN_BALANCE where 1=1 ");
		sql.append(" and start_time<=sysdate");
		sql.append(" and end_time>=sysdate");
		sql.append(" and CAN_USE_QUOTA > "+new BigDecimal(0));
		sql.append(" for update ");
		return sql.toString();
	}
}
