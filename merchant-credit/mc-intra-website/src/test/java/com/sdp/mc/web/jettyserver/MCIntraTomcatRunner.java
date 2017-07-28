package com.sdp.mc.web.jettyserver;

import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Embedded;



public class MCIntraTomcatRunner {
	public static void main(String[] args) throws Exception {
        Embedded tomcat = new Embedded();
        String baseDir = new File(".").getAbsolutePath();
        // tomcat home自己新建一个，里面就只建一个webapps空目录
        // 数据源配在context.xml里，可以从普通tomcat里拷贝过来
        // 放一个默认的web.xml,从普通tomcat里拷贝过来
        tomcat.setCatalinaHome(baseDir + "/src/test/resources/tomcat-home");
        Engine engine = tomcat.createEngine();
        engine.setName("Catalina");
        // webapps建个空目录就可以
        Host host = tomcat.createHost("localhost", tomcat.getCatalinaHome() + "/webapps");
        host.setAutoDeploy(false);
        engine.addChild(host);
        engine.setDefaultHost(host.getName());
        // 要在tomcat里启动的应用
        Context ctxtRoot = tomcat.createContext("/mc-intra", baseDir + "/src/main/webapp");
        host.addChild(ctxtRoot);
        tomcat.addEngine(engine);
        // http
        Connector httpConnector = tomcat.createConnector((String)null, 8081, false);
        tomcat.addConnector(httpConnector);
//        // https
//        Connector httpsConnector = tomcat.createConnector((String)null, 443, true);
//        httpsConnector.setProperty("keystoreFile", baseDir + "/src/test/resources/.keystore");
//        httpsConnector.setProperty("keystorePass", "111111");
//        tomcat.addConnector(httpsConnector);
        tomcat.start();
    }

}
