/**
 * Shengpay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.sdp.mc.common.enums;

/**
 * 
 * @author sunzhi.tom
 * @version $Id: AccountStatus.java, v 0.1 2011-8-12 下午4:15:43 sunzhi.tom Exp $
 */
public enum AccountStatus {
    
    AccountStatusInActive(0, "AccountStatusInActive"),
    AccountStatusActive(1, "AccountStatusActive"),
    AccountStatusLock(2, "AccountStatusLock"),
    AccountStatusDeniedFundOut(3, "AccountStatusDeniedFundOut"),
    AccountStatusDeniedFundIn(4, "AccountStatusDeniedFundIn");
    
    /** 编码 */
    private final int    code;
    /** 信息 */
    private final String message;

    AccountStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static AccountStatus getByCode(long code) {
        for (AccountStatus _AccountStatus : AccountStatus.values()) {
            if (_AccountStatus.getCode() == code) {
                return _AccountStatus;
            }
        }
        return null;
    }

}
