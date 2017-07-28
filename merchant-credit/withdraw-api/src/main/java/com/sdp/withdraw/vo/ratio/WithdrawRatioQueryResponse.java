package com.sdp.withdraw.vo.ratio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sdp.withdraw.vo.BaseResponse;

public class WithdrawRatioQueryResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8458392767520673464L;

	private List<WithdrawRatioResult> withdrawRatioResults = new ArrayList<WithdrawRatioResult>();
	private Integer returnRows;

	public List<WithdrawRatioResult> getWithdrawRatioResults() {
		return withdrawRatioResults;
	}

	public void setWithdrawRatioResults(List<WithdrawRatioResult> withdrawRatioResults) {
		this.withdrawRatioResults = withdrawRatioResults;
	}

	public Integer getReturnRows() {
		return returnRows;
	}

	public void setReturnRows(Integer returnRows) {
		this.returnRows = returnRows;
	}

}
