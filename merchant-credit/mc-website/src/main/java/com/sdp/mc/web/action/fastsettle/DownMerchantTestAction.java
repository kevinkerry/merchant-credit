package com.sdp.mc.web.action.fastsettle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.mc.common.web.MCMerchantUser;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.PmtQueryPosMerchantPO;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExampleExt;
import com.sdp.mc.ffconfig.dao.ext.FastSettleConfigDOExt;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.web.action.BaseAction;
import com.sdp.mc.common.util.NumberUtils;

@Controller
@RequestMapping(value = { "/posPromoter", "/mposPromoter" })
public class DownMerchantTestAction extends BaseAction {
	private static final Logger log = LoggerFactory.getLogger(DownMerchantTestAction.class);
	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;

	/**
	 * 自动快速结算商户管理--下载结果
	 *
	 * @throws Exception
	 * **/
	@RequestMapping(value = "/aaa")
	public void aaa(@ModelAttribute("query") FastSettleConfigDOExampleExt query, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws Exception {
		query.setNeedQeryTotal(true);
		List<FastSettleConfigDOExt> dataList = this.fastSettleConfigManager.selectByQuery4Intra(query);
		StringBuffer buff = new StringBuffer();
		buff.append("ID,盛付通商户号,商户名称,商户类型类型,自动快速结算,是否开通快速结算,单日最高额度,拓展方商户号,拓展方名称,拓展方保证金,拓展方额度\r\n");
		if (dataList != null && !dataList.isEmpty()) {
			log.info("dataList:" + dataList.size());
			for (int i = 0; i < dataList.size(); i++) {
				String rowStr = getRowInfo(dataList.get(i));
				buff.append(rowStr);
				// buff.append("ID,").append(i).append("盛付通商户号,商户名称,商户类型类型,自动快速结算,是否开通快速结算,单日最高额度,拓展方商户号,拓展方名称,拓展方保证金,拓展方额度\r\n");
				log.info("dataList iterator:" + i);
			}
		}
		log.info("buff toStirng:" + buff.toString().length() + "," + buff.toString());

		String fileName = "merchantlist_" + DateUtil.date2Str(new Date(), DateUtil.forOrderFormat) + ".csv";
		response.setContentType("application/octet-stream;charset=GBK");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "GBK"));
		// response.setBufferSize(10240);
		byte[] buffer = new byte[4096];// 缓冲区
		BufferedOutputStream output = null;
		BufferedInputStream input = null;
		try {
			byte[] byteData = buff.toString().getBytes("GBK");
			output = new BufferedOutputStream(response.getOutputStream());
			input = new BufferedInputStream(new ByteArrayInputStream(byteData));
			int n;
			StringBuffer tmpBuf = new StringBuffer();
			// 遍历，开始下载
			while ((n = input.read(buffer, 0, 4096)) > -1) {
				output.write(buffer, 0, n);
				output.flush(); // 不可少
				log.info("n:" + n);
				tmpBuf.append(new String(byteData, 0, n));
			}
			log.info("resutl Str:" + tmpBuf.toString());

		} catch (Exception e) {
			log.error("NewT0SettleIntraAction.downloadMerchantQueryResult error:" + e, e);
		} finally {
			// 关闭流，不可少
			if (input != null) {
				input.close();
			}
			if(output!=null){
				output.close();
			}
		}
	}

	private String getRowInfo(FastSettleConfigDOExt doExt) {
		StringBuffer buff = new StringBuffer();
		buff.append("-" + ",");
		buff.append((doExt.getMcMerchantNo() == null ? "-" : doExt.getMcMerchantNo()) + ",");
		buff.append((doExt.getMcMerchantName() == null ? "-" : doExt.getMcMerchantName()) + ",");
		buff.append(getMcTypeName(doExt.getMcType()) + ",");
		buff.append((doExt.getAutoFastSettle() != null && doExt.getAutoFastSettle() >= 1 ? "是" : "否") + ",");
		buff.append(("1".equals(doExt.getMerchantFastSettleFlag()) ? "开通" : "关闭") + ",");
		buff.append("s" + ",");
		buff.append((doExt.getPromoterMerchantNo() == null ? "-" : doExt.getPromoterMerchantNo()) + ",");
		buff.append((doExt.getPromoterName() == null ? "-" : doExt.getPromoterName()) + ",");
		buff.append((doExt.getPmt_fast_settle_margin() == null ? "-" : doExt.getPmt_fast_settle_margin()) + ",");
		buff.append((doExt.getPmt_fast_settle_limit() == null ? "-" : doExt.getPmt_fast_settle_limit()) + "-");
		buff.append("\r\n");
		return buff.toString();
	}

	private String getRowInfo1(FastSettleConfigDOExt doExt) {
		StringBuffer buff = new StringBuffer();
		buff.append((doExt.getPfcId() == null ? "-" : doExt.getPfcId()) + ",");
		buff.append((doExt.getMcMerchantNo() == null ? "-" : doExt.getMcMerchantNo()) + ",");
		buff.append((doExt.getMcMerchantName() == null ? "-" : doExt.getMcMerchantName()) + ",");
		buff.append(getMcTypeName(doExt.getMcType()) + ",");
		buff.append((doExt.getAutoFastSettle() != null && doExt.getAutoFastSettle() >= 1 ? "是" : "否") + ",");
		buff.append(("1".equals(doExt.getMerchantFastSettleFlag()) ? "开通" : "关闭") + ",");
		buff.append((NumberUtils.format(doExt.getLimitAmount()) == null ? "-" : NumberUtils.format(doExt.getLimitAmount())) + ",");
		buff.append((doExt.getPromoterMerchantNo() == null ? "-" : doExt.getPromoterMerchantNo()) + ",");
		buff.append((doExt.getPromoterName() == null ? "-" : doExt.getPromoterName()) + ",");
		buff.append((doExt.getPmt_fast_settle_margin() == null ? "-" : doExt.getPmt_fast_settle_margin()) + ",");
		buff.append((doExt.getPmt_fast_settle_limit() == null ? "-" : doExt.getPmt_fast_settle_limit()) + "-");
		buff.append("\r\n");
		return buff.toString();
	}

	private String getMcTypeName(String mcType) {
		if (mcType == null) { return " "; }
		if ("0001".equals(mcType)) {
			return "普通POS商户";
		} else if ("0005".equals(mcType)) {
			return "miniPOS商户";
		} else if ("0006".equals(mcType)) { return "mPOS商户"; }
		return mcType;
	}

	private PmtQueryPosMerchantPO buildPmtQueryPosMerchantPO(PmtQueryPosMerchantPO query, MCMerchantUser user) {
		PmtQueryPosMerchantPO po = new PmtQueryPosMerchantPO();
		BeanUtils.copyProperties(query, po);
		po.setPmtMerchantNo(user.getMerchantNo());
		po.setPmtMemberId(user.getMemberId());
		if (MerchantContractCst.TYPE_PROMOTER.equals(user.getCurrentMcType())) {
			po.setType(MerchantContractCst.TYPE_POS_MERCHANT);
		} else if (MerchantContractCst.TYPE_MPOS_PROMOTER.equals(user.getCurrentMcType())) {
			po.setType(MerchantContractCst.TYPE_MPOS_MERCHANT);
		}
		// po.setType(MerchantContractCst.TYPE_POS_MERCHANT);
		return po;
	}
}
