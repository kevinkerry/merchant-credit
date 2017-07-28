package com.shengpay.debit.common.risk.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.shengpay.model.fileManager.UploadFileResponse;

/**
 * 额度申请定制页面
 * @author zhangyulong
 *
 */
public class CreditLineApplyRequest implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6589437937316389589L;
	/**
	 * 申请人姓名
	 */
	private String applicantName;

	/**
	 * 申请人身份证号
	 */
	private String applicantIdNo;

	/**
	 * 身份证照片正面信息（上传）
	 */
	private UploadFileResponse positiveCardFileInfo;

	/**
	 * 身份证照片背面信息（上传）
	 */
	private UploadFileResponse backCardFileInfo;

	/**
	 * 申请人性别
	 */
	private String applicantSex;

	/**
	 * 申请人婚姻状况
	 */
	private String maritalStatus;

	/**
	 * 本人及子女户口本信息（上传）
	 */
	private UploadFileResponse accountBookFileInfo;

	/**
	 * 子女数量
	 */
	private String quantityOfChildren;

	/**
	 * 申请额度
	 */
	private BigDecimal applicantAmount;

	/**
	 * 盛付通个人钱包账号
	 */
	private String persionalLoginName;

	/**
	 * 钱包登录密码
	 */
	private String password;

	/**
	 * 商户营业执照信息（上传）
	 */
	private UploadFileResponse businessLicenseFileInfo;

	/**
	 * 个人征信报告填写标记 TODO
	 */

	/**
	 * 人行征信报告信息（上传）
	 */
	private UploadFileResponse creditReportFileInfo;

	/**
	 * 个人征信报告网络查询密码:用户名
	 */
	private String creditUserName;

	/**
	 * 个人征信报告网络查询密码:密码
	 */
	private String creditPassword;

	/**
	 * 房地产数量
	 */
	private String qiantityOfHouse;

	/**
	 * 房产证明信息（上传）
	 */
	private UploadFileResponse housePropertyFileInfo;

	/**
	 * 其他财产证明（上传）
	 */
	private UploadFileResponse otherPropertyFileInfo;

	/**
	 * 其他财产上传状态（0未上传，1上传）
	 */
	private String isOtherPropertyUpload;

	/**
	 * 申请人手机
	 */
	private String applicantPhone;

	/**
	 * 办公电话区号（1）
	 */
	private String telephoneAreaCode;

	/**
	 * 办公电话（2）
	 */
	private String telephone;

	/**
	 * 办公电话分机（3）
	 */
	private String extensionTelephone;

	/**
	 * 居住地址(省)
	 */
	private String residentialProvice;

	/**
	 * 居住地址（市）
	 */
	private String residentialCity;

	/**
	 * 居住地址（区县街道）
	 */
	private String residentialStreet;

	/**
	 * 经营地址(省)
	 */
	private String manageProvice;

	/**
	 * 经营地址（市）
	 */
	private String manageCity;

	/**
	 * 经营地址（区县街道）
	 */
	private String manageStreet;

	/**
	 * 电子邮件
	 */
	private String email;

	/***
	 * QQ号
	 */
	private String qqNo;

	/**
	 * 微信
	 */
	private String weChatNo;

	/**
	 * 配偶姓名
	 */
	private String spouseName;

	/**
	 * 配偶手机号码
	 */
	private String spousePhone;

	/**
	 * 配偶身份证号
	 */
	private String spouseIdNo;

	/**
	 * 其他联系人关系1
	 */
	private String relative1;

	/**
	 * 其他联系人姓名1
	 */
	private String relativeName1;

	/**
	 * 其他联系人电话1
	 */
	private String relativePhone1;

	/**
	 * 其他联系人关系2
	 */
	private String relative2;
	/**
	 * 其他联系人姓名2
	 */
	private String relativeName2;

	/**
	 * 其他联系人电话2
	 */
	private String relativePhone2;

	/**
	 * 提交代理商确认 TODO
	 */
	private String isNeedAgentGuarantee;
	/**
	 * 天天贷协议 TODO
	 */

	/**
	 * 特别声明
	 */
	private String specialStatement;

	/**
	 * 保存或更新标记
	 */
	private String saveOrUpdateFlag;

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantIdNo() {
		return applicantIdNo;
	}

	public void setApplicantIdNo(String applicantIdNo) {
		this.applicantIdNo = applicantIdNo;
	}

	public UploadFileResponse getPositiveCardFileInfo() {
		return positiveCardFileInfo;
	}

	public void setPositiveCardFileInfo(UploadFileResponse positiveCardFileInfo) {
		this.positiveCardFileInfo = positiveCardFileInfo;
	}

	public UploadFileResponse getBackCardFileInfo() {
		return backCardFileInfo;
	}

	public void setBackCardFileInfo(UploadFileResponse backCardFileInfo) {
		this.backCardFileInfo = backCardFileInfo;
	}

	public String getApplicantSex() {
		return applicantSex;
	}

	public void setApplicantSex(String applicantSex) {
		this.applicantSex = applicantSex;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public UploadFileResponse getAccountBookFileInfo() {
		return accountBookFileInfo;
	}

	public void setAccountBookFileInfo(UploadFileResponse accountBookFileInfo) {
		this.accountBookFileInfo = accountBookFileInfo;
	}

	public String getQuantityOfChildren() {
		return quantityOfChildren;
	}

	public void setQuantityOfChildren(String quantityOfChildren) {
		this.quantityOfChildren = quantityOfChildren;
	}




	public BigDecimal getApplicantAmount() {
		return applicantAmount;
	}

	public void setApplicantAmount(BigDecimal applicantAmount) {
		this.applicantAmount = applicantAmount;
	}



	public UploadFileResponse getBusinessLicenseFileInfo() {
		return businessLicenseFileInfo;
	}

	public void setBusinessLicenseFileInfo(
			UploadFileResponse businessLicenseFileInfo) {
		this.businessLicenseFileInfo = businessLicenseFileInfo;
	}

	public UploadFileResponse getCreditReportFileInfo() {
		return creditReportFileInfo;
	}

	public void setCreditReportFileInfo(UploadFileResponse creditReportFileInfo) {
		this.creditReportFileInfo = creditReportFileInfo;
	}


	public String getQiantityOfHouse() {
		return qiantityOfHouse;
	}

	public void setQiantityOfHouse(String qiantityOfHouse) {
		this.qiantityOfHouse = qiantityOfHouse;
	}

	public UploadFileResponse getHousePropertyFileInfo() {
		return housePropertyFileInfo;
	}

	public void setHousePropertyFileInfo(UploadFileResponse housePropertyFileInfo) {
		this.housePropertyFileInfo = housePropertyFileInfo;
	}

	public UploadFileResponse getOtherPropertyFileInfo() {
		return otherPropertyFileInfo;
	}

	public void setOtherPropertyFileInfo(UploadFileResponse otherPropertyFileInfo) {
		this.otherPropertyFileInfo = otherPropertyFileInfo;
	}

	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	public String getTelephoneAreaCode() {
		return telephoneAreaCode;
	}

	public void setTelephoneAreaCode(String telephoneAreaCode) {
		this.telephoneAreaCode = telephoneAreaCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getExtensionTelephone() {
		return extensionTelephone;
	}

	public void setExtensionTelephone(String extensionTelephone) {
		this.extensionTelephone = extensionTelephone;
	}

	public String getResidentialProvice() {
		return residentialProvice;
	}

	public void setResidentialProvice(String residentialProvice) {
		this.residentialProvice = residentialProvice;
	}

	public String getResidentialCity() {
		return residentialCity;
	}

	public void setResidentialCity(String residentialCity) {
		this.residentialCity = residentialCity;
	}

	public String getResidentialStreet() {
		return residentialStreet;
	}

	public void setResidentialStreet(String residentialStreet) {
		this.residentialStreet = residentialStreet;
	}

	public String getManageProvice() {
		return manageProvice;
	}

	public void setManageProvice(String manageProvice) {
		this.manageProvice = manageProvice;
	}

	public String getManageCity() {
		return manageCity;
	}

	public void setManageCity(String manageCity) {
		this.manageCity = manageCity;
	}

	public String getManageStreet() {
		return manageStreet;
	}

	public void setManageStreet(String manageStreet) {
		this.manageStreet = manageStreet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQqNo() {
		return qqNo;
	}

	public void setQqNo(String qqNo) {
		this.qqNo = qqNo;
	}

	public String getWeChatNo() {
		return weChatNo;
	}

	public void setWeChatNo(String weChatNo) {
		this.weChatNo = weChatNo;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpousePhone() {
		return spousePhone;
	}

	public void setSpousePhone(String spousePhone) {
		this.spousePhone = spousePhone;
	}

	public String getSpouseIdNo() {
		return spouseIdNo;
	}

	public void setSpouseIdNo(String spouseIdNo) {
		this.spouseIdNo = spouseIdNo;
	}

	public String getRelativeName1() {
		return relativeName1;
	}

	public void setRelativeName1(String relativeName1) {
		this.relativeName1 = relativeName1;
	}

	public String getRelativePhone1() {
		return relativePhone1;
	}

	public void setRelativePhone1(String relativePhone1) {
		this.relativePhone1 = relativePhone1;
	}

	public String getRelativePhone2() {
		return relativePhone2;
	}

	public void setRelativePhone2(String relativePhone2) {
		this.relativePhone2 = relativePhone2;
	}

	public String getSpecialStatement() {
		return specialStatement;
	}

	public void setSpecialStatement(String specialStatement) {
		this.specialStatement = specialStatement;
	}

	public String getSaveOrUpdateFlag() {
		return saveOrUpdateFlag;
	}

	public void setSaveOrUpdateFlag(String saveOrUpdateFlag) {
		this.saveOrUpdateFlag = saveOrUpdateFlag;
	}

	public String getPersionalLoginName() {
		return persionalLoginName;
	}

	public void setPersionalLoginName(String persionalLoginName) {
		this.persionalLoginName = persionalLoginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRelative1() {
		return relative1;
	}

	public void setRelative1(String relative1) {
		this.relative1 = relative1;
	}

	public String getRelative2() {
		return relative2;
	}

	public void setRelative2(String relative2) {
		this.relative2 = relative2;
	}

	public String getRelativeName2() {
		return relativeName2;
	}

	public void setRelativeName2(String relativeName2) {
		this.relativeName2 = relativeName2;
	}
	private String cityStr;//经营地
	private String homeAddress;//住宅
	public String getHomeAddress() {
    StringBuffer sb=new StringBuffer("");
    if(StringUtils.isNotBlank(residentialProvice)){
      sb.append(residentialProvice.trim());
      sb.append("省");
       if(StringUtils.isNotBlank(residentialCity)){
        sb.append(residentialCity.trim());
        sb.append("市");
      }
       if(StringUtils.isNotBlank(residentialStreet)){
        sb.append(residentialStreet.trim());

      }
    }
    homeAddress=sb.toString();
    return homeAddress;
  }


  public String getCityStr() {
    StringBuffer sb=new StringBuffer("");
    if(StringUtils.isNotBlank(manageProvice)){
      sb.append(manageProvice.trim());
      sb.append("省");
       if(StringUtils.isNotBlank(manageCity)){
        sb.append(manageCity.trim());
        sb.append("市");
      }
       if(StringUtils.isNotBlank(manageStreet)){
        sb.append(manageStreet.trim());

      }
    }
    cityStr=sb.toString();
    return cityStr;
  }
	@Override
	public String toString() {
		return "CreditLineApplyRequest [applicantName=" + applicantName
				+ ", applicantIdNo=" + applicantIdNo
				+ ", positiveCardFileInfo=" + positiveCardFileInfo
				+ ", backCardFileInfo=" + backCardFileInfo + ", applicantSex="
				+ applicantSex + ", maritalStatus=" + maritalStatus
				+ ", accountBookFileInfo=" + accountBookFileInfo
				+ ", quantityOfChildren=" + quantityOfChildren
				+ ", applicantAmount=" + applicantAmount
				+ ", persionalLoginName=" + persionalLoginName + ", password="
				+ password + ", businessLicenseFileInfo="
				+ businessLicenseFileInfo + ", creditReportFileInfo="
				+ creditReportFileInfo + ", creditUserName=" + creditUserName
				+ ", creditPassword=" + creditPassword + ", qiantityOfHouse="
				+ qiantityOfHouse + ", housePropertyFileInfo="
				+ housePropertyFileInfo + ", otherPropertyFileInfo="
				+ otherPropertyFileInfo + ", isOtherPropertyUpload="
				+ isOtherPropertyUpload + ", applicantPhone=" + applicantPhone
				+ ", telephoneAreaCode=" + telephoneAreaCode + ", telephone="
				+ telephone + ", extensionTelephone=" + extensionTelephone
				+ ", residentialProvice=" + residentialProvice
				+ ", residentialCity=" + residentialCity
				+ ", residentialStreet=" + residentialStreet
				+ ", manageProvice=" + manageProvice + ", manageCity="
				+ manageCity + ", manageStreet=" + manageStreet + ", email="
				+ email + ", qqNo=" + qqNo + ", weChatNo=" + weChatNo
				+ ", spouseName=" + spouseName + ", spousePhone=" + spousePhone
				+ ", spouseIdNo=" + spouseIdNo + ", relative1=" + relative1
				+ ", relativeName1=" + relativeName1 + ", relativePhone1="
				+ relativePhone1 + ", relative2=" + relative2
				+ ", relativeName2=" + relativeName2 + ", relativePhone2="
				+ relativePhone2 + ", isNeedAgentGuarantee="
				+ isNeedAgentGuarantee + ", specialStatement="
				+ specialStatement + ", saveOrUpdateFlag=" + saveOrUpdateFlag
				+ "]";
	}

	public String getCreditUserName() {
		return creditUserName;
	}

	public void setCreditUserName(String creditUserName) {
		this.creditUserName = creditUserName;
	}

	public String getCreditPassword() {
		return creditPassword;
	}

	public void setCreditPassword(String creditPassword) {
		this.creditPassword = creditPassword;
	}

	public String getIsOtherPropertyUpload() {
		return isOtherPropertyUpload;
	}

	public void setIsOtherPropertyUpload(String isOtherPropertyUpload) {
		this.isOtherPropertyUpload = isOtherPropertyUpload;
	}

	public String getIsNeedAgentGuarantee() {
		return isNeedAgentGuarantee;
	}

	public void setIsNeedAgentGuarantee(String isNeedAgentGuarantee) {
		this.isNeedAgentGuarantee = isNeedAgentGuarantee;
	}

}
