package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.util.List;

public class WithdrawProductResponse extends BaseResponse implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -1443592032225709253L;
	private List<WithdrawProductResult> withdrawProductList;
	public List<WithdrawProductResult> getWithdrawProductList() {
		return withdrawProductList;
	}
	public void setWithdrawProductList(List<WithdrawProductResult> withdrawProductList) {
		this.withdrawProductList = withdrawProductList;
	}
	public WithdrawProductResponse(String errorCode, String errorMsg, List<WithdrawProductResult> withdrawProductList) {
		super(errorCode, errorMsg);
		this.withdrawProductList = withdrawProductList;
	}
	public WithdrawProductResponse(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
		this.withdrawProductList =null;
	}
	
	


}
