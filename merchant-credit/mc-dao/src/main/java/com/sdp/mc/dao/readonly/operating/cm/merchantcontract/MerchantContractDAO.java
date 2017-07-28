package com.sdp.mc.dao.readonly.operating.cm.merchantcontract;

import com.shengpay.commons.core.base.BaseDAO2;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商户抽象合同信息（MC）访问接口
 *
 * @author wangyiyong@snda.com
 */
@Deprecated
public interface MerchantContractDAO extends BaseDAO2<MerchantContractEO> {
    /**
     * 查询状态为非删除的某合同号的数目
     */
    int countNotDeleteContract(String contractNO);

    /**
     * 查询状态为非删除的某合同
     */
    MerchantContractEO selectNotDeleteContract(String contractNO);

    /**
     * 根据商户号查询机具方id
     */
    Long queryTerminalProviderIdByMerchantNO(String merchantNO);

    /**
     * (定时任务)更新所有合同的状态，返回更新的条数
     * 1. 已审核(1)且进入合同有效期，置为：已激活(3)
     * 2. 已审核(1)或已激活(3)且已过合同有效期，置为：预约终止(2)
     */
    Integer taskUpdateMerchantContractStatus();

    /**
     * 查询【在合同有效期内】某些状态的合同 ，状态：已审核(1)
     */
    List<MerchantContractEO> queryValidContractAudited();

    /**
     * 查询【过期的】某些状态的合同 ，状态：已审核(1)、已激活(3)
     */
    List<MerchantContractEO> queryOverdueContractAuditedActived();

    /**
     * 查询商户个数:某个商户号，某些类型，某些状态( 已审核(1)、 已激活(3) )
     *
     * @param merchantNo  商户号
     * @param typeArray   类型(多个)
     * @param statusArray 状态(多个)
     */
    Integer countMerchantByCondition(String merchantNo, String[] typeArray, String[] statusArray);

    /**
     * 查询用户销毁(删除)的商户
     */
    List<MerchantContractEO> queryMerchantForDestory(String merchantNo, String merchantType, String merchantStatus, Date createTimeAt);
    
    /**
     * 根据合同状态等查询记录
     * @param merchantNo
     * @param typeArray
     * @param statusArray
     * @return
     */
    public List<MerchantContractEO> queryMerchantContracts(String merchantNo, String[] typeArray, String[] statusArray);

    //-----------------------------		add by xiaobai start	------------------------------
    /**
     * 根据机具方商户号查询机具方信息
     */
    MerchantContractEO queryTerminalProviderByMerchantNO(String merchantNO);
    //-----------------------------		add by xiaobai end	------------------------------
    
    public Integer queryCountMc4CustomRuleByCond(Mc4CustomRuleCond cond);
    
    public List<Mc4CustomRuleVO> queryMc4CustomRuleByCond(Mc4CustomRuleCond cond);
    
    /**
     * 根据商户号查询该商户名称
     * @param merchantNo
     * @return
     */
    public Map<String, Object> queryMerchantContractByMerchantNO(String merchantNo);
}
