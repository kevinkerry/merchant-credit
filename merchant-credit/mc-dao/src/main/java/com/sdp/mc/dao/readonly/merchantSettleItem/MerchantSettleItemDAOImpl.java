package com.sdp.mc.dao.readonly.merchantSettleItem;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.sdp.mc.common.util.DateUtil;
import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

@Repository("merchantSettleItemDAO")
@Deprecated
public class MerchantSettleItemDAOImpl implements MerchantSettleItemDAO {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "ibatisTemplate_mc")
	private IbatisBaseDAOImpl ibatisTemplete;

	@Override
	public Long insert(MerchantSettleItemEO eo) {
		Long msiId = (Long) ibatisTemplete.insert("MerchantSettleItemDAO.insert", eo);
		return msiId;
	}

	@Override
	public int deleteByMerchantNo(String merchantNo, Long msiStatus) {
		int delete = 0;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merchantNo", merchantNo);
		paramMap.put("msiStatus", msiStatus);
		try {
			delete = ibatisTemplete.delete("MerchantSettleItemDAO.deleteByMerchantNo", paramMap);
		} catch (OptimisticLockingFailureException e) {
			logger.error(String.format("delete merchant settle items by merchantNo 【%s】 with exception 【%s】", merchantNo, e));
			throw new OptimisticLockingFailureException("删除商户号【" + merchantNo + "】的结算规则出现乐观锁异常");
		}
		return delete;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantSettleItemEO> queryEOByMerchantNo(String merchantNo) {
		return (List<MerchantSettleItemEO>) ibatisTemplete.queryForList("MerchantSettleItemDAO.queryEOByMerchantNo", merchantNo);
	}

	@Override
	public void invalidByMsiId(Long msiId) {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("msiId", msiId);
			// String nowStr = DateUtil.dateToStr(new Date(), "yyyy-MM-dd");
			paramMap.put("msiEndTime", DateUtil.generateMidnightTimeStamp(new Date()));
			ibatisTemplete.update("MerchantSettleItemDAO.invalidByMsiId", paramMap);
		} catch (OptimisticLockingFailureException e) {
			throw new OptimisticLockingFailureException("更新结算规则【" + msiId + "】出现乐观锁异常");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantSettleItemEO> queryListByMerchantNoAdStatus(String merchantNo, Long status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merchantNo", merchantNo);
		paramMap.put("status", status);
		return (List<MerchantSettleItemEO>) ibatisTemplete.queryForList("MerchantSettleItemDAO.queryListByMerchantNoAdStatus", paramMap);
	}

	@SuppressWarnings("unchecked")
	public MerchantSettleItemEO queryFastSettleItmeByMerchantNo(String merchantNo) {
		List<MerchantSettleItemEO> itemEOs = ibatisTemplete.queryForList("MerchantSettleItemDAO.queryFastSettleItmeByMerchantNo", merchantNo);
		return (itemEOs == null || itemEOs.isEmpty()) ? null : itemEOs.get(0);
	}

	public void updateSttleItemProirity(Long msiId, Long msiPriority) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("msiId", msiId);
		paramMap.put("msiPriority", msiPriority);
		ibatisTemplete.update("MerchantSettleItemDAO.updateSttleItemProirity", paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantSettleItemEO> queryFastSettleItmeByMerchantList(String merchantNo) {
		return (List<MerchantSettleItemEO>) ibatisTemplete.queryForList("MerchantSettleItemDAO.queryFastSettleItmeByMerchantList", merchantNo);
	}
}
