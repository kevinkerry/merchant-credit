package com.shengpay.debit.ext.daointerface;

import java.util.List;
import com.shengpay.debit.dal.dataobject.TbWithholdingFileInfoPO;
import com.shengpay.debit.dal.ext.dataobject.ExtTbWithholdingFileInfoExample;
import com.shengpay.debit.daointerface.TbWithholdingFileInfoDAO;

public interface ExtTbWithholdingFileInfoDAO extends TbWithholdingFileInfoDAO {
	/**
	 * 分页查询
	 * @param queryParam
	 * @return
	 * @throws Exception
	 */
	public List<TbWithholdingFileInfoPO> pageQueryInfoList(ExtTbWithholdingFileInfoExample queryParam) throws Exception;
}
