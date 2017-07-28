package com.sdp.withdraw.manager.ext.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawServiceTypeEnums;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.daointerface.ext.ExtRefoundReqDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtWithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtRefoundReqVO;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqDOExample;
import com.sdp.withdraw.dao.ext.ExtWithdrawReqVO;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqManager;
import com.sdp.withdraw.manager.impl.WithdrawReqManagerImpl;

@Service("extWithdrawReqManager")
public class ExtWithdrawReqManagerImpl extends WithdrawReqManagerImpl implements ExtWithdrawReqManager{
	private static final Logger log = LoggerFactory.getLogger(ExtWithdrawReqManagerImpl.class);
	@Autowired
	private ExtWithdrawReqDAO extWithdrawReqDAO;
	@Autowired
	private ExtRefoundReqDAO extRefoundReqDAO;
	@Override
	public Integer queryWithdrawReqCount(ExtWithdrawReqDOExample example) {
		Integer totalItem = (Integer) extWithdrawReqDAO.countWithdrawReqByQuery(example);
		return totalItem;
	}
	@Override
	public List<ExtWithdrawReqVO> queryWithdrawReqInfo(
			ExtWithdrawReqDOExample example) {

		Integer totalItem = (Integer) extWithdrawReqDAO.countWithdrawReqByQuery(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<ExtWithdrawReqVO> returnList = new ArrayList<ExtWithdrawReqVO>();
		List<ExtWithdrawReqVO> list = extWithdrawReqDAO.selectWithdrawReqByQuery(example);
		returnList.addAll(list);
		return returnList;
	}
	@Override
	public List<ExtWithdrawReqVO> selectWithdrawReqByQuery(
			ExtWithdrawReqDOExample example) {

		Integer totalItem = (Integer) extWithdrawReqDAO.countWithdrawReqByQuery(example);

		example.setTotalItem(totalItem);

		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<ExtWithdrawReqVO> returnList = new ArrayList<ExtWithdrawReqVO>();
		if (example.getPageFristItem() > example.getTotalItem()) {
			example.setCurrentPage(1);
		}
		List<ExtWithdrawReqVO> list = extWithdrawReqDAO.selectWithdrawReqByQuery(example);
		returnList.addAll(list);
		return returnList;
	}
	@Override
	public List<ExtWithdrawReqVO> queryWithdrawInfoByQuery(
			ExtWithdrawReqDOExample example) {
		
		Integer totalItem = (Integer) extWithdrawReqDAO.countWithdrawInfoByQuery(example);
		
		example.setTotalItem(totalItem);
		
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<ExtWithdrawReqVO> returnList = new ArrayList<ExtWithdrawReqVO>();
		if (example.getPageFristItem() > example.getTotalItem()) {
			example.setCurrentPage(1);
		}
		List<ExtWithdrawReqVO> list = extWithdrawReqDAO.queryWithdrawInfoByQuery(example);
		returnList.addAll(list);
		return returnList;
	}

	@Override
	public int updateByExampleSelective(WithdrawReqDO record, WithdrawReqDOExample example) {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.updateByExampleSelective(record, example);
	}
	@Override
	public int updateByExample(WithdrawReqDO record, WithdrawReqDOExample example) {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.updateByExample(record, example);
	}

	public List<ExtWithdrawReqVO> selectMerchantFastsettleByQuery(
			ExtWithdrawReqDOExample example) {
	long time=System.currentTimeMillis();
	Integer totalItem = (Integer) extWithdrawReqDAO.countMerchantFastsettleByQuery(example);
	log.info("#selectMerchantFastsettleByQuery count use time:"+(System.currentTimeMillis()-time));
	example.setTotalItem(totalItem);
	
	if (example.isNeedQueryAll() && totalItem > 0) {
		example.setPageSize(totalItem);
	}
	List<ExtWithdrawReqVO> returnList = new ArrayList<ExtWithdrawReqVO>();
	if (example.getPageFristItem() > example.getTotalItem()) {
		example.setCurrentPage(1);
	}
	time=System.currentTimeMillis();
	List<ExtWithdrawReqVO> list = extWithdrawReqDAO.selectMerchantFastsettleByQuery(example);
	returnList.addAll(list);
	log.info("#selectMerchantFastsettleByQuery page query data use time:"+(System.currentTimeMillis()-time));
	return returnList;
}
	/**
	 * 退款
	 * @param example
	 * @return
	 */
	@Override
	public Integer queryRefoundCount(ExtWithdrawReqDOExample example) {
		Integer totalItem = (Integer) extRefoundReqDAO.countRefoundByQuery(example);
		return totalItem;
	}
	@Override
	public List<ExtRefoundReqVO> queryRefoundReqInfo(ExtWithdrawReqDOExample example) {
		Integer totalItem = (Integer) queryRefoundCount(example);
		example.setTotalItem(totalItem);
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<ExtRefoundReqVO> list = extRefoundReqDAO.selectRefoundByQuery(example);
		return list;

	}
	@Override
	public StatisticsWithdrawInfoDTO statisticsPromoterMerchantWithdrawInfo(Long promoterId) {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.statisticsPromoterMerchantWithdrawInfo(promoterId);
	}
	@Override
	public List<WithdrawReqDO> queryStatusDisagreeInfo() {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.queryStatusDisagreeInfo();
	}
	@Override
	public List<StatisticsWithdrawInfoDTO> statisticsPromoterWithdrawInfo(Long promoterId) {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.statisticsPromoterWithdrawInfo(promoterId);
	}
	@Override
	public List<StatisticsWithdrawInfoDTO> statisticsMerchantWithdrawInfo(Long merchantBizId) {
		// TODO Auto-generated method stub
		return extWithdrawReqDAO.statisticsMerchantWithdrawInfo(merchantBizId);
	}
	@Override
	public BigDecimal queryWithdrawReqTotalAmount(String merchantNo, String mcType, Date startTime, Date endTime) {
		ExtWithdrawReqDOExample example=new ExtWithdrawReqDOExample();
		example.setMerchantNo(merchantNo);
		example.setMcType(mcType);
		example.setServiceType(WithdrawServiceTypeEnums.T0.code);
		example.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
		example.setStartWithdrawTime(startTime);
		example.setEndWithdrawTime(endTime);
		return (BigDecimal) extWithdrawReqDAO.queryWithdrawReqTotalAmount(example);
	}
}
