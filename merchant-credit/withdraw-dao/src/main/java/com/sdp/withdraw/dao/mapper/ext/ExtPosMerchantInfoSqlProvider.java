package com.sdp.withdraw.dao.mapper.ext;

import com.sdp.withdraw.dao.PosMerchantInfoDOExample;

/**
 * 出款sqlProvider扩展
 * 
 * @author zhangyulong
 *
 */
public class ExtPosMerchantInfoSqlProvider {
	/**
	 * 根据Query对象分页查询出款列表信息
	 * 
	 * @param example
	 * @return
	 */
	public String selectOpenFastSettlePromoterInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT pi.* ");
		sb.append("FROM MCREDIT.FW_POS_MERCHANT_INFO pi, VIEW_PROMOTER_INFO cp ");
		sb.append("WHERE PI.PARENT_PROMOTER_ID IS NULL ");
		sb.append("AND PI.MERCHANT_TYPE IN ('0003', '0007','0101') ");
		sb.append(" AND PI.POS_MERCHANT_ID = CP.PROMOTER_ID ");
		sb.append("AND (CP.PROMOTER_FS_FLAG = 1 ");
		sb.append("OR (CP.PROMOTER_FS_FLAG = 0 ");
		sb.append("AND EXISTS (SELECT 1 ");
		sb.append("FROM MCREDIT.FW_WITHDRAW_INFO wi ");
		sb.append(" WHERE WI.BIZ_ID = PI.ID AND WI.LIMITATION > 0))) ");
		return sb.toString();
	}

	public String syncMerchantOperator() {
		StringBuilder sb = new StringBuilder();
		sb.append("select I.ID,M.PMT_BIND_OPERATOR_ID_V PMT_BIND_OPERATOR_ID,M.PMT_BIND_OPERATOR_NAME_V PMT_BIND_OPERATOR_NAME ");
		sb.append("from MCREDIT.FW_POS_MERCHANT_INFO i ,PPCPAY.MSP_POS_MERCHANT m ");
		sb.append("where I.POS_MERCHANT_ID=M.ID_N ");
		sb.append("and I.MERCHANT_TYPE in('0001','0006') ");
		sb.append("and (I.PMT_BIND_OPERATOR_ID<> M.PMT_BIND_OPERATOR_ID_V or I.PMT_BIND_OPERATOR_NAME <> M.PMT_BIND_OPERATOR_NAME_V) ");
		return sb.toString();
	}

	public String repairFirstOpenDate() {
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO MCREDIT.FW_MERCHANT_SETTLE_ATTR (ID,BIZ_ID,MERCHANT_NO,MERCHANT_TYPE,BIZ_TYPE,FIRST_OPEN_TIME,CREATE_TIME) ");
		sb.append(" SELECT MCREDIT.SEQ_FW_MERCHANT_SETTLE_ATTR.NEXTVAL, a.id,a.MERCHANT_NO,a.MERCHANT_TYPE,a.service_Type,a.TIME,SYSDATE ");
		sb.append(" FROM ( SELECT I.ID,I.MERCHANT_NO,I.MERCHANT_TYPE,CASE WHEN ri.RATIO_TYPE = 10 THEN 1 ELSE RI.RATIO_TYPE - 18 END service_Type, MIN (RI.EFFECTIVE_TIME) TIME ");
		sb.append(" FROM MCREDIT.FW_POS_MERCHANT_INFO i,MCREDIT.FW_WITHDRAW_RATIO_INFO ri ");
		sb.append(" WHERE I.ID = RI.BIZ_ID AND NOT EXISTS (SELECT 1 FROM MCREDIT.FW_MERCHANT_SETTLE_ATTR a ");
		sb.append(" WHERE A.BIZ_ID = I.ID AND (RI.RATIO_TYPE - 18 = A.BIZ_TYPE OR RI.RATIO_TYPE - 9 = A.BIZ_TYPE)) ");
		sb.append(" GROUP BY I.ID, I.MERCHANT_NO,I.MERCHANT_TYPE,RI.RATIO_TYPE) a ");
		return sb.toString();
	}

	public String selectOpenFastSettleMerchantInfoByPromoterId(Long promoterId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT mi.* ");
		sb.append("FROM MCREDIT.FW_POS_MERCHANT_INFO mi, VIEW_MERCHANT_INFO mpm ");
		sb.append("WHERE  mi.MERCHANT_TYPE IN ('0001', '0006','0201') ");
		sb.append("AND mi.POS_MERCHANT_ID = MPM.MERCHANT_ID ");
		sb.append("and MPM.PROMOTER_ID='" + promoterId + "' ");
		sb.append("AND (MPM.MERCHANT_FS_FLAG=1  ");
		sb.append("OR (MPM.MERCHANT_FS_FLAG = 0 ");
		sb.append(" AND EXISTS (SELECT 1 ");
		sb.append("FROM MCREDIT.FW_WITHDRAW_INFO wi ");
		sb.append(" WHERE WI.BIZ_ID = mi.ID AND WI.LIMITATION > 0))) ");

		return sb.toString();
	}

	public String getOpenT0IdentityMerchantInfo(PosMerchantInfoDOExample example) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ident.* ");
		sb.append("FROM MCREDIT.FW_POS_MERCHANT_INFO mi, MCREDIT.FW_POS_MERCHANT_INFO ident ");
		sb.append(" where MI.MERCHANT_NO='" + example.getMerchantNo() + "' ");
		sb.append("and MI.MERCHANT_TYPE='" + example.getMerchantType() + "' ");
		sb.append("and MI.CERT_NO is not null ");
		sb.append("and IDENT.MERCHANT_TYPE='" + example.getMerchantType() + "' ");
		sb.append("AND IDENT.FAST_SETTLE_FLAG=1 ");
		sb.append("and MI.CERT_NO=IDENT.CERT_NO ");
		return sb.toString();
	}

	public String distinctMerchant() {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from MCREDIT.FW_POS_MERCHANT_INFO info where exists( ");
		sb.append("select 1 from MCREDIT.FW_POS_MERCHANT_INFO i,(select I.MERCHANT_NO,I.MERCHANT_TYPE from MCREDIT.FW_POS_MERCHANT_INFO i  ");
		sb.append("where I.MERCHANT_TYPE in ('0001','0006') ");
		sb.append("group by I.MERCHANT_NO,I.MERCHANT_TYPE ");
		sb.append("having count(1) >1) m ");
		sb.append("where I.MERCHANT_NO=m.MERCHANT_NO ");
		sb.append("and info.id=I.ID ");
		sb.append("and I.MERCHANT_TYPE=m.MERCHANT_TYPE ");
		sb.append("and ((I.AUTO_FAST_SETTLE_FLAG is null and I.ID not in(461331,461381,461431,461406)) or I.ID=703003)) ");
		return sb.toString();
	}

	public String syncOpenAccountTime() {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE MCREDIT.FW_POS_MERCHANT_INFO mi ");
		sb.append(" SET MI.CREATE_TIME = ");
		sb.append(" (SELECT MIN (C.MC_CREATE_TIME_T) ");
		sb.append(" FROM PPCPAY.CM_MERCHANT_CONTRACT c ");
		sb.append(" WHERE C.MC_ID_N = MI.POS_MERCHANT_ID) ");
		sb.append(" WHERE MI.MERCHANT_TYPE IN ('0001', '0006') ");
		sb.append(" AND EXISTS ");
		sb.append(" (SELECT 1 ");
		sb.append(" FROM PPCPAY.CM_MERCHANT_CONTRACT c ");
		sb.append(" WHERE MI.POS_MERCHANT_ID = C.MC_ID_N ");
		sb.append(" AND TRUNC (MI.CREATE_TIME) <> TRUNC (C.MC_CREATE_TIME_T)) ");
		return sb.toString();
	}

	public String executeSql(String sql) {
		return sql;
	}

	public String createNewMerchantWithdrawInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into MCREDIT.FW_WITHDRAW_INFO(ID,LIMITATION_TYPE,BIZ_ID,BIZ_TYPE,LIMITATION,FORZEN_LIMITATION,USED_LIMITATION,CREATE_TIME,UPDATE_TIME) ");
		sb.append(" SELECT MCREDIT.SEQ_FW_WITHDRAW_INFO.nextval ,0,I.ID,1, I.FAST_SETTLE_LIMIT,0,0,sysdate,sysdate ");
		sb.append(" FROM MCREDIT.FW_POS_MERCHANT_INFO i ");
		sb.append(" WHERE I.FAST_SETTLE_FLAG = 1 AND I.FAST_SETTLE_LIMIT > 0 ");
		sb.append(" AND (I.MERCHANT_TYPE IN ( '0003',  '0007', '0101') ");
		sb.append(" OR (I.MERCHANT_TYPE IN ('0001', '0006', '0201') ");
		sb.append(" AND EXISTS (SELECT 1 ");
		sb.append(" FROM MCREDIT.FW_POS_MERCHANT_INFO pi ");
		sb.append(" WHERE pI.FAST_SETTLE_FLAG = 1 ");
		sb.append(" AND pI.FAST_SETTLE_LIMIT > 0 ");
		sb.append(" AND pi.id = I.PARENT_PROMOTER_ID))) ");
		sb.append(" and not exists(select 1 from MCREDIT.FW_WITHDRAW_INFO wi where WI.BIZ_ID=i.id) ");
		return sb.toString();
	}

	public String updateMerchantWithdrawInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE MCREDIT.FW_WITHDRAW_INFO wi ");
		sb.append(" SET WI.FORZEN_LIMITATION = 0, ");
		sb.append("  WI.USED_LIMITATION = 0, ");
		sb.append("  WI.UPDATE_TIME = SYSDATE, ");
		sb.append(" WI.LIMITATION = ");
		sb.append("  (SELECT I.FAST_SETTLE_LIMIT ");
		sb.append("  FROM FW_POS_MERCHANT_INFO i ");
		sb.append(" WHERE I.ID = WI.BIZ_ID) ");
		sb.append(" WHERE (WI.FORZEN_LIMITATION > 0 OR WI.USED_LIMITATION > 0) ");
		return sb.toString();
	}
	
	public String selectMerchantWithdrawInfoForUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT WI.* FROM MCREDIT.FW_WITHDRAW_INFO wi ");
		sb.append(" WHERE (WI.FORZEN_LIMITATION > 0 OR WI.USED_LIMITATION > 0) FOR UPDATE");
		return sb.toString();
	}

}
