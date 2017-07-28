package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawReqExtraInfoDO;
import com.sdp.withdraw.dao.WithdrawReqExtraInfoDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawReqExtraInfoDAO;
import com.sdp.withdraw.manager.WithdrawReqExtraInfoManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawReqExtraInfoManager")
public class WithdrawReqExtraInfoManagerImpl implements WithdrawReqExtraInfoManager {
    @Autowired
    private WithdrawReqExtraInfoDAO withdrawReqExtraInfoDAO;

    /**
     * 根据主键删除出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        int rows = withdrawReqExtraInfoDAO.deleteByPrimaryKey(id);
        return rows;
    }

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public Long insert(WithdrawReqExtraInfoDO record) {
        Long id = withdrawReqExtraInfoDAO.insert(record);
        return record.getId();
    }

    /**
     * 添加出款扩展信息【WithdrawReqExtraInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawReqExtraInfoDO record) {
        Long id = withdrawReqExtraInfoDAO.insertSelective(record);
        return record.getId();
    }

    /**
     * 根据Example对象查询得到出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawReqExtraInfoDO> selectByExample(WithdrawReqExtraInfoDOExample example) {
        List<WithdrawReqExtraInfoDO> list = withdrawReqExtraInfoDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public WithdrawReqExtraInfoDO selectByPrimaryKey(Long id) {
        WithdrawReqExtraInfoDO record = withdrawReqExtraInfoDAO.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawReqExtraInfoDO record) {
        int rows = withdrawReqExtraInfoDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新出款扩展信息【WithdrawReqExtraInfoDO】对象信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawReqExtraInfoDO record) {
        int rows = withdrawReqExtraInfoDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询出款扩展信息【WithdrawReqExtraInfoDO】对象列表信息
     *
     * @mbggenerated Tue Aug 30 09:37:59 CST 2016
     */
    @Override
    public List<WithdrawReqExtraInfoDO> selectByQuery(WithdrawReqExtraInfoDOExample example) {
        Integer totalItem = (Integer)withdrawReqExtraInfoDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawReqExtraInfoDO> returnList = new ArrayList<WithdrawReqExtraInfoDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawReqExtraInfoDO> list =withdrawReqExtraInfoDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}