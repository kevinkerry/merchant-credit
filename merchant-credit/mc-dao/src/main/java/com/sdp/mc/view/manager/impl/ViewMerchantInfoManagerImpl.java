package com.sdp.mc.view.manager.impl;

import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.mc.view.dao.ViewMerchantInfoDTOExample;
import com.sdp.mc.view.dao.daointerface.ViewMerchantInfoDAO;
import com.sdp.mc.view.manager.ViewMerchantInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("viewMerchantInfoManager")
public class ViewMerchantInfoManagerImpl implements ViewMerchantInfoManager {
    @Autowired
    private ViewMerchantInfoDAO viewMerchantInfoDAO;

   

    /**
     * 根据Example对象查询得到null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ViewMerchantInfoDTO> selectByExample(ViewMerchantInfoDTOExample example) {
        List<ViewMerchantInfoDTO> list = viewMerchantInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据Query对象分页查询null【ViewMerchantInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 15:39:16 CST 2016
     */
    @Override
    public List<ViewMerchantInfoDTO> selectByQuery(ViewMerchantInfoDTOExample example) {
        Integer totalItem = (Integer)viewMerchantInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<ViewMerchantInfoDTO> returnList = new ArrayList<ViewMerchantInfoDTO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<ViewMerchantInfoDTO> list =viewMerchantInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}