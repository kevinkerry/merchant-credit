package com.sdp.mc.newt0.manager.impl;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import com.sdp.mc.newt0.dao.daointerface.Newt0McLimitChangeReqDAO;
import com.sdp.mc.newt0.manager.Newt0McLimitChangeReqManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newt0McLimitChangeReqManager")
public class Newt0McLimitChangeReqManagerImpl implements Newt0McLimitChangeReqManager {
    @Autowired
    private Newt0McLimitChangeReqDAO newt0McLimitChangeReqDAO;

    /**
     * 根据主键删除商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int deleteByPrimaryKey(Long reqId) {
        int rows = newt0McLimitChangeReqDAO.deleteByPrimaryKey(reqId);
        return rows;
    }

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Long insert(Newt0McLimitChangeReqDO record) {
        Long id = newt0McLimitChangeReqDAO.insert(record);
        return record.getReqId();
    }

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Long insertSelective(Newt0McLimitChangeReqDO record) {
        Long id = newt0McLimitChangeReqDAO.insertSelective(record);
        return record.getReqId();
    }

    /**
     * 根据Example对象查询得到商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Newt0McLimitChangeReqDO> selectByExample(Newt0McLimitChangeReqDOExample example) {
        List<Newt0McLimitChangeReqDO> list = newt0McLimitChangeReqDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public Newt0McLimitChangeReqDO selectByPrimaryKey(Long reqId) {
        Newt0McLimitChangeReqDO record = newt0McLimitChangeReqDAO.selectByPrimaryKey(reqId);
        return record;
    }

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int updateByPrimaryKeySelective(Newt0McLimitChangeReqDO record) {
        int rows = newt0McLimitChangeReqDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public int updateByPrimaryKey(Newt0McLimitChangeReqDO record) {
        int rows = newt0McLimitChangeReqDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    @Override
    public List<Newt0McLimitChangeReqDO> selectByQuery(Newt0McLimitChangeReqDOExample example) {
        Integer totalItem = (Integer)newt0McLimitChangeReqDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<Newt0McLimitChangeReqDO> returnList = new ArrayList<Newt0McLimitChangeReqDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<Newt0McLimitChangeReqDO> list =newt0McLimitChangeReqDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }

	@Override
	public int countByExample(Newt0McLimitChangeReqDOExample query) {
		
		return this.newt0McLimitChangeReqDAO.countByExample(query);
	}
}