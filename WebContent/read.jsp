<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%--引入JSTL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	
	<!--引入核心bootstrap样式-->
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<title>在线读</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	<div align="center">
	<h2 style="width: 75%;"><label class="label label-success">在线读：${data.get('name') }</label></h2>
	<h4 style="width: 75%">
		<label class="label label-primary">第${data.get('unit') }章节</label>
		<label class="label label-primary">更新日期：${data.get('update_date') }</label>
		<label class="label label-primary">本单元访问量：${data.get('count') }</label>
		
	</h4>
	</div>
		<div class="container">
		<div class="col-xs-13">
		<div class="jumbotron content_media" align="left">
			<c:forEach items="${data.get('content') }" var="content" varStatus="v">
			<p>${content}</p>
			</c:forEach>
		</div>
		<div align="center">
			<ul class="pager">
			
			<c:choose>
				<c:when test="${data.get('unit')-1 == 0}">
					<li class="disabled"><a href="mainInfo.action?name=${data.get('name') }&unit=1">上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="mainInfo.action?name=${data.get('name') }&unit=${data.get('unit')-1}">上一页</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="detail.action?name=${data.get('name') }">返回到：${data.get('name') }</a></li>
				<c:choose>
					<c:when test="${data.get('lastUnit')==data.get('unit')}">
					<li class="disabled"><a href="mainInfo.action?name=${data.get('name') }&unit=${data.get('unit')}">下一页</a></li>
					</c:when>
					<c:otherwise>
					<li><a href="mainInfo.action?name=${data.get('name') }&unit=${data.get('unit')+1}">下一页</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		</div>
		</div>
	

	<!-- 底部信息 -->
	<div class="footer"></div>
</body>
	<!--核心js插件：jquery-->
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<!--引入核心bootstrap 核心js文件,必须在引入js文件之后引入-->
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<!-- 自定义js -->
	<script type="text/javascript" src="js/index/index.js"></script>
</html>