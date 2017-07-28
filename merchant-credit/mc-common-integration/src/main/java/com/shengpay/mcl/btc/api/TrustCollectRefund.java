package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.RefundRequest;
import com.shengpay.mcl.btc.response.RefundResponse;

/**
 * <p>委托代收退款</p>
 * @author Eric.fu
 * @version $Id: TrustCollectRefund.java, v 0.1 2012-3-16 下午06:48:51 fuyangbiao Exp $
 */
@WebService
public interface TrustCollectRefund {

    /**
     * 退款申请
     * @param request
     * @return
     */
    public RefundResponse refund(RefundRequest request);
}
