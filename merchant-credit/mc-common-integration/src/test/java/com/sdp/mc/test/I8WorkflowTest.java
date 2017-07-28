package com.sdp.mc.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdp.mc.common.util.MD5Digest;

public class I8WorkflowTest {
	private static final Logger logger = LoggerFactory.getLogger(I8WorkflowTest.class);
	private String accountID = "";
	private String sessionID = "";
	private String passport = "";
	private String _I8_AppID_ = "44acb964-d50a-4184-929c-c3969818914e";
	private String _I8_Sign_KEY = "9188f8e7-631b-4c81-89ce-6c164f780d1f";
//	private String host = "http://10.241.14.74:18001";
	 private String host = "http://10.241.14.243:18001";

	private static HttpClient httpclient = new DefaultHttpClient();

	@Before
	public void testJsonLogin() {
		String url = host + "/api/v1/Common/Login";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "liyantao01");
		map.put("password", "Morenpwd@154");
		String ticket = MD5Digest.getDigestString(_I8_AppID_ + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		String body = post(httpost, map);
		if (body != null) {
			JSONObject json = JSONObject.fromObject(body);
			JSONObject Session = json.getJSONObject("RetObject").getJSONObject("Session");
			System.out.println("===================" + Session.toString());
			accountID = Session.getString("AccountID");
			sessionID = Session.getString("ID");
			passport = Session.getString("PassportID");
		}
	}

	 @Test
	public void testGetProcInfo() {
		String url = host + "/api/v1/Process/GetProcInfo";
		Map<String, Object> map = new HashMap<String, Object>();
		 map.put("procFullName", "SDP考勤漏打卡申请");
		 map.put("version", 18);
//		/*map.put("procFullName", "test调整数据源用");
//		map.put("version", 6);*/
//		map.put("procFullName", "盛付通信贷审批流程");
//		map.put("version", 5);

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY);
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
			/*
			 * JSONObject json=JSONObject.fromObject(body); JSONObject
			 * Session=json.getJSONObject("RetObject").getJSONObject("Session");
			 * System.out.println("==================="+Session.toString());
			 * accountID = Session.getString("AccountID"); sessionID =
			 * Session.getString("ID"); passport =
			 * Session.getString("PassportID");
			 */
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testStartNewProc() {
		String url = host + "/api/v1/Process/StartProcess";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("procType", "0");
		map.put("procTitle", "WebAPI测试流程自动发起2");
		map.put("procFullName", "WebAPI接口流程");
		map.put("version", 2);
		map.put("jsonFormData",
				"[{\"ControlType\":\"userinfocomponent\",\"ControlID\":\"ShenQingRen\",\"ControlName\":\"%E7%94%B3%E8%AF%B7%E4%BA%BA\",\"ControlValue\":\"%5B%7B%22key%22%3A%22UserID%22%2C%22value%22%3A%2288666027-19aa-437f-8993-4d3c3af08e27%22%7D%2C%7B%22key%22%3A%22DepartmentID%22%2C%22value%22%3A%22%22%7D%5D\"},{\"ControlType\":\"select\",\"ControlID\":\"QingJiaLeiXing\",\"ControlName\":\"%E8%AF%B7%E5%81%87%E7%B1%BB%E5%9E%8B\",\"ControlValue\":\"%E7%97%85%E5%81%87\"},{\"ControlType\":\"subset\",\"ControlID\":\"JiLianZiChan\",\"ControlName\":\"%E7%BA%A7%E8%81%94%E8%B5%84%E4%BA%A7\",\"ControlValue\":\"%E5%9B%BA%E5%AE%9A%E8%B5%84%E4%BA%A7&split&2\"},{\"ControlType\":\"userKey\",\"ControlID\":\"RuZhiRenYuan\",\"ControlName\":\"%E5%85%A5%E8%81%8C%E4%BA%BA%E5%91%98\",\"ControlValue\":\"53faead0-a902-4b0d-99a0-c7d52cc62f52\"},{\"ControlType\":\"orgKey\",\"ControlID\":\"RuZhiBuMen\",\"ControlName\":\"%E5%85%A5%E8%81%8C%E9%83%A8%E9%97%A8\",\"ControlValue\":\"bb206112-fcaf-465f-91f2-349452bb9ff4\"},{\"ControlType\":\"grid\",\"ControlID\":\"ChuChaMingXi\",\"ControlName\":\"%E5%87%BA%E5%B7%AE%E6%98%8E%E7%BB%86\",\"ControlValue\":\"\",\"RowHeader\":[\""
						+ url_encode("出发地")
						+ "\",\""
						+ url_encode("目的地")
						+ "\",\""
						+ url_encode("交通工具")
						+ "\",\""
						+ url_encode("费用")
						+ "\",\""
						+ url_encode("出发时间")
						+ "\",\""
						+ url_encode("返回时间")
						+ "\"],\"RowItems\":[[\"%E4%B8%8A%E6%B5%B7\",\"%E5%8C%97%E4%BA%AC\",\"%E9%A3%9E%E6%9C%BA\",\"2000\",\"2014-09-26\",\"2014-09-26\"],[\"%E5%8C%97%E4%BA%AC\",\"%E7%BE%8E%E5%9B%BD\",\"%E9%A3%9E%E6%9C%BA\",\"300000\",\"2014-09-27\",\"2014-10-03\"]]},{\"ControlType\":\"VacationSummaryComponent\",\"ControlID\":\"YuanGongJiaQiXinXi\",\"ControlName\":\"%E5%91%98%E5%B7%A5%E5%81%87%E6%9C%9F%E4%BF%A1%E6%81%AF\",\"RowHeader\":[\"%E5%81%87%E6%9C%9F%E7%B1%BB%E5%9E%8B\",\"%E5%BC%80%E5%A7%8B%E6%97%B6%E9%97%B4\",\"%E7%BB%93%E6%9D%9F%E6%97%B6%E9%97%B4\",\"%E8%AF%B7%E5%81%87%E5%B0%8F%E6%97%B6%E6%95%B0\",\"%E5%A4%87%E6%B3%A8\"],\"RowItems\":[[\""
						+ url_encode("调休")
						+ "\",\"2014-09-26 15:53\",\"2014-09-26 15:53\",\"3\",\"\"],[\"shijia\",\"2014-09-26 15:54\",\"2014-09-26 15:54\",\"5\",\"\"]]},{\"ControlType\":\"text\",\"ControlID\":\"listSUMcol_4_FeiYong__\",\"ControlName\":\"%E8%B4%B9%E7%94%A8%E5%90%88%E8%AE%A1\",\"ControlValue\":\"302000.00\"}]");
		map.put("receiver", "45f69cda-105f-4ed3-bdc2-6de6ad6986fe,88666027-19aa-437f-8993-4d3c3af08e27");
		map.put("attatchments", null);
		map.put("approvers", null);
		map.put("referID", null);
		map.put("relationProcInstId", new Object[] { 2130001, 2100076 });
		map.put("agent", null);

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testStartNewProc2() {
		String url = host + "/api/v1/Process/StartProcess";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ApplyParttimeID", "");
		map.put("procRel", "");
		map.put("fileid", "");
		map.put("filedata", "");
		map.put("ProcTitle", "测试HTTPClient发起流程链接");
		map.put("Originator", "e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("OriginatorName", "李彦涛");
		map.put("ProcFullName", "test调整数据源用");
		map.put("Version", "6");
		map.put("ProcType", "IndependentDesign");
		map.put("Receiver", "0cd40125-b15e-4d47-b286-11fe681b9c75;e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("Approver", "");
		map.put("appid", "");
		map.put("refer", "");
		map.put("jsonFormData",
				"[{\"ControlType\":\"text\",\"ControlID\":\"XingMing\",\"ControlName\":\"%E5%A7%93%E5%90%8D\",\"ControlValue\":\"%E6%B0%B4%E6%B0%B4%E6%B0%B4%E6%B0%B4\"}]");
		// map.put("jsonFormData" ,
		// "[{\"ControlType\":\"text\",\"ControlID\":\"XingMing\",\"ControlName\":\"%E5%A7%93%E5%90%8D\",\"ControlValue\":\""+url_encode("<div><a href=\"http://www.shengpay.com\">盛付通</a></div>",
		// "utf-8")+"\"}]");

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testStartNewProc3() {
		String url = host + "/api/v1/Process/StartProcess";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("procRel", "");
		map.put("fileid", "");
		map.put("filedata", "");
		map.put("ProcTitle", "测试fdsgfsd自定义流程");
		map.put("Originator", "e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("OriginatorName", "李彦涛");
		map.put("ProcFullName", "自定义流程");
		map.put("Version", "1");
		map.put("ProcType", "PersonalSetActivity");
		map.put("Receiver", "0cd40125-b15e-4d47-b286-11fe681b9c75;e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("Approver", "0cd40125-b15e-4d47-b286-11fe681b9c75");
		map.put("appid", "");
		map.put("refer", "");
		// map.put("jsonFormData",url_encode("[{\"ControlType\":\"kdeditor\",\"ControlID\":\"textDetail\",\"ControlName\":\"详细内容\",\"ControlValue:\""+url_encode("<span>123123dsafasdfa</span>","utf-8")+"\"},{\"ControlType\":\"text\",\"ControlID\":\"textReason\",\"ControlName\":\"申请原因\",\"ControlValue\":\"的撒发的\"}]","utf-8"));
		// map.put("jsonFormData","[{\"ControlType\":\"kdeditor\",\"ControlID\":\"textDetail\",\"ControlName\":\"详细内容\",\"ControlValue:\""+url_encode("<span style=\"color:#99BB00;\"><u>1232131321</u></span><strong><span style=\"color:#99BB00;\"><u></u></span></strong>","utf-8")+"\"},{\"ControlType\":\"text\",\"ControlID\":\"textReason\",\"ControlName\":\"申请原因\",\"ControlValue\":\"的撒发的\"}]");
		// map.put("jsonFormData","[{\"ControlType\":\"kdeditor\",\"ControlID\":\"textDetail\",\"ControlName\":\"%E8%AF%A6%E7%BB%86%E5%86%85%E5%AE%B9\",\"ControlValue\":\""+url_encode("<span style=\"color:#99BB00;\"><u>1232131321</u></span><strong><span style=\"color:#99BB00;\"><u></u></span></strong>","utf-8")+"\"},{\"ControlType\":\"text\",\"ControlID\":\"textReason\",\"ControlName\":\"%E7%94%B3%E8%AF%B7%E5%8E%9F%E5%9B%A0\",\"ControlValue\":\"%E5%9C%B0%E6%96%B9%E4%B8%89%E4%BC%8F\"}]");
		map.put("jsonFormData",
				"[{\"ControlType\":\"kdeditor\",\"ControlID\":\"textDetail\",\"ControlName\":\"%E8%AF%A6%E7%BB%86%E5%86%85%E5%AE%B9\",\"ControlValue\":\""
						+ url_encode("<a href=\"http://www.baidu.com\" target=\"_blank\"> 123123123131</a>", "utf-8")
						+ "\"},{\"ControlType\":\"text\",\"ControlID\":\"textReason\",\"ControlName\":\"%E7%94%B3%E8%AF%B7%E5%8E%9F%E5%9B%A0\",\"ControlValue\":\"%E5%9C%B0%E6%96%B9%E4%B8%89%E4%BC%8F\"}]");

		System.out.println(url_decode(map.get("jsonFormData").toString(), "utf-8"));

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testStartNewProc4() {

		String url = host + "/api/v1/Process/StartProcess";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ApplyParttimeID", "");
		map.put("procRel", "");
		map.put("fileid", "");
		map.put("filedata", "");
		map.put("ProcTitle", "测试发起流程带有链接点击");
		map.put("Originator", "e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("OriginatorName", "李彦涛xvzcvz");
		map.put("ProcFullName", "SDP信息发布流程");
		map.put("Version", "23");
		map.put("ProcType", "IndependentDesign");
		map.put("Receiver", "");
		map.put("APPROVER", "0cd40125-b15e-4d47-b286-11fe681b9c75");
		map.put("appid", "");
		map.put("refer", "");
		map.put("jsonFormData",
				"[{\"ControlType\":\"text\",\"ControlID\":\"FaBuMuDe\",\"ControlName\":\"%E5%8F%91%E5%B8%83%E7%9B%AE%E7%9A%84\","
						+ "\"ControlValue\":\"%E7%9A%84%E6%92%92%E8%8C%83%E5%BE%B7%E8%90%A8%E8%8C%83%E5%BE%B7%E8%90%A8\"},"
						+ "{\"ControlType\":\"select\",\"ControlID\":\"FaBuFanWei\",\"ControlName\":\"%E5%8F%91%E5%B8%83%E8%8C%83%E5%9B%B4\",\"ControlValue\":\"SDP%E7%9B%9B%E4%BB%98%E9%80%9A\"},"
						+ "{\"ControlType\":\"select\",\"ControlID\":\"XinXiLeiBie\",\"ControlName\":\"%E4%BF%A1%E6%81%AF%E7%B1%BB%E5%88%AB\",\"ControlValue\":\"%E5%85%B6%E4%BB%96\"},"
						+ "{\"ControlType\":\"text\",\"ControlID\":\"XinXiBiaoTi\",\"ControlName\":\"%E4%BF%A1%E6%81%AF%E6%A0%87%E9%A2%98\",\"ControlValue\":\"%E7%9A%84%E6%92%92%E5%8F%91%E7%94%9F%E5%A4%A7%E5%8F%91%E6%96%AF%E8%92%82%E8%8A%AC\"},"
						+ "{\"ControlType\":\"text\",\"ControlID\":\"XinXiNaRong\",\"ControlName\":\"%E4%BF%A1%E6%81%AF%E5%86%85%E5%AE%B9\",\"ControlValue\":\""
						+ url_encode(
								"<div><a href=\"http://www.shengpay.com\" target=\"_blank\">打开盛付通官网</a><br/><a href=\"http://www.shengpay.com\" target=\"_blank\">打开盛付通官网</a></div>",
								"utf-8")
						+ "\"},"
						+ "{\"ControlType\":\"checkbox\",\"ControlID\":\"FaBuFangShi\",\"ControlName\":\"%E5%8F%91%E5%B8%83%E6%96%B9%E5%BC%8F\",\"ControlValue\":\"\"},"
						+ "{\"ControlType\":\"text\",\"ControlID\":\"XiWangFaBuShiJian\",\"ControlName\":\"%E5%B8%8C%E6%9C%9B%E5%8F%91%E5%B8%83%E6%97%B6%E9%97%B4\",\"ControlValue\":\"2016-12-09\"},"
						+ "{\"ControlType\":\"userKey\",\"ControlID\":\"SuoZaiBuMenZongJian\",\"ControlName\":\"%E6%89%80%E5%9C%A8%E9%83%A8%E9%97%A8%E6%80%BB%E7%9B%91\",\"ControlValue\":\"81a1c7fb-13fc-4eaa-8aad-584534bc49e8\"},"
						+ "{\"ControlType\":\"text\",\"ControlID\":\"ZhuYiShiXiang\",\"ControlName\":\"%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9\",\"ControlValue\":\"%E6%89%A7%E8%A1%8C%E5%89%8D%E8%AF%B7%E5%86%8D%E6%AC%A1%E7%A1%AE%E8%AE%A4%E4%BB%A5%E4%B8%8B%E4%BA%8B%E9%A1%B9%EF%BC%8C%E5%AE%8C%E6%88%90%E7%A1%AE%E8%AE%A4%E4%B9%8B%E5%90%8E%E8%AF%B7%E6%89%93%E5%8B%BE%E3%80%82%0A1.%E4%BF%A1%E6%81%AF%E6%A0%87%E9%A2%98%E5%92%8C%E5%86%85%E5%AE%B9%E9%83%BD%E6%AD%A3%E7%A1%AE%EF%BC%9B%0A2.%E5%B7%B2%E7%BB%8F%E5%88%A4%E6%96%AD%E4%BA%86%E6%98%AF%E5%90%A6%E5%8F%91%E9%80%81%E9%82%AE%E4%BB%B6%EF%BC%9B%0A3.%E5%A6%82%E6%9E%9C%E9%9C%80%E8%A6%81%E5%8F%91%E9%80%81%E9%82%AE%E4%BB%B6%EF%BC%8C%E5%B7%B2%E7%BB%8F%E7%A1%AE%E8%AE%A4%E4%BA%86%E9%82%AE%E4%BB%B6%E4%B8%AD%E9%9C%80%E8%A6%81%E5%8F%91%E9%80%81%E7%9A%84%E9%99%84%E4%BB%B6%E6%88%96%E6%98%AF%E4%B8%8D%E9%9C%80%E8%A6%81%E5%8F%91%E9%80%81%E7%9A%84%E9%99%84%E4%BB%B6%E3%80%82\"},"
						+ "{\"ControlType\":\"checkBox\",\"ControlID\":\"QingQueRen\",\"ControlName\":\"%E8%AF%B7%E7%A1%AE%E8%AE%A4\",\"ControlValue\":\"\"},{\"ControlType\":\"checkBox\",\"ControlID\":\"FaSongFuJianLieBiao\",\"ControlName\":\"%E5%8F%91%E9%80%81%E9%99%84%E4%BB%B6%E5%88%97%E8%A1%A8\",\"ControlValue\":\"\"},"
						+ "{\"ControlType\":\"radio\",\"ControlID\":\"ShiFuFaSongYouJian\",\"ControlName\":\"%E6%98%AF%E5%90%A6%E5%8F%91%E9%80%81%E9%82%AE%E4%BB%B6\",\"ControlValue\":\"\"}]");

		System.out.println(url_decode(map.get("jsonFormData").toString(), "utf-8"));

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}
	 @Test
	public void testStartNewProc5() {
		String con="测试信贷系统发起工作流，请忽视";
		String url = host + "/api/v1/Process/StartProcess";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ApplyParttimeID", "");
		map.put("procRel", "");
		map.put("fileid", "");
		map.put("filedata", "");
		map.put("ProcTitle", con);
		map.put("Originator", "e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a");
		map.put("OriginatorName", "李彦涛");
		map.put("ProcFullName", "盛付通信贷审批流程");
		map.put("Version", "5");
		map.put("ProcType", "IndependentDesign");
		map.put("Receiver", "68f3796b-9f82-4376-8503-3429241def7a;3da78a19-6446-428b-9e7f-a49ad4d093ff;286fe9d2-0aeb-4a7d-8bba-87d32d8f2ebd;0274f80c-6b07-4687-bf43-eb7701bc51d2;340d47ad-e63b-48b8-96c4-9ba97019e5d5;e77547c7-b9fe-4883-ba9d-14d5508e2224");
		map.put("APPROVER", "");
		map.put("appid", "");
		map.put("refer", "");
		String jsonFormData="[{\"ControlType\": \"text\","+
		        "\"ControlID\": \"XiangMuXiangXiNaRong\","+
		        "\"ControlName\": \"%E9%A1%B9%E7%9B%AE%E8%AF%A6%E7%BB%86%E5%86%85%E5%AE%B9\","+
		        "\"ControlValue\": \""+url_encode(con+"\n换行数据测试\n●换行数据测试\n◆换行数据测试\t\n■换行数据测试\n\n\n★换行数据测试") +"\"},"
		        + "{\"ControlType\": \"text\",\"ControlID\": \"ShenQingYuanYin\","+
		        "\"ControlName\": \"%E7%94%B3%E8%AF%B7%E5%8E%9F%E5%9B%A0\","+
		        "\"ControlValue\": \""+url_encode(con) +"\"}]";
		map.put("jsonFormData",jsonFormData);
		
		System.out.println(url_decode(map.get("jsonFormData").toString(), "utf-8"));
		
		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);
		
		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testCalculateNextActivity() {
		String url = host + "/api/v1/Activity/CalculateNextActivity";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ProcessName", "test调整数据源用");

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	@Test
	public void testGetProcInstContext() {
		String url = host + "/api/v1/ProcContext/GetProcInstContext";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("procInstID", 6209798);

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testGetProcTaskRecords() {
		String url = host + "/api/v1/Process/GetProcTaskRecords";
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("pageIndex" , 0);
		// map.put("pageSize" , 20);
		// map.put("sortField" , 1);
		// map.put("sort" , 0);
		// map.put("procFullName" , "test调整数据源用");

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testGetProcApplicationRecords() {
		String url = host + "/api/v1/Process/GetProcApplicationRecords";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageIndex", 1);
		map.put("pageSize", 20);
		map.put("sortField", 1);
		map.put("sort", 0);
		map.put("status", null);
		// map.put("procFullName" , "test调整数据源用");

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testAddTask() throws Exception {

		String url = host + "/api/v1/Task/AddTask";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginTime", "2016-11-25 09:19:14");
		map.put("endTime", "2016-11-26 09:19:14");
		map.put("owner", "1eaba03c-a8f7-4182-82fd-54a4b0b254fd");
		map.put("taskName", new String("AotoTestTask中文测试".getBytes(), "utf-8"));
		// map.put("taskName", url_encode("AotoTestTask中文测试"));
		// map.put("taskName", "AotoTestTask");
		map.put("description", "AotoTestTask");
		map.put("clientsource", null);

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testGetSystemBox() {
		String url = host + "/api/v1/VMail/GetSystemBox";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("PageIndex", "1");
		map.put("PageSize", "10");

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
		}
		httpclient.getConnectionManager().shutdown();
	}

	// @Test
	public void testGetPersonFullInfo() {
		String url = host + "/api/v1/PersonInfo/GetPersonFullInfo";
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("accountID", accountID);
		// map.put("PassportID", passport);

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + JSONObject.fromObject(map).toString() + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);

		String body = post(httpost, map);
		if (body != null) {
			// {"personInfo":{"PassportID":"e8ae1680-b1a0-43a0-a7e1-d48027eb1b1a","OrgID":"bd9dbf3e-12ed-4394-b7b9-d8223334e7af","OrgName":"SDP-资金管理研发部","Postion":null,"Type":0,"CompanyName":null,"Passport":"liyantao01@shengpay.com","Name":"李彦涛","NamePinyin":"liyantao","EmployeeNo":"032967","IDCard":null,"Division":null,"EntryTime":"2015-12-01 00:00:00","Tel":null,"Email":"liyantao01@shengpay.com","MPhone":"13761244331","LoginTime":"2016-12-07 15:41:48","OnlineMinutes":0,"LoginIP":"10.241.80.26","LoginCount":160,"LogoutUrl":null,"LogoutTime":"0001-01-01 00:00:00","LogoutIP":null,"HeadImage":"00000000-0000-0000-0000-000000000000.png","iCalendarQRCode":null,"LevelName":null,"Badge":"032967","ReportTo":"0cd40125-b15e-4d47-b286-11fe681b9c75","EmployeeType":"Norm","JobCode":"SDP001","JobName":"软件开发-SDP","ManaGrade":"100","ManaGradeName":"无","SpecGrade":"004","SpecGradeName":"资深","AdmiGrade":"YG","ID":"efc6c558-d738-4e0d-ad1a-919a3452fd57","AccountID":"5e06a3a2-d986-4f27-9c9b-b8e75338dd19","CreateTime":"2016-03-30 11:59:52","LastUpdateTime":"2016-12-07 15:41:48"},"RetCode":0,"Description":"","Sign":null,"ElapsedMS":190,"RetObject":null}
		}
		httpclient.getConnectionManager().shutdown();
	}

	@Test
	public void testFileProcessPost() throws ClientProtocolException, IOException {
		// //上传类型
		// typedef NS_ENUM(NSInteger, FileUploadType){
		// FileUploadTypeImage = 0,
		// FileUploadTypeDocument = 1,
		// FileUploadTypeHeaderIcon = 2,
		// };
		String uuid = UUID.randomUUID().toString();
		String url = host + "/api/v1/FileProcess/Post?uploadType=0&fileID=" + uuid.toLowerCase();
		System.out.println(url);
		Map<String, Object> map = new HashMap<String, Object>();

		String ticket = MD5Digest.getDigestString(_I8_AppID_ + sessionID + accountID + "" + _I8_Sign_KEY, "utf-8");
		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("I8-AppID", _I8_AppID_);
		httpost.setHeader("I8-Sign", ticket);
		httpost.setHeader("I8-AccessToken", sessionID);
		httpost.setHeader("I8-AccountID", accountID);
		String filePath = "D:\\capture.png";
		File file = new File(filePath);
		FileBody bin = new FileBody(file);
		// uploadFile对应服务端类的同名属性<File类型>
		// uploadFileName对应服务端类的同名属性<String类型>
		HttpEntity reqEntity = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE).addPart("uploadFile", bin)
				.setCharset(CharsetUtils.get("UTF-8")).build();
		httpost.setEntity(reqEntity);

		HttpResponse response = httpclient.execute(httpost);
		System.out.println(ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
		System.out.println(paseResponse(response));
		httpclient.getConnectionManager().shutdown();
	}

	public static String post(HttpPost httpost, Map<String, Object> params) {

		String body = null;

		postJSON(httpost, params);

		body = invoke(httpclient, httpost);

		return body;
	}

	private static String invoke(HttpClient httpclient, HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);

		return body;
	}

	private static String paseResponse(HttpResponse response) {
		logger.info("get response from http server..");
		HttpEntity entity = response.getEntity();

		logger.info("response status: " + response.getStatusLine());
		String charset = EntityUtils.getContentCharSet(entity);
		logger.info(charset);

		String body = null;
		try {
			body = EntityUtils.toString(entity);
			logger.info(body);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		return body;
	}

	private static HttpResponse sendRequest(HttpClient httpclient, HttpUriRequest httpost) {
		logger.info("execute post...");
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return response;
	}

	private static HttpPost postJSON(HttpPost httpost, Map<String, Object> params) {
		StringEntity s;
		try {
			s = new StringEntity(JSONObject.fromObject(params).toString(), "UTF-8");
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			httpost.setEntity(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpost;
	}

	/**
	 * 对字符串作按照UTF－8格式作常规的URL编码
	 * 
	 * @param str
	 *            字符串
	 * @return 编码后的字符串
	 */
	public static String url_encode(String str) {
		return str;
		// return url_encode(str, "UTF-8");
	}

	/**
	 * 对字符串作按照指定格式作常规的URL编码
	 * 
	 * @param str
	 *            字符串
	 * @return 编码后的字符串
	 */
	public static String url_encode(String str, String encoding) {
		if (str == null || str.equals("")) return "";
		try {
			String url_encode = URLEncoder.encode(str, encoding);
			System.out.println(url_encode);
			return url_encode;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return str;
		}
	}

	public static String url_decode(String str, String encoding) {
		if (str == null || str.equals("")) return "";
		try {
			String url_encode = URLDecoder.decode(str, encoding);
			System.out.println(url_encode);
			return url_encode;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return str;
		}
	}

	public static void main(String[] args) {
		String ff = url_decode(
				url_decode(
						"%5B%7B%22ControlType%22%3A%22kdeditor%22%2C%22ControlID%22%3A%22textDetail%22%2C%22ControlName%22%3A%22%25E8%25AF%25A6%25E7%25BB%2586%25E5%2586%2585%25E5%25AE%25B9%22%2C%22ControlValue%22%3A%22%253Cspan%2520style%253D%2522color%253A%252399BB00%253B%2522%253E%253Cu%253E1232131321%253C%252Fu%253E%253C%252Fspan%253E%253Cstrong%253E%253Cspan%2520style%253D%2522color%253A%252399BB00%253B%2522%253E%253Cu%253E%253C%252Fu%253E%253C%252Fspan%253E%253C%252Fstrong%253E%22%7D%2C%7B%22ControlType%22%3A%22text%22%2C%22ControlID%22%3A%22textReason%22%2C%22ControlName%22%3A%22%25E7%2594%25B3%25E8%25AF%25B7%25E5%258E%259F%25E5%259B%25A0%22%2C%22ControlValue%22%3A%22%25E7%259A%2584%25E8%25AF%25B4%25E6%25B3%2595%25E5%25A4%25A7%22%7D%5D",
						"utf-8"), "utf-8");
		System.out.println(ff);
	}
}
