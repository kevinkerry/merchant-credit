package com.sdp.mc.service.settle.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sdp.mc.ScSettleBaseService;
import com.sdp.mc.settle.api.dto.PromoterSettleOrderDTO;

/**
 * 下周结算单明细,后台操作
 */
public class DownloadOrderDetailThread implements Runnable {
	private Logger logger = LoggerFactory.getLogger(DownloadOrderDetailThread.class);

	private ScSettleBaseService scSettleBaseService;
	private String id;
	private String operatorId;
	private String operatorName;
	// private String promoterNo;
	boolean validate = false;

	// TODO:修改 baseService 传入方式
	public DownloadOrderDetailThread(String id, String operatorId, String operatorName, ScSettleBaseService scSettleBaseService) {
		this.id = id;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.scSettleBaseService = scSettleBaseService;
	}

	// TODO:修改 baseService 传入方式
	public DownloadOrderDetailThread(String id, String promoterNo, ScSettleBaseService scSettleBaseService) {
		this.operatorId = promoterNo;
		this.operatorName = promoterNo;
		this.scSettleBaseService = scSettleBaseService;
		validate = true;
	}

	// /**
	// * 下载结算单明细,前台代理商使用
	// *
	// * @param settleOrderDTO
	// * settleOrderId 必填,结算单ID operatorId 必填,代理商商户号 operatorName
	// * 必填,代理商名称
	// * @return
	// */
	// public PromoterSettleOrderDTO
	// summary2ExcelInfo4POSPromoter(PromoterSettleOrderDTO settleOrderDTO) {
	// return summary2ExcelInfo(settleOrderDTO, true);
	// }

	@Override
	public void run() {
		try {
			PromoterSettleOrderDTO settleOrderDTO = new PromoterSettleOrderDTO();
			settleOrderDTO.setOperatorId(operatorId);
			settleOrderDTO.setOperatorName(operatorName);
			settleOrderDTO.setSettleOrderId(id);
			PromoterSettleOrderDTO responseDto = null;
			if (!validate)
				responseDto = scSettleBaseService.getSettleOrderService().summary2ExcelInfo4Operator(settleOrderDTO);
			else responseDto = scSettleBaseService.getSettleOrderService().summary2ExcelInfo4POSPromoter(settleOrderDTO);
			logger.info("DownloadOrderDetailThread response msg {}", responseDto.getRespMsg());
		} catch (Exception e) {
			logger.error("DownloadOrderDetailThread system error:{},{}", new Object[] { e.getMessage(), e });
		}
	}
}