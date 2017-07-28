package com.sdp.withdraw.service;

import java.util.List;

import com.sdp.mc.common.dto.WithdrawCoreServiceDTO;
import com.sdp.mc.integration.fos.dto.request.WithdrawT0RequestDTO;
import com.sdp.mc.integration.fos.dto.response.WithdrawBackOrderStatusDTO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDOExample;

/**

 */
public interface WithdrawReqFosDetailService {
	/**
	 * 构建出款调用对象
	 *
	 * @param serviceDTO
	 * @return
	 */
	WithdrawT0RequestDTO buildWithdrawT0RequestDTO(WithdrawCoreServiceDTO serviceDTO);

	/**
	 * 创建详细出款对象
	 *
	 * @param serviceDTO
	 * @return
	 */
	WithdrawReqFosDetailDO createDoByServiceDto(WithdrawCoreServiceDTO serviceDTO);

	/**
	 * 更新调用FOS详细数据的记录
	 * @param orderResultStr 订单出款状态 json
	 * @param status
	 */
	int updateDataForWaiting(Long detailId, String errorCode, String errorMessage, String status,String orderResultStr);

	/**
	 * 查询回掉超时的数据
	 *
	 * @param callbackTimeoutMinute
	 * @return
	 */
	List<WithdrawReqFosDetailDO> queryCallbackTimeoutData(int callbackTimeoutMinute);

	/**
	 * 通过支付业务订单号查询出款详细信息
	 * @param remitVoucherNo
	 * @return
	 */
	WithdrawReqFosDetailDO queryWithdrawReqFosDetailByRemitVoucherNo(String remitVoucherNo);
    /**
     * 更新数据
     * @param detailDo
     */
	void updateData(WithdrawReqFosDetailDO detailDo);
    /**
     * 通过出款纤细信息构建出款核心服务请求实体
     * @param detailDo
     * @return
     */
	WithdrawCoreServiceDTO getWithdrawCoreServiceDTOByDo(WithdrawReqFosDetailDO detailDo);
    /**
     * 更新数据
     * @param record
     * @param example
     * @return
     */
	int updateByExample(WithdrawReqFosDetailDO record, WithdrawReqFosDetailDOExample example);
    /**
     * 根据条件查询出款调用详细信息
     * @param example
     * @return
     */
	List<WithdrawReqFosDetailDO> selectByExample(WithdrawReqFosDetailDOExample example);
     /**
      * 查询最后一次调用FOS的详细信息
      * @param reqId
      * @return
      */
	WithdrawReqFosDetailDO queryLastDetailByReqId(Long reqId);
    /**
     * 更新数据
     * @param withdrawStatus
     * @param responseDto
     * @param withdrawReqFosDetail
     * @param withdrawReqDO
     * @return
     */
	int updateReqAndOrderDetailInfo(boolean withdrawStatus, WithdrawBackOrderStatusDTO responseDto, WithdrawReqFosDetailDO withdrawReqFosDetail,
			WithdrawReqDO withdrawReqDO);
    /**
     * 更新数据
     * @param withdrawReqFosDetail
     * @param withdrawReqDO
     * @param extention 存放出款订单json串
     */
	void updateReqAndOrderDetailInfoByWithdrawSuccess(WithdrawReqFosDetailDO withdrawReqFosDetail, WithdrawReqDO withdrawReqDO,String extention);

	void createWithdrawFailDetail(WithdrawCoreServiceDTO serviceDTO);

	WithdrawReqFosDetailDO getDetailDOById(Long detailId);

	List<WithdrawReqFosDetailDO> queryDetailInfoByReqId(Long reqId);

}
