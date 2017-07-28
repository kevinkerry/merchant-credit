package com.sdp.mc.service.fsconfig.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDO;
import com.sdp.mc.ffconfig.dao.FastSettleConfigDOExample;
import com.sdp.mc.ffconfig.manager.FastSettleConfigManager;
import com.sdp.mc.service.fsconfig.FastSettleConfigService;

@Service("FastSettleConfigService")
public class FastSettleConfigImpl implements FastSettleConfigService {

	@Autowired
	private FastSettleConfigManager fastSettleConfigManager;

	/**
	 * 修改商户自动快速结算设置
	 *
	 * @param merchantId
	 *            msp系统商户表id
	 * @param autoFastSettle
	 *            开关标志
	 * @return ErrorMessageVO
	 * **/

	public ErrorMessageVO modifyMerchantAutoFastSettle(Long merchantId, Integer autoFastSettle) {
		ErrorMessageVO errorMessage = new ErrorMessageVO(false);
		FastSettleConfigDOExample example = new FastSettleConfigDOExample();
		FastSettleConfigDOExample.Criteria criteria = example.createCriteria();
		criteria.andObjIdEqualTo(merchantId);
		List<FastSettleConfigDO> ffcList = fastSettleConfigManager.selectByExample(example);
		if (ffcList != null && ffcList.size() == 1) {
			FastSettleConfigDO record = new FastSettleConfigDO();
			record.setAutoFastSettle(autoFastSettle);
			record.setUpdateTime(new Date());
			criteria.andAutoFastSettleEqualTo(autoFastSettle);
			int rows = this.fastSettleConfigManager.updateByExampleSelective(record, example);
			boolean isSuccess = rows == 1;
			errorMessage.setSuccess(isSuccess);
			errorMessage.setErrorMessage(isSuccess ? "配置修改成功" : "配置修改成功");
		} else if (ffcList != null && ffcList.size() > 1) {
			errorMessage.setErrorMessage("此商户产生了多条配置，请检查");
		} else {
			// 插入配置
			FastSettleConfigDO record = new FastSettleConfigDO();
			record.setAutoFastSettle(autoFastSettle);
			record.setObjId(merchantId);
			record.setObjType(1);
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			Long fscId = this.fastSettleConfigManager.insertSelective(record);
			errorMessage.setSuccess(true);
			errorMessage.setErrorCode(fscId.toString());
			errorMessage.setErrorMessage("配置保存成功");
		}
		return errorMessage;
	}
	
	@Override
	public FastSettleConfigDO getFastSettleConfig(long merchantId) {
		FastSettleConfigDOExample example = new FastSettleConfigDOExample();
		example.createCriteria().andObjIdEqualTo(merchantId);
		List<FastSettleConfigDO> list = fastSettleConfigManager.selectByExample(example);
		if (list != null && list.size() > 0) { return list.get(0); }
		return null;
	}
	@Override
	public Long updateOrInsertFastSettleConfig(FastSettleConfigDO record) {
		FastSettleConfigDOExample example = new FastSettleConfigDOExample();
		example.createCriteria().andObjIdEqualTo(record.getObjId());
		List<FastSettleConfigDO> list = fastSettleConfigManager.selectByExample(example);
		if (list != null && list.size() > 0) {
			record.setPfcId(list.get(0).getPfcId());
			record.setUpdateTime(new Date());
			return (long) fastSettleConfigManager.updateByExampleSelective(record, example);
		} else {
			record.setCreateTime(new Date());
			return fastSettleConfigManager.insert(record);
		}
	}
}
