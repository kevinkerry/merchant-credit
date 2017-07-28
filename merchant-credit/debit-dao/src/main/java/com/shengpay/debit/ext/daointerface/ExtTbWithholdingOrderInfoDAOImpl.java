package com.shengpay.debit.ext.daointerface;

import java.util.ArrayList;
import java.util.List;

import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingOrderInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingOrderInfoDAOImpl;
public class ExtTbWithholdingOrderInfoDAOImpl extends TbWithholdingOrderInfoDAOImpl implements ExtTbWithholdingOrderInfoDAO {

	@Override
	public List<TbWithholdingOrderInfoPO> pageQueryInfoList(
			ExtTbWithholdingOrderInfoExample queryParam) throws Exception {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_ORDER_INFO.countWithholdingCount", queryParam);
		queryParam.setTotalItem(totalItem);
		if (queryParam.isNeedQueryAll() && totalItem > 0) {
			queryParam.setPageSize(totalItem);
		}
		List<TbWithholdingOrderInfoPO> returnList = new ArrayList<TbWithholdingOrderInfoPO>();
		if (queryParam.getPageFristItem() <= queryParam.getTotalItem()) {
			List<TbWithholdingOrderInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_ORDER_INFO.pageQueryWithholdingList", queryParam);
			returnList.addAll(list);
		}
		return returnList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbWithholdingOrderInfoPO> getOrderListByOrderNo(TbWithholdingOrderInfoExample example) {
		// TODO Auto-generated method stub
		List<TbWithholdingOrderInfoPO> list = getSqlMapClientTemplate().queryForList("TB_WITHHOLDING_ORDER_INFO.findOrderByExample", example);
		return list;
	}

	@Override
	public TbWithholdingOrderInfoPO getOrderInfoByOrderNo(TbWithholdingOrderInfoExample example) {
		// TODO Auto-generated method stub
		TbWithholdingOrderInfoPO po = (TbWithholdingOrderInfoPO) getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_ORDER_INFO.orderInfoByExample", example);
		return po;
	}
	@Override
	public String creditWithholdOrderNo(){
		TbWithholdingOrderInfoExample example=new TbWithholdingOrderInfoExample();
		try {
			return getSqlMapClientTemplate().queryForObject("TB_WITHHOLDING_ORDER_INFO.creditWithholdOrderNo",example).toString();
		} catch (Exception e) {
			return"";
		}

	}
}
