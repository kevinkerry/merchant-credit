package com.shengpay.service.view;

import java.util.List;

import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;

public interface MerchantInfoService {

	ViewMerchantInfoDTO queryMerchantInfoByMerchantNo(String merchantNo);

	ViewMerchantInfoDTO queryMerchantInfoByMerchantNo(String merchantNo, String mcType);

	List<ViewMerchantInfoDTO> queryAllMerchantInfo();

	ViewMerchantInfoDTO queryMerchantInfoByMerchantId(long merchantId);

	List<ViewMerchantInfoDTO> selectByExample(ViewMerchantInfoDTOExample example);


}
