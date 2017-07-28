package com.shengpay.debit.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.dal.dataobject.DoBorrowMoneyPO;
import com.shengpay.debit.dal.dataobject.DoMerchantDebitOrderPO;
import com.shengpay.debit.dal.ext.dataobject.ExtDoMerchantDebitOrderExample;
import com.shengpay.debit.dal.ext.dataobject.LoanDebitOrderDTO;

/**
 * 商户借款订单表操作类
 *
 * @author wangjingao.william
 * **/
public interface MerchantDebitOrderService {

    /**
     * 分页查询商户借款订单
     * **/
    public List<DoMerchantDebitOrderPO> pageQueryMerchantDebitOrder(ExtDoMerchantDebitOrderExample query);

    /**
     * 根据id查询商户借款订单
     * **/
    public DoMerchantDebitOrderPO selectByPrimerykey(Long id);

    /**
     * 逾期还款逻辑处理
     *
     * @param id
     *            商户借款订单表id
     * **/
    public ErrorMessageVO overdueRepayment(Long id);
    /**
     * 统计未还款总额
     * **/
    public BigDecimal sumDebitAmount(String merchantNo);
    /**
     * 统计最近5天须归还的借款总额
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
     * @return
     */
    public List<DoBorrowMoneyPO> pageQueryBorrowMonery(ExtDoMerchantDebitOrderExample queryParam) throws Exception;
    /**
     *  根据商户号查询借款明细详情
     * @param merchantNo
     * @return
     * @throws Exception
     */
    public DoBorrowMoneyPO borrowMoneyDetail(String merchantNo,String id) throws Exception;

    /**
     * 查询商户借款出款信息
     * @param query
     * @return
     */
    public List<LoanDebitOrderDTO> pageQueryLoanDebitOrder(ExtDoMerchantDebitOrderExample query);

    /**
     * 查询商户借款出款信息
     * @param query
     * @return
     */
    public BigDecimal totalAmount(ExtDoMerchantDebitOrderExample query);

    /**
     * 查询商户借款订单详情
     * @param query
     * @return
     */
    public DoMerchantDebitOrderPO loanOrderDetail(Long id);
}
