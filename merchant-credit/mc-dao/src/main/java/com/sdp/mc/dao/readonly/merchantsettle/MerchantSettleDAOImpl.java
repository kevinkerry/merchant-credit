package com.sdp.mc.dao.readonly.merchantsettle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

@Repository("merchantSettleDAO")
@Deprecated
public class MerchantSettleDAOImpl implements MerchantSettleDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "ibatisTemplate_mc")
	private IbatisBaseDAOImpl ibatisTemplete;

	@Override
	public Long insert(MerchantSettleEO eo) {
		Long msId = (Long) ibatisTemplete.insert("MerchantSettleDAO.insert", eo);
		return msId;
	}

	@Override
	public MerchantSettleEO selectEOByMerchantNo(String merchantNo) {
		return (MerchantSettleEO) ibatisTemplete.queryForObject("MerchantSettleDAO.selectEOByMerchantNo", merchantNo);
	}

	@Override
	public int updateByEO(MerchantSettleEO eo) {
		int update = 0;
		try {
			update = ibatisTemplete.update("MerchantSettleDAO.updateByEO", eo);
		} catch (OptimisticLockingFailureException e) {
			logger.error("更新结算信息【" + new Gson().toJson(eo) + "】出现异常：【" + e + "】");
			throw new OptimisticLockingFailureException("更新结算信息【" + eo + "】出现乐观锁异常");
		}
		return update;
	}

	/**
	 * 前一天所创建的快速结算
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MerchantSettleEO> queryMerchantSettleListByCreateYesterday() {
		// 取当前日期
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(cal.getTime());
		return ibatisTemplete.queryForList("MerchantSettleDAO.queryMerchantSettleListByCreateYesterday", date);
	}

	/**
	 * T0出款调用--根据商户号查询商户出款额度
	 * @param merchantNo 商户的商户号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MerchantSettleEO> selectByMerchantNo(String merchantNo) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("merchantNo", merchantNo);
		return ibatisTemplete.queryForList("MerchantSettleDAO.selectByMerchantNo", map);
	}


}
