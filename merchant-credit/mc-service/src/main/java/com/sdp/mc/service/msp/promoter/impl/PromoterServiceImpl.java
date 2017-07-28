package com.sdp.mc.service.msp.promoter.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.util.CstValueUtil;
import com.sdp.mc.common.util.ListUtil;
import com.sdp.mc.dao.readonly.promoter.PromoterCond;
import com.sdp.mc.dao.readonly.promoter.PromoterDAO;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.service.msp.promoter.PromoterPO;
import com.sdp.mc.service.msp.promoter.PromoterRO;
import com.sdp.mc.service.msp.promoter.PromoterService;
import com.sdp.mc.service.msp.promoter.PromoterTO;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.service.withdraw.T0WithdrawService;

/**
 * @author zhangguoliang.burt 拓展商
 */
@Deprecated
@Service("PromoterService")
public class PromoterServiceImpl implements PromoterService {
	private Logger logger = LoggerFactory.getLogger(PromoterServiceImpl.class);

	@Autowired
	private PromoterDAO promoterDAO;
	@Autowired
	private T0WithdrawService t0WithdrawService;


	/**
	 * 查询拓展商信息
	 */
	public PaginationBaseObject<PromoterRO> queryPromoter(PromoterPO po) {
		PromoterCond cond = new PromoterCond();
		BeanUtils.copyProperties(po, cond);
		PaginationBaseObject<PromoterRO> pageRO = new PaginationBaseObject<PromoterRO>();
		int totalCount = promoterDAO.queryCountPromoters(cond);
		if (totalCount == 0) {
			return null;
		}
		Integer maxPageNo = (totalCount / po.getPageSize()) + (totalCount % po.getPageSize() > 0 ? 1 : 0);
		if (po.getPageNo() > maxPageNo) {
			cond.setPageNo(maxPageNo);
		}
		List<PromoterEO> promoterEOs = promoterDAO.queryPromoters(cond);
		pageRO.setDataList(convertToRO(promoterEOs));
		pageRO.setPagination(totalCount, cond.getPageSize(), cond.getPageNo());
		return pageRO;
	}

	/**
	 * 将EO转化成RO
	 * 
	 * @param promoterEOs
	 * @return
	 */
	private List<PromoterRO> convertToRO(List<PromoterEO> promoterEOs) {
		List<PromoterRO> promoterROs = new ArrayList<PromoterRO>();
		for (PromoterEO eo : promoterEOs) {
			PromoterRO ro = new PromoterRO();
			BeanUtils.copyProperties(eo, ro);
//			ro.setMcStatusCh(CstValueUtil.getChValue(MerchantContractCst.class, "MC_STATUS", ro.getMcStatus()));
			ro.setTodayLimit(t0WithdrawService.getWithdrawT0ServiceAPI().findTotalAmount(ro.getMcMerchantNo(), ro.getMcType()));
			promoterROs.add(ro);
		}
		return promoterROs;
	}

	/**
	 * 根据拓展商Id查询相关信息
	 */
	public PromoterRO queryPromoterInfoById(Long mcId) {
		PromoterRO ro = new PromoterRO();
		queryPromoterInfo(mcId, ro);
		return ro;
	}

	/**
	 * 根据McId查询拓展商的合同信息
	 * 
	 * @param mcId
	 * @param ro
	 */
	private void queryPromoterInfo(Long mcId, PromoterRO ro) {
		PromoterEO eo = promoterDAO.queryPromoterByMcId(mcId);
		if(eo==null)
			ro = new PromoterRO();
		else
			BeanUtils.copyProperties(eo, ro);
	}

	/**
	 * 根据mcMerchantNo查询拓展商McId
	 * 
	 * @param mcMerchantNo
	 */
	@Deprecated
	public Long queryPromoterInfoByMcMerchantNo(String promoterNo) {
		return promoterDAO.queryPromoterByMcMerchantNo(promoterNo);
	}

	public List<PromoterEO> queryPromoterListByMerchantNo(String merchantNo) {
		List<PromoterEO> promoterEO = promoterDAO.queryPromoterListByMerchantNo(merchantNo);
		return promoterEO;
	}

	@Override
	public List<PromoterEO> queryPromoterAll() {
		return promoterDAO.queryPromoterAll();
	}

	@Override
	public List<PromoterEO> queryPromoterInfo(List<String> merchantNoList) {
		
		return promoterDAO.queryPromoterInfo(merchantNoList);
	}

	

}
