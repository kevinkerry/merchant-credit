package com.sdp.withdraw.service;

import java.util.List;
import java.util.Map;

import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.withdraw.dao.WithdrawReqDO;
import com.sdp.withdraw.dao.WithdrawReqDOExample;
import com.sdp.withdraw.dao.WithdrawReqFosDetailDO;
import com.sdp.withdraw.vo.WithdrawResult;

/**
 */
public interface WithdrawReqService {
	/**
	 * 插入出款额度
	 * 
	 * @param request
	 * @return
	 */
	public WithdrawReqDO insertWithdrawReq(WithdrawReqDO reqdo) throws Exception;

	/**
	 * 根據oerderNO && appid 查詢
	 * 
	 * @param orderNo
	 * @param appid
	 * @return
	 */
	public List<WithdrawReqDO> queryWithdrawByOrderNoAndAppID(Map<String, Object> paramMap);

	/**
	 * 查询出款请求信息，通过请求的ID
	 * 
	 * @param reqId
	 * @return
	 */
	public WithdrawReqDO queryWithdrawReqByReqId(Long reqId);

	/**
	 * 更新请求对象
	 * 
	 * @param reqDo
	 */
	public void updateData(WithdrawReqDO reqDo);

	/**
	 * 更新请求对象
	 * 
	 * @param reqDo
	 */
	public Integer updateByPrimaryKeySelective(WithdrawReqDO reqDo);

	/**
	 * 更新数据
	 * 
	 * @param vo
	 */
	public int updateDataMessage(WithdrawReqDO reqdo, ErrorMessageVO<Object> vo);

	/**
	 * 发起回掉
	 * 
	 * @param reqDo
	 * @param remitVoucherNo
	 */
	public void initiateCallback(WithdrawReqDO reqDo, String remitVoucherNo);

	/**
	 * 发起回掉
	 * 
	 * @param reqId
	 * @param remitVoucherNo
	 */
	void initiateCallback(Long reqId, String remitVoucherNo);

	/**
	 * 根据条件查询出款信息
	 * 
	 * @param example
	 * @return
	 */
	List<WithdrawReqDO> selectByExample(WithdrawReqDOExample example);

	/**
	 * 更新数据
	 * 
	 * @param record
	 * @param example
	 * @return
	 */
	int updateByExample(WithdrawReqDO record, WithdrawReqDOExample example);

	// /**
	// * 查询出款分页列表
	// * @param record
	// * @return
	// */
	// List<WithdrawReqDO> withdrawInfoList(WithdrawReqDOExampleExt example);
	/**
	 * 后台重试放款更新状态，暂不考虑并发问题
	 */
	public int updateWithdrawReq(Long reqId, Integer status, Integer retryTimes) throws Exception;

	/**
	 * @param reqDo
	 * @param detailDo
	 * @return
	 */
	public WithdrawResult getWithdrawResult(WithdrawReqDO reqDo, WithdrawReqFosDetailDO detailDo);

	/**
	 * 更新请求数据为出款中
	 * 
	 * @param withdrawReqDO
	 */
	public void updateStatusWithdrawing(WithdrawReqDO withdrawReqDO);

	/**
	 * 处理已经存在的请求
	 * 
	 * @param reqDo
	 * @param request
	 * @return
	 */
	public ErrorMessageVO<Object> dealwithExistsWithdraw(WithdrawReqDO reqDo);

	public int updateStatus(WithdrawReqDO reqDo, Integer sourceStatus, Integer targetStatus);

	public StatisticsWithdrawInfoDTO statisticsPromoterMerchantWithdrawInfo(Long promoterId);

	int updateDataStatusFail(long reqId, String errorCode, String errorMessage);

	/**
	 * 查询状态不一致的
	 * 
	 * @param example
	 * @return
	 */
	List<WithdrawReqDO> queryStatusDisagreeInfo();

	List<StatisticsWithdrawInfoDTO> statisticsPromoterWithdrawInfo(Long promoterId);

	List<StatisticsWithdrawInfoDTO> statisticsMerchantWithdrawInfo(Long merchantBizId);

	public int updateReqLastDetailId(Long reqId, Long lastDetailId);

}
