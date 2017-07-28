package com.sdp.debit.batch.util;

import java.util.Date;
import java.util.TimeZone;

import org.springframework.scheduling.support.CronSequenceGenerator;

public class TaskExpressionTimeUtil {


    public static Date nextDate(String expression, Date date){
        TimeZone china = TimeZone.getDefault();
        CronSequenceGenerator cronSequenceGenerator = new CronSequenceGenerator(expression,china);
        return cronSequenceGenerator .next(date);
    }

}
