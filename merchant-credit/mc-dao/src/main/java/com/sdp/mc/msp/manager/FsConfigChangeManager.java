package com.sdp.mc.msp.manager;

import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.dao.FsConfigChangeDOExample;
import java.util.List;

public interface FsConfigChangeManager {
	    /**
	     * 根据主键删除配置更改记录【FsConfigChangeDO】对象信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    int deleteByPrimaryKey(Long fcmId);

	    /**
	     * 添加配置更改记录【FsConfigChangeDO】对象信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    Long insert(FsConfigChangeDO record);

	    /**
	     * 添加配置更改记录【FsConfigChangeDO】对象信息,空值字段不插入
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    Long insertSelective(FsConfigChangeDO record);

	    /**
	     * 根据Example对象查询得到配置更改记录【FsConfigChangeDO】对象列表信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    List<FsConfigChangeDO> selectByExample(FsConfigChangeDOExample example);

	    /**
	     * 根据主键查询配置更改记录【FsConfigChangeDO】对象信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    FsConfigChangeDO selectByPrimaryKey(Long fcmId);

	    /**
	     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息，仅更新非空对象
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    int updateByPrimaryKeySelective(FsConfigChangeDO record);

	    /**
	     * 根据主键更新配置更改记录【FsConfigChangeDO】对象信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    int updateByPrimaryKey(FsConfigChangeDO record);

	    /**
	     * 根据Query对象分页查询配置更改记录【FsConfigChangeDO】对象列表信息
	     *
	     * @mbggenerated Wed Nov 09 15:53:44 CST 2016
	     */
	    List<FsConfigChangeDO> selectByQuery(FsConfigChangeDOExample example);

	public int selectMaxVersion(long objId, int objType);

	public int selectChangeFeeSum(long objId);

	List<FsConfigChangeDO> selectSpecialPageSizeChanges(Long promoterId, Integer opType, Integer status);
}