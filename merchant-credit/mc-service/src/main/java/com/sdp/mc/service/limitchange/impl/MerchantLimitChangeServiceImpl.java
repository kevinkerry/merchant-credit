package com.sdp.mc.service.limitchange.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdo.common.lang.StringUtil;
import com.sdp.mc.common.enums.LimitTypeEnums;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeDtlDOExample;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDO;
import com.sdp.mc.newt0.dao.Newt0McLimitChangeReqDOExample;
import com.sdp.mc.newt0.manager.Newt0McLimitChangeDtlManager;
import com.sdp.mc.newt0.manager.Newt0McLimitChangeReqManager;
import com.sdp.mc.promoter.dao.ext.PromoterFastSettleSwitchDOExt;
import com.sdp.mc.service.limitchange.MerchantLimitChangeService;
import com.sdp.mc.service.newt0.NewT0MerchantFastSettleService;
import com.shengpay.commons.core.utils.NumberUtils;
import com.shengpay.commons.core.utils.StringUtils;

@Service("merchantLimitChangeService")
public class MerchantLimitChangeServiceImpl implements MerchantLimitChangeService {

	@Autowired
	private Newt0McLimitChangeDtlManager newt0MarchatlimitChangeDtlManager;
	@Autowired
	private Newt0McLimitChangeReqManager newt0MarchatlimitChangeReqManager;
	@Autowired
	private NewT0MerchantFastSettleService newT0MerchantFastSettleService;

	@Override
	public List<Newt0McLimitChangeReqDO> queryMarchatLimitChange(Newt0McLimitChangeReqDOExample query) {
		// example.setOrderByClause("reqId");
		Newt0McLimitChangeReqDOExample.Criteria cri = query.createCriteria();
		if (query.getStartTime() != null) {
			cri.andReqTimeGreaterThan(query.getStartTime());
		}
		if (query.getEndTime() != null) {
			cri.andReqTimeLessThan(query.getEndTime());
		}

		Integer totalItem = newt0MarchatlimitChangeReqManager.countByExample(query);

		query.setTotalItem(totalItem);

		if (query.isNeedQueryAll() && totalItem > 0) {
			query.setPageSize(totalItem);
		}
		if (query.getPageFristItem() > query.getTotalItem()) {
			query.setCurrentPage(1);
		}
		query.setOrderByClause(" CREATE_TIME DESC ");
		List<Newt0McLimitChangeReqDO> list2 = newt0MarchatlimitChangeReqManager.selectByQuery(query);
		return list2;
	}

	@Override
	public List<Newt0McLimitChangeDtlDO> queryMarchatLimitChangeDetailByReqId(Long reqId) {
		Newt0McLimitChangeDtlDOExample example = new Newt0McLimitChangeDtlDOExample();
		example.setReqId(reqId);
		List<Newt0McLimitChangeDtlDO> list2 = newt0MarchatlimitChangeDtlManager.selectByExample(example);
		return list2;
	}

	@Override
	public Long createMarchatLimitChangeReq(String fileName, List<String[]> marchatInfoList) {
		int size = 0;
		if (marchatInfoList != null) {
			String[] arr = marchatInfoList.get(0);
			if (arr != null && arr.length >= 4) {
				String merchantNo = arr[0];// 商户号
				if (merchantNo.indexOf(".") > 0) {
					merchantNo = merchantNo.substring(0, merchantNo.indexOf("."));
				}
				if (!NumberUtils.isLong(merchantNo)) {
					size = marchatInfoList.size() - 1;
				} else {
					size = marchatInfoList.size();
				}
			}

		}
		Newt0McLimitChangeReqDO reqDo = createReqDo(fileName, size, 0, 0);
		Long reqId = 0l;
		if (reqDo != null) {
			reqId = reqDo.getReqId();
			createMarchatLimitChangeDetail(reqId, marchatInfoList);
		}
		return reqId;
	}

	@SuppressWarnings("unused")
	private Newt0McLimitChangeReqDO createReqDo(String fileName, int reqNum, int reqType, int status) {
		Newt0McLimitChangeReqDO reqDo = new Newt0McLimitChangeReqDO();
		if (!StringUtils.isBlank(fileName)) {
			reqDo.setReqFileName(fileName);
		}
		reqDo.setCreateTime(new Date());
		reqDo.setReqTime(new Date());
		reqDo.setStatus(status);
		reqDo.setReqType(reqType);
		if (reqNum == 0) {
			reqDo.setReqNum(0);
			reqDo.setFailNum(0);
			reqDo.setStatus(2);
			reqDo.setSuccessNum(0);
		} else {
			reqDo.setReqNum(reqNum);
		}
		Long reqId = newt0MarchatlimitChangeReqManager.insert(reqDo);
		return reqDo;
	}

	private void createMarchatLimitChangeDetail(Long reqId, List<String[]> marchatInfoList) {
		if (marchatInfoList != null) {
			int i = 0;
			for (String[] arr : marchatInfoList) {
				if (arr != null && arr.length >= 4) {
					String merchantNo = arr[0];// 商户号
					if (!NumberUtils.isLong(merchantNo)) {
						if (i == 0) {
							i++;
							continue;
						}
					}
					Newt0McLimitChangeDtlDO detailDo = new Newt0McLimitChangeDtlDO();
					detailDo.setCreateTime(new Date());
					detailDo.setStatus(0);
					detailDo.setReqId(reqId);
					detailDo.setMcNo(arr[0]);
					detailDo.setPosMcType(arr[1]);
					detailDo.setMaxLimit(new BigDecimal(arr[2]));
					detailDo.setMinLimit(new BigDecimal(arr[3]));
					String limitType = arr[4];
					if (StringUtil.isBlank(limitType) || LimitTypeEnums.TEMPORARY.code.equals(limitType.trim())) {
						detailDo.setLimitType(LimitTypeEnums.TEMPORARY.code);
					} else if (LimitTypeEnums.PERMANENT.code.equals(limitType.trim())) {
						detailDo.setLimitType(LimitTypeEnums.PERMANENT.code);
					}
					this.newt0MarchatlimitChangeDtlManager.insert(detailDo);

				}
			}

		}

	}

	@Override
	public Newt0McLimitChangeReqDO getReqDoByReqId(Long reqId) {
		return this.newt0MarchatlimitChangeReqManager.selectByPrimaryKey(reqId);
	}

	@Override
	public void updateReqDo(Newt0McLimitChangeReqDO reqDo) {
		this.newt0MarchatlimitChangeReqManager.updateByPrimaryKey(reqDo);

	}

	@Override
	public void updateDetailDo(Newt0McLimitChangeDtlDO detailDo) {
		this.newt0MarchatlimitChangeDtlManager.updateByPrimaryKey(detailDo);
	}

	@Override
	public long changeMerchantLimit(Newt0McLimitChangeDtlDO detailDo , String operatorId) throws Exception {
		long result = 0;
		if (detailDo != null) {
			try {
				result = newT0MerchantFastSettleService.changMerchantLimit(detailDo.getMcNo(), detailDo.getPosMcType(), detailDo.getMaxLimit(),
						detailDo.getMinLimit(),operatorId,detailDo.getLimitType());
			} catch (Exception e) {
				throw e;
			}
		}
		return result;
	}

	@Override
	public Newt0McLimitChangeReqDO createAutoChangeMarchatLimitChangeReq(List<PromoterFastSettleSwitchDOExt> list) {
		int size = 0;
		if (list != null) {
			size = list.size();
		}
		return createReqDo(null, size, 1, 1);
	}

	@Override
	public void createReqDetailDo(Newt0McLimitChangeDtlDO detailDo) {
		this.newt0MarchatlimitChangeDtlManager.insert(detailDo);
	}

}
