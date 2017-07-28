package com.shengpay.debit.dal.ext.dataobject;

import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;

public class LoanDebitOrderDTO extends DoMerchantDebitOrderPO{

    /**
     * 序列化
     */
    private static final long serialVersionUID = -2645940360909235045L;

    //放款人
    private String realName;
    
    private String lendLoginName;
    
    /**
     * VARCHAR(64)<br>
     * 商户memberId
     */
    private String lendMemberId;
    
    /**
     * 借款账户实名
     */
    private String realLendLoginName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

	public String getLendLoginName() {
		return lendLoginName;
	}

	public void setLendLoginName(String lendLoginName) {
		this.lendLoginName = lendLoginName;
	}


	public String getLendMemberId() {
		return lendMemberId;
	}

	public void setLendMemberId(String lendMemberId) {
		this.lendMemberId = lendMemberId;
	}

	public String getRealLendLoginName() {
		return realLendLoginName;
	}

	public void setRealLendLoginName(String realLendLoginName) {
		this.realLendLoginName = realLendLoginName;
	}



}
