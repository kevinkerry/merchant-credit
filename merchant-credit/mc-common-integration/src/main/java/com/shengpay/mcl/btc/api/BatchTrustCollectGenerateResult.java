package com.shengpay.mcl.btc.api;

import javax.jws.WebService;

import com.shengpay.mcl.btc.request.BatchResultGenerateRequest;
import com.shengpay.mcl.btc.response.BatchResultGenerateResponse;


/**
 * <p>批量银行卡委托代收结果生成</p>
 * @author Eric.fu
 * @version $Id: BatchTrustCollectGenerateResult.java, v 0.1 2012-3-16 下午06:12:51 fuyangbiao Exp $
 */
@WebService
public interface BatchTrustCollectGenerateResult {
    /**
     * 申请
     * @param request
     * @return
     */
    public BatchResultGenerateResponse generate(BatchResultGenerateRequest request);
}
