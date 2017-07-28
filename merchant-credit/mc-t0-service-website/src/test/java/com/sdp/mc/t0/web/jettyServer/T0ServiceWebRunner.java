package com.sdp.mc.t0.web.jettyServer;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;

public class T0ServiceWebRunner {
	private static Server server = new Server();

	public static void main(String[] args) throws Exception {
		QueuedThreadPool boundedThreadPool = new QueuedThreadPool();
		boundedThreadPool.setMaxThreads(5);
		server.setThreadPool(boundedThreadPool);

		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		server.addConnector(connector);

		WebAppContext context = new WebAppContext("src/main/webapp", "/mc-t0-service-website");
		context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		context.setConfigurationClasses(new String[] { "org.mortbay.jetty.webapp.WebInfConfiguration",
				"org.mortbay.jetty.plus.webapp.EnvConfiguration", "org.mortbay.jetty.plus.webapp.Configuration",
				"org.mortbay.jetty.webapp.JettyWebXmlConfiguration", "org.mortbay.jetty.webapp.TagLibConfiguration" });
		server.setHandler(context);
		server.setStopAtShutdown(true);
		server.setSendServerVersion(true);
		server.start();
		server.join();
	}

}
