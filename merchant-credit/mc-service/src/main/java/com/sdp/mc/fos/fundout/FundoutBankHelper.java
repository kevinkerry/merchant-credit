package com.sdp.mc.fos.fundout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sdp.fos.baseservice.model.FundoutBank;
import com.sdp.fos.baseservice.model.FundoutBankDetail;
import com.sdp.fos.baseservice.model.FundoutRequiredField;

/**
 * 出款银行
 */
public class FundoutBankHelper {	
	/**
	 * 所有对公银行列表(缓存)
	 */
	private static List<FundoutBankRO> ALL_COMPANY_BANK_LIST = new ArrayList<FundoutBankRO>();
	
	/**
	 * 所有对私银行列表(缓存)
	 */
	private static List<FundoutBankRO> ALL_PERSONAL_BANK_LIST = new ArrayList<FundoutBankRO>();
	
	private static final String BANK_PROVINCE="bankProvince";
	private static final String BANK_BRANCH="bankBranch";
	
	/**
	 * 所有对公银行是否支持直连列表(缓存)
	 */
	private static Map<String, Boolean> ALL_COMPANY_BANK_SUPPORT_DIRECT_LIST = new HashMap<String, Boolean>();
	/**
	 * 所有对公银行是否支持直连列表(缓存)
	 */
	private static Map<String, Boolean> ALL_PERSONAL_BANK_SUPPORT_DIRECT_LIST = new HashMap<String, Boolean>();
	
	/**
	 * 所有对公银行初始化
	 */
	public static void initAllCompanyBankList( List<FundoutBank> list ){
		List<FundoutBankRO> newList = new ArrayList<FundoutBankRO>( list.size() );
		for( FundoutBank fb : list ){
			if( StringUtils.isNotBlank( fb.getBankCode() ) && StringUtils.isNotBlank( fb.getBankName() ) ){
				FundoutBankRO ro=new FundoutBankRO( fb.getBankCode(), fb.getBankName() );
				List<Boolean>s=new ArrayList<Boolean>();
				s.add(0,false);
				s.add(1,false);
				ro.setS(s);
				setRequiredField(s, fb);
				newList.add( ro );
				ALL_COMPANY_BANK_SUPPORT_DIRECT_LIST.put(fb.getBankCode(), fb.isSupportDirect());
			}
		}
		ALL_COMPANY_BANK_LIST = newList;
	}

	/**
	 * 所有对私银行初始化
	 */
	public static void initAllPersonalBankList( List<FundoutBank> list ){
		List<FundoutBankRO> newList = new ArrayList<FundoutBankRO>( list.size() );
		for( FundoutBank fb : list ){
			if( StringUtils.isNotBlank( fb.getBankCode() ) && StringUtils.isNotBlank( fb.getBankName() ) ){
				FundoutBankRO ro=new FundoutBankRO( fb.getBankCode(), fb.getBankName() );
				List<Boolean>s=new ArrayList<Boolean>();
				s.add(0,false);
				s.add(1,false);
				ro.setS(s);
				setRequiredField(s, fb);
				newList.add( ro );
				ALL_PERSONAL_BANK_SUPPORT_DIRECT_LIST.put(fb.getBankCode(), fb.isSupportDirect());
			}
		}
		ALL_PERSONAL_BANK_LIST = newList;
	}
	
	/**
	 * 取得对公银行列表
	 */
	public static List<FundoutBankRO> getAllCompanyBankList(){
		return ALL_COMPANY_BANK_LIST;
	}
	
	/**
	 * 取得对私银行列表
	 */
	/*public static List<FundoutBankRO> getAllPersonalBankList(){
		return ALL_PERSONAL_BANK_LIST;
	}*/
	/**
	 * 根据银行代码获取扩展属性（对公）
	 * @param bankCode 银行代码
	 * @return
	 */
	/*@SuppressWarnings("rawtypes")
	public static List getCompanyBankS(String bankCode){
		return getBankS(bankCode,ALL_COMPANY_BANK_LIST);
	}*/
	/**
	 * 根据银行代码获取扩展属性（对私）
	 * @param bankCode 银行代码
	 * @return
	 */
	/*@SuppressWarnings("rawtypes")
	public static List getPersonalBankS(String bankCode){
		return getBankS(bankCode,ALL_PERSONAL_BANK_LIST);
	}*/
	/**
	 * 根据银行代码获取扩展属性
	 * @param bankCode 银行代码
	 * @param list 银行列表
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static List getBankS(String bankCode,List<FundoutBankRO> list){
		if(StringUtils.isNotBlank(bankCode)){
			for(FundoutBankRO ro:list){
				if(bankCode.equals(ro.getK())){
					return ro.getS();
				}
			}
		}
		return null;
	}
	/**
	 * 设置required属性
	 * @param ro FundoutBankRO对象
	 * @param fb FundoutBank数据
	 */
	private static void setRequiredField(List<Boolean>s,FundoutBank fb){
		List<FundoutBankDetail> detailList = fb.getDetails();
		if(detailList!=null){
			for(FundoutBankDetail fd : detailList){
				List<FundoutRequiredField> reqFieldList = fd.getRequiredFields();
				if(reqFieldList!=null){
					for(FundoutRequiredField frf : reqFieldList){
						if(BANK_PROVINCE.equals(frf.getFieldKey())){
							s.set(0,true);
						}
						if(BANK_BRANCH.equals(frf.getFieldKey())){
							s.set(1,true);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 是否支持直连银行（对公）
	 * @param bankCode 银行代码
	 * @return
	 */
	@Deprecated
	public static boolean isSupportDirectForCompany(String bankCode){
		boolean isSupportDirect = false;
		if(ALL_COMPANY_BANK_SUPPORT_DIRECT_LIST.get(bankCode) != null && ALL_COMPANY_BANK_SUPPORT_DIRECT_LIST.get(bankCode)){
			isSupportDirect = true;
		}
		return isSupportDirect;
	}
	
	/**
	 * 是否支持直连银行（对私）
	 * @param bankCode 银行代码
	 * @return
	 */
	@Deprecated
	public static boolean isSupportDirectForPersonal(String bankCode){
		boolean isSupportDirect = false;
		if(ALL_PERSONAL_BANK_SUPPORT_DIRECT_LIST.get(bankCode) != null && ALL_PERSONAL_BANK_SUPPORT_DIRECT_LIST.get(bankCode)){
			isSupportDirect = true;
		}
		return isSupportDirect;
	}
}
