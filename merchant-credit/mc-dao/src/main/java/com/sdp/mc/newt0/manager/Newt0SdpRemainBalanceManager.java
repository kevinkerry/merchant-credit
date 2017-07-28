package com.sdp.mc.newt0.manager;

import java.util.List;

import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;

public interface Newt0SdpRemainBalanceManager {
    /**
     * 添加null【Newt0SdpRemainBalanceDO】对象信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
	Long insert(Newt0SdpRemainBalanceDO record);

    /**
     * 添加null【Newt0SdpRemainBalanceDO】对象信息,空值字段不插入
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
	Long insertSelective(Newt0SdpRemainBalanceDO record);

    /**
     * 根据Example对象查询得到null【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    List<Newt0SdpRemainBalanceDO> selectByExample(Newt0SdpRemainBalanceDOExample example);

    /**
     * 根据Query对象分页查询null【Newt0SdpRemainBalanceDO】对象列表信息
     *
     * @mbggenerated Thu Sep 17 14:47:15 CST 2015
     */
    List<Newt0SdpRemainBalanceDO> selectByQuery(Newt0SdpRemainBalanceDOExample example);
    
    int updateByPrimaryKey(Newt0SdpRemainBalanceDO record);
    
    public int updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record);
    
    
}