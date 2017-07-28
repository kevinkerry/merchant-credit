package com.sdp.mc.mcwithfunding.manager;

import java.math.BigDecimal;
import java.util.List;

import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDO;
import com.sdp.mc.mcwithfunding.dao.WithCapital4PromoterDOExample;
import com.sdp.mc.mcwithfunding.dao.ext.WithCapitalReqDOExampleExt;

public interface WithCapital4PromoterManager {
    /**
     * 根据主键删除代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    Long insert(WithCapital4PromoterDO record);

    /**
     * 添加代理商配资记录表【WithCapital4PromoterDO】对象信息,空值字段不插入
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    Long insertSelective(WithCapital4PromoterDO record);

    /**
     * 根据Example对象查询得到代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    List<WithCapital4PromoterDO> selectByExample(WithCapital4PromoterDOExample example);

    /**
     * 根据主键查询代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    WithCapital4PromoterDO selectByPrimaryKey(Long id);

    /**
     * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息，仅更新非空对象
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    int updateByPrimaryKeySelective(WithCapital4PromoterDO record);

    /**
     * 根据主键更新代理商配资记录表【WithCapital4PromoterDO】对象信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    int updateByPrimaryKey(WithCapital4PromoterDO record);

    /**
     * 根据Query对象分页查询代理商配资记录表【WithCapital4PromoterDO】对象列表信息
     *
     * @mbggenerated Mon Jun 08 14:31:48 CST 2015
     */
    List<WithCapital4PromoterDO> selectByQuery(WithCapital4PromoterDOExample example);
    
    public int updateByExampleSelective(WithCapital4PromoterDO record, WithCapital4PromoterDOExample example);

    int updateByExample(WithCapital4PromoterDO record,WithCapital4PromoterDOExample example);

    List<WithCapital4PromoterDO> selectByQuery4Intra(WithCapitalReqDOExampleExt example);
    
    /**
	 * 统计代理商已配资总额按代理商id统计
	 * **/
    BigDecimal sumWithCapitalAmountByPromoterId(Long promoterId);
}