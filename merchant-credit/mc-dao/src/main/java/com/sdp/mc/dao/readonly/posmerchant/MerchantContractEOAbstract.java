package com.sdp.mc.dao.readonly.posmerchant;

import com.shengpay.commons.core.base.BaseObject;
import com.shengpay.commons.core.constants.ConstantsUtil;

import java.util.Date;

/**
 * 商户抽象合同信息（MC）实体对象
 *
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public abstract class MerchantContractEOAbstract extends BaseObject {
    /**
     * 账号(邮箱或手机号)
     */
    protected String mcLoginAccount;

    /**
     * 注册账号类型(1:邮箱，2:手机号)
     */
    protected Integer mcRegType;

    /**
     * 证件类型(1:营业执照/身份证 2:户口本 3:护照 4：军官证 5:回乡证。默认传：1)
     */
    protected Integer mcCertiType;

    /**
     * 证件编码
     */
    protected String mcCertiValue;

    /**
     * 合同开始时间
     */
    protected Date mcContractBeginDate;

    /**
     * 合同结束时间
     */
    protected Date mcContractEndDate;

    /**
     * 合同实际结束时间
     */
    protected Date mcContractRealEndDate;

    /**
     * 商户合同主键
     */
    protected Long mcId;

    /**
     * 商户号
     */
    protected String mcMerchantNo;

    /**
     * 合同号
     */
    protected String mcContractNo;

    /**
     * 合同状态
     */
    protected String mcStatus;

    /**
     * 合同类型(0001:POS商户,0002:机具方,0003:拓展商)
     */
    protected String mcType;

    /**
     * 版本号
     */
    protected Long mcVersion;

    /**
     * 创建时间
     */
    protected Date mcCreateTime;

    /**
     * 最后修改时间
     */
    protected Date mcLastUpdateTime;

    /**
     * 商户名称
     */
    protected String mcMerchantName;

    /**
     * 取得 账号(邮箱或手机号)
     */
    public String getMcLoginAccount() {
        return mcLoginAccount;
    }

    /**
     * 设置 账号(邮箱或手机号)
     */
    public void setMcLoginAccount(String mcLoginAccount) {
        this.mcLoginAccount = mcLoginAccount;
    }

    /**
     * 取得 注册账号类型(1:邮箱，2:手机号)
     */
    public Integer getMcRegType() {
        return mcRegType;
    }

    /**
     * 设置 注册账号类型(1:邮箱，2:手机号)
     */
    public void setMcRegType(Integer mcRegType) {
        this.mcRegType = mcRegType;
    }

    /**
     * 取得 证件类型(1:营业执照/身份证 2:户口本 3:护照 4：军官证 5:回乡证。默认传：1)
     */
    public Integer getMcCertiType() {
        return mcCertiType;
    }

    /**
     * 设置 证件类型(1:营业执照/身份证 2:户口本 3:护照 4：军官证 5:回乡证。默认传：1)
     */
    public void setMcCertiType(Integer mcCertiType) {
        this.mcCertiType = mcCertiType;
    }

    /**
     * 取得 证件编码
     */
    public String getMcCertiValue() {
        return mcCertiValue;
    }

    /**
     * 设置 证件编码
     */
    public void setMcCertiValue(String mcCertiValue) {
        this.mcCertiValue = mcCertiValue;
    }

    /**
     * 取得 合同开始时间
     */
    public Date getMcContractBeginDate() {
        return mcContractBeginDate;
    }

    /**
     * 设置 合同开始时间
     */
    public void setMcContractBeginDate(Date mcContractBeginDate) {
        this.mcContractBeginDate = mcContractBeginDate;
    }

    /**
     * 取得 合同结束时间
     */
    public Date getMcContractEndDate() {
        return mcContractEndDate;
    }

    /**
     * 设置 合同结束时间
     */
    public void setMcContractEndDate(Date mcContractEndDate) {
        this.mcContractEndDate = mcContractEndDate;
    }

    /**
     * 取得 合同实际结束时间
     */
    public Date getMcContractRealEndDate() {
        return mcContractRealEndDate;
    }

    /**
     * 设置 合同实际结束时间
     */
    public void setMcContractRealEndDate(Date mcContractRealEndDate) {
        this.mcContractRealEndDate = mcContractRealEndDate;
    }

    /**
     * 取得 商户合同主键
     */
    public Long getMcId() {
        return mcId;
    }

    /**
     * 设置 商户合同主键
     */
    public void setMcId(Long mcId) {
        this.mcId = mcId;
    }

    /**
     * 取得 商户号
     */
    public String getMcMerchantNo() {
        return mcMerchantNo;
    }

    /**
     * 设置 商户号
     */
    public void setMcMerchantNo(String mcMerchantNo) {
        this.mcMerchantNo = mcMerchantNo;
    }

    /**
     * 取得 合同号
     */
    public String getMcContractNo() {
        return mcContractNo;
    }

    /**
     * 设置 合同号
     */
    public void setMcContractNo(String mcContractNo) {
        this.mcContractNo = mcContractNo;
    }

    /**
     * 取得 合同状态
     */
    public String getMcStatus() {
        return mcStatus;
    }

    /**
     * 设置 合同状态
     */
    public void setMcStatus(String mcStatus) {
        this.mcStatus = mcStatus;
    }

    /**
     * 获取合同状态名称
     */
    public static String getMcStatusName(String mcStatus) {
        return ConstantsUtil.getConstantsName(mcStatus, "MC_STATUS");
    }

    /**
     * 获取合同状态名称
     */
    public String getMcStatusName() {
        return getMcStatusName(mcStatus);
    }

    /**
     * 取得 合同类型(0001:POS商户,0002:机具方,0003:拓展商)
     */
    public String getMcType() {
        return mcType;
    }

    /**
     * 设置 合同类型(0001:POS商户,0002:机具方,0003:拓展商)
     */
    public void setMcType(String mcType) {
        this.mcType = mcType;
    }

    /**
     * 获取合同类型(0001:POS商户,0002:机具方,0003:拓展商)名称
     */
    public static String getMcTypeName(String mcType) {
        return ConstantsUtil.getConstantsName(mcType, "MC_TYPE");
    }

    /**
     * 获取合同类型(0001:POS商户,0002:机具方,0003:拓展商)名称
     */
    public String getMcTypeName() {
        return getMcTypeName(mcType);
    }

    /**
     * 取得 版本号
     */
    public Long getMcVersion() {
        return mcVersion;
    }

    /**
     * 设置 版本号
     */
    public void setMcVersion(Long mcVersion) {
        this.mcVersion = mcVersion;
    }

    /**
     * 取得 创建时间
     */
    public Date getMcCreateTime() {
        return mcCreateTime;
    }

    /**
     * 设置 创建时间
     */
    public void setMcCreateTime(Date mcCreateTime) {
        this.mcCreateTime = mcCreateTime;
    }

    /**
     * 取得 最后修改时间
     */
    public Date getMcLastUpdateTime() {
        return mcLastUpdateTime;
    }

    /**
     * 设置 最后修改时间
     */
    public void setMcLastUpdateTime(Date mcLastUpdateTime) {
        this.mcLastUpdateTime = mcLastUpdateTime;
    }

    /**
     * 取得 商户名称
     */
    public String getMcMerchantName() {
        return mcMerchantName;
    }

    /**
     * 设置 商户名称
     */
    public void setMcMerchantName(String mcMerchantName) {
        this.mcMerchantName = mcMerchantName;
    }

}