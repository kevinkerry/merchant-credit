package com.shengpay.autorepayment.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.sdo.ma.ws.api.response.online.GetMemberInfoResponse;
import com.sdo.ma.ws.api.response.online.MemberMappingResponse;
import com.sdo.mas.common.api.common.entity.Extension;
import com.sdo.mas.common.api.common.entity.Header;
import com.sdo.mas.common.api.common.entity.Sender;
import com.sdo.mas.common.api.common.entity.SignSource;
import com.sdo.mas.common.api.common.entity.Signature;
import com.sdo.mas.common.api.common.exception.MasAPIException;
import com.sdo.mas.common.api.common.utils.SignatureUtil;
import com.sdo.mas.common.api.payment.entity.mtc.MtcBankPaymentRequest;
import com.sdo.mas.common.api.payment.entity.mtc.MtcBankPaymentResponse;
import com.sdo.mas.common.api.payment.entity.trans.AccountTypes;
import com.sdo.mas.common.api.payment.entity.trans.ArrayOfKvp;
import com.sdo.mas.common.api.payment.entity.trans.CurrencyType;
import com.sdo.mas.common.api.payment.entity.trans.Kvp;
import com.sdo.mas.common.api.payment.entity.trans.Payer;
import com.sdo.mas.common.api.payment.entity.trans.TransReqItem;
import com.sdo.mas.common.api.payment.entity.trans.TransferRequest;
import com.sdo.mas.common.api.payment.entity.trans.TransferResponse;
import com.sdo.mas.common.api.payment.service.MtcBankPaymentAPI;
import com.sdo.mas.common.api.payment.service.TransSoap;
import com.sdo.mas.common.api.query.order.entity.syn.single.OrderQueryRequest;
import com.sdo.mas.common.api.query.order.entity.syn.single.OrderQueryResponse;
import com.sdo.mas.common.api.query.order.service.QueryOrderAPI;
import com.sdp.mc.common.enums.WithholdCurrencyEnums;
import com.sdp.mc.common.enums.WithholdTypeEnums;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.util.FileUtil;
import com.sdp.mc.common.util.MD5Digest;
import com.sdp.mc.common.util.ParseCsvFileUtil;
import com.sdp.mc.common.util.SFTPUtil;
import com.sdp.mc.common.util.StringUtil;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.shengpay.autorepayment.service.WithholdFileService;
import com.shengpay.autorepayment.service.WithholdMoneyService;
import com.shengpay.debit.common.enums.WithholdBatchOpStatusEnum;
import com.shengpay.debit.common.enums.WithholdCardTypeEnum;
import com.shengpay.debit.common.enums.WithholdOrderOpStatusEnum;
import com.shengpay.debit.common.enums.WithholdPaperTypeEnum;
import com.shengpay.debit.common.enums.WithholdTransStatusEnum;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample.Criteria;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import com.shengpay.debit.dal.ext.dataobject.TbWithholdingInfoDTO;
import com.shengpay.mcl.btc.util.FileDigestAlgorithm;
import com.shengpay.mcl.btc.util.FileOperateUtil;
import com.shengpay.mcl.btc.util.SignUtil;
import com.shengpay.model.fileManager.DownloadFileResponse;
import com.shengpay.model.fileManager.UploadFileResponse;
import com.shengpay.service.fileManager.FileManagerService;
import com.shengpay.service.fileManager.impl.DFSUtils;
import com.shengpay.service.message.http.HttpClientUtil;

@Service
public class WithholdFileServiceImpl implements WithholdFileService {
	private static Logger log = LoggerFactory.getLogger(WithholdFileServiceImpl.class);
	@Value("${file.store.url}")
	private String fileStoreUrl;// 小文件地址
	@Value("${mtc.ftp.host}")
	private String host;// 主机
	@Value("${mtc.ftp.port}")
	private String port;// 端口
	@Value("${mtc.ftp.user}")
	private String username;// 用户名
	@Value("${mtc.ftp.pwd}")
	private String password;// 密码

	@Value("${mtc.ftp.file.url}")
	private String directory;// 目标路径
	@Value("${file.service.url}")
	private String filePath;// tomcat文件路径
	@Value("${batch.withhold.callback.url}")
	private String callbackUrl;
	@Value("${withhold.customerno}")
	private String customerno;
	@Value("${mas.withhold.sendtime.url}")
	private String sendTimeURL;
	@Value("${mas.withhold.senderId}")
	private String senderNo;
	@Value("${mas.withhold.merchantKey}")
	private String merchantKey;
	@Value("${mc.withhold.sign.flag}")
	private boolean signFlag;
	@Autowired
	private WithholdMoneyService withholdMoneyService;
	@Autowired
	private FileManagerService fileManagerService;
	@Resource(name = "masMtcBankPaymentAPI")
	private MtcBankPaymentAPI masMtcBankPaymentAPI;
	@Resource(name = "queryOrderAPI")
	private QueryOrderAPI queryOrderAPI;
	@Resource(name = "transSoapAPI")
	private TransSoap transSoapAPI;

	private final String SERVICE_CODE = "QUERY_ORDER_REQUEST";
	private final String VERSION = "V4.3.1.1.1";
	private final String WALLET_VERSION = "1.0";
	private final String ZFNO = "zf910";
	/**
	 * 1-rsa 2-md5
	 */
	private final int signTypeMd5 = 2;
	/**
	 * 0 请求
	 */
	private final String transLogDataRequest = "0";
	/**
	 * 接口类型：Transfer-转账 Billing-代扣
	 */
	private final String interFaceType = "Billing";

	/**
	 * 文件顺序固定为： 日期 批次号 商户号 总笔数 总金额 20120101 2.01E+12 245888 2 100 商户订单号 订单金额 银行
	 * 姓名 卡类型 卡号 证件类型 证件号码 附言 备注 2.01E+14 10 中国农业银行 张三 1 6.23E+18 1 3.31E+17 附言1
	 * 商户备注1 2.01E+14 90 邮政储蓄 李四 2 6.23E+18 2 1.11E+12 附言2 商户备注2
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public TbWithholdingInfoDTO checkFile(List<String[]> list, String fileType) throws Exception {
		TbWithholdingInfoDTO resultDTO = new TbWithholdingInfoDTO();
		if (list == null || list.size() < 4) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "内容为空或行数不足"));
			return resultDTO;
		} else {

			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[0]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "批次号不能为空"));
				return resultDTO;
			}
			if (!StringUtil.isNumeric(StringUtils.trimToEmpty(list.get(1)[0]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "批次号必须为数字"));
				return resultDTO;
			}
			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[1]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数不能为空"));
				return resultDTO;
			}
			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[2]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额不能为空"));
				return resultDTO;
			}

			try {
				Integer.parseInt(StringUtils.trimToEmpty(list.get(1)[1]));
			} catch (Exception e) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数非数字 "));
				return resultDTO;
			}

			if (!StringUtil.isAmountNumber(StringUtils.trimToEmpty(list.get(1)[2]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额非金额额数字，小数点后四舍五入，保留两位 "));
				return resultDTO;
			}

			if (Integer.parseInt(StringUtils.trimToEmpty(list.get(1)[1])) != (list.size() - 3)) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数不一致"));
				return resultDTO;
			}
			BigDecimal sum = BigDecimal.ZERO;
			for (int i = 3; i < list.size(); i++) {
				if (StringUtils.isNotBlank(StringUtils.trimToEmpty(list.get(i)[0]))) {
					sum = sum.add(new BigDecimal(StringUtils.trimToEmpty(list.get(i)[0])));
				}
			}
			if (sum.compareTo(new BigDecimal(StringUtils.trimToEmpty(list.get(1)[2]))) != 0) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额不一致"));
				return resultDTO;
			}
			Date date = new Date();
			resultDTO.setBatchTime(date);
			resultDTO.setBatchNo(StringUtils.trimToEmpty(list.get(1)[0]));
			resultDTO.setMerchantNo(customerno);
			resultDTO.setTotalCount(StringUtils.trimToEmpty(list.get(1)[1]));
			resultDTO.setTotalAmount(new BigDecimal(StringUtils.trimToEmpty(list.get(1)[2])));
			resultDTO.setCreateTime(new Date());
			List<TbWithholdingOrderInfoPO> tbWithholdingOrderInfoList = new ArrayList<TbWithholdingOrderInfoPO>();
			String cardType = "";
			String typeTitle = "卡号";
			String compTitle = StringUtils.trimToEmpty(list.get(2)[4]);
			if (!typeTitle.equals(compTitle)) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "请检查，确保传入正确的模板"));
				return resultDTO;
			}
			for (int i = 3; i < list.size(); i++) {
				TbWithholdingOrderInfoPO tbWithholdingOrderInfoPO = new TbWithholdingOrderInfoPO();
				tbWithholdingOrderInfoPO.setMerchantOrderNo(withholdMoneyService.creditWithholdingOrderNo());

				tbWithholdingOrderInfoPO.setMerchantNo(customerno);
				// 批次号-不做校验
				tbWithholdingOrderInfoPO.setBatchNo(resultDTO.getBatchNo());
				// 订单金额>0
				String orderObj = StringUtils.trimToEmpty(list.get(i)[0]);
				// 判段非金额
				if (StringUtils.isBlank(orderObj)) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额不能为空"));
					return resultDTO;
				}

				if (!StringUtil.isAmountNumber(orderObj)) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额非金额额数字，小数点后四舍五入，保留两位 "));
					return resultDTO;
				}
				// 转成两位
				BigDecimal orderAmount = StringUtil.bigScaleUP(orderObj, 2);
				// ompareto就是比较两个数据的大小关系 大于0表示前一个数据比后一个数据大，
				// 0表示相等，小于0表示第一个数据小于第二个数据
				if (orderAmount.compareTo(new BigDecimal(0)) <= 0) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额必须大于0 "));
					return resultDTO;
				}

				tbWithholdingOrderInfoPO.setOrderAmount(orderAmount);
				tbWithholdingOrderInfoPO.setBankName(StringUtils.trimToEmpty(list.get(i)[1]));
				if (StringUtils.isBlank(tbWithholdingOrderInfoPO.getBankName())) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "银行编码不能为空"));
					return resultDTO;
				}
				if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(i)[2]))) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "姓名不能为空"));
					return resultDTO;
				}
				tbWithholdingOrderInfoPO.setChName(StringUtils.trimToEmpty(list.get(i)[2]));

				cardType = StringUtils.trimToEmpty(list.get(i)[3]);
				if (StringUtils.isNotBlank(cardType)) {
					if (cardType.length() == 1) {
						if (WithholdCardTypeEnum.getEnumsByCode(Integer.parseInt(cardType)) == null) {
							resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡类型不符合要求，01-借记卡  02-贷记卡  03-存折  04-公司银行账户(暂不支持) "));
							return resultDTO;
						}
					} else if (cardType.length() == 2) {
						if (WithholdCardTypeEnum.getEnumsByValue(cardType) == null) {
							resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡类型不符合要求，01-借记卡  02-贷记卡  03-存折  04-公司银行账户(暂不支持) "));
							return resultDTO;
						}
					} else {
						resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡类型不符合要求，01-借记卡  02-贷记卡  03-存折  04-公司银行账户(暂不支持) "));
						return resultDTO;
					}

				} else {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡类型不能为空"));
					return resultDTO;
				}
				tbWithholdingOrderInfoPO.setCardType(cardType);

				tbWithholdingOrderInfoPO.setCardNo(StringUtils.trimToEmpty(list.get(i)[4]));
				if (StringUtils.isBlank(tbWithholdingOrderInfoPO.getCardNo())) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡号不能为空"));
					return resultDTO;
				}
				if (!StringUtil.isNumeric(tbWithholdingOrderInfoPO.getCardNo())) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "卡号必须为数字"));
					return resultDTO;
				}
				String paperType = StringUtils.trimToEmpty(list.get(i)[5]);
				if (StringUtils.isNotBlank(paperType)) {
					WithholdPaperTypeEnum enumPo = WithholdPaperTypeEnum.parse(paperType.toUpperCase());
					if (enumPo == null) {
						// 提示不合法的类型
						resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "证件类型不符合要求" + WithholdPaperTypeEnum.toStr()));
						return resultDTO;
					}
				} else {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "证件类型不能为空"));
					return resultDTO;
				}
				tbWithholdingOrderInfoPO.setPaperType(StringUtils.trimToEmpty(list.get(i)[5]));
				tbWithholdingOrderInfoPO.setPaperNo(StringUtils.trimToEmpty(list.get(i)[6]));
				if (StringUtils.isBlank(tbWithholdingOrderInfoPO.getPaperNo())) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "证件号码不能为空"));
					return resultDTO;
				}
				if (StringUtils.isNotBlank(StringUtils.trimToEmpty(list.get(i)[5]))) {
					tbWithholdingOrderInfoPO.setPlanwithholddate(DateUtil.parseDate(list.get(i)[7], DateUtil.dateFormat5));
				}
				tbWithholdingOrderInfoPO.setPostscript(StringUtils.trimToEmpty(list.get(i)[8]));
				tbWithholdingOrderInfoPO.setRemark(StringUtils.trimToEmpty(list.get(i)[9]));
				tbWithholdingOrderInfoPO.setCreateTime(new Date());
				tbWithholdingOrderInfoPO.setCurrency(WithholdCurrencyEnums.CNY.code);
				tbWithholdingOrderInfoPO.setType(WithholdTypeEnums.BANK_CARD_WITHDRAW.code);
				tbWithholdingOrderInfoList.add(tbWithholdingOrderInfoPO);
			}
			resultDTO.setTbWithholdingOrderInfoList(tbWithholdingOrderInfoList);
		}

		resultDTO.setErrorMessageVO(new ErrorMessageVO(true, "0", "校验成功"));
		return resultDTO;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public TbWithholdingInfoDTO checkWalletFile(List<String[]> list) throws Exception {
		TbWithholdingInfoDTO resultDTO = new TbWithholdingInfoDTO();
		if (list == null || list.size() < 4) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "内容为空或行数不足"));
			return resultDTO;
		} else {

			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[0]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "批次号不能为空"));
				return resultDTO;
			}
			if (!StringUtil.isNumeric(StringUtils.trimToEmpty(list.get(1)[0]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "批次号必须为数字"));
				return resultDTO;
			}
			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[1]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数不能为空"));
				return resultDTO;
			}
			if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(1)[2]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额不能为空"));
				return resultDTO;
			}

			try {
				Integer.parseInt(StringUtils.trimToEmpty(list.get(1)[1]));
			} catch (Exception e) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数非数字 "));
				return resultDTO;
			}

			if (!StringUtil.isAmountNumber(StringUtils.trimToEmpty(list.get(1)[2]))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额非金额额数字，小数点后四舍五入，保留两位 "));
				return resultDTO;
			}

			if (Integer.parseInt(StringUtils.trimToEmpty(list.get(1)[1])) != (list.size() - 3)) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总笔数不一致"));
				return resultDTO;
			}
			BigDecimal sum = BigDecimal.ZERO;
			for (int i = 3; i < list.size(); i++) {
				if (StringUtils.isNotBlank(StringUtils.trimToEmpty(list.get(i)[0]))) {
					sum = sum.add(new BigDecimal(StringUtils.trimToEmpty(list.get(i)[0])));
				}
			}
			if (sum.compareTo(new BigDecimal(StringUtils.trimToEmpty(list.get(1)[2]))) != 0) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "总金额不一致"));
				return resultDTO;
			}
			Date date = new Date();
			resultDTO.setBatchTime(date);
			resultDTO.setBatchNo(StringUtils.trimToEmpty(list.get(1)[0]));
			resultDTO.setMerchantNo(customerno);
			resultDTO.setTotalCount(StringUtils.trimToEmpty(list.get(1)[1]));
			resultDTO.setTotalAmount(new BigDecimal(StringUtils.trimToEmpty(list.get(1)[2])));
			resultDTO.setCreateTime(new Date());
			String typeTitle = "钱包账户";
			String compTitle = StringUtils.trimToEmpty(list.get(2)[2]);
			if (!typeTitle.replaceAll(",", "").equals(compTitle.replaceAll(",", ""))) {
				resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "请检查，确保传入正确的模板"));
				return resultDTO;
			}
			List<TbWithholdingOrderInfoPO> tbWithholdingOrderInfoList = new ArrayList<TbWithholdingOrderInfoPO>();
			for (int i = 3; i < list.size(); i++) {
				TbWithholdingOrderInfoPO orderPo = new TbWithholdingOrderInfoPO();
				orderPo.setMerchantOrderNo(withholdMoneyService.creditWithholdingOrderNo());

				orderPo.setMerchantNo(customerno);
				// 批次号-不做校验
				orderPo.setBatchNo(resultDTO.getBatchNo());
				// 订单金额>0
				String orderObj = StringUtils.trimToEmpty(list.get(i)[0]);
				// 判段非金额
				if (StringUtils.isBlank(orderObj)) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额不能为空"));
					return resultDTO;
				}

				if (!StringUtil.isAmountNumber(orderObj)) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额非金额额数字，小数点后四舍五入，保留两位 "));
					return resultDTO;
				}
				// 转成两位
				BigDecimal orderAmount = StringUtil.bigScaleUP(orderObj, 2);
				if (orderAmount.compareTo(new BigDecimal(0)) <= 0) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "订单金额必须大于0 "));
					return resultDTO;
				}

				if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(i)[1]))) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "币种不能为空"));
					return resultDTO;
				}
				if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(i)[2]))) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "钱包账户不能为空"));
					return resultDTO;
				}

				if (StringUtils.isBlank(StringUtils.trimToEmpty(list.get(i)[3]))) {
					resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "姓名不能为空"));
					return resultDTO;
				}
				orderPo.setOrderAmount(orderAmount);
				orderPo.setCurrency(StringUtils.trimToEmpty(list.get(i)[1]));
				orderPo.setWalletno(StringUtils.trimToEmpty(list.get(i)[2]));
				orderPo.setChName(StringUtils.trimToEmpty(list.get(i)[3]));
				orderPo.setMobel(StringUtils.trimToEmpty(list.get(i)[4]));
				if (StringUtils.isNotBlank(list.get(i)[5])) {
					orderPo.setPlanwithholddate(DateUtil.parseDate(list.get(i)[5], DateUtil.dateFormat5));
				}
				orderPo.setPostscript(StringUtils.trimToEmpty(list.get(i)[6]));
				orderPo.setRemark(StringUtils.trimToEmpty(list.get(i)[7]));
				orderPo.setCreateTime(new Date());
				orderPo.setType(WithholdTypeEnums.WALLET_WITHDRAW.code);
				// 设置PT memberId
				MemberMappingResponse response = bulidMemberInfoResponse(orderPo, resultDTO);
				if (resultDTO.getErrorMessageVO() != null) { return resultDTO; }
				orderPo.setMemberid(response.getMemberId());
				String pt = response.getPt();
				if (StringUtils.isBlank(pt)) {
					pt = response.getVpt();
				}
				orderPo.setPt(pt);
				tbWithholdingOrderInfoList.add(orderPo);
			}
			resultDTO.setTbWithholdingOrderInfoList(tbWithholdingOrderInfoList);
		}

		resultDTO.setErrorMessageVO(new ErrorMessageVO(true, "0", "校验成功"));
		return resultDTO;
	}

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@SuppressWarnings("rawtypes")
	private MemberMappingResponse bulidMemberInfoResponse(TbWithholdingOrderInfoPO po, TbWithholdingInfoDTO resultDTO) {
		GetMemberInfoResponse response = maOnlineWrapper.getMemberInfo(po.getWalletno(), "");
		if (response == null || response.getHeader() == null) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "请检查钱包账号"));
			return null;
		}
		if (!response.getHeader().getResponseCode().equals("0")) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", response.getHeader().getResponseMessage()));
			return null;
		}
		MemberMappingResponse mappingResponse = maOnlineWrapper.getMemberMapping(response.getMemberId(), 1L);
		if (mappingResponse == null || mappingResponse.getHeader() == null) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", "请检查钱包账号PT信息"));
			return null;
		}
		if (!mappingResponse.getHeader().getResponseCode().equals("0")) {
			resultDTO.setErrorMessageVO(new ErrorMessageVO(false, "-1", response.getHeader().getResponseMessage()));
			return null;
		}

		return mappingResponse;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public ErrorMessageVO uploadFileToFTP(String batchNo) {
		ErrorMessageVO vo = new ErrorMessageVO(true);
		String filepath = "";
		// 获取文件再上传
		TbWithholdingFileInfoExample example = new TbWithholdingFileInfoExample();
		example.createCriteria().andBatchNoEqualTo(batchNo);
		TbWithholdingFileInfoPO filePO;
		try {
			filePO = withholdMoneyService.selectFileByExample(example);

			// 下载文件
			DownloadFileResponse downloadFileResponse = fileManagerService.downLoadFile(filePO.getFileKey());
			byte[] downLoad = downloadFileResponse.getDownloadByte();
			FileUtil.byte2File(downLoad, filePath, filePO.getFileName());
			vo.setErrorMessage(MD5Digest.toHexString(downLoad));
			// 上传文件
			ChannelSftp sftp = SFTPUtil.connect(host, Integer.parseInt(port), username, password);
			filepath = filePath + "\\" + filePO.getFileName();
			boolean uploadFlag = SFTPUtil.upload(directory, filepath, sftp);
			if (uploadFlag == false) {
				vo.setSuccess(false);
				vo.setErrorMessage("上传文件到FTP失败");
			}
		} catch (Exception e) {
			vo.setSuccess(false);
			vo.setErrorMessage("上传文件到FTP异常");
		}

		return vo;
	}

	public List<String[]> readerFileData11(File file) throws Exception {
		return ParseCsvFileUtil.readCsvFile(file, "GBK");
	}

	@Override
	public UploadFileResponse uploadFileTOStore(String fileName) {
		File file = new File(filePath + "\\" + fileName);
		UploadFileResponse response = new UploadFileResponse();
		response.setOriFileName(file.getName()); // 用户上传文件名
		response.setContentType("csv"); // 文件类型
		response.setFileSize(file.length()); // 文件长度
		byte[] bytes = FileUtil.File2byte(file.getPath());
		String furl;
		furl = DFSUtils.postForLocation(fileStoreUrl, bytes);
		response.setStoreKey(furl);
		response.setUploadSuccess(true);
		return response;
	}

	public UploadFileResponse uploadFileTOStore(File file) {
		UploadFileResponse response = new UploadFileResponse();
		response.setOriFileName(file.getName()); // 用户上传文件名
		response.setContentType("csv"); // 文件类型
		response.setFileSize(file.length()); // 文件长度
		byte[] bytes = FileUtil.File2byte(file.getPath());
		String furl;
		furl = DFSUtils.postForLocation(fileStoreUrl, bytes);
		response.setStoreKey(furl);
		response.setUploadSuccess(true);
		return response;
	}

	public String getUploadFileDigest(String batchNo) throws Exception {
		// 获取文件再上传
		TbWithholdingFileInfoExample example = new TbWithholdingFileInfoExample();
		example.createCriteria().andBatchNoEqualTo(batchNo);

		TbWithholdingFileInfoPO filePO = withholdMoneyService.selectFileByExample(example);
		String digestFilePath = filePath + "\\" + filePO.getFileName();
		String digest = FileOperateUtil.generateFileDigest(digestFilePath, FileDigestAlgorithm.MD5);
		return digest;
	}

	/**
	 * 发起银行卡代扣（Job调用）
	 *
	 * @throws WebServiceException
	 *             ,Exception
	 */
	public void apply(TbWithholdingOrderInfoPO orderPo) throws WebServiceException, Exception {
		log.info("applyorderPo is start");
		if (null == orderPo) {
			log.error("apply.orderPo is null");
			return;
		}
		log.info("apply.start orderPo:{}", ToStringBuilder.reflectionToString(orderPo), ToStringStyle.SHORT_PREFIX_STYLE);
		try {
			MtcBankPaymentRequest request = bulidMcPayRequest(orderPo);
			// 插入日志表记录
			Long logId = addTransLog(orderPo, request, transLogDataRequest);
			// 调用接口
			log.info("masMtcBankPaymentAPI.mtcPay.start.request:{}", ToStringBuilder.reflectionToString(request));
			MtcBankPaymentResponse batchResponse = masMtcBankPaymentAPI.mtcPay(request);
			log.info("masMtcBankPaymentAPI.mtcPay.end.batchResponse:{}", ToStringBuilder.reflectionToString(batchResponse));
			updateTransLog(batchResponse, logId);
			orderPo.setRequestTime(new Date());
			if (batchResponse == null) {
				orderPo.setStatus(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
				TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(orderPo.getId());
				criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code);
				orderPo.setRequestTime(new Date());
				withholdMoneyService.updateByExampleSelective(orderPo, example);
				log.info("cardNo:{},id:{}  withhold is end  batchResponse is null", new Object[] { orderPo.getCardNo(), orderPo.getId() });
			} else {
				orderPo.setUpdateTime(new Date());
				updateStatusByResponse(batchResponse, orderPo);
				log.info("cardNo:{} id:{} withhold is sucess !", new Object[] { orderPo.getCardNo(), orderPo.getId() });
			}
		} catch (WebServiceException we) {
			throw new WebServiceException();
		} catch (Exception e) {
			throw new Exception();
		}

	}

	private MtcBankPaymentRequest bulidMcPayRequest(TbWithholdingOrderInfoPO orderPo) throws MasAPIException {
		MtcBankPaymentRequest request = new MtcBankPaymentRequest();
		Header header = new Header();
		Sender sender = new Sender();
		Extension ext = new Extension();
		ext.setExt1("ext1");
		ext.setExt2("ext2");
		sender.setSenderId(senderNo);
		String sendData = HttpClientUtil.getMethod(sendTimeURL + "?merchantNo=" + customerno, "");
		if (StringUtils.isBlank(sendData)) sendData = "";
		JSONObject jsonObject = JSONObject.fromObject(sendData);
		String sendTime = "";
		if (jsonObject.containsKey("timestamp")) {
			sendTime = jsonObject.getString("timestamp");
		}
		header.setCharset("UTF-8");
		header.setSender(sender);
		header.setTraceNo(orderPo.getMerchantOrderNo());
		request.setAccountName(orderPo.getChName());
		request.setCardNo(orderPo.getCardNo());
		request.setCardType(orderPo.getCardType());
		request.setCertiNo(orderPo.getPaperNo());
		request.setCertiType(orderPo.getPaperType());
		request.setCurrency(orderPo.getCurrency());
		request.setCustomerNo(customerno);
		request.setExtension(ext);
		request.setHeader(header);
		request.setInstCode(orderPo.getBankName());
		// 服务器通知地址
		request.setNotifyUrl(callbackUrl);
		request.setOrderAmount(orderPo.getOrderAmount().toString());
		request.setOrderNo(orderPo.getMerchantOrderNo());
		request.setOrderTime(sendTime);
		request.setSignature(buildSignature());
		SignSource ss = request.buildSignSource();
		ss.setMd5Key(merchantKey);
		String sign = SignatureUtil.getSignMessage(ss);
		request.getSignature().setSignMsg(sign);
		return request;
	}

	private Long addTransLog(TbWithholdingOrderInfoPO orderPo, Object data, String requestType) throws Exception {
		TbWithholdingTransLogPO po = new TbWithholdingTransLogPO();
		po.setBatchNo(orderPo.getBatchNo());
		JSONObject jsonRequest = JSONObject.fromObject(data);
		po.setRequestData(jsonRequest.toString());
		po.setRequestTime(new Date());
		po.setCreateTime(new Date());
		po.setMerchantOrderNo(orderPo.getMerchantOrderNo());
		po.setCardNo(orderPo.getCardNo());
		po.setResulttype(requestType);
		return withholdMoneyService.addTransInfo(po);
	}

	private void updateTransLog(Object data, Long logId) throws Exception {
		TbWithholdingTransLogPO po = new TbWithholdingTransLogPO();
		po.setId(logId);
		JSONObject responseDate = JSONObject.fromObject(data);
		po.setResponsedate(responseDate.toString());
		po.setUpdateTime(new Date());
		withholdMoneyService.updateTransInfo(po);
	}

	private void updateStatusByResponse(TransferResponse response, TbWithholdingOrderInfoPO orderPo) {

		String resultStatus = "";
		if (response.getCode() == 0) {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_SUCCESS.code;
			orderPo.setSucessTime(new Date());
			orderPo.setSucessTime(DateUtil.parseDate(response.getRespBody().getPayTime().toString(), DateUtil.default_pattern));
			orderPo.setExt(response.getRespBody().getSerialNo());// ext
		} else {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_FAILL.code;
		}
		String extStatus = WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code;
		orderPo.setStatus(extStatus);
		orderPo.setErrorcode(String.valueOf(response.getCode()));
		orderPo.setErrormsg(response.getMessage());
		orderPo.setPayablefee("0.00");
		orderPo.setReceivablefee("0.00");
		orderPo.setRequestTime(new Date());
		withholdMoneyService.updateOrderOpStatus(orderPo, resultStatus);
	}

	private void updateStatusByResponse(MtcBankPaymentResponse batchResponse, TbWithholdingOrderInfoPO orderPo) {

		String resultStatus = "";
		if (!StringUtils.isEmpty(batchResponse.getReturnInfo().getErrorCode())) {
			resultStatus = WithholdTransStatusEnum.FAIL.code;
		}
		if (null == batchResponse.getTransStatus()) {
			resultStatus = WithholdTransStatusEnum.PROCESSING.code;
		} else if (StringUtils.isNotBlank(batchResponse.getTransStatus().getCode())) {
			resultStatus = batchResponse.getTransStatus().getCode();
		}
		// 更新状态
		if (resultStatus.equals(WithholdTransStatusEnum.SUCC.code)) {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_SUCCESS.code;
			orderPo.setSucessTime(new Date());
		} else if (resultStatus.equals(WithholdTransStatusEnum.FAIL.code)) {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_FAILL.code;
		} else if (resultStatus.equals(WithholdTransStatusEnum.PROCESSING.code)) {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code;
		} else if (resultStatus.equals(WithholdTransStatusEnum.TIMEOUT.code)) {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_TIMEOUT.code;
		} else {
			resultStatus = WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code;
		}

		if (StringUtils.isNotBlank(batchResponse.getPaymentTime())) orderPo.setSucessTime(DateUtil.parse2Date(batchResponse.getPaymentTime()));
		orderPo.setExt(batchResponse.getTransNo());// ext 扩展字段存放返回支付订单号
		String extStatus = WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code;
		orderPo.setStatus(extStatus);
		orderPo.setErrorcode(batchResponse.getReturnInfo().getErrorCode());
		orderPo.setErrormsg(batchResponse.getReturnInfo().getErrorMsg());
		orderPo.setPayablefee(batchResponse.getPayableFee());
		orderPo.setReceivablefee(batchResponse.getReceivableFee());
		orderPo.setRequestTime(new Date());
		withholdMoneyService.updateOrderOpStatus(orderPo, resultStatus);
	}

	@Override
	public List<String[]> readerFileData(File file) throws Exception {
		return ParseCsvFileUtil.readCsvFile(file, "gb2312");
	}

	@Override
	public List<String[]> readerFileData(String fileName) throws Exception {
		File file = new File(filePath + "\\" + fileName);
		return ParseCsvFileUtil.readCsvFile(file, "gb2312");
	}

	@Override
	public void run() {
		log.info("WithholdFileServiceImpl.run.start");
		List<TbWithholdingBrechInfoPO> batchList = null;
		List<TbWithholdingOrderInfoPO> list = new ArrayList<TbWithholdingOrderInfoPO>();
		StringBuffer batchNoStr = new StringBuffer();
		try {
			// 获取状态是代扣的批次 002(代扣中),003(处理中)
			batchList = queryBatchInfoByStatus();
			log.info("run batchList:", ToStringBuilder.reflectionToString(batchList, ToStringStyle.SHORT_PREFIX_STYLE));
			if (batchList == null || batchList.size() == 0) return;
			// 获取相关的订单信息001,002
			queryInitOrderByBatchIfno(batchList, batchNoStr, list);
			// 扣款
			if (list == null || list.size() == 0) return;
			updateBatchStatusToProcessing();
			// 扣款操作
			for (TbWithholdingOrderInfoPO orderInfo : list) {
				log.info("run list one order orderNo{},PO:{}:",
						new Object[] { orderInfo.getMerchantOrderNo(), ToStringBuilder.reflectionToString(orderInfo) });
				Date date = DateUtil.generateDawnTimeStamp(new Date());
				if (orderInfo.getPlanwithholddate() == null) orderInfo.setPlanwithholddate(date);
				orderInfo.setStatus(WithholdOrderOpStatusEnum.ORDER_INIT.code);
				String exStatus = WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code;
				log.info("planWithHoldDate compare result:{}", new Object[] { DateUtil.compareDate(new Date(), orderInfo.getPlanwithholddate()) });
				if (DateUtil.compareDate(new Date(), orderInfo.getPlanwithholddate()) >= 0) {
					try {
						// 更新订单状态到002
						withholdMoneyService.updateOrderOpStatus(orderInfo, exStatus);

						if (WithholdTypeEnums.BANK_CARD_WITHDRAW.code.equals(orderInfo.getType())) {
							// 银行卡代扣
							this.apply(orderInfo);
						} else {
							// 钱包代扣
							this.walletWithholdApply(orderInfo);
						}

					} catch (WebServiceException we) {
						log.error("cardNo:{} id:{} withhold is  webServiceException !",
								new Object[] { orderInfo.getCardNo(), orderInfo.getId(), we.getMessage(), we });
					} catch (Exception e) {
						log.error("order:{} apply withhold is error", new Object[] { orderInfo.getMerchantOrderNo(), e, e.getMessage() });
						orderInfo.setSucessTime(new Date());
						TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
						example.createCriteria().andIdEqualTo(orderInfo.getId());
						example.createCriteria().andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code);
						try {
							orderInfo.setStatus(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
							withholdMoneyService.updateOrderByExample(orderInfo, example);
						} catch (Exception e1) {
							log.error("exception.updateOrderByExample.error", e1);
						}
					}

				}

			}

		} catch (Exception e) {
			log.error("run  is error", e.getMessage(), e);
			return;
		}

	}

	/**
	 * 所有批次状态 待扣中 002--处理中003
	 */
	private void updateBatchStatusToProcessing() {
		// 更新批次表状态 待扣中 002--处理中003
		TbWithholdingInfoDTO dto = new TbWithholdingInfoDTO();
		String extStatus = WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code;
		String status = WithholdBatchOpStatusEnum.BATCH_PROCESSING.code;
		withholdMoneyService.updateBatchStatus(status, dto, extStatus);
	}

	/**
	 * // 获取相关的订单信息001
	 *
	 * @param batchList
	 * @param batchNoStr
	 * @param list
	 * @throws Exception
	 */
	private void queryInitOrderByBatchIfno(List<TbWithholdingBrechInfoPO> batchList, StringBuffer batchNoStr, List<TbWithholdingOrderInfoPO> list)
			throws Exception {
		for (TbWithholdingBrechInfoPO brechPo : batchList) {
			TbWithholdingOrderInfoExample orderQueryParam = new TbWithholdingOrderInfoExample();
			Criteria criteria = orderQueryParam.createCriteria();
			criteria.andBatchNoEqualTo(brechPo.getBatchNo());
//			criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_INIT.code);
			List<String> statuslist=new ArrayList<String>();
			statuslist.add(WithholdOrderOpStatusEnum.ORDER_INIT.code);
			statuslist.add(WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code);
			criteria.andStatusIn(statuslist);
			List<TbWithholdingOrderInfoPO> orderList = withholdMoneyService.selectOrderByExample(orderQueryParam);
			list.addAll(orderList);
			batchNoStr.append(brechPo.getBatchNo()).append(",");
		}
	}

	/**
	 * 获取状态是 002(代扣中),003(处理中)的批次信息
	 *
	 * @return
	 * @throws Exception
	 */
	private List<TbWithholdingBrechInfoPO> queryBatchInfoByStatus() throws Exception {
		log.info("WithholdFileServiceImpl.run.withholdMoneyService.selectBrechByExample.status=" + WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code);
		TbWithholdingBrechInfoExample queryParam = new TbWithholdingBrechInfoExample();
		com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoExample.Criteria cat = queryParam.createCriteria();
		List<String> statusList = new ArrayList<String>();
		statusList.add(WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code);
		statusList.add(WithholdBatchOpStatusEnum.BATCH_PROCESSING.code);
		cat.andStatusIn(statusList);
		return withholdMoneyService.selectBrechByExample(queryParam);
	}

	/**
	 * 通过批次号更新批次订单全部处理完成
	 *
	 * @param brechInfoPO
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void updateBatchInfoToSucess(String brechNo) throws Exception {
		TbWithholdingOrderInfoExample orderQueryParam = new TbWithholdingOrderInfoExample();
		Criteria criteria = orderQueryParam.createCriteria();
		criteria.andBatchNoEqualTo(brechNo);
		criteria.andStatusNotEqualTo(WithholdOrderOpStatusEnum.ORDER_ABOLISH.code);
		List<TbWithholdingOrderInfoPO> orderCount = withholdMoneyService.selectOrderByExample(orderQueryParam);
		TbWithholdingOrderInfoExample param = new TbWithholdingOrderInfoExample();
		Criteria criteria1 = param.createCriteria();
		criteria1.andBatchNoEqualTo(brechNo);
		List<String> statusList = new ArrayList<String>();
		statusList.add(WithholdOrderOpStatusEnum.ORDER_SUCCESS.code);
		statusList.add(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
		statusList.add(WithholdOrderOpStatusEnum.ORDER_FAILL.code);
		statusList.add(WithholdOrderOpStatusEnum.ORDER_TIMEOUT.code);
		criteria1.andStatusIn(statusList);
		List<TbWithholdingOrderInfoPO> upStatusCount = withholdMoneyService.selectOrderByExample(param);
		log.info("batchNo:{},upStatusCount size:{},orderCount:{}", new Object[] { brechNo, upStatusCount.size(), orderCount.size() });
		if (orderCount.size() == upStatusCount.size()) {
			// 更新批次表为完成状态 处理中--完成
			TbWithholdingInfoDTO dto = new TbWithholdingInfoDTO();
			String extStatus = WithholdBatchOpStatusEnum.BATCH_PROCESSING.code;
			String status = WithholdBatchOpStatusEnum.BATCH_COMPLETE.code;
			dto.setBatchNo(brechNo);
			withholdMoneyService.updateBatchStatus(status, dto, extStatus);
		}
	}

	private Signature buildSignature() {
		Signature signature = new Signature();
		signature.setSignType("MD5");
		return signature;
	}

	@Override
	public void transStautsQueryExecute() {
		Set<String> batchSet = new HashSet<String>();
		// 1.查询所有状态为004的订单
		List<TbWithholdingOrderInfoPO> list = withholdMoneyService.findInvokCallbackOrder();
		if (list == null || list.isEmpty()) {
			log.info("#transStautsQueryExecute,query order status is 004 list is empty");
			return;
		}
		log.error("transStautsQueryExecute list:{}", ToStringBuilder.reflectionToString(list, ToStringStyle.SHORT_PREFIX_STYLE));
		for (TbWithholdingOrderInfoPO order : list) {
			log.error("transStautsQueryExecute order:{}", ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE));
			// ext 扩展字段存放 产品订单号(transNo)
			if (StringUtils.isEmpty(order.getExt())) continue;

			OrderQueryRequest request = null;
			OrderQueryResponse response = null;
			try {
				request = getInitOrderQueryRequest(order.getExt());
				if (signFlag) {
					// 新签名方式
					SignUtil.signOrderRequest(request, merchantKey);
				} else {
					// 老签名方式
					SignUtil.signOrderQueryRequest(request, merchantKey);
				}
				log.info("queryOrderAPI,request:{}", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE));
				response = queryOrderAPI.queryOrder(request);
				log.info("queryOrderAPI,response:{}", ToStringBuilder.reflectionToString(response, ToStringStyle.SHORT_PREFIX_STYLE));
			} catch (Exception e) {
				log.error("queryOrderAPI is error order:{}", ToStringBuilder.reflectionToString(request, ToStringStyle.SHORT_PREFIX_STYLE), e);
				continue;
			}

			TbWithholdingOrderInfoPO dataDTO = new TbWithholdingOrderInfoPO();
			dataDTO.setStatus(WithholdOrderOpStatusEnum.ORDER_INVOK_CALLBACK.code);
			dataDTO.setMerchantOrderNo(order.getMerchantOrderNo());
			dataDTO.setBatchNo(order.getBatchNo());
			String orderExStatus = "";

			if (StringUtils.isBlank(response.getTransStatus()) || WithholdTransStatusEnum.PROCESSING.code.equals(response.getTransStatus())) {
				continue;
			} else if (WithholdTransStatusEnum.SUCC.code.equals(response.getTransStatus())) {
				orderExStatus = WithholdOrderOpStatusEnum.ORDER_SUCCESS.code;
				dataDTO.setSucessTime(new Date());
				dataDTO.setErrorcode("");
				dataDTO.setErrormsg("");
			} else if (WithholdTransStatusEnum.FAIL.code.equals(response.getTransStatus())) {
				orderExStatus = WithholdOrderOpStatusEnum.ORDER_FAILL.code;
				saveTransLog(response, order, "3");
			} else if (WithholdTransStatusEnum.TIMEOUT.code.equals(response.getTransStatus())) {
				orderExStatus = WithholdOrderOpStatusEnum.ORDER_TIMEOUT.code;
				saveTransLog(response, order, "3");
			}
			if (response.getReturnInfo() != null) {
				dataDTO.setErrorcode(response.getReturnInfo().getErrorCode());
				dataDTO.setErrormsg(response.getReturnInfo().getErrorMsg());
			}
			int rows = withholdMoneyService.updateOrderOpStatus(dataDTO, orderExStatus);
			if (rows > 0) {
				log.info("update success,order:{},expect:{}", ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE),
						ToStringBuilder.reflectionToString(orderExStatus, ToStringStyle.SHORT_PREFIX_STYLE));
			} else {
				log.error("update rows less than 0,order:{},expect:{}", ToStringBuilder.reflectionToString(order, ToStringStyle.SHORT_PREFIX_STYLE),
						ToStringBuilder.reflectionToString(orderExStatus, ToStringStyle.SHORT_PREFIX_STYLE));
			}
		}

		//更新批次表为完成状态
		 List<TbWithholdingBrechInfoPO> brechList=queryNotSucessBatchListByStatus();
		 for (TbWithholdingBrechInfoPO batchPo : brechList) {
			 try {
				updateBatchInfoToSucess(batchPo.getBatchNo());
			} catch (Exception e) {
				log.error("updateBatchInfoToSucess is error,batchNo:{}",new Object[]{batchPo.getBatchNo(),e.getMessage(),e});
			}
		}

	}
	/**
	 * 查询非成功批次状态002（代扣中），003（处理中）的所有批次
	 */
	private List<TbWithholdingBrechInfoPO> queryNotSucessBatchListByStatus(){
		try {
			//002,003
			TbWithholdingBrechInfoExample queryParam=new TbWithholdingBrechInfoExample();
			List<String> batchStatusList=new ArrayList<String>();
			batchStatusList.add(WithholdBatchOpStatusEnum.BATCH_WITHHOLD.code);
			batchStatusList.add(WithholdBatchOpStatusEnum.BATCH_PROCESSING.code);
			queryParam.createCriteria().andStatusIn(batchStatusList);
			List<TbWithholdingBrechInfoPO> brechList=withholdMoneyService.selectBrechByExample(queryParam);
			return brechList;
		} catch (Exception e) {
			log.error("queryNotSucessBatchListByStatus is error",e.getMessage(),e);
			return null;
		}
	}
	/**
	 * 保存日志
	 *
	 * @param response
	 * @param orderPo
	 * @param status
	 */
	private void saveTransLog(OrderQueryResponse response, TbWithholdingOrderInfoPO orderPo, String status) {
		try {
			// 插入日志表记录
			TbWithholdingTransLogPO responsePO = new TbWithholdingTransLogPO();
			responsePO.setBatchNo(orderPo.getBatchNo());
			JSONObject jsonResponse = JSONObject.fromObject(response);
			responsePO.setRequestData(jsonResponse.toString());
			responsePO.setRequestTime(new Date());
			responsePO.setCreateTime(new Date());
			responsePO.setMerchantOrderNo(orderPo.getMerchantOrderNo());
			responsePO.setCardNo(orderPo.getCardNo());
			responsePO.setResulttype(status);
			withholdMoneyService.addTransInfo(responsePO);
		} catch (Exception e) {
			log.error("订单查询job插入log异常：", e);
		}
	}

	private OrderQueryRequest getInitOrderQueryRequest(String transNo) {
		OrderQueryRequest request = new OrderQueryRequest();

		Header head = new Header();
		Sender sender = new Sender();
		Signature sign = new Signature();
		request.setSignature(sign);
		head.setSender(sender);
		head.getSender().setSenderId(senderNo);
		head.setCharset("UTF-8");
		request.setHeader(head);
		request.getSignature().setSignType("MD5");
		request.setTransNo(transNo);
		com.sdo.mas.common.api.common.entity.Service service = new com.sdo.mas.common.api.common.entity.Service();
		head.setService(service);
		Extension ext = new Extension();
		request.setExtension(ext);
		head.getService().setServiceCode(SERVICE_CODE);
		head.getService().setVersion(VERSION);
		head.setSendTime(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
		head.setTraceNo(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));

		return request;
	}

	private CurrencyType getCurrency(String currency) {
		if (currency.equals(WithholdCurrencyEnums.RMB.code)) {
			return CurrencyType.RMB;
		} else if (currency.equals(WithholdCurrencyEnums.JPY.code)) {
			return CurrencyType.JPY;
		} else if (currency.equals(WithholdCurrencyEnums.USD.code)) {
			return CurrencyType.USD;
		} else if (currency.equals(WithholdCurrencyEnums.CAD.code)) {
			return CurrencyType.CAD;
		} else if (currency.equals(WithholdCurrencyEnums.GBP.code)) {
			return CurrencyType.GBP;
		} else if (currency.equals(WithholdCurrencyEnums.AUD.code)) {
			return CurrencyType.AUD;
		} else if (currency.equals(WithholdCurrencyEnums.HKD.code)) {
			return CurrencyType.HKD;
		} else if (currency.equals(WithholdCurrencyEnums.EUR.code)) {
			return CurrencyType.EUR;
		} else if (currency.equals(WithholdCurrencyEnums.SGD.code)) {
			return CurrencyType.SGD;
		} else if (currency.equals(WithholdCurrencyEnums.CHF.code)) {
			return CurrencyType.CHF;
		} else {
			return CurrencyType.RMB;
		}
	}

	/**
	 * 钱包代扣rquest
	 *
	 * @param orderPo
	 * @return
	 * @throws Exception
	 */
	private TransferRequest billingRequest(TbWithholdingOrderInfoPO orderPo) throws Exception {
		TransferRequest request = new TransferRequest();
		request.setVersion(WALLET_VERSION);// 接口版本号,传1.0
		request.setInterfaceType(interFaceType);// 接口类型：Transfer-转账 Billing-代扣
		request.setAppId(ZFNO);// 接口编号（保留字段，默认不用填写）
		request.setMerchantNo(senderNo);// 商户号
		request.setMachineName("machineName");
		request.setSummary("summary");
		TransReqItem reqBody = new TransReqItem();
		reqBody.setAmount(orderPo.getOrderAmount());// 金额

		reqBody.setCurrency(getCurrency(orderPo.getCurrency()));// 货币类型：枚举
		reqBody.setMerchantOrderId(orderPo.getMerchantOrderNo());// 订单号.唯一
		reqBody.setProductDesc(orderPo.getMerchantOrderNo());// 产品备注,如不为空，会做为钱包帐户明细备注

		Payer payer = new Payer();// 付款人
		payer.setMemberId(orderPo.getPt());// 盛大通行证或钱包账户
		payer.setMemberIdType(AccountTypes.PT_ID);// MemberId的类型，枚举：通行证或账户
		reqBody.setPayer(payer);

		Payer toPayer = new Payer();// 收款方
		toPayer.setMemberId(senderNo);// 盛大通行证或钱包账户
		toPayer.setMemberIdType(AccountTypes.MERCHANT_NO);// MemberId的类型，枚举：通行证或账户
		reqBody.setToPayer(toPayer);
		if (!orderPo.getCurrency().equals(WithholdCurrencyEnums.RMB.code)) {
			ArrayOfKvp kvpArray = new ArrayOfKvp();
			List<Kvp> kvpList = kvpArray.getKvp();
			kvpList.add(getKvp("invokeIp", InetAddress.getLocalHost().getHostAddress()));
			kvpList.add(getKvp("idNo", orderPo.getPaperNo()));
			kvpList.add(getKvp("realName", orderPo.getChName()));
			kvpList.add(getKvp("mobile", orderPo.getMobel()));
			reqBody.setExt(kvpArray);// 说明：如果为外币转账或者跨境商户转账，需要在ReqBody的扩展字段中传入实名信息，字段分别是：realName,
										// idNo, mobile，invokeIp
		}
		request.setReqBody(reqBody);
		request.setSignType(signTypeMd5);// 签名类型
		String macInfo = request.getVersion() + "|" + request.getInterfaceType() + "|" + request.getMerchantNo() + "|" + request.getAppId() + "|"
				+ StringUtil.bigScaleUP(reqBody.getAmount().toString(), 2) + "|" + reqBody.getCurrency().value().toUpperCase() + "|"
				+ reqBody.getMerchantOrderId() + "|" + payer.getMemberId() + "|" + payer.getMemberIdType().value().toUpperCase() + "|"
				+ toPayer.getMemberId() + "|" + toPayer.getMemberIdType().value().toUpperCase() + "|" + request.getMachineName() + "|"
				+ request.getSummary();
		String mac = MD5Digest.sign(macInfo, merchantKey, "gb2312");
		log.info("signBefore:{},key:{},signEnd:{}", new Object[] { macInfo, merchantKey, mac });
		request.setMac(mac);// 签名信息
		return request;
	}

	private Kvp getKvp(String key, String value) {
		Kvp kvp = new Kvp();
		kvp.setKey(key);
		kvp.setValue(value);
		return kvp;
	}

	@Override
	public void walletWithholdApply(TbWithholdingOrderInfoPO orderPo) throws WebServiceException,Exception {
		log.info("walletWithholdApply orderPo is start");
		if (null == orderPo) {
			log.error("walletWithholdApply.orderPo is null");
			return;
		}
		log.info("walletWithholdApply start orderPo:{}", ToStringBuilder.reflectionToString(orderPo), ToStringStyle.SHORT_PREFIX_STYLE);
		try {
			TransferRequest request = this.billingRequest(orderPo);

			// 插入日志表记录
			Long logId = addTransLog(orderPo, request, transLogDataRequest);
			// 调用接口
			log.info("transSoap.transfer.start.request:{}", ToStringBuilder.reflectionToString(request));
			TransferResponse response = transSoapAPI.transfer(request);
			log.info("transSoap.transfer.end.response:{}", ToStringBuilder.reflectionToString(response));
			updateTransLog(response, logId);
			orderPo.setRequestTime(new Date());
			if (response == null) {
				orderPo.setStatus(WithholdOrderOpStatusEnum.ORDER_WAIT_FAILL.code);
				TbWithholdingOrderInfoExample example = new TbWithholdingOrderInfoExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(orderPo.getId());
				criteria.andStatusEqualTo(WithholdOrderOpStatusEnum.ORDER_WAIT_CALL.code);
				orderPo.setRequestTime(new Date());
				withholdMoneyService.updateByExampleSelective(orderPo, example);
			} else {
				orderPo.setUpdateTime(new Date());
				updateStatusByResponse(response, orderPo);
			}
		} catch (WebServiceException we) {
			throw new WebServiceException();
		} catch (Exception e) {
			throw new Exception();
		}

	}

}
