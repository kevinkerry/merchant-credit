package com.sdp.mc.facade.msp.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caucho.hessian.client.HessianProxyFactory;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.hessian.RemotingCallUtil;
import com.sdp.mc.common.hessian.RemotingModuleEnum;
import com.sdp.mc.common.util.ConfigOptionHelper;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.config.manager.ConfigOptionManager;
import com.sdp.mc.facade.msp.FastSettleHessianInterface;
import com.sdp.mc.service.newt0.Newt0PromoterService;
import com.shengpay.pos.pcs.api.settle.StraightlyCfg;
import com.shengpay.pos.pcs.api.settle.StraightlySettle;
import com.shengpay.pos.pcs.api.settle.StraightlySettleResult;
import com.shengpay.pos.pcs.api.settle.ValidOrders;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleCfg;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleFundOutInfo;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleResult;
import com.shengpay.pos.pcs_t0.api.fastsettle.FastSettleService;
import com.shengpay.pos.pcs_t0.api.fastsettle.ValidOrder;

/**
 * msp系统快速结算接口代理类，包装老接口和新接口，支持新老接口切换
 *
 * @author wangjingao.william
 */
@Service("FastSettleHessianInterfaceProxy")
public class FastSettleHessianInterfaceProxy implements FastSettleHessianInterface {

	private static Logger logger = LoggerFactory.getLogger(FastSettleHessianInterfaceProxy.class);

	@Autowired
	private ConfigOptionManager configOptionManager;

	private StraightlySettle straightlySettle;

	private FastSettleService fastSettleService;

	@Autowired
	private Newt0PromoterService newt0PromoterService;


	private StraightlySettle getStraightlySettle() {
		if (straightlySettle == null) {
			straightlySettle = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.STRAIGHTLY_SETTLE_MODULE, StraightlySettle.class);
		}
		return straightlySettle;
	}

	private FastSettleService getFastSettleService() {
		if (fastSettleService == null) {
			fastSettleService = RemotingCallUtil.getHessianServiceByModuleWithoutCanonicalName(RemotingModuleEnum.NEWT0_SETTLE_MODULE, FastSettleService.class);
		}
		return fastSettleService;
	}

	/**
	 * 手动发起结算
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerposMerchantNo
	 *            * POS商户编号
	 * @param ids
	 *            订单号集
	 * @return
	 */
	public ErrorMessageVO straightlySettle(String merchantNo, String posMerchantNo, List<Long> ids, String bizId, Integer shareType) {
		Boolean isSwitchOff = this.isSwitchOff(merchantNo, posMerchantNo, null);
		logger.info("FastSettleHessianInterfaceProxy.straightlySettle.merchantNo=" + merchantNo + ",posMerchantNo=" + posMerchantNo + ",isSwitchOff=" + isSwitchOff);
		if (isSwitchOff) {
			StraightlySettleResult result = getStraightlySettle().straightlySettle(merchantNo, posMerchantNo, ids);
			boolean flag = StraightlySettleResult.SUCESS == result;
			return new ErrorMessageVO(flag, result.getCode(), result.getMsg());
		} else {
			FastSettleResult result = getFastSettleService().fastSettle(merchantNo, posMerchantNo, ids, bizId, shareType);
			boolean flag = FastSettleResult.SUCESS == result;
			return new ErrorMessageVO(flag, result.getCode(), result.getMsg());
		}
	}

	/**
	 * 查询可发起快速结算的订单编号
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return
	 */
	public List<ValidOrders> queryValidOrderList(String merchantNo, String posMerchantNo) {
		Boolean isSwitchOff = this.isSwitchOff(merchantNo, posMerchantNo, null);
		logger.info("FastSettleHessianInterfaceProxy.queryValidOrderList.merchantNo=" + merchantNo + ",posMerchantNo=" + posMerchantNo + ",isSwitchOff=" + isSwitchOff);
		if (isSwitchOff) {
			List<ValidOrders> list = getStraightlySettle().queryValidOrderList(merchantNo, posMerchantNo);
			return list;
		} else {
			List<ValidOrder> list = getFastSettleService().queryValidOrderList(merchantNo, posMerchantNo);
			if (list != null) {
				List<ValidOrders> list2 = new ArrayList<ValidOrders>();
				for (ValidOrder validOrder : list) {
					ValidOrders vo = new ValidOrders(validOrder.getOrderId(), validOrder.isSelected());
					list2.add(vo);
				}
				return list2;
			}
		}
		return null;
	}

	/**
	 * 获取快速结算配置
	 *
	 * @param merchantNo
	 *            商户编号
	 * @param posMerchantNo
	 *            POS商户编号
	 * @return
	 */
	public StraightlyCfg getStraightlyCfg(String merchantNo, String posMerchantNo) {
		logger.info("FastSettleHessianInterfaceProxy #getStraightlyCfg,merchantNo:" + merchantNo + ",posMerchantNo:" + posMerchantNo);
		Boolean isSwitchOff = this.isSwitchOff(merchantNo, posMerchantNo, null);
		logger.info("FastSettleHessianInterfaceProxy.getStraightlyCfg.merchantNo=" + merchantNo + ",posMerchantNo=" + posMerchantNo + ",isSwitchOff=" + isSwitchOff);
		if (isSwitchOff) {
			StraightlyCfg straightlyCfg = getStraightlySettle().getStraightlyCfg(merchantNo, posMerchantNo);
			logger.info("FastSettleHessianInterfaceProxy #getStraightlyCfg,straightlyCfg:" + ToStringBuilder.reflectionToString(straightlyCfg));
			return straightlyCfg;
		} else {
			FastSettleCfg fsc = getFastSettleService().getMerchantFastSettleCfg(merchantNo, posMerchantNo);
			/**
			 * 00-成功 ,01-商户无权限或配置错误 ,12-商户快速结算规则未配置或已失效, 99-未知错误
			 * **/
			logger.info("FastSettleHessianInterfaceProxy #getStraightlyCfg,FastSettleCfg:" + ToStringBuilder.reflectionToString(fsc));
			if (fsc != null && (StraightlySettleResult.MERCHANT_HAS_NO_RIGHT.getCode().equals(fsc.getCheckResultCode()) || "12".equals(fsc.getCheckResultCode()))) {
				StraightlyCfg sc = new StraightlyCfg();
				BeanUtils.copyProperties(fsc, sc);
				sc.setMid(fsc.getMerchantNo());
				sc.setPosMerchantId(fsc.getPosMerchantNo());
				sc.setPid(fsc.getPromoterId());
				// 标志位和老接口保持一致
				sc.setStraightFlag(false);
				return sc;
			}
			if (fsc != null && StraightlySettleResult.SUCESS.getCode().equals(fsc.getCheckResultCode())) {
				StraightlyCfg sc = new StraightlyCfg();
				BeanUtils.copyProperties(fsc, sc);
				sc.setMid(fsc.getMerchantNo());
				sc.setPosMerchantId(fsc.getPosMerchantNo());
				sc.setPid(fsc.getPromoterId());
				sc.setStraightFlag(fsc.isFastSettleFlag());
				return sc;
			}
		}
		return null;
	}

	/**
	 * 获取代理商快速结算配置
	 *
	 * @param promoterId
	 * @return
	 */
	public StraightlyCfg getPromoterStraightlyCfg(Long promoterId) {
		Boolean isSwitchOff = this.isSwitchOff(null, null, promoterId);
		logger.info("FastSettleHessianInterfaceProxy.getStraightlyCfg.promoterId=" + promoterId + ",isSwitchOff=" + isSwitchOff);
		if (isSwitchOff) {
			return getStraightlySettle().getPromoterStraightlyCfg(promoterId);
		} else {
			FastSettleCfg fsc = getFastSettleService().getPromoterFastSettleCfg(promoterId);
			logger.info("FastSettleHessianInterfaceProxy.getPromoterStraightlyCfg.promoterId=" + promoterId + ",fsc=" + ToStringBuilder.reflectionToString(fsc));
			if (fsc != null && StraightlySettleResult.PROMOTER_HAS_NO_RIGHT.getCode().equals(fsc.getCheckResultCode())) {
				StraightlyCfg sc = new StraightlyCfg();
				BeanUtils.copyProperties(fsc, sc);
				sc.setMid(fsc.getMerchantNo());
				sc.setPosMerchantId(fsc.getPosMerchantNo());
				sc.setPid(fsc.getPromoterId());
				// 标志位和老接口保持一致
				sc.setStraightFlag(false);
				return sc;
			}
			if (fsc != null && StraightlySettleResult.SUCESS.getCode().equals(fsc.getCheckResultCode())) {
				StraightlyCfg sc = new StraightlyCfg();
				BeanUtils.copyProperties(fsc, sc);
				sc.setMid(fsc.getMerchantNo());
				sc.setPosMerchantId(fsc.getPosMerchantNo());
				sc.setPid(fsc.getPromoterId());
				sc.setStraightFlag(fsc.isFastSettleFlag());
				return sc;
			}
		}
		return null;
	}

	/**
	 * 查询快速结算及出账信息
	 *
	 * @param list
	 * @return
	 */
	public List<FastSettleFundOutInfo> queryFastSettleFundOutInfo(List<String> list) {
		try {
			return getFastSettleService().queryFastSettleFundOutInfo(list);
		} catch (Exception e) {
			logger.error("FastSettleHessianInterfaceProxy#queryFastSettleFundOutInfo is null"+e.getMessage(),e);
			return null;
		}

	}

	/**
	 * 获取垫资方
	 *
	 * @param promoterId
	 * @return
	 */
	private boolean isSwitchOff(String merchantNo, String posMerchantNo, Long promoterId) {
		Boolean newt0mock = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.NEW_T0_MOCK);
		logger.info("FastSettleHessianInterfaceProxy.isSwitchOff.newt0mock=" + newt0mock);
		if (newt0mock) {// mock用旧的（测试时候用）
			return true;
		}
		if (promoterId == null) {
			/*CmPosMerchantEO cmPosMerchantEO = cmPosMerchantDAO.queryPosMerchantByNo(posMerchantNo);
			//TODO 集测遇到cmPosMerchantEO null 导致功能不可用
			if(null==cmPosMerchantEO)return false;
			promoterId = cmPosMerchantEO.getPosmPromoterId();*/
		}
		logger.info("FastSettleHessianInterfaceProxy.isSwitchOff.posMerchantNo=" + posMerchantNo + " promoterId=" + (promoterId == null ? "null" : promoterId));
		Integer loaningType = newt0PromoterService.getLoaningTypeByPromoterId(promoterId);
		boolean isPromoter = (LoaningTypeEnum.PROMOTER == LoaningTypeEnum.getLoaningTypeEnum(loaningType));
		logger.info("FastSettleHessianInterfaceProxy.isSwitchOff.posMerchantNo=" + posMerchantNo + " promoterId=" + (promoterId == null ? "null" : promoterId) + " isPromoter="
				+ isPromoter);
		if (!isPromoter) {// 盛付通垫资用新的
			return false;
		} else {// 用于控制代理商垫资以后的切换
			Boolean isSwitchOff = ConfigOptionHelper.getBooleanByKey(MerchantCreditConstant.NEWT0_INTERFACE_SWITCH_OFF);
			logger.info("FastSettleHessianInterfaceProxy.getPromoterStraightlyCfg.posMerchantNo=" + posMerchantNo + " promoterId=" + (promoterId == null ? "null" : promoterId)
					+ " isSwitchOff=" + isSwitchOff);
			return isSwitchOff;
		}
	}

	public static void main(String[] args) {
		try {
			// String url =
			// "http://10.132.97.105:8083/pcs_t0_facade/hessian/fastSettle";
			String url = "http://10.241.80.74:8082/pcs_t0_facade/hessian/fastSettle";
			HessianProxyFactory factory = new HessianProxyFactory();
			factory.setChunkedPost(false);
			factory.setOverloadEnabled(true);
			FastSettleService service = (FastSettleService) factory.create(FastSettleService.class, url);
			List<String> list = new ArrayList<String>();
			list.add("358");
			List<FastSettleFundOutInfo> resultList = service.queryFastSettleFundOutInfo(list);
			for (FastSettleFundOutInfo fastSettleFundOutInfo : resultList) {
				System.out.println(ToStringBuilder.reflectionToString(fastSettleFundOutInfo));
			}
			System.out.println("==============");
			FastSettleCfg cfg = service.getMerchantFastSettleCfg("710816", "820290057320003");
			System.out.println(ToStringBuilder.reflectionToString(cfg));
		} catch (Exception e) {
			logger.error("FastSettleHessianInterfaceProxy.error" + e.getMessage(), e);
		}
	}
}
