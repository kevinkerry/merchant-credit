package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.RefundQueryRequest;
import com.shengpay.mcl.btc.response.RefundQueryResponse;

/**
 * <p>委托代收退款查询</p>
 * @author Eric.fu
 * @version $Id: TrustCollectRefundQuery.java, v 0.1 2012-3-16 下午06:50:05 fuyangbiao Exp $
 */
@WebService
public interface TrustCollectRefundQuery {

    /**
     * 退款结果查询
     * @param request
     * @return
     */
    public RefundQueryResponse refundQuery(RefundQueryRequest request);
}
