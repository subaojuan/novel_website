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
<title>${sessionScope.typeIndexNameMap.get("type_name") }</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	<div class="container">
		<div class="panel panel-default">
	   		<div class="panel-heading">
	       		<h3 class="panel-title">
	       		${sessionScope.typeIndexNameMap.get("type_name") }
	       		</h3>
	   		</div>
	   		<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>头像</th>
							<th>小说</th>
							<th>作者</th>
							<th>简介</th>
							<th>发布日期</th>
							<th>最近更新日期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.typeIndex }" var="typeIndex" varStatus="v">
							<tr>
								<td><img style="height: 130px;border: 1px solid #ccc;" alt="…" src="${ typeIndex.get('img')}" title="${ typeIndex.get('novel_name')}"></td>
								<td><a href="detail.action?name=${typeIndex.get('novel_name')}">${typeIndex.get('novel_name')}</a></td>
								<td>${typeIndex.get('author_name')}</td>
								<td width="50%">${typeIndex.get('info')}</td>
								<td>${typeIndex.get('birthday')}</td>
								<td>${typeIndex.get('last_modified_date')}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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