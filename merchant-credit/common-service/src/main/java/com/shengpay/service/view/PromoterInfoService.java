package com.shengpay.service.view;

import java.util.List;

import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;

public interface PromoterInfoService {
/**
 * 查询代理商信息
 * @param merchantNo 代理商商户号
 * @param mcType 代理商类型
 * @return
 */
	List<ViewPromoterInfoDTO> queryPromoterInfoByMerchantInfo(String merchantNo, String mcType);

	ViewPromoterInfoDTO queryPromoterById(Long id);

	ViewPromoterInfoDTO queryPromoterInfo(String promoterNo, String mcType);

	List<ViewPromoterInfoDTO> selectByExample(ViewPromoterInfoDTOExample example);

}
