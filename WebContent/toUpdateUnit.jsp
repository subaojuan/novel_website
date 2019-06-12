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
<title>更新章节</title>
</head>
<body>
<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	
	<div class="container">
		<c:forEach items="${requestScope.unitList }" var="unitList" varStatus="v">
		<div class="panel panel-default">
	   		<div class="panel-heading">
	       		<h3 class="panel-title">
	       			《${requestScope.novel }》第${unitList.get("UNIT") }章节
	       		</h3>
	   		</div>
	   		<div class="panel-body">
	   			<form role="form" action="updateContent.action" method="post" class="form-horizontal">
	   				<input hidden="hidden" name="unit" value="${unitList.get('UNIT') }">
	   				<input hidden="hidden" name="novel" value="${requestScope.novel }">
	   				
	   				<!-- 更新时间 -->
	   				<div class="form-group">
						<label for="time" class="col-sm-2 control-label">
							更新时间
						</label>
						<div class="col-sm-10">
							<input disabled="disabled" value="${unitList.get('UPDATE_DATE') }" id="time" class="form-control"  name="time" style="border: none">
						</div>
					</div>
					<!-- 内容 -->
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">内容</label>
						<div class="col-sm-10">
							<textarea rows="20" id="content" name="content" class="form-control">${unitList.get('CONTENT') }</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-6 control-label">&nbsp;</label>
						<button class="btn btn-primary col-sm-1" type="submit">发布</button>
					</div>
	   			</form>
	   		</div>
	   	</div>
	   	</c:forEach>
	  
	   		
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