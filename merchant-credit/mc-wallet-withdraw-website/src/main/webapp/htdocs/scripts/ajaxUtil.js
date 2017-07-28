var _LOGIN_URL = "/index.htm";

/**
 * 公用的Ajax提交方法
 * 返回的data的格式为以下其中之一(竖线|表示或者):
 * 1.true|false
 * 2.{return:'true|false',msg:'提示信息'}
 */
function ajaxSubmit(url,dataObj,callBackFunctionName,isDebug, checkLogin) {
	isDebug = (isDebug != null && typeof(isDebug) == "boolean") ? isDebug : false;
	checkLogin = (checkLogin != null && typeof(checkLogin) == "boolean") ? checkLogin : true;
	var sendData = null;

	//如果是表单
	var oForm = document.forms[dataObj];
	if (oForm != null) {
		if (isDebug) {
			alert("find form " + dataObj);
		}
		oForm = j(oForm);
		sendData = oForm.serialize();
		if (isDebug) {
			alert("send form data");
		}
	} else {
		if (isDebug) {
			alert("send data object");
		}
		sendData = dataObj;
	}
	
	if (isDebug) {
		alert("ajaxSubmit() url=" + url);
		alert("ajaxSubmit() sendData=" + sendData);
	}

	j.ajax({
		type: "POST",
		url: url,
		cache: false,
		data: sendData,
		beforeSend: function(){
		},
		success: function(data){
			if (isDebug) {
				alert("ajaxSubmit() success return data=[" + data + "]");
			}
			if (data == null || j.trim(data) == "") {
				ajaxTip("操作失败,请重试!");
				ajaxCallBack(callBackFunctionName,"{}",isDebug);
				return;
			}
			//data = data.replace(/(^\s*)|(\s*$)/g,"");
			data = j.trim(data);
			//检查是否已经登录
			var isLogin = false;
			if (typeof(checkLogin) == "boolean" && checkLogin == false) {
				isLogin = true;
			} else {
				isLogin = ajaxCheckIsLogin(data);
			}
			if (isDebug) {
				alert("ajaxSubmit() isLogin=" + isLogin);
			}
			//检查返回的数据是否是对象
			if (isLogin) {
					if (data.indexOf("{") == 0 && data.indexOf("}") == data.length-1) {
						if (isDebug) {
							alert("ajaxSubmit() eval(data)");
						}
						var eval_data = eval("("+data+")");
						if (ajaxBeforeCallBack(eval_data,isDebug)) {
							ajaxCallBack(callBackFunctionName,data,isDebug);
						} else {
							ajaxCallBack(callBackFunctionName,data,isDebug);
						}
						return;
					} else {
						if (data.indexOf("true") == 0) {
							ajaxTip("操作成功!");
							ajaxCallBack(callBackFunctionName,"{'result':'true'}",isDebug);
							return;
						} else {
							ajaxTip("操作失败,请重试!");
							ajaxCallBack(callBackFunctionName,"{'result':'false'}",isDebug);
							return;
						}
					}
			}
		},
		error: function (data) {
			if (isDebug) {
				alert("ajaxSubmit() error");
			}
			ajaxTip("操作失败,请重试!");
			ajaxCallBack(callBackFunctionName,"{}",isDebug);
			return;
		}
	});
}

/**
 * ajax回调函数之前执行(当返回的数据为对象时)
 */
function ajaxBeforeCallBack(data,isDebug) {
	var v = false;
	isDebug = (isDebug != null && typeof(isDebug) == "boolean") ? isDebug : false;
	if (data != null) {
		var result = (data.result == "true") ? true : false;
		if (isDebug) {
			alert("ajaxBeforeCallBack() result="+result);
		}
		var msg = "";
		if (data.msg != null && data.msg != "") {
			msg = data.msg;
		} else {
			if (result) {
				msg = "操作成功!";
			} else {
				msg = "操作失败,请重试!";
			}
		}
		if (isDebug) {
			alert("ajaxBeforeCallBack() msg="+msg);
		}
		ajaxTip(msg);
		v = result;
	}
	return v;
}

/**
 * 公用的ajax回调函数
 */
function ajaxCallBack(functionName,data,isDebug) {
	isDebug = (isDebug != null && typeof(isDebug) == "boolean") ? isDebug : false;
	if (isDebug) {
		alert("ajaxCallBack() functionName=" + functionName);
		alert("ajaxCallBack() data=" + data);
	}
	if (functionName != null && functionName != "") {
		eval(functionName+"("+data+")");
	}
}

/**
 * 公用的ajax返回之后进行是否已经登录的检查
 */
function ajaxCheckIsLogin(data) {
	if (data != null && data != "") {
		//登录页面的特征
		if (data.indexOf("#AJAX_FLAG_THIS_IS_LOGIN_PAGE#") >= 0) {
			ajaxTip("登录超时,请重新登录");
			top.location = _LOGIN_URL;
			return false;
		}
	}
	return true;
}

/**
 * 公用的ajax返回时的提示信息
 */
function ajaxTip(msg) {
	if (msg != null && msg != "") {
		if (msg == "_MUTE") {
			//跳过
		} else {
			//暂用alter
			alert(msg);
		}
	}
}