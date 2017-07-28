package com.shengpay.debit.common.enums;

/**
 * 商户借款订单状态
 */
public enum MerchantDebitOrderStatusEnums {

    //借款部分
    INIT("0", "初始"),
    //BORROW_TRANSFERING("1", "借款转账中"),
    //BORROW_TRANSFER_SUCCESS("101", "借款转账成功"),
    //BORROW_TRANSFER_FAIL("-101", "借款转账失败"),
    PAYBACKING("1","还款中"),
    OVERDUEING("2","逾期中"),
    OVERDUEING_PAYBACK_SUCCESS("3","逾期还款成功"),
    NORMAL_PAYBACK_SUCCESS("4","正常还款成功"),
    LOAN_REVIEW("5","待放款"),
    LOANING("6","放款中"),
    LOAN_ERROR("7","放款失败"),
    LOAN_REVIEW_REFUSE("8","拒绝放款");

    //还款部分
    //PAYBACK_SUCCESS("102", "借款订单还款成功"),
    //PAYBACK_UNFREEZE_MERCHANT_ACCOUNT_FAIL("-102", "解冻商户账户出款服务失败"),
    //PAYBACK_UNFREEZE_PERSONAL_ACCOUNT_FAIL("-103", "解冻个人账户出款服务失败"),
    //PAYBACK_PRINCIPAL_FAIL("-104", "还本金失败"),
    //PAYBACK_OVERDUE_INTEREST_FAIL("-104", "还逾期滞纳金失败"),
    //PAYBACK_RECOVER_BORROW_MONEY_FAIL("-105", "恢复借款申请权限失败"),
    ;

    MerchantDebitOrderStatusEnums(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    private final String key;
    private final String desc;

    public String getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

    public static MerchantDebitOrderStatusEnums parse(String code) {
        for (MerchantDebitOrderStatusEnums temp : MerchantDebitOrderStatusEnums.values()) {
            if (temp.getKey().equals(code)) {
                return temp;
            }
        }
        return null;
    }

    public static String getDescByKey(String code) {
        for (MerchantDebitOrderStatusEnums temp : MerchantDebitOrderStatusEnums
                .values()) {
            if (temp.getKey().equals(code)) {
                return temp.getDesc();
            }
        }
        return "";
    }

}
