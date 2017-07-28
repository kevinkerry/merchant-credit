//package com.sdp.mc.dao.readonly.test;
//
//import java.util.List;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sdp.mc.common.constant.DistrictCst;
//import com.sdp.mc.dao.authorize.AuthDAO;
//import com.sdp.mc.dao.authorize.RuleEO;
//import com.sdp.mc.dao.lockoperator.LockOperatorDAO;
//import com.sdp.mc.dao.readonly.cm.district.DistrictDAO;
//import com.sdp.mc.dao.readonly.cm.district.DistrictEO;
//import com.sdp.mc.dao.readonly.merchant.CmPosMerchantDAO;
//import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractDAO;
//import com.sdp.mc.dao.readonly.merchantcontract.CmMerchantContractEO;
//import com.sdp.mc.dao.readonly.promoter.PromoterCond;
//import com.sdp.mc.dao.readonly.promoter.PromoterDAO;
//import com.sdp.mc.dao.readonly.promoter.PromoterEO;
//import com.sdp.mc.dao.test.MCBaseTest;
//import com.sdp.mc.dao.userloginlog.McUserLoginLogDAO;
//import com.sdp.mc.ffconfig.dao.daointerface.FastSettleConfigDAO;
//import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
//import com.sdp.mc.margin.dao.daointerface.MarginOpReqDAO;
//import com.sdp.mc.margin.dao.ext.MarginOpReqDOExampleExt;
//import com.sdp.mc.margin.dao.ext.MarginOpReqDOExt;
//
//public class ReadOnlyTableDAOTest extends MCBaseTest {
//	@Autowired
//	private CmMerchantContractDAO cmMerchantContractDAO;
//	@Autowired
//	private CmPosMerchantDAO cmPosMerchantDAO;
//	@Autowired
//	private AuthDAO authDAO;
//	@Autowired
//	private LockOperatorDAO lockOperatorDAO;
//	@Autowired
//	private PromoterDAO promoterDAO;
//	@Autowired
//	private DistrictDAO districtDAO;
//
//	@Autowired
//	private MarginOpReqDAO marginOpReqDAO;
//	
//	@Autowired
//	private FastSettleConfigDAO fastSettleConfigDAO;
//	// @Test
//	public void testSelect() {
//		// 合同查询
//		CmMerchantContractEO merchantContract = this.cmMerchantContractDAO.queryPosPromoterByMerchantNo("704823");
//		System.out.println("merchantContract====" + ToStringBuilder.reflectionToString(merchantContract));
//		// pos商户号查询
//		String merchantNo = this.cmPosMerchantDAO.queryPosMerchantNoByMerchantNo("201110311000000841");
//		System.out.println("merchantNo====" + merchantNo);
//		// 查询所有的权限
//		List<RuleEO> rules = this.authDAO.getAllRules();
//		System.out.println("rules.size====" + rules.size());
//		Integer status = this.lockOperatorDAO.getLockStatusByOperatorId("201110311000000841");
//		System.out.println("opr.status====" + status);
//	}
//
//	// @Test
//	public void testSelectPromoter() {
//		PromoterCond cond = new PromoterCond();
//		cond.setCountryId("86");
//		cond.setProvinceDistrictId("");
//		cond.setCreateTimeEndStr("");
//		int count = promoterDAO.queryCountPromoters(cond);
//		System.out.println("-----count=======" + count);
//		List<PromoterEO> promoterEOs = promoterDAO.queryPromoters(cond);
//		System.out.println("---promoterEOs.size====" + promoterEOs.size());
//	}
//
//	//@Test
//	public void testQueryAllDistrictByLevel() {
//		List<DistrictEO> countryEOList = districtDAO.queryAllDistrictByLevel(DistrictCst.DCT_DISTRICT_LEVEL_COUNTRY);
//		System.out.println("---countryEOList.size====" + countryEOList.size());
//	}
//	//@Test
//	public void testQueryMargin(){
//		MarginOpReqDOExampleExt example = new MarginOpReqDOExampleExt();
//		List<MarginOpReqDOExt> list = marginOpReqDAO.selectByQuery4Intra(example);
//	}
//	
//	@Test
//	public void testAutoFastSettleQuery(){
//		FastSettleConfigDOExampleExt example = new FastSettleConfigDOExampleExt();
//		this.fastSettleConfigDAO.selectByQuery4Intra(example);
//	}
//}
