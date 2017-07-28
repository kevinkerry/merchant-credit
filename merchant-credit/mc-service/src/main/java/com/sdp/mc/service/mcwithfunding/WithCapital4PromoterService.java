package com.sdp.mc.service.mcwithfunding;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;

public interface WithCapital4PromoterService {

	/**
	 * 申请配资记录
	 *
	 * @param promoterId
	 * @param applyDatetime
	 * @return
	 */
	BigDecimal queryWithCapital4Promoter(Long promoterId);

	/**
	 * 是否是工作日
	 *
	 * @return
	 */
	String isWorkDay(Date toDay);

	Long insert(WithCapital4PromoterDO record);

	/**
	 * 更新配资记录
	 *
	 * @param id
	 * @param creditFosId
	 *            fos授信转账id
	 * @param feeFosId
	 *            fos手续费转账id
	 * @param batchNo
	 *            fos批量转账批次号
	 * @param creditChangeId
	 *            授信变更记录id
	 * @return
	 */
	int updateByPrimaryKeySelective(Long id, Long creditFosId, Long feeFosId, String batchNo, Long creditChangeId, Integer status);

	List<WithCapital4PromoterDO> pageQueryWithCapital(WithCapital4PromoterDOExample example);

}
