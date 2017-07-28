package com.sdp.mc.msp.manager.impl;

import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample;
import com.sdp.mc.msp.dao.daointerface.FsConfigChangeDAO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fsConfigChangeManager")
public class FsConfigChangeManagerImpl implements FsConfigChangeManager {
    @Autowired
    private FsConfigChangeDAO fsConfigChangeDAO;

    /**
     * 根据主键删除配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public int deleteByPrimaryKey(Long fcmId) {
        int rows = fsConfigChangeDAO.deleteByPrimaryKey(fcmId);
        return rows;
    }

    /**
     * 添加配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public Long insert(FsConfigChangeDO record) {
        Long id = fsConfigChangeDAO.insert(record);
        return record.getFcmId();
    }

    /**
     * 添加配置更改记录【FsConfigChangeDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public Long insertSelective(FsConfigChangeDO record) {
        Long id = fsConfigChangeDAO.insertSelective(record);
        return record.getFcmId();
    }

    /**
     * 根据Example对象查询得到配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<FsConfigChangeDO> selectByExample(FsConfigChangeDOExample example) {
        List<FsConfigChangeDO> list = fsConfigChangeDAO.selectByExample(example);
        return list;
    }

    /**
     * 根据主键查询配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public FsConfigChangeDO selectByPrimaryKey(Long fcmId) {
        FsConfigChangeDO record = fsConfigChangeDAO.selectByPrimaryKey(fcmId);
        return record;
    }

    /**
     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public int updateByPrimaryKeySelective(FsConfigChangeDO record) {
        int rows = fsConfigChangeDAO.updateByPrimaryKeySelective(record);
        return rows;
    }

    /**
     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public int updateByPrimaryKey(FsConfigChangeDO record) {
        int rows = fsConfigChangeDAO.updateByPrimaryKey(record);
        return rows;
    }

    /**
     * 根据Query对象分页查询配置更改记录【FsConfigChangeDO】对象列表信息
     *
     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
     */
    @Override
    public List<FsConfigChangeDO> selectByQuery(FsConfigChangeDOExample example) {
        Integer totalItem = (Integer)fsConfigChangeDAO.countByExample(example);
        
        example.setTotalItem(totalItem);
        
        if (example.isNeedQueryAll() && totalItem > 0) {
             	example.setPageSize(totalItem);
        }
        List<FsConfigChangeDO> returnList = new ArrayList<FsConfigChangeDO>();
        if (example.getPageFristItem() <= example.getTotalItem()) {
             
            List<FsConfigChangeDO> list =fsConfigChangeDAO.selectByQuery(example);
             returnList.addAll(list);
        }
        return returnList;
    }

	public int selectMaxVersion(long objId, int objType) {
		Integer maxVersion = fsConfigChangeDAO.selectMaxVersion(objId, objType);
		if (maxVersion == null)
			return 0;
		return maxVersion;
	}

	public int selectChangeFeeSum(long objId) {
		Integer sum = fsConfigChangeDAO.selectChangeFeeSum(objId);
		if (sum == null) {
			return 0;
		}
		return sum;
	}

	@Override
	public List<FsConfigChangeDO> selectSpecialPageSizeChanges(Long promoterId, Integer opType, Integer status) {
		FsConfigChangeDOExample example = new FsConfigChangeDOExample();
		example.createCriteria().andObjIdEqualTo(promoterId).andOpTypeNotEqualTo(opType).andStatusEqualTo(status).andTypeEqualTo(OpObjTypeEnums.PROMOTER.getCode());
		example.setOrderByClause(" UPDATE_TIME DESC");
		example.setTotalItem(example.getPageSize());
		return fsConfigChangeDAO.selectByQuery(example);// 用了默认页面大小
	}

}