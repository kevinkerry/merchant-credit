package com.sdp.withdraw.vo;

import java.io.Serializable;
import java.util.List;

public class WithdrawQueryResponse implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 7975898501573711651L;
	private List<WithdrawResult> withdrawT0Results;
	private Integer returnRows;
	public List<WithdrawResult> getWithdrawT0Results() {
		return withdrawT0Results;
	}

	public void setWithdrawT0Results(List<WithdrawResult> withdrawT0Results) {
		this.withdrawT0Results = withdrawT0Results;
	}

	public Integer getReturnRows() {
		return returnRows;
	}

	public void setReturnRows(Integer returnRows) {
		this.returnRows = returnRows;
	}

}
