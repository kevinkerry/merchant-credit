package com.shengpay.mcl.btc.util;

/**
 *
 * <p>请求各字段限定</p>
 * @author tuwenjie
 * @version $Id: FieldConstraint.java, v 0.1 2012-3-7 下午01:26:56 tuwenjie Exp $
 */
public interface FieldConstraint {

    //字段非法信息描述
    public static String       INVALID_LEN_MSG         = "长度非法";
    public static String       NOT_PROVIDED_MSG        = "未提供";
    public static String       WRONG_FORMAT            = "格式错误";
    public static final String BATCH_NO_PATTERN_MSG    = "批次号必须为数字或字母";

    //回调地址的最大长度
    public static final int    MAX_LEN_CALLBACK_URL    = 256;

    //代扣文件路径的最大长度
    public static final int    MAX_LEN_FILE_PATH       = 128;

    //代扣文件摘要的最大长度
    public static final int    MAX_LEN_FILE_DIGEST     = 128;

    //商户号的最大长度
    public static final int    MAX_LEN_CUSTOMER_NO     = 32;

    //批次号的最大长度
    public static final int    MAX_LEN_BATCH_NO        = 32;

    //批次内的订单号最大长度
    public static final int    MAX_LEN_ORDER_NO        = 30;

    //商户退款流水号最大长度
    public static final int    MAX_LEN_REFUND_NO       = 30;

    //备注最大长度
    public static final int    MAX_LEN_MEMO            = 256;

    //金额整数位最大长度
    public static final int    MAX_LEN_AMOUNT_INTEGER  = 15;

    //金额小数位最大长度
    public static final int    MAX_LEN_AMOUNT_FRACTION = 2;

    //附言最大长度
    public static final int    MAX_LEN_POST_SCRIPT     = 64;

    //文件加密类型最大长度
    public static final int    MAX_LEN_FILE_SING_TYPE     = 3;

    //最小金额值
    public static final String MIN_AMOUNT              = "0.01";

    //批次号正则表达式[只能是数字或字母]
    public static final String BATCH_NO_PATTERN        = "[A-Za-z0-9]+$";

    public static final String AMOUNT_PATTERN          = "^(0(\\.\\d{0,2}+[0]*)?|([0-9]*)+(\\.\\d{1,2})+[0]*)$";
}
