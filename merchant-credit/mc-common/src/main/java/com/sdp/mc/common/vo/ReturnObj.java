package com.sdp.mc.common.vo;

/**HTML5基本很多页面都会不会直接刷新页面
 *而是通过ajax返回,然后根据结果判断页面跳转还是div的切换
 * @author shishengfeng.senvon
 *
 */
public class ReturnObj {

	public static final Integer SUCCESS = 1000;//请求成功返回码
	public static final Integer NO_LOGIN = -999;//没有登录返回码
	
	private Integer code;//
	private Object result;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
