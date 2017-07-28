package com.sdp.mc.dao.readonly.posmerchant;

import java.util.List;

import com.sdp.mc.common.base.dao.BaseCond;


/**
 * 拓展商查询所属商户查询条件
 *
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
public class PosMerchantPromoterCond extends BaseCond {

    /**
     * 拓展商Id
     */
    private String promoterId;

    /**
     * 拓展商名称
     */
    private String promoterName;

    /**
     * 拓展商商户号
     */
    private String promoterMerchantNo;

    /**
     * 拓展商商户号
     */
    private List<String> promoterMerchantNoList;

    public String getPromoterId() {
        return promoterId;
    }

    public void setPromoterId(String promoterId) {
        this.promoterId = promoterId;
    }

    public String getPromoterName() {
        return promoterName;
    }

    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public String getPromoterMerchantNo() {
        return promoterMerchantNo;
    }

    public void setPromoterMerchantNo(String promoterMerchantNo) {
        this.promoterMerchantNo = promoterMerchantNo;
    }

    public List<String> getPromoterMerchantNoList() {
        return promoterMerchantNoList;
    }

    public void setPromoterMerchantNoList(List<String> promoterMerchantNoList) {
        this.promoterMerchantNoList = promoterMerchantNoList;
    }
}
