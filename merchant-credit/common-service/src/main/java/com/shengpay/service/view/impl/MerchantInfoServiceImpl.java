package com.shengpay.service.view.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;
import com.sdp.mc.view.manager.ViewMerchantInfoManager;
import com.shengpay.service.view.MerchantInfoService;

@Service
public class MerchantInfoServiceImpl implements MerchantInfoService {
	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(MerchantInfoServiceImpl.class);

	@Autowired
	private ViewMerchantInfoManager viewMerchantInfoManager;

	@Override
	public ViewMerchantInfoDTO queryMerchantInfoByMerchantNo(String merchantNo) {
		ViewMerchantInfoDTOExample example = new ViewMerchantInfoDTOExample();
		example.setMerchantNo(merchantNo);
		List<ViewMerchantInfoDTO> list = this.viewMerchantInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public ViewMerchantInfoDTO queryMerchantInfoByMerchantNo(String merchantNo, String mcType) {
		ViewMerchantInfoDTOExample example = new ViewMerchantInfoDTOExample();
		example.setMerchantNo(merchantNo);
		example.setMcType(mcType);
		List<ViewMerchantInfoDTO> list = this.viewMerchantInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<ViewMerchantInfoDTO> queryAllMerchantInfo() {
		ViewMerchantInfoDTOExample example = new ViewMerchantInfoDTOExample();
		return this.viewMerchantInfoManager.selectByExample(example);
	}

	@Override
	public ViewMerchantInfoDTO queryMerchantInfoByMerchantId(long merchantId) {
		ViewMerchantInfoDTOExample example = new ViewMerchantInfoDTOExample();
		example.setMerchantId(merchantId);
		List<ViewMerchantInfoDTO> list = this.viewMerchantInfoManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<ViewMerchantInfoDTO> selectByExample(ViewMerchantInfoDTOExample example) {
		return this.viewMerchantInfoManager.selectByExample(example);
	}

}
