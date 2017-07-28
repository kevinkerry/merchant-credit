package com.sdp.mc.common.enums;

public enum UserOperaRecordEnum {
    //邮件警报
        RTMARGIN(4,"退回保证金"),
        //手机短信警报
        LOAN(5,"天天贷放款");
        public final long code;

        public final String message;

        UserOperaRecordEnum(long code,String message ) {
            this.code = code;
            this.message = message;
        }

        public static UserOperaRecordEnum getByCode(long code) {
            for (UserOperaRecordEnum s : values()) {
                if (s.code == code) {
                    return s;
                }
            }
            return null;
        }

        public long getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

}
