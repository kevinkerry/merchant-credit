package com.sdp.mc.dao.readonly.posmerchant;

/**
 * 商户抽象合同信息（MC）实体对象
 *
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public class MerchantContractEO extends MerchantContractEOAbstract {
    /**
     * 被排除的多个状态
     */
    private String[] exceptMcStatusArr;


    /**
     * 最后更新时间的开始日期（包含）
     */
    private String mcBeginLastUpdateDate;

    /**
     * 最后更新时间的结束日期（包含）
     */
    private String mcEndLastUpdateDate;

    /**
     * 默认构造方法
     */
    public MerchantContractEO() {
    }
    
    
    /**
     * 默认构造方法
     */
    public MerchantContractEO(String merchantNo, String mcType,String mcStatus) {
    	this.mcMerchantNo = merchantNo;
    	this.mcType = mcType;
    	this.mcStatus = mcStatus;
    }


    /**
     * 获取被排除的多个状态
     */
    public String[] getExceptMcStatusArr() {
        return exceptMcStatusArr;
    }


    /**
     * 设置被排除的多个状态
     */
    public void setExceptMcStatusArr(String[] exceptMcStatusArr) {
        this.exceptMcStatusArr = exceptMcStatusArr;
    }


    public String getMcBeginLastUpdateDate() {
        return mcBeginLastUpdateDate;
    }

    public void setMcBeginLastUpdateDate(String beginLastUpdateDate) {
        this.mcBeginLastUpdateDate = beginLastUpdateDate;
    }

    public String getMcEndLastUpdateDate() {
        return mcEndLastUpdateDate;
    }

    public void setMcEndLastUpdateDate(String endLastUpdateDate) {
        this.mcEndLastUpdateDate = endLastUpdateDate;
    }

}