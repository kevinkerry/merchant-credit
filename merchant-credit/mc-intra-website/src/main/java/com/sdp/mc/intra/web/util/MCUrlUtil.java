package com.sdp.mc.intra.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sdp.emall.intra.admin.administrator.dao.dataobject.ActAdminUserDO;
import com.sdp.emall.intra.admin.common.vo.AuthBaseAdminUser;
import com.sdp.emall.intra.admin.common.vo.UrlPermission;
import com.sdp.emall.intra.admin.permission.dao.dataobject.ActAdminPermissionDO;
import com.sdp.emall.intra.admin.security.util.SecurityUserHolder;
import com.sdp.mc.common.web.MCMerchantUser;

/**
 * 本项目的专用util
 * 
 * @author liuxi.xiliu
 */
public class MCUrlUtil {

	
	public static boolean canAccessUrl(String url, HttpServletRequest request) {
		// ----session中没有权限信息，即开发模式下，允许-----------
//		MCMerchantUser u = MCMerchantUser.getMCMerchantUser(request.getSession());
		AuthBaseAdminUser admin=SecurityUserHolder.getAuthUser(); 
		if (admin == null) {
			return false;
		}

		// ----如果是管理员，允许-----------
//		if (u.getAdminFlag()) {
//			return true;
//		}
		List<ActAdminPermissionDO> list=admin.getPermissions(); 
		if(list==null||list.isEmpty()){
			return false;
		}
		for(ActAdminPermissionDO actDo:list){
//			System.out.println("==="+actDo.getActionUrl());
			if(actDo.getActionUrl().startsWith(url)){
				return true;
			}
		}

		// ----如果有权限，允许-----------
		/*Map<String, UrlPermission> map=admin.getUrlPermissionMap();
		if(map==null||map.isEmpty()){
			return false;
		}
		for(Iterator<String> it=map.keySet().iterator();it.hasNext();){
			String key=it.next();
			System.out.println(key);
			if(key.startsWith(url)){
				return true;
			}
		}*/
		return false;
	}

	/**
	 * 计算目标日期与当前时间之间的天数
	 * @param endDate 还款日
	 * @param dueRepaymentTime 逾期还款日
	 * **/
	public static int daysBetween(Date endDate,Date dueRepaymentTime) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			endDate = sdf.parse(sdf.format(endDate));
			long time1 = endDate.getTime();
			Date date2 = dueRepaymentTime == null ? new Date() : dueRepaymentTime;
			Date currentDate = sdf.parse(sdf.format(date2));
			long time2 = currentDate.getTime();
			long between_days = (time2 - time1) / 1000 / 60 / 60 / 24;
			return (int) between_days;
		} catch (Exception e) {
			return 0;
		}
	}
}
