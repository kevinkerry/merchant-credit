package com.sdp.withdraw.vo.wallet;

import java.io.Serializable;
import java.util.List;

public class WalletWithdrawQueryResponse implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 7975898501573711651L;
	private List<WalletWithdrawResult> withdrawResults;
	private Integer returnRows;
	
	
	public WalletWithdrawQueryResponse() {
		super();
	}

	public WalletWithdrawQueryResponse(List<WalletWithdrawResult> withdrawResults, Integer returnRows) {
		super();
		this.withdrawResults = withdrawResults;
		this.returnRows = returnRows;
	}

	

	public List<WalletWithdrawResult> getWithdrawResults() {
		return withdrawResults;
	}

	public void setWithdrawResults(List<WalletWithdrawResult> withdrawResults) {
		this.withdrawResults = withdrawResults;
	}

	public Integer getReturnRows() {
		return returnRows;
	}

	public void setReturnRows(Integer returnRows) {
		this.returnRows = returnRows;
	}

}
