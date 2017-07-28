package com.sdp.debit.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengpay.debit.common.enums.ThreadConfigStatusEnum;
import com.shengpay.debit.dal.dataobject.DbThreadConfigPO;
import com.shengpay.debit.ext.daointerface.ExtDbThreadConfigDAO;

@Service
public class JobBatchConfigService {

    @Autowired
    private ExtDbThreadConfigDAO  dbThreadConfigDAO;

    public List<DbThreadConfigPO> selectAllValid(){
        return dbThreadConfigDAO.selectConfigByStatus(ThreadConfigStatusEnum.VALID.getValue());
    }

    public DbThreadConfigPO findByBatchCode(String batchCode){
    	return dbThreadConfigDAO.findByBatchCode(batchCode);
    }

}
