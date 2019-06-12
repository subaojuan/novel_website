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
<title>增加小说</title>
</head>
<body>
	<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	<!-- 留空格 -->
	<div style="height: 70px"></div>
	
	<!-- 表单增加小说 -->
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">增加小说</h3>
			</div>
			<div class="panel-body">
				<form role="form" action="addNovel.action" method="post" class="form-horizontal" enctype="multipart/form-data">
					<div class="form-group">
						<label for="new_novel_name" class="col-sm-2 control-label">小说名</label>
						<div class="col-sm-10">
							<input id="new_novel_name" name="new_novel_name" class="form-control" placeholder="输入小说名"/>
						</div>
					</div>		
					<div class="form-group">
						<label for="new_novel_type" class="col-sm-2 control-label">类型</label>
						<div class="col-sm-10">
							<select id="new_novel_type" name="new_novel_type" class="form-control">
								<c:forEach items="${sessionScope.types }" var="type" varStatus="v">
									<option>${type }</option>
								</c:forEach>
							</select>
						</div>
					</div>		
					<div class="form-group">
						<label for="new_novel_info" class="col-sm-2 control-label">描述</label>
						<div class="col-sm-10">
							<textarea id="new_novel_info" name="new_novel_info" class="form-control" placeholder="对小说进行简单的描述……"></textarea>
						</div>
					</div>
					<!-- 封面 -->
					<div class="form-group">
						<label for="new_novel_face" class="col-sm-2 control-label">
							封面
						</label>
						<div class="col-sm-10">
							<input id="new_novel_face" class="form-control" type="file" name="novelFace" style="border: none">
							<div class="alert alert-warning">小提示：当封面不做选择时，网站会给予一个默认封面！</div>
						</div>
					</div>
					<div class="form-group">
						<input hidden="hidden" name="authorId" value="${sessionScope.detailMap.get('user_main_id') }"/>
						<label class="col-sm-2 control-label">&nbsp;</label>
						<button class="btn btn-primary col-sm-1" type="submit">发布</button>
						<button class="btn btn-primary col-sm-1" type="reset">全部重写</button>
					</div>
				</form>
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