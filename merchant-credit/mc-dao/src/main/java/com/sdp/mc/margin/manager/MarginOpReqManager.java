package com.sdp.mc.margin.manager;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
import com.sdp.mc.margin.dao.ext.MarginOpReqDOExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;

public interface MarginOpReqManager {
    /**
     * 根据主键删除代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    int deleteByPrimaryKey(Long morId);

    /**
     * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    Long insert(MarginOpReqDO record);

    /**
     * 添加代理商保证金追加/退回记录【MarginOpReqDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    Long insertSelective(MarginOpReqDO record);

    /**
     * 根据Example对象查询得到代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    List<MarginOpReqDO> selectByExample(MarginOpReqDOExample example);

    /**
     * 根据主键查询代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    MarginOpReqDO selectByPrimaryKey(Long morId);

    /**
     * 批量查询
     * @param morIds
     * @return
     */
    List<MarginOpReqDO> selectByPrimaryKeys(String morIds);
    /**
     * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    int updateByPrimaryKeySelective(MarginOpReqDO record);

    /**
     * 根据主键更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    int updateByPrimaryKey(MarginOpReqDO record);
    
    /**
     * 根据Query对象分页查询代理商保证金追加/退回记录【MarginOpReqDO】对象列表信息
     *
     * @mbggenerated Mon Mar 30 13:57:53 CST 2015
     */
    List<MarginOpReqDO> selectByQuery(MarginOpReqDOExample example);
    
    /**
	 * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息，仅更新非空字段
	 * 
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	int updateByExampleSelective(MarginOpReqDO record, MarginOpReqDOExample example);

	/**
	 * 根据Example对象更新代理商保证金追加/退回记录【MarginOpReqDO】对象信息
	 * 
	 * @mbggenerated Mon Mar 30 13:57:53 CST 2015
	 */
	int updateByExample(MarginOpReqDO record, MarginOpReqDOExample example);
	
	public List<MarginOpReqDOExt> selectByQuery4Intra(MarginOpReqDOExampleExt example);
	/**
	 * 保证金退回审核列表
	 * @param example
	 * @return
	 */
	public List<RedeemedMarginApplyExt> selectByNewT0AuditingQuery4Intra(RedeemedMarginApplyExampleExt example);

	/**
	 * 根据代理商id，操作类型，状态查询列表
	 * @param promoterId
	 * @param opType
	 * @param status
	 * @return
	 */
	List<MarginOpReqDO> queryMarginOpReq(Long promoterId, Integer opType, Integer status);
	
	/**
	 * 统计所有页面申请取回合计金额
	 * @param example
	 * @return
	 */
	BigDecimal totalAmount(RedeemedMarginApplyExampleExt example);

	/**
	 * 根据代理商id，操作类型，状态查询列表amount总和
	 * @param promoterId
	 * @param opType
	 * @param status
	 * @return
	 */
	BigDecimal queryMarginOpReqSum(Long promoterId, Integer opType, Integer status);
}