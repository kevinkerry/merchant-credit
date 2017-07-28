package com.sdp.mc.common.vo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 出款服务
 * @author liutao
 *
 */
public class WithdrawVO {
	private String appId;
	private String orderNo;
	private String memberId;
	private String merchantNo;
	private String mcType;
	private String withdrawType;
	private BigDecimal withdrawAmount;
	private String callbackAddress;
	private String signature;
	private Map<String, Object> extention;


}
