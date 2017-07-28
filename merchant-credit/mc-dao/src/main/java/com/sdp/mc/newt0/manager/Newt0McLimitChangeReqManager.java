package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import java.util.List;

public interface Newt0McLimitChangeReqManager {
    /**
     * 根据主键删除商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int deleteByPrimaryKey(Long reqId);

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Long insert(Newt0McLimitChangeReqDO record);

    /**
     * 添加商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Long insertSelective(Newt0McLimitChangeReqDO record);

    /**
     * 根据Example对象查询得到商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    List<Newt0McLimitChangeReqDO> selectByExample(Newt0McLimitChangeReqDOExample example);

    /**
     * 根据主键查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Newt0McLimitChangeReqDO selectByPrimaryKey(Long reqId);

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int updateByPrimaryKeySelective(Newt0McLimitChangeReqDO record);

    /**
     * 根据主键更新商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int updateByPrimaryKey(Newt0McLimitChangeReqDO record);

    /**
     * 根据Query对象分页查询商户额度变更请求信息表【Newt0McLimitChangeReqDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    List<Newt0McLimitChangeReqDO> selectByQuery(Newt0McLimitChangeReqDOExample example);

	int countByExample(Newt0McLimitChangeReqDOExample query);
}