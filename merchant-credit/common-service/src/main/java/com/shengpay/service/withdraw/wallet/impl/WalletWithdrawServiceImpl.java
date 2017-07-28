package com.shengpay.service.withdraw.wallet.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdp.mc.common.constant.WithdrawConstant;
import com.sdp.mc.common.enums.withdraw.WalletWithdrawStatusEnums;
import com.sdp.mc.common.exception.WalletWithdrawRequestException;
import com.sdp.mc.common.util.DateUtil;
import com.sdp.withdraw.dao.WalletWithdrawReqDO;
import com.sdp.withdraw.dao.WalletWithdrawReqDOExample;
import com.sdp.withdraw.dao.daointerface.WalletWithdrawReqDAO;
import com.sdp.withdraw.dao.daointerface.ext.ExtWalletWithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtWalletWithdrawReqDTO;
import com.sdp.withdraw.entity.WalletWithdrawReqDTO;
import com.sdp.withdraw.entity.WalletWithdrawReqPO;
import com.sdp.withdraw.enums.PosMerchantTypeEnums;
import com.sdp.withdraw.enums.ReturnCodeEnums;
import com.sdp.withdraw.manager.WalletWithdrawReqManager;
import com.sdp.withdraw.manager.ext.ExtWalletWithdrawReqManager;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawQueryResponse;
import com.sdp.withdraw.vo.wallet.WalletWithdrawRequest;
import com.sdp.withdraw.vo.wallet.WalletWithdrawResult;
import com.shengpay.service.withdraw.wallet.WalletWithdrawService;
import com.shengpay.service.withdraw.wallet.worker.WalletWithdrawHandler;
@Service("WalletWithdrawService")
public class WalletWithdrawServiceImpl implements WalletWithdrawService {
	private Logger logger = LoggerFactory.getLogger(WalletWithdrawServiceImpl.class);
	
	@Autowired
	private Mapper beanMapper;
	@Autowired 
	private WalletWithdrawReqManager walletWithdrawReqManager;
	@Autowired 
	private ExtWalletWithdrawReqManager extWalletWithdrawReqManager;
	@Autowired 
	private ExtWalletWithdrawReqDAO extWalletWithdrawReqDAO;
	@Autowired 
	private WalletWithdrawHandler walletWithdrawHandler;
	@Autowired
    private WalletWithdrawReqDAO walletWithdrawReqDAO;

	@Override
	public boolean checkRequestUnqiue(String appId, String orderNo) {
		WalletWithdrawReqDO reqDo=getWalletWithdrawReqDO(appId,orderNo);
		if(reqDo!=null){
			throw new WalletWithdrawRequestException(ReturnCodeEnums.FW_REPEAT_REQUEST.code,ReturnCodeEnums.FW_REPEAT_REQUEST.msg);
		}
		return true;
		
	}
	@Override
	public WalletWithdrawReqDO getWalletWithdrawReqDO(String appId, String orderNo) {
		WalletWithdrawReqDOExample example=new WalletWithdrawReqDOExample();
		example.setAppId(appId);
		example.setOrderNo(orderNo);
		List<WalletWithdrawReqDO>  list=  walletWithdrawReqManager.selectByExample(example);
		if(list!=null&&list.size()>0){
		     return list.get(0);
		}
		return null;
		
	}

	@Override
	@Transactional
	public WalletWithdrawReqDO createWalletWithdrawData(WalletWithdrawRequest walletWithdrawRequest) {
		WalletWithdrawReqDO reqDo=beanMapper.map(walletWithdrawRequest, WalletWithdrawReqDO.class);
		reqDo.setStatus(WalletWithdrawStatusEnums.INIT.code);
		reqDo.setCreateTime(new Date());
		try {
			Long reqId=walletWithdrawReqManager.insert(reqDo);
		} catch (DuplicateKeyException e) {
			logger.error("createWalletWithdrawData insert DuplicateKeyException",e);
			throw new WalletWithdrawRequestException(ReturnCodeEnums.FW_REPEAT_REQUEST.code,ReturnCodeEnums.FW_REPEAT_REQUEST.msg);
		}
		return reqDo;
		
	}

	@Override
	public WalletWithdrawReqDO queryWalletWithdrawReqByReqId(Long reqId) {
		// TODO Auto-generated method stub
		return walletWithdrawReqManager.selectByPrimaryKey(reqId);
	}

	@Override
	public int updateDataStatus(Long reqId, int status, Long traceNo) {
		WalletWithdrawReqDO reqDo=new WalletWithdrawReqDO();
		reqDo.setReqId(reqId);
		reqDo.setStatus(status);
		if(traceNo!=null){
			reqDo.setTraceNo(traceNo);
		}
		reqDo.setUpdateTime(new Date());
		return walletWithdrawReqManager.updateByPrimaryKeySelective(reqDo);
	}
	@Override
	public int updateDataStatus(Long reqId, int sourceStatus, int targetStatus) {
		WalletWithdrawReqDO reqDo=new WalletWithdrawReqDO();
		reqDo.setStatus(targetStatus);
		reqDo.setUpdateTime(new Date());
		WalletWithdrawReqDOExample example=new WalletWithdrawReqDOExample();
		example.createCriteria().andReqIdEqualTo(reqId).andStatusEqualTo(sourceStatus);
		return walletWithdrawReqDAO.updateByExample(reqDo, example);
	}

	@Override
	public WalletWithdrawResult queryWalletWithdrawInfo(Long reqId) {
		ExtWalletWithdrawReqDTO dto=extWalletWithdrawReqManager.queryWalletWithdrawInfo(reqId);
		return this.beanMapper.map(dto, WalletWithdrawResult.class);
	}

	@Override
	public WalletWithdrawQueryResponse queryWalletWithdrawInfo(WalletWithdrawQueryRequest walletWithdrawQueryRequest) {
		ExtWalletWithdrawReqDTO dto=this.beanMapper.map(walletWithdrawQueryRequest, ExtWalletWithdrawReqDTO.class);
		List<ExtWalletWithdrawReqDTO> list= this.extWalletWithdrawReqDAO.selectWalletWithdrawByQuery(dto);
		if(list==null||list.isEmpty()){
			return new WalletWithdrawQueryResponse(new ArrayList<WalletWithdrawResult>(), 0);
		}
		List<WalletWithdrawResult> results=new ArrayList<WalletWithdrawResult>();
		for(ExtWalletWithdrawReqDTO result:list){
			results.add(this.beanMapper.map(result, WalletWithdrawResult.class));
		}
		return new WalletWithdrawQueryResponse(results, results.size());
	}
	@Override
	public List<WalletWithdrawReqDO> selectByQuery(WalletWithdrawReqDTO query) {
		WalletWithdrawReqPO po = query.getPo();
		WalletWithdrawReqDOExample example = query.getExample();
		if (StringUtils.isNotBlank(po.getAppId() )) {
			example.setAppId(po.getAppId());
		}
		if (StringUtils.isNotBlank(po.getOrderNo() )) {
			example.setOrderNo(po.getOrderNo());
		}
		if (StringUtils.isNotBlank(po.getMemberNo() )) {
			example.setMemberNo(po.getMemberNo());
		}
		if (StringUtils.isNotBlank(po.getMemberType() )) {
			example.setMemberType(po.getMemberType());
		}
		if(StringUtils.isNotBlank(po.getEndApplyTime())&&StringUtils.isNotBlank(po.getStartApplyTime())){
			example.createCriteria().andCreateTimeBetween(DateUtil.str2Date(po.getStartApplyTime()),DateUtil.str2Date(po.getEndApplyTime()));
		}else if(StringUtils.isNotBlank(po.getStartApplyTime())){
			example.createCriteria().andCreateTimeGreaterThanOrEqualTo(DateUtil.str2Date(po.getStartApplyTime()));
		}else if(StringUtils.isNotBlank(po.getEndApplyTime())){
			example.createCriteria().andCreateTimeLessThanOrEqualTo(DateUtil.str2Date(po.getEndApplyTime()));
		}
		if (po.getStatus() != null) {
			example.setStatus(po.getStatus());
		}

		query.getExample().setOrderByClause("CREATE_TIME DESC");
		List<WalletWithdrawReqDO> list = walletWithdrawReqManager.selectByQuery(example);
		return list;
	}
	@Override
	public int easypayWalletWithdrawFailRetry() {
		WalletWithdrawReqDOExample example = new WalletWithdrawReqDOExample();
		example.setStatus(WalletWithdrawStatusEnums.FAIL.code);
		example.setMemberType(PosMerchantTypeEnums.EASYPAY_MERCHANT.code);
		List<WalletWithdrawReqDO> list = walletWithdrawReqManager.selectByQuery(example);
		if(list!=null&&list.size()>0){
			for(WalletWithdrawReqDO reqDo:list){
				walletWithdrawHandler.execute(reqDo,WithdrawConstant.withdrawTypeRealTime);
			}
		}
		
		return list.size();
	}
}
