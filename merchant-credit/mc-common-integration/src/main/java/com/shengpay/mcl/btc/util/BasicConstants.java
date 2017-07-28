package com.shengpay.mcl.btc.util;

import com.sdo.common.util.money.Money;

/**
 *
 * <p>基础常量容器</p>
 * @author tuwenjie
 * @version $Id: MTCConstants.java, v 0.1 2012-3-7 下午01:26:56 tuwenjie Exp $
 */
public interface BasicConstants {
    /** 编码 */
    public static final String ENCODE                             = "UTF-8";
    /** WEB编码 */
    public static final String WEB_ENCODE                         = "ISO-8859-1";
    /** 文件编码 */
    public static final String FILE_ENCODE                        = "GBK";

    /** 成功字符串标识 */
    public static final String TRUE_STRING                        = "Y";
    /** 失败字符串标识 */
    public static final String FALSE_STRING                       = "N";

    /** 零金额 */
    public static final Money  ZeroMoney                          = new Money(0.0);

    /** 后台任务触发监听器名称 */
    public static final String DAEMON_TRIGGER_LISTENER            = "daemonTriggerListener";
    /** 后台任务触发器名称前缀 */
    public static final String DAEMON_TRIGGER_NAME_PREFIX         = "DAEMON_";
    /** 未知主机信息 */
    public static final String UNKNOW_HOST                        = "UNKNOW_HOST";

    /** 批次明细每次加载数量 */
    public static final int    ITEM_LOAD_ROW_LIMIT                = 100;

    /** 数据库memo字段的长度定义，如果超长，在保存到数据库时需要截取 */
    public static final int    MEMO_LENGTH                        = 200;

    /** MAS回调URL：退款结果通知*/
    public static final String MAS_CALLBACK_URL_REFUND_RESULT     = "/masCallback/receiveRefundResult.htm";

    /** MAS回调URL：银行卡订单结果通知*/
    public static final String MAS_CALLBACK_URL_BANK_ORDER_RESULT = "/masCallback/receiveBankOrderResult.htm";

}
