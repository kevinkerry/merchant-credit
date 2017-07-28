package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import com.sdp.mc.newt0.dao.daointerface.NewT0AuditInfoDAO;
import com.sdp.mc.newt0.manager.NewT0AuditInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newT0AuditInfoManager")
public class NewT0AuditInfoManagerImpl implements NewT0AuditInfoManager {
    @Autowired
    private NewT0AuditInfoDAO newT0AuditInfoDAO;

    /**
     * 根据主键删除审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = newT0AuditInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public Long insert(NewT0AuditInfoDO record) {
        Long id = newT0AuditInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public Long insertSelective(NewT0AuditInfoDO record) {
        Long id = newT0AuditInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<NewT0AuditInfoDO> selectByExample(NewT0AuditInfoDOExample example) {
        List<NewT0AuditInfoDO> list = newT0AuditInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public NewT0AuditInfoDO selectByPrimaryKey(Long id) {
        NewT0AuditInfoDO record = newT0AuditInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(NewT0AuditInfoDO record) {
        int rows = newT0AuditInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public int updateByPrimaryKey(NewT0AuditInfoDO record) {
        int rows = newT0AuditInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    @Override
    public List<NewT0AuditInfoDO> selectByQuery(NewT0AuditInfoDOExample example) {
        Integer totalItem = (Integer)newT0AuditInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<NewT0AuditInfoDO> returnList = new ArrayList<NewT0AuditInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<NewT0AuditInfoDO> list =newT0AuditInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}