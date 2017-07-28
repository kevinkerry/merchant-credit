package com.withdraw.service.test.fos;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

import com.sdp.fos.model.AppRemitWithdrawOrder;
import com.sdp.fos.model.RemitTransferRequest;
import com.sdp.fos.model.TransferOrderOrigApplication;
import com.sdp.fos.model.WithdrawRequest;
import com.sdp.fos.model.WithdrawResponse;
import com.sdp.fos.service.RemitTransferService;
import com.sdp.fos.service.WithdrawService;
import com.sdp.mc.common.constant.MerchantCreditConstant;
import com.sdp.mc.integration.fos.dto.request.RemitTransferRequestDTO;
import com.sdp.mc.integration.fos.enums.FOSPaymentCodeEnum;
import com.sdp.mc.integration.fos.enums.FOSProductCodeEnum;

/**
 * 单笔出款
 */
public class TestWithdrawTransferService {

	private RemitTransferService remitTransferService;
	private WithdrawService withdrawService;
	private String fosCallbackURL = "http://127.0.0.1/test/xx";

	@Before
	public void init(){
		//单笔出款（集测环境）
		String url = "http://10.132.97.67:8081/fos/services/withdrawService?wsdl";
		//转账
//		String url = "http://10.132.97.67:8081/fos/services/remitTransferService?wsdl";
		org.apache.cxf.jaxws.JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(url);
		//转账
//		factory.setServiceClass(RemitTransferService.class);
//		remitTransferService = (RemitTransferService) factory.create();
		//出款
		factory.setServiceClass(WithdrawService.class);
		withdrawService = (WithdrawService) factory.create();
	}

	@Test
	public void testTransfer(){
		//转账
		RemitTransferRequestDTO requestDTO = buildRemitTransferRequestDTO();
//		RemitTransferRequest request = buildTransferRequestAndSetCallbackAddress(requestDTO);
//		RemitTransferResponse response = this.remitTransferService.transfer(request);
//		System.out.println("转账返回:"+ToStringBuilder.reflectionToString(response));

		//出款
		WithdrawRequest paramWithdrawRequest = buildWithRequestAndSetCallbackAddress(requestDTO);
		WithdrawResponse withResponse = withdrawService.withdraw(paramWithdrawRequest);
		System.out.println("出款返回:"+ToStringBuilder.reflectionToString(withResponse));
	}


	/**
	 * 出款参数
	 * @param requestDTO
	 * @return
	 */
	private WithdrawRequest buildWithRequestAndSetCallbackAddress(RemitTransferRequestDTO requestDTO) {
		// TODO Auto-generated method stub
		WithdrawRequest paramWithdrawRequest = new WithdrawRequest();

		AppRemitWithdrawOrder withdrawOrder = new AppRemitWithdrawOrder();

		withdrawOrder.setProductCode(requestDTO.getProductCode().code);// 产品编码
		withdrawOrder.setSourceCode(requestDTO.getAppId());
		withdrawOrder.setPaymentCode(requestDTO.getPaymentCode().code);
		// TODO:根据 PaymentCode 判断 payerAccountType payeeAccountType
		// productCode+ paymentCode+ remitVoucherNo:要求唯一
		withdrawOrder.setRemitVoucherNo(requestDTO.getRemitVoucherNo());// 转账订单号,32位
		withdrawOrder.setPayerMemberId(requestDTO.getPayerMemberId());// 付款人会员ID
//		withdrawOrder.setPayeeMemberId(requestDTO.getPayeeMemberId());// 收款人会员ID
		withdrawOrder.setNeedCountFee(false);// 是否需要计费,1：计费；0：不计费
		withdrawOrder.setPayerFee(BigDecimal.valueOf(0));// 付款人费用
		withdrawOrder.setPayeeFee(BigDecimal.valueOf(0));// 收款人费用

		withdrawOrder.setPayerAccountType(requestDTO.getPayerAccountType());// 付款方账户类型
		withdrawOrder.setPayerAccountNo(requestDTO.getPayerAccountNo());// 付款人储值账户ID
//		withdrawOrder.setPayeeAccountType(requestDTO.getPayeeAccountType());// 收款人账户类型
//		withdrawOrder.setPayeeAccountNo(requestDTO.getPayeeAccountNo());// 收款人储值账户ID

		withdrawOrder.setGmtBizInitiate(new Date());// 业务发起时间,例如：20071117020101
		withdrawOrder.setGmtPaymentInitiate(new Date());// 支付发起时间
		withdrawOrder.setRemitAmount(requestDTO.getRemitAmount());// 转账金额
		withdrawOrder.setMemo(requestDTO.getMemo());// 备注信息,储值系统要求不能为空
		withdrawOrder.setPemitPricingErr(false);// 是否允许计费异常
		withdrawOrder.setCurrency("CNY");// 不传默认为CNY

		withdrawOrder.setRemitVoucherNo("321456");
		withdrawOrder.setBankCity("12346587");
		withdrawOrder.setBankName("test");
		withdrawOrder.setBankBranch("test");
		withdrawOrder.setBankLineNo("1646486");
		withdrawOrder.setBankProvince("546416");
		withdrawOrder.setBankCity("test");
		withdrawOrder.setPayeeName("test");
		withdrawOrder.setPayeeCardNo("26346161");

		paramWithdrawRequest.setWithdrawOrder(withdrawOrder);
		paramWithdrawRequest.setExtension("test");

		paramWithdrawRequest.getWithdrawOrder().setCallbackAddress(fosCallbackURL);

		return paramWithdrawRequest;
	}

	/**
	 * 转账参数
	 * @return
	 */
	private RemitTransferRequestDTO buildRemitTransferRequestDTO() {
		// TODO Auto-generated method stub
		RemitTransferRequestDTO dto = new RemitTransferRequestDTO();
		dto.setAppId("12346");
		dto.setBizId("32146");
		dto.setBizType("123");
		dto.setPayeeAccountNo("622578954411233512");
		dto.setPayeeAccountType(1L);
		dto.setPayeeMemberId("1324689");

		dto.setPayerAccountNo("123456");
		dto.setPayerAccountType(1L);
		dto.setPayerMemberId("123465");
		dto.setPaymentCode(FOSPaymentCodeEnum.CREDIT_PAYMENT_CODE_02);
		dto.setProductCode(FOSProductCodeEnum.MC_FOS_CREDIT_PRODUCT_CODE);

		dto.setMemo("test");
		dto.setMarginTransId(12L);

		dto.setRemitAmount(new BigDecimal(0));
		dto.setRemitVoucherNo("123456");

		return dto;
	}
	/**
	 * 转账参数
	 * @param requestDTO
	 * @return
	 */
	private RemitTransferRequest buildTransferRequestAndSetCallbackAddress(RemitTransferRequestDTO requestDTO) {
		RemitTransferRequest request = buildRemitTransferRequest(requestDTO);
		request.getTransferOrder().setCallbackAddress(fosCallbackURL);
		return request;
	}

	/**
	 * 转账
	 * @param requestDTO
	 * @return
	 */
	public static RemitTransferRequest buildRemitTransferRequest(RemitTransferRequestDTO requestDTO) {
		TransferOrderOrigApplication tooa = new TransferOrderOrigApplication();
		if (requestDTO.getProductCode() != null) {
			tooa.setProductCode(requestDTO.getProductCode().code);// 产品编码
		} else {
			tooa.setProductCode(MerchantCreditConstant.MC_FOS_MARGIN_PRODUCT_CODE);// 产品编码
		}
		if (!"".equals(requestDTO.getAppId()) && requestDTO.getAppId() != null) {
			tooa.setSourceCode(requestDTO.getAppId());
		} else {
			tooa.setSourceCode(requestDTO.getAppId());
		}
		// 支付编码,2001:基本户到子账户,2101:子账户到基本户
		tooa.setPaymentCode(requestDTO.getPaymentCode().code);
		// productCode+ paymentCode+ remitVoucherNo:要求唯一
		tooa.setRemitVoucherNo(requestDTO.getRemitVoucherNo());// 转账订单号,32位
		tooa.setPayerMemberId(requestDTO.getPayerMemberId());// 付款人会员ID
		tooa.setPayeeMemberId(requestDTO.getPayeeMemberId());// 收款人会员ID
		tooa.setNeedCountFee(false);// 是否需要计费,1：计费；0：不计费
		tooa.setPayerFee(BigDecimal.valueOf(0));// 付款人费用
		tooa.setPayeeFee(BigDecimal.valueOf(0));// 收款人费用

		tooa.setPayerAccountType(requestDTO.getPayerAccountType());// 付款方账户类型
		tooa.setPayerAccountNo(requestDTO.getPayerAccountNo());// 付款人储值账户ID
		tooa.setPayeeAccountType(requestDTO.getPayeeAccountType());// 收款人账户类型
		tooa.setPayeeAccountNo(requestDTO.getPayeeAccountNo());// 收款人储值账户ID

		tooa.setGmtBizInitiate(new Date());// 业务发起时间,例如：20071117020101
		tooa.setGmtPaymentInitiate(new Date());// 支付发起时间
		tooa.setRemitAmount(requestDTO.getRemitAmount());// 转账金额
		tooa.setMemo(requestDTO.getMemo());// 备注信息,储值系统要求不能为空
		tooa.setPemitPricingErr(false);// 是否允许计费异常
		tooa.setCurrency("CNY");// 不传默认为CNY
		RemitTransferRequest request = new RemitTransferRequest();
		request.setTransferOrder(tooa);
		return request;
	}
}
