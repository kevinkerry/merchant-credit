/*
 * Copyright 2012 shengpay.com, Inc. All rights reserved.
 * shengpay.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * creator : fanmanrong
 * create time : 2012-8-6 下午1:34:30
 */
package com.sdp.mc.withdraw;

/**
 * 功能描述：提现返回
 * @author fanmanrong
 * time : 2012-8-6 下午1:34:30
 */
public interface WithdrawMapKey {
    //提现返回的时候,Map对象中key值
    public class WithdrawResponseKey {
        public static final String processTime = "processTime"; //
        public static final String orderNo = "orderNo"; //
        public static final String payStatus = "payStatus"; //
        public static final String userID = "userID"; //
    }
}
