package com.sdp.mc.view.manager;

import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;
import java.util.List;

public interface ViewPromoterInfoManager {
    

    /**
     * 根据Example对象查询得到null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:46:53 CST 2016
     */
    List<ViewPromoterInfoDTO> selectByExample(ViewPromoterInfoDTOExample example);

    /**
     * 根据Query对象分页查询null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:46:53 CST 2016
     */
    List<ViewPromoterInfoDTO> selectByQuery(ViewPromoterInfoDTOExample example);
}