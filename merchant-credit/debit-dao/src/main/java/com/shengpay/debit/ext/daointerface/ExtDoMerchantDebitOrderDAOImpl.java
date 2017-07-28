package com.shengpay.debit.ext.daointerface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shengpay.debit.dal.dataobject.DoBorrowMoneyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderExample;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;
import com.shengpay.debit.daointerface.DoMerchantDebitOrderDAOImpl;

public class ExtDoMerchantDebitOrderDAOImpl extends DoMerchantDebitOrderDAOImpl implements ExtDoMerchantDebitOrderDAO {

	/**
	 * 分页查询商户借款订单
	 * **/
	@Override
    @SuppressWarnings("unchecked")
	public List<DoMerchantDebitOrderPO> pageQueryMerchantDebitOrder(ExtDoMerchantDebitOrderExample example) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.countMerchantDebitOrder", example);
		example.setTotalItem(totalItem);
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<DoMerchantDebitOrderPO> returnList = new ArrayList<DoMerchantDebitOrderPO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {
			List<DoMerchantDebitOrderPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_DEBIT_ORDER.pageQueryMerchantDebitOrder", example);
			returnList.addAll(list);
		}
		return returnList;
	}

	@Override
    public int updateDebitOrder2Success(Long id, String originalStatus, String targetStatus) {
		DoMerchantDebitOrderExample example = new DoMerchantDebitOrderExample();
		example.createCriteria().andIdEqualTo(id).andStatusEqualTo(originalStatus);
		DoMerchantDebitOrderPO record = new DoMerchantDebitOrderPO();
		record.setStatus(targetStatus);
		record.setUpdateTime(new Date());
		record.setDueRepaymentTime(new Date());
		return this.updateByExampleSelective(record, example);
	}

	/**
	 * 查询到此时间范围内的所有还款订单
	 * @param startTime
	 * @param endTime
	 * @param status
	 * @return
	 */
	@Override
    public List<DoMerchantDebitOrderPO> queryAllRepaymentOrdersByStatus(Date startTime, Date endTime, String status){
		DoMerchantDebitOrderExample example = new DoMerchantDebitOrderExample();
		DoMerchantDebitOrderExample.Criteria criteria = example.createCriteria();
		criteria.andEndTimeBetween(startTime, endTime);
		criteria.andStatusEqualTo(status);
		return this.selectByExample(example);
	}


	/**
	 * 统计未还款总额
	 * **/
	@Override
    public BigDecimal sumDebitAmount(String merchantNo) {
		return (BigDecimal) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.sumDebitAmount", merchantNo);
	}

	/**
	 * 统计最近5天的借款总额
	 * **/
	@Override
    public BigDecimal sumDebitAmountInLast5Days(String merchantNo) {
		return (BigDecimal) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.sumDebitAmountInLast5Days", merchantNo);
	}

	/**
	 * 统计最近5天的借款笔数
	 * **/
	@Override
    public Integer countDebitAmountInLast5Days(String merchantNo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.countDebitAmountInLast5Days", merchantNo);
	}

	/**
	 *借款查询
	 */
	@Override
    @SuppressWarnings("unchecked")
	public List<DoBorrowMoneyPO> pageQueryBorrowMonery(
			ExtDoMerchantDebitOrderExample queryParam) throws Exception{
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.countMerchantDebitOrder", queryParam);
		queryParam.setTotalItem(totalItem);
		if (queryParam.isNeedQueryAll() && totalItem > 0) {
			queryParam.setPageSize(totalItem);
		}
		List<DoBorrowMoneyPO> returnList = new ArrayList<DoBorrowMoneyPO>();
		if (queryParam.getPageFristItem() <= queryParam.getTotalItem()) {
			List<DoBorrowMoneyPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_DEBIT_ORDER.pageQueryborrow", queryParam);
			returnList.addAll(list);
		}
		return returnList;
	}
	/**
	 * 借款明细查询
	 * @param merchantNo
	 * @return
	 */
	@Override
    @SuppressWarnings("unchecked")
	public DoBorrowMoneyPO borrowMoneyDetail(String merchantNo,String id) throws Exception{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("merchantNo", merchantNo);
		map.put("id", id);
		List<DoBorrowMoneyPO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_DEBIT_ORDER.borrowMoneyDetail", map);
		if(null!=list&&list.size()>0){
			return  list.get(0);
		}
		return null;
	}

	/**
	 * 分页查询出款借款订单
	 * **/
	@Override
    @SuppressWarnings("unchecked")
	public List<LoanDebitOrderDTO> pageQueryLoanDebitOrder(ExtDoMerchantDebitOrderExample example) {
		Integer totalItem = (Integer) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.pageQueryLoanDebitOrderCount", example);
		example.setTotalItem(totalItem);
		if (example.isNeedQueryAll() && totalItem > 0) {
			example.setPageSize(totalItem);
		}
		List<LoanDebitOrderDTO> returnList = new ArrayList<LoanDebitOrderDTO>();
		if (example.getPageFristItem() <= example.getTotalItem()) {
			List<LoanDebitOrderDTO> list = getSqlMapClientTemplate().queryForList("DO_MERCHANT_DEBIT_ORDER.pageQueryLoanDebitOrder", example);
			returnList.addAll(list);
		}
		return returnList;
	}

	/**
	 * 查询总出款额度
	 * **/
	@Override
    public BigDecimal totalAmount(ExtDoMerchantDebitOrderExample example){
		BigDecimal totalAmount = (BigDecimal) getSqlMapClientTemplate().queryForObject("DO_MERCHANT_DEBIT_ORDER.loanDebitOrderRealAmount", example);
		return totalAmount;
	}

}
