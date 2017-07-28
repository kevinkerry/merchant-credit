package com.withdraw.service.test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sdp.mc.common.bean.newt0.LoaningConfigBean;
import com.sdp.mc.common.bean.newt0.PmtMerchantType;
import com.sdp.mc.common.enums.withdraw.PmtTypeEnums;

public class Test {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		LoaningConfigBean bean  = new LoaningConfigBean();
		bean.setFloorAmt(new BigDecimal(11));
		bean.setFsBeginTime("9:00");
		bean.setFsEndTime("21:00");
		String[] holidayFees = {"0.1","0.2"};
		bean.setHolidayFees(holidayFees);
		bean.setWorkdayFees(holidayFees);
		bean.setMinimumMargin(10000);
		bean.setMarginRedeem(2);
		bean.setMinimumMarginRedeem(10000);
		bean.setLoaingType(0);

		List<PmtMerchantType> ptmMerchantType = new ArrayList<PmtMerchantType>();
		PmtMerchantType type1 = new PmtMerchantType();
		type1.setFloorAmt(new BigDecimal(11));
		type1.setFloorAmt(new BigDecimal(11));
		type1.setFsBeginTime("9:00");
		type1.setFsEndTime("21:00");
		type1.setHolidayFees(holidayFees);
		type1.setWorkdayFees(holidayFees);
		type1.setMinimumMargin(10000);
		type1.setMarginRedeem(2);
		type1.setMinimumMarginRedeem(10000);
		type1.setLoaingType(0);
		type1.setMcType("0003");

		PmtMerchantType type2 = new PmtMerchantType();
		type2.setFloorAmt(new BigDecimal(11));
		type2.setFloorAmt(new BigDecimal(11));
		type2.setFsBeginTime("9:00");
		type2.setFsEndTime("21:00");
		type2.setHolidayFees(holidayFees);
		type2.setWorkdayFees(holidayFees);
		type2.setMinimumMargin(10000);
		type2.setMarginRedeem(2);
		type2.setMinimumMarginRedeem(10000);
		type2.setLoaingType(0);
		type2.setMcType("0001");
		ptmMerchantType.add(type1);
		ptmMerchantType.add(type2);

		bean.setPtmMerchantType(ptmMerchantType);

		String config1 = "{'floorAmt':100,'holidayFees':['0.002','0.0025','0.003','0.0035'],'loaingType':0,'marginRedeem':2,'minimumMargin':100000,'minimumMarginRedeem':2,'workdayFees':['0.002','0.0025','0.003'],'fsBeginTime':'8:00','fsEndTime':'22:00'}";
		LoaningConfigBean config = LoaningConfigBean.json2Bean(config1);
		List<PmtMerchantType> ptmMerchantTypeList = new ArrayList<PmtMerchantType>();
		PmtMerchantType type11 = new PmtMerchantType();
		BeanUtils.copyProperties(config, type11);
		type11.setMcType(PmtTypeEnums.PMT_POS_MERCHANT_TYPE.code);
		PmtMerchantType type22 = new PmtMerchantType();
		BeanUtils.copyProperties(config, type22);
		type22.setMcType(PmtTypeEnums.PMT_MPOS_MERCHANT_TYPE.code);
		ptmMerchantTypeList.add(type11);
		ptmMerchantTypeList.add(type22);
		config.setPtmMerchantType(ptmMerchantTypeList);
		System.err.println(config);
	}
}
