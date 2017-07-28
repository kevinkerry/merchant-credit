package com.sdp.mc.common.enums.withdraw;

public enum WithdrawServiceTypeEnums {

	/**
	 * 实时出款服务
	 */
	T0("T0",4, "T0出款","T0"),
	T1("T1",2, "T1出款","T1"),
	D1("D1",3, "D1出款","D1"),

	;
	public final String key;
	public final Integer code;
	public final String desc;
	public final String type;

	WithdrawServiceTypeEnums(String key,Integer code, String desc,String type) {
		this.key=key;
		this.code = code;
		this.desc = desc;
		this.type=type;
	}
	  public static WithdrawServiceTypeEnums getEnumByKey(Integer code) {
	        for (WithdrawServiceTypeEnums temp : WithdrawServiceTypeEnums.values()) {
	            if (temp.code.equals(code)) {
	                return temp;
	            }
	        }
	       return null;
	    }
}
