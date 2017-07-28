package com.sdp.mc.dao.readonly.posmerchant;

import com.shengpay.commons.core.base.BaseDAO2;

import java.math.BigDecimal;
import java.util.List;

/**
 * POS商户访问接口
 *
 * @author wangyiyong@snda.com
 * @date: 13-2-2 上午10:18
 */
@Deprecated
public interface PosMerchantDAO extends BaseDAO2<PosMerchantEO> {

    /**
     * 查询pos商户Count
     */
    Integer queryMerchantCount(PosMerchantCond cond);

    /**
     * 查询pos商户List  (分页)查询
     */
    List<PosMerchantEO> queryMerchantList(PosMerchantCond cond);

    /**
     * 查询POS商户所属拓展商列表
     *
     * @param posMerchantNOList POS商户所属拓展商列表
     * @return
     */
    List<PosMerchantEO> queryMerchantPromoterList(List<String> posMerchantNOList);

    /**
     * 根据合同号查询非删除状态的合同(唯一)
     */
    PosMerchantEO queryPosMerchantNotDeleted(String contractNO);


    /**
     * 根据pos商户编号查询合同id（审核通过或激活状态）
     */
    Long queryPosMerchantIdByNo(String posMerchantNO);


    /**
     * getMerchantNoByMposPromoter
     *
     * @param pmtMerchantNo 拓展商的商户号
     * @return 所有mpos商户的商户号
     */
    List<String> getMerchantNoByMposPromoter(String pmtMerchantNo);

    /**
     * 根据商户号查询(pos/mpos/minipos)商户信息
     *
     * @param merchantType 商户类型pos/mpos/minipos
     */
    List<PosMerchantEO> queryMerchantListByType(String merchantType, int pageNo, int pageSize);

    /**
     * 根据终端号 查询商户信息
     */
    PosMerchantEO queryPosMerchantByTerminalNO(String terminalNO);

    /**
     * 根据商户号查询pos商户
     */
    List<PosMerchantEO> queryMerchantByMerchantNO(String merchantNO, String[] mcType, String[] mcStatus);

    /**
     * 根据mcId更新mccId
     */
    public void updateMccByPosmId(Long mcId, Long mccId, String mccName);
    
    /**
     * 新代理商替换旧代理商
     * @param oldPromoterNo
     * @param newPromoterNo
     * @param mcType
     * @param mcStatus
     * @return
     */
    public int updatePromoter(Long oldPromoterId, Long newPromoterId,String mcType, String newPromoterName);
    
    /**
     * 根据终端号 查询商户信息(适配Mpos库存导入)
     * @return
     */
    public PosMerchantEO queryPosMerchantEOByMposInfo(String terminalNo);
    
    /**
     * 获取商户拓展商下的所有商户
     * @param pmtMerchantNo
     * @return
     */
    public List<String> getPromoterChildByMerchantNo(String pmtMerchantNo);
    
    /**
     * 根据盛付通商户号查询出POS商户号（15位）
     * @return
     */
    public List<String> getPosMerchantNoByMerchantNo(String merchantNo);
    /**
     * 更新商户对应的代理商
     * @author zhangmeng.michael
     * @param eo
     */
    void updateMerchantPomoter(PosMerchantEO eo);
    
    public PosMerchantEO qryMerchantByMerchantNoAdMcType(String merchantNo,String mcType);
    
	/**
	 * 查询商户信息根据商户主键id
	 * @param TermId
	 * @return
	 */
	public PosMerchantEO queryPosMerchantEOByTermId(Long termId);
	
	/**
	 *  根据MCCCode查询进件费率
	 * @param mccCode
	 * @return
	 */
	public BigDecimal queryMccFeeByMccCode(String mccCode);
	
	/**
	 * 查询pos商户快速结算 Count
	 */
	public Integer queryMerchantFastSettleCount(PosMerchantCond cond);
	
	/**
	 * 查询pos商户快速结算 List
	 */
	public List<PosMerchantEO> queryMerchantFastSettleList(PosMerchantCond cond);
}
