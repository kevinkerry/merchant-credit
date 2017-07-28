package com.sdp.mc.newt0.manager;

import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import java.util.List;

public interface NewT0UserOperaRecordManager {
    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    Long insert(NewT0UserOperaRecordDO record);

    /**
     * 添加保证金赎回放款操作表【NewT0UserOperaRecordDO】对象信息,空值字段不插入
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    Long insertSelective(NewT0UserOperaRecordDO record);

    /**
     * 根据Example对象查询得到保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    List<NewT0UserOperaRecordDO> selectByExample(NewT0UserOperaRecordDOExample example);

    /**
     * 根据Query对象分页查询保证金赎回放款操作表【NewT0UserOperaRecordDO】对象列表信息
     *
     * @mbggenerated Fri Oct 09 09:50:32 CST 2015
     */
    List<NewT0UserOperaRecordDO> selectByQuery(NewT0UserOperaRecordDOExample example);
}