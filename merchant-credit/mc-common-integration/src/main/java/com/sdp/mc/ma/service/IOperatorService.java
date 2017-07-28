package com.sdp.mc.ma.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.sdp.mc.ma.request.impl.QueryOperatorMemberScopeRequest;
import com.sdp.mc.ma.response.impl.QueryOperatorMemberScopeResponse;

/**
 * <p>操作员服务</p>
 * @author wangchanggeng
 * @version $Id: IOperatorService.java, v 0.1 2010-12-14 上午09:03:40 wangchanggeng Exp $
 */
@WebService(targetNamespace="http://operator.service.ws.authorize.sdo.com")
@SOAPBinding(style=Style.DOCUMENT,parameterStyle=ParameterStyle.BARE,use=Use.LITERAL)
public interface IOperatorService {

    /*
     * 查询操作员拥有数据权限范围的商户列表
     * 调用方：POS（java）
     * 联系人：liuxi 项目经理：叶春林
     * add by yuanjie
     * 2014-2-12 11：28
     * @param request
     * @return
     */
    @WebMethod(operationName = "QueryOperatorMemberScope",action="QueryOperatorMemberScope")
    @WebResult(name = "QueryOperatorMemberScope")
    QueryOperatorMemberScopeResponse QueryOperatorMemberScope(@WebParam(name="QueryOperatorMemberScopeRequest") QueryOperatorMemberScopeRequest request);
}

