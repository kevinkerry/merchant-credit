package com.sdp.mc.easypay.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 注册基本信息
 */
public class EnterpriseRegisterBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1158153650934520634L;
	// ID
	private String id;
	// 手机号
	private String phoneNo;
	// 商户名称
	private String merchantName;
	// 姓名
	private String linkMan;
	// 门店名称
	private String shopName;
	// 市编码
	private String cityCode;
	// 市名称
	private String cityName;
	// 安装地址
	private String bussinessAddr;
	// 邮箱
	private String email;
	// 代理商商户号
	private String proxyMerchantId;
	// 主营类型
	private String bussinessType;
	// 费率
	private BigDecimal fee;
	// 注册状态
	private String status;
	// 商户号
	private String merchantNo;
	// sessionId
	private String sessionId;
	// 请求来源
	private String reqSource;
	// 二维码
	private String scanCode;
	// 同步到T0 状态
	private String syncMc;
	// 保存、提交标示
	private String realNameStatus;
	// 创建时间
	private String createTime;
	// 更新时间
	private String updateTime;
	// 详细地址
	private String address;
	// 省编码
	private String provinceCode;
	// 省名称
	private String provinceName;
	// 商务联系人电话
	private String linkTel;

	private String openAccountRespNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBussinessAddr() {
		return bussinessAddr;
	}

	public void setBussinessAddr(String bussinessAddr) {
		this.bussinessAddr = bussinessAddr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProxyMerchantId() {
		return proxyMerchantId;
	}

	public void setProxyMerchantId(String proxyMerchantId) {
		this.proxyMerchantId = proxyMerchantId;
	}

	public String getBussinessType() {
		return bussinessType;
	}

	public void setBussinessType(String bussinessType) {
		this.bussinessType = bussinessType;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getReqSource() {
		return reqSource;
	}

	public void setReqSource(String reqSource) {
		this.reqSource = reqSource;
	}

	public String getScanCode() {
		return scanCode;
	}

	public void setScanCode(String scanCode) {
		this.scanCode = scanCode;
	}

	public String getSyncMc() {
		return syncMc;
	}

	public void setSyncMc(String syncMc) {
		this.syncMc = syncMc;
	}

	public String getRealNameStatus() {
		return realNameStatus;
	}

	public void setRealNameStatus(String realNameStatus) {
		this.realNameStatus = realNameStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getOpenAccountRespNo() {
		return openAccountRespNo;
	}

	public void setOpenAccountRespNo(String openAccountRespNo) {
		this.openAccountRespNo = openAccountRespNo;
	}

}
