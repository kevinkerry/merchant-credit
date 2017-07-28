package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;
import java.util.List;

public interface WhiteListInfoManager {
    /**
     * 根据主键删除白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    Long insert(WhiteListInfoDO record);

    /**
     * 添加白名单信息表【WhiteListInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    Long insertSelective(WhiteListInfoDO record);

    /**
     * 根据Example对象查询得到白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    List<WhiteListInfoDO> selectByExample(WhiteListInfoDOExample example);

    /**
     * 根据主键查询白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    WhiteListInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    int updateByPrimaryKeySelective(WhiteListInfoDO record);

    /**
     * 根据主键更新白名单信息表【WhiteListInfoDO】对象信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    int updateByPrimaryKey(WhiteListInfoDO record);

    /**
     * 根据Query对象分页查询白名单信息表【WhiteListInfoDO】对象列表信息
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    List<WhiteListInfoDO> selectByQuery(WhiteListInfoDOExample example);
}