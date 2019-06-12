//动态时间
function getDate(){
	
	var date = new Date();
	
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var mintue = date.getMinutes();
	var week = date.getDay();
	
	//判断
	month = month > 9 ? month : "0"+month
	day = day > 9 ? day : "0"+day;
	var _m = hour < 12 ? "上午" : "下午";
	//设置无限时间，每1秒刷新一次。
	var time = document.getElementById("time");
	time.innerHTML = year+"年"+month+"月"+day+"日"+"星期"+week+_m+hour+"时"+mintue+"分";
	setTimeout("getDate()",60000);
}

$(document).ready(function(){
	// js加载导航网页
	$('.nav_head').load('html/nav_top_fixed.jsp');
});
$(document).ready(function(){
	// js加载底部页面
	$('.footer').load('html/footer.html');
});






function searchMore(x) {
	alert(x);
}
window.onload=function(){
	getDate();
}