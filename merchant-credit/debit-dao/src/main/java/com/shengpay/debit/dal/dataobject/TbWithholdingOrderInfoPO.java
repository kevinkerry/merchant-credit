package com.shengpay.debit.dal.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbWithholdingOrderInfoPO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * DECIMAL(18) 必填<br>
     * ID
     */
    private Long id;

    /**
     * VARCHAR(100) 必填<br>
     * 商户订单号
     */
    private String merchantOrderNo;

    /**
     * VARCHAR(100)<br>
     * 商户号
     */
    private String merchantNo;

    /**
     * VARCHAR(100) 必填<br>
     * 批次号
     */
    private String batchNo;

    /**
     * DECIMAL(18,2)<br>
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * VARCHAR(400)<br>
     * 银行名称
     */
    private String bankName;

    /**
     * VARCHAR(400)<br>
     * 姓名
     */
    private String chName;

    /**
     * VARCHAR(100)<br>
     * 卡类型
     */
    private String cardType;

    /**
     * VARCHAR(100)<br>
     * 卡号
     */
    private String cardNo;

    /**
     * VARCHAR(100)<br>
     * 证件类型
     */
    private String paperType;

    /**
     * VARCHAR(100)<br>
     * 证件号
     */
    private String paperNo;

    /**
     * VARCHAR(1000)<br>
     * 附言
     */
    private String postscript;

    /**
     * VARCHAR(1000)<br>
     * 请求备注
     */
    private String remark;

    /**
     * VARCHAR(100)<br>
     * 001-初始 002-待调用 003-接口调用失败 004-待回调 005-成功 006-失败 007-作废 
     */
    private String status;

    /**
     * TIMESTAMP(11,6)<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 更新时间
     */
    private Date updateTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 请求时间
     */
    private Date requestTime;

    /**
     * TIMESTAMP(11,6)<br>
     * 成功扣款时间
     */
    private Date sucessTime;

    /**
     * VARCHAR(100)<br>
     * 1-银行卡代扣 2-钱包代扣
     */
    private String type;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String ext;

    /**
     * VARCHAR(100)<br>
     * 原订单号
     */
    private String initorderno;

    /**
     * VARCHAR(100)<br>
     * 上次失败订单号
     */
    private String failorderno;

    /**
     * VARCHAR(20)<br>
     * 异常代码
     */
    private String errorcode;

    /**
     * VARCHAR(20)<br>
     * 异常原因
     */
    private String errormsg;

    /**
     * VARCHAR(50)<br>
     * 应付费用
     */
    private String payablefee;

    /**
     * VARCHAR(50)<br>
     * 应收费用
     */
    private String receivablefee;

    /**
     * VARCHAR(1000)<br>
     * 币种
     */
    private String currency;

    /**
     * VARCHAR(1000)<br>
     * 钱包账户
     */
    private String walletno;

    /**
     * TIMESTAMP(11,6)<br>
     * 计划扣款时间
     */
    private Date planwithholddate;

    /**
     * VARCHAR(100)<br>
     * 联系方式
     */
    private String mobel;

    /**
     * VARCHAR(100)<br>
     * 会员编号
     */
    private String memberid;

    /**
     * VARCHAR(100)<br>
     * 盛大通行证PT
     */
    private String pt;

    /**
     * DECIMAL(18) 必填<br>
     * 获得 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * DECIMAL(18) 必填<br>
     * 设置 ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * VARCHAR(100) 必填<br>
     * 获得 批次号
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 批次号
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * DECIMAL(18,2)<br>
     * 获得 订单金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * DECIMAL(18,2)<br>
     * 设置 订单金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * VARCHAR(400)<br>
     * 获得 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * VARCHAR(400)<br>
     * 获得 姓名
     */
    public String getChName() {
        return chName;
    }

    /**
     * VARCHAR(400)<br>
     * 设置 姓名
     */
    public void setChName(String chName) {
        this.chName = chName == null ? null : chName.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 卡类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 卡类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 证件类型
     */
    public String getPaperType() {
        return paperType;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 证件类型
     */
    public void setPaperType(String paperType) {
        this.paperType = paperType == null ? null : paperType.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 证件号
     */
    public String getPaperNo() {
        return paperNo;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 证件号
     */
    public void setPaperNo(String paperNo) {
        this.paperNo = paperNo == null ? null : paperNo.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 附言
     */
    public String getPostscript() {
        return postscript;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 附言
     */
    public void setPostscript(String postscript) {
        this.postscript = postscript == null ? null : postscript.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 请求备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 请求备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 001-初始 002-待调用 003-接口调用失败 004-待回调 005-成功 006-失败 007-作废 
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 001-初始 002-待调用 003-接口调用失败 004-待回调 005-成功 006-失败 007-作废 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 请求时间
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 请求时间
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 成功扣款时间
     */
    public Date getSucessTime() {
        return sucessTime;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 成功扣款时间
     */
    public void setSucessTime(Date sucessTime) {
        this.sucessTime = sucessTime;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 1-银行卡代扣 2-钱包代扣
     */
    public String getType() {
        return type;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 1-银行卡代扣 2-钱包代扣
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * VARCHAR(100)<br>
     */
    public String getExt() {
        return ext;
    }

    /**
     * VARCHAR(100)<br>
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 原订单号
     */
    public String getInitorderno() {
        return initorderno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 原订单号
     */
    public void setInitorderno(String initorderno) {
        this.initorderno = initorderno == null ? null : initorderno.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 上次失败订单号
     */
    public String getFailorderno() {
        return failorderno;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 上次失败订单号
     */
    public void setFailorderno(String failorderno) {
        this.failorderno = failorderno == null ? null : failorderno.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 异常代码
     */
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 异常代码
     */
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode == null ? null : errorcode.trim();
    }

    /**
     * VARCHAR(20)<br>
     * 获得 异常原因
     */
    public String getErrormsg() {
        return errormsg;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 异常原因
     */
    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 应付费用
     */
    public String getPayablefee() {
        return payablefee;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 应付费用
     */
    public void setPayablefee(String payablefee) {
        this.payablefee = payablefee == null ? null : payablefee.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 应收费用
     */
    public String getReceivablefee() {
        return receivablefee;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 应收费用
     */
    public void setReceivablefee(String receivablefee) {
        this.receivablefee = receivablefee == null ? null : receivablefee.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 钱包账户
     */
    public String getWalletno() {
        return walletno;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 钱包账户
     */
    public void setWalletno(String walletno) {
        this.walletno = walletno == null ? null : walletno.trim();
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 获得 计划扣款时间
     */
    public Date getPlanwithholddate() {
        return planwithholddate;
    }

    /**
     * TIMESTAMP(11,6)<br>
     * 设置 计划扣款时间
     */
    public void setPlanwithholddate(Date planwithholddate) {
        this.planwithholddate = planwithholddate;
    }

    /**
     * VARCHAR(100)<br>
     * 获得 联系方式
     */
    public String getMobel() {
        return mobel;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 联系方式
     */
    public void setMobel(String mobel) {
        this.mobel = mobel == null ? null : mobel.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 会员编号
     */
    public String getMemberid() {
        return memberid;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 会员编号
     */
    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 盛大通行证PT
     */
    public String getPt() {
        return pt;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 盛大通行证PT
     */
    public void setPt(String pt) {
        this.pt = pt == null ? null : pt.trim();
    }
}