package com.shengpay.service.view.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;
import com.sdp.mc.view.dao.daointerface.ViewPromoterInfoDAO;
import com.sdp.mc.view.manager.ViewPromoterInfoManager;
import com.shengpay.service.view.PromoterInfoService;

@Service
public class PromoterInfoServiceImpl implements PromoterInfoService {

	@Autowired
	private ViewPromoterInfoManager viewPromoterInfoManager;
	@Autowired
	private ViewPromoterInfoDAO viewPromoterInfoDAO;

	@Override
	public List<ViewPromoterInfoDTO> queryPromoterInfoByMerchantInfo(String merchantNo, String mcType) {
		ViewPromoterInfoDTOExample example = new ViewPromoterInfoDTOExample();
		example.setPromoterMerchantNo(merchantNo);
		example.setPromoterType(mcType);
		return this.viewPromoterInfoDAO.selectByExample(example);
	}

	@Override
	public ViewPromoterInfoDTO queryPromoterById(Long id) {
		if(id==null){
			return null;
		}
		ViewPromoterInfoDTOExample example = new ViewPromoterInfoDTOExample();
		example.setPromoterId(id);
		List<ViewPromoterInfoDTO> list = this.viewPromoterInfoDAO.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public ViewPromoterInfoDTO queryPromoterInfo(String promoterNo, String mcType) {
		List<ViewPromoterInfoDTO> list = queryPromoterInfoByMerchantInfo(promoterNo, mcType);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<ViewPromoterInfoDTO> selectByExample(ViewPromoterInfoDTOExample example) {

		return this.viewPromoterInfoManager.selectByExample(example);
	}

}
