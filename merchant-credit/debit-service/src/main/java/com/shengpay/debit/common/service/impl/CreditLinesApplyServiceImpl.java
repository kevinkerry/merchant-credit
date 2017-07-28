package com.shengpay.debit.common.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.common.lang.StringUtil;
import com.sdo.common.util.DateUtil;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.CreditLevelStatusEnum;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.risk.model.CreditRiskResult;
import com.shengpay.debit.common.risk.model.CreditRiskSubmitRootVO;
import com.shengpay.debit.common.risk.model.GetCreditRiskResponseModel;
import com.shengpay.debit.common.risk.model.ScoreType4Submit;
import com.shengpay.debit.common.service.CreditLinesApplyService;
import com.shengpay.debit.common.service.CreditLinesApplyServiceUtil;
import com.shengpay.debit.common.service.CreditRiskService;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.credit.lines.apply.enums.CreditLinesApplyStatusEnums;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.dataobject.DbRiskRequestLogExample;
import com.shengpay.debit.dal.dataobject.DbRiskRequestLogPO;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoExample;
import com.shengpay.debit.dal.dataobject.DoMeCreditLinesApplyInfoPO;
import com.shengpay.debit.dal.dataobject.DoMerchantApplyFailLogPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyExample;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.daointerface.DoMeCreditLinesApplyInfoDAO;
import com.shengpay.debit.daointerface.DoMerchantCreditLinesApplyDAO;
import com.shengpay.debit.ext.daointerface.ExtDbOrgCreditSettingDAO;
import com.shengpay.debit.ext.daointerface.ExtDbRiskRequestLogDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantApplyFailLogDAO;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.fileManager.FileManagerService;
import com.shengpay.service.mail.AlertMessageSender;

/**
 * 申请额度的sercie
 *
 * @author heyi.alex
 *
 */
@Service
public class CreditLinesApplyServiceImpl implements CreditLinesApplyService {
	private static final Logger log = LoggerFactory.getLogger(CreditLinesApplyServiceImpl.class);

	@Autowired
	private DebitConfigService debitConfigService;

	@Autowired
	private DoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;

	@Autowired
	private DoMeCreditLinesApplyInfoDAO doMeCreditLinesApplyInfoDAO;

	@Autowired
	private CreditRiskService creditRiskService;

	@Autowired
	private ExtDbRiskRequestLogDAO dbRiskRequestLogDAO;

	@Autowired
	private ExtDbOrgCreditSettingDAO dbOrgCreditSettingDAO;

	@Autowired
	private AlertMessageSenderFactory alertMessageSenderFactory;

	@Autowired
	private ConfigOptionManager configOptionManager;

	@Autowired
	private ExtDoMerchantApplyFailLogDAO doMerchantApplyFailLogDAO;

	private String getValue(ConfigEnums enums) {
		return debitConfigService.getByKey(enums);
	}

	/**
	 * 后台运营审核失败退回让用户修改提交资料[e.g.图片不清晰、证件号输入错误]
	 *
	 * @param 商户贷款额度申请id
	 * **/
	public ErrorMessageVO auditFail(Long id, String failReason) {
		ErrorMessageVO validateMessage = this.validateAuditFail(failReason);
		if (!validateMessage.isSuccess()) {
			return validateMessage;
		}
		// 校验商户贷款额度申请单
		DoMerchantCreditLinesApplyPO merchantCreditLinesApply = this.doMerchantCreditLinesApplyDAO.selectByPrimaryKey(id);
		if (merchantCreditLinesApply == null) {
			return new ErrorMessageVO(false, "-1", "商户贷款额度申请不存在");
		}
		if (!CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key.equals(merchantCreditLinesApply.getApplyStatus())) {
			return new ErrorMessageVO(false, "-1", "商户贷款额度申请状态不正确");
		}
		// 审核不通过打回让商户重新修改
		boolean flag = this.auditFailUpdateMerchantCreditLineStatus(id, CreditLinesApplyStatusEnums.USER_INFO_SUBMIT, CreditLinesApplyStatusEnums.USER_MODIFY, failReason);
		if (flag) {
			return new ErrorMessageVO(true, "0", "状态已回退，请通知商户修改资料后重新提交");
		} else {
			return new ErrorMessageVO(false, "-1", "修改失败，请联系开发");
		}
	}

	/**
	 * 后台运营审核将商户资料提交风控计算评级
	 *
	 * @param 商户贷款额度申请id
	 * **/
	public ErrorMessageVO submitCredit(Long id, FileManagerService fileService) {
		// 校验商户贷款额度申请单
		DoMerchantCreditLinesApplyPO merchantCreditLinesApply = this.doMerchantCreditLinesApplyDAO.selectByPrimaryKey(id);
		if (merchantCreditLinesApply == null) {
			return new ErrorMessageVO(false, "-1", "商户贷款额度申请不存在");
		}
		if (!CreditLinesApplyStatusEnums.USER_INFO_SUBMIT.key.equals(merchantCreditLinesApply.getApplyStatus())) {
			return new ErrorMessageVO(false, "-1", "商户贷款额度申请状态不正确");
		}

		// 查询提交到风控的商户资料信息
		DoMeCreditLinesApplyInfoExample example = new DoMeCreditLinesApplyInfoExample();
		DoMeCreditLinesApplyInfoExample.Criteria criteria = example.createCriteria();
		criteria.andLineApplyOrderIdEqualTo(merchantCreditLinesApply.getId());
		List<DoMeCreditLinesApplyInfoPO> mcaList = this.doMeCreditLinesApplyInfoDAO.selectByExample(example);
		if (mcaList == null || mcaList.size() == 0) {
			return new ErrorMessageVO(false, "-1", "商户资料未保存");
		}

		// 讲该申请单下的征信项填充到map里边,key=评分类型+"_"+code
		Map<String, DoMeCreditLinesApplyInfoPO> policyTypes = new HashMap<String, DoMeCreditLinesApplyInfoPO>();
		for (DoMeCreditLinesApplyInfoPO doMeCreditLinesApplyInfoPO : mcaList) {
			String key = doMeCreditLinesApplyInfoPO.getInputKind() + "_" + doMeCreditLinesApplyInfoPO.getInputCode();
			policyTypes.put(key, doMeCreditLinesApplyInfoPO);
		}

		// 查询风控模型
		GetCreditRiskResponseModel creditModel = this.creditRiskService.getCreditRiskModel();
		if (creditModel == null) {
			return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
		}

		CreditRiskSubmitRootVO creditRiskSubmitRoot = new CreditRiskSubmitRootVO();
		creditRiskSubmitRoot.setCode(merchantCreditLinesApply.getMerchantNo());
		creditRiskSubmitRoot.setName(merchantCreditLinesApply.getMerchantName());
		creditRiskSubmitRoot.setType(getValue(ConfigEnums.RISK_OWNER_VALUE));
		creditRiskSubmitRoot.setPolicyCode(getValue(ConfigEnums.RISK_POLICY_VALUE));
		creditRiskSubmitRoot.setCallBackUrl(getValue(ConfigEnums.CREDIT_RISK_NOTIFY_URL));
		try {
			List<ScoreType4Submit> scoreType4SubmitList = CreditLinesApplyServiceUtil.buildScoreType4SubmitListA(policyTypes, creditModel, fileService);
			creditRiskSubmitRoot.addAllPolicyTypes(scoreType4SubmitList);
		} catch (Exception e) {
			log.error("CreditLinesApplyServiceImpl.submitCredit.buildScoreType4SubmitList.error", e);
			return new ErrorMessageVO(false, "-1", e.getMessage());
		}
		try {
			// 将json串更新到数据库
			Long riskRequestLogId = this.saveRiskRequestLogRequest(merchantCreditLinesApply, creditRiskSubmitRoot);
			ErrorMessageVO errorMessage = this.creditRiskService.submitCredit(creditRiskSubmitRoot);
			log.info("CreditLinesApplyServiceImpl.submitCredit,merchantCreditLinesApplyId=" + id + ",responseText=" + ToStringBuilder.reflectionToString(errorMessage));
			// 落地log表的response
			saveRiskRequestLogResponse(riskRequestLogId, errorMessage);
			if (errorMessage.isSuccess()) {
				// 更新贷款申请表的状态
				this.updateMerchantCreditLineStatus(id, CreditLinesApplyStatusEnums.USER_INFO_SUBMIT, CreditLinesApplyStatusEnums.RISK_SUBMIT);
				errorMessage.setErrorMessage("已提交风控，请耐心等待");
			}
			return errorMessage;
		} catch (Exception e) {
			log.error("CreditLinesApplyServiceImpl.submitCredit.error", e);
			return new ErrorMessageVO(false, "-1", "系统繁忙");
		}
	}

	/**
	 * 更新扩展字段
	 * **/
	private Long saveRiskRequestLogRequest(DoMerchantCreditLinesApplyPO merchantCreditLinesApply, CreditRiskSubmitRootVO creditRiskSubmitRoot) {
		JSONObject json = JSONObject.fromObject(creditRiskSubmitRoot);
		String s = StringUtil.substring(json.toString(), 4000);
		DbRiskRequestLogExample example = new DbRiskRequestLogExample();
		DbRiskRequestLogExample.Criteria criteria = example.createCriteria();
		criteria.andLineApplyOrderIdEqualTo(merchantCreditLinesApply.getId());
		List<DbRiskRequestLogPO> listRequestLog = this.dbRiskRequestLogDAO.selectByExample(example);
		if (listRequestLog == null || listRequestLog.size() == 0) {
			DbRiskRequestLogPO record = new DbRiskRequestLogPO();
			record.setLineApplyOrderId(merchantCreditLinesApply.getId());
			record.setRequestMsg(s);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			Long id = this.dbRiskRequestLogDAO.insert(record);
			log.info("CreditLinesApplyServiceImpl.saveRiskRequestLogRequest.insert,id=" + id + ",applyId=" + merchantCreditLinesApply.getId());
			return id;
		} else if (listRequestLog.size() == 1) {
			DbRiskRequestLogPO _record = listRequestLog.get(0);
			criteria.andIdEqualTo(_record.getId());
			DbRiskRequestLogPO record = new DbRiskRequestLogPO();
			record.setRequestMsg(s);
			record.setUpdateTime(new Date());
			this.dbRiskRequestLogDAO.updateByExampleSelective(record, example);
			log.info("CreditLinesApplyServiceImpl.saveRiskRequestLogRequest.update,id=" + _record.getId() + ",applyId=" + merchantCreditLinesApply.getId());
			return _record.getId();
		}
		return null;
	}

	private boolean saveRiskRequestLogResponse(Long id, ErrorMessageVO errorMessage) {
		DbRiskRequestLogExample example = new DbRiskRequestLogExample();
		DbRiskRequestLogExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		DbRiskRequestLogPO record = new DbRiskRequestLogPO();
		record.setResponseMsg(JSONObject.fromObject(errorMessage).toString());
		record.setResponseStatus(errorMessage.getErrorCode());
		record.setUpdateTime(new Date());
		int rows = this.dbRiskRequestLogDAO.updateByExampleSelective(record, example);
		log.info("CreditLinesApplyServiceImpl.saveRiskRequestLogResponse.update,id=" + id + ",rows=" + rows + ",errorMessage=" + ToStringBuilder.reflectionToString(errorMessage));
		return rows == 1;
	}

	/**
	 * 提交更新状态
	 * **/
	private boolean updateMerchantCreditLineStatus(Long id, CreditLinesApplyStatusEnums originalStatus, CreditLinesApplyStatusEnums targetStatus) {
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andApplyStatusEqualTo(originalStatus.key);
		DoMerchantCreditLinesApplyPO record = new DoMerchantCreditLinesApplyPO();
		record.setApplyStatus(targetStatus.key);
		record.setPolicyStartTime(new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		record.setPolicyEndTime(cal.getTime());
		// 后台提交到风控时间
		record.setApplyRiskTime(new Date());
		record.setUpdateTime(new Date());
		int rows = this.doMerchantCreditLinesApplyDAO.updateByExampleSelective(record, example);
		log.info("CreditLinesApplyServiceImpl.updateMerchantCreditLineStatus,id=" + id + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * 打回操作状态更新状态
	 * **/
	private boolean auditFailUpdateMerchantCreditLineStatus(Long id, CreditLinesApplyStatusEnums originalStatus, CreditLinesApplyStatusEnums targetStatus, String failReason) {
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andApplyStatusEqualTo(originalStatus.key);
		DoMerchantCreditLinesApplyPO record = new DoMerchantCreditLinesApplyPO();
		record.setApplyStatus(targetStatus.key);
		record.setIsAgnetGuarantee("");
		Date policyStartTime = com.sdp.mc.common.util.DateUtil.formatWithNoTime(new Date());
		record.setPolicyStartTime(policyStartTime);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		Date policyEndTime = com.sdp.mc.common.util.DateUtil.formatWithNoTime(cal.getTime());
		record.setPolicyEndTime(policyEndTime);
		// 后台提交到风控时间
		record.setApplyRiskTime(new Date());
		record.setUpdateTime(new Date());
		int rows = this.doMerchantCreditLinesApplyDAO.updateByExampleSelective(record, example);
		log.info("CreditLinesApplyServiceImpl.updateMerchantCreditLineStatus,id=" + id + ",rows=" + rows);
		if (rows == 1) {
			DoMerchantApplyFailLogPO failLog = new DoMerchantApplyFailLogPO();
			failLog.setApplyId(id);
			failLog.setCreateTime(new Date());
			failLog.setFailReason(failReason);
			failLog.setUpdateTime(new Date());
			doMerchantApplyFailLogDAO.insert(failLog);
		}
		return rows == 1;
	}

	private ErrorMessageVO validateAuditFail(String failReason) {
		if (StringUtils.isBlank(failReason)) {
			return new ErrorMessageVO(false, "-1", "请填写打回原因");
		}
		return new ErrorMessageVO(true, "0", "验证通过");
	}

	/**
	 * 更新状态
	 * **/
	public boolean updateMerchantCreditLineStatusJob(Long id, CreditLinesApplyStatusEnums originalStatus, CreditLinesApplyStatusEnums targetStatus) {
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andApplyStatusEqualTo(originalStatus.key);
		DoMerchantCreditLinesApplyPO record = new DoMerchantCreditLinesApplyPO();
		record.setApplyStatus(targetStatus.key);
		record.setIsAgnetGuarantee("0");// job处理的数据都是不担保
		int rows = this.doMerchantCreditLinesApplyDAO.updateByExampleSelective(record, example);
		log.info("CreditLinesApplyServiceImpl.updateMerchantCreditLineStatus,id=" + id + ",rows=" + rows);
		return rows == 1;
	}

	/**
	 * job同步风控评级结果
	 * **/
	public void syncCreditRiskResult4Job() {
		// 查询状态是"提交风控完毕"的贷款申请记录
		DoMerchantCreditLinesApplyExample example = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria = example.createCriteria();
		criteria.andApplyStatusEqualTo(CreditLinesApplyStatusEnums.RISK_SUBMIT.key);
		List<DoMerchantCreditLinesApplyPO> listMerchantCreditLinesApply = this.doMerchantCreditLinesApplyDAO.selectByExample(example);
		if (listMerchantCreditLinesApply != null) {
			for (DoMerchantCreditLinesApplyPO merchantCreditLinesApply : listMerchantCreditLinesApply) {
				// 调用风控系统接口,同步商户号的评级结果
				CreditRiskResult crr = this.creditRiskService.getCreditScore(merchantCreditLinesApply.getMerchantNo());
				log.info("CreditLinesApplyServiceImpl.getCreditScore,applyId=" + merchantCreditLinesApply.getId() + ",crr=" + ToStringBuilder.reflectionToString(crr));
				// 处理中直接返回
				if (CreditLevelStatusEnum.PROCESSING.code.equals(crr.getStatus())) {
					log.info("CreditLinesApplyServiceImpl.syncCreditRiskResult4Job,merchantNo=" + merchantCreditLinesApply.getMerchantNo() + ",risk.level.processing");
					continue;
				}
				// 如果状态是空则表示调用风控系统返回结果是异常应答，就不做后续处理，job或者风控通知接口可以再次补单处理
				if (StringUtils.isNotBlank(crr.getStatus())) {
					this.syncCreditRiskResult(merchantCreditLinesApply, crr);
				} else {
					// 异常应答打印出日志
					log.error("CreditLinesApplyServiceImpl.syncCreditRiskResult4Job.merchantNo" + merchantCreditLinesApply.getMerchantNo()
							+ ",credit risk result is exception response");
				}
			}
		}
	}

	/**
	 * 同步风控评级结果,贷款额度申请流程
	 * **/
	public boolean syncCreditRiskResult(DoMerchantCreditLinesApplyPO merchantCreditLinesApply, CreditRiskResult crr) {
		log.info("CreditLinesApplyServiceImpl.syncCreditRiskResult,crr=" + ToStringBuilder.reflectionToString(crr));
		/** 风控日志表操作 **/
		// 查询出请求风控系统日志，修改响应信息
		DbRiskRequestLogExample example = new DbRiskRequestLogExample();
		DbRiskRequestLogExample.Criteria criteria = example.createCriteria();
		criteria.andLineApplyOrderIdEqualTo(merchantCreditLinesApply.getId());
		List<DbRiskRequestLogPO> listRequestLog = this.dbRiskRequestLogDAO.selectByExample(example);
		if (listRequestLog != null && listRequestLog.size() == 1) {
			DbRiskRequestLogPO record = new DbRiskRequestLogPO();
			record.setNotifyMsg(JSONObject.fromObject(crr).toString());
			record.setNotifyStatus(crr.getErrorCode());
			record.setNotifyTime(new Date());
			record.setUpdateTime(new Date());
			int rows = this.dbRiskRequestLogDAO.updateByExampleSelective(record, example);
			log.info("CreditLinesApplyServiceImpl.syncCreditRiskResult,RiskRequestLogId=" + listRequestLog.get(0).getId() + ",rows=" + rows);
		}
		// 能够放贷的商户评级要求是A、B、C三个等级
		CreditLinesApplyStatusEnums status = CreditLinesApplyStatusEnums.APPLY_FAIL;
		BigDecimal debitAmountLimit = null;
		if (CreditLevelStatusEnum.SUCCESS.code.equals(crr.getStatus())) {
			// 1、查询贷款机构及其级别对应的贷款额度
			DbOrgCreditSettingPO orgCreditSetting = this.dbOrgCreditSettingDAO.selectByRiskLevel(DebitOrganizationEnum.SFT.code, crr.getLevel());
			if (orgCreditSetting.getAmountLimit() == null) {
				// 如果机构的信用级别配置错误,邮件提醒
				StringBuilder sb = new StringBuilder();
				sb.append("机构码:").append(merchantCreditLinesApply.getOrganizationCode());
				sb.append(",商户号:").append(merchantCreditLinesApply.getMerchantNo());
				sb.append(",商户名称:").append(merchantCreditLinesApply.getMerchantName());
				sb.append(",信用评级:").append(crr.getLevel());
				sb.append(",状态:").append(crr.getStatus());
				this.sendMail("机构未给信用评级配置信用额度", sb.toString());
				return false;
			} else if (orgCreditSetting.getAmountLimit() != null && orgCreditSetting.getAmountLimit().compareTo(BigDecimal.valueOf(0)) > 0) {
				status = CreditLinesApplyStatusEnums.RISK_NOTIFY;
				debitAmountLimit = orgCreditSetting.getAmountLimit();
			}
		}
		/** 额度申请表操作 **/
		// 2、修改贷款申请状态、级别、额度、确认时间
		DoMerchantCreditLinesApplyPO newDoMerchantCreditLinesApply = new DoMerchantCreditLinesApplyPO();
		newDoMerchantCreditLinesApply.setApplyStatus(status.key);
		newDoMerchantCreditLinesApply.setRiskLevel(crr.getLevel());
		newDoMerchantCreditLinesApply.setLendAmount(debitAmountLimit);
		newDoMerchantCreditLinesApply.setRiskAnswerTime(new Date());
		newDoMerchantCreditLinesApply.setUpdateTime(new Date());
		// 格式化日期
		Date expireDate = DateUtil.parseDateNewFormat(crr.getExpireDate());
		Date policyEndTime = com.sdp.mc.common.util.DateUtil.formatWithNoTime(expireDate);
		newDoMerchantCreditLinesApply.setPolicyEndTime(policyEndTime);
		DoMerchantCreditLinesApplyExample example3 = new DoMerchantCreditLinesApplyExample();
		DoMerchantCreditLinesApplyExample.Criteria criteria3 = example3.createCriteria();
		criteria3.andIdEqualTo(merchantCreditLinesApply.getId());
		criteria3.andApplyStatusEqualTo(CreditLinesApplyStatusEnums.RISK_SUBMIT.key);
		int rows = this.doMerchantCreditLinesApplyDAO.updateByExampleSelective(newDoMerchantCreditLinesApply, example3);
		log.info("CreditLinesApplyServiceImpl.syncCreditRiskResult,applyId=" + merchantCreditLinesApply.getId() + ",rows=" + rows);
		return status == CreditLinesApplyStatusEnums.RISK_NOTIFY;
	}

	private void sendMail(final String title, final String content) {
		try {
			final String mailList = ConfigOptionHelper.getConfigByKey(MerchantCreditConstant.TTD_FOS_PROCESSING_MAIL_LIST);
			if (StringUtils.isBlank(mailList)) {
				log.error("CreditLinesApplyServiceImpl.sendMail.error,mail list is not configured");
				return;
			}
			Thread t = new Thread() {
				public void run() {
					AlertMessageSender sender = alertMessageSenderFactory.getAlertMessageSender(AlertMessageSendTypeEnum.MAIL_ALERT);
					sender.sendMessage(title, content, mailList);
				}
			};
			t.start();
		} catch (Exception e) {
			log.error("FOSFacadeImpl.sendMail.error,content=" + content, e);
		}
	}

	@Override
	public void updateMerchantCreditLineStatusJob(Map<String, Object> maps) {
		try {
			this.doMerchantCreditLinesApplyDAO.updateMerchantCreditLineStatusJob(maps);
		} catch (Exception e) {
			log.error("updateMerchantCreditLineStatusJob.error", e);
		}

	}
	@Override
	public void updateByPrimaryKeySelective(DoMerchantCreditLinesApplyPO record){
		this.doMerchantCreditLinesApplyDAO.updateByPrimaryKeySelective(record);
	}

}
