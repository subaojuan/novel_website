/**
 * 前端校验数据的模板。
 * @param id 标签的id属性，选中该标签，并对其中的内容进行正则校验。
 * @param news 当校验不通过时，浏览器弹出该消息。
 * @param regex 正则表达式
 * @returns 当验证通过时，返回true。
 */
function checkData(id,news,regex){
	// 取出对应id标签中的值
	var datas = $("#" + id).val();
	// 验证不通过时，弹出消息
	if(! regex.test(datas)){
		alert(news);
		$("#" + id).focus();
		return false;
	}
	return true;
	
}

/**
 * 判断不为空。
 * @param id 标签的id属性，选中该标签
 * @param news 当校验不通过时，浏览器弹出该消息。
 * @returns 目标标签不为空时，返回true。
 */
function isNotEmpty(id,news){
	// 取出对应id标签中的值
	var datas = $("#" + id).val();
	// 该值为‘空’时，弹出消息。
	if(datas == ''){
		alert(news);
		$("#"+id).focus();
		return false;
	}
	return true;
}