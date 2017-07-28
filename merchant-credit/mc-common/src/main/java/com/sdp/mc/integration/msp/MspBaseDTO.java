package com.sdp.mc.integration.msp;

import java.util.Date;

public class MspBaseDTO {

	/**
	 * 操作类型 - 开通、申请、追加、退回
	 */
	private Integer opType;
	private Long objId;
	/**
	 * 对象类型 - 商户、代理商
	 */
	private Integer objType;

	private String name;
	/**
	 * 代理商状态 3 正常 ;0 1 2 4 关闭
	 * 商户状态 3：正常，其它：异常
	 */
	private String status;
	/**
	 * 0:关闭
	 * 1:开通
	 * **/
	private Integer fastSettleFlag;

	/**
	 * 创建时间，页面显示用
	 */
	private Date createTime;

	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public int getOpType() {
		return opType;
	}

	public void setOpType(int opType) {
		this.opType = opType;
	}

	public int getObjType() {
		return objType;
	}

	public void setObjType(int objType) {
		this.objType = objType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getFastSettleFlag() {
		return fastSettleFlag;
	}

	public void setFastSettleFlag(Integer fastSettleFlag) {
		this.fastSettleFlag = fastSettleFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
