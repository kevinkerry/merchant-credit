package com.sdp.withdraw.dao;

import com.sdp.emall.common.dao.BaseDO;
import java.math.BigDecimal;
import java.util.Date;

public class WithdrawSplittingDO extends BaseDO {
    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Long reqId;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostShengpaySplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal baseCostPromoterSplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostSplittingScale;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostShengpaySplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal wdCostPromoterSplitting;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal platformCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal shengpayTotalCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal promoterTotalCost;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Date createTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private Date updateTime;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal daySettleAward;

    /**
     * This field corresponds to the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    private BigDecimal monthActiveAward;

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.ID
     *
     * @return the value of FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.ID
     *
     * @param id the value for FW_WITHDRAW_SPLITTING.ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.REQ_ID
     *
     * @return the value of FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Long getReqId() {
        return reqId;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.REQ_ID
     *
     * @param reqId the value for FW_WITHDRAW_SPLITTING.REQ_ID
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCost() {
        return baseCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST
     *
     * @param baseCost the value for FW_WITHDRAW_SPLITTING.BASE_COST
     * column comments 基本费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCost(BigDecimal baseCost) {
        this.baseCost = baseCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostSplittingScale() {
        return baseCostSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     *
     * @param baseCostSplittingScale the value for FW_WITHDRAW_SPLITTING.BASE_COST_SPLITTING_SCALE
     * column comments 代理商分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostSplittingScale(BigDecimal baseCostSplittingScale) {
        this.baseCostSplittingScale = baseCostSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostShengpaySplitting() {
        return baseCostShengpaySplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     *
     * @param baseCostShengpaySplitting the value for FW_WITHDRAW_SPLITTING.BASE_COST_SHENGPAY_SPLITTING
     * column comments 盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostShengpaySplitting(BigDecimal baseCostShengpaySplitting) {
        this.baseCostShengpaySplitting = baseCostShengpaySplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getBaseCostPromoterSplitting() {
        return baseCostPromoterSplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     *
     * @param baseCostPromoterSplitting the value for FW_WITHDRAW_SPLITTING.BASE_COST_PROMOTER_SPLITTING
     * column comments 代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setBaseCostPromoterSplitting(BigDecimal baseCostPromoterSplitting) {
        this.baseCostPromoterSplitting = baseCostPromoterSplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCost() {
        return wdCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST
     *
     * @param wdCost the value for FW_WITHDRAW_SPLITTING.WD_COST
     * column comments 提现费用
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCost(BigDecimal wdCost) {
        this.wdCost = wdCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostSplittingScale() {
        return wdCostSplittingScale;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     *
     * @param wdCostSplittingScale the value for FW_WITHDRAW_SPLITTING.WD_COST_SPLITTING_SCALE
     * column comments 代理商提现分润比例
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostSplittingScale(BigDecimal wdCostSplittingScale) {
        this.wdCostSplittingScale = wdCostSplittingScale;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostShengpaySplitting() {
        return wdCostShengpaySplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     *
     * @param wdCostShengpaySplitting the value for FW_WITHDRAW_SPLITTING.WD_COST_SHENGPAY_SPLITTING
     * column comments 提现费用盛付通分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostShengpaySplitting(BigDecimal wdCostShengpaySplitting) {
        this.wdCostShengpaySplitting = wdCostShengpaySplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     *
     * @return the value of FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getWdCostPromoterSplitting() {
        return wdCostPromoterSplitting;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     *
     * @param wdCostPromoterSplitting the value for FW_WITHDRAW_SPLITTING.WD_COST_PROMOTER_SPLITTING
     * column comments 提现费用代理商分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setWdCostPromoterSplitting(BigDecimal wdCostPromoterSplitting) {
        this.wdCostPromoterSplitting = wdCostPromoterSplitting;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getPlatformCost() {
        return platformCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.PLATFORM_COST
     *
     * @param platformCost the value for FW_WITHDRAW_SPLITTING.PLATFORM_COST
     * column comments 平台成本
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setPlatformCost(BigDecimal platformCost) {
        this.platformCost = platformCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getShengpayTotalCost() {
        return shengpayTotalCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     *
     * @param shengpayTotalCost the value for FW_WITHDRAW_SPLITTING.SHENGPAY_TOTAL_COST
     * column comments 盛付通总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setShengpayTotalCost(BigDecimal shengpayTotalCost) {
        this.shengpayTotalCost = shengpayTotalCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     *
     * @return the value of FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getPromoterTotalCost() {
        return promoterTotalCost;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     *
     * @param promoterTotalCost the value for FW_WITHDRAW_SPLITTING.PROMOTER_TOTAL_COST
     * column comments 代理商总分润
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setPromoterTotalCost(BigDecimal promoterTotalCost) {
        this.promoterTotalCost = promoterTotalCost;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     *
     * @return the value of FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.CREATE_TIME
     *
     * @param createTime the value for FW_WITHDRAW_SPLITTING.CREATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     *
     * @return the value of FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.UPDATE_TIME
     *
     * @param updateTime the value for FW_WITHDRAW_SPLITTING.UPDATE_TIME
     * column comments null
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     *
     * @return the value of FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getDaySettleAward() {
        return daySettleAward;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     *
     * @param daySettleAward the value for FW_WITHDRAW_SPLITTING.DAY_SETTLE_AWARD
     * column comments 日结算量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setDaySettleAward(BigDecimal daySettleAward) {
        this.daySettleAward = daySettleAward;
    }

    /**
     * This method returns the value of the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     *
     * @return the value of FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public BigDecimal getMonthActiveAward() {
        return monthActiveAward;
    }

    /**
     * This method sets the value of the database column FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     *
     * @param monthActiveAward the value for FW_WITHDRAW_SPLITTING.MONTH_ACTIVE_AWARD
     * column comments 月激活量奖励
     *
     * @mbggenerated Mon Jul 18 13:16:35 CST 2016
     */
    public void setMonthActiveAward(BigDecimal monthActiveAward) {
        this.monthActiveAward = monthActiveAward;
    }
}