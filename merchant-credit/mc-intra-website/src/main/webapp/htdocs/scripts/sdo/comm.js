function refreshValidateCode(_id,url){
	document.getElementById(_id).src = url+"?date="+new Date();
}