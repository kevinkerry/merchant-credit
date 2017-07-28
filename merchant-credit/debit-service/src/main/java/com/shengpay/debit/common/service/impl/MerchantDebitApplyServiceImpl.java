package com.shengpay.debit.common.service.impl;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.sdp.mc.common.enums.FosPaymentStateEnums;
import com.sdp.mc.common.enums.UserOperaRecordEnum;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.integration.fos.dto.request.DebitTransferRequestDTO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDO;
import com.sdp.mc.newt0.dao.NewT0UserOperaRecordDOExample;
import com.sdp.mc.newt0.dao.daointerface.NewT0UserOperaRecordDAO;
import com.shengpay.debit.common.enums.AgentProfitStatusEnum;
import com.shengpay.debit.common.enums.ConfigEnums;
import com.shengpay.debit.common.enums.DebitOrganizationEnum;
import com.shengpay.debit.common.enums.LoanOperaTypeEnum;
import com.shengpay.debit.common.enums.MerchantDebitOrderStatusEnums;
import com.shengpay.debit.common.service.DebitConfigService;
import com.shengpay.debit.common.service.MerchantDebitApplyService;
import com.shengpay.debit.common.service.MerchantDebitInfoService;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingExample;
import com.shengpay.debit.dal.dataobject.DbOrgCreditSettingPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoExample;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitInfoPO;
import com.shengpay.debit.dal.dataobject.DmMerchantDebitLogInfoPO;
import com.shengpay.debit.dal.dataobject.DoAgentProfitPO;
import com.shengpay.debit.dal.dataobject.DoMerchantCreditLinesApplyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderExample;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;
import com.shengpay.debit.daointerface.DmMerchantDebitLogInfoDAO;
import com.shengpay.debit.daointerface.DoAgentProfitDAO;
import com.shengpay.debit.ext.daointerface.ExtDbOrgCreditSettingDAO;
import com.shengpay.debit.ext.daointerface.ExtDmMerchantDebitInfoDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantCreditLinesApplyDAO;
import com.shengpay.debit.ext.daointerface.ExtDoMerchantDebitOrderDAO;
import com.shengpay.debit.merchant.account.enums.DebitAccountEnums;
import com.shengpay.debit.merchant.account.enums.MerchantDebitLogOperateTypeEnum;
import com.shengpay.facade.fos.FOSFacade4Debit;

/**
 * 申请借款
 */
@Service
public class MerchantDebitApplyServiceImpl implements MerchantDebitApplyService {

	@Autowired
	private ExtDmMerchantDebitInfoDAO dmMerchantDebitInfoDAO;
	@Autowired
	private ExtDoMerchantDebitOrderDAO extDoMerchantDebitOrderDAO;
	@Autowired
	private DmMerchantDebitLogInfoDAO dmMerchantDebitLogInfoDAO;
	@Autowired
	private ExtDbOrgCreditSettingDAO dbOrgCreditSettingDAO;
	@Autowired
	private FOSFacade4Debit FOSFacade4Debit;
	@Autowired
	private MerchantDebitInfoService merchantDebitInfoService;
	@Autowired
	private DoAgentProfitDAO doAgentProfitDAO;
	@Autowired
	private DebitConfigService debitConfigService;
	@Autowired
	private ExtDoMerchantCreditLinesApplyDAO doMerchantCreditLinesApplyDAO;
	@Autowired
	private NewT0UserOperaRecordDAO newT0UserOperaRecordDAO;

	private static Logger log = LoggerFactory.getLogger(MerchantDebitApplyServiceImpl.class);

	// private static ExecutorService executorService =
	// Executors.newFixedThreadPool(10);

	@Override
	public ErrorMessageVO applyResutl(Long id, ModelMap map) {
		if (id == null) {
			return new ErrorMessageVO(false, "", "id为空");
		}
		DoMerchantDebitOrderPO debitOrder = extDoMerchantDebitOrderDAO.selectByPrimaryKey(id);
		if (debitOrder == null) {
			return new ErrorMessageVO(false, "", "未找到相应记录");
		}
		map.put("status", debitOrder.getStatus());
		if (MerchantDebitOrderStatusEnums.LOAN_REVIEW.getKey().equals(debitOrder.getStatus())) {// 待审核
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP2_TIP));
		} else if (MerchantDebitOrderStatusEnums.LOANING.getKey().equals(debitOrder.getStatus())) {// 当是待审核
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP2_TIP));
		} else if (MerchantDebitOrderStatusEnums.LOAN_ERROR.getKey().equals(debitOrder.getStatus())) {// 出错
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP3_ERROR_TIP));
		} else if (MerchantDebitOrderStatusEnums.LOAN_REVIEW_REFUSE.getKey().equals(debitOrder.getStatus())) {// 拒绝
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP3_REFUSE_TIP));
		} else if (MerchantDebitOrderStatusEnums.PAYBACKING.getKey().equals(debitOrder.getStatus())) {// 成功
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP3_SUCCESS_TIP));
		} else {// 申请提示
			map.put("tip", this.debitConfigService.getByKey(ConfigEnums.DEBIT_LOAN_STEP1_TIP));
		}
		return new ErrorMessageVO(true, "", "成功");
	}

	@Override
	public DmMerchantDebitInfoPO queryDebitMerchantDebitInfo(String merchantNo) {
		DmMerchantDebitInfoExample example = new DmMerchantDebitInfoExample();
		DmMerchantDebitInfoExample.Criteria criteria = example.createCriteria();
		criteria.andMerchantNoEqualTo(merchantNo);
		List<DmMerchantDebitInfoPO> list = dmMerchantDebitInfoDAO.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 借款申请
	 */
	@Override
	@Transactional("debitTransactionManager")
	public ErrorMessageVO debitApply(DoMerchantDebitOrderPO record, boolean isAgentGuarantee, MCMerchantUser user) {
		// 落地借款订单
		Long id = extDoMerchantDebitOrderDAO.insert(record);
		// 冻结申请额度
		DmMerchantDebitInfoPO merchantDebitInfo = merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(record.getMerchantNo(), DebitOrganizationEnum.SFT);
		BigDecimal beforeAmount = merchantDebitInfo.getCanUseAmount();
		int row = dmMerchantDebitInfoDAO.freezeMerchantDebit(record.getMerchantNo(), DebitAccountEnums.ACCOUNT_CAN_USE.getKey(), record.getDebitAmount());
		DmMerchantDebitInfoPO afterMerchantDebitInfo = merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(record.getMerchantNo(), DebitOrganizationEnum.SFT);
		DmMerchantDebitLogInfoPO debitLogInfoPO = new DmMerchantDebitLogInfoPO();
		debitLogInfoPO.setMerchantNo(record.getMerchantNo());
		debitLogInfoPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
		debitLogInfoPO.setBeforeAmount(beforeAmount);
		debitLogInfoPO.setAfterAmount(afterMerchantDebitInfo.getCanUseAmount());
		debitLogInfoPO.setAmount(record.getDebitAmount());
		debitLogInfoPO.setOperateType(MerchantDebitLogOperateTypeEnum.BORROWING.code);
		debitLogInfoPO.setCreateTime(new Date());
		debitLogInfoPO.setUpdateTime(new Date());
		dmMerchantDebitLogInfoDAO.insert(debitLogInfoPO);
		if (row != 1 || id == null) {
			return new ErrorMessageVO(false, "-1", "借款失败，请稍后再试");
		} else {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			// 更新订单状态为借款放款审核中，待后台清算放款
			updateByDebitOrderId(id, MerchantDebitOrderStatusEnums.LOAN_REVIEW.getKey());
			return new ErrorMessageVO(true, "0", "借款申请成功", param);
		}

	}

	/**
	 * 插入代理商分润记录
	 * **/
	private void insertDoAgentProfit(DoMerchantDebitOrderPO debitOrder) {
		DoAgentProfitPO record = new DoAgentProfitPO();
		record.setBorrowOrderId(debitOrder.getId().toString());
		record.setAmount(debitOrder.getDebitAmount());
		record.setPromoterNo(debitOrder.getPromoterNo());
		record.setStatus(AgentProfitStatusEnum.INIT.code);
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		doAgentProfitDAO.insert(record);
	}

	private Long merchantDebitLog(DoMerchantDebitOrderPO record, DmMerchantDebitInfoPO debitInfo) {
		DmMerchantDebitLogInfoPO debitLogInfoPO = new DmMerchantDebitLogInfoPO();
		debitLogInfoPO.setMerchantNo(record.getMerchantNo());
		debitLogInfoPO.setOrganizationCode(debitInfo.getOrganizationCode());
		debitLogInfoPO.setBeforeAmount(debitInfo.getCanUseAmount());
		debitLogInfoPO.setAfterAmount(debitInfo.getCanUseAmount());
		debitLogInfoPO.setAmount(record.getDebitAmount());
		debitLogInfoPO.setOperateType(MerchantDebitLogOperateTypeEnum.BORROWING.code);
		debitLogInfoPO.setCreateTime(new Date());
		debitLogInfoPO.setUpdateTime(new Date());
		return dmMerchantDebitLogInfoDAO.insert(debitLogInfoPO);
	}

	@Override
	public Long insert(DoMerchantDebitOrderPO record) {
		return extDoMerchantDebitOrderDAO.insert(record);
	}

	/**
	 * 更新订单状态
	 */
	private int updateByDebitOrderId(Long id, String status) {
		DoMerchantDebitOrderPO record = extDoMerchantDebitOrderDAO.selectByPrimaryKey(id);
		DoMerchantDebitOrderExample example = new DoMerchantDebitOrderExample();
		DoMerchantDebitOrderExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		criteria.andStatusEqualTo(record.getStatus());
		record.setStatus(status);
		if (StringUtils.isNotBlank(status) && status.equals(MerchantDebitOrderStatusEnums.PAYBACKING.getKey())) {
			record.setTransferTime(new Date());
			record.setStartTime(new Date());
			Date endTime = com.sdo.common.util.DateUtil.addDays(record.getStartTime(), record.getBorrowDays().intValue());
			record.setEndTime(endTime);
			// 逾期时间是结束时间+1
			Date overDueTime = com.sdo.common.util.DateUtil.addDays(record.getStartTime(), record.getBorrowDays().intValue() + 1);
			record.setOverDueTime(overDueTime);
		}
		record.setUpdateTime(new Date());
		return extDoMerchantDebitOrderDAO.updateByExampleSelective(record, example);
	}

	/**
	 * 查询机构放款额度配置
	 *
	 * @param orgnizationCode
	 * @param riskLevel
	 * @return
	 */
	@Override
	public BigDecimal getInterestRateDay(String orgnizationCode, String riskLevel) {
		DbOrgCreditSettingExample example = new DbOrgCreditSettingExample();
		DbOrgCreditSettingExample.Criteria criteria = example.createCriteria();
		criteria.andOrgnizationCodeEqualTo(orgnizationCode);
		criteria.andRiskLevelEqualTo(riskLevel);
		List<DbOrgCreditSettingPO> listOrgCreditSetting = this.dbOrgCreditSettingDAO.selectByExample(example);
		if (listOrgCreditSetting != null && listOrgCreditSetting.size() > 0) {
			return listOrgCreditSetting.get(0).getInterestRateDay();
		}
		return null;
	}

	/**
	 * 查询待审核订单
	 *
	 * @param orgnizationCode
	 * @param riskLevel
	 * @return
	 */
	private DoMerchantDebitOrderPO getMerchantDebitOrder(Long id) {
		DoMerchantDebitOrderPO doMerchantDebitOrderPO = extDoMerchantDebitOrderDAO.selectByPrimaryKey(id);

		if (doMerchantDebitOrderPO != null) {
			return doMerchantDebitOrderPO;
		}
		return null;
	}

	/**
	 * 借款放款
	 */
	@Override
	public ErrorMessageVO loanOperation(Long id, String status, String operator, String operatorId) {
		synchronized (this) {
			DoMerchantDebitOrderPO record = getMerchantDebitOrder(id);
			if (record == null || !record.getStatus().equals(MerchantDebitOrderStatusEnums.LOAN_REVIEW.getKey())) {
				return new ErrorMessageVO(false, "-1", "订单已处理");
			}

			int row = updateByDebitOrderId(id, MerchantDebitOrderStatusEnums.LOANING.getKey());
			if (row != 1) {
				return new ErrorMessageVO(false, "-1", "更新操作人失败");
			}

			NewT0UserOperaRecordDO newT0UserOperaRecordDO = new NewT0UserOperaRecordDO();
			if (id != null) {
				newT0UserOperaRecordDO.setBizId(id);
				newT0UserOperaRecordDO.setRealname(operator);
				newT0UserOperaRecordDO.setUsername(operatorId);
				newT0UserOperaRecordDO.setBizType(UserOperaRecordEnum.LOAN.getCode());
				newT0UserOperaRecordDO.setCreateTime(new Date());
			}
			Long recordId = newT0UserOperaRecordDAO.insert(newT0UserOperaRecordDO);
			if (recordId == null) {
				return new ErrorMessageVO(false, "-1", "放款人信息保存失败");
			}

			if (StringUtils.isNotBlank(status) && status.equals(LoanOperaTypeEnum.AGREE.code)) {
				DoMerchantCreditLinesApplyPO applyPO = doMerchantCreditLinesApplyDAO.getLatestCreditLines(record.getMerchantNo());
				/**
				 * 固定服务费
				 */
				String serverRate = this.debitConfigService.getByKey(ConfigEnums.DEBIT_ORDER_SERVER_RATE);
				BigDecimal _serverRate = new BigDecimal(serverRate);// 服务费
				// 计算手续费
				BigDecimal interestRateDay = record.getInterestRateDay(); // 日息利率
				// 手续费率=息利率-服务费率
				BigDecimal feeRate = interestRateDay.subtract(_serverRate);
				/**
				 * 固定服务费end
				 */
				BigDecimal debitAmount = record.getDebitAmount(); // 借款本金
				BigDecimal borrowDays = record.getBorrowDays(); // 借款期限
				try {
					BigDecimal _interestAmount = (debitAmount.multiply(feeRate)).multiply(borrowDays).divide(BigDecimal.valueOf(10000)).setScale(2, RoundingMode.FLOOR);
					BigDecimal _serviceAmount = (debitAmount.multiply(_serverRate)).multiply(borrowDays).divide(BigDecimal.valueOf(10000)).setScale(2, RoundingMode.FLOOR);
					DmMerchantDebitInfoPO merchantDebitInfo = merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(record.getMerchantNo(), DebitOrganizationEnum.SFT);

					// fos转账
					DebitTransferRequestDTO transferRequestDTO = new DebitTransferRequestDTO();
					transferRequestDTO.setBizId(record.getId().toString());
					transferRequestDTO.setMemberId(merchantDebitInfo.getLendMemberId());
					transferRequestDTO.setCreditAccountId(merchantDebitInfo.getCreditAccount());
					transferRequestDTO.setPublicAccountId(merchantDebitInfo.getLendWalletAccount());
					transferRequestDTO.setInterestAccountId(merchantDebitInfo.getInterestAccount());
					transferRequestDTO.setDebitLimitAmount(record.getDebitAmount());
					transferRequestDTO.setFee(_serviceAmount);
					transferRequestDTO.setInterest(_interestAmount);
					transferRequestDTO.setBatchNo(UUID.randomUUID().toString().replaceAll("-", ""));// TODO
																									// 用序列
					ErrorMessageVO errorMessage = FOSFacade4Debit.transfer4Debit(transferRequestDTO);

					if (FosPaymentStateEnums.S.code.equals(errorMessage.getErrorCode())) {
						boolean fosFlag = fosPaymentSuccess(record, applyPO, merchantDebitInfo);
						if (fosFlag) {
							return new ErrorMessageVO(true, "0", "借款成功");
						} else {
							return new ErrorMessageVO(false, "-1", "借款成功后更新状态或者变更流水异常");
						}
					} else if (FosPaymentStateEnums.P.code.equals(errorMessage.getErrorCode())) {
						return new ErrorMessageVO(false, "R", "正在处理中，请稍后到钱包查询交易状态");
					} else if (FosPaymentStateEnums.E.code.equals(errorMessage.getErrorCode())) {
						// 如果调用fos异常则特殊处理，降低可用额度、冻结金额不做处理
						return new ErrorMessageVO(false, "R", "请去个人钱包户查收资金，若有疑问请致电021-20575188-807755");
					} else {
//						dmMerchantDebitInfoDAO.freezeMerchantDebitFail(record.getMerchantNo(), DebitAccountEnums.ACCOUNT_CAN_USE.getKey(), record.getDebitAmount());
						updateByDebitOrderId(id, MerchantDebitOrderStatusEnums.LOAN_REVIEW.getKey());
						NewT0UserOperaRecordDOExample recordExample = new NewT0UserOperaRecordDOExample();
						recordExample.createCriteria().andBizIdEqualTo(id);
						newT0UserOperaRecordDAO.deleteByExample(recordExample);
						return new ErrorMessageVO(false, "-1", "借款失败，请重试");
					}
				} catch (Exception e) {
					log.error("MerchantDebitApplyServiceImpl.loanOperation.error,orderId=" + record.getId(), e);
					return new ErrorMessageVO(false, "-1", "系统繁忙，请稍后再试");
				}
			} else if (StringUtils.isNotBlank(status) && status.equals(LoanOperaTypeEnum.REFUSE.code)) {// 拒绝放款
				log.info("MerchantDebitApplyServiceImpl.loanOperation：" + record.getId() + ",refuseLoanSuccess");
				updateByDebitOrderId(record.getId(), MerchantDebitOrderStatusEnums.LOAN_REVIEW_REFUSE.getKey());
				DmMerchantDebitInfoPO merchantDebitInfo = merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(record.getMerchantNo(), DebitOrganizationEnum.SFT);
				dmMerchantDebitInfoDAO.freezeMerchantDebitFail(record.getMerchantNo(), DebitAccountEnums.ACCOUNT_CAN_USE.getKey(), record.getDebitAmount());
				DmMerchantDebitInfoPO afterMerchantDebitInfo = merchantDebitInfoService.selectMerchantDebitInfoByMerchantNo(record.getMerchantNo(), DebitOrganizationEnum.SFT);
				DmMerchantDebitLogInfoPO debitLogInfoPO = new DmMerchantDebitLogInfoPO();
				debitLogInfoPO.setMerchantNo(record.getMerchantNo());
				debitLogInfoPO.setOrganizationCode(DebitOrganizationEnum.SFT.code);
				debitLogInfoPO.setBeforeAmount(merchantDebitInfo.getCanUseAmount());
				debitLogInfoPO.setAfterAmount(afterMerchantDebitInfo.getCanUseAmount());
				debitLogInfoPO.setAmount(record.getDebitAmount());
				debitLogInfoPO.setOperateType(MerchantDebitLogOperateTypeEnum.BORROWING.code);
				debitLogInfoPO.setCreateTime(new Date());
				debitLogInfoPO.setUpdateTime(new Date());
				dmMerchantDebitLogInfoDAO.insert(debitLogInfoPO);
				return new ErrorMessageVO(true, "0", "拒绝借款成功");
			} else {
				return new ErrorMessageVO(false, "-1", "传入参数有误");
			}
		}
	}

	/**
	 * 批量放款
	 */
	@Override
	public ErrorMessageVO batchLoanOperation(String ids, String status, String operator, String operatorId) {
		ErrorMessageVO error = null;
		String[] idArray = ids.split(",");
		if (idArray != null && idArray.length > 0) {
			for (int i = 0; i < idArray.length; i++) {
				error = loanOperation(Long.parseLong(idArray[i]), status, operator, operatorId);
			}
		}
		return error;
	}

	/**
	 * 文件下载
	 */
	@Override
	public ErrorMessageVO doExcel(List<LoanDebitOrderDTO> dataList, HttpServletRequest request, HttpServletResponse response) {
		String fileName = DateUtil.datefosOrderFormat(new Date()) + ".csv";// yyyyMMddHHmmss
		OutputStream os = null;
		try {
			// 输出流
			response.setContentType("application/csv;charset=gb18030");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

//			String lineSeparator = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));
			String info = "商户号,商户名,请款时间,账期（天数）,到期日,放款金额,放款人,放款状态" + "\r\n";
			for (LoanDebitOrderDTO model : dataList) {
				String merchantNo = model.getMerchantNo() != null ? model.getMerchantNo() : "";
				String merchantName = model.getMerchantName() != null ? model.getMerchantName() : "";
				String applyDate = model.getApplyDate() != null ? DateUtil.date2DateStr(model.getApplyDate()) : "";
				String borrowDays = model.getBorrowDays() != null ? model.getBorrowDays().toString() : "";
				String endTime = model.getEndTime() != null ? DateUtil.date2DateStr(model.getEndTime()) : "";
				String realAmount = model.getRealAmount() == null ? "0" : model.getRealAmount().toString();
				String realName = model.getRealName() != null ? model.getRealName() : "";
				String status = model.getStatus() != null ? MerchantDebitOrderStatusEnums.getDescByKey(model.getStatus()) : "";
				String dataInfo = merchantNo + "," + merchantName + "," + applyDate + "," + borrowDays + "," + endTime + "," + realAmount + "," + realName + "," + status;
				info = info + dataInfo + "\r\n";
			}
			os = new BufferedOutputStream(response.getOutputStream());
			byte[] infiByte = info.getBytes("gb18030"); // 将文件转换成字节数组
			os.write(infiByte);
			os.flush();
			os.close();
		} catch (Exception e) {
			log.error("文件生成异常：" + e.getMessage());
			return new ErrorMessageVO(false, "-1", "下载失败");
		} finally {
			// 关闭输出流
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				log.error("OutputStream关闭异常", e);
			}
		}
		return new ErrorMessageVO(true, "0", "下载成功");
		// ByteArrayInputStream bais = new ByteArrayInputStream(infiByte);
		// //把字节数组转换成字节数组流
		// FileOutputStream fos = new FileOutputStream(file); //创建文件输出流
		// byte[] buffer = new byte[10240]; //定义字节字节数组流的缓存读取字节数的大小
		// int len = bais.read(buffer); //向字节数组里读入文件内容
		// while (len != -1) {
		// fos.write(buffer, 0, len); //向文件中写入数据
		// len = bais.read(buffer);
		// }
		// fos.close();
		// bais.close();

		// String fileName = DateUtil.datefosOrderFormat(new
		// Date())+".xls";//yyyyMMddHHmmss
		// OutputStream os = null;
		// Workbook book = null;
		// try {
		// // 输出流
		// response.setContentType("application/vnd.ms-excel");
		// response.setHeader("Content-disposition", "attachment;filename=" +
		// fileName);
		// os = response.getOutputStream();//new FileOutputStream(reportPath +
		// fileName);
		// // 创建工作区(97-2003)
		// book = new HSSFWorkbook();
		// // 创建第一个sheet页
		// Sheet sheet1 = book.createSheet("sheet1");
		//
		// //单元格宽度
		// sheet1.setDefaultColumnWidth(18);
		//
		// //列头的样式
		// HSSFCellStyle sheetStyle = (HSSFCellStyle) book.createCellStyle();
		// // 背景色的设定
		// sheetStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
		// // 前景色的设定
		// sheetStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		//
		// // 左右居中
		// sheetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//
		// // 上下居中
		// sheetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//
		// int rowindex = 0;
		//
		// String headers[] =
		// "商户号,商户名,请款时间,账期（天数）,到期日,放款金额,放款人,放款状态".split(",");
		// // 填充模式
		// // sheetStyle.setFillPattern(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);
		//
		// // 设置字体
		// HSSFFont columnHeadFont = (HSSFFont) book.createFont();
		// columnHeadFont.setFontName("宋体");
		// columnHeadFont.setFontHeightInPoints((short) 10);
		// columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// HSSFFont headfont = (HSSFFont) book.createFont();
		// headfont.setFontName("黑体");
		// headfont.setFontHeightInPoints((short) 22);// 字体大小
		// headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
		//
		// sheetStyle.setFont(columnHeadFont);
		//
		//
		// Row row_a = sheet1.createRow(rowindex++);
		// for (int hi = 0; hi < headers.length; hi++) {
		// // 表头，hi：第几列
		// row_a.setHeightInPoints(30);//设置行高50
		// HSSFCell cellhead=(HSSFCell) row_a.createCell(hi);//每一列单元格
		// cellhead.setCellValue(headers[hi]);
		// cellhead.setCellStyle(sheetStyle);
		// }
		//
		// // 单元行样式
		// HSSFCellStyle columnHeadStyle = (HSSFCellStyle)
		// book.createCellStyle();
		// // 设置字体
		// HSSFFont rowFont = (HSSFFont) book.createFont();
		// columnHeadFont.setFontName("宋体");
		// columnHeadFont.setFontHeightInPoints((short) 10);
		// columnHeadFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// columnHeadStyle.setFont(rowFont);
		// columnHeadStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		// columnHeadStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//
		// 上下居中
		//
		// for (LoanDebitOrderDTO model : dataList) {
		// Row rown = sheet1.createRow(rowindex++);
		// rown.setHeightInPoints(30);//设置行高50
		// //创建每一列单元格样式
		// HSSFCell cellhead0 = (HSSFCell) rown.createCell(0); //每一列单元格
		// HSSFCell cellhead1 = (HSSFCell) rown.createCell(1); //每一列单元格
		// HSSFCell cellhead2 = (HSSFCell) rown.createCell(2); //每一列单元格
		// HSSFCell cellhead3 = (HSSFCell) rown.createCell(3); //每一列单元格
		// HSSFCell cellhead4 = (HSSFCell) rown.createCell(4); //每一列单元格
		// HSSFCell cellhead5 = (HSSFCell) rown.createCell(5); //每一列单元格
		// HSSFCell cellhead6 = (HSSFCell) rown.createCell(6); //每一列单元格
		// HSSFCell cellhead7 = (HSSFCell) rown.createCell(7); //每一列单元格
		//
		// /**每一列单元格样式**/
		// cellhead0.setCellStyle(columnHeadStyle);
		// cellhead1.setCellStyle(columnHeadStyle);
		// cellhead2.setCellStyle(columnHeadStyle);
		// cellhead3.setCellStyle(columnHeadStyle);
		// cellhead4.setCellStyle(columnHeadStyle);
		// cellhead5.setCellStyle(columnHeadStyle);
		// cellhead6.setCellStyle(columnHeadStyle);
		// cellhead7.setCellStyle(columnHeadStyle);
		// /**每一列单元格值**/
		// cellhead0.setCellValue(new HSSFRichTextString(model.getMerchantNo() +
		// ""));
		// cellhead1.setCellValue(model.getMerchantName());
		// cellhead2.setCellValue(DateUtil.date2DateStr(model.getApplyDate()));
		// cellhead3.setCellValue(model.getBorrowDays() + "");
		// cellhead4.setCellValue(DateUtil.date2DateStr(model.getEndTime()));
		// cellhead5.setCellValue(model.getDebitAmount() == null ? "0" :
		// model.getDebitAmount().toString());
		// cellhead6.setCellValue(model.getRealName() + "");
		// cellhead7.setCellValue(MerchantDebitOrderStatusEnums.getDescByKey(model.getStatus()));
		// }
		//
		// // 写文件
		// book.write(os);
		// os.flush();
		// }catch (Exception e) {
		// log.error("文件生成异常："+e.getMessage());
		// return new ErrorMessageVO(false, "-1", "下载失败");
		// } finally {
		// // 关闭输出流
		// try {
		// if (os != null) {
		// os.close();
		// }
		// } catch (IOException e) {
		// log.error("OutputStream关闭异常："+e.getMessage());
		// }
		// }
		// return new ErrorMessageVO(true, "0", "下载成功");
	}

	/**
	 * 修改放款操作用户记录信息
	 *
	 * @param morId
	 * @param operator
	 * @param operatorId
	 */
	private void modfiyNewT0UserOpreaRecord(Long morId, String operator, String operatorId) {
		// TODO Auto-generated method stub
		NewT0UserOperaRecordDOExample recordExample = new NewT0UserOperaRecordDOExample();
		recordExample.createCriteria().andBizIdEqualTo(morId);
		recordExample.createCriteria().andOperaTimeIsNull();
		recordExample.createCriteria().andBizTypeEqualTo(UserOperaRecordEnum.LOAN.getCode());
		NewT0UserOperaRecordDO recordRecord = new NewT0UserOperaRecordDO();
		recordRecord.setRealname(operator);
		recordRecord.setUsername(operatorId);
		recordRecord.setOperaTime(new Date());
		recordRecord.setUpdateTime(new Date());
		newT0UserOperaRecordDAO.updateByExampleSelective(recordRecord, recordExample);
	}

	@Transactional("debitTransactionManager")
	private boolean fosPaymentSuccess(DoMerchantDebitOrderPO record, DoMerchantCreditLinesApplyPO applyPO, DmMerchantDebitInfoPO merchantDebitInfo) {
		try {
			dmMerchantDebitInfoDAO.freezeMerchantDebitSuccess(record.getMerchantNo(), DebitAccountEnums.ACCOUNT_CAN_USE.getKey(), record.getDebitAmount());
			// 更新订单状态为转账成功
			updateByDebitOrderId(record.getId(), MerchantDebitOrderStatusEnums.PAYBACKING.getKey());
			// 成功插入代理商分润记录
			if ("1".equals(applyPO.getIsAgnetGuarantee())) {
				// 承诺担保的商户要插入分润记录
				this.insertDoAgentProfit(record);
			}
			// 变更流水
			Long logId = merchantDebitLog(record, merchantDebitInfo);
			log.info("MerchantDebitApplyServiceImpl.fosPaymentSuccess.DoMerchantDebitOrderPO=" + record);

		} catch (Exception e) {
			log.error("MerchantDebitApplyServiceImpl.fosPaymentSuccess.Exception", e);
			return false;
		}
		return true;
	}
}
