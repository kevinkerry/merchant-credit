package com.sdp.mc.service.settle.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.settle.api.dto.PromoterEasypaySettleOrderDTO;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;

public class DownloadEasypayOrderDetailThread implements Runnable {
	private Logger logger = LoggerFactory.getLogger(DownloadEasypayOrderDetailThread.class);
	
	private ScSettleBaseService scSettleBaseService;
	private String id;
	private String operatorId;
	private String operatorName;
	boolean validate = false;
	
	// TODO:修改 baseService 传入方式
	public DownloadEasypayOrderDetailThread(String id, String operatorId, String operatorName, ScSettleBaseService scSettleBaseService) {
		this.id = id;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.scSettleBaseService = scSettleBaseService;
	}
	
	// TODO:修改 baseService 传入方式
	public DownloadEasypayOrderDetailThread(String id, String promoterNo, ScSettleBaseService scSettleBaseService) {
		this.operatorId = promoterNo;
		this.operatorName = promoterNo;
		this.scSettleBaseService = scSettleBaseService;
		validate = true;
	}
	
	@Override
	public void run() {
		try {
			PromoterEasypaySettleOrderDTO settleOrderDTO = new PromoterEasypaySettleOrderDTO();
			settleOrderDTO.setOperatorId(operatorId);
			settleOrderDTO.setOperatorName(operatorName);
			settleOrderDTO.setSettleOrderId(id);
			PromoterEasypaySettleOrderDTO responseDto = null;
			if (!validate)
//				responseDto = scSettleBaseService.getSettleOrderService().summary2ExcelInfo4Operator(settleOrderDTO);
//			else responseDto = scSettleBaseService.getSettleOrderService().summary2ExcelInfo4POSPromoter(settleOrderDTO);
				responseDto = scSettleBaseService.getSettleOrderService().summary2EasypayExcelInfo4Operator(settleOrderDTO);
			else responseDto = scSettleBaseService.getSettleOrderService().summary2EasypayExcelInfo4POSPromoter(settleOrderDTO);
			logger.info("DownloadEasypayOrderDetailThread response msg {}", responseDto.getRespMsg());
		} catch (Exception e) {
			logger.error("DownloadEasypayOrderDetailThread system error:{},{}", new Object[] { e.getMessage(), e });
		}
	}
}
