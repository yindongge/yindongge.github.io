//校验非零正整数
function isPlusInteger(s) {
	var pattern = /^[1-9][0-9]*$/;
	return pattern.test(s);
}

//校验数字
function isNumber(s) {
	var pattern = /^[0-9]*$/; 
	return pattern.test(s);
}

//校验浮点数
function isFloat(s) {
	var pattern = /^\d+(\.\d+)?$/; 
	return pattern.test(s);
}

//校验email
function isEmail(s) {
	var pattern =  /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
	return pattern.test(s);
}

//校验手机号
function isMobile(s) {
	var pattern = /^1\d{10}$/;
	return pattern.test(s);
}

//校验区号
function isTelAreaCode(s) {
	var pattern = /^0[1-9]\d{1,2}$/;
	return pattern.test(s);
}

//校验座机号
function isTel(s) {
	var pattern = /^\d{7,8}$/;
	return pattern.test(s);
}

//限制文本框文本长度
function checkTextAreaLength(ele, strLength){
	var intro = ele.value.replace(/^\s+|\s+$/g,"");
	if(intro.length>parseInt(strLength)){
		ele.value=intro.substr(0,strLength);
	}
}

//校验电话号
function isPhone(s) {
	var pattern = /^1\d{10}$|^\d{7,8}$|^0[1-9]\d{1,2}-\d{7,8}$|^0[1-9]\d{8,10}$/;
	return pattern.test(s);
}

//校验用户名
function isUserName(s) {
	var pattern = /^[a-zA-Z0-9_\-\u4e00-\u9fa5]+$/;
	return pattern.test(s)&&s.length>=4&&s.length<=20;
}

//校验用户名
function isPassword(s) {
	return s.length>=6&&s.length<=20;
}