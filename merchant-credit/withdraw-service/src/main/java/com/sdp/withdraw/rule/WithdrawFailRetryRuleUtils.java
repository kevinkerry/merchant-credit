package com.sdp.withdraw.rule;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.bean.RetryRulePO;
import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.service.impl.WithdrawCallQueueServiceImpl;
import com.snda.toolkit.common.util.StringUtil;

public class WithdrawFailRetryRuleUtils {
	private static final Map<String, RetryRulePO> rules = new HashMap<String, RetryRulePO>();
	private static Logger logger = LoggerFactory.getLogger(WithdrawCallQueueServiceImpl.class);
	static {
		logger.info("WithdrawFailRetryRuleUtils load config");
		try {
			loadConfig();
		} catch (Exception e) {
			logger.info("WithdrawFailRetryRuleUtils load config Error" ,e);
		}
		logger.info("WithdrawFailRetryRuleUtils load config success");
	}

	private static void loadConfig() throws Exception {
		// 导入xml文件，要注意xml文件的路径要正确
//		String s_xmlpath = "com/sdp/withdraw/rule/retryRules.xml";
//		InputStream in = ClassLoader.getSystemResourceAsStream(s_xmlpath);
		 InputStream in=null;
		/*
		 * 实例化一个DocumentBuildFactory，一个document构造器构建的工厂， 顾名思义，我想大家都能猜到它的作用了吧。
		 */
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			File file = new File(WithdrawConstant.WITHDRAW_RETRY_RULE_FILE);
			in=new FileInputStream(file);
			// 实例化一个DocumentBuilder，一个document构造器，用于生成Document文档
			db = dbf.newDocumentBuilder();
			// 通过构造器的parse()方法，将一个File对象生成相应的Document文档
			Document document = db.parse(in);
			// 根据字符串在document内查找相应的根，其返回值是一个节点链表
			NodeList nodeList = document.getElementsByTagName("rule");
			for (int j = 0; j < nodeList.getLength(); j++) {
				// 返回相应根内的子节点，其返回值也是个节点链表
				NodeList childList = nodeList.item(j).getChildNodes();
				String errorCode=null;
				String codeKey=null;
				String retryTimes=null;
				String timeInterval=null;
				String description=null;
				for (int i = 0; i < childList.getLength(); i++) {
					// 获取相应的根内的元素的名字
					String tagName = childList.item(i).getNodeName();
//					System.out.println(tagName + ":" + childList.item(i).getTextContent());
					if (tagName.equals("error_code")) {
						errorCode=childList.item(i).getTextContent();
					} else if (tagName.equals("code_key")) {
						codeKey=childList.item(i).getTextContent();
					} else if (tagName.equals("retry_times")) {
						retryTimes=childList.item(i).getTextContent();
					} else if (tagName.equals("time_interval")) {
						timeInterval=childList.item(i).getTextContent();
					} else if (tagName.equals("description")) {
						description=childList.item(i).getTextContent();
					} 
				}
				addRule(errorCode,codeKey,retryTimes,timeInterval,description);
			}
		} catch (Exception e) {
			logger.error("WithdrawFailRetryRuleUtils #loadConfig Exception"+e.getMessage(), e);
		} finally{
			if(in!=null){
				in.close();
			}
		}
	}

	private static void addRule(String errorCode, String codeKey, String retryTimes, String timeInterval, String description) {
		if(StringUtil.isEmpty(errorCode)){
			return;
		}
		if(StringUtil.isEmpty(retryTimes)||!StringUtil.isNum(retryTimes)||Integer.parseInt(retryTimes)<=0){
			return;
		}
		if(StringUtil.isEmpty(timeInterval)||!StringUtil.isNum(timeInterval)||Integer.parseInt(timeInterval)<=0){
			return;
		}
		rules.put(errorCode, new RetryRulePO(errorCode, codeKey, retryTimes, timeInterval, description));
		
		
	}
	
	public static RetryRulePO getRetryRule(String errorCode){
		return rules.get(errorCode);
	};

	public static Date getRetryDate(String errorCode,Integer retryTimes){
		RetryRulePO po=rules.get(errorCode);
		if(po!=null){
			if(po.getRetryTimes()>retryTimes){
				return DateUtil.addMinutes(new Date(), po.getTimeInterval());
			}
		}
		return null;
	};
	
	public static void outputEnumsRule(){
		 ReturnCodeEnums[] enums=ReturnCodeEnums.values(); StringBuffer
		 buff=new StringBuffer();
		 buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \n");
		 buff.append("<rules>  \n"); for(ReturnCodeEnums en:enums){
		 buff.append("<rule>  \n");
		 buff.append(" <error_code>"+en.code+"</error_code>  \n");
		 buff.append(" <code_key>"+en.desc+"</code_key>  \n");
		 buff.append(" <retry_times>0</retry_times>  \n");
		 buff.append("<time_interval>3</time_interval>  \n");
		 buff.append(" <description>"+en.msg+"</description>\n");
		 buff.append("</rule>  \n"); } buff.append("</rules>");
		 System.out.println(buff.toString());
	}
	
	public static void main(String[] args) {
		outputEnumsRule();
//		System.out.println(rules.get("01005"));
		 
	}

}
