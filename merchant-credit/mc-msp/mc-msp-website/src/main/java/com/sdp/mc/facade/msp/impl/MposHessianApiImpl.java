package com.sdp.mc.facade.msp.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.gson.Gson;
import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.AlertMessageSendTypeEnum;
import com.sdp.mc.common.enums.FsConfigChangeStatusEnum;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.OpObjTypeEnums;
import com.sdp.mc.common.enums.StraightlySettleResultEnums;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.dao.readonly.merchantSettleItem.MerchantSettleItemDAO;
import com.sdp.mc.dao.readonly.merchantSettleItem.MerchantSettleItemEO;
import com.sdp.mc.dao.readonly.merchantsettle.MerchantSettleDAO;
import com.sdp.mc.dao.readonly.merchantsettle.MerchantSettleEO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantDAO;
import com.sdp.mc.dao.readonly.msp.mspposmerchant.MspPosMerchantEO;
import com.sdp.mc.dao.readonly.msptxn.McSettFastTxnRO;
import com.sdp.mc.dao.readonly.msptxn.MspTxnDAO;
import com.sdp.mc.dao.readonly.msptxn.mc.McMspTxnVO;
import com.sdp.mc.dao.readonly.posmerchant.PosMerchantDAO;
import com.sdp.mc.dao.readonly.posmerchant.PosMerchantEO;
import com.sdp.mc.dao.readonly.promoter.PromoterDAO;
import com.sdp.mc.dao.readonly.promoter.PromoterEO;
import com.sdp.mc.integration.ma.dto.Promoter4MADTO;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsTradeDO;
import com.sdp.mc.merchant.manager.MerchantFsRManager;
import com.sdp.mc.merchant.manager.MerchantFsTradeManager;
import com.sdp.mc.msp.api.MposHessianApi;
import com.sdp.mc.msp.api.vo.ApplyResult;
import com.sdp.mc.msp.api.vo.FastSettleCfg;
import com.sdp.mc.msp.api.vo.MposFastSettleInfo;
import com.sdp.mc.msp.api.vo.ValidOrderResult;
import com.sdp.mc.msp.dao.FsConfigChangeDO;
import com.sdp.mc.msp.manager.FsConfigChangeManager;
import com.sdp.mc.newt0.dao.Newt0PromoterDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.manager.ExtNewt0SdpRemainBalanceManager;
import com.sdp.mc.newt0.manager.Newt0PromoterManager;
import com.sdp.mc.sars.SarsService;
import com.sdp.mc.sars.bean.SarsCP261Bean;
import com.sdp.mc.sars.bean.SarsCP281Bean;
import com.shengpay.boss.service.crm.query.api.DelegationPay2CardQueryService;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardInfo;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryRequest;
import com.shengpay.boss.service.crm.query.api.model.DelegationPay2CardQueryResponse;
import com.shengpay.facade.ma.MAFacade;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettlePO;
import com.shengpay.pos.operating.api.pcs.settle.MerchantSettleRO;
import com.shengpay.pos.operating.api.pcs.settle.PromoterSettlePO;
import com.shengpay.pos.operating.api.pcs.settle.PromoterSettleRO;
import com.shengpay.pos.operating.api.pcs.settle.SettleInfoInterface;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.pos.pcs.api.settle.StraightlySettleResult;
import com.shengpay.pos.pcs.api.settle.ValidOrders;
import com.shengpay.service.alert.factory.AlertMessageSenderFactory;
import com.shengpay.service.crm.CrmService;
import com.shengpay.service.mail.AlertMessageSender;

@Service("MposHessianApi")
public class MposHessianApiImpl implements MposHessianApi {

	private static Logger logger = LoggerFactory.getLogger(MposHessianApiImpl.class);

	@Override
	public MposFastSettleInfo getMposFastSettleInfo(String merchantNo,
			String posMerchantNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplyResult applyMposFastSettle(String merchantNo,
			String posMerchantNo, String[] txnIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValidOrderResult queryValidOrderList(String merchantNo,
			String posMerchantNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FastSettleCfg getMerchantFastSettleCfg(String merchantNo,
			String posMerchantNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
