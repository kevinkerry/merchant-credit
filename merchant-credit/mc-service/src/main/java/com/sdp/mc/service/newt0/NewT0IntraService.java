package com.sdp.mc.service.newt0;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExampleExt;
import com.sdp.mc.margin.dao.ext.RedeemedMarginApplyExt;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDO;
import com.sdp.mc.newt0.dao.Newt0SdpRemainBalanceDOExample;

/**
 * NEW T0 垫资管理
 * @author wangmindong
 *
 */
public interface NewT0IntraService {

	
	Long insert(Newt0SdpRemainBalanceDO record);
	
	List<Newt0SdpRemainBalanceDO> pageQueryWithCapital(Newt0SdpRemainBalanceDOExample example);
	
	List<Newt0SdpRemainBalanceDO> selectByExample(Newt0SdpRemainBalanceDOExample example);
	
	int updateByPrimaryKey(Newt0SdpRemainBalanceDO record);

	List<RedeemedMarginApplyExt> selectRedeemedReq(RedeemedMarginApplyExampleExt example);
	
	boolean modifyNewt0SdpRemainBalance(Newt0SdpRemainBalanceDO config);
	/**
	 * 统计所有页面申请取回合计金额
	 * @param example
	 * @return
	 */
	BigDecimal totalAmount(RedeemedMarginApplyExampleExt example);
	
	/**
	 * 下载
	 * @param dataList
	 * @param request
	 * @param response
	 * @return
	 */
	void doExcel(List<RedeemedMarginApplyExt> dataList,HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 放款操作
	 * @param morIds
	 * @return
	 */
	ErrorMessageVO loanOperation(String morIds,int status,String operator,String operatorId);

	int updateByPrimaryKeySelective(Newt0SdpRemainBalanceDO record);
	

}
