package com.sdp.mc.web.interceptor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.util.MCUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.dao.lockoperator.LockOperatorEO;
import com.sdp.mc.service.lockoperator.ADDLockOperatorPO;
import com.sdp.mc.service.lockoperator.LockOperatorService;

/**
 * 请求拦截器
 *
 * @author liuxi.xiliu
 */
public class RequestInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 默认恶意操作者锁定时间（分钟）
	 */
	private static int LOCK_TIME_DEFAULT = 30;
	/**
	 * 不需要检验来源的请求地址
	 */
	private List<String> noNeedCheckRefererRequest;

	/**
	 * 允许的来源前缀
	 */
	private List<String> allowedRefererPrefix;

	private Long allowedOperateInterval;

	@Autowired
	private LockOperatorService lockOperatorService;

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 拦截功能
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// ----session中没有用户信息，允许通过-----------
		MCMerchantUser merchantUser = MCMerchantUser.getMCMerchantUser(request
				.getSession());
		if (merchantUser == null) {
			return true;
		}

		String functionName = MCUtil.getFunctionName(request);
		if (StringUtils.isNotBlank(functionName)) {
			if (functionName.indexOf("/file") > 0
					|| functionName.indexOf("/credit") > 0) {
				return true;
			}
		}

		// ----检查referer-----------
//		if (!this.checkReferer(request)) {
//			return false;
//		}

		/**
		 * 检查操作者的锁定状态及是否到了解锁状态
		 */
		if (!this.checkOperatorLockStatus(merchantUser, request, response)) {
			return false;
		}

		// ----检查操作时间间隔-------------
		if (!this.checkOperatingInterval(merchantUser, request)) {
			return false;
		}

		// ----用label、菜单的信息-------------
		this.forLabelAndMenu(request);

		return true;
	}

	/**
	 * 检查referer
	 */
	@SuppressWarnings("unused")
	private boolean checkReferer(HttpServletRequest request) {
		// ----不需要检验来源的请求地址，允许通过------------
		String functionName = MCUtil.getFunctionName(request);
		for (String u : noNeedCheckRefererRequest) {
			if (functionName.equals(u)) {
				return true;
			}
		}

		// ----空referer不能通过-----------
		String referer = request.getHeader("referer");
		if (StringUtils.isBlank(referer)) {
			logger.info(" referer not allowed [" + referer + "]---> : "
					+ request.getRequestURI());
			return false;
		}

		// ----检验请求的来源，允许的才能通过---------------
		boolean passCheck = false;
		for (String u : allowedRefererPrefix) {
			if (referer.startsWith(u)) {
				passCheck = true;
				break;
			}
		}

		if (!passCheck) {
			logger.info(" referer not allowed [" + referer + "]---> : "
					+ request.getRequestURI());
			return false;
		}

		return true;
	}

	/**
	 * 检查操作员的锁定状态
	 *
	 * @throws IOException
	 */
	private boolean checkOperatorLockStatus(MCMerchantUser MCMerchantUser,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		LockOperatorEO eo = lockOperatorService
				.getLockOperatorLast(MCMerchantUser.getOperatorId());
		if (null != eo && null != eo.getLockTime()) {
			String lockTimeStr = ConfigOptionHelper
					.getValue(ConfigOptionHelper.OPERATOR_ACCESS_LOCK_TIME);
			long lockTimeLeft = lockTimeLeft(eo.getLockTime(),
					StringUtils.isEmpty(lockTimeStr) ? LOCK_TIME_DEFAULT
							: Integer.parseInt(lockTimeStr));
			if (lockTimeLeft > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(calcTimeJs());
				sb.append("<body onload='clock();return true'>由于恶意操作，您的账号已被锁定,");
				sb.append(wrapperHtml(lockTimeLeft));
				sb.append("后自动解锁，建议使用Chrome、Firefox或IE浏览器,勿使用360浏览器。如有疑问，请联系客服</body>");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print(sb.toString());
				return false;
			}
		}
		return true;
	}

	private String calcTimeJs() {
		String jsHtml = " <script language='JavaScript'> "
				+ " function clock(){"
				+ " var hh = document.getElementById('hh').innerHTML; "
				+ " var mm = document.getElementById('mm').innerHTML; "
				+ " var ss = document.getElementById('ss').innerHTML; "
				+ " if(ss*1>0){ "
				+ " 	ss = ss-1;	"
				+ "	document.getElementById('ss').innerHTML = (ss<10?'0'+ss:ss); "
				+ " } else {"
				+ "	if(mm*1>0){ "
				+ "		mm = mm-1 ;"
				+ " 		document.getElementById('mm').innerHTML = (mm<10?'0'+mm:mm); "
				+ "		document.getElementById('ss').innerHTML = 59; "
				+ "	}else{ "
				+ "		if(hh*1>0){ "
				+ "			hh = hh-1; "
				+ "			document.getElementById('mm').innerHTML = (hh<10?'0'+hh:hh ); "
				+ "			document.getElementById('mm').innerHTML = 59; "
				+ "			document.getElementById('ss').innerHTML = 59; "
				+ "		} else {" + "			location.reload(); " + "			return ; "
				+ "		}" + " 	} " + " }" + " setTimeout('clock()',1000); "
				+ " } " +

				"</script>";
		return jsHtml;
	}

	/**
	 * 离自动解锁的剩余时间
	 *
	 * @param lockTime
	 * @param lockInternalTime
	 * @return
	 */
	private long lockTimeLeft(Date lockTime, int lockInternalTime) {
		long nowTime = new Date().getTime();
		return (lockTime.getTime() + lockInternalTime * 60 * 1000 - nowTime);
	}

	private String wrapperHtml(long lockTimeLeft) {
		int hour = 0;
		int minute = 0;
		long second = 0;
		second = Long.parseLong(lockTimeLeft + "") / 1000;
		if (second > 60) {
			minute = (int) (second / 60);
			second = second % 60;
		}

		if (minute > 60) {
			hour = minute / 60;
			minute = minute % 60;
		}
		String html = "<span id='hh'>" + (hour < 10 ? "0" + hour : hour)
				+ "</span> 小时 " + "<span id='mm'>"
				+ (minute < 10 ? "0" + minute : minute) + "</span> 分 "
				+ "<span id='ss'>" + (second < 10 ? "0" + second : second)
				+ "</span> 秒";
		return html;
	}

	/**
	 * 检查操作时间间隔
	 */
	private boolean checkOperatingInterval(MCMerchantUser mcMerchantUser,
			HttpServletRequest request) {
		String lastOperateFunction = mcMerchantUser.getLastOperateFunction();
		long lastOperateTime = mcMerchantUser.getLastOperateTime();
		mcMerchantUser.setLastOperateFunction(request.getRequestURI());
		mcMerchantUser.setLastOperateTime(System.currentTimeMillis());
		if (mcMerchantUser.getLastOperateFunction().equals(lastOperateFunction)) {
			long timeInterval = mcMerchantUser.getLastOperateTime()
					- lastOperateTime;
			if (timeInterval < allowedOperateInterval) {
				logger.info("checkOperatingFrequency [timeInterval]:"
						+ timeInterval + ", [function]:" + lastOperateFunction
						+ ", [memberId]:" + mcMerchantUser.getMemberId()
						+ ", [adminLoginName]:"
						+ mcMerchantUser.getAdminLoginName()
						+ ", [operatorLoginName]:"
						+ mcMerchantUser.getOperatorLoginName());

				// ----记录累计快刷次数，达到上限，锁定状态------------
				mcMerchantUser.setFastOperateTimes(mcMerchantUser
						.getFastOperateTimes() + 1);
				if (mcMerchantUser.getFastOperateTimes() >= ConfigOptionHelper.MAX_FAST_OPEATER_TIMES) {
					mcMerchantUser
							.setUserStatus(MCMerchantUser.USER_STATUS_FAST_OPERATER_LOCKED);
					this.addFastOperaterLockOperator(mcMerchantUser, request,
							MCMerchantUser.USER_STATUS_FAST_OPERATER_LOCKED);
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * 用label、菜单的信息
	 */
	private void forLabelAndMenu(HttpServletRequest request) {
		String functionName = MCUtil.getFunctionName(request);
		request.setAttribute("thisFn", functionName);
		request.setAttribute("label", request.getParameter("label$"));

		// ----菜单所属：我是XXX-----------
		String mType$ = request.getParameter("mType$");
		if (StringUtils.isNotBlank(mType$)) {
			request.setAttribute("mType", mType$);
		} else {
			request.setAttribute("mType",
					functionName.substring(0, functionName.indexOf("/")));
		}
	}

	/**
	 * 保存操作员锁定记录，(因快刷)
	 */
	private void addFastOperaterLockOperator(MCMerchantUser u,
			HttpServletRequest request, Integer lockStatus) {
		ADDLockOperatorPO po = new ADDLockOperatorPO();
		po.setOperatorId(u.getOperatorId());
		po.setOperatorName(u.getDisplayUserName());
		po.setMerchantNo(u.getMerchantNo());
		po.setMerchantType("");
		po.setLockStatus(lockStatus);
		po.setClientIp(IPUtils.getClientIP(request));
		po.setLockMemo("");
		po.setLockTime(new Date());
		lockOperatorService.addLockOperator(po);

	}

	public List<String> getNoNeedCheckRefererRequest() {
		return noNeedCheckRefererRequest;
	}

	public void setNoNeedCheckRefererRequest(
			List<String> noNeedCheckRefererRequest) {
		this.noNeedCheckRefererRequest = noNeedCheckRefererRequest;
	}

	public List<String> getAllowedRefererPrefix() {
		return allowedRefererPrefix;
	}

	public void setAllowedRefererPrefix(List<String> allowedRefererPrefix) {
		this.allowedRefererPrefix = allowedRefererPrefix;
	}

	public long getAllowedOperateInterval() {
		return allowedOperateInterval;
	}

	public void setAllowedOperateInterval(long allowedOperateInterval) {
		this.allowedOperateInterval = allowedOperateInterval;
	}

}
