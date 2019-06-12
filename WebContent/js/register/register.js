// 校验用户名是否为空
function checkName(){
	return isNotEmpty('inputName','提示：名字不能为空');
};
// 校验邮箱格式
function checkEmail(){
	if(isNotEmpty('inputEmail','提示：邮箱不能为空')){
		var regex = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
		return checkData('inputEmail','提示：邮箱格式不正确',regex);
	};
	return false;
};

// 校验密码格式
function checkPwd(){
	if(isNotEmpty('inputPassword','提示：密码不能为空')){
		var regex = /^.*(?=.{6,32})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*? ]).*$/;
		return checkData('inputPassword','提示：密码格式不对',regex);
	};
};

// 校验电话格式，为空时返回true，不为空需要校验格式
function checkTel(){
	var datas = $("#inputTel").val();
	if(datas.trim() == '')return true;
	var regex = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\d{8}$/;
	return checkData('inputTel','提示：电话格式不对',regex);
};

// 提交时，需要调用该方法。校验需要检验的数据
function checkInput(){
	if(checkName() && checkEmail() && checkPwd() && checkTel()){
		return true;
	};
	return false;
};