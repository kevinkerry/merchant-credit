package com.sdp.mc.service.mcwithfunding.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.enums.WithCapitalEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import com.sdp.mc.mcwithfunding.manager.WithCapital4PromoterManager;
import com.sdp.mc.pcs.dao.WorkCalendar;
import com.sdp.mc.pcs.dao.WorkCalendarExample;
import com.sdp.mc.pcs.manager.WorkCalendManager;
import com.sdp.mc.service.mcwithfunding.WithCapital4PromoterService;

@Service("withCapital4PromoterService")
public class WithCapital4PromoterServiceImpl implements WithCapital4PromoterService {

	@Autowired
	private WithCapital4PromoterManager withCapital4PromoterManager;
	@Autowired
	private WorkCalendManager workCalendManager;

	@Override
	public List<WithCapital4PromoterDO> pageQueryWithCapital(WithCapital4PromoterDOExample example) {
		return this.withCapital4PromoterManager.selectByQuery(example);
	}

	@Override
	public int updateByPrimaryKeySelective(Long id, Long creditFosId, Long feeFosId, String batchNo, Long creditChangeId, Integer status) {
		WithCapital4PromoterDO record = withCapital4PromoterManager.selectByPrimaryKey(id);
		if(creditFosId != null){
			record.setCreditFosId(creditFosId);
		}
		if(feeFosId != null){
			record.setFeeFosId(feeFosId);
		}
		if(batchNo != null){
			record.setBatchNo(batchNo);
		}
		if (creditChangeId != null) {
			record.setCreditChangeId(creditChangeId);
		}
		record.setStatus(status);
		return withCapital4PromoterManager.updateByPrimaryKeySelective(record);
	}

	@Override
	public Long insert(WithCapital4PromoterDO record) {
		return withCapital4PromoterManager.insert(record);
	}

	@Override
	public BigDecimal queryWithCapital4Promoter(Long promoterId) {
		Date now = new Date();
		BigDecimal amount = BigDecimal.ZERO;
		WithCapital4PromoterDOExample example = new WithCapital4PromoterDOExample();
		WithCapital4PromoterDOExample.Criteria criteria = example.createCriteria();
		criteria.andPromoterIdEqualTo(promoterId);
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_SUCCESS.code);
		statusList.add(WithCapitalEnums.MSP_FAST_SETTLE_LIMIT_ADD_FAILURE.code);
		criteria.andApplyDatetimeBetween(DateUtil.generateDawnTimeStamp(now), DateUtil.generateMidnightTimeStamp(now));
		criteria.andStatusIn(statusList);
		List<WithCapital4PromoterDO> list = withCapital4PromoterManager.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (WithCapital4PromoterDO dto : list) {
				amount = amount.add(dto.getAmount());
			}
			return amount;
		} else {
			return null;
		}

	}

	@Override
	public String isWorkDay(Date toDay) {
		String now = DateUtil.date2Str(toDay, DateUtil.dateFormat3);
		WorkCalendarExample example = new WorkCalendarExample();
		WorkCalendarExample.Criteria criteria = example.createCriteria();
		criteria.andDateStrEqualTo(now);
		List<WorkCalendar> list = workCalendManager.selectByExample(example);
		if (list != null && !list.isEmpty())
			return list.get(0).getIsWorkDay();
		return null;
	}

	public Date getNextWorkDay(Date now) {
		String isWorkDay = isWorkDay(now);
		Date nextWorkDay = null;
		if (isWorkDay != null && "0".equals(isWorkDay)) {
			nextWorkDay = DateUtil.increaseDate(now, 1);
			getNextWorkDay(nextWorkDay);
		}
		return nextWorkDay;
	}

}
