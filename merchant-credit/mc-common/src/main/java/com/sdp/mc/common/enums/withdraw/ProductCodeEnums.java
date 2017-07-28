package com.sdp.mc.common.enums.withdraw;


public enum ProductCodeEnums {
	 /**
	  *
POS:

		新T0：30040004 3003

		老T0：30040004 3002（不用）

		委托付款：30040004 3001

		专业版提现：10030003 3001

		专业版付款：30040004 3001

		MPOS：

		新T0：10030003 3003

		老T0：10030003 3002（不用）

		客户端提现：10030003 3001（要改，T+1用10030003 3004，D+1用10030003 3005/含手续费）

		专业版提现：10030003 3001

		退费：30060010 2001
		
		
		云收银T0出款:

		 20030001	3001-出款
	     2101-退票
	     
	     2017-06-22
	     http://jira.shengpayqa.com/browse/FUND-85
	     1、调整T0清算协议：
		 （1）POS T0：
		 现：30040004-3003，改为：20030002-3001
		（2）MPOS T0：
		 现：10030003-3003，改为：20030003-3001

	  */

	T0_POS_Withdraw("20030002","3001","T0_POS_Withdraw"),
	T0_MPOS_Withdraw("20030003","3001","T0_MPOS_Withdraw"),
	T1_MPOS_Withdraw("10030003","3004","T1_MPOS_Withdraw"),
	D1_MPOS_Withdraw("10030003","3005","D1_MPOS_Withdraw"),
	T0_EAYSPAY_Withdraw("20030001","3001","T0_EAYSPAY_Withdraw");
	private String productCode;
	private String paymentCode;
	private String key;

	ProductCodeEnums(String productCode, String paymentCode, String key) {
		this.productCode = productCode;
		this.paymentCode = paymentCode;
		this.key=key;
	}

	public String getKey() {
		return key;
	}

//	public void setKey(String key) {
//		this.key = key;
//	}

	public String getProductCode() {
		return productCode;
	}

//	public void setProductCode(String productCode) {
//		this.productCode = productCode;
//	}



	public String getPaymentCode() {
		return paymentCode;
	}

//	public void setPaymentCode(String paymentCode) {
//		this.paymentCode = paymentCode;
//	}


    public static ProductCodeEnums getProduceInfoByKey(String key) {
        for (ProductCodeEnums temp : ProductCodeEnums.values()) {
            if (temp.getKey().equals(key)) {
                return temp;
            }
        }
       return null;
    }
}
