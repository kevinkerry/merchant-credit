package com.withdraw.service.test;

import java.math.BigDecimal;

import com.sdp.mc.common.util.NumberUtils;

public class TestNumber {
	public static void main(String[] args) {
		System.out.println(NumberUtils.isNumber("1"));
		System.out.println(NumberUtils.isNumber("1."));
		System.out.println(NumberUtils.isNumber("0.5"));
		
		System.out.println(new BigDecimal("1."));
	}
}
