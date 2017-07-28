package com.sdp.mc.web.interceptor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.util.BrowserChecker;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.util.ListUtil;
import com.sdp.mc.common.util.MCUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.ma.wrapper.IOperatorServiceWrapper;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.ma.wrapper.OrgServiceWrapper;
import com.sdp.mc.service.authorize.AuthService;
import com.sdp.mc.service.contract.MerchantContractService;
import com.sdp.mc.service.lockoperator.LockOperatorService;
import com.sdp.mc.service.userloginlog.UserLoginLogService;
import com.sdp.mc.service.userloginlog.UserLoginLogTO;
import com.shengpay.spa.msso.client.filter.callback.HttpSessionCasMerchantFilterCallback;
import com.shengpay.spa.msso.client.vo.ValidatedUserInfo;

/**
 * 用户信息信息拦截器
 * 
 * @author liuxi.xiliu
 */
public class MCMerchantUserInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private LockOperatorService lockOperatorService;

	@Autowired
	private MerchantContractService merchantContractService;

	@Autowired
	private AuthService authService;

	@Autowired
	private UserLoginLogService mspUserLoginLogService;

	@Autowired
	private OrgServiceWrapper orgServiceWrapper;

	@Autowired
	private IOperatorServiceWrapper operatorServiceWrapper;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Value("${cas.casUrl}")
	private String casURL;
	@Value("${mc.website.quit.url}")
	private String quitURL;

	/**
	 * 不需要检验用户的请求
	 */
	private List<String> noNeedCheckMCMerchantUserRequest;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	public String getCurrentMcType(String uri) {
		if (uri.contains(MerchantCreditConstant.MERCHANT_PREFIX_MPOSMERCHANT))
			return MerchantContractCst.TYPE_MPOS_MERCHANT;
		else if (uri.contains(MerchantCreditConstant.MERCHANT_PREFIX_POSMERCHANT))
			return MerchantContractCst.TYPE_POS_MERCHANT;
		else if (uri.contains(MerchantCreditConstant.MERCHANT_PREFIX_MPOSPROMOTER))
			return MerchantContractCst.TYPE_MPOS_PROMOTER;
		else if (uri.contains(MerchantCreditConstant.MERCHANT_PREFIX_POSPROMOTER))
			return MerchantContractCst.TYPE_PROMOTER;
		else if (uri.contains(MerchantCreditConstant.MERCHANT_PREFIX_MPOS_PARTNER_PROMOTER))
			return MerchantContractCst.TYPE_MPOS_PARTNER_PROMOTER;
		else return null;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("quitURL", quitURL);
		request.setAttribute("casURL", casURL);

		String mcType = getCurrentMcType(request.getRequestURI());

		if (noNeedCheckMCMerchantUserRequest != null && noNeedCheckMCMerchantUserRequest.contains(MCUtil.getFunctionName(request))) { return true; }

		HttpSession session = request.getSession();
		// session中保存的mspMerchantUser
		Object mspMerchantUserObj = session.getAttribute(MCMerchantUser.MC_MERCHANT_USER);
		String userType = null;
		if (mspMerchantUserObj != null) {
			userType = ((MCMerchantUser) mspMerchantUserObj).getCurrentMcType();
			// MCMerchantUser mcUser = (MCMerchantUser) mspMerchantUserObj;
			// String userType = mcUser.getCurrentMcType();
		}

		if (mspMerchantUserObj == null || (userType != null && mcType != null && !userType.equalsIgnoreCase(mcType))) {
			Object validatedUserObj = session.getAttribute(HttpSessionCasMerchantFilterCallback.USER_SESSION_KEY);
			if (validatedUserObj == null) {
				if (request.getRequestURI().endsWith(".json")) {
					response.setContentType("application/json;charset=utf-8");
					ErrorMessageVO error = new ErrorMessageVO(false, "nologin", "请重新登录");
					PrintWriter pw = response.getWriter();
					pw.write(JSONObject.fromObject(error).toString());
					pw.flush();
					pw.close();
					return false;
				} else {
					// ----跳到首页(这时会被sso拦截，跳到登录页面)-------
					response.sendRedirect(request.getContextPath() + "/common/main/index.htm");
					return false;
				}
			}

			// 登录用户的会员号,都是操作员
			ValidatedUserInfo validatedUserInfo = (ValidatedUserInfo) validatedUserObj;
			String memberId = validatedUserInfo.getMemberId();
			if (memberId == null) {
				logger.error("----memberId is null----, validatedUserInfo:[ adminLoginName:" + validatedUserInfo.getAdminLoginName()
						+ ", operatorLoginName:" + validatedUserInfo.getOperatorLoginName() + ", memberId:" + validatedUserInfo.getMemberId()
						+ ", operatorId:" + validatedUserInfo.getOperatorId() + ", loginTime:" + validatedUserInfo.getLoginTime()
						+ ", securityLevel:" + validatedUserInfo.getSecurityLevel());
				throw new RuntimeException();
			}

			logger.info("queryMerchantNoByUserMemberId.memberId=" + memberId);
			String merchantNo = this.maOnlineWrapper.queryMerchantNoByUserMemberId(memberId, IPUtils.getClientIP(request));

			logger.info("mspFacade.findPromoterInfoByPromoterNo.merchantNo=" + merchantNo);
			MCMerchantUser u = this.makeMcMerchantUser(merchantNo, mcType, validatedUserInfo);

			session.setAttribute(MCMerchantUser.MC_MERCHANT_USER, u);
			// 记录用户登录日志
			UserLoginLogTO to = new UserLoginLogTO();
			to.setMemberId(memberId);
			to.setOperatorId(validatedUserInfo.getOperatorId());
			to.setOperatorLoginName(validatedUserInfo.getOperatorLoginName());
			to.setAdminLoginName(validatedUserInfo.getAdminLoginName());
			to.setMerchantNo(merchantNo);
			to.setMerchantName("");
			to.setMerchantType(u.getMerchantTypes());
			to.setGroupMerchant(u.getIsGroupMerchantType());
			to.setLoginIp(IPUtils.getClientIP(request));
			to.setBrowserName(BrowserChecker.getBrowserType(request));// 浏览器类型
			to.setOsName(BrowserChecker.getOSType(request));// 操作系统类型
			to.setUserAgent(request.getHeader("user-agent"));
			to.setLoginTime(new Date());
			try {
				mspUserLoginLogService.addUserLoginLog(to);
			} catch (Exception e) {
				logger.error("----mspUserLoginLogService.addUserLoginLog error, memberId:" + memberId, e);
			}
		}

		/**
		 * 切换 当前登录的 merchantId 和 promoterId
		 */
		MCMerchantUser u = (MCMerchantUser) request.getSession().getAttribute(MCMerchantUser.MC_MERCHANT_USER);
		if (StringUtils.isNotEmpty(mcType) && !u.getCurrentMcType().equalsIgnoreCase(mcType)) {
			getPromoterInfoDTOByMcType(u, u.getMerchantNo(), mcType);
		}

		// 如果是代理商则进行白名单校验
		if (u.getIsPosPromoterType() || u.getIsMposPromoterType()) {
			String whiteList = ConfigOptionHelper.getConfigByKey(ConfigOptionHelper.FAST_SETTLE_PROMOTER_WHITE_LIST);
			if (StringUtils.isNotBlank(whiteList)) {
				if (!whiteList.contains(u.getMerchantNo())) {
					// 如果不在白名单则跳转到空白页提示
					response.sendRedirect(request.getContextPath() + "/common/main/gotoEmpty.htm");
					return false;
				}
			}
		}
		if (!u.getHasBussFlag()) {
			String info = "您尚未签约线下收单产品，无法使用线下收单作业平台，谢谢！";
			session.setAttribute("info", info);
			if ("common/main/index".equals(MCUtil.getFunctionName(request))) {
				logger.error("----error merchant : " + u.getMerchantNo() + ", no product for msp ");
				response.sendRedirect(request.getContextPath() + "/common/main/index.htm");
			}
		}

		return true;
	}

	/**
	 * 组装MspMerchantUser对象
	 */
	private MCMerchantUser makeMcMerchantUser(String merchantNo, String mcType, ValidatedUserInfo validatedUserInfo) {
		// ----将MspMerchantUser对象放入session--------------
		MCMerchantUser u = new MCMerchantUser();
		u.setAdminLoginName(validatedUserInfo.getAdminLoginName());
		u.setOperatorLoginName(validatedUserInfo.getOperatorLoginName());
		u.setMemberId(validatedUserInfo.getMemberId());
		u.setOperatorId(validatedUserInfo.getOperatorId());
		u.setDisplayUserName(u.getOperatorLoginName() == null ? u.getAdminLoginName() : u.getOperatorLoginName());
		u.setMerchantNo(merchantNo);
		u.setAdminFlag(u.getOperatorLoginName() == null ? true : false);
		u.setCurrentMcType(mcType);
		// if (promoterInfoDTO != null)
		// u.setPromoterId(promoterInfoDTO.getPromoterId());
		try {
			boolean belongs2Group = this.orgServiceWrapper.belongs2Group(merchantNo);
			u.setIsGroupMerchantType(belongs2Group);
		} catch (Exception e) {
			logger.error(
					"remote invoke iOrgWS.checkMerchantOrgNode error, memberId:" + validatedUserInfo.getMemberId() + ",merchantNo=" + merchantNo, e);
			throw new RuntimeException("remote invoke iOrgWS.checkMerchantOrgNode error, memberId:" + validatedUserInfo.getMemberId()
					+ ",merchantNo=" + merchantNo);
		}

		String operatorAllMerchantNos = "";
		String groupMerchantNos = "";
		if (u.getIsGroupMerchantType()) {// 集团商户
			try {
				String merchantNos[] = this.operatorServiceWrapper.queryMerchantNoByOperatorId(validatedUserInfo.getOperatorId());
				groupMerchantNos = ListUtil.join(merchantNos, "'", "'", ",");
			} catch (Exception e) {
				logger.error("remote invoke iOperatorService.QueryOperatorMemberScope error, operatorId:" + validatedUserInfo.getOperatorId(), e);
				throw new RuntimeException();
			}
		}
		if (!"".equals(groupMerchantNos)) {
			operatorAllMerchantNos = groupMerchantNos + ",'" + merchantNo + "'";
		} else {
			operatorAllMerchantNos = "'" + merchantNo + "'";
		}
		u.setOperatorAllMerchantNos(operatorAllMerchantNos);

		// ----取得合同管理(cm)的商户信息，可能有多种类型-------------
		List<Map<String, Object>> typeList = merchantContractService.selectMerchantTypes(merchantNo);
		List<String> merchantTypeList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		for (Map<String, Object> map : typeList) {
			String merchantType = (map.get("MC_TYPE_C") == null ? null : String.valueOf(map.get("MC_TYPE_C")));
			String merchantName = (map.get("MC_MERCHANT_NAME_V") == null ? null : String.valueOf(map.get("MC_MERCHANT_NAME_V")));
			if (MerchantContractCst.TYPE_POS_MERCHANT.equals(merchantType)) {
				u.setIsPosMerchantType(true);
				u.setHasBussFlag(true);
				u.setPosMerchantName(merchantName);
			} else if (MerchantContractCst.TYPE_PROMOTER.equals(merchantType)) {
				u.setIsPosPromoterType(true);
				u.setHasBussFlag(true);
				u.setPosPromoterMerchantName(merchantName);
			} else if (MerchantContractCst.TYPE_MPOS_PROMOTER.equals(merchantType)) {
				u.setIsMposPromoterType(true);
				u.setHasBussFlag(true);
				u.setMposPromoterMerchantName(merchantName);
			} else if (MerchantContractCst.TYPE_MPOS_SDK_PROMOTER.equals(merchantType)) {
				u.setIsMposSDKPromoterType(true);
				u.setHasBussFlag(true);
				u.setMposSDKPromoterMerchantName(merchantName);
			} else if (MerchantContractCst.TYPE_FACTORY.equals(merchantType)) {
				u.setIsFactoryType(true);
				u.setHasBussFlag(true);
				u.setFactoryMerchantName(merchantName);
			} else if (MerchantContractCst.TYPE_MPOS_PARTNER_PROMOTER.equals(merchantType)) {
				u.setHasBussFlag(true);
				u.setPosMerchantName(merchantName);
				u.setIsMposPartnerPromoterType(true);
			}
			merchantTypeList.add(merchantType);
			sb.append(merchantType).append(",");
		}
		String merchantTypesStr = "";
		if (sb.lastIndexOf(",") != -1) {
			merchantTypesStr = sb.substring(0, sb.lastIndexOf(","));
		}
		u.setMerchantTypeList(merchantTypeList);
		u.setMerchantTypes(merchantTypesStr);

		// ----如果是非管理员，取得所有权限------------
		if (!u.getAdminFlag()) {
			u.setRules(authService.getAllRules(u.getOperatorId()));
		}

		// ----取得操作员的锁定记录--------------
		Integer lockStatus = lockOperatorService.getLockStatusByOperatorId(u.getOperatorId());
		if (lockStatus != null) {
			u.setUserStatus(lockStatus);
		}

		getPromoterInfoDTOByMcType(u, merchantNo, mcType);
		return u;
	}

	public void setNoNeedCheckMCMerchantUserRequest(List<String> noNeedCheckMspMerchantUserRequest) {
		this.noNeedCheckMCMerchantUserRequest = noNeedCheckMspMerchantUserRequest;
	}

	protected PromoterInfoDTO getPromoterInfoDTOByMcType(MCMerchantUser u, String merchantNo, String mcType) {
		PromoterInfoDTO promoterInfoDTO = null;

		if (u.getCurrentMcType() == null || u.getCurrentMcType().isEmpty()) {
			String type = u.getMerchantTypeList().get(0);
			u.setCurrentMcType(type);
			mcType = type;
		}

		promoterInfoDTO = mspFacade.findPromoterInfoByPromoterNoAndType(merchantNo, mcType);
		if (promoterInfoDTO != null) u.setPromoterId(promoterInfoDTO.getPromoterId());
		if (promoterInfoDTO == null) {
			MerchantInfoDTO merchantInfoDTO = mspFacade.findMerchantInfoByMerchantNo(merchantNo, mcType);
			u.setMerchantId(Long.parseLong(merchantInfoDTO.getMerchantId()));
			u.setPromoterId(merchantInfoDTO.getPromoterId());
		}
		u.setCurrentlevel(promoterInfoDTO.getPmtLevel()==null?0:promoterInfoDTO.getPmtLevel());
		return promoterInfoDTO;

	}
}
