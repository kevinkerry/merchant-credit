package com.shengpay.debit.ext.daointerface;

import java.util.List;
import com.shengpay.debit.dal.dataobject.TbWithholdingBrechInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingBrechInfoExample;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingBrechInfoDAO;

public interface ExtTbWithholdingBrechInfoDAO extends TbWithholdingBrechInfoDAO {
	/**
	 * 分页查询
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingBrechInfoPO> pageQueryInfoList(ExtTbWithholdingBrechInfoExample queryParam) throws Exception;
	
	/**
	 * 查询代扣批次,加入代扣订单查询信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingBrechInfoPO> queryByPage(ExtTbWithholdingInfoExample param) throws Exception;
}
