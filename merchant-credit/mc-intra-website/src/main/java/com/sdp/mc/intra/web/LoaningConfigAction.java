package com.sdp.mc.intra.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.newt0.PmtMerchantType;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDO;
import com.sdp.mc.newt0.dao.Newt0LoaningConfigDOExample;
import com.sdp.mc.newt0.manager.Newt0LoaningConfigManager;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;

@Controller
@RequestMapping("/loaningConfig")
public class LoaningConfigAction {

	private static final Logger logger = LoggerFactory.getLogger(LoaningConfigAction.class);

	@Autowired
	private Newt0LoaningConfigManager newt0LoaningConfigManager;


	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/config/loaning/index";
	}

	@RequestMapping(value = "/ajaxPaging/logningList")
	public String logningList(@ModelAttribute("query") Newt0LoaningConfigDOExample query, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		query.setOrderByClause(" CREATE_TIME DESC");
		List<Newt0LoaningConfigDO> list = this.newt0LoaningConfigManager.selectByQuery(query);
		model.put("dataList", list);
		model.put("query", query);
		return "/config/loaning/logningList";
	}

	@RequestMapping(value = "/initEdit")
	public String initEdit(Long configId, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("LoaningConfigAction.initEdit.configId=" + configId);
		if (configId != null) {
			Newt0LoaningConfigDO config = this.newt0LoaningConfigManager.selectByPrimaryKey(configId);
			LoaningConfigBean loaningType = LoaningConfigBean.json2Bean(config.getContent());
			model.put("loaningType", loaningType);
		}
		model.put("configId", configId);
		return "/config/loaning/edit";
	}

	@RequestMapping(value = "/initEditOp")
	@ResponseBody
	public ErrorMessageVO<Object> initEditOp(String posParas,String mposParas,Long id,String easypayParas, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		logger.info("LoaningConfigAction.initEditOp. posParas :{} mposParas :{} easypayParas :{} id :{}",new Object[]{posParas,mposParas,id,easypayParas});
		ErrorMessageVO<Object> error = new ErrorMessageVO<Object>(false);
		try {
			if (StringUtils.isEmpty(posParas) || StringUtils.isEmpty(mposParas)|| StringUtils.isEmpty(easypayParas) || id == null) {
				error.setSuccess(false);
				error.setErrorMessage("参数异常");
				error.setErrorCode("1");
				return error;

			}
		/*	String fsBeginTime =fsTimeStr.split(",")[0];
			String fsEndTime =fsTimeStr.split(",")[1];*/
			Newt0LoaningConfigDO record = this.newt0LoaningConfigManager.selectByPrimaryKey(id);
			LoaningConfigBean loaningType = LoaningConfigBean.json2Bean(record.getContent());

			/*loaningType.setFsBeginTime(fsBeginTime);
			loaningType.setFsEndTime(fsEndTime);*/

			@SuppressWarnings("rawtypes")
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("pmtMerchantType", PmtMerchantType.class);
			List<PmtMerchantType> pmtMerchantType = loaningType.getPtmMerchantType();
			List<PmtMerchantType> upMerchantType = new ArrayList<PmtMerchantType>();
			try {
				for (int i=0;i<pmtMerchantType.size();i++) {
					PmtMerchantType merchantType = (PmtMerchantType) JSONObject.toBean(JSONObject.fromObject(pmtMerchantType.get(i)), PmtMerchantType.class, classMap);
					//merchantType.setFsBeginTime(fsBeginTime);
					//merchantType.setFsEndTime(fsEndTime);
					if (PosMerchantTypeEnums.POS_PROMOTER.code.equals(merchantType.getMcType())) {
						merchantType = initPmtMerchantType(merchantType,posParas);
					}else if (PosMerchantTypeEnums.MPOS_PROMOTER.code.equals(merchantType.getMcType())){
						merchantType = initPmtMerchantType(merchantType,mposParas);
					}else if (PosMerchantTypeEnums.EASYPAY_PROMOTER.code.equals(merchantType.getMcType())){
						merchantType = initPmtMerchantType(merchantType,easypayParas);
					}
					upMerchantType.add(merchantType);
				}
			} catch (Exception e) {
				logger.error("修改垫资类型参数解析异常:",e);
				error.setErrorMessage("参数解析异常:"+e);
				error.setErrorCode("1");
				return error;
			}

			loaningType.setPtmMerchantType(upMerchantType);
			String jsonContent = JSONObject.fromObject(loaningType).toString();
			logger.info("jsonContent=="+jsonContent);
			record.setUpdateTime(new Date());
			record.setContent(jsonContent);
			int updateStatus = this.newt0LoaningConfigManager.updateByPrimaryKey(record);
			if (updateStatus>0) {
				error.setSuccess(true);
				error.setErrorMessage("修改成功");
				error.setErrorCode("0");
			}
		} catch (Exception e) {
			logger.error("修改垫资类型异常:",e);
			error.setErrorMessage("修改垫资类型异常:"+e);
			error.setErrorCode("1");
		}
		return error;
	}

	/**
	 * @param merchantType
	 * @param jsonContent
	 * @return
	 */
	private PmtMerchantType initPmtMerchantType(PmtMerchantType merchantType,String jsonContent){
		String workdayFees = jsonContent.split("_")[0];
		workdayFees = workdayFees.substring(1,workdayFees.length()-1);
		int workdayLen = workdayFees.split(",").length;
		String[] workFee = new String[workdayLen];
		for(int i=0;i<workdayLen;i++){
			workFee[i] = workdayFees.split(",")[i].trim();
		}


		String holidayFees = jsonContent.split("_")[1];
		holidayFees = holidayFees.substring(1, holidayFees.length()-1);
		int holidayLen = holidayFees.split(",").length;
		String[] holidayFee = new String[holidayLen];
		for(int i=0;i<holidayLen;i++){
			holidayFee[i] = holidayFees.split(",")[i].trim();
		}
		long minimumMargin = Long.parseLong(jsonContent.split("_")[2]);//保底保证金
		int  minimumMarginRedeem = Integer.parseInt(jsonContent.split("_")[3]);//保底保证金取回天数
		int marginRedeem = Integer.parseInt(jsonContent.split("_")[4]);//浮动保证金取回天数
		BigDecimal floorAmt = new BigDecimal(jsonContent.split("_")[5]);
		String fsBeginTime = jsonContent.split("_")[6];
		String fsEndTime = jsonContent.split("_")[7];
		merchantType.setWorkdayFees(workFee);
		merchantType.setHolidayFees(holidayFee);
		merchantType.setMinimumMargin(minimumMargin);
		merchantType.setMinimumMarginRedeem(minimumMarginRedeem);
		merchantType.setMarginRedeem(marginRedeem);
		merchantType.setFloorAmt(floorAmt);
		merchantType.setFsBeginTime(fsBeginTime);
		merchantType.setFsEndTime(fsEndTime);
		return merchantType;
	}
}
