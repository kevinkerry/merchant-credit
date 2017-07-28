package com.sdp.mc.common.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.sdp.mc.common.util.MapUtil;

/**
 * (登录的)商户用户对象，放于session
 *
 * @author liuxi.xiliu
 */
public class MCMerchantUser {
	/**
	 * 存放于session中的用户信息
	 */
	public static final String MC_MERCHANT_USER = "MC_MERCHANT_USER";

	/**
	 * 用户锁定状态11：快速刷功能被锁
	 */
	public static final Integer USER_STATUS_FAST_OPERATER_LOCKED = 11;

	/**
	 * 用户状态
	 */
	private Integer userStatus = 1;

	/**
	 * 会员id-操作员的memberId就是商户号的memberId
	 */
	private String memberId;

	/**
	 * 管理员登录名
	 */
	private String adminLoginName;

	/**
	 * 操作员登录名
	 */
	private String operatorLoginName;

	/**
	 * 操作员id
	 */
	private String operatorId;

	/**
	 * 管理员标志
	 */
	private Boolean adminFlag = false;

	/**
	 * 显示的用户名称(如果是管理员，为登录的账号，如果是操作员，为操作员)
	 */
	private String displayUserName;
	/**
	 * msp系统代理商编号id
	 * **/
	private Long promoterId;
	/**
	 * msp系统商户编号id
	 * **/
	private Long merchantId;

	/**
	 * 商户号(盛付通6位商户号)
	 */
	private String merchantNo;

	/**
	 * 是否开通了(任意一种)业务标志。即是否是POS商户、代理商、mpos代理商...
	 */
	private Boolean hasBussFlag = false;

	/**
	 * 商户类型列表
	 */
	private List<String> merchantTypeList;

	/**
	 * 商户类型（多个商户类型间以","间隔开）
	 */
	private String merchantTypes;

	/**
	 * 是否POS商户类型0001
	 */
	private Boolean isPosMerchantType = false;

	/**
	 * POS商户类型对应的商户名称
	 */
	private String posMerchantName;

	/**
	 * 是否POS拓展商类型0003
	 */
	private Boolean isPosPromoterType = false;
	
	private Boolean isBatchPromoter = false;

	/**
	 * POS拓展商类型对应的商户名称
	 */
	private String posPromoterMerchantName;

	/**
	 * 是否MPOS拓展商类型0007
	 */
	private Boolean isMposPromoterType = false;

	/**
	 * MPOS拓展商类型对应的商户名称
	 */
	private String mposPromoterMerchantName;

	/**
	 * 是否MPOS拓展商类型0009
	 */
	private Boolean isMposSDKPromoterType = false;

	/**
	 * 是否 MPost 合作方
	 */
	private Boolean isMposPartnerPromoterType = false;
	
	/**
	 * MposSDK拓展商类型对应的商户名称
	 */
	private String mposSDKPromoterMerchantName;

	/**
	 * 是否机具厂商0010
	 */
	private Boolean isFactoryType = false;

	/**
	 * 机具厂商类型对应的商户名称
	 */
	private String factoryMerchantName;

	/**
	 * 用户权限集合
	 */
	private Map<String, String> rules;

	/**
	 * 上次操作时间
	 */
	private long lastOperateTime = 0;

	/**
	 * 上次操作功能
	 */
	private String lastOperateFunction = "";

	/**
	 * 快速规操作计数，用于拦截恶意请求，达到一定次数会被记录黑名单
	 */
	private Integer fastOperateTimes = 0;

	/**
	 * 是否集团商户
	 */
	private Boolean isGroupMerchantType = false;

	/**
	 * 操作员所辖商户信息列表（可直接用于merchant_no in (...)）
	 *
	 * 当操作员是集团商户时：操作员的集团商户号 + 所辖子商户号列表 当操作员是独立商户时：操作员的商户号
	 */
	private String operatorAllMerchantNos;

	private String currentMcType;

	private Map<String, Object> mcTypeDtoMap;
	
	private Integer currentlevel = 0;

	/**
	 * 从session中获取登录的用户对象
	 */
	public static MCMerchantUser getMCMerchantUser(HttpSession session) {
		Object o = session.getAttribute(MC_MERCHANT_USER);
		return o == null ? null : (MCMerchantUser) o;
	}

	/**
	 * 取得用户具体信息，用于展示
	 */
	public String getFullInfo() {
		StringBuffer strb = new StringBuffer();
		strb.append("memberId:").append(this.memberId).append(", ").append("adminLoginName:").append(this.adminLoginName).append(", ")
				.append("operatorLoginName:").append(this.operatorLoginName).append(", ").append("operatorId:").append(this.operatorId).append(", ")
				.append("adminFlag:").append(this.adminFlag).append(", ").append("displayUserName:").append(this.displayUserName).append(", ")
				.append("merchantNo:").append(this.merchantNo).append(", ").append("hasBussFlag:").append(this.hasBussFlag).append(", ")
				.append("isPosMerchantType:").append(this.isPosMerchantType).append(", ").append("isPosPromoterType:").append(this.isPosPromoterType)
				.append(", ").append("isMposPromoterType:").append(this.isMposPromoterType).append(", ").append("rules:")
				.append(MapUtil.getKeysForString(this.rules, ",")).append(", ").append("lastOperateTime:").append(this.lastOperateTime).append(", ")
				.append("lastOperateFunction:").append(this.lastOperateFunction);
		return strb.toString();
	}

	public String getCurrentMcType() {
		return currentMcType;
	}

	public void setCurrentMcType(String currentMcType) {
		this.currentMcType = currentMcType;
	}

	public Map<String, Object> getMcTypeDtoMap() {
		return mcTypeDtoMap;
	}

	public void setMcTypeDtoMap(Map<String, Object> mcTypeDtoMap) {
		this.mcTypeDtoMap = mcTypeDtoMap;
	}

	/**
	 * 是否拥有某权限
	 */
	public Boolean hasRule(String ruleCode) {
		return adminFlag ? true : this.getRules() == null ? false : this.getRules().containsKey(ruleCode);
	}

	public String getAdminLoginName() {
		return adminLoginName;
	}

	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}

	public String getOperatorLoginName() {
		return operatorLoginName;
	}

	public void setOperatorLoginName(String operatorLoginName) {
		this.operatorLoginName = operatorLoginName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getDisplayUserName() {
		return displayUserName;
	}

	public void setDisplayUserName(String displayUserName) {
		this.displayUserName = displayUserName;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public long getLastOperateTime() {
		return lastOperateTime;
	}

	public void setLastOperateTime(long lastOperateTime) {
		this.lastOperateTime = lastOperateTime;
	}

	public String getLastOperateFunction() {
		return lastOperateFunction;
	}

	public void setLastOperateFunction(String lastOperateFunction) {
		this.lastOperateFunction = lastOperateFunction;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public Boolean getIsPosMerchantType() {
		return isPosMerchantType;
	}

	public void setIsPosMerchantType(Boolean isPosMerchantType) {
		this.isPosMerchantType = isPosMerchantType;
	}

	public String getPosMerchantName() {
		return posMerchantName;
	}

	public void setPosMerchantName(String posMerchantName) {
		this.posMerchantName = posMerchantName;
	}

	public Boolean getIsPosPromoterType() {
		return isPosPromoterType;
	}

	public void setIsPosPromoterType(Boolean isPosPromoterType) {
		this.isPosPromoterType = isPosPromoterType;
	}

	public String getPosPromoterMerchantName() {
		return posPromoterMerchantName;
	}

	public void setPosPromoterMerchantName(String posPromoterMerchantName) {
		this.posPromoterMerchantName = posPromoterMerchantName;
	}

	public Boolean getIsMposPromoterType() {
		return isMposPromoterType;
	}

	public void setIsMposPromoterType(Boolean isMposPromoterType) {
		this.isMposPromoterType = isMposPromoterType;
	}

	public String getMposPromoterMerchantName() {
		return mposPromoterMerchantName;
	}

	public void setMposPromoterMerchantName(String mposPromoterMerchantName) {
		this.mposPromoterMerchantName = mposPromoterMerchantName;
	}

	public Boolean getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(Boolean adminFlag) {
		this.adminFlag = adminFlag;
	}

	public Map<String, String> getRules() {
		return rules;
	}

	public void setRules(Map<String, String> rules) {
		this.rules = rules;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getFastOperateTimes() {
		return fastOperateTimes;
	}

	public void setFastOperateTimes(Integer fastOperateTimes) {
		this.fastOperateTimes = fastOperateTimes;
	}

	public Boolean getHasBussFlag() {
		return hasBussFlag;
	}

	public void setHasBussFlag(Boolean hasBussFlag) {
		this.hasBussFlag = hasBussFlag;
	}

	public Boolean getIsMposSDKPromoterType() {
		return isMposSDKPromoterType;
	}

	public void setIsMposSDKPromoterType(Boolean isMposSDKPromoterType) {
		this.isMposSDKPromoterType = isMposSDKPromoterType;
	}

	public String getMposSDKPromoterMerchantName() {
		return mposSDKPromoterMerchantName;
	}

	public void setMposSDKPromoterMerchantName(String mposSDKPromoterMerchantName) {
		this.mposSDKPromoterMerchantName = mposSDKPromoterMerchantName;
	}

	public Boolean getIsFactoryType() {
		return isFactoryType;
	}

	public void setIsFactoryType(Boolean isFactoryType) {
		this.isFactoryType = isFactoryType;
	}

	public String getFactoryMerchantName() {
		return factoryMerchantName;
	}

	public void setFactoryMerchantName(String factoryMerchantName) {
		this.factoryMerchantName = factoryMerchantName;
	}

	public List<String> getMerchantTypeList() {
		return merchantTypeList;
	}

	public void setMerchantTypeList(List<String> merchantTypeList) {
		this.merchantTypeList = merchantTypeList;
	}

	public String getMerchantTypes() {
		return merchantTypes;
	}

	public void setMerchantTypes(String merchantTypes) {
		this.merchantTypes = merchantTypes;
	}

	public Boolean getIsGroupMerchantType() {
		return isGroupMerchantType;
	}

	public void setIsGroupMerchantType(Boolean isGroupMerchantType) {
		this.isGroupMerchantType = isGroupMerchantType;
	}

	public String getOperatorAllMerchantNos() {
		return operatorAllMerchantNos;
	}

	public void setOperatorAllMerchantNos(String operatorAllMerchantNos) {
		this.operatorAllMerchantNos = operatorAllMerchantNos;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Boolean getIsMposPartnerPromoterType() {
		return isMposPartnerPromoterType;
	}

	public void setIsMposPartnerPromoterType(Boolean isMposPartnerPromoterType) {
		this.isMposPartnerPromoterType = isMposPartnerPromoterType;
	}

	public Boolean getIsBatchPromoter() {
		return isBatchPromoter;
	}

	public void setIsBatchPromoter(Boolean isBatchPromoter) {
		this.isBatchPromoter = isBatchPromoter;
	}

	public Integer getCurrentlevel() {
		return currentlevel;
	}

	public void setCurrentlevel(Integer currentlevel) {
		this.currentlevel = currentlevel;
	}
	
	
	

}
