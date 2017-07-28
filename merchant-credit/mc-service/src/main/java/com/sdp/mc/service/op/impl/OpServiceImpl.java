package com.sdp.mc.service.op.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.service.op.OpService;
import com.sdp.mc.service.op.state.OpContext;
import com.sdp.mc.service.op.state.OpState;
import com.sdp.mc.service.op.state.OpStateFactory;
import com.sdp.mc.service.op.state.OpStateResponse;

@Service("OpService")
public class OpServiceImpl implements OpService {

	private OpState opState;
	@Autowired
	private OpStateFactory factory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sdp.mc.service.op.impl.OpService#handler(com.sdp.mc.service.op.state
	 * .OpContext, int)
	 */

	@Override
	public OpStateResponse handler(OpContext context, int code,String operatorId) {
		// TODO:根据返回状态code，判断是否继续处理，比如“中”或者最终完成状态;factory 返回
		// null，说明该状态不用处理则按照业务逻辑返回
		opState = factory.generate(context, code);
		if (opState == null) { return context.getOpStateResponse(); }
		code = opState.handler(context,operatorId);
		return handler(context, code,operatorId);
	}

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date t = new Date();
		System.out.println(format.format(t));
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(t);
		calendar.add(Calendar.DATE, 2);// 周日 1，周六2

		t = calendar.getTime();
		System.out.println(format.format(t));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
	}
}