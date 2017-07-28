package com.sdp.mc.dao.readonly.merchantSettleItem;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sdp.mc.common.util.DateUtil;

public class MerchantSettleItemEO {
	/**
	 * 主键
	 */
	protected Long msiId;
	/**
	 * 创建时间
	 */
	protected Date msiCreateTime = new Date();
	/**
	 * 更新时间
	 */
	protected Date msiUpdateTime = new Date();
	/**
	 * 版本号
	 */
	protected Long msiVersion;
	/**
	 * 商户号
	 */
	protected String msiMerchantNo;
	/**
	 * 卡类型(DC:借记卡,CC:贷记卡,SCC:准贷记卡,PC:预付卡)
	 */
	protected String msiCardType;
	/**
	 * 卡组织(VISA,UNIPAY)
	 */
	protected String msiCardOrg;
	/**
	 * 结算周期类型(1:自然日,2:工作日,3:自然日定时,4:工作日定时)
	 */
	protected Long msiCycleType;
	/**
	 * 结算周期值
	 */
	protected String msiCycleValue;

	protected Long msiSettleRuleId;

	protected String msiIssureId;

	protected BigDecimal msiHolidayFee;

	protected BigDecimal msiWorkDayFee;

	protected Date msiBeginTime;

	protected Date msiEndTime;

	protected Long msiStatus;

	protected Long msiPriority;

	public MerchantSettleItemEO() {
	}

	public String toMerchantSettleJson() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<String, String>();
		map.put("msiCardOrg", msiCardOrg);
		map.put("msiCardType", msiCardType);
		map.put("msiSettleRuleId", msiSettleRuleId + "");
		map.put("msiCycleType", msiCycleType + "");
		map.put("msiCycleValue", msiCycleValue);
		map.put("msiHolidayFee", msiHolidayFee + "");
		map.put("msiWorkDayFee", msiWorkDayFee + "");
		map.put("msiPriority", msiPriority + "");
		map.put("msiStatus", msiStatus + "");
		map.put("msiBeginTime", DateUtil.date2Str(msiBeginTime, DateUtil.dateFormat4));
		map.put("msiEndTime", DateUtil.date2Str(msiEndTime, DateUtil.dateFormat4));

		return objectMapper.writeValueAsString(map);
	}

	public Long getMsiId() {
		return msiId;
	}

	public void setMsiId(Long msiId) {
		this.msiId = msiId;
	}

	public Date getMsiCreateTime() {
		return msiCreateTime;
	}

	public void setMsiCreateTime(Date msiCreateTime) {
		this.msiCreateTime = msiCreateTime;
	}

	public Date getMsiUpdateTime() {
		return msiUpdateTime;
	}

	public void setMsiUpdateTime(Date msiUpdateTime) {
		this.msiUpdateTime = msiUpdateTime;
	}

	public Long getMsiVersion() {
		return msiVersion;
	}

	public void setMsiVersion(Long msiVersion) {
		this.msiVersion = msiVersion;
	}

	public String getMsiMerchantNo() {
		return msiMerchantNo;
	}

	public void setMsiMerchantNo(String msiMerchantNo) {
		this.msiMerchantNo = msiMerchantNo;
	}

	public String getMsiCardType() {
		return msiCardType;
	}

	public void setMsiCardType(String msiCardType) {
		this.msiCardType = msiCardType;
	}

	public String getMsiCardOrg() {
		return msiCardOrg;
	}

	public void setMsiCardOrg(String msiCardOrg) {
		this.msiCardOrg = msiCardOrg;
	}

	public Long getMsiCycleType() {
		return msiCycleType;
	}

	public void setMsiCycleType(Long msiCycleType) {
		this.msiCycleType = msiCycleType;
	}

	public String getMsiCycleValue() {
		return msiCycleValue;
	}

	public void setMsiCycleValue(String msiCycleValue) {
		this.msiCycleValue = msiCycleValue;
	}

	public Long getMsiSettleRuleId() {
		return msiSettleRuleId;
	}

	public void setMsiSettleRuleId(Long msiSettleRuleId) {
		this.msiSettleRuleId = msiSettleRuleId;
	}

	public String getMsiIssureId() {
		return msiIssureId;
	}

	public void setMsiIssureId(String msiIssureId) {
		this.msiIssureId = msiIssureId;
	}

	public BigDecimal getMsiHolidayFee() {
		return msiHolidayFee;
	}

	public void setMsiHolidayFee(BigDecimal msiHolidayFee) {
		this.msiHolidayFee = msiHolidayFee;
	}

	public BigDecimal getMsiWorkDayFee() {
		return msiWorkDayFee;
	}

	public void setMsiWorkDayFee(BigDecimal msiWorkDayFee) {
		this.msiWorkDayFee = msiWorkDayFee;
	}

	public Date getMsiBeginTime() {
		return msiBeginTime;
	}

	public void setMsiBeginTime(Date msiBeginTime) {
		this.msiBeginTime = msiBeginTime;
	}

	public Date getMsiEndTime() {
		return msiEndTime;
	}

	public void setMsiEndTime(Date msiEndTime) {
		this.msiEndTime = msiEndTime;
	}

	public Long getMsiStatus() {
		return msiStatus;
	}

	public void setMsiStatus(Long msiStatus) {
		this.msiStatus = msiStatus;
	}

	public Long getMsiPriority() {
		return msiPriority;
	}

	public void setMsiPriority(Long msiPriority) {
		this.msiPriority = msiPriority;
	}

}
