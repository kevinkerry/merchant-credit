package com.shengpay.debit.ext.daointerface;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.shengpay.debit.dal.dataobject.DoBorrowMoneyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;
import com.shengpay.debit.daointerface.DoMerchantDebitOrderDAO;

public interface ExtDoMerchantDebitOrderDAO extends DoMerchantDebitOrderDAO {
	/**
	 * 分页查询商户借款订单
	 * **/
	public List<DoMerchantDebitOrderPO> pageQueryMerchantDebitOrder(ExtDoMerchantDebitOrderExample query);

	public int updateDebitOrder2Success(Long id, String originalStatus, String targetStatus);


	public List<DoMerchantDebitOrderPO> queryAllRepaymentOrdersByStatus(Date startTime, Date endTime, String status);

	/**
	 * 统计未还款总额
	 * **/
	public BigDecimal sumDebitAmount(String merchantNo);

	/**
	 * 统计最近5天的借款总额
	 * **/
	public BigDecimal sumDebitAmountInLast5Days(String merchantNo);

	/**
	 * 统计最近5天的借款笔数
	 * **/
	public Integer countDebitAmountInLast5Days(String merchantNo);
	/**
	 * 借款查询
	 * @param queryParam
	 * 商户名称 模糊查询
	 * 商户号
	 * 借款日期开始时间
	 * 借款日期结束时间
	 * 还款日期开始时间
	 * 还款日期结束时间
	 * 状态
	 *
	 * @return List<DoBorrowMoneyPO>
	 */
	public List<DoBorrowMoneyPO> pageQueryBorrowMonery(ExtDoMerchantDebitOrderExample queryParam) throws Exception;
	/**
	 * 借款详情，默认根据商户号查询并作关联
	 * @param merchantNo
	 * @return DoBorrowMoneyPO
	 * @throws Exception
	 */
	public DoBorrowMoneyPO borrowMoneyDetail(String merchantNo,String id) throws Exception;
	/**
	 * 分页查询商户借款出款订单
	 * **/
	public List<LoanDebitOrderDTO> pageQueryLoanDebitOrder(ExtDoMerchantDebitOrderExample example) ;

	/**
	 * 查询总出款额度
	 * **/
	public BigDecimal totalAmount(ExtDoMerchantDebitOrderExample example) ;

}
