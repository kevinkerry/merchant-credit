package com.sdp.mc.dao.readonly.posmerchant;

import java.util.Date;
import java.util.List;

/**
 * 商户信息查询条件
 *
 * @author: wangyiyong
 * @date: 13-1-31 下午1:56
 */
public class PosMerchantCond extends PosMerchantPromoterCond {

    /**
     * POS商户id
     */
    private String posMerchantId;

    /**
     * POS商户编号
     */
    private String posMerchantNo;

    /**
     * POS的商户号
     */
    private String merchantNo;

    /**
     * 商户号
     */
    private List<String> merchantNoList;

    /**
     * POS商户编号
     */
    private List<String> posMerchantNoList;
    /**
     * POS商户名称
     */
    private String merchantName;

    /**
     * 商户状态
     */
    private String status;

    /**
     * 商户状态
     */
    private List<String> statusList;

    /**
     * 是否有终端
     */
    private Boolean hasTerminal;

    /**
     * POS商户的类型
     *
     * @return
     */
    private String posMerchantType;

    /**
     * POS商户的类型
     *
     * @return
     */
    private List<String> posMerchantTypeList;

    /**
     * pos商户创建(起始)时间
     */
    private Date createTimeStart;

    /**
     * pos商户创建(截止)时间
     */
    private Date createTimeEnd;

    /**
     * 城市省级Id
     */
    private String provinceId;

    /**
     * 城市区域Id
     */
    private String districtId;

    /**
     * Mcc
     */
    private List<String> mccList;
    
    /**
     * 销售类型  0.分销 1直销
     */
    private Integer posmMposSalesType;
    
    /**
     * 账号
     */
    private String mcLoginAccount;

    
    
    public String getMcLoginAccount() {
		return mcLoginAccount;
	}

	public void setMcLoginAccount(String mcLoginAccount) {
		this.mcLoginAccount = mcLoginAccount;
	}

	public Integer getPosmMposSalesType() {
		return posmMposSalesType;
	}

	public void setPosmMposSalesType(Integer posmMposSalesType) {
		this.posmMposSalesType = posmMposSalesType;
	}

	public String getPosMerchantId() {
        return posMerchantId;
    }

    public void setPosMerchantId(String posMerchantId) {
        this.posMerchantId = posMerchantId;
    }

    public Boolean getHasTerminal() {
        return hasTerminal;
    }

    public void setHasTerminal(Boolean hasTerminal) {
        this.hasTerminal = hasTerminal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }


    public String getPosMerchantNo() {
        return posMerchantNo;
    }

    public void setPosMerchantNo(String posMerchantNo) {
        this.posMerchantNo = posMerchantNo;
    }

    public String getPosMerchantType() {
        return posMerchantType;
    }

    public void setPosMerchantType(String posMerchantType) {
        this.posMerchantType = posMerchantType;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public List<String> getMerchantNoList() {
        return merchantNoList;
    }

    public void setMerchantNoList(List<String> merchantNoList) {
        this.merchantNoList = merchantNoList;
    }

    public List<String> getPosMerchantNoList() {
        return posMerchantNoList;
    }

    public void setPosMerchantNoList(List<String> posMerchantNoList) {
        this.posMerchantNoList = posMerchantNoList;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<String> getPosMerchantTypeList() {
        return posMerchantTypeList;
    }

    public void setPosMerchantTypeList(List<String> posMerchantTypeList) {
        this.posMerchantTypeList = posMerchantTypeList;
    }

    public List<String> getMccList() {
        return mccList;
    }

    public void setMccList(List<String> mccList) {
        this.mccList = mccList;
    }
}
