package com.sdp.mc.service.msp.posmerchant.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantDAO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantCond;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.facade.msp.MspFacade;
import com.sdp.mc.service.msp.posmerchant.MspPosMerchantRO;
import com.sdp.mc.service.msp.posmerchant.PosMerchantService;
import com.sdp.withdraw.enums.WithdrawRatioTypeEnums;
import com.sdp.withdraw.vo.ratio.WithdrawRatioQueryResponse;
import com.shengpay.commons.core.base.PaginationBaseObject;
import com.shengpay.service.withdraw.T0WithdrawService;

@Service("PosMerchantService")
public class PosMerchantServiceImpl implements PosMerchantService {
	private static Logger logger = LoggerFactory.getLogger(PosMerchantServiceImpl.class);
	@Autowired
	private MspPosMerchantDAO mspPosMerchantDAO;
	@Autowired
	private MspFacade mspFacade;
	@Autowired
	private T0WithdrawService t0WithdrawService;
	/**
	 * (分页)代理商查询POS商户
	 */
	public PaginationBaseObject<MspPosMerchantRO> pagingPmtQueryPosMerchant(PmtQueryPosMerchantPO po) {
		PaginationBaseObject<MspPosMerchantRO> pbo = new PaginationBaseObject<MspPosMerchantRO>();

		Integer count = mspPosMerchantDAO.pmtQueryPosMerchantCount(po);
		if (count == 0) {
			pbo.setDataList(new ArrayList<MspPosMerchantRO>());
		} else {
			String mcType = "";
			Integer maxPageNo = (count / po.getPageSize()) + (count % po.getPageSize() > 0 ? 1 : 0);
			if (po.getPageNo() > maxPageNo) {
				po.setPageNo(maxPageNo);
			}
			List<MspPosMerchantEO> list = mspPosMerchantDAO.pmtQueryPosMerchant(po);
			for(MspPosMerchantEO mspPosMerchantEO : list){
				WithdrawRatioQueryResponse res = null;
				if(po.getType().equals(MerchantContractCst.TYPE_MPOS_MERCHANT)){
					res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(mspPosMerchantEO.getMerchantNo(), MerchantContractCst.TYPE_MPOS_MERCHANT, WithdrawRatioTypeEnums.MPOS_T0_SETTLE_RATIO.code); 
				}else if(po.getType().equals(MerchantContractCst.TYPE_POS_MERCHANT)){
					res = t0WithdrawService.getMerchantCurrentAvaliableWithdrawRatio(mspPosMerchantEO.getMerchantNo(), MerchantContractCst.TYPE_POS_MERCHANT, WithdrawRatioTypeEnums.POS_T0_SETTLE_RATIO.code); 
				}
				try {
					
				if(res != null && res.getWithdrawRatioResults() != null && res.getWithdrawRatioResults().size() > 0 
						&& res.getWithdrawRatioResults().get(0) != null 
						&& res.getWithdrawRatioResults().get(0).getWorkDayWithDrawRatio() != null 
						&& res.getWithdrawRatioResults().get(0).getHolidayWithDrawRatio() != null){
					mspPosMerchantEO.setWorkdayFee(res.getWithdrawRatioResults().get(0).getWorkDayWithDrawRatio());
					mspPosMerchantEO.setHolidayFee(res.getWithdrawRatioResults().get(0).getHolidayWithDrawRatio());
				}else{
					mspPosMerchantEO.setWorkdayFee(null);
					mspPosMerchantEO.setHolidayFee(null);
				}
				} catch (Exception e) {
					logger.error("pagingPmtQueryPosMerchant getRatio Exception,mspPosMerchantEO:"+ToStringBuilder.reflectionToString(mspPosMerchantEO),e);
				}
				
			}
			pbo.setDataList(this.mspPosMerchantEOListToROList(list));
		}
		pbo.setPagination(count, po.getPageSize(), po.getPageNo());
		return pbo;
	}

	/**
	 * eoList转roList
	 * 
	 * @param list
	 * @return
	 */
	private List<MspPosMerchantRO> mspPosMerchantEOListToROList(List<MspPosMerchantEO> list) {
		List<MspPosMerchantRO> roList = new ArrayList<MspPosMerchantRO>(list.size());
		for (MspPosMerchantEO eo : list) {
			roList.add(new MspPosMerchantRO(eo));
		}
		return roList;
	}

	/**
	 * 代理商查询POS商户结果集全部
	 */
	public List<MspPosMerchantEO> pmtQueryAllPosMerchant(PmtQueryPosMerchantCond cond) {
		return mspPosMerchantDAO.pmtQueryAllPosMerchant(cond);
	}

	@Override
	public List<MspPosMerchantEO> querySyncPosMerchantInfo(PmtQueryPosMerchantPO po) {
		// TODO Auto-generated method stub
		return mspPosMerchantDAO.querySyncPosMerchantInfo(po);
	}

}
