package com.sdp.withdraw.service.impl;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.drools.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.common.enums.withdraw.WithdrawOrderStatusEnums;
import com.sdp.mc.common.enums.withdraw.WithdrawReqStatusEnums;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.OrderResults;
import com.sdp.mc.integration.fos.dto.response.WithdrawBackOrderStatusDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.WithdrawReqFosDetailManager;
import com.sdp.withdraw.manager.WithdrawReqManager;
import com.sdp.withdraw.manager.ext.ExtWithdrawReqFosDetailManager;
import com.sdp.withdraw.service.BaseService;
import com.sdp.withdraw.service.WithdrawReqFosDetailService;
import com.sdp.withdraw.service.WithdrawReqService;
import com.shengpay.commons.springtools.util.JsonUtils;

@Service("WithdrawReqFosDetailService")
public class WithdrawReqFosDetailServiceImpl extends BaseService implements WithdrawReqFosDetailService {

	private Logger logger = LoggerFactory.getLogger(WithdrawReqFosDetailServiceImpl.class);
	@Autowired
	private WithdrawReqFosDetailManager withdrawReqFosDetailManager = null;

	@Autowired
	private ExtWithdrawReqFosDetailManager extWithdrawReqFosDetailManager = null;

	@Autowired
	private WithdrawReqManager withdrawReqManager;
	@Autowired
	private WithdrawReqService withdrawReqService;

	@Override
	public WithdrawT0RequestDTO buildWithdrawT0RequestDTO(WithdrawCoreServiceDTO serviceDTO) {
		WithdrawT0RequestDTO dto = beanMapper.map(serviceDTO, WithdrawT0RequestDTO.class);
		if (serviceDTO.getReqExtention() != null) {
			dto.setExtention(JSONObject.fromObject(serviceDTO.getReqExtention()).toString());
		}
		return dto;
	}

	@Override
	public WithdrawReqFosDetailDO createDoByServiceDto(WithdrawCoreServiceDTO serviceDTO) {
		WithdrawReqFosDetailDO detailDo = beanMapper.map(serviceDTO, WithdrawReqFosDetailDO.class);
		if (serviceDTO.getReqExtention() != null) {
			detailDo.setReqExtention(JSONObject.fromObject(serviceDTO.getReqExtention()).toString());
		}
		detailDo.setCreateTime(new Date());
		// 初始 状态为处理中，防止调用Fos超时，但是申请成功，并未到超时时间，fos发起了出款结果回掉
		detailDo.setWithdrawStatus(WithdrawOrderStatusEnums.WAITTING.code);
		Long id = withdrawReqFosDetailManager.insert(detailDo);
		withdrawReqService.updateReqLastDetailId(detailDo.getReqId(),id);
		detailDo.setDetailId(id);
		serviceDTO.setDetailId(id);
		return detailDo;
	}

	@Override
	public int updateDataForWaiting(Long detailId, String errorCode, String errorMessage, String status, String orderResultStr) {
		logger.info(String.format("WithdrawFailServiceImpl #withdrawFailDealWith: detailId:%d,errorCode: %s,errorMessage: %s", detailId, errorCode,
				errorMessage));
		if (detailId != null) {
			WithdrawReqFosDetailDO detailDo = new WithdrawReqFosDetailDO();
			WithdrawReqFosDetailDOExample example = new WithdrawReqFosDetailDOExample();
			example.createCriteria().andDetailIdEqualTo(detailId).andWithdrawStatusEqualTo(WithdrawOrderStatusEnums.WAITTING.code);
			detailDo.setReturnCode(errorCode);
			detailDo.setWithdrawStatus(status);
			detailDo.setReturnMsg(errorMessage);
			detailDo.setUpdateTime(new Date());
			if (!StringUtils.isEmpty(orderResultStr)) {
				detailDo.setExtention(orderResultStr);
			}
			int row=extWithdrawReqFosDetailManager.updateByExample(detailDo, example);
			if(row<1){
				logger.info("updateDataForWaiting fail  row <1 ,detailId:{},detailDo:{}",new Object[]{detailId,detailDo});
			}
			return row;
		}
		return 0;

	}

	@Override
	public List<WithdrawReqFosDetailDO> queryCallbackTimeoutData(int callbackTimeoutMinute) {
		List<WithdrawReqFosDetailDO> list = this.extWithdrawReqFosDetailManager.queryCallbackTimeoutData(callbackTimeoutMinute);
		return list;
	}

	@Override
	public WithdrawReqFosDetailDO queryWithdrawReqFosDetailByRemitVoucherNo(String remitVoucherNo) {
		if (StringUtils.isEmpty(remitVoucherNo)) { return null; }
		WithdrawReqFosDetailDOExample example = new WithdrawReqFosDetailDOExample();
		example.setRemitVoucherNo(remitVoucherNo);
		List<WithdrawReqFosDetailDO> list = this.withdrawReqFosDetailManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public void updateData(WithdrawReqFosDetailDO detailDo) {
		this.withdrawReqFosDetailManager.updateByPrimaryKeySelective(detailDo);
	}

	@Override
	public WithdrawCoreServiceDTO getWithdrawCoreServiceDTOByDo(WithdrawReqFosDetailDO detailDo) {
		return beanMapper.map(detailDo, WithdrawCoreServiceDTO.class);
	}

	@Override
	public int updateByExample(WithdrawReqFosDetailDO record, WithdrawReqFosDetailDOExample example) {
		// TODO Auto-generated method stub
		return extWithdrawReqFosDetailManager.updateByExample(record, example);
	}

	@Override
	public List<WithdrawReqFosDetailDO> selectByExample(WithdrawReqFosDetailDOExample example) {
		// TODO Auto-generated method stub
		return withdrawReqFosDetailManager.selectByExample(example);
	}

	@Override
	public WithdrawReqFosDetailDO queryLastDetailByReqId(Long reqId) {
		WithdrawReqFosDetailDOExample example = new WithdrawReqFosDetailDOExample();
		example.setReqId(reqId);
		example.setOrderByClause("DETAIL_ID DESC");
		List<WithdrawReqFosDetailDO> list = this.withdrawReqFosDetailManager.selectByExample(example);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}
	@Override
	public List<WithdrawReqFosDetailDO> queryDetailInfoByReqId(Long reqId) {
		WithdrawReqFosDetailDOExample example = new WithdrawReqFosDetailDOExample();
		example.setReqId(reqId);
		example.setOrderByClause("DETAIL_ID ASC");
		return this.withdrawReqFosDetailManager.selectByExample(example);
	}

	@Override
	@Transactional
	public int updateReqAndOrderDetailInfo(boolean withdrawStatus, WithdrawBackOrderStatusDTO responseDto, WithdrawReqFosDetailDO reqFosDetail,
			WithdrawReqDO reqDO) {
		OrderResults result = responseDto.getOrderResults().get(0);

		if (withdrawStatus) {
			reqFosDetail.setReturnCode(result.getReturnCode());
			reqFosDetail.setReturnMsg(result.getReturnMsg());
		} else {
			reqFosDetail.setReturnCode(WithdrawOrderStatusEnums.FAIL.code);
			reqFosDetail.setReturnMsg(result.getReturnMsg());
		}
		reqFosDetail.setUpdateTime(new Date());
		withdrawReqFosDetailManager.updateByPrimaryKey(reqFosDetail);// .updateByExample(fosDetailRecord,
																		// example);

		if (withdrawStatus) {
			reqDO.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
		} else {
			reqDO.setStatus(WithdrawReqStatusEnums.FAIL.code);
		}
		reqDO.setErrorCode(ReturnCodeEnums.getEnumsByCode(responseDto.getReturnCode()).code);
		reqDO.setErrorMsg(responseDto.getReturnMsg());
		reqDO.setUpdateTime(new Date());
		return withdrawReqManager.updateByPrimaryKey(reqDO);
	}

	@Override
	@Transactional
	public void updateReqAndOrderDetailInfoByWithdrawSuccess(WithdrawReqFosDetailDO reqFosDetail, WithdrawReqDO reqDO, String orderRseultStr) {
		reqFosDetail.setWithdrawStatus(WithdrawOrderStatusEnums.SUCCESS.code);
		reqFosDetail.setReturnCode(ReturnCodeEnums.FW_SUCCESS.code);
		reqFosDetail.setReturnMsg(ReturnCodeEnums.FW_SUCCESS.msg);
		reqFosDetail.setUpdateTime(new Date());
		reqFosDetail.setExtention(orderRseultStr);
		withdrawReqFosDetailManager.updateByPrimaryKey(reqFosDetail);

		reqDO.setStatus(WithdrawReqStatusEnums.SUCCESS.code);
		reqDO.setErrorCode(ReturnCodeEnums.FW_SUCCESS.code);
		reqDO.setErrorMsg(ReturnCodeEnums.FW_SUCCESS.msg);
		if (reqDO.getWithdrawTime() == null) {
			reqDO.setWithdrawTime(new Date());
		}
		reqDO.setUpdateTime(new Date());
		withdrawReqManager.updateByPrimaryKey(reqDO);

	}

	@Override
	public void createWithdrawFailDetail(WithdrawCoreServiceDTO serviceDTO) {
		WithdrawReqFosDetailDO detailDo = beanMapper.map(serviceDTO, WithdrawReqFosDetailDO.class);
		detailDo.setCreateTime(new Date());
		detailDo.setUpdateTime(new Date());
		detailDo.setWithdrawStatus(WithdrawOrderStatusEnums.FAIL.code);
		Long id = withdrawReqFosDetailManager.insert(detailDo);
		serviceDTO.setDetailId(id);
	}

	@Override
	public WithdrawReqFosDetailDO getDetailDOById(Long detailId) {
		return withdrawReqFosDetailManager.selectByPrimaryKey(detailId);
	}

}
