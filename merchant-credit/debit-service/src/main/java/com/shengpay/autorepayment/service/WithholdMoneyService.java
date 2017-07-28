package com.shengpay.autorepayment.service;

import java.util.List;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingInfoExample;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.ext.dataobject.TbWithholdingInfoDTO;

/**
 * 处理与批次 ，订单有关的数据
 *
 * @author liutao
 *
 */
public interface WithholdMoneyService {
	/**
	 * 获取批次信息
	 *
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingBrechInfoPO> selectBrechByExample(TbWithholdingBrechInfoExample queryParam) throws Exception;

	public List<TbWithholdingBrechInfoPO> pageQueryBrechInfoList(ExtTbWithholdingInfoExample queryParam) throws Exception;

	/**
	 * 获取文件信息
	 *
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public TbWithholdingFileInfoPO selectFileByExample(String batchNo) throws Exception;

	public TbWithholdingFileInfoPO selectFileByExample(TbWithholdingFileInfoExample queryParam) throws Exception;

	/**
	 * 获取订单信息
	 *
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingOrderInfoPO> selectOrderByExample(TbWithholdingOrderInfoExample queryParam) throws Exception;

	public List<TbWithholdingOrderInfoPO> pageQueryOrderInfoList(ExtTbWithholdingOrderInfoExample queryParam) throws Exception;

	/**
	 * 删除批次信息（逻辑删除）
	 *
	 * @param brechNo
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBrechInfo(String batchNo) throws Exception;

	/**
	 * 删除订单信息（逻辑删除）
	 *
	 * @param brechNo
	 * @return
	 * @throws Exception
	 */
	public boolean deleteOrderInfo(String batchNo) throws Exception;

	/**
	 * 删除文件信息
	 *
	 * @param brechNo
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFileInfo(String batchNo, String filekey) throws Exception;

	/**
	 * 新增批次信息
	 *
	 * @param breachList
	 * @throws Exception
	 */
	public void addBrechInfo(TbWithholdingInfoDTO dataDTO) throws Exception;

	/**
	 * 新增订单信息
	 *
	 * @param orderList
	 * @throws Exception
	 */
	public void addOrderInfo(List<TbWithholdingOrderInfoPO> orderList);

	/**
	 * 新增文件信息
	 *
	 * @param fileInfo
	 * @throws Exception
	 */
	public void addFileInfo(TbWithholdingFileInfoPO fileInfo) throws Exception;

	public Long addTransInfo(TbWithholdingTransLogPO po) throws Exception;
	public int updateTransInfo(TbWithholdingTransLogPO po) throws Exception;

	/**
	 * 更新批次信息
	 *
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public boolean updateBreachByExample(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example) throws Exception;

	/**
	 * 更新订单信息
	 *
	 * @param example
	 * @return
	 * @throws Exception
	 */
	public boolean updateOrderByExample(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example) throws Exception;

	/**
	 * 更新文件
	 *
	 * @param record
	 * @param example
	 * @return
	 */
	public boolean updateFileByExample(TbWithholdingFileInfoPO record);

	/**
	 * 更新批次状态
	 *
	 * @param status
	 */
	public int updateBatchStatus(String status, TbWithholdingInfoDTO dto, String exStatus);

	/**
	 * 更新订单
	 *
	 * @param status
	 * @param batchNo
	 * @param exStatus
	 * @throws Exception
	 */

	public void updateOrderStatus(TbWithholdingInfoDTO dto, String exStatus) throws Exception;

	/**
	 * 更新订单状态
	 *
	 * @param dto
	 * @param exStatus
	 */
	public int updateOrderOpStatus(TbWithholdingOrderInfoPO dto, String exStatus);

	/**
	 * 查询待回调订单状态
	 *
	 * @param orderNo
	 * @param batchNo
	 * @return
	 */
	public boolean findOrderOpByOrderNo(String orderNo, String batchNo);

	/**
	 * 根据订单号查询批次号
	 *
	 * @param transNo
	 * @return
	 */
	public TbWithholdingOrderInfoPO findOrderInfoByTransNo(String transNo);

	/**
	 * 更新批次
	 *
	 * @param record
	 * @return
	 */
	public int updateBrechByPrimaryKeySelective(TbWithholdingBrechInfoPO record);

	/**
	 * 更细订单
	 */
	public int updateOrderByPrimaryKeySelective(TbWithholdingOrderInfoPO record);

	/**
	 * 查询失败订数量
	 *
	 * @param orderNo
	 * @param batchNo
	 * @return
	 */
	public String findFailOrderByBatchNo(String batchNo);

	/**
	 * 查询失败订单数据
	 *
	 * @param orderNo
	 * @param batchNo
	 * @return
	 */
	public List<TbWithholdingOrderInfoPO> findFailOrderListByBatchNo(String batchNo);

	/**
	 * 查询所有待回调（处理中）的订单
	 *
	 * @return
	 */
	public List<TbWithholdingOrderInfoPO> findInvokCallbackOrder();

	/**
	 * 查询成功订单状态
	 *
	 * @param orderNo
	 * @param batchNo
	 * @return
	 */
	public String findSuccessOrderByBatchNo(String batchNo);

	public String creditWithholdingOrderNo();

	public boolean updateByExampleSelective(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example);

	public boolean findOrderOpByOrderNo(String batchNo);

	// 根据批次号查询 状态处理中(没有明确状态，成功，失败，过期)的 order 数量
	public int selectOrderByBatchNo(String batchNo);
}
