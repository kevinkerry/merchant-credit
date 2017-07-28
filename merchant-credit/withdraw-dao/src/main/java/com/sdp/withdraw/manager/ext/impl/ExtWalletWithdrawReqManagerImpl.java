package com.sdp.withdraw.manager.ext.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.withdraw.dao.daointerface.ext.ExtWalletWithdrawReqDAO;
import com.sdp.withdraw.dao.ext.ExtWalletWithdrawReqDTO;
import com.sdp.withdraw.manager.ext.ExtWalletWithdrawReqManager;

@Service("ExtWalletWithdrawReqManager")
public class ExtWalletWithdrawReqManagerImpl implements ExtWalletWithdrawReqManager{
	private static final Logger log = LoggerFactory.getLogger(ExtWalletWithdrawReqManagerImpl.class);
	@Autowired
	private ExtWalletWithdrawReqDAO extWalletWithdrawReqDAO;
	@Override
	public ExtWalletWithdrawReqDTO queryWalletWithdrawInfo(Long reqId) {
		// TODO Auto-generated method stub
		ExtWalletWithdrawReqDTO dto=new ExtWalletWithdrawReqDTO();
		dto.setReqId(reqId);
		List<ExtWalletWithdrawReqDTO> list= extWalletWithdrawReqDAO.selectWalletWithdrawByQuery(dto);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
}
