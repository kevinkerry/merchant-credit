package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample;
import java.util.List;

public interface Newt0McLimitChangeDtlManager {
    /**
     * 根据主键删除商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int deleteByPrimaryKey(Long changeId);

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Long insert(Newt0McLimitChangeDtlDO record);

    /**
     * 添加商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息,空值字段不插入
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Long insertSelective(Newt0McLimitChangeDtlDO record);

    /**
     * 根据Example对象查询得到商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    List<Newt0McLimitChangeDtlDO> selectByExample(Newt0McLimitChangeDtlDOExample example);

    /**
     * 根据主键查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    Newt0McLimitChangeDtlDO selectByPrimaryKey(Long changeId);

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int updateByPrimaryKeySelective(Newt0McLimitChangeDtlDO record);

    /**
     * 根据主键更新商户额度变更明细【Newt0McLimitChangeDtlDO】对象信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    int updateByPrimaryKey(Newt0McLimitChangeDtlDO record);

    /**
     * 根据Query对象分页查询商户额度变更明细【Newt0McLimitChangeDtlDO】对象列表信息
     *
     * @mbggenerated Wed Dec 30 15:56:42 CST 2015
     */
    List<Newt0McLimitChangeDtlDO> selectByQuery(Newt0McLimitChangeDtlDOExample example);
}