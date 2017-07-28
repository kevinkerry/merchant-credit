package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoExample;
import com.shengpay.debit.dal.dataobject.TbWithholdingOrderInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingOrderInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingOrderInfoDAO;

public interface ExtTbWithholdingOrderInfoDAO extends TbWithholdingOrderInfoDAO {
	public List<TbWithholdingOrderInfoPO> pageQueryInfoList(ExtTbWithholdingOrderInfoExample queryParam) throws Exception;


	/** 查询待回调订单状态  **/
    List<TbWithholdingOrderInfoPO> getOrderListByOrderNo(TbWithholdingOrderInfoExample example);

    /** 根据订单号查询批次号 **/
    TbWithholdingOrderInfoPO getOrderInfoByOrderNo(TbWithholdingOrderInfoExample example);
    /**
     * 订单号
     * @return
     */
    public String creditWithholdOrderNo();
}
