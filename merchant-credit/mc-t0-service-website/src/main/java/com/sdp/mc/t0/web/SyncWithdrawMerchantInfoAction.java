package com.sdp.mc.t0.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.view.dao.ViewMerchantInfoDTO;
import com.sdp.withdraw.dao.PosMerchantInfoDO;
import com.sdp.withdraw.dao.PosMerchantInfoDOExample;
import com.sdp.withdraw.dao.WithdrawInfoDO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.error.QuatoOpreateException;
import com.sdp.withdraw.service.LimitationService;
import com.sdp.withdraw.service.impl.LimitationBaseService;
import com.shengpay.service.view.MerchantInfoService;

/**
 * 同步商户信息
 * @author wangmindong
 * 2016年3月10日 16:05:21
 */
@Controller
//@RequestMapping("syncWithdrawMerchantInfo")
public class SyncWithdrawMerchantInfoAction {

	private static final Logger logger = LoggerFactory.getLogger(SyncWithdrawMerchantInfoAction.class);


	@Autowired
	private LimitationService limitationService;
	@Autowired
	private LimitationBaseService limitationBaseService;
	@Autowired
	private MerchantInfoService merchantInfoService;

	@RequestMapping("syncMerchantInfo")
	public String syncMerchantInfo(HttpServletRequest request, HttpServletResponse response,ModelMap model){
		String synKey=request.getParameter("synKey");
		Long start = System.currentTimeMillis();
		if(!WithdrawConstant.MERCHANT_INFO_SYNKEY.equals(synKey)){//没有同步标识，不发起同步
			logger.info("SyncWithdrawMerchantInfoAction #syncMerchantInfo,illegal request！");
			model.put("result", "商户信息同步参数异常~");
			return "/withdraw/resultInfo";
		}
		try {
			//TODO 查询所有的商户信息 ppcpay.MSP_POS_MERCHANT POS MPOS
			//List<MspPosMerchantEO> list = mspPosMerchantDAO.queryAllMspMerchant();
			List<ViewMerchantInfoDTO> list=merchantInfoService.queryAllMerchantInfo();
			if (list ==null || list.isEmpty()) return "/withdraw/resultInfo";
			//遍历商户
			for (ViewMerchantInfoDTO merchantEo : list) {
				//TODO 同步数据
				String merchantNo = merchantEo.getMerchantNo();//商户号
				String mcType = merchantEo.getMcType();
				if(isExsitByMerchantNo(merchantNo,mcType)){
					continue;
				}
				//POS商户
				if(PosMerchantTypeEnums.POS_MERCHANT.code.equals(mcType) || PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(mcType)) {
					Long rows = limitationBaseService.insertMerchantInfo(merchantEo);
					if (rows<0) {
						logger.error("SyncWithdrawMerchantInfoAction syncMerchantInfo error : rows ["+rows+"]"+"merchantNo:["+merchantEo.getMerchantNo()+"] mcType: ["+mcType+"]");
						System.err.println("商户数据同步错误: rows ["+rows+"]"+"merchantNo:["+merchantEo.getMerchantNo()+"] mcType: ["+mcType+"]");
					}
				}
			}
			Long end = System.currentTimeMillis();
			model.put("result", "商户信息同步完成 耗时:"+(end-start)/1000 +" s ");
		} catch (QuatoOpreateException e) {
			logger.error("商户信息同步异常:"+e.getErrorMsg());
			model.put("result", "商户信息同步异常"+e.getErrorMsg());
		}
		return "/withdraw/resultInfo";
	}

	/**
	 * 是否存在 true：存在 false:不存在
	 * @param merchantNo
	 * @return
	 */
	private boolean isExsitByMerchantNo(String merchantNo,String mcType) {
		PosMerchantInfoDOExample example = new PosMerchantInfoDOExample();
		example.setMerchantNo(merchantNo);
		example.setMerchantType(mcType);
		List<PosMerchantInfoDO>  list = limitationService.findPosMerchantInfo(example);
		if (list==null || list.isEmpty()) {
			return false;
		}
		//判断额度记录是否存在
		Long bizId = list.get(0).getId();
		List<WithdrawInfoDO> withdrawList = limitationBaseService.getWithdrawInfoDO(bizId);
		if (withdrawList == null || withdrawList.isEmpty()) {
			return false;
		}
		return true;
	}
}
