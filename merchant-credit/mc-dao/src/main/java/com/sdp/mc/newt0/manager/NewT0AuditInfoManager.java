package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.NewT0AuditInfoDO;
import com.sdp.mc.newt0.dao.NewT0AuditInfoDOExample;
import java.util.List;

public interface NewT0AuditInfoManager {
    /**
     * 根据主键删除审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    Long insert(NewT0AuditInfoDO record);

    /**
     * 添加审核表【NewT0AuditInfoDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    Long insertSelective(NewT0AuditInfoDO record);

    /**
     * 根据Example对象查询得到审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    List<NewT0AuditInfoDO> selectByExample(NewT0AuditInfoDOExample example);

    /**
     * 根据主键查询审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    NewT0AuditInfoDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    int updateByPrimaryKeySelective(NewT0AuditInfoDO record);

    /**
     * 根据主键更新审核表【NewT0AuditInfoDO】对象信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    int updateByPrimaryKey(NewT0AuditInfoDO record);

    /**
     * 根据Query对象分页查询审核表【NewT0AuditInfoDO】对象列表信息
     *
     * @mbggenerated Mon Jun 06 17:21:26 CST 2016
     */
    List<NewT0AuditInfoDO> selectByQuery(NewT0AuditInfoDOExample example);
}