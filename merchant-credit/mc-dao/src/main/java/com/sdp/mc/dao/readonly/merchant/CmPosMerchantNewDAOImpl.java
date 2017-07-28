package com.sdp.mc.dao.readonly.merchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sdp.mc.common.util.StringUtil;
import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;
import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

/**
 * (cm)POS商户
 *
 * @author liuxi.xiliu
 */
@Repository("cmPosMerchantNewDAO")
@Deprecated
public class CmPosMerchantNewDAOImpl implements CmPosMerchantNewDAO {
	private static Logger log = LoggerFactory.getLogger(CmPosMerchantNewDAOImpl.class);
	
	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name = "ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;

	@Override
	public String selectPromoterNoByPromoterId(Long promoterId) {
		try {
			Object o = ibatisTemplete.queryForObject("cmPosMerchantNewDAO.selectPromoterNoByPromoterId", promoterId);
			return o == null ? "" : o.toString();
		} catch (Exception e) {
			log.error("CmPosMerchantNewDAOImpl.selectPromoterNoByPromoterId.error" + e.getMessage(), e);
			return "";
		}

	}

	/**
	 * 获取合同信息 获取这个字段mcCreateTime
	 */
	public CmMerchantContractEO selectContractInfo(String merchantNo) {
		List<CmMerchantContractEO> list = ibatisTemplete.queryForList("cmPosMerchantNewDAO.selectContractInfo", merchantNo);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 连续收单六个月
	 */
	@Override
	public boolean selectOPenContract(String merchantNo, int monthCount) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("merchantNo", merchantNo);
		paramMap.put("monthCount", monthCount);
		int o = (Integer) ibatisTemplete.queryForObject("cmPosMerchantNewDAO.selectOPenContract", paramMap);
		if (o > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 参与保证金取回的代理商
	 */

	@Override
	public List<CmPosMerchantFastEOExt> selectFastAmount() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return ibatisTemplete.queryForList("cmPosMerchantNewDAO.selectFastAmount", paramMap);
	}

	@Override
	public CmMerchantContractEO selecMerchantInfo(String promoterId) {
		List<CmMerchantContractEO> list = ibatisTemplete.queryForList("cmPosMerchantNewDAO.selecMerchantInfo", promoterId);
		if (null == list)
			return null;
		return list.get(0);
	}

}
