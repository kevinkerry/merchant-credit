package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.daointerface.WithdrawReqDAO;
import com.sdp.withdraw.manager.WithdrawReqManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("withdrawReqManager")
public class WithdrawReqManagerImpl implements WithdrawReqManager {
    @Autowired
    private WithdrawReqDAO withdrawReqDAO;

    /**
     * 根据主键删除出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long reqId) {
        int rows = withdrawReqDAO.deleteByPrimaryKey(reqId);
        return rows;
    }

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public Long insert(WithdrawReqDO record) {
        Long id = withdrawReqDAO.insert(record);
        return record.getReqId();
    }

    /**
     * 添加出款业务请求表【WithdrawReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public Long insertSelective(WithdrawReqDO record) {
        Long id = withdrawReqDAO.insertSelective(record);
        return record.getReqId();
    }

    /**
     * 根据Example对象查询得到出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WithdrawReqDO> selectByExample(WithdrawReqDOExample example) {
        List<WithdrawReqDO> list = withdrawReqDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public WithdrawReqDO selectByPrimaryKey(Long reqId) {
        WithdrawReqDO record = withdrawReqDAO.selectByPrimaryKey(reqId);
        return record;
    }

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(WithdrawReqDO record) {
        int rows = withdrawReqDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新出款业务请求表【WithdrawReqDO】对象信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public int updateByPrimaryKey(WithdrawReqDO record) {
        int rows = withdrawReqDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询出款业务请求表【WithdrawReqDO】对象列表信息
     *
     * @mbggenerated Tue May 31 10:37:35 CST 2016
     */
    @Override
    public List<WithdrawReqDO> selectByQuery(WithdrawReqDOExample example) {
        Integer totalItem = (Integer)withdrawReqDAO.countByExample(example);

        example.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<WithdrawReqDO> returnList = new ArrayList<WithdrawReqDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<WithdrawReqDO> list =withdrawReqDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}