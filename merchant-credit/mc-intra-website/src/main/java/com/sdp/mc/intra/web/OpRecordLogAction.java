package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.dto.StatisticsWithdrawInfoDTO;
import com.sdp.mc.common.enums.withdraw.LogRecordTypeEnums;
import com.sdp.mc.common.exception.IdentityLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.view.dao.ViewPromoterInfoDTO;
import com.sdp.mc.withdraw.WithdrawOpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDO;
import com.sdp.withdraw.dao.OpLogRecordDOExample;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.dao.WithdrawInfoDOExample;
import com.sdp.withdraw.dao.mapper.OpLogRecordMapper;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.manager.PosMerchantInfoManager;
import com.sdp.withdraw.manager.WithdrawInfoManager;
import com.sdp.withdraw.service.WithdrawReqService;
import com.sdp.withdraw.service.impl.LimitationBaseService;
import com.shengpay.service.view.PromoterInfoService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Controller
@RequestMapping("/withdraw")
public class OpRecordLogAction {

	private static final Logger logger = LoggerFactory.getLogger(OpRecordLogAction.class);

	@Autowired
	private OpLogRecordMapper opLogRecordMapper;
	@Autowired
	private WithdrawInfoManager withdrawInfoManager;
	@Autowired
	protected Mapper beanMapper;
	@Autowired
	private LimitationBaseService limitationBaseService;

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;
	@Autowired
	private WithdrawReqService withdrawReqService;

	/**
	 * 默认查询一个月的记录
	 * 
	 * @param query
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/opRecordLog/query")
	public String autoNewt0SettleMerchantQuery(String mcMerchantNo,String mcType, HttpServletRequest request,
			HttpServletResponse response,Long id, ModelMap model) {
		String redirectUrl = "/newt0/merchant/withdrawOpLogRecord";
		PosMerchantInfoDO merchantInfo=null;
		List<StatisticsWithdrawInfoDTO>  dataList=new ArrayList<StatisticsWithdrawInfoDTO>();
		try {
			if(id!=null){
				//查代理商
//				PromoterEO promoterEo = promoterDAO.queryPromoterById(id);
				merchantInfo= fwPosMerchantInfoService.getPosMerchantInfoByPosMerchantId(id);
				if (merchantInfo == null) {
					return redirectUrl;
				}
				dataList=withdrawReqService.statisticsPromoterWithdrawInfo(id);
			
			}else{
				if (StringUtils.isEmpty(mcMerchantNo) || StringUtils.isEmpty(mcType)) {
					return redirectUrl;
				}
				merchantInfo=fwPosMerchantInfoService.getPosMerchantInfoByMerchantInfo(mcMerchantNo, mcType);
				if (merchantInfo == null) {
					return redirectUrl;
				}
				dataList=withdrawReqService.statisticsMerchantWithdrawInfo(merchantInfo.getId());
			}
			//根据bizId 查询log
			List<WithdrawOpLogRecordDO> newList = new ArrayList<WithdrawOpLogRecordDO>();
			//查询当日的额度记录
			Long bizId = merchantInfo.getId();
			List<WithdrawInfoDO> withdrawInfos = queryWithdrawInfo(bizId);
			if (!withdrawInfos.isEmpty()) {
				WithdrawInfoDO withdrawInfo = withdrawInfos.get(0);
				WithdrawOpLogRecordDO logRecord = new WithdrawOpLogRecordDO();
//				OpLogRecordVO op = opLogRecordService.getOpLogRecordForLastDay(withdrawInfo,mcType, -1);
				beanMapper.map(withdrawInfo, logRecord);
				logRecord.setRecordType(LogRecordTypeEnums.SYNC_MERCHANT_WITHDRAW.desc);
				logRecord.setMerchantNo(merchantInfo.getMerchantNo());
				logRecord.setMcType(merchantInfo.getMerchantType());
				BigDecimal currentFastAmount = limitationBaseService.findMerchantFastAmount(merchantInfo.getMerchantNo(), merchantInfo.getMerchantType());
				logRecord.setLimitation(currentFastAmount);
				if (logRecord.getForzenLimitation()==null) logRecord.setForzenLimitation(BigDecimal.ZERO);
				if (logRecord.getUsedLimitation()==null) logRecord.setUsedLimitation(BigDecimal.ZERO);
				logRecord.setBeginTime(DateUtil.getCurrentDayStrFristTime(new Date()));
				newList.add(logRecord);
			}
			
			if(PosMerchantTypeEnums.POS_MERCHANT.code.equals(merchantInfo.getMerchantType())
					||PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(merchantInfo.getMerchantType())
							||PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(merchantInfo.getMerchantType())){
				BigDecimal identityLimit = limitationBaseService.getIdentityLimit(merchantInfo.getMerchantNo(), merchantInfo.getMerchantType());
				model.put("identityLimit", identityLimit);
				try {
					BigDecimal usedIdentityLimit = limitationBaseService.queryUsedIdentityLimit(merchantInfo.getMerchantNo(), merchantInfo.getMerchantType());
					model.put("usedIdentityLimit", usedIdentityLimit);
				} catch (IdentityLimitException e) {
					logger.error("queryUsedIdentityLimit", e);
					model.put("usedIdentityLimit", e.getErrorMessage());
				}
			}
			model.put("merchantInfo", merchantInfo);
			model.put("newList", newList);
			model.put("dataList", dataList);
		} catch (Exception e) {
			logger.error("query opreator record log error : ",e);
		}

		return redirectUrl;
	}

	private List<WithdrawInfoDO> queryWithdrawInfo(Long bizId) {
		// TODO Auto-generated method stub
		WithdrawInfoDOExample queryExample = new WithdrawInfoDOExample();
		WithdrawInfoDOExample.Criteria queryCriteria = queryExample.createCriteria();
		queryCriteria.andBizIdEqualTo(bizId);
		List<WithdrawInfoDO> withdrawInfos = withdrawInfoManager.selectByExample(queryExample);
		withdrawInfos = withdrawInfos == null ? new ArrayList<WithdrawInfoDO>() : withdrawInfos;
		return withdrawInfos;
	}

	/**
	 * 查询log
	 * 
	 * @param posMerchatInfo
	 * @return
	 */
	private List<OpLogRecordDO> queryOpRecordLog(PosMerchantInfoDO posMerchatInfo) {
		OpLogRecordDOExample logExample = new OpLogRecordDOExample();
		OpLogRecordDOExample.Criteria logCriteria = logExample.createCriteria();
		logCriteria.andOpRecordLike("{\"bizId\":\"" + String.valueOf(posMerchatInfo.getId()) + "%");
		List<String> type = new ArrayList<String>();
		type.add(LogRecordTypeEnums.SYNC_MERCHANT_WITHDRAW.code);
		logCriteria.andRecordTypeIn(type);
		logCriteria.andCreateTimeGreaterThan(getBeforeDayFirstTime());// 查询一个月的记录
		logExample.setOrderByClause(" CREATE_TIME DESC ");
		List<OpLogRecordDO> _list = opLogRecordMapper.selectByExample(logExample);
		_list = _list == null ? new ArrayList<OpLogRecordDO>() : _list;
		return _list;
	}

	/**
	 * json convert map
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private HashMap<String, Object> json2HashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	/**
	 * 一个月
	 *
	 * @return
	 */
	private Date getBeforeDayFirstTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
