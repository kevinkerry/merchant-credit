package com.shengpay.debit.common.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.shengpay.debit.common.service.GuaranteeService;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListExample;
import com.shengpay.debit.dal.dataobject.DmAgentMerchantSettingListPO;
import com.shengpay.debit.daointerface.DmAgentMerchantSettingListDAO;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {
	private static final Logger log = LoggerFactory.getLogger(GuaranteeServiceImpl.class);

	@Autowired
	private DmAgentMerchantSettingListDAO dmAgentMerchantDao;

	public ErrorMessageVO openOrCloseAgentPower(DmAgentMerchantSettingListPO po) {
		ErrorMessageVO vo = new ErrorMessageVO(false);
		try {
			DmAgentMerchantSettingListExample example = new DmAgentMerchantSettingListExample();
			example.createCriteria().andAgentMerchantNoEqualTo(po.getAgentMerchantNo());
			// 根据商户号查询代理商配置表
			DmAgentMerchantSettingListPO dmPo = this.selectByExample(example);
			if (dmPo != null) {
				// 存在updae
				po.setAgentMerchantName(dmPo.getAgentMerchantName());// 代理商名称
				po.setId(dmPo.getId());
				po.setUpdateTime(new Date());
				dmAgentMerchantDao.updateByPrimaryKey(po);
			} else {
				// 不存在insert
				po.setCreateTime(new Date());
				dmAgentMerchantDao.insert(po);
			}

			vo.setSuccess(true);
		} catch (Exception e) {
			log.error("GuaranteeServiceImpl-->openOrCloseAgentPower-->error", e);
			vo.setSuccess(false);
			vo.setErrorMessage("后台操作失败，请联系管理员或者开发人员");
			vo.setErrorCode("-99");
		}
		return vo;
	}

	@Override
	public DmAgentMerchantSettingListPO selectByExample(DmAgentMerchantSettingListExample example) {
		List<DmAgentMerchantSettingListPO> list = dmAgentMerchantDao.selectByExample(example);
		if (list != null && list.size() > 0)
			return list.get(0);
		else
			return null;

	}

}
