package com.shengpay.debit.merchant.account.enums;

/**
 * 资产负债状态
 * @author heyi.alex
 *
 */
public enum DebitAccountEnums {


    ACCOUNT_CAN_USE("100", "正常可使用的状态"),
    DEBIT_OVER_DUE("992","逾期")
    ;

    DebitAccountEnums(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    private String key;
    private String desc;

    public String getKey() {
		return key;
	}

//	public void setKey(String key) {
//		this.key = key;
//	}

	public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }



}
