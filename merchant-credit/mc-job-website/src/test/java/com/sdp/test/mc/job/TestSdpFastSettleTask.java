//package com.sdp.test.mc.job;
//
//import static org.mockito.Mockito.when;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
//import com.sdp.mc.facade.msp.MspFacade;
//import com.sdp.mc.fastsettle.thread.service.FastSettleSessionThreadUtil;
//import com.sdp.mc.fastsettle.thread.service.SdpFastSettleService;
//import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
//import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
//
//public class TestSdpFastSettleTask extends BaseTestCase{
//
//
//	@Mock
//	private MspFacade spyMspFacade;
//
//	@Autowired
//	private MspFacade mspFacade;
//
//	@Mock
//	private SdpFastSettleService spySdpFastSettleService;
//
//	@Autowired
//	private SdpFastSettleService sdpFastSettleService;
//
//	@Autowired
//	private FastSettleSessionThreadUtil fastSettleSessionThreadUtil;
//
//	@Before
//	public void initMocks() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		ReflectionTestUtils.setField(
//				AopTargetUtils.getTarget(fastSettleSessionThreadUtil), "sDPFastSettleService",
//				spySdpFastSettleService);
//		StraightlyCfg cfg = new StraightlyCfg();
//		cfg.setValidCredit(new BigDecimal(1000));
//		Newt0SdpRemainBalanceDO newdo = new Newt0SdpRemainBalanceDO();
//		newdo.setCanUseQuota(new BigDecimal(10000));
//		when(spySdpFastSettleService.getNowRemainBalance()).thenReturn(newdo);
//		when(spySdpFastSettleService.queryMerchantCreditByMerchantId(Mockito.anyString())).thenReturn(cfg);
//		when(spySdpFastSettleService.queryPromoterCreditByPrometerId(Mockito.anyLong())).thenReturn(cfg);
//
//		List<McSettFastTxnRO> ros = new ArrayList<McSettFastTxnRO>();
//		for (int i = 0; i < 10; i++){
//			McSettFastTxnRO ro = new McSettFastTxnRO();
//			ro.setAmt(new BigDecimal(10));
//			ro.setOrigTxnNo(new Long(i));
//			ros.add(ro);
//		}
//		when(spySdpFastSettleService.queryTxnByMerchantNo(Mockito.anyString())).thenReturn(ros);
//
//		when(spySdpFastSettleService.updateFrozen(Mockito.anyLong(), Mockito.any(BigDecimal.class))).thenReturn(true);
//
//	}
//
//	@Test
//	public void test(){
//		try {
//			Thread.sleep(10000*100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
