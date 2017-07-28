package com.sdp.mc.test;

import java.math.BigDecimal;

public class TestBigdecmal {
	public static void main(String[] args) {
        System.out.println(new BigDecimal(28.76).multiply(new BigDecimal(0.0005)).setScale(2,BigDecimal.ROUND_UP));
        System.out.println(new BigDecimal(28.76).multiply(new BigDecimal(0.0005)).setScale(2,BigDecimal.ROUND_HALF_UP));
	}
}
