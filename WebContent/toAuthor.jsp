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
<title>成为作者</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	<!-- 内容 -->
	<div class="col-xs-13 container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">成为作者
					<!-- 当该用户没有激活时，提示用户进行激活 -->
					<c:if test="${requestScope.live==0 }">
						<label>（提示：成为作者必须要先<a href="activate.action?code=${requestScope.code }">成为已激活账户</a>)</label>
					</c:if>
				</h3>
			</div>
			<div >
				<div class="col-xs-13">
					<form action="doAuthor.action">
						<table class="table table-hover">
							<thead>
								<tr><td>教育经历</td><td><input hidden="hidden" name="experience_id" value="${id }"/></td></tr>
							</thead>
							<tbody>
								<tr><td>学校名称</td><td><input name="school"/></td></tr>
								<tr><td>专业</td><td><input name="subject"/></td></tr>
								<tr><td>入学时间</td><td><input name="inschool" type="date"/></td></tr>
								<tr><td>毕业时间</td><td><input name="outschool" type="date"/></td></tr>
								<tr><td>学历（专/本/硕/博等）</td><td><input name="educational"/></td></tr>
								<tr><td>笔名</td><td><input name="name"/></td></tr>
							</tbody>
							<tfoot>
								<tr>
									<td>
										<button class="btn btn-success" type="submit">成为作者</button>
										<button class="btn btn-success" type="reset">重填</button>
									</td>
									<td></td>
								</tr>
							</tfoot>
						</table>
					</form>
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