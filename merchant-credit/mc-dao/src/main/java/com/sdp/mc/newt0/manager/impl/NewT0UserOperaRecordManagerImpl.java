package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import com.sdp.mc.newt0.dao.daointerface.NewT0UserOperaRecordDAO;
import com.sdp.mc.newt0.manager.NewT0UserOperaRecordManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newT0UserOperaRecordManager")
public class NewT0UserOperaRecordManagerImpl implements NewT0UserOperaRecordManager {
    @Autowired
    private NewT0UserOperaRecordDAO newT0UserOperaRecordDAO;

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @Override
    public Long insert(NewT0UserOperaRecordDO record) {
        Long id = newT0UserOperaRecordDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @Override
    public Long insertSelective(NewT0UserOperaRecordDO record) {
        Long id = newT0UserOperaRecordDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<NewT0UserOperaRecordDO> selectByExample(NewT0UserOperaRecordDOExample example) {
        List<NewT0UserOperaRecordDO> list = newT0UserOperaRecordDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据Query对象分页查询保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    @Override
    public List<NewT0UserOperaRecordDO> selectByQuery(NewT0UserOperaRecordDOExample example) {
        Integer totalItem = (Integer)newT0UserOperaRecordDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<NewT0UserOperaRecordDO> returnList = new ArrayList<NewT0UserOperaRecordDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<NewT0UserOperaRecordDO> list =newT0UserOperaRecordDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}