package com.sdp.mc.service.settle.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDplDTO;

/**
 * 导出结算单（导出汇总）,后台操作
 */
public class DownloadOrderCollectThread implements Runnable {

	private Logger logger = LoggerFactory.getLogger(DownloadOrderCollectThread.class);

	private PromoterSettleOrderDTO settleOrderDTO;
	private ScSettleBaseService scSettleBaseService;
	String id;
	String operatorId;
	String operatorName;

	public DownloadOrderCollectThread(PromoterSettleOrderDTO settleOrderDTO, String operatorId, String operatorName,
			ScSettleBaseService scSettleBaseService) {
		this.settleOrderDTO = settleOrderDTO;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.scSettleBaseService = scSettleBaseService;
	}

	@Override
	public void run() {
		try {
			settleOrderDTO.setOperatorId(operatorId);
			settleOrderDTO.setOperatorName(operatorName);
			PromoterSettleOrderDplDTO responseDto = scSettleBaseService.getSettleOrderService().exportSettleOrder(settleOrderDTO);
			logger.info("DownloadOrderCollectThread response msg {}", responseDto.getRespMsg());
		} catch (Exception e) {
			logger.error("DownloadOrderCollectThread system error:{},{}", new Object[] { e.getMessage(), e });
		}
	}
}