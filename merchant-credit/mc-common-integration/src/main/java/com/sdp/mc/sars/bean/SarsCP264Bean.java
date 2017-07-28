package com.sdp.mc.sars.bean;


/**
 * Created by huyaxiong on 2015/1/9.
 */
public class SarsCP264Bean extends SarsParentBean {

    private static final String checkPoint = "CP264";

    private String merchantNo;
    private Long amount;


    public SarsCP264Bean(String merchantNo, Long amount) {
        super(checkPoint);
        this.merchantNo = merchantNo;
        this.amount = amount;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
