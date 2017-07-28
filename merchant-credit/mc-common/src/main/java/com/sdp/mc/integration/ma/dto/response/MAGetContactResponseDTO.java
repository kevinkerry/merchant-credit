package com.sdp.mc.integration.ma.dto.response;

import com.sdp.mc.integration.ma.dto.MABaseDTO;

public class MAGetContactResponseDTO extends MABaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 是否创建成功
	 * **/
	private boolean isSuccess;
	/**
	 * 返回码
	 */
	private String responseCode;

	/**
	 * 返回消息描述
	 */
	private String responseMessage;
	/**
	 * 请求序列号
	 */
	private String requestNo;

	/**
	 * 联系人名，必须填写
	 */
	private String contactName;

	/**
	 * 国家，名称
	 */
	private String countryCode;

	/**
	 * 省份，名称
	 */
	private String provinceCode;

	/**
	 * 城市，名称
	 */
	private String cityCode;

	/**
	 * 城镇/区/街
	 */
	private String town;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮政编码
	 */
	private String postcode;

	/**
	 * 网站
	 */
	private String website;

	/**
	 * 传真
	 */
	private String fax;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 电话
	 */
	private String tel;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * QQ
	 */
	private String qq;

	/**
	 * MSN
	 */
	private String msn;

	/**
	 * 职位
	 */
	private String position;

	/**
	 * 部门
	 */
	private String dept;

	public MAGetContactResponseDTO(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
