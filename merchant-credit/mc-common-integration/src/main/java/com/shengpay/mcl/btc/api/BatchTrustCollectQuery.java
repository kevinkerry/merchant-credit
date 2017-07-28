package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.BatchQueryRequest;
import com.shengpay.mcl.btc.response.BatchQueryResponse;


/**
 * <p>批量委托代收状态查询</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectQuery.java, v 0.1 2012-3-16 下午06:40:37 fuyangbiao Exp $
 */
@WebService
public interface BatchTrustCollectQuery {

    /**
     * 查询批次状态
     * @param request
     * @return
     */
    public BatchQueryResponse query(BatchQueryRequest request);
}
