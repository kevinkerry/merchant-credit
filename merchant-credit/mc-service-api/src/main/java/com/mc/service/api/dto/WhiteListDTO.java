package com.mc.service.api.dto;

import java.io.Serializable;

public class WhiteListDTO implements Serializable {
    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.ID
     * column comments 主键ID
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Long id;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE
     * column comments 白名单类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private Integer type;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.TYPE_NAME
     * column comments 类型名称
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String typeName;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_NO
     * column comments 商户号/代理商商户号
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantNo;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.MERCHANT_TYPE
     * column comments 商户类型/代理商商户类型
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String merchantType;

    /**
     * This field corresponds to the database column TB_WHITE_LIST_INFO.CONTENT
     * column comments 白名单内容
     *
     * @mbggenerated Fri Apr 22 15:46:19 CST 2016
     */
    private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

   
    
}