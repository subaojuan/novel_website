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
	<title>搜索</title>
	<!-- 表格样式 -->
	<style type="text/css">
        .myTable{
        	border:1px solid green;
        	width:1000px;
        }
		table tr{
			border:1px solid green;
		}
    </style>

</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	
	<!-- 核心内容 -->
	<div align="center">
	<h3 class='btn-success' style="padding: 3px;width: 75%">搜索结果</h3>
	</div>
	<div class="container">
	<div class="col-xs-13">
		<div class="jumbotron content_media" align="center">
			<div class="media">
			<div id="media-left" class="media-left media-middle">
				<!-- 表格展示 -->
				<table class="table-hover myTable">
					<thead>
						<tr>
							<td>序号</td>
							<td>小说名</td>
							<td>作者</td>
							<td>发布日期</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${requestScope.novels }" var="novel" varStatus="v">
						<tr>
							<td style="border: 1px solid green">${v.count}</td>
							<td> <a href="detail.action?name=${novel.get('name')}">${novel.get('name') }</a></td>
							<td>${novel.get('author_name') }</td>
							<td>${novel.get('birthday') }</td>
						</tr>
					</c:forEach>
					</tbody>
				 </table>
			</div>
			</div>
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