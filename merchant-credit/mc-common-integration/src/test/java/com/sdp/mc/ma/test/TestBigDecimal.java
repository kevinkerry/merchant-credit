package com.sdp.mc.ma.test;

import java.math.BigDecimal;

import com.sdp.mc.common.constant.MerchantCreditConstant;

public class TestBigDecimal {

	
	public static void main(String[] args) {
		System.out.println(MerchantCreditConstant.MERCHANT_FAST_SETTLE_HOLIDAY_FEE.compareTo(new BigDecimal(0.0025)));
		System.out.println(MerchantCreditConstant.MERCHANT_FAST_SETTLE_HOLIDAY_FEE.compareTo(BigDecimal.valueOf(0.0025)));
		System.out.println(MerchantCreditConstant.MERCHANT_FAST_SETTLE_HOLIDAY_FEE.doubleValue());
	}
}
