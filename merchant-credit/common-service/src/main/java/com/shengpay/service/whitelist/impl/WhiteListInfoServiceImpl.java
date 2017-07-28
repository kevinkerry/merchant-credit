package com.shengpay.service.whitelist.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.service.api.WhiteListInfoAPI;
import com.mc.service.api.dto.WhiteListDTO;
import com.mc.service.api.enums.WhiteTypeEnums;
import com.sdp.mc.common.bean.whitelist.WhiteListFeeBean;
import com.sdp.mc.common.enums.WhiteListInfoStatusEnums;
import com.sdp.mc.dataobjct.WhiteListInfoDTO;
import com.sdp.mc.dataobjct.WhiteListInfoPO;
import com.sdp.mc.newt0.dao.WhiteListInfoDO;
import com.sdp.mc.newt0.dao.WhiteListInfoDOExample;
import com.sdp.mc.newt0.manager.WhiteListInfoManager;
import com.shengpay.service.whitelist.WhiteListInfoService;

@Service("whiteListInfoService")
public class WhiteListInfoServiceImpl implements WhiteListInfoService,WhiteListInfoAPI {

	private Logger logger = LoggerFactory.getLogger(WhiteListInfoServiceImpl.class);

	@Autowired
	private WhiteListInfoManager whiteListInfoManager;
	
	@Autowired
	protected Mapper beanMapper;

	@Override
	public List<WhiteListInfoDO> queryWhiteListInfo(WhiteListInfoDOExample query) {
		query.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		List<WhiteListInfoDO> list2 = whiteListInfoManager.selectByQuery(query);
		return list2;
	}

	@Override
	public WhiteListInfoDO selectByPrimaryKey(Long id) {
		return this.whiteListInfoManager.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(WhiteListInfoDO infoDo) {
		return this.whiteListInfoManager.updateByPrimaryKeySelective(infoDo);

	}

	@Override
	public WhiteListInfoDO queryWhiteListInfo(Integer type, String merchantNo, String merchantType) {
		WhiteListInfoDOExample query = new WhiteListInfoDOExample();
		logger.info("queryWhiteListInfo,type:{},merchantNo:{},merchantType:{}",new Object[]{type, merchantNo, merchantType});
		if(type==null||StringUtils.isBlank(merchantNo)||StringUtils.isBlank(merchantType)){
			logger.error("queryWhiteListInfo query param is null ");
			return null;
		}
		query.setType(type);
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		query.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		List<WhiteListInfoDO> list = whiteListInfoManager.selectByExample(query);
		if (list != null && !list.isEmpty()) { return list.get(0); }
		return null;
	}

	@Override
	public List<WhiteListInfoDO> queryWhiteListInfo(Integer type) {
		WhiteListInfoDOExample query = new WhiteListInfoDOExample();
		query.setType(type);
		query.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		return whiteListInfoManager.selectByExample(query);
	}

	@Override
	public List<WhiteListInfoDO> queryWhiteListInfo(String merchantNo, String merchantType) {
		WhiteListInfoDOExample query = new WhiteListInfoDOExample();
		query.setMerchantNo(merchantNo);
		query.setMerchantType(merchantType);
		query.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		return whiteListInfoManager.selectByExample(query);
	}

	@Override
	public List<WhiteListInfoDO> queryWhiteListInfo(String merchantNo) {
		WhiteListInfoDOExample query = new WhiteListInfoDOExample();
		query.setMerchantNo(merchantNo);
		query.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		return whiteListInfoManager.selectByExample(query);
	}

	@Override
	public List<WhiteListInfoDO> selectByQuery(WhiteListInfoDTO query) {
		WhiteListInfoPO po = query.getPo();
		WhiteListInfoDOExample example = query.getExample();
		if (po.getType() != null) {
			example.setType(po.getType());
		}
		if (po.getMerchantNo() != null) {
			example.setMerchantNo(po.getMerchantNo());
		}
		if (po.getMerchantType() != null) {
			example.setMerchantType(po.getMerchantType());
		}
		if (po.getStatus() != null) {
			example.setStatus(po.getStatus());
		}
		query.getExample().setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		query.getExample().setOrderByClause("CREATE_TIME DESC");
		List<WhiteListInfoDO> list = whiteListInfoManager.selectByQuery(example);
		return list;
	}

	@Override
	public Long insert(WhiteListInfoDO config) {
		// TODO Auto-generated method stub
		return whiteListInfoManager.insert(config);
	}

	@Override
	public WhiteListFeeBean queryWhiteFee(Integer type, String merchantNo, String merchantType) {
		WhiteListInfoDO info = this.queryWhiteListInfo(type, merchantNo, merchantType);
		if (info != null) {
			if (WhiteTypeEnums.FEE.code.intValue() == info.getType()) {
				try {
					WhiteListFeeBean bean = WhiteListFeeBean.json2Bean(info.getContent());
					return bean;
				} catch (Exception e) {
					logger.error("queryWhiteFee json2Bean Exception:"+ToStringBuilder.reflectionToString(info));
				}
			}
		}
		return null;
	}

	@Override
	public int updateLoseEfficacy(Long id,String opUser) {
		WhiteListInfoDO info= new WhiteListInfoDO();
		info.setId(id);
		info.setUpdateTime(new Date());
		info.setUpdateUser(opUser);
		info.setStatus(WhiteListInfoStatusEnums.LOSE_EFFICACY.code);
		return this.whiteListInfoManager.updateByPrimaryKeySelective(info);
	}
	

	@Override
	public Long createWhiteInfo(Integer code, String merchantNo, String mcType,String content,String opUser) {
		WhiteListInfoDO info= new WhiteListInfoDO();
		info.setMerchantType(mcType);
		info.setMerchantNo(merchantNo);
		info.setType(code);
		info.setTypeName(WhiteTypeEnums.getEnumsByCode(code).desc);
		info.setContent(content);
		info.setCreateTime(new Date());
		info.setCreateUser(opUser);
		info.setStatus(WhiteListInfoStatusEnums.TAKE_EFFECT.code);
		return this.whiteListInfoManager.insert(info);
	}

	@Override
	public WhiteListInfoDO queryWhiteListInfo(Integer type, String merchantNo, String merchantType, String promoterMerchantNo, String promoterType) {
		WhiteListInfoDO info=queryWhiteListInfo(type, merchantNo, merchantType);
		if(info==null){
			info=queryWhiteListInfo(type, promoterMerchantNo, promoterType);
		}
		return info;
	}

	@Override
	public int updateWhiteInfo(Long id, String content, String operatorId) {
		WhiteListInfoDO whiteInfo= new WhiteListInfoDO();
		whiteInfo.setId(id);
		whiteInfo.setContent(content);
		whiteInfo.setUpdateTime(new Date());
		whiteInfo.setUpdateUser(operatorId);
		return whiteListInfoManager.updateByPrimaryKeySelective(whiteInfo);
	}

	@Override
	public WhiteListDTO getWhiteListInfo(String merchantNo, String merchantType, int type) {
		WhiteListInfoDO info=queryWhiteListInfo(type, merchantNo, merchantType);
		if(info!=null){
			return beanMapper.map(info, WhiteListDTO.class);
		}
		return null;
	}


}
