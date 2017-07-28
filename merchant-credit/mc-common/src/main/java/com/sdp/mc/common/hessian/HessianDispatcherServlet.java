package com.sdp.mc.common.hessian;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 如果有任何对代码的修改,请按下面的格式注明修改的内容. 序号 时间 作者 修改内容 1. 2008-12-3 马仁配 created this
 * class.
 */
public class HessianDispatcherServlet extends HttpServlet {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -7625335213634856414L;

	/**
	 * 获得注册的要发布成为hessian service的服务.
	 */
	@Autowired
	private IHessianServiceManager serviceManager;

	/**
	 * 不用每次去创建patter.
	 */
	private Pattern pattern = Pattern.compile("(.+)");

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.initSpringContext();
	}

	/**
	 * 初始化spring配置文件
	 *
	 * @param springConfig
	 */
	private void initSpringContext() {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());
		//初始化放在ServletContextLoader中
		//DefaultBeanFactory.setSpringApplicationContext(ctx);

		serviceManager = (IHessianServiceManager) ctx
				.getBean("hessianServiceManager");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		throw new ServletException("only support post method.");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			invokeService(resp, req);
		} catch (Exception e) {
			// 注意,bean运行过程中的异常并不是通过此处抛出的
			// 而是通过remoting机制传递到客户端再抛出的
			// 此处抛出的是非bean的异常
			// 由于这里的异常不会抛出到客户端，因此把异常打印出来，方便开发调试
			// 使用log4j把异常打印出来是一种好习惯！
			// LoggerUtil.error(e);
			throw new ServletException(e);
		}
	}

	/**
	 *
	 * @param response
	 * @param request
	 * @throws ServletException
	 */
	protected void invokeService(final HttpServletResponse response,
			final HttpServletRequest request) throws ServletException {
		String requestPath = request.getParameter("id");
		String serviceId = getServiceId(requestPath);
		invokeBean(request, response, serviceId);
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @param serviceId
	 * @throws ServletException
	 */
	protected void invokeBean(final HttpServletRequest request,
			final HttpServletResponse response, final String serviceId)
			throws ServletException {
		// 因为所有的服务都是无状态的服务，所以此处的_service无须进行同步，
		// 可以同时为多个调用服务
		HessianServiceExporter exporter = findHttpInvokerServiceExporter(serviceId);
		if (null == exporter) {
			// LoggerUtil.error("Hessian service not found:" + serviceId);
			throw new ServletException(
					"Can not find http invoke service object.");
		}
		try {
			exporter.handleRequest(request, response);
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * 从缓存中查找是否已经创建了与参数serviceId对应的HttpInvokerServiceExporter.
	 * 如果已经创建了就直接返回创建的对象,否则就新创建一个HttpInvokerServiceExporter,并返回.
	 *
	 * @param serviceId
	 *            String
	 * @return HttpInvokerServiceExporter
	 */
	protected HessianServiceExporter findHttpInvokerServiceExporter(
			final String serviceId) {
		HessianServiceExporter exporter = serviceManager.findService(serviceId);
		return exporter;
	}

	/**
	 * 用正则表达式将Path中的服务id提取出来，比如“/com.cownew.demo.IService”
	 * 将“com.cownew.demo.IService”解析出来
	 *
	 * @param requestPath
	 * @return
	 */
	protected String getServiceId(final String requestPath) {
		Matcher match = pattern.matcher(requestPath);
		match.matches();
		match.group();
		String serviceId = match.group(1);
		return serviceId;
	}
}
