package com.sdp.mc.web.action;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import com.alibaba.fastjson.JSON;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.common.web.MerchantPromoterInfo;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.integration.ma.dto.PersionalInfoDTO;
import com.sdp.mc.integration.ma.dto.request.CheckPayPwdRequestDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.ues.UESClient;
import com.sdp.mc.web.dto.AddMarginReqDTO;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;
import com.shengpay.ues.model.UesResult;
import com.shengpay.ues.util.UesUtils;

public class BaseAction {

	private static Logger logger = LoggerFactory.getLogger(BaseAction.class);

	private static final String UTF8 = "UTF-8";
	protected static final String CONTENT_TYPE = "application/octet-stream";

	private UESClient uesClient;

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Autowired
	protected MspFacade mspFacade;

	@Autowired
	protected ScSettleBaseService scSettleBaseService;

	@Autowired
	private FileManagerService fileManagerService;

	/**
	 * 密码参数
	 */
	public static final String PARAMETER_PASSWORD = "password";

	/**
	 * 密码参数
	 */
	public static final String PARAMETER_ENCRYPTEDKEY = "encryptedKey";

	/**
	 * 密码参数
	 */
	public static final String PARAMETER_CERTSERIALNO = "certSerialNo";

	/**
	 * 获取商户以及代理商信息
	 * 
	 * @param request
	 */
	protected MerchantPromoterInfo getMerchantPromoterInfo(HttpServletRequest request) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		MerchantPromoterInfo merchantPromoterInfo = new MerchantPromoterInfo();
		// 商户号
		merchantPromoterInfo.setMerchantNo(user.getMerchantNo());
		// 商户名称
		if (StringUtils.isNotEmpty(user.getPosMerchantName())) {
			merchantPromoterInfo.setMerchantName(user.getPosMerchantName());
		} else if (StringUtils.isNotEmpty(user.getMposPromoterMerchantName())) {
			merchantPromoterInfo.setMerchantName(user.getMposPromoterMerchantName());
		}
		// 代理商商户号
		Long promoterId = user.getPromoterId();
		if (promoterId != null) {
			PromoterInfoDTO promoterInfoDTO = mspFacade.findPromoterInfoByPromoterId(promoterId);
			merchantPromoterInfo.setPromoterNo(String.valueOf(promoterInfoDTO.getPromoterNo()));
			// 代理商名称
			merchantPromoterInfo.setPromoterName(promoterInfoDTO.getName());
		}
		return merchantPromoterInfo;

	}

	/**
	 * 有支付密码的页面初始
	 * 
	 * @param model
	 * @throws Exception
	 */
	protected void payPwdInit(ModelMap model) throws Exception {
		UesResult result = maOnlineWrapper.getCert();
		if ("000".equals(result.getResultCode())) {
			// 这两值放在页面的隐藏域里
			model.put("sActivexPubKey", "-----BEGIN CERTIFICATE-----\n" + result.getData() + "\n-----END CERTIFICATE-----");
			model.put("certSerialNo", UesUtils.getSerialNoFromBase64Cert(result.getData()));
		}
	}

	@SuppressWarnings("rawtypes")
	protected ErrorMessageVO checkMarginSecPwd(MCMerchantUser user, AddMarginReqDTO addMarginReqDTO, HttpServletRequest request) {
		String loginName = user.getDisplayUserName();
		ErrorMessageVO errorMessage = checkSecPwd(user.getMemberId(), loginName, user.getOperatorId(), addMarginReqDTO.getPasswrod(),
				addMarginReqDTO.getEncryptedKey(), addMarginReqDTO.getCertSerialNo(), AccountType.B_BASE_ACCOUNT, request);
		return errorMessage;
	}

	@SuppressWarnings("rawtypes")
	protected ErrorMessageVO checkSecPwd(String memberId, String loginName, String operatorId, String passwrod, String encryptedKey,
			String certSerialNo, AccountType accountType, HttpServletRequest request) {
		CheckPayPwdRequestDTO requestDTO = new CheckPayPwdRequestDTO();
		String accountId = maOnlineWrapper.queryAccount(memberId, request.getRemoteAddr(), accountType);
		requestDTO.setLoginName(loginName);
		requestDTO.setAccountId(accountId);
		requestDTO.setOperatorId(operatorId);
		requestDTO.setPassword(passwrod);
		requestDTO.setEnKey(encryptedKey);
		requestDTO.setCertNo(certSerialNo);
		logger.info("request check pay password:" + requestDTO.toString());
		ErrorMessageVO errorMessage = maOnlineWrapper.checkPayPwd(requestDTO);
		logger.info("reponse check pay password:" + errorMessage.toString());
		return errorMessage;
	}

	/**
	 * 验证密码
	 * 
	 * @param persionalInfoDTO
	 * @param password
	 * @param encryptedKey
	 * @param operatorId
	 * @param certSerialNo
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected ErrorMessageVO checkPassword(PersionalInfoDTO persionalInfoDTO, HttpServletRequest request) {
		CheckPayPwdRequestDTO requestDTO = new CheckPayPwdRequestDTO();
		requestDTO.setLoginName(persionalInfoDTO.getLoginName());
		requestDTO.setAccountId(persionalInfoDTO.getWalletAccount());
		requestDTO.setOperatorId(persionalInfoDTO.getOperatorId());
		requestDTO.setPassword(request.getParameter(PARAMETER_PASSWORD));
		requestDTO.setEnKey(request.getParameter(PARAMETER_ENCRYPTEDKEY));
		requestDTO.setCertNo(request.getParameter(PARAMETER_CERTSERIALNO));

		logger.info("request check pay password:" + requestDTO.toString());
		ErrorMessageVO errorMessage = maOnlineWrapper.checkPayPwd(requestDTO);
		logger.info("reponse check pay password:" + errorMessage.toString());
		return errorMessage;
	}

	/**
	 * 向response里面写入返回的json
	 * 
	 * @param response
	 * @param obj
	 */
	public static void writeJson(final HttpServletResponse response, final Object obj, String... agentType) {
		try {
			response.setCharacterEncoding("UTF-8");
			if (agentType.length > 0) {
				if (agentType[0].equals("ie10")) {
					response.setContentType("application/htm");
				} else if (!agentType[0].equals("ie10") && agentType[0].indexOf("ie") >= 0) {
					response.setContentType("application/htm");
				} else {
					response.setContentType("application/json");
				}
			} else {
				response.setContentType("application/json");
			}

			Writer writer = response.getWriter();
			String json = JSON.toJSONString(obj);
			logger.info("writer response json:" + json);
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.error("BaseAction.writeJson.error" + e.getMessage(), e);
		}
	}

	/**
	 * 判断浏览器版本
	 * 
	 * @param agent
	 * @return
	 */
	public static String getBrowserName(String agent) {
		if (agent.indexOf("msie 7") > 0) {
			return "ie7";
		} else if (agent.indexOf("msie 8") > 0) {
			return "ie8";
		} else if (agent.indexOf("msie 9") > 0) {
			return "ie9";
		} else if (agent.indexOf("msie 10") > 0) {
			return "ie10";
		} else if (agent.indexOf("msie") > 0) {
			return "ie";
		} else if (agent.indexOf("opera") > 0) {
			return "opera";
		} else if (agent.indexOf("firefox") > 0) {
			return "firefox";
		} else if (agent.indexOf("webkit") > 0) {
			return "webkit";
		} else if (agent.indexOf("gecko") > 0 && agent.indexOf("rv:11") > 0) {
			return "ie11";
		} else {
			return "Others";
		}
	}

	protected void fileDownloadsView(String key, String fileName, HttpServletResponse response, String contentType) throws Exception {
		OutputStream os = null;
		try {
			fileName = URLDecoder.decode(fileName, UTF8);
			response.reset();
			response.setHeader("Expires", "0");
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Cache-Control", "public");
			response.setContentType(contentType);
			if (StringUtils.isNotEmpty(contentType) && contentType.indexOf("image") >= 0) {
				response.addHeader("Content-Disposition", contentType + "; filename=" + URLEncoder.encode(fileName, UTF8));
			} else {
				response.addHeader("Content-Disposition", "attachment" + "; filename=" + URLEncoder.encode(fileName, UTF8));
			}
			response.setBufferSize(1024);

			DownloadFileResponse downloadFileResponse = fileManagerService.downLoadFile(key);
			byte[] fileByte = downloadFileResponse.getDownloadByte();
			os = new BufferedOutputStream(response.getOutputStream());
			os.write(fileByte);
		} catch (Exception e) {
			logger.error("downloadView,{}", e.getMessage(), e);
			throw e;
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (Exception e) {
				logger.error("fileDownloadsView,{}", e.getMessage(), e);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void inputSettleTypeEnums2PageSelect(HttpServletRequest request, ModelMap model) {
		MCMerchantUser user = MCMerchantUser.getMCMerchantUser(request.getSession());
		String mcType = user.getCurrentMcType();
		List list = new ArrayList();
		// Map<String,String> map = new HashMap<String,String>();
		if (MerchantContractCst.TYPE_MPOS_PROMOTER.equalsIgnoreCase(mcType)||MerchantContractCst.TYPE_MPOS_PARTNER_PROMOTER.equalsIgnoreCase(mcType)) {
			// list.add(WithdrawServiceTypeEnums.T0_MPOS_Withdraw);
			Map<String, Object> map1 = new HashMap<String, Object>();
			map1.put("code", WithdrawServiceTypeEnums.T0.code);
			map1.put("type", WithdrawServiceTypeEnums.T0.type);
			list.add(map1);
			// list.add(WithdrawServiceTypeEnums.T1_MPOS_Withdraw);
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("code", WithdrawServiceTypeEnums.T1.code);
			map2.put("type", WithdrawServiceTypeEnums.T1.type);
			list.add(map2);
			// list.add(WithdrawServiceTypeEnums.D1_MPOS_Withdraw);
			Map<String, Object> map3 = new HashMap<String, Object>();
			map3.put("code", WithdrawServiceTypeEnums.D1.code);
			map3.put("type", WithdrawServiceTypeEnums.D1.type);
			list.add(map3);
		} else {
			// list.add(WithdrawServiceTypeEnums.T0_POS_Withdraw);
			Map<String, Object> map4 = new HashMap<String, Object>();
			map4.put("code", WithdrawServiceTypeEnums.T0.code);
			map4.put("type", WithdrawServiceTypeEnums.T0.type);
			list.add(map4);
		}
		model.put("settleTypes", list);
	}

	public UESClient getUesClient() {
		return uesClient;
	}

	public MspFacade getMspFacade() {
		return mspFacade;
	}

	public ScSettleBaseService getScSettleBaseService() {
		return scSettleBaseService;
	}

}
