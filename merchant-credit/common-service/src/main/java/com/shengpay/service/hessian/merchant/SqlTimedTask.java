package com.shengpay.service.hessian.merchant;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mc.service.api.bean.BaseCustomizedTimedTask;
import com.mc.service.api.exception.TimedTaskException;
import com.sdp.mc.common.enums.MessageTemplateCodeEnum;
import com.sdp.mc.common.enums.TaskSqlTypeEnums;
import com.sdp.mc.common.enums.TaskStatusEnum;
import com.shengpay.pos.PosExternalService;
import com.shengpay.service.withdraw.FwPosMerchantInfoService;

@Service("sqlTimedTask")
public class SqlTimedTask extends BaseCustomizedTimedTask {
	private Logger logger = LoggerFactory.getLogger(SqlTimedTask.class);

	@Autowired
	private FwPosMerchantInfoService fwPosMerchantInfoService;

	@Override
	@Transactional
	public void execute(Map<String, String> param) {
		logger.info("SqlTimedTask init,param:{}",param);
		String sqlType = param.get("sqlType");

		try {
			if (TaskSqlTypeEnums.INSERT.getCode().equals(sqlType)) {
				int insertNumber = fwPosMerchantInfoService.executeInsertSql(param.get("sqlContext"));
				logger.info("executeInsertSql,insertNumber:{}",insertNumber);
				// 如果插入实行成功
				if (insertNumber < 0) { throw new TimedTaskException(STATUS_FAILURE, "插入失败"); }
			} else if (TaskSqlTypeEnums.UPDATE.getCode().equals(sqlType)) {
				int updateNumber = fwPosMerchantInfoService.executeUpdateSql(param.get("sqlContext"));
				logger.info("executeUpdateSql,updateNumber:{}",updateNumber);
				if (updateNumber < 0) { throw new TimedTaskException(STATUS_FAILURE, "更新失败"); }
			} else {
				logger.info("sqlType is not Exsit,sqlType==" + sqlType);
				throw new TimedTaskException(STATUS_FAILURE, "不支持的类型");
			}
		} catch (Exception e) {
			logger.error("SqlTimedTask Exception",e);
			throw new TimedTaskException(STATUS_FAILURE, "执行发生异常");
		}
	}

}
