package com.sdp.mc.intra.worker.limitrule;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.sdp.mc.common.constant.LimitRuleInfoConstant;
import com.sdp.mc.common.exception.FastSettleLimitException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.intra.web.util.FileUtil;
import com.sdp.mc.service.limitrule.LimitRuleInfoService;
import com.shengpay.commom.config.GlobalConfig;
import com.shengpay.commons.core.utils.NumberUtils;
import com.shengpay.logback.mdc.trace.wrapper.InheritTraceNoRunableWrapper;
/**
 * 商户快速结算额度试算处理线程
 * @author liyantao01
 *
 */
@Service("limitRuleTrialHandler")
public class LimitRuleTrialHandler  {


	protected final ExecutorService pool = Executors.newFixedThreadPool(2);
	@Autowired
	private LimitRuleInfoService limitRuleInfoService;


	private Logger logger = LoggerFactory.getLogger(LimitRuleTrialHandler.class);
	public void execute(String fileName,List<String[]> merchantNoList,String ruleId) {
		logger.info("FastSettleHandler #execute.");
		LimitRuleTrialTask transferIngTask = new LimitRuleTrialTask(fileName,merchantNoList,ruleId);
		pool.execute(new InheritTraceNoRunableWrapper(transferIngTask));
	}


	class LimitRuleTrialTask implements Runnable {

		private Logger logger = LoggerFactory.getLogger(LimitRuleTrialTask.class);

		private String fileName;
		private List<String[]> merchantNoList;
		private String ruleId;



		public LimitRuleTrialTask(String fileName, List<String[]> merchantNoList,
				String ruleId) {
			this.fileName=fileName;
			this.merchantNoList=merchantNoList;
			this.ruleId=ruleId;
		}

		public void run() {
			logger.info("LimitRuleTrialHandler #run,trial file fileName：" +fileName);
			Assert.notNull(merchantNoList);

			StringBuffer buff=new StringBuffer();
			buff.append("商户号,商户类型,快速结算额度,试算消息\n");
			if(merchantNoList!=null&&merchantNoList.size()>1){
				for(int i=0;i<merchantNoList.size();i++){
					String[] arr=merchantNoList.get(i);
					String message="";
					String posMerchantType=" ";
					int fastSettleAmountInt=0;
					if(arr!=null&&arr.length>1){
						String merchantNo=arr[0];//商户号
						if(merchantNo.indexOf(".")>0){
							merchantNo=merchantNo.substring(0,merchantNo.indexOf("."));
						}
						posMerchantType=arr[1];//商户类型
						if(!NumberUtils.isLong( merchantNo)){
							if(i==0){
								continue;
							}else{
								message="商户号格式不正确";
							}
						}else{

							try {
								BigDecimal fastSettleAmount=limitRuleInfoService.cmoputeFastSettleAmount(ruleId, merchantNo,posMerchantType);
								if(fastSettleAmount!=null){
								    fastSettleAmountInt=fastSettleAmount.intValue();
								}
							} catch (FastSettleLimitException e) {
								message=e.getMessage();
							} catch (Exception e) {
								message="试算发生异常";
								logger.error("LimitRuleTrialHandler #error  data merchantNo:"+merchantNo+" posMerchantType:"+posMerchantType, e);
							}
						}
						buff.append(merchantNo+","+posMerchantType+","+(fastSettleAmountInt==0?" ":fastSettleAmountInt)+","+message+"\n");
					}
				}
			}
			String dateStr=DateUtil.date2Str(new Date(), DateUtil.forOrderFormat);
			String name=fileName.substring(0,fileName.lastIndexOf("."));
			String resultFileName="试算结果_"+name+"_"+dateStr+".csv";
			String filePath=GlobalConfig.getString(LimitRuleInfoConstant.LIMIT_RULE_TRIAL_FILE_PATH);
			File trialFile =new File(filePath,resultFileName);
			try {
				FileUtil.WriteFile(trialFile.getAbsolutePath(), buff.toString(), false, "GBK");
			} catch (IOException e) {
				logger.error("LimitRuleTrialHandler#WriteFile is error " + e.getMessage(),e);
			}
			String key=LimitRuleInfoConstant.LIMIT_RULE_TRIAL_KEY_PREFIX+ruleId;
			LimitRuleInfoConstant.LIMIT_RULE_TRIAL_RUELT_MAP.put(key, resultFileName);
			logger.info("LimitRuleTrialHandler #end, result file "+trialFile.getAbsolutePath());

		}


	}
}
