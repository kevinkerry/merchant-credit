package com.shengpay.service.withdraw.wallet.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.YesNoEnum;
import com.sdp.mc.common.enums.withdraw.WalletWithdrawStatusEnums;
import com.sdp.mc.settle.api.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.vo.WithdrawT0ServiceRequest;
import com.sdp.withdraw.vo.WithdrawT0ServiceResponse;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
import com.shengpay.service.withdraw.T0WithdrawService;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;
/**
 * 钱包出款发起出款处理线程
 * @author liyantao01
 *
 */
@Service("WalletWithdrawHandler")
public class WalletWithdrawHandler  {

	@Autowired
	private Mapper beanMapper;
    @Autowired
    private T0WithdrawService t0WithdrawService;
    @Autowired
    private WalletWithdrawService walletWithdrawService;
    @Autowired
    private WalletWithdrawServiceCallbackHandler walletWithdrawServiceCallbackHandler;
	
	protected final ExecutorService pool = Executors.newFixedThreadPool(5);


	private Logger logger = LoggerFactory.getLogger(WalletWithdrawHandler.class);
	public void execute(WalletWithdrawReqDO reqDo,String withdrawType) {
		logger.info("WalletWithdrawHandler #execute.");
		WalletWithdrawTask task = new WalletWithdrawTask(reqDo,withdrawType);
		pool.execute(new InheritTraceNoRunableWrapper(task));
	}


	class WalletWithdrawTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(WalletWithdrawTask.class);

		private WalletWithdrawReqDO reqDo;
		private String withdrawType;

		public WalletWithdrawTask(WalletWithdrawReqDO reqDo,String withdrawType) {
			this.reqDo=reqDo;
			this.withdrawType=withdrawType;
		}

		public void run() {
			logger.info("WalletWithdrawTask #run,withdrawType:{},WalletWithdrawReqDO:{}",new Object[]{withdrawType,ToStringBuilder.reflectionToString(reqDo,ToStringStyle.SHORT_PREFIX_STYLE)});
			if(reqDo!=null&&(WalletWithdrawStatusEnums.INIT.code==reqDo.getStatus()||WalletWithdrawStatusEnums.FAIL.code==reqDo.getStatus())){
				Long traceNo=null;
				if(PosMerchantTypeEnums.MPOS_MERCHANT.code.equals(reqDo.getMemberType())||PosMerchantTypeEnums.EASYPAY_MERCHANT.code.equals(reqDo.getMemberType())){
					try {
						//扩展字段不需要透传
						String extention=reqDo.getExtention();
						reqDo.setExtention(null);
						WithdrawT0ServiceRequest request=beanMapper.map(reqDo, WithdrawT0ServiceRequest.class);
						request.setWithdrawType(withdrawType);
						request.setCallbackAddress(WithdrawConstant.WALLET_WITHDRAW_CALLBACK_RECEIVE_URL);
						request.setSignature(request.getSignStr(WithdrawConstant.MD5key));
						if(StringUtils.isNotBlank(extention)){
							JSONObject json=JSONObject.fromObject(extention);
							if(json.containsKey(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN)
									&&YesNoEnum.YES.code.equals(json.getString(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN))){
								Map<String,Object> extentionMap=new HashMap<String, Object>();
								extentionMap.put(WithdrawConstant.WITHDRAW_REQUEST_EXTENTS_KEY_HAS_OA_TXN, YesNoEnum.YES.code);
								request.setExtention(extentionMap);
							}
						}
						WithdrawT0ServiceResponse respose=t0WithdrawService.getWithdrawT0ServiceAPI().t0WithdrawBalance(request);
						logger.info("t0WithdrawBalance apply respose：{}",ToStringBuilder.reflectionToString(respose,ToStringStyle.SHORT_PREFIX_STYLE));
						if(respose!=null){
							traceNo=StringUtils.isNotBlank(respose.getTraceNo())?Long.valueOf(respose.getTraceNo()):null;
							if(ReturnCodeEnums.FW_MC_T0_ING.code.equals(respose.getErrorCode())){
								walletWithdrawService.updateDataStatus(reqDo.getReqId(),WalletWithdrawStatusEnums.WAITTING.code,traceNo);
								logger.info("t0WithdrawBalance apply success");
								return;
							}else if(ReturnCodeEnums.FW_SUCCESS.code.equals(respose.getErrorCode())){
								walletWithdrawService.updateDataStatus(reqDo.getReqId(),WalletWithdrawStatusEnums.SUCCESS.code,traceNo);
								logger.info("t0WithdrawBalance apply success,withdraw success");
								return;
							}
						}
					} catch (Exception e) {
						logger.error("t0WithdrawBalance apply Exception",e);
					}
					logger.info("t0WithdrawBalance apply fail");
					walletWithdrawService.updateDataStatus(reqDo.getReqId(),WalletWithdrawStatusEnums.FAIL.code,traceNo);
					if(StringUtils.isNotBlank(reqDo.getCallbackAddress())){
						walletWithdrawServiceCallbackHandler.execute(reqDo.getReqId());
					}
				}else{
					logger.info(" not mpos merchant data");
				}
				
			}
		}


	}


}
