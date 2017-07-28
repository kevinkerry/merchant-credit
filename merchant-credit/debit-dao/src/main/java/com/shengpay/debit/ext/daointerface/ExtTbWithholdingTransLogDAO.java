package com.shengpay.debit.ext.daointerface;

import java.util.List;

import com.shengpay.debit.dal.dataobject.TbWithholdingTransLogPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingTransLogExample;
import com.shengpay.debit.daointerface.TbWithholdingTransLogDAO;

public interface ExtTbWithholdingTransLogDAO extends TbWithholdingTransLogDAO {
	public List<TbWithholdingTransLogPO> pageQueryInfoList(ExtTbWithholdingTransLogExample queryParam) throws Exception;
}
