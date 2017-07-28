package com.sdp.mc.dao.readonly.posmerchant;

import com.shengpay.commons.core.constants.ConstantsUtil;

import java.util.Date;

/**
 * POS商户实体对象
 *
 * @author wangyiyong@snda.com
 */
public abstract class PosMerchantEOAbstract extends MerchantContractEO {
    /**
     * 营业执照号码
     */
    protected String posmBusinessLicense;

    /**
     * 公司法人
     */
    protected String posmLegalPerson;

    /**
     * 营业名称
     */
    protected String posmBusinessName;

    /**
     * 城市省级ID
     */
    protected Long posmProvinceId;

    /**
     * 支持后台退货(BACKSTAGE) 1:支持 0:不支持
     */
    protected Boolean posmSptReturnGoodsBs;

    /**
     * 支持退货 1:支持 0:不支持
     */
    protected Boolean posmSptReturnGoods;

    /**
     * 支持预授权 1:支持 0:不支持
     */
    protected Boolean posmSptPreAuth;

    /**
     * 支持跨终端预授权完成 1:支持 0:不支持
     */
    protected Boolean posmSptTermPreAuthCmplt;
    
    /**
     * 支持跨终端预授权撤销 1:支持 0:不支持
     */
    protected Boolean posmSptTermPreAuthRevt;

    /**
     * $field.fieldComment
     */
    protected Boolean posmCreditCardDeal;

    /**
     * 外部MCC名称
     */
    protected String posmExternalMccName;

    /**
     * 内部MCC名称
     */
    protected String posmInternalMccName;

    /**
     * 拓展商名称
     */
    protected String posmPromoterName;

    /**
     * 城市地区名称（省&市）
     */
    protected String posmDistrictName;

    /**
     * POS商户ID
     */
    protected Long posmId;

    /**
     * POS商户编号(15位)
     */
    protected String posmPosMerchantNo;

    /**
     * POS商户类型
     */
    protected String posmMerchantType;

    /**
     * 商户级别
     */
    protected Long posmMerchantLevel;

    /**
     * 销售经理
     */
    protected String posmSalesManager;

    /**
     * 城市地区ID
     */
    protected Long posmDistrictId;

    /**
     * 具体地址
     */
    protected String posmAddress;

    /**
     * 外部MCCID
     */
    protected Long posmExternalMccId;

    /**
     * 内部MCCID
     */
    protected Long posmInternalMccId;

    /**
     * 拓展商ID
     */
    protected Long posmPromoterId;

    /**
     * 是否允许跨终端退货
     */
    protected Boolean posmAllopatryReturnGoods;

    /**
     * 是否允许手工预授权完成
     */
    protected Boolean posmManualAuthComplete;

    /**
     * 是否级联取消预授权
     */
    protected Boolean posmCascadeAuthCancel;

    /**
     * 是否允许银行卡交易
     */
    protected Boolean posmBankCardDeal;

    /**
     * 是否允许预付卡交易
     */
    protected Boolean posmPpcCardDeal;

    /**
     * 扩展位图
     */
    protected String posmExpandBitmap;

    /**
     * 版本
     */
    protected Long posmVersion;

    /**
     * 创建时间
     */
    protected Date posmCreateTime;

    /**
     * 最后更新时间
     */
    protected Date posmLastUpdateTime;
    
    /**
     * 退款信用额度
     */
    protected Double posmBackCredits;
    
    /**
     * MPOS商户业务1等级
     */
    protected Long posmBuss1Level;
    
    /**
     * 是否依赖电子签名
     */
    protected Integer posmRelyElecSignFlag;
    
    /**
     * 是否强制电子签名
     */
    protected Integer posmEnforceElecSignFlag;
    
    /**
     * mpos销售类型(0-分销,1-直销)
     */
    protected Integer posmMposSalesType;
    /**
     * 联系电话
     */
    protected String posmTelephoneNo;
    
    /**
     * 法人身份证
     */
    protected String posmIdNum;
    
    public Integer getPosmEnforceElecSignFlag() {
		return posmEnforceElecSignFlag;
	}

	public void setPosmEnforceElecSignFlag(Integer posmEnforceElecSignFlag) {
		this.posmEnforceElecSignFlag = posmEnforceElecSignFlag;
	}

	public Integer getPosmMposSalesType() {
		return posmMposSalesType;
	}

	public void setPosmMposSalesType(Integer posmMposSalesType) {
		this.posmMposSalesType = posmMposSalesType;
	}

	public Integer getPosmRelyElecSignFlag() {
		return posmRelyElecSignFlag;
	}

	public void setPosmRelyElecSignFlag(Integer posmRelyElecSignFlag) {
		this.posmRelyElecSignFlag = posmRelyElecSignFlag;
	}

	/**
     * 取得 城市省级ID
     */
    public Long getPosmProvinceId() {
        return posmProvinceId;
    }

    /**
     * 设置 城市省级ID
     */
    public void setPosmProvinceId(Long posmProvinceId) {
        this.posmProvinceId = posmProvinceId;
    }

    /**
     * 取得 $field.fieldComment
     */
    public Boolean getPosmCreditCardDeal() {
        return posmCreditCardDeal;
    }

    /**
     * 设置 $field.fieldComment
     */
    public void setPosmCreditCardDeal(Boolean posmCreditCardDeal) {
        this.posmCreditCardDeal = posmCreditCardDeal;
    }

    /**
     * 取得 外部MCC名称
     */
    public String getPosmExternalMccName() {
        return posmExternalMccName;
    }

    /**
     * 设置 外部MCC名称
     */
    public void setPosmExternalMccName(String posmExternalMccName) {
        this.posmExternalMccName = posmExternalMccName;
    }

    /**
     * 取得 内部MCC名称
     */
    public String getPosmInternalMccName() {
        return posmInternalMccName;
    }

    /**
     * 设置 内部MCC名称
     */
    public void setPosmInternalMccName(String posmInternalMccName) {
        this.posmInternalMccName = posmInternalMccName;
    }

    /**
     * 取得 拓展商名称
     */
    public String getPosmPromoterName() {
        return posmPromoterName;
    }

    /**
     * 设置 拓展商名称
     */
    public void setPosmPromoterName(String posmPromoterName) {
        this.posmPromoterName = posmPromoterName;
    }

    /**
     * 取得 城市地区名称（省&市）
     */
    public String getPosmDistrictName() {
        return posmDistrictName;
    }

    /**
     * 设置 城市地区名称（省&市）
     */
    public void setPosmDistrictName(String posmDistrictName) {
        this.posmDistrictName = posmDistrictName;
    }

    /**
     * 取得 POS商户ID
     */
    public Long getPosmId() {
        return posmId;
    }

    /**
     * 设置 POS商户ID
     */
    public void setPosmId(Long posmId) {
        this.posmId = posmId;
    }

    /**
     * 取得 POS商户编号(15位)
     */
    public String getPosmPosMerchantNo() {
        return posmPosMerchantNo;
    }

    /**
     * 设置 POS商户编号(15位)
     */
    public void setPosmPosMerchantNo(String posmPosMerchantNo) {
        this.posmPosMerchantNo = posmPosMerchantNo;
    }

    /**
     * 取得 POS商户类型
     */
    public String getPosmMerchantType() {
        return posmMerchantType;
    }

    /**
     * 设置 POS商户类型
     */
    public void setPosmMerchantType(String posmMerchantType) {
        this.posmMerchantType = posmMerchantType;
    }

    /**
     * 获取POS商户类型名称
     */
    public static String getPosmMerchantTypeName(String posmMerchantType) {
        return ConstantsUtil.getConstantsName(posmMerchantType, "POSM_MERCHANT_TYPE");
    }

    /**
     * 获取POS商户类型名称
     */
    public String getPosmMerchantTypeName() {
        return getPosmMerchantTypeName(posmMerchantType);
    }
    /**
     * 取得 商户级别
     */
    public Long getPosmMerchantLevel() {
        return posmMerchantLevel;
    }

    /**
     * 设置 商户级别
     */
    public void setPosmMerchantLevel(Long posmMerchantLevel) {
        this.posmMerchantLevel = posmMerchantLevel;
    }

    /**
     * 取得 销售经理
     */
    public String getPosmSalesManager() {
        return posmSalesManager;
    }

    /**
     * 设置 销售经理
     */
    public void setPosmSalesManager(String posmSalesManager) {
        this.posmSalesManager = posmSalesManager;
    }

    /**
     * 取得 城市地区ID
     */
    public Long getPosmDistrictId() {
        return posmDistrictId;
    }

    /**
     * 设置 城市地区ID
     */
    public void setPosmDistrictId(Long posmDistrictId) {
        this.posmDistrictId = posmDistrictId;
    }

    /**
     * 取得 具体地址
     */
    public String getPosmAddress() {
        return posmAddress;
    }

    /**
     * 设置 具体地址
     */
    public void setPosmAddress(String posmAddress) {
        this.posmAddress = posmAddress;
    }

    /**
     * 取得 外部MCCID
     */
    public Long getPosmExternalMccId() {
        return posmExternalMccId;
    }

    /**
     * 设置 外部MCCID
     */
    public void setPosmExternalMccId(Long posmExternalMccId) {
        this.posmExternalMccId = posmExternalMccId;
    }

    /**
     * 取得 内部MCCID
     */
    public Long getPosmInternalMccId() {
        return posmInternalMccId;
    }

    /**
     * 设置 内部MCCID
     */
    public void setPosmInternalMccId(Long posmInternalMccId) {
        this.posmInternalMccId = posmInternalMccId;
    }

    /**
     * 取得 拓展商ID
     */
    public Long getPosmPromoterId() {
        return posmPromoterId;
    }

    /**
     * 设置 拓展商ID
     */
    public void setPosmPromoterId(Long posmPromoterId) {
        this.posmPromoterId = posmPromoterId;
    }

    /**
     * 取得 是否允许跨终端退货
     */
    public Boolean getPosmAllopatryReturnGoods() {
        return posmAllopatryReturnGoods;
    }

    /**
     * 设置 是否允许跨终端退货
     */
    public void setPosmAllopatryReturnGoods(Boolean posmAllopatryReturnGoods) {
        this.posmAllopatryReturnGoods = posmAllopatryReturnGoods;
    }

    /**
     * 取得 是否允许手工预授权完成
     */
    public Boolean getPosmManualAuthComplete() {
        return posmManualAuthComplete;
    }

    /**
     * 设置 是否允许手工预授权完成
     */
    public void setPosmManualAuthComplete(Boolean posmManualAuthComplete) {
        this.posmManualAuthComplete = posmManualAuthComplete;
    }

    /**
     * 取得 是否级联取消预授权
     */
    public Boolean getPosmCascadeAuthCancel() {
        return posmCascadeAuthCancel;
    }

    /**
     * 设置 是否级联取消预授权
     */
    public void setPosmCascadeAuthCancel(Boolean posmCascadeAuthCancel) {
        this.posmCascadeAuthCancel = posmCascadeAuthCancel;
    }

    /**
     * 取得 是否允许银行卡交易
     */
    public Boolean getPosmBankCardDeal() {
        return posmBankCardDeal;
    }

    /**
     * 设置 是否允许银行卡交易
     */
    public void setPosmBankCardDeal(Boolean posmBankCardDeal) {
        this.posmBankCardDeal = posmBankCardDeal;
    }

    /**
     * 取得 是否允许预付卡交易
     */
    public Boolean getPosmPpcCardDeal() {
        return posmPpcCardDeal;
    }

    /**
     * 设置 是否允许预付卡交易
     */
    public void setPosmPpcCardDeal(Boolean posmPpcCardDeal) {
        this.posmPpcCardDeal = posmPpcCardDeal;
    }

    /**
     * 取得 扩展位图
     */
    public String getPosmExpandBitmap() {
        return posmExpandBitmap;
    }

    /**
     * 设置 扩展位图
     */
    public void setPosmExpandBitmap(String posmExpandBitmap) {
        this.posmExpandBitmap = posmExpandBitmap;
    }

    /**
     * 取得 版本
     */
    public Long getPosmVersion() {
        return posmVersion;
    }

    /**
     * 设置 版本
     */
    public void setPosmVersion(Long posmVersion) {
        this.posmVersion = posmVersion;
    }

    /**
     * 取得 创建时间
     */
    public Date getPosmCreateTime() {
        return posmCreateTime;
    }

    /**
     * 设置 创建时间
     */
    public void setPosmCreateTime(Date posmCreateTime) {
        this.posmCreateTime = posmCreateTime;
    }

    /**
     * 取得 最后更新时间
     */
    public Date getPosmLastUpdateTime() {
        return posmLastUpdateTime;
    }

    /**
     * 设置 最后更新时间
     */
    public void setPosmLastUpdateTime(Date posmLastUpdateTime) {
        this.posmLastUpdateTime = posmLastUpdateTime;
    }

    public String getPosmBusinessLicense() {
        return posmBusinessLicense;
    }

    public void setPosmBusinessLicense(String posmBusinessLicense) {
        this.posmBusinessLicense = posmBusinessLicense;
    }

    public String getPosmLegalPerson() {
        return posmLegalPerson;
    }

    public void setPosmLegalPerson(String posmLegalPerson) {
        this.posmLegalPerson = posmLegalPerson;
    }

    public String getPosmBusinessName() {
        return posmBusinessName;
    }

    public void setPosmBusinessName(String posmBusinessName) {
        this.posmBusinessName = posmBusinessName;
    }

    public Boolean getPosmSptReturnGoodsBs() {
        return posmSptReturnGoodsBs;
    }

    public void setPosmSptReturnGoodsBs(Boolean posmSptReturnGoodsBs) {
        this.posmSptReturnGoodsBs = posmSptReturnGoodsBs;
    }

    public Boolean getPosmSptReturnGoods() {
        return posmSptReturnGoods;
    }

    public void setPosmSptReturnGoods(Boolean posmSptReturnGoods) {
        this.posmSptReturnGoods = posmSptReturnGoods;
    }

    public Boolean getPosmSptPreAuth() {
        return posmSptPreAuth;
    }

    public void setPosmSptPreAuth(Boolean posmSptPreAuth) {
        this.posmSptPreAuth = posmSptPreAuth;
    }

    public Boolean getPosmSptTermPreAuthCmplt() {
        return posmSptTermPreAuthCmplt;
    }

    public void setPosmSptTermPreAuthCmplt(Boolean posmSptTermPreAuthCmplt) {
        this.posmSptTermPreAuthCmplt = posmSptTermPreAuthCmplt;
    }

	public Boolean getPosmSptTermPreAuthRevt() {
		return posmSptTermPreAuthRevt;
	}

	public void setPosmSptTermPreAuthRevt(Boolean posmSptTermPreAuthRevt) {
		this.posmSptTermPreAuthRevt = posmSptTermPreAuthRevt;
	}

	public Double getPosmBackCredits() {
		return posmBackCredits;
	}

	public void setPosmBackCredits(Double posmBackCredits) {
		this.posmBackCredits = posmBackCredits;
	}

	public Long getPosmBuss1Level() {
		return posmBuss1Level;
	}

	public void setPosmBuss1Level(Long posmBuss1Level) {
		this.posmBuss1Level = posmBuss1Level;
	}

	public String getPosmTelephoneNo() {
		return posmTelephoneNo;
	}

	public void setPosmTelephoneNo(String posmTelephoneNo) {
		this.posmTelephoneNo = posmTelephoneNo;
	}

	public String getPosmIdNum() {
		return posmIdNum;
	}

	public void setPosmIdNum(String posmIdNum) {
		this.posmIdNum = posmIdNum;
	}
}