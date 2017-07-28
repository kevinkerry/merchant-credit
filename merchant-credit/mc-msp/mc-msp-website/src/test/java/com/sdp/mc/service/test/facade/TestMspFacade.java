package com.sdp.mc.service.test.facade;

import java.net.MalformedURLException;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import com.caucho.hessian.client.HessianProxyFactory;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.pos.pcs.api.settle.StraightlySettle;
import com.shengpay.pos.pcs.api.settle.StraightlySettleResult;
import com.shengpay.pos.pcs.api.settle.ValidOrders;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleCfg;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleService;

public class TestMspFacade {
	private HessianProxyFactory factory;
	private HessianProxyFactory newT0factory;
	private StraightlySettle straightlySettle;
	private Long promoterId;
	private String merchantId;
	private String posMerchantId;
	private List<Long> ids;
	private StraightlyCfg straightlyCfg;
	private FastSettleCfg fastSettleCfg;
	private FastSettleService fastSettleService;

	@Before
	public void init() {
		String url = "http://10.132.97.134:8085/pcs_facade/hessian/straightlySettle";
		String newT0Url = "http://10.132.97.105:8083/pcs_t0_facade/hessian/fastSettle";
		factory = new HessianProxyFactory();
		newT0factory = new HessianProxyFactory();
		try {
			straightlySettle = (StraightlySettle) factory.create(StraightlySettle.class, url);
			fastSettleService = (FastSettleService) newT0factory.create(FastSettleService.class, newT0Url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// FastSettleService
		promoterId = 201110241000000340l;

		merchantId = "710839";
		posMerchantId = "820290057320007";
	}

	@Test
	public void testAllInterface() {
		if (merchantId != null && posMerchantId != null) {
			straightlyCfg = straightlySettle.getStraightlyCfg(merchantId, posMerchantId);
			System.out.println(ToStringBuilder.reflectionToString(straightlyCfg));
			FastSettleCfg fastSettleCfg = fastSettleService.getMerchantFastSettleCfg(merchantId, posMerchantId);
			System.out.println(ToStringBuilder.reflectionToString(fastSettleCfg));
		}
		System.out.println(ToStringBuilder.reflectionToString(straightlyCfg));
		straightlyCfg = null;
		System.out.println(ToStringBuilder.reflectionToString(straightlyCfg));
	}

	// @Test
	public void testStraightlySettleInterface() {
		if (promoterId != null) {
			straightlyCfg = straightlySettle.getPromoterStraightlyCfg(promoterId);
			System.out.println(ToStringBuilder.reflectionToString(straightlyCfg));
		}
		if (merchantId != null && posMerchantId != null) {
			straightlyCfg = straightlySettle.getStraightlyCfg(merchantId, posMerchantId);
			System.out.println(ToStringBuilder.reflectionToString(straightlyCfg));

			List<ValidOrders> list = straightlySettle.queryValidOrderList(merchantId, posMerchantId);
			for (ValidOrders validOrders : list) {
				System.out.println(ToStringBuilder.reflectionToString(validOrders));
			}
			if (merchantId != null && posMerchantId != null && ids != null && !ids.isEmpty()) {
				StraightlySettleResult straightlySettleResult = straightlySettle.straightlySettle(merchantId, posMerchantId, ids);
				System.out.println(ToStringBuilder.reflectionToString(straightlySettleResult));
			}
		}
	}

}
