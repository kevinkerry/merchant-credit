package com.sdp.mc.dao.userloginlog;


import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;


/**
 * MSP用户登录日志
 * @author dengxb
 * @date 2014-2-14 下午04:16:04
 */
@Repository("mcUserLoginLogDAO")
public class McUserLoginLogDAOImpl implements McUserLoginLogDAO{
	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="ibatisTemplate_mc")
	protected IbatisBaseDAOImpl ibatisTemplete;

	/**
	 * 新增
	 */
	@Override
	public Long insert( McUserLoginLogEO eo ){
		Long id = ( Long )ibatisTemplete.insert( "McUserLoginLogDAO.insert", eo );
		return id;
	}
}
