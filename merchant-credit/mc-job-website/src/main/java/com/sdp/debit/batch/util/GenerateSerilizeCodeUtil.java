package com.sdp.debit.batch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateSerilizeCodeUtil {

    /**
     * 根据时间格式规则，产生批次号
     * @param experssion
     * @return
     */
    public static String generateDateExpressionSerilzeCode(String experssion) {
        Date now = new Date();
        Date nextExpressionDate = TaskExpressionTimeUtil.nextDate(experssion, now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateFormat = sdf.format(nextExpressionDate);
        return dateFormat;
    }

}
