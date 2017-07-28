package com.sdp.mc.merchant.manager;

import com.sdp.mc.merchant.dao.MerchantFsReq;
import com.sdp.mc.merchant.dao.MerchantFsReqExample;
import java.util.List;

public interface MerchantFsRManager {
    /**
     * 根据主键删除商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    int deleteByPrimaryKey(Long mfqId);

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    Long insert(MerchantFsReq record);

    /**
     * 添加商户快速结算申请记录【MerchantFsReq】对象信息,空值字段不插入
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    Long insertSelective(MerchantFsReq record);

    /**
     * 根据Example对象查询得到商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    List<MerchantFsReq> selectByExample(MerchantFsReqExample example);

    /**
     * 根据主键查询商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    MerchantFsReq selectByPrimaryKey(Long mfqId);

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息，仅更新非空对象
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    int updateByPrimaryKeySelective(MerchantFsReq record);

    /**
     * 根据主键更新商户快速结算申请记录【MerchantFsReq】对象信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    int updateByPrimaryKey(MerchantFsReq record);

    /**
     * 根据Query对象分页查询商户快速结算申请记录【MerchantFsReq】对象列表信息
     *
     * @mbggenerated Tue Dec 15 15:47:17 CST 2015
     */
    List<MerchantFsReq> selectByQuery(MerchantFsReqExample example);
    
    int updateByExampleSelective(MerchantFsReq record, MerchantFsReqExample example);
}