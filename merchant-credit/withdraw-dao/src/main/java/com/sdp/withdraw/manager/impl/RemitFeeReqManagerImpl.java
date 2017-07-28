package com.sdp.withdraw.manager.impl;

import com.sdp.withdraw.dao.RemitFeeReqDo;
import com.sdp.withdraw.dao.RemitFeeReqDoExample;
import com.sdp.withdraw.dao.daointerface.RemitFeeReqDAO;
import com.sdp.withdraw.manager.RemitFeeReqManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("remitFeeReqManager")
public class RemitFeeReqManagerImpl implements RemitFeeReqManager {
    @Autowired
    private RemitFeeReqDAO remitFeeReqDAO;

    /**
     * 根据主键删除退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long remitId) {
        int rows = remitFeeReqDAO.deleteByPrimaryKey(remitId);
        return rows;
    }

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public Long insert(RemitFeeReqDo record) {
        Long id = remitFeeReqDAO.insert(record);
        return record.getRemitId();
    }

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public Long insertSelective(RemitFeeReqDo record) {
        Long id = remitFeeReqDAO.insertSelective(record);
        return record.getRemitId();
    }

    /**
     * 根据Example对象查询得到退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<RemitFeeReqDo> selectByExample(RemitFeeReqDoExample example) {
        List<RemitFeeReqDo> list = remitFeeReqDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public RemitFeeReqDo selectByPrimaryKey(Long remitId) {
        RemitFeeReqDo record = remitFeeReqDAO.selectByPrimaryKey(remitId);
        return record;
    }

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(RemitFeeReqDo record) {
        int rows = remitFeeReqDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public int updateByPrimaryKey(RemitFeeReqDo record) {
        int rows = remitFeeReqDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    @Override
    public List<RemitFeeReqDo> selectByQuery(RemitFeeReqDoExample example) {
        Integer totalItem = (Integer)remitFeeReqDAO.countByExample(example);

        example.setTotalItem(totalItem);

        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<RemitFeeReqDo> returnList = new ArrayList<RemitFeeReqDo>();
        if (example.getPageFristItem() <= example.getTotalItem()) {

            List<RemitFeeReqDo> list =remitFeeReqDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }
}