package com.sdp.withdraw.manager;

import com.sdp.withdraw.dao.RemitFeeReqDo;
import com.sdp.withdraw.dao.RemitFeeReqDoExample;
import java.util.List;

public interface RemitFeeReqManager {
    /**
     * 根据主键删除退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    int deleteByPrimaryKey(Long remitId);

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    Long insert(RemitFeeReqDo record);

    /**
     * 添加退款记录【RemitFeeReqDo】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    Long insertSelective(RemitFeeReqDo record);

    /**
     * 根据Example对象查询得到退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    List<RemitFeeReqDo> selectByExample(RemitFeeReqDoExample example);

    /**
     * 根据主键查询退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    RemitFeeReqDo selectByPrimaryKey(Long remitId);

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    int updateByPrimaryKeySelective(RemitFeeReqDo record);

    /**
     * 根据主键更新退款记录【RemitFeeReqDo】对象信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    int updateByPrimaryKey(RemitFeeReqDo record);

    /**
     * 根据Query对象分页查询退款记录【RemitFeeReqDo】对象列表信息
     *
     * @mbggenerated Mon Apr 25 15:42:27 CST 2016
     */
    List<RemitFeeReqDo> selectByQuery(RemitFeeReqDoExample example);
}