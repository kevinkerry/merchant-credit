package com.shengpay.service.message;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.bean.MessageTemplateBean;
import com.sdp.mc.newt0.dao.MessageTemplateDO;
import com.sdp.mc.newt0.dao.MessageTemplateDOExample;
import com.sdp.mc.newt0.dao.SendMessageLogDO;
import com.sdp.mc.newt0.dao.SendMessageLogDOExample;
import com.sdp.mc.newt0.manager.MessageTemplateManager;
import com.sdp.mc.newt0.manager.SendMessageLogManager;
import com.sdp.mc.newt0.manager.impl.ext.ExtMessageTemplateManagerImpl;
import com.shengpay.service.message.dto.MessageResultDTO;
import com.shengpay.service.message.http.HttpHelper;
import com.shengpay.service.message.http.HttpHelper.RequestParam;
import com.shengpay.service.message.http.HttpHelper.RequestType;
import com.shengpay.service.message.http.RequestResponse;
/**
 *
 * 功能描述：短信服务接口实现
 * @author zhangyulong
 * time : 2015-9-14 下午5:03:03
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{
    protected final static Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
    @Value("${sms.pid}")
    private String smsPid;

    @Value("${sms.pwd}")
    private String smsPwd;

    @Value("${sms.url}")
    private String smsUrl;

    @Autowired
    private MessageTemplateManager messageTemplateManager;
    @Autowired
    private ExtMessageTemplateManagerImpl extMessageTemplateManagerImpl;
    @Autowired
    private SendMessageLogManager sendMessageLogManager;


    private static ExecutorService executorService = Executors.newFixedThreadPool(3);
    public void sendMessage(final List<String> toUserList, final String templateCode, final Map<String, String> paramMap){

    	Thread t = new Thread() {
    		public void run() {
    			send(toUserList, templateCode, paramMap);
    		}
    	};
    	executorService.execute(t);
    }

    public void sendOneMessage(final String phone, final String templateCode, final Map<String, String> paramMap){

    	Thread t = new Thread() {
    		public void run() {
    			List<String> toUserList = new ArrayList<String>();
    			if(StringUtils.isNotBlank(phone)){
    				toUserList.add(phone);
    			}
    			send(toUserList, templateCode, paramMap);
    		}
    	};
    	executorService.execute(t);
    }

    private void send(List<String> toUserList, String templateCode, Map<String, String> paramMap) {
        //基本非空校验
        String baseCheckResult = baseCheck(toUserList, templateCode, paramMap);
        if(StringUtils.isNotBlank(baseCheckResult)){
            log.error(baseCheckResult);
        }
        MessageResultDTO resultDTO = null;
        //循环手机号发送短信
        for(int i = 0; i < toUserList.size(); i++){
            try{
                    resultDTO = sendMessage(toUserList.get(i), templateCode, paramMap);
                    if(StringUtils.isNotBlank(resultDTO.getResultCode()) && resultDTO.getResultCode().equals("0")){
                        log.error("发送至" + toUserList.get(i) + "信息失败,失败原因："+resultDTO.getResultMessage());
                        SendMessageLogDO record = new SendMessageLogDO();
                        record.setCreatedAt(new Date());
                        record.setPhone(toUserList.get(i));
                        record.setSendResultInfo("发送至" + toUserList.get(i) + "信息失败,失败原因："+resultDTO.getResultMessage());
                        record.setSendState("0#发送失败");
                        record.setTemplateCode(templateCode);
                        if(StringUtils.isNotBlank(resultDTO.getExtResultMessage())){
                        	record.setMessageInfo(resultDTO.getExtResultMessage());
                        }
                        record.setUpdatedAt(new Date());
                        this.sendMessageLogManager.insertSelective(record);
                        continue;
                    }
                }catch(Exception e){
                    log.error("发送至" + toUserList.get(i) + "信息失败",e);
                    SendMessageLogDO record = new SendMessageLogDO();
                    record.setCreatedAt(new Date());
                    record.setPhone(toUserList.get(i));
                    record.setSendResultInfo("发送至" + toUserList.get(i) + "信息失败,失败原因：系统异常");
                    record.setSendState("0#发送失败");
                    if(resultDTO != null && StringUtils.isNotBlank(resultDTO.getExtResultMessage())){
                    	record.setMessageInfo(resultDTO.getExtResultMessage());
                    }
                    record.setTemplateCode(templateCode);
                    record.setUpdatedAt(new Date());
                    this.sendMessageLogManager.insertSelective(record);
                    continue;
                }

            }


        return;
    }

    /**
     * 发送短信
     * @param phone
     * @param templateCode
     * @param paramMap
     * @return
     */
    private MessageResultDTO sendMessage(String phone,String templateCode, Map<String, String> paramMap){
    	MessageResultDTO resultDTO = new MessageResultDTO();
        if (!isInt(phone) || phone.length() < 6) {
                log.error("短信 >> 发送短信失败，无效的手机号码." + phone);
                resultDTO.setResultCode("0");
                resultDTO.setResultMessage("无效的手机号码");
                return resultDTO;
            }
        //查询模板
        MessageTemplateDO messageTemplateDO = getMessageTemplate(templateCode);
        if(messageTemplateDO == null){
            log.error("没有配置短信模板");
            resultDTO.setResultCode("0");
            resultDTO.setResultMessage("没有配置短信模板");
            return resultDTO;
        }

        String messageTemplate = messageTemplateDO.getTemplateInfo();
        String messageSendRule = messageTemplateDO.getSendRule();
        //替换短信模板参数
        String messageInfo = getMessageInfoByParam(paramMap, messageTemplate);
        if(StringUtils.isBlank(messageInfo)){
            log.error("替换模板参数失败");
            resultDTO.setResultCode("0");
            resultDTO.setResultMessage("替换模板参数失败");
            return resultDTO;
        }
        //校验规则
        if(StringUtils.isNotBlank(messageSendRule)){
            String ruleResult = checkRule(phone, templateCode, messageInfo,messageSendRule);
            if(StringUtils.isNotBlank(ruleResult)){
            	  resultDTO.setResultCode("0");
                  resultDTO.setResultMessage(ruleResult);
                  resultDTO.setExtResultMessage(messageInfo);
                  return resultDTO;
            }
        }

        RequestParam[] params = {
                // new RequestParam("userAddr", "pwd"), 该值可为空
                new RequestParam("pid", smsPid), new RequestParam("pwd", smsPwd),
                new RequestParam("phone", phone),
                new RequestParam("msg", encode(messageInfo, "UTF-8"))
        };

        /**
         * 调短信网关发送消息
         */
        RequestResponse rp = HttpHelper.getInstance().execute(smsUrl, RequestType.GET, params);

        if (rp == null) {
            log.error("发送短信：send SMS error. to phone :" + phone + "\n 内容：" + messageInfo);
            resultDTO.setResultCode("0");
            resultDTO.setResultMessage("发送短信：send SMS error. to phone :" + phone);
            resultDTO.setExtResultMessage(messageInfo);
            return resultDTO;
        } else {
            log.info("MessageServiceImpl rp code: " + rp.getResponseCode() + "。 Content : " +
                    rp.getContent());
            SendMessageLogDO record = new SendMessageLogDO();
            record.setCreatedAt(new Date());
            record.setMessageInfo(messageInfo);
            record.setPhone(phone);
            record.setSendResultInfo("发送至" + phone + "信息成功");
            record.setSendState("1#发送成功");
            record.setTemplateCode(templateCode);
            record.setUpdatedAt(new Date());
            this.sendMessageLogManager.insertSelective(record);
        }
        resultDTO.setResultCode("1");
        resultDTO.setResultMessage("发送短信成功");
        return resultDTO;
    }


    /**
     * 1.若短信模板中没有含有${}，则直接返回
     * 2.短信模板中含有${}，进行替换
     * @param paramObj
     * @param messageContext
     * @return
     */
    private String getMessageInfoByParam(Map<String, String> paramMap, String messageTemplate){

        if(!messageTemplate.contains("${")){
            return messageTemplate;
        }
        if(paramMap == null || paramMap.isEmpty()){
        	return "";
        }
        for (Iterator<Map.Entry<String, String>> iterator = paramMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, String> entry = iterator.next();

            messageTemplate = messageTemplate.replaceAll("\\$\\{" + entry.getKey() + "\\}", entry.getValue());
        }
        //参数不足以替换模板中全部变量
        if(Pattern.compile("\\$\\{\\w+\\}").matcher(messageTemplate).find()){
            return "";
        }
        return messageTemplate;
    }

    /**
     * 规则校验
     * @param phone
     * @param messageInfo
     * @param messageSendRule
     * @return
     */
    private String checkRule(String phone, String templateCode, String messageInfo,String messageSendRule){
        //查询日志表 增加模板防止多个活动短信与手机相同
        List<SendMessageLogDO> logList = getSendMessageLog(phone, templateCode, messageInfo);
        //如果第一次发，则不进行校验
        if(logList==null || logList.size() < 1){
            return "";
        }
        JSONObject rule = JSONObject.fromObject(messageSendRule);
        Calendar now = Calendar.getInstance();
        String sendUnit = (String) rule.get("sendUnit");
        String amount = (String) rule.get("amount");
        String interval = (String) rule.get("interval");

        String checkJsonResult = checkRuleJson(sendUnit, amount, interval);
        if(StringUtils.isNotBlank(checkJsonResult)){
            return checkJsonResult;
        }
        //全为空也不校验
        if(StringUtils.isBlank(sendUnit) && StringUtils.isBlank(amount) && StringUtils.isBlank(interval)){
            return "";
        }
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;
        int nowDay = now.get(Calendar.DAY_OF_MONTH);
        int nowHour = now.get(Calendar.HOUR_OF_DAY);
        int dayTypeSum = 0;
        int yearTypeSum = 0;
        int monthTypeSum = 0;
        int hourTypeSum = 0;

        //查询最近一次发送,取得时间
        Date lastSendDate = logList.get(0).getCreatedAt();
        if (StringUtils.isNotBlank(interval)) {
           long actualInteeval = getTimeDelta(new Date(), lastSendDate);
           if(actualInteeval <= Long.parseLong(interval)){
               return "同一短信两次发送间隔时间需要大于" + interval + "秒";
           }
        }
        if (StringUtils.isNotBlank(sendUnit) && isInt(amount) && Integer.parseInt(amount) > 0) {
            if (sendUnit.equals("D")) {
                //循环取得日志list中数据的日期，如果日期的年，月，天等于nowYear，nowMonth，nowDay,则
                for(SendMessageLogDO sendMessageDO : logList){
                    Date createdAt = sendMessageDO.getCreatedAt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(createdAt);
                    if(calendar.get(Calendar.YEAR) == nowYear &&
                            (calendar.get(Calendar.MONTH)+1) == nowMonth
                            && calendar.get(Calendar.DAY_OF_MONTH) == nowDay){
                        dayTypeSum++;
                    }
                }
                if (dayTypeSum >= Integer.parseInt(amount)) {
                    return "当天本条短信发送至" +phone+ "已超过限制";
                }
            } else if (sendUnit.equals("Y")) {
                //循环取得日志list中数据的日期，如果日期的年等于nowYear,则
                for(SendMessageLogDO sendMessageDO : logList){
                    Date createdAt = sendMessageDO.getCreatedAt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(createdAt);
                    if(calendar.get(Calendar.YEAR) == nowYear){
                        yearTypeSum++;
                    }
                }
                if (yearTypeSum >= Integer.parseInt(amount)) {
                    return "本年内本条短信发送至" +phone+ "已超过限制";
                }
            } else if (sendUnit.equals("M")) {
                //循环取得日志list中数据的日期，如果日期的年，月等于nowYear,nowMonth则
                for(SendMessageLogDO sendMessageDO : logList){
                    Date createdAt = sendMessageDO.getCreatedAt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(createdAt);
                    if(calendar.get(Calendar.YEAR) == nowYear &&
                            (calendar.get(Calendar.MONTH)+1) == nowMonth){
                        monthTypeSum++;
                    }
                }
                if (monthTypeSum >= Integer.parseInt(amount)) {
                    return "本月内本条短信发送至" +phone+ "已超过限制";
                }
            } else if (sendUnit.equals("H")) {
                //循环取得日志list中数据的日期，如果日期的年，月,日，时等于nowYear,nowMonth，nowDay，nowHour则
                for(SendMessageLogDO sendMessageDO : logList){
                    Date createdAt = sendMessageDO.getCreatedAt();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(createdAt);
                    if(calendar.get(Calendar.YEAR) == nowYear &&
                            (calendar.get(Calendar.MONTH)+1) == nowMonth
                            && calendar.get(Calendar.DAY_OF_MONTH) == nowDay &&
                            calendar.get(Calendar.HOUR_OF_DAY) == nowHour){
                        hourTypeSum++;
                    }
                }
                if (hourTypeSum >= Integer.parseInt(amount)) {
                    return "本小时内本条短信发送至" +phone+ "已超过限制";
                }
            } else {
                return "规则配置有误";
            }
        }
        return "";
    }

    /**
     * 校验是否为数字
     * @param value
     * @return
     */
    private boolean isInt(String value) {
        if (value == null || value.trim().length() == 0) {
            return false;
        }
        return (Pattern.matches("[\\d]+", value));
    }

    /**
     * 编码转换
     * @param txt
     * @param charset
     * @return
     */
    private String encode(String txt, String charset) {
        try {
            return URLEncoder.encode(txt, charset);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 两个时间相差多少秒
     * @param date1
     * @param date2
     * @return
     */
    private long getTimeDelta(Date date1,Date date2){
        long timeDelta=(date1.getTime()-date2.getTime())/1000;//单位是秒
//        long secondsDelta=timeDelta>0?(long)timeDelta:(long)Math.abs(timeDelta);
        return timeDelta;
    }
    /**
     * 基本校验
     * @param toUserList
     * @param templateCode
     * @param paramMap
     * @return
     */
    private String baseCheck(List<String> toUserList, String templateCode, Map<String, String> paramMap){
        if(toUserList == null || toUserList.size() < 1){
        	log.info("MessageServiceImpl.baseCheck: phone is null,time: "+new Date());
            return "短信号码为空";
        }
        if(StringUtils.isBlank(templateCode)){
        	log.info("MessageServiceImpl.baseCheck: templateCode is null,time: "+new Date());
            return "短信模板编码为空";
        }
        return "";
    }

    /**
     * 查询短信模板
     * @param templateCode
     * @return
     */
    private MessageTemplateDO getMessageTemplate(String templateCode){
        MessageTemplateDOExample example = new MessageTemplateDOExample();
        example.createCriteria().andTemplateCodeEqualTo(templateCode);
        List<MessageTemplateDO> list = this.messageTemplateManager.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 查询发送成功消息记录(已排序)
     * @param phone
     * @param templateCode
     * @param messageInfo
     * @return
     */
    private List<SendMessageLogDO> getSendMessageLog(String phone, String templateCode, String messageInfo){
        SendMessageLogDOExample example = new SendMessageLogDOExample();
        example.createCriteria().andPhoneEqualTo(phone).andTemplateCodeEqualTo(templateCode).andMessageInfoEqualTo(messageInfo).andSendStateEqualTo("1#发送成功");
        example.setOrderByClause(" CREATED_AT DESC ");
        List<SendMessageLogDO> list = this.sendMessageLogManager.selectByExample(example);
        return list;
    }

    /**
     * 校验规则配置
     * @param sendUnit
     * @param amount
     * @param sinterval
     * @return
     */
    private String checkRuleJson(String sendUnit, String amount, String sinterval){

        if(StringUtils.isBlank(sendUnit) && StringUtils.isNotBlank(amount)){
            return "短信发送类型为空，则发送次数一定为空";
        }else if(StringUtils.isNotBlank(sendUnit) && StringUtils.isBlank(amount)){
            return "短信发送类型不为空，则发送次数一定不为空";
        }else{
            return "";
        }
    }
    /**
     * 查询短信模板
     * @param example
     * @return
     * @throws Exception  数据库操作异常
     */
    @Override
    public List<MessageTemplateDO> selectMsgTemplateList(MessageTemplateBean queryBean) throws Exception{
    	try {
    		return extMessageTemplateManagerImpl.selectByQuery(queryBean);
		} catch (Exception e) {
			log.error("MessageServiceImpl#selectMsgTemplateList is error",e);
			throw e;
		}

    }
    /**
     * 更新短信模板 只能修改标题，内容
     * @param example
     * @throws Exception
     */
    @Override
    public boolean  updateMsgTemplate(MessageTemplateDO record) throws Exception{
    	try {
    		record.setUpdatedAt(new Date());
        	int rows=messageTemplateManager.updateByPrimaryKeySelective(record);
        	return rows>0?true:false;
		} catch (Exception e) {
			log.error("MessageServiceImpl#selectMsgTemplateList is error",e);
			throw e;
		}


    }

	@Override
	public MessageTemplateDO selectByPrimaryKey(Long id) throws Exception {
	 try {
		return messageTemplateManager.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.error("MessageServiceImpl#selectMsgTemplateList is error",e);
			throw e;
		}
	}
}
