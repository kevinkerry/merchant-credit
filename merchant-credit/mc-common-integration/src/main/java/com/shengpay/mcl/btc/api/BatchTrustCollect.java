package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.BatchRequest;
import com.shengpay.mcl.btc.response.BatchResponse;

/**
 * <p>银行卡批量委托扣款</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollect.java, v 0.1 2012-3-16 下午05:45:52 fuyangbiao Exp $
 */
@WebService
public interface BatchTrustCollect {
    /**
     * 申请
     * @param request
     * @return
     */
    public BatchResponse apply(BatchRequest request);
}
