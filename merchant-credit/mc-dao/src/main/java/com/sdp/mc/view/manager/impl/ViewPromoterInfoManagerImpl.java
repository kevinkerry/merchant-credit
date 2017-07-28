package com.sdp.mc.view.manager.impl;

import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.view.dao.ViewPromoterInfoDTOExample;
import com.sdp.mc.view.dao.daointerface.ViewPromoterInfoDAO;
import com.sdp.mc.view.manager.ViewPromoterInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("viewPromoterInfoManager")
public class ViewPromoterInfoManagerImpl implements ViewPromoterInfoManager {
    @Autowired
    private ViewPromoterInfoDAO viewPromoterInfoDAO;

    

    /**
     * 根据Example对象查询得到null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:46:53 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ViewPromoterInfoDTO> selectByExample(ViewPromoterInfoDTOExample example) {
        List<ViewPromoterInfoDTO> list = viewPromoterInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据Query对象分页查询null【ViewPromoterInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:46:53 CST 2016
     */
    @Override
    public List<ViewPromoterInfoDTO> selectByQuery(ViewPromoterInfoDTOExample example) {
        Integer totalItem = (Integer)viewPromoterInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<ViewPromoterInfoDTO> returnList = new ArrayList<ViewPromoterInfoDTO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<ViewPromoterInfoDTO> list =viewPromoterInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}