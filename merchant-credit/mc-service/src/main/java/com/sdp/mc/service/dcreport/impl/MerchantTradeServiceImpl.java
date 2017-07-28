package com.sdp.mc.service.dcreport.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.merchant.CmPosMerchantNewDAO;
import com.sdp.mc.dataservice.MerchantTradeService;
import com.sdp.mc.service.dcreport.MCMerchantTradeService;

/**
 * 交易量
 *
 * @author
 */
@Service("merchantTradeService ")
public class MerchantTradeServiceImpl implements MCMerchantTradeService {

	private static final Log log = LogFactory.getLog(MerchantTradeServiceImpl.class);

	// @Value("${dc.report.url}")
	// private String dcReportUrl;
	// @Value("${newt0.mock}")
	// private boolean newt0mock;
	@Autowired
	private CmPosMerchantNewDAO cmPosMerchantNewDAO;
	@Autowired
	private ConfigOptionManager configOptionManager;

	private MerchantTradeService merchantTradeService;

	private MerchantTradeService getMerchantTradeService() {
		if (merchantTradeService == null) {
			//merchantTradeService = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.NEWT0_DATA_SERVICE_MODULE, MerchantTradeService.class);
		}
		return merchantTradeService;
	}

	private String getGMVOfLastMonth(String merchantNo, Date date) {
		String resultDate = "";
		try {
			// Boolean newt0mock =
			// configOptionManager.getBooleanByKey(MerchantCreditConstant.NEW_T0_MOCK);
			// if (true == newt0mock) {
			// resultDate =
			// "{\"data\":{\"items\":[{\"amount\":100.35, \"merchantno\":\"BD001\",\"month\":2015-07}]},\"result\":true}";
			// return resultDate;
			// }
			resultDate = getMerchantTradeService().getGMVOfLastMonth(merchantNo, date);
			log.info("MerchantTradeServiceImpl-->getGMVOfLastMonth-->resultDate=" + resultDate);
		} catch (Exception e) {
			log.error("MerchantTradeServiceImpl-->getGMVOfLastMonth-->异常=", e);
			resultDate = "{\"data\":{\"items\":[]},\"result\":false}";
		}
		return resultDate;

	}

	private String getGMVOfLastThreeMonth(String merchantNo, Date date) {
		String resultDate = "";
		try {
			// Boolean newt0mock =
			// configOptionManager.getBooleanByKey(MerchantCreditConstant.NEW_T0_MOCK);
			// if (true == newt0mock) {
			// resultDate =
			// "{\"data\":{\"items\":[{\"amount\":100.35, \"merchantno\":\"BD002\",\"month\":2015-07},{\"amount\":99.35,\"merchantno\":\"BD002\",\"month\":2015-06},{\"amount\":199.35,\"merchantno\":\"BD002\",\"month\":2015-05}]},\"result\":true}";
			// return resultDate;
			// }
			resultDate = getMerchantTradeService().getGMVOfLastThreeMonth(merchantNo, date);
			log.info("MerchantTradeServiceImpl-->getGMVOfLastThreeMonth-->resultDate=" + resultDate);
		} catch (Exception e) {
			log.error("MerchantTradeServiceImpl-->getGMVOfLastMonth-->Exception=", e);
			resultDate = "{\"data\":{\"items\":[]},\"result\":false}";
		}
		return resultDate;
	}

	/**
	 * 根据商户号查询季度每月（前三个月）是否大于指定交易额 查询结果为当前日期的前三个月,如:2015-09-xx,返回结果是 2015-06 ~
	 * 2015-08月是否满足的结果
	 *
	 * @param merchantNo
	 * @return boolean
	 * @throws Exception
	 */
	public boolean monthTradeAmount(String merchantNo) throws Exception {
		return monthTradeAmount(merchantNo, new Date());
	}
	/**
	 * 根据商户号查询上个月的支付获取天数
	 *
	 * @param merchantNo
	 * @throws Exception
	 */
	@Override
	public int getActiveDaysOfLastMonth(String merchantNo) throws Exception {
		return getActiveDaysOfLastMonth(merchantNo, new Date());
	}
	/**
	 * 根据商户号查询上个月的支付获取天数
	 *
	 * @param merchantNo
	 * @throws Exception
	 */
	@Override
	public int getActiveDaysOfLastMonth(String merchantNo, Date date) throws Exception  {
		String resultData = "";
		try {
			resultData = getMerchantTradeService().getActiveDaysOfLastMonth(merchantNo, date);
			log.info("MerchantTradeServiceImpl-->getActiveDaysOfLastMonth-->resultDate=" + resultData);
			JSONObject jsonObject = JSONObject.fromObject(resultData);
			boolean resultFlag = checkResultStr(jsonObject);
			if (resultFlag == false)
				return 0;
			// 返回结果是否成功
			boolean flag = Boolean.valueOf(jsonObject.getBoolean("result"));
			// 失败直接返回
			if (flag == false) {
				return 0;
			}
			JSONObject jsondata = jsonObject.getJSONObject("data");
			List<?> list = jsondata.getJSONArray("items");

			// 如果没有返回数据 返回0
			if (list == null || list.size() == 0)
				return 0;
			for (int i = 0; i < list.size(); i++) {
				JSONObject jsonObj = (JSONObject) list.get(i);
				String tmp_merchantNo = jsonObj.getString("merchantno");
				String tmp_month = jsonObj.getString("month");
				if (StringUtils.isBlank(tmp_merchantNo) || StringUtils.isBlank(tmp_month)) {
					log.error("MerchantTradeServiceImpl-->getDayOfAmount-->tmp_merchantNo=" + tmp_merchantNo + "&tmp_month=" + tmp_month);
					return 0;
				}
				if (!tmp_merchantNo.equals(merchantNo)) {
					log.error("MerchantTradeServiceImpl-->getDayOfAmount-->merchantNo=" + merchantNo + "&tmp_merchantNo=" + tmp_merchantNo);
					return 0;
				}
				SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM");
				date = DateUtil.increaseMonthDate(new Date(), -1);
				if (!dateFormat4.format(date).equals(tmp_month)) {
					log.error("MerchantTradeServiceImpl-->getDayOfAmount-->month=" + DateUtil.date2DateStr(date) + "&tmp_month=" + tmp_month);
					return 0;
				}
				// 判断是不是同一商户号
					// 返回金额
				return jsonObj.getInt("amount");
			}


		} catch (Exception e) {
			log.error("MerchantTradeServiceImpl-->getActiveDaysOfLastMonth-->异常=", e);
		}
		return 0;
	}

	/**
	 * 根据商户号查询季度每月（前三个月）是否大于指定交易额
	 *
	 * @param merchantNo
	 *            商户号
	 * @param date
	 *            日期（查询结果为传入日期的前三个月,如:2015-09-xx,返回结果是 2015-06 ~
	 *            2015-08月是否满足的结果）
	 * @return boolean
	 * @throws Exception
	 */
	public boolean monthTradeAmount(String merchantNo, Date date) throws Exception {
		log.info("MerchantTradeServiceImpl-->monthTradeAmount-->param:merchantNo=" + merchantNo + "&month=" + DateUtil.date2DateStr(date));
		// date = DateUtil.increaseMonthDate(new Date(), -1);
		/**
		 * 新T0商户每月交易额配置
		 */
		String tradeAmountStr = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.NEW_T0_MONTHAMOUNT);
		BigDecimal tradeAmount = new BigDecimal(tradeAmountStr);

		log.info("MerchantTradeServiceImpl-->monthTradeAmount-->param:merchantNo=" + merchantNo + "&month=" + DateUtil.date2DateStr(date));
		String resultDate = getGMVOfLastThreeMonth(merchantNo, date);
		log.info("MerchantTradeServiceImpl-->monthTradeAmount-->resultDate=" + resultDate);
		JSONObject jsonObject = JSONObject.fromObject(resultDate);
		if (!checkResultStr(jsonObject))
			return false;
		log.info("MerchantTradeServiceImpl-->monthTradeAmount-->jsonObject=" + jsonObject);
		// 返回结果是否成功
		boolean flag = Boolean.valueOf(jsonObject.getBoolean("result"));
		// 失败直接返回
		if (flag == false)
			return false;

		JSONObject jsondata = jsonObject.getJSONObject("data");
		List<?> list = jsondata.getJSONArray("items");
		// 如果没有返回数据 返回false
		if (list == null || list.size() == 0)
			return false;
		for (int i = 0; i < list.size(); i++) {
			// 商户号必须相等
			if (!((JSONObject) list.get(i)).get("merchantno").equals(merchantNo)) {
				log.error("MerchantTradeServiceImpl-->monthTradeAmount-->return unknown data ");
				return false;
			}
			String amount = ((JSONObject) list.get(i)).getString("amount");
			if (BigDecimal.valueOf(Double.valueOf(amount)).compareTo(tradeAmount) == -1) {
				log.error("MerchantTradeServiceImpl-->monthTradeAmount-->tradeAmount Less than " + tradeAmount);
				return false;
			}
		}
		return true;

	}

	/**
	 * msp
	 *
	 * @param merchantNo
	 *            商户号
	 * @return
	 */
	@Override
	public BigDecimal getDayOfAmount(String merchantNo) throws Exception {
		return getDayOfAmount(merchantNo, new Date());
	}

	/**
	 * msp
	 *
	 * @param merchantNo
	 *            商户号
	 * @param month
	 *            月份
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	@Override
	public BigDecimal getDayOfAmount(String merchantNo, Date date) throws Exception {
		log.info("MerchantTradeServiceImpl-->getDayOfAmount-->param:merchantNo=" + merchantNo + "&month=" + DateUtil.date2DateStr(date));
		// date = DateUtil.increaseMonthDate(new Date(), -1);

		BigDecimal dayAmount = null;
		// 这里需要调用接口
		String resultData = this.getGMVOfLastMonth(merchantNo, date);
		JSONObject jsonObject = JSONObject.fromObject(resultData);
		boolean resultFlag = checkResultStr(jsonObject);
		if (resultFlag == false)
			return new BigDecimal(0);
		// 返回结果是否成功
		boolean flag = Boolean.valueOf(jsonObject.getBoolean("result"));
		// 失败直接返回
		if (flag == false) {
			return new BigDecimal(0);
		}
		JSONObject jsondata = jsonObject.getJSONObject("data");
		List<?> list = jsondata.getJSONArray("items");

		// 如果没有返回数据 返回0
		if (list == null || list.size() == 0)
			return new BigDecimal(0);
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonObj = (JSONObject) list.get(i);
			String tmp_merchantNo = jsonObj.getString("merchantno");
			String tmp_month = jsonObj.getString("month");
			if (StringUtils.isBlank(tmp_merchantNo) || StringUtils.isBlank(tmp_month)) {
				log.error("MerchantTradeServiceImpl-->getDayOfAmount-->tmp_merchantNo=" + tmp_merchantNo + "&tmp_month=" + tmp_month);
				return new BigDecimal(0);
			}
			if (!tmp_merchantNo.equals(merchantNo)) {
				log.error("MerchantTradeServiceImpl-->getDayOfAmount-->merchantNo=" + merchantNo + "&tmp_merchantNo=" + tmp_merchantNo);
				return new BigDecimal(0);
			}
			SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy-MM");
			date = DateUtil.increaseMonthDate(new Date(), -1);
			if (!dateFormat4.format(date).equals(tmp_month)) {
				log.error("MerchantTradeServiceImpl-->getDayOfAmount-->month=" + DateUtil.date2DateStr(date) + "&tmp_month=" + tmp_month);
				return new BigDecimal(0);
			}
			// 判断是不是同一商户号
//			if (tmp_merchantNo.equals(merchantNo)) {
				// 返回金额
				dayAmount = BigDecimal.valueOf(((JSONObject) list.get(i)).getDouble("amount"));
//			}
		}

		return dayAmount;

	}





	private boolean checkResultStr(JSONObject jsonObj) {
		boolean resultFlag = true;
		if (!jsonObj.containsKey("result")) {
			log.error("MerchantTradeServiceImpl-->checkResultStr-->result is not exits");
			resultFlag = false;
		}
		if (!jsonObj.containsKey("data")) {
			log.error("MerchantTradeServiceImpl-->checkResultStr-->data is not exits");
			resultFlag = false;
		}
		JSONObject jsondata = jsonObj.getJSONObject("data");
		if (!jsondata.containsKey("items")) {
			log.error("MerchantTradeServiceImpl-->checkResultStr-->items is not exits");
			resultFlag = false;
		}
		return resultFlag;
	}

	/**
	 * 连续收单几个月
	 */
	@Override
	public boolean selectOPenContract(String merchantNo) {
		return selectOPenContract(merchantNo, 0);
	}

	/**
	 * 连续收单几个月
	 */
	@Override
	public boolean selectOPenContract(String merchantNo, int monthCount) {
		// TODO Auto-generated method stub
		/**
		 * 默认查询展开收单业务六个月
		 */
		if (monthCount == 0) {
			monthCount = -6;
		}
		return cmPosMerchantNewDAO.selectOPenContract(merchantNo, monthCount);
	}

	public static void main(String[] args) {
		// String json =
		// "{\"data\":{\"items\":[{\"amount\":100.35, \"merchantno\":\"200\",\"month\":4},{\"amount\":99.35,\"merchantno\":\"200\",\"month\":3},{\"amount\":199.35,\"merchantno\":\"200\",\"month\":2}]},\"result\":true}";
		// String
		// json="{\"data\":{\"items\":{\"amount\":100.35,\"merchantno\":\"100\",\"month\":2}},\"result\":true}";
		// JSONObject jsonObject = JSONObject.fromObject(json);
		// JSONObject jsondata = jsonObject.getJSONObject("data");
		// List<?> items = jsondata.getJSONArray("items");
		// JSONObject v = (JSONObject) items.get(0);
		// MerchantTradeVO vo = (MerchantTradeVO) JSONObject.toBean(v,
		// MerchantTradeVO.class);
		//
		// System.out.println(vo.getMerchantNo());
		// List<?> list = jsondata.getJSONArray("items");
		// System.out.println(((JSONObject)list.get(1)).get("merchantno"));
		// String json = "{\"data\":{\"items\":[]},\"result\":true}";
		// JSONObject jsonObject = JSONObject.fromObject(json);
		// System.out.println(jsonObject);

		// System.out.println(DateUtil.dateFormat3.format(Date.parse("Wed Sep 16 11:06:45 CST 2015")));
	}


}
