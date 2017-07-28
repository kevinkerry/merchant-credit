package com.sdp.mc.dao.readonly.operating.cm.merchantcontract;

import com.shengpay.commons.springtools.base.IbatisBaseDAOImpl;

import org.springframework.dao.OptimisticLockingFailureException;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商户抽象合同信息（MC）访问接口抽象实现
 *
 * @author wangyiyong@snda.com
 */
@Deprecated
public abstract class MerchantContractDAOImplAbstract implements MerchantContractDAO {

    /**
     * IBatis模板在spring配置文件中的beanId
     */
    @Resource(name="ibatisTemplate_mc")
    protected IbatisBaseDAOImpl ibatisTemplete;

    @Override
    public Long insert(MerchantContractEO eo) {
        if (eo.getMcId() != null) {
            ibatisTemplete.insert("MerchantContractDAOAbstract.insertHasId", eo);
            eo.setMcVersion(1l);
            return eo.getMcId();
        } else {
            Long ppId = (Long) ibatisTemplete.insert("MerchantContractDAOAbstract.insert", eo);
            eo.setMcId(ppId);
            eo.setMcVersion(1l);
            return ppId;
        }
    }

    @Override
    public MerchantContractEO select(Long id) {
        return select(id, false);
    }

    @Override
    public MerchantContractEO selectAndLock(Long id) {
        return select(id, true);
    }

    public MerchantContractEO select(Long id, boolean isLock) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        paramMap.put("isLock", isLock);
        return (MerchantContractEO) ibatisTemplete.queryForObject("MerchantContractDAOAbstract.select", paramMap);
    }

    @Override
    public MerchantContractEO selectEOByEO(MerchantContractEO eo) {
        return (MerchantContractEO) ibatisTemplete.queryForObject("MerchantContractDAOAbstract.selectEOByEO", eo);
    }

    @Override
    public int countByEO(MerchantContractEO eo) {
        Integer count = (Integer) ibatisTemplete.queryForObject("MerchantContractDAOAbstract.countByEO", eo);
        return count != null ? count : 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantContractEO> selectListByEO(MerchantContractEO eo) {
        return ibatisTemplete.queryForList("MerchantContractDAOAbstract.selectEOByEO", eo);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantContractEO> selectListByIdList(List<Long> idList, boolean isLock) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("idList", idList);
        paramMap.put("isLock", isLock);
        return ibatisTemplete.queryForList("MerchantContractDAOAbstract.selectListByIdList", paramMap);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MerchantContractEO> selectListByEO(MerchantContractEO eo, int pageNO, int pageSize) {
        return ibatisTemplete.queryForList("MerchantContractDAOAbstract.selectEOByEO", eo, (pageNO - 1) * pageSize, pageSize);
    }

    @Override
    public int update(MerchantContractEO eo) {
        int update = ibatisTemplete.update("MerchantContractDAOAbstract.update", eo);
        if (update == 0) {
            throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
        }
        eo.setMcVersion(eo.getMcVersion() + 1);
        return update;
    }

    @Override
    public int updateByField(MerchantContractEO eo) {
        int update = ibatisTemplete.update("MerchantContractDAOAbstract.updateByField", eo);
        if (update == 0) {
            throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
        }
        eo.setMcVersion(eo.getMcVersion() + 1);
        return update;
    }

    @Override
    public int delete(MerchantContractEO eo) {
        int delete = ibatisTemplete.delete("MerchantContractDAOAbstract.delete", eo);
        if (delete == 0) {
            throw new OptimisticLockingFailureException("删除纪录[" + eo + "]时发生乐观锁并发异常");
        }
        return delete;
    }
}
