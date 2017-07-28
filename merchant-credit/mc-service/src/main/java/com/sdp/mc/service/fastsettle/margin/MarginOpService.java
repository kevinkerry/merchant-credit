package com.sdp.mc.service.fastsettle.margin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sdp.mc.common.enums.LoaningTypeEnum;
import com.sdp.mc.common.enums.OpTypeEnums;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;
import com.sdp.mc.integration.msp.request.MspModifyRequest;
import com.sdp.mc.margin.dao.MarginOpReqDO;
import com.sdp.mc.margin.dao.MarginOpReqDOExample;
import com.sdp.mc.service.op.state.OpStateResponse;

public interface MarginOpService {

	/**
	 * 分页查询fos交易记录
	 *
	 * **/
	public List<MarginOpReqDO> pageQueryMarginTrans(MarginOpReqDOExample query);

	/**
	 * 查询代理商信息
	 *
	 * @param promoterId
	 *            代理商编号
	 * @return
	 */
	public PromoterInfoDTO queryPromoterInfo(Long promoterId);

	/**
	 * 查询 代理商 当前回退金额
	 *
	 * @param promoterId
	 * @return
	 */
	public String queryCurrentRedeemMargin(Long promoterId);

	/**
	 * 追加保证金
	 *
	 * @param promoterId
	 *            代理商编号
	 * @param amount
	 *            追加金额
	 * @return
	 */
	public OpStateResponse addMargin(long promoterId, BigDecimal amount, OpTypeEnums opType,String operatorId);

	/**
	 * 追加保证金
	 *
	 * @param promoterId
	 *            代理商编号
	 * @param amount
	 *            追加金额
	 * @param key
	 *            0：浮动保证金 1：保底保证金
	 * @return
	 */
	public OpStateResponse addMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, LoaningTypeEnum loaningType, Integer key,String operatorId);

	/**
	 * 代理商保证金操作生成 MspModifyRequest
	 *
	 * @param opType
	 *            操作类型，追加、退回
	 * @param amount
	 *            操作金额
	 * @param fastSettleMargin
	 *            代理商当前保证金
	 * @param margin2ConfigTimes
	 *            系统扩大倍数
	 * @param promoterId
	 *            代理商ID
	 * @param promoterNo
	 *            代理商商户号
	 * @param promoterType
	 *            代理商类型
	 * @return
	 */
	public MspModifyRequest generatMarginMspModifyRequest(OpTypeEnums opType, BigDecimal amount, BigDecimal fastSettleMargin, String margin2ConfigTimes, long promoterId, String promoterNo,
			String promoterType);

	public String getRedeemedSepCnt();

	/**
	 * 代理商当日是否有取回保证金记录
	 *
	 * @param promoterId
	 * @return
	 */
	public boolean todayRedeemMargin(Long promoterId);

	/**
	 * 追加保证金
	 *
	 * @param promoterId
	 * @param amount
	 * @param opType
	 * @param isServer是不是后台
	 * @return
	 */
	ErrorMessageVO<Object> validateAndAddMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, boolean isServer,String operatorId);
	/**
	 * 修改代理商的保证金
	 * @param promoterId 代理商ＩＤ
	 * @param amount　最终的保证金金额
	 * @param opType　操作类型
	 * @param memberId　会员ID
	 * @param operatorId 操作人
	 * @return
	 */
	ErrorMessageVO<Object> modifyMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, String operatorId);

	/**
	 * 取回保证金
	 *
	 * @param promoterId
	 * @param amount
	 * @param opType
	 * @param isServer是不是后台
	 * @return
	 */
	ErrorMessageVO<Object> validateAndRedeemMargin(long promoterId, BigDecimal amount, OpTypeEnums opType, String memberId, boolean isServer,String operatorId);

	/**
	 * 发短信
	 *
	 * @param promoterId
	 *            代理商id
	 * @param key
	 *            短信模板code
	 * @param map
	 *            短信模板中对应值
	 */
	void sendMessage(Long promoterId, String key, Map<String, String> map);

	/**
	 * 根据代理商id，操作类型，状态查询列表amount总和
	 * @param promoterId
	 * @param opType
	 * @param status
	 * @return
	 */
	BigDecimal queryMarginOpReqSum(Long promoterId, Integer opType, Integer status);
	/**
	 * 发送邮件
	 * @param title
	 * @param content
	 */
	public void sendMail(final String title, final String content);

}
