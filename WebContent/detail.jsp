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
	<style type="text/css">
		.detail-title{
			color:#fff;
		}
		.detail-img{
			height: 130px;
			border:1px solid #ccc;
		}
		.table td{
			width: 50%;
		}
	</style>
	
	
	<title>作品详情页</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	
	<div class="container">
	<div class="col-xs-13 media">
		<div class="media-top">
			<h2><label class="detail-title label label-success">${detail.get('novel_name') }</label></h2>
		</div>
		<div class="jumbotron content_media">
			<div class="media-left">
				<!-- 此处的img暂时使用静态处理。若要更换动态 -->
				<img class="detail-img" src="${detail.get('img')==null ? 'img/novel_pic/chuanyuezhicuangailishizhishu.jpg':detail.get('img') }"/>	
			</div>
			
			<div class="media-body">
				<table class="table">
					  <caption>${detail.get('novel_name') }</caption>
						  <tbody>
						    <tr>
						      <td>书名</td>
						      <td>${detail.get('novel_name') }</td></tr>
						    <tr>
						      <td>作者</td>
						      <td>${detail.get('author_name') }</td></tr>
						    <tr>
						      <td>类型</td>
						      <td>${detail.get('type_name') }</td></tr>
						    <tr>
						      <td>发布日期</td>
						      <td>${detail.get('birthday') }</td></tr>
						    <tr>
						      <td>章节数目</td>
						      <td>${detail.get('units') }</td></tr>
						    <tr>
						      <td>最近一次更新时间</td>
						      <td>${detail.get('last_modified_date') }</td></tr>
						    <tr>
						      <td>作品介绍</td>
						      <td>${detail.get('info') }</td></tr>
						  </tbody>
				</table>
			</div>
			<div class="media-bottom">
				<a href="download.action?filename=倚天屠龙记.txt">点我下载！</a>
			</div>
		</div>
		<!-- 阅读专区 -->
		<h2><label class="detail-title label label-success">阅读</label></h2>
		<div class="jumbotron content_media">
			<c:forEach items="${requestScope.units }" var="unit" varStatus="v">
			<a href="mainInfo.action?name=${detail.get('novel_name') }&unit=${unit.get('unit')}">第${unit.get('unit') }章节</a>
			</c:forEach>
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