package com.sdp.mc.dao.readonly.operating.cm.merchantcontract;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sdp.mc.common.constant.MerchantContractCst;
import com.sdp.mc.common.util.ArrayUtil;


/**
 * 商户抽象合同信息（MC）访问接口默认实现
 *
 * @author wangyiyong@snda.com
 */
@Repository("merchantContractDAO")
@Deprecated
public class MerchantContractDAOImpl extends MerchantContractDAOImplAbstract {
    /**
     * 查询状态为非删除的某合同号的数目
     */
    public int countNotDeleteContract(String contractNO) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("contractNO", contractNO);
        params.put("status", MerchantContractCst.MC_STATUS_DELETE);
        Object obj = ibatisTemplete.queryForObject("MerchantContractDAO.countNotDeleteContract", params);
        if (obj != null) {
            return Integer.parseInt(String.valueOf(obj));
        }
        return 0;
    }

    /**
     * 查询状态为非删除的某合同
     */
    public MerchantContractEO selectNotDeleteContract(String contractNO) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("contractNO", contractNO);
        params.put("status", MerchantContractCst.MC_STATUS_DELETE);
        List<MerchantContractEO> list = ibatisTemplete.queryForList("MerchantContractDAO.selectNotDeleteContract", params);
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 根据商户号查询机具方id
     */
    public Long queryTerminalProviderIdByMerchantNO(String merchantNO) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("merchantNO", merchantNO);
        params.put("merchantType", MerchantContractCst.TYPE_TERMINAL_PROVIDER);
        params.put("status", "'" + MerchantContractCst.MC_STATUS_ACTIVE + "'");
        List<Long> idList = ibatisTemplete.queryForList("MerchantContractDAO.queryTerminalProviderIdByMerchantNO", params);
        if (idList.size() == 0) {
            return null;
        } else {
            return idList.get(0);
        }
    }

    /**
     * (定时任务)更新所有合同的状态，返回更新的条数
     * 1. 已审核(1)且进入合同有效期，置为：已激活(3)
     * 2. 已审核(1)或已激活(3)且已过合同有效期，置为：预约终止(2)
     */
    public Integer taskUpdateMerchantContractStatus() {
        int count = 0;
        //----1. 已审核(1)且进入合同有效期，置为：已激活(3)
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("mcStatus", MerchantContractCst.MC_STATUS_ACTIVE);
        map1.put("oldMcStatus1", MerchantContractCst.MC_STATUS_CONFIRM);
        //map1.put( "now", new Date() );
        count += ibatisTemplete.update("MerchantContractDAO.jobUpdateStatus1", map1);

        //----2. 已审核(1)或已激活(3)且已过合同有效期，置为：预约终止(2)
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("mcStatus", MerchantContractCst.MC_STATUS_SIGNOFF);
        map2.put("oldMcStatus1", MerchantContractCst.MC_STATUS_CONFIRM);
        map2.put("oldMcStatus2", MerchantContractCst.MC_STATUS_ACTIVE);
        //map2.put( "now", new Date() );
        count += ibatisTemplete.update("MerchantContractDAO.jobUpdateStatus2", map2);

        return count;
    }

    /**
     * 查询【在合同有效期内】某些状态的合同 ，状态：已审核(1)
     */
    public List<MerchantContractEO> queryValidContractAudited() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", "'" + MerchantContractCst.MC_STATUS_CONFIRM + "'");
        List<MerchantContractEO> mcList = ibatisTemplete.queryForList("MerchantContractDAO.queryValidContractWithStatus", params);
        return mcList;
    }

    /**
     * 查询【过期的】某些状态的合同 ，状态：已审核(1)、已激活(3)
     */
    public List<MerchantContractEO> queryOverdueContractAuditedActived() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("statuses", "'" + MerchantContractCst.MC_STATUS_CONFIRM + "', '" + MerchantContractCst.MC_STATUS_ACTIVE + "'");
        List<MerchantContractEO> mcList = ibatisTemplete.queryForList("MerchantContractDAO.queryOverdueContractWithStatus", params);
        return mcList;
    }

    /**
     * 查询某个类型的商户个数，状态为有效( 已审核(1)、 已激活(3) )
     */
    public Integer countMerchantByCondition(String merchantNo, String[] typeArray, String[] statusArray) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchantNo", merchantNo);
        params.put("types", ArrayUtil.join(typeArray, "'", "'", ","));
        params.put("statuses", ArrayUtil.join(statusArray, "'", "'", ","));
        Object obj = ibatisTemplete.queryForObject("MerchantContractDAO.countValidByMerchantNoAndTypeAndStatus", params);
        if (obj != null) {
            return Integer.valueOf(obj.toString());
        } else {
            return 0;
        }
    }

    /**
     * 查询用户销毁(删除)的商户
     */
    public List<MerchantContractEO> queryMerchantForDestory(String merchantNo, String merchantType, String merchantStatus, Date createTimeAt) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchantNo", merchantNo);
        params.put("merchantType", merchantType);
        params.put("merchantStatus", merchantStatus);
        params.put("createTimeAt", createTimeAt);
        List<MerchantContractEO> list = ibatisTemplete.queryForList("MerchantContractDAO.queryMerchantForDestory", params);
        return list;
    }
    
    /**
     * 根据合同状态等查询记录
     * @param merchantNo
     * @param typeArray
     * @param statusArray
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<MerchantContractEO> queryMerchantContracts(String merchantNo, String[] typeArray, String[] statusArray){
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchantNo", merchantNo);
        params.put("types", ArrayUtil.join(typeArray, "'", "'", ","));
        if(statusArray!=null){
        	params.put("statuses", ArrayUtil.join(statusArray, "'", "'", ","));
        }
        List<MerchantContractEO> list = ibatisTemplete.queryForList("MerchantContractDAO.queryMerchantContract", params);
        return list;
    }

    //-----------------------------		add by xiaobai start	------------------------------
    /**
     * 根据机具方商户号查询机具方信息
     */
    public MerchantContractEO queryTerminalProviderByMerchantNO(String merchantNO){
    	Map<String, String> params = new HashMap<String, String>();
        params.put("merchantNO", merchantNO);
        params.put("merchantType", MerchantContractCst.TYPE_TERMINAL_PROVIDER);
        params.put("status", "'" + MerchantContractCst.MC_STATUS_ACTIVE + "'");
        List<MerchantContractEO> eoList = ibatisTemplete.queryForList("MerchantContractDAO.queryTerminalProviderByMerchantNO", params);
        if (eoList.size() == 0) {
            return null;
        } else {
            return eoList.get(0);
        }
    }
    //-----------------------------		add by xiaobai end	------------------------------
    
    public Integer queryCountMc4CustomRuleByCond(Mc4CustomRuleCond cond){
    	return (Integer)ibatisTemplete.queryForObject("MerchantContractDAO.queryCountMc4CustomRuleByCond", cond);
    }
    
    @SuppressWarnings("unchecked")
	public List<Mc4CustomRuleVO> queryMc4CustomRuleByCond(Mc4CustomRuleCond cond){
    	List<Mc4CustomRuleVO> vos = ibatisTemplete.queryForList("MerchantContractDAO.queryMc4CustomRuleByCond", cond,(cond.getPageNo()-1)*cond.getPageSize(),cond.getPageSize());
    	return vos;
    }
    /**
     * 根据商户号查询该商户名称
     * @param merchantNo
     * @return
     */
    public Map<String, Object> queryMerchantContractByMerchantNO(String merchantNo){
    	Object o=ibatisTemplete.queryForObject("MerchantContractDAO.queryMerchantContractByMerchantNO", merchantNo);
    	return o==null?null:(Map<String,Object>)o;
    }
    
    
}
