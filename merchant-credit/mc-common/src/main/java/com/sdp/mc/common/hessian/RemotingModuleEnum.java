package com.sdp.mc.common.hessian;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import com.sdp.mc.common.util.MCAppVarPropsUtil;

public enum RemotingModuleEnum {

	/**
	 * hessian SUPPLY 模块 URL
	 */
	// LOTTERY_WEBSITE_MODULE("com.sdp.nfc.hessian.nfc.website.module","hessian 调用 刷机支付前台模块 URL"),
	/**
	 * 商户申请快速接口申请 - 交易系统接口
	 */
	STRAIGHTLY_SETTLE_MODULE("pcs.service_url", "商户申请快速接口申请 - 交易系统接口"),
	/**
	 * 快速结算配置修改接口 - operating系统
	 */
	OPERATING_SETTLE_MODULE("operating.api.service.url", "快速结算配置修改接口 - operating系统接口"),

	NEWT0_SETTLE_MODULE("newt0.service_url", "商户申请快速接口申请 - 新t0"),
	NEWT0_MPOS_FAST_SETTLE("mpos.fast.settle.url","MPOS快速结算URL"),
	T0_WITHDRAW_SERVICE_URL("t0.withdraw.service.url","T0出款服务URL"),
	NEWT0_DATA_SERVICE_MODULE("dc.report.url","数据组提供商户数据统计查询接口 - 新t0新t0"),
	/**
	 * "withdraw.ratio.service.url","出款服务费率接口"
	 */
	WITHDRAW_RATIO_SERVICE_URL("withdraw.ratio.service.url","出款服务费率接口"),
	
	POS_EXTERNAL_API_HESSION_URL("pos.external.api.hession.url","POS跨部门接口API"),
	;
	private static Logger log = LoggerFactory.getLogger(RemotingModuleEnum.class);

	private String key;
	private String name;
	private List<String> allUrls = new ArrayList<String>();

	private RemotingModuleEnum(String key, String name) {
		this.key = key;
		this.name = name;

		// 初始化所有URLs(考虑到多个URL的情况)
		for (StringTokenizer tokens = new StringTokenizer(MCAppVarPropsUtil.getStringProp(key), ","); tokens.hasMoreTokens();) {
			String url = tokens.nextToken().trim();
			if (!"".equals(url)) {
				allUrls.add(url);
			}
		}

	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public List<String> getAllUrls() {
		return this.allUrls;
	}

	public String getUniqueUrl() {
		if (this.allUrls.size() > 1) {
			log.warn("There are more than one url in the list!" + allUrls);
		}

		return this.allUrls.get(0);
	}
}
