package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.SingleQueryRequest;
import com.shengpay.mcl.btc.response.SingleQueryResponse;

/**
 * <p>委托代收单笔状态查询</p>
 * @author Eric.fu
 * @version $Id: TrustCollectQuery.java, v 0.1 2012-3-16 下午06:42:58 fuyangbiao Exp $
 */
@WebService
public interface TrustCollectQuery {

    /**
     * 查询单笔订单处理结果
     * @param request
     * @return
     */
    public SingleQueryResponse query(SingleQueryRequest request);
}
