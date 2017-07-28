package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawReqFosDetailDAO;
import com.sdp.withdraw.manager.WithdrawReqFosDetailManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawReqFosDetailManager")
public class WithdrawReqFosDetailManagerImpl implements WithdrawReqFosDetailManager {
    @Autowired
    private WithdrawReqFosDetailDAO withdrawReqFosDetailDAO;

    /**
     * 根据主键删除出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long detailId) {
        int rows = withdrawReqFosDetailDAO.deleteByPrimaryKey(detailId);
        return rows;
    }

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public Long insert(WithdrawReqFosDetailDO record) {
        Long id = withdrawReqFosDetailDAO.insert(record);
        return record.getDetailId();
    }

    /**
     * 添加出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawReqFosDetailDO record) {
        Long id = withdrawReqFosDetailDAO.insertSelective(record);
        return record.getDetailId();
    }

    /**
     * 根据Example对象查询得到出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawReqFosDetailDO> selectByExample(WithdrawReqFosDetailDOExample example) {
        List<WithdrawReqFosDetailDO> list = withdrawReqFosDetailDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public WithdrawReqFosDetailDO selectByPrimaryKey(Long detailId) {
        WithdrawReqFosDetailDO record = withdrawReqFosDetailDAO.selectByPrimaryKey(detailId);
        return record;
    }

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawReqFosDetailDO record) {
        int rows = withdrawReqFosDetailDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawReqFosDetailDO record) {
        int rows = withdrawReqFosDetailDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询出款业务调用FOS详细表【WithdrawReqFosDetailDO】对象列表信息
     *
     * @mbggenerated Fri Mar 11 19:55:36 CST 2016
     */
    @Override
    public List<WithdrawReqFosDetailDO> selectByQuery(WithdrawReqFosDetailDOExample example) {
        Integer totalItem = (Integer)withdrawReqFosDetailDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawReqFosDetailDO> returnList = new ArrayList<WithdrawReqFosDetailDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<WithdrawReqFosDetailDO> list =withdrawReqFosDetailDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}