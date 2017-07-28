package com.shengpay.debit.dal.ext.dataobject;

import java.util.List;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;

public class TbWithholdingInfoDTO extends TbWithholdingBrechInfoPO{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//订单
	private List<TbWithholdingOrderInfoPO> tbWithholdingOrderInfoList;

	@SuppressWarnings("rawtypes")
	private ErrorMessageVO errorMessageVO;

	public List<TbWithholdingOrderInfoPO> getTbWithholdingOrderInfoList() {
		return tbWithholdingOrderInfoList;
	}

	public void setTbWithholdingOrderInfoList(
			List<TbWithholdingOrderInfoPO> tbWithholdingOrderInfoList) {
		this.tbWithholdingOrderInfoList = tbWithholdingOrderInfoList;
	}

	public ErrorMessageVO getErrorMessageVO() {
		return errorMessageVO;
	}

	public void setErrorMessageVO(ErrorMessageVO errorMessageVO) {
		this.errorMessageVO = errorMessageVO;
	}

}
