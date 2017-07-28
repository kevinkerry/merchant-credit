package com.sdp.mc.easypay.vo;

import java.io.Serializable;

import com.sdp.mc.easypay.fileManager.UploadFileResponse;

/**
 * 注册认证信息
 */
public class EnterpriseRegisterAuthInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8817938462636434202L;
	// ID
	private String id;
	// 姓名
	private String realName;
	// 法人联系电话
	private String operatorTel;
	// 身份证编码
	private String idcard;
	// 营业执照编码
	private String certifyCode;
	// 经办人类型
	private String operatorType;
	// 营业执照发证机关
	private String certifyAuthOrg;
	// 营业执照有效起始时间
	private String certifyStartTime;
	// 营业执照有效结束时间
	private String certifyEndTime;
	// 身份证有效起始时间
	private String idcardStartTime;
	// 身份证有效结束时间
	private String idcardEndTime;
	// 营业执照证件照
	private String certifyImg;
	// 身份证正面照
	private String idcardFrontImg;
	// 身份证反面照
	private String idcardReverseImg;
	// 委托书图片
	private String authorizeImg;
	// 税务登记证
	private String taxRegistImg;
	// 组织机构代码
	private String orgCode;
	// 合同影印件
	private String contractImg;
	// 组织机构代码证
	private String orgCodeImg;
	// 银行开户证明
	private String bankAccountImg;
	// 场地照片（门牌）
	private String siteImg1;
	// 场地照片（前台）
	private String siteImg2;
	// 场地照片（营业区域）
	private String siteImg3;
	// 场地图片（写字楼外观）
	private String siteImg4;
	// 创建时间
	private String createTime;
	// 更新时间
	private String updateTime;

	private String registerId;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getOperatorTel() {
		return operatorTel;
	}

	public void setOperatorTel(String operatorTel) {
		this.operatorTel = operatorTel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getCertifyCode() {
		return certifyCode;
	}

	public void setCertifyCode(String certifyCode) {
		this.certifyCode = certifyCode;
	}

	public String getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	public String getCertifyAuthOrg() {
		return certifyAuthOrg;
	}

	public void setCertifyAuthOrg(String certifyAuthOrg) {
		this.certifyAuthOrg = certifyAuthOrg;
	}

	public String getCertifyStartTime() {
		return certifyStartTime;
	}

	public void setCertifyStartTime(String certifyStartTime) {
		this.certifyStartTime = certifyStartTime;
	}

	public String getCertifyEndTime() {
		return certifyEndTime;
	}

	public void setCertifyEndTime(String certifyEndTime) {
		this.certifyEndTime = certifyEndTime;
	}

	public String getIdcardStartTime() {
		return idcardStartTime;
	}

	public void setIdcardStartTime(String idcardStartTime) {
		this.idcardStartTime = idcardStartTime;
	}

	public String getIdcardEndTime() {
		return idcardEndTime;
	}

	public void setIdcardEndTime(String idcardEndTime) {
		this.idcardEndTime = idcardEndTime;
	}

	public String getCertifyImg() {
		return certifyImg;
	}

	public void setCertifyImg(String certifyImg) {
		this.certifyImg = certifyImg;
	}

	public String getIdcardFrontImg() {
		return idcardFrontImg;
	}

	public void setIdcardFrontImg(String idcardFrontImg) {
		this.idcardFrontImg = idcardFrontImg;
	}

	public String getIdcardReverseImg() {
		return idcardReverseImg;
	}

	public void setIdcardReverseImg(String idcardReverseImg) {
		this.idcardReverseImg = idcardReverseImg;
	}

	public String getAuthorizeImg() {
		return authorizeImg;
	}

	public void setAuthorizeImg(String authorizeImg) {
		this.authorizeImg = authorizeImg;
	}

	public String getTaxRegistImg() {
		return taxRegistImg;
	}

	public void setTaxRegistImg(String taxRegistImg) {
		this.taxRegistImg = taxRegistImg;
	}

	public String getContractImg() {
		return contractImg;
	}

	public void setContractImg(String contractImg) {
		this.contractImg = contractImg;
	}

	public String getOrgCodeImg() {
		return orgCodeImg;
	}

	public void setOrgCodeImg(String orgCodeImg) {
		this.orgCodeImg = orgCodeImg;
	}

	public String getBankAccountImg() {
		return bankAccountImg;
	}

	public void setBankAccountImg(String bankAccountImg) {
		this.bankAccountImg = bankAccountImg;
	}

	public String getSiteImg1() {
		return siteImg1;
	}

	public void setSiteImg1(String siteImg1) {
		this.siteImg1 = siteImg1;
	}

	public String getSiteImg2() {
		return siteImg2;
	}

	public void setSiteImg2(String siteImg2) {
		this.siteImg2 = siteImg2;
	}

	public String getSiteImg3() {
		return siteImg3;
	}

	public void setSiteImg3(String siteImg3) {
		this.siteImg3 = siteImg3;
	}

	public String getSiteImg4() {
		return siteImg4;
	}

	public void setSiteImg4(String siteImg4) {
		this.siteImg4 = siteImg4;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

}
