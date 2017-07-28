package com.sdp.withdraw.enums;


public enum PosMerchantTypeEnums {
	// 商户类型
		// POS商户：0001；机具方：0002；转接方：0004；miniPOS商户：0005；mPOS商户：0006；
		// POS拓展商：0003；mPOS拓展商：0007；miniPOS拓展商：0008；SDK拓展商：0009；机具厂商：0010；
		/**
		 * POS商户：0001
		 */
		POS_MERCHANT("0001", "POS商户","POS"),
		/**
		 * mPOS商户：0006
		 */
		MPOS_MERCHANT("0006", "mPOS商户","MPOS"),
		/**
		 * 云收银商户：0201
		 */
		EASYPAY_MERCHANT("0201", "云收银商户","EASYPAY"),
		/**
		 * POS拓展商：0003
		 */
		POS_PROMOTER("0003", "POS拓展商","POS"),
		/**
		 * mPOS拓展商：0007
		 */
		MPOS_PROMOTER("0007", "mPOS拓展商","MPOS"),
		MPOS_SECOND_LEVEL_PROMOTER("9999", "mPOS二级拓展商","OTHER"),

		/**
		 * 云收银拓展商:0101
		 */
		EASYPAY_PROMOTER("0101", "云收银拓展商","EASYPAY"),
		;
		public final String code;
		public final String desc;
		public final String type;

		PosMerchantTypeEnums(String code, String desc,String type) {
			this.code = code;
			this.desc = desc;
			this.type = type;
		}

		public static PosMerchantTypeEnums getMerchantTypeByCode(String code) {
			PosMerchantTypeEnums merchantTypeEnums[] = PosMerchantTypeEnums.values();
			for (PosMerchantTypeEnums enums : merchantTypeEnums) {
				if (enums.code.equalsIgnoreCase(code)) return enums;
			}
			return null;
		}
}
