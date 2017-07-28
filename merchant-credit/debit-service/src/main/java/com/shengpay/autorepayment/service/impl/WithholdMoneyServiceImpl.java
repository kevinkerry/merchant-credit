package com.shengpay.autorepayment.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.autorepayment.service.WithholdMoneyService;
import com.shengpay.debit.common.enums.WithholdBatchOpStatusEnum;
import com.shengpay.debit.common.enums.WithholdCardTypeEnum;
import com.shengpay.debit.common.enums.WithholdOrderOpStatusEnum;
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
import com.shengpay.debit.ext.daointerface.ExtTbWithholdingBrechInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtTbWithholdingFileInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtTbWithholdingOrderInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtTbWithholdingTransLogDAO;

@Service
public class WithholdMoneyServiceImpl implements WithholdMoneyService {
	private static Logger log = LoggerFactory.getLogger(WithholdMoneyServiceImpl.class);
	@Autowired
	public ExtTbWithholdingBrechInfoDAO extTbWithholdingBrechInfoDAO;
	@Autowired
	public ExtTbWithholdingOrderInfoDAO extTbWithholdingOrderInfoDAO;
	@Autowired
	public ExtTbWithholdingFileInfoDAO extTbWithholdingFileInfoDAO;
	@Autowired
	public ExtTbWithholdingTransLogDAO extTbWithholdingTransLogDAO;

	@Override
	public List<TbWithholdingBrechInfoPO> pageQueryBrechInfoList(ExtTbWithholdingInfoExample example) throws Exception {
//		return extTbWithholdingBrechInfoDAO.pageQueryInfoList(example);
		return extTbWithholdingBrechInfoDAO.queryByPage(example);
	}

	@Override
	public List<TbWithholdingBrechInfoPO> selectBrechByExample(TbWithholdingBrechInfoExample queryParam) throws Exception {
		List<TbWithholdingBrechInfoPO> list = extTbWithholdingBrechInfoDAO.selectByExample(queryParam);
		return list;

	}

	@Override
	public TbWithholdingFileInfoPO selectFileByExample(String batchNo) throws Exception {
		TbWithholdingFileInfoExample fileExample = new TbWithholdingFileInfoExample();
		fileExample.createCriteria().andBatchNoEqualTo(batchNo);
		List<TbWithholdingFileInfoPO> list = extTbWithholdingFileInfoDAO.selectByExample(fileExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<TbWithholdingOrderInfoPO> pageQueryOrderInfoList(ExtTbWithholdingOrderInfoExample example) throws Exception {
		return extTbWithholdingOrderInfoDAO.pageQueryInfoList(example);
	}

	@Override
	public List<TbWithholdingOrderInfoPO> selectOrderByExample(TbWithholdingOrderInfoExample queryParam) throws Exception {
		return extTbWithholdingOrderInfoDAO.selectByExample(queryParam);
	}

	@Override
	public boolean deleteBrechInfo(String batchNo) throws Exception {
		TbWithholdingBrechInfoExample example = new TbWithholdingBrechInfoExample();
		example.createCriteria().andBatchNoEqualTo(batchNo);
		int rows = extTbWithholdingBrechInfoDAO.deleteByExample(example);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public boolean deleteOrderInfo(String batchNo) throws Exception {
		TbWithholdingOrderInfoExample orderExample = new TbWithholdingOrderInfoExample();
		orderExample.createCriteria().andBatchNoEqualTo(batchNo);
		int rows = extTbWithholdingOrderInfoDAO.deleteByExample(orderExample);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public boolean deleteFileInfo(String batchNo, String filekey) throws Exception {
		TbWithholdingFileInfoExample example = new TbWithholdingFileInfoExample();
		example.createCriteria().andBatchNoEqualTo(batchNo);
		example.createCriteria().andFileKeyEqualTo(filekey);
		int rows = extTbWithholdingFileInfoDAO.deleteByExample(example);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public void addBrechInfo(TbWithholdingInfoDTO dataDTO) throws Exception {
		TbWithholdingBrechInfoPO brechpO = new TbWithholdingBrechInfoPO();
		brechpO.setBatchNo(dataDTO.getBatchNo());
		brechpO.setBatchTime(dataDTO.getBatchTime());
		brechpO.setCreateTime(new java.util.Date());
		brechpO.setMerchantNo(dataDTO.getMerchantNo());
		// brechpO.setStatus(WithholdBatchStatusEnum.INIT.code);
		brechpO.setStatus(WithholdBatchOpStatusEnum.BATCH_INIT.code);
		brechpO.setTotalAmount(dataDTO.getTotalAmount());
		brechpO.setTotalCount(dataDTO.getTotalCount());
		brechpO.setOpernerid(dataDTO.getOpernerid());
		brechpO.setOpernername(dataDTO.getOpernername());
		brechpO.setBiztype(dataDTO.getBiztype());
		extTbWithholdingBrechInfoDAO.insert(brechpO);

	}

	/* (non-Javadoc)
	 * @see com.shengpay.autorepayment.service.WithholdMoneyService#addOrderInfo(java.util.List)
	 */
	@Override
	public void addOrderInfo(List<TbWithholdingOrderInfoPO> orderList) {
		if (orderList == null || orderList.isEmpty()) return;
		for (TbWithholdingOrderInfoPO po : orderList) {
			String orderNo = extTbWithholdingOrderInfoDAO.creditWithholdOrderNo();
			po.setMerchantOrderNo(orderNo);
			po.setStatus(WithholdBatchOpStatusEnum.BATCH_INIT.code);
			po.setCreateTime(new java.util.Date());
			po.setErrorcode("");//清空异常
			po.setErrormsg("");//清空异常
			if(StringUtils.isNotBlank(po.getCardType())&&po.getCardType().length()==1){
				po.setCardType(WithholdCardTypeEnum.getEnumsByCode(Integer.parseInt(po.getCardType())).value);
			}
			extTbWithholdingOrderInfoDAO.insert(po);
		}

	}
	@Override
	public void addFileInfo(TbWithholdingFileInfoPO fileInfo) throws Exception {
		extTbWithholdingFileInfoDAO.insert(fileInfo);
	}

	@Override
	public boolean updateBreachByExample(TbWithholdingBrechInfoPO record, TbWithholdingBrechInfoExample example) throws Exception {
		int rows = extTbWithholdingBrechInfoDAO.updateByExample(record, example);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public boolean updateOrderByExample(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example) throws Exception {
		int rows = extTbWithholdingOrderInfoDAO.updateByExample(record, example);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public boolean updateFileByExample(TbWithholdingFileInfoPO record) {
		TbWithholdingFileInfoExample example = new TbWithholdingFileInfoExample();
		example.createCriteria().andBatchNoEqualTo(record.getBatchNo());
		example.createCriteria().andFileKeyEqualTo(record.getFileKey());
		int rows = extTbWithholdingFileInfoDAO.updateByExample(record, example);
		if (rows > 0)
			return true;
		else return false;
	}

	@Override
	public TbWithholdingFileInfoPO selectFileByExample(TbWithholdingFileInfoExample example) throws Exception {
		List<TbWithholdingFileInfoPO> list = extTbWithholdingFileInfoDAO.selectByExample(example);
		if (list.size() == 0) return null;
		return list.get(0);

	}

	/**
	 * 更新批次状态
	 *
	 * @param status
	 * @throws Exception
	 */
	@Override
	public int updateBatchStatus(String status, TbWithholdingInfoDTO dto, String exStatus) {
		// 更新批次
		TbWithholdingBrechInfoExample queryExample = new TbWithholdingBrechInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample.Criteria criteria = queryExample.createCriteria();
		if (!StringUtils.isEmpty(dto.getBatchNo())) {
			List<String> batchNoList = new ArrayList<String>();
			String[] al = dto.getBatchNo().split(",");
			for (int i = 0; i < al.length; i++) {
				batchNoList.add(al[i]);
			}
			log.info("批量更新批次状态批次号: [ " + batchNoList.toString() + " ] ");
			criteria.andBatchNoIn(batchNoList);
		}

		criteria.andStatusEqualTo(exStatus);

		TbWithholdingBrechInfoPO record = new TbWithholdingBrechInfoPO();
		record.setStatus(status);
		record.setSucessCount(dto.getSucessCount());
		record.setFailCount(dto.getFailCount());
		record.setUpdateTime(new Date());
		record.setMerchantNo(dto.getResultCode());
		record.setOpernerid(dto.getOpernerid());
		record.setOpernername(dto.getOpernername());
		return extTbWithholdingBrechInfoDAO.updateByExampleSelective(record, queryExample);

	}

	/**
	 * 更细订单
	 */
	@Override
	public void updateOrderStatus(TbWithholdingInfoDTO dto, String exStatus) throws Exception {
		// //更新订单
		TbWithholdingOrderInfoExample queryExample = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = queryExample.createCriteria();
		criteria.andBatchNoEqualTo(dto.getBatchNo());
		criteria.andStatusEqualTo(exStatus);
		List<TbWithholdingOrderInfoPO> orderList = dto.getTbWithholdingOrderInfoList();
		for (TbWithholdingOrderInfoPO orderInfoPO : orderList) {
			TbWithholdingOrderInfoPO record = new TbWithholdingOrderInfoPO();
			record.setStatus(orderInfoPO.getStatus());
			record.setRemark(orderInfoPO.getRemark());
			record.setUpdateTime(new Date());
			extTbWithholdingOrderInfoDAO.updateByExampleSelective(record, queryExample);
		}

	}

	/**
	 * 更新订单
	 */
	@Override
	public int updateOrderOpStatus(TbWithholdingOrderInfoPO po, String exStatus) {
		TbWithholdingOrderInfoExample queryExample = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = queryExample.createCriteria();
		if (!StringUtils.isEmpty(po.getMerchantOrderNo())) {
			criteria.andMerchantOrderNoEqualTo(po.getMerchantOrderNo());
		}
		if (StringUtils.isNotEmpty(po.getBatchNo())) {
			criteria.andBatchNoEqualTo(po.getBatchNo());
		}

		if (StringUtils.isNotEmpty(po.getStatus())) {
			criteria.andStatusEqualTo(po.getStatus());
		}

		if (po.getId() != null && po.getId() > 0) {
			criteria.andIdEqualTo(po.getId());
		}

		TbWithholdingOrderInfoPO record = new TbWithholdingOrderInfoPO();
		record.setStatus(exStatus);
		record.setUpdateTime(new Date());
		record.setErrorcode(po.getErrorcode());
		record.setErrormsg(po.getErrormsg());
		record.setPayablefee(po.getPayablefee());
		record.setReceivablefee(po.getReceivablefee());
		record.setRequestTime(po.getRequestTime());
		record.setSucessTime(po.getSucessTime());
		if (!StringUtils.isEmpty(po.getExt())) {
			record.setExt(po.getExt());
		}
		return extTbWithholdingOrderInfoDAO.updateByExampleSelective(record, queryExample);
	}

	@Override
	public Long addTransInfo(TbWithholdingTransLogPO po) throws Exception {
		 return extTbWithholdingTransLogDAO.insert(po);

	}

	public boolean findOrderOpByOrderNo(String batchNo) {
		return findOrderOpByOrderNo(null, batchNo);
	}

	@Override
	public boolean findOrderOpByOrderNo(String orderNo, String batchNo) {
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		List<String> list = new ArrayList<String>();
		list.add(WithholdOrderOpStatusEnum.ORDER_INIT.code);
		list.add(WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code);
		list.add(WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code);
		criteria.andStatusIn(list);
		if (StringUtils.isNotBlank(orderNo)) criteria.andMerchantOrderNoEqualTo(orderNo);
		if (StringUtils.isNotBlank(batchNo)) criteria.andBatchNoEqualTo(batchNo);
		List<TbWithholdingOrderInfoPO> orderList = extTbWithholdingOrderInfoDAO.getOrderListByOrderNo(example);
		if (orderList != null && orderList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public TbWithholdingOrderInfoPO findOrderInfoByTransNo(String transNo) {
		// TODO Auto-generated method stub
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo(WithholdOrderOpStatusEnum.ORDER_ABOLISH.code);
		criteria.andExtEqualTo(transNo);
		TbWithholdingOrderInfoPO po = extTbWithholdingOrderInfoDAO.getOrderInfoByOrderNo(example);
		return po;
	}

	@Override
	public int updateBrechByPrimaryKeySelective(TbWithholdingBrechInfoPO record) {
		return extTbWithholdingBrechInfoDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateOrderByPrimaryKeySelective(TbWithholdingOrderInfoPO record) {
		return extTbWithholdingOrderInfoDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public String findFailOrderByBatchNo(String batchNo) {
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(batchNo);
		criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_FAILL.code);

		List<TbWithholdingOrderInfoPO> orderList = extTbWithholdingOrderInfoDAO.selectByExample(example);// .getOrderListByOrderNo(example);
		if (orderList != null && orderList.size() > 0) {
			return String.valueOf(orderList.size());
		} else {
			return "0";
		}
	}

	@Override
	public List<TbWithholdingOrderInfoPO> findFailOrderListByBatchNo(String batchNo) {
		// TODO Auto-generated method stub
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(batchNo);
		List<String> listStatus = new ArrayList<String>();
		listStatus.add(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
		listStatus.add(WithholdOrderOpStatusEnum.ORDER_FAILL.code);
		criteria.andStatusIn(listStatus);

		List<TbWithholdingOrderInfoPO> orderList = extTbWithholdingOrderInfoDAO.selectByExample(example);
		if (orderList == null) {
			orderList = new ArrayList<TbWithholdingOrderInfoPO>();
		}
		return orderList;
	}

	@Override
	public String findSuccessOrderByBatchNo(String batchNo) {
		// TODO Auto-generated method stub
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(batchNo);
		criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_SUCCESS.code);

		List<TbWithholdingOrderInfoPO> orderList = extTbWithholdingOrderInfoDAO.getOrderListByOrderNo(example);
		if (orderList != null && orderList.size() > 0) {
			return String.valueOf(orderList.size());
		} else {
			return "0";
		}
	}

	@Override
	public String creditWithholdingOrderNo() {
		return extTbWithholdingOrderInfoDAO.creditWithholdOrderNo();
	}

	@Override
	public List<TbWithholdingOrderInfoPO> findInvokCallbackOrder() {
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code);

		List<TbWithholdingOrderInfoPO> orderList = extTbWithholdingOrderInfoDAO.getOrderListByOrderNo(example);
		return orderList;
	}

	@Override
	public boolean updateByExampleSelective(TbWithholdingOrderInfoPO record, TbWithholdingOrderInfoExample example) {
		int rows = extTbWithholdingOrderInfoDAO.updateByExampleSelective(record, example);
		if (rows > 0)
			return true;
		else return false;
	}

	// 根据批次号查询 状态处理中(没有明确状态，成功，失败，过期)的 order 数量
	public int selectOrderByBatchNo(String batchNo) {
		// if (StringUtils.isBlank(batchNo)) {
		// log.error("input batchNo is blank.");
		// return 0;
		// }
		TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
		TbWithholdingOrderInfoExample.Criteria criteria = example.createCriteria().andBatchNoEqualTo(batchNo);

		criteria.andStatusNotIn(Arrays.asList(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code, WithholdOrderOpStatusEnum.ORDER_SUCCESS.code,
				WithholdOrderOpStatusEnum.ORDER_FAILL.code, WithholdOrderOpStatusEnum.ORDER_TIMEOUT.code));
		return extTbWithholdingOrderInfoDAO.countByExample(example);
	}

	@Override
	public int updateTransInfo(TbWithholdingTransLogPO po) throws Exception {
		return  extTbWithholdingTransLogDAO.updateByPrimaryKeySelective(po);
	}

}
