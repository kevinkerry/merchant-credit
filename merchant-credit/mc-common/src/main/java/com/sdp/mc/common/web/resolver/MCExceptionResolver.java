package com.sdp.mc.common.web.resolver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.util.RequestUtil;

/**
 * 电影票异常处理类
 * 
 * @author yangjianhua
 * 
 */
public class MCExceptionResolver extends SimpleMappingExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(MCExceptionResolver.class);
	private static DateFormat ALERT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	protected String buildLogMessage(Exception ex, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append("时间：");
		sb.append(ALERT_DATE_FORMAT.format(new Date()));
		sb.append("\n");
		sb.append("rquestInfo:\t");
		sb.append("ClientIP:");
		sb.append(IPUtils.getClientIP(request));
		sb.append("\tServerIP:");
		try {
			sb.append(IPUtils.getServerIPsStr());
		} catch (SocketException e) {
			sb.append(e);
		}
		sb.append("\n");
		sb.append(RequestUtil.getFullRequestInfo(request));
		sb.append("exception:\n");
		sb.append("message:");
		sb.append(ex.getMessage());
		sb.append("\n");
		StringWriter writer = new StringWriter();
		logger.error("MCExceptionResolver.buildLogMessage.error", ex , new PrintWriter(writer));
		ex.printStackTrace(new PrintWriter(writer));
		sb.append(writer.getBuffer());
		sb.append("\n\n");
		if (logger.isDebugEnabled()) {
			logger.debug(sb.toString());
		}
		return sb.toString();
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.error(ex.getMessage(), ex);
		return super.doResolveException(request, response, handler, ex);
	}
}
