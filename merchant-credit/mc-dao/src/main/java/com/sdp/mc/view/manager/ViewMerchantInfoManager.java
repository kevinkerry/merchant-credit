package com.sdp.mc.view.manager;

import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;
import java.util.List;

public interface ViewMerchantInfoManager {

    /**
     * 根据Example对象查询得到null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    List<ViewMerchantInfoDTO> selectByExample(ViewMerchantInfoDTOExample example);

    /**
     * 根据Query对象分页查询null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    List<ViewMerchantInfoDTO> selectByQuery(ViewMerchantInfoDTOExample example);
}