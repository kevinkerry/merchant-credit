package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;
import com.sdp.mc.newt0.dao.daointerface.WhiteListInfoDAO;
import com.sdp.mc.newt0.manager.WhiteListInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("whiteListInfoManager")
public class WhiteListInfoManagerImpl implements WhiteListInfoManager {
    @Autowired
    private WhiteListInfoDAO whiteListInfoDAO;

    /**
     * 根据主键删除白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = whiteListInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public Long insert(WhiteListInfoDO record) {
        Long id = whiteListInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public Long insertSelective(WhiteListInfoDO record) {
        Long id = whiteListInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WhiteListInfoDO> selectByExample(WhiteListInfoDOExample example) {
        List<WhiteListInfoDO> list = whiteListInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public WhiteListInfoDO selectByPrimaryKey(Long id) {
        WhiteListInfoDO record = whiteListInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WhiteListInfoDO record) {
        int rows = whiteListInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WhiteListInfoDO record) {
        int rows = whiteListInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    @Override
    public List<WhiteListInfoDO> selectByQuery(WhiteListInfoDOExample example) {
        Integer totalItem = (Integer)whiteListInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WhiteListInfoDO> returnList = new ArrayList<WhiteListInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WhiteListInfoDO> list =whiteListInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}