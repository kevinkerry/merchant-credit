//package com.sdp.test.mc.job;
//
//import static org.mockito.Mockito.when;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import org.junit.Before;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.util.Assert;
//
//import com.sdp.mc.batch.fastsettle.SdpFastSettleTask;
//import com.sdp.mc.facade.msp.MspFacade;
//import com.sdp.mc.fastsettle.thread.model.PrometerMerchantCalModel;
//import com.sdp.mc.fastsettle.thread.service.SdpFastSettleService;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
//import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
//import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
//import com.sdp.mc.integration.msp.MerchantInfoDTO;
//import com.sdp.mc.integration.msp.PromoterInfoDTO;
//import com.sdp.mc.merchant.dao.MerchantFsReq;
//import com.sdp.mc.merchant.manager.MerchantFsRManager;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
//import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
//
//public class TestSdpFastSettleService extends BaseTestCase {
//
//	@Autowired
//	private SdpFastSettleService sdpFastSettleService;
//
//	@Mock
//	private MspFacade spyMspFacade;
//
//	@Mock
//	private FastSettleConfigManager spyFastSettleConfigManager;
//
//	@Mock
//	private MerchantFsRManager spyMerchantFsRManager;
//
//	@Autowired
//	private FastSettleConfigManager fastSettleConfigManager;
//
//	@Autowired
//	private MspFacade mspFacade;
//
//	@Autowired
//	protected ExtNewt0SdpRemainBalanceManager extNewt0SdpRemainBalanceManager;
//
//	@Autowired
//	private SdpFastSettleTask sdpFastSettleTask;
//
//
////	@Before
//	public void initMocks() throws Exception {
//
//		sdpFastSettleTask.stopRunning();
//
//		MockitoAnnotations.initMocks(this);
//		ReflectionTestUtils.setField(
//				AopTargetUtils.getTarget(sdpFastSettleService), "mspFacade",
//				spyMspFacade);
//
//		List<FastSettleConfigDO> list = new ArrayList<FastSettleConfigDO>();
//		for (int i = 0; i < 5; i++) {
//			FastSettleConfigDO config = new FastSettleConfigDO();
//			config.setObjId(new Long(i));
//			list.add(config);
//			MerchantInfoDTO chantInfoDTO = new MerchantInfoDTO();
//			PromoterInfoDTO prometerInfoDTO = new PromoterInfoDTO();
//			if (i %2 == 0){
//				chantInfoDTO.setPromoterId(1000);
//				prometerInfoDTO.setPromoterId(1000);
//			} else{
//				chantInfoDTO.setPromoterId(1001);
//				prometerInfoDTO.setPromoterId(1001);
//			}
//			when(spyMspFacade.findMerchantInfoByMerchantId(new Long(i)))
//			.thenReturn(chantInfoDTO);
//			when(spyMspFacade.findPromoterInfoByPromoterId(1000 + new Long(i)))
//					.thenReturn(prometerInfoDTO);
//		}
//		when(
//				spyFastSettleConfigManager.selectByExample(Mockito
//						.any(FastSettleConfigDOExample.class)))
//				.thenReturn(list);
//
//		ReflectionTestUtils.setField(
//				AopTargetUtils.getTarget(sdpFastSettleService),
//				"fastSettleConfigManager", spyFastSettleConfigManager);
//	}
//
//	@Before
//	public void initFastSettleMocks() throws Exception {
//		sdpFastSettleTask.stopRunning();
//		MockitoAnnotations.initMocks(this);
//
//		ReflectionTestUtils.setField(
//				AopTargetUtils.getTarget(sdpFastSettleService), "mspFacade",
//				spyMerchantFsRManager);
//		when(spyMerchantFsRManager.insert(Mockito.any(MerchantFsReq.class))).thenReturn(12l);
//
//
//	}
//
//
//	// @After
//	public void clearMocks() throws Exception {
//		ReflectionTestUtils.setField(
//				AopTargetUtils.getTarget(sdpFastSettleService), "mspFacade",
//				mspFacade);
//	}
//
//	// @Test
//	public void testgetNowRemainBalance() throws ParseException {
//		makegetNowRemainBalanceDate();
//		Newt0SdpRemainBalanceDO newt0SdpRemainBalanceDO = sdpFastSettleService
//				.getNowRemainBalance();
//
//		Assert.notNull(newt0SdpRemainBalanceDO);
//
//		sdpFastSettleService.getNowRemainBalance();
//
//		Assert.notNull(newt0SdpRemainBalanceDO);
//		sdpFastSettleService.getNowRemainBalance();
//
//		Assert.notNull(newt0SdpRemainBalanceDO);
//		sdpFastSettleService.getNowRemainBalance();
//
//		Assert.notNull(newt0SdpRemainBalanceDO);
//		sdpFastSettleService.getNowRemainBalance();
//		Assert.notNull(newt0SdpRemainBalanceDO);
//
//	}
//
////	@Test
//	public void groupByPrometer() {
//		Map<Long, PrometerMerchantCalModel> map = sdpFastSettleService
//				.groupByPrometer();
//		for (Entry<Long, PrometerMerchantCalModel> entry : map.entrySet()) {
//			System.out.println(entry.getKey());
//		}
//		map = sdpFastSettleService.groupByPrometer();
//
//		map = sdpFastSettleService.groupByPrometer();
////		try {
////			Thread.sleep(30 * 1000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		map = sdpFastSettleService.groupByPrometer();
//
//		for (Entry<Long, PrometerMerchantCalModel> entry : map.entrySet()) {
//			System.out.println(entry.getKey());
//		}
//		map = sdpFastSettleService.groupByPrometer();
//
//	}
//
//	private void makegetNowRemainBalanceDate() throws ParseException {
//		Date now = new Date();
//		Newt0SdpRemainBalanceDO record = new Newt0SdpRemainBalanceDO();
//		record.setCreateTime(now);
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//		String startTimeStr = sf.format(now) + " 00:00:00";
//		String endTimeStr = sf.format(now) + " 23:59:59";
//
//		sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		record.setStartTime(sf.parse(startTimeStr));
//		record.setEndTime(sf.parse(endTimeStr));
//		record.setCanUseQuota(new BigDecimal(100000));
//		record.setFrozenQuota(new BigDecimal(0));
//		record.setQuota(new BigDecimal(100000));
//		record.setUpdateTime(new Date());
//		extNewt0SdpRemainBalanceManager.insert(record);
//	}
//
//}
