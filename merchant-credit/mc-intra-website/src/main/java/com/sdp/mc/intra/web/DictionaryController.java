//package com.sdp.mc.intra.web;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.slf4j.Logger;import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.sdp.mc.service.msp.cardissuer.MspCardIssuerRO;
//import com.sdp.mc.service.msp.cardissuer.MspCardIssuerService;
//import com.sdp.mc.service.msp.cm.district.DistrictHelper;
//import com.sdp.mc.service.msp.cm.district.DistrictRO;
//import com.sdp.mc.service.msp.dictionary.DictionaryRO;
//import com.sdp.mc.service.msp.dictionary.DictionaryService;
//
///**
// * DictionaryController，用于下拉框
// * 
// * @author liuxi.xiliu
// */
//@Controller
//@RequestMapping("/common/dictionary")
//public class DictionaryController {
//	private static final Logger log = LoggerFactory.getLogger(DictionaryController.class);
//	@Autowired
//	private DictionaryService dictionaryService;
//	@Autowired
//	private MspCardIssuerService mspCardIssuerService;
//
//	/**
//	 * 获取字典，作为下拉框的数据，通用字典
//	 */
//	@RequestMapping(value = "/forSelect")
//	@ResponseBody
//	public List<DictionaryRO> forSelect(String label, ModelMap model) {
//		List<DictionaryRO> list = dictionaryService.queryByLabel(label);
//		return list;
//	}
//
//	/**
//	 * 取得字典，作为下拉框的数据，发卡机构
//	 */
//	@RequestMapping(value = "/forCardIssuerSelect")
//	@ResponseBody
//	public List<MspCardIssuerRO> forFundoutBranchBankSelect(ModelMap model) {
//		List<MspCardIssuerRO> list = mspCardIssuerService.getAllMspCardIssuerList();
//		return list;
//	}
//
//	/**
//	 * 获取城市
//	 */
//	@RequestMapping(value = "/forSelectProvinces")
//	@ResponseBody
//	public List<DistrictRO> getProvinces(@RequestParam Long pid, ModelMap model) {
//		List<DistrictRO> provinceList = DistrictHelper.queryProvincesByParentId(pid);
//		return provinceList;
//	}
//
//	/**
//	 * 获取城市
//	 */
//	@RequestMapping(value = "/forSelectCities")
//	@ResponseBody
//	public List<DistrictRO> getCities(@RequestParam Long pid, ModelMap model) {
//		try {
//			// ----取得所有地区的城市-------------
//			if (pid > 0) {
//				List<DistrictRO> cityList = DistrictHelper.queryDistrictByParentId(pid);
//				return cityList;
//			}
//		} catch (Exception e) {
//			log.error("DictionaryController.getCities.error,pid=" + pid, e);
//		}
//		return new ArrayList<DistrictRO>();
//	}
//}
