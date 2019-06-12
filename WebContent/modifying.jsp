<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>修改小说</title>
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
	       			《${requestScope.novelDetail.get("NOVEL_NAME") }》的基本信息
	       		</h3>
	   		</div>
	   		<div class="panel-body">
	   			<form role="form" action="updateNovelDetail.action" method="post" class="form-horizontal" enctype="multipart/form-data">
					<!-- 封面 -->
					<div class="form-group">
						<label for="new_novel_face" class="col-sm-2 control-label">
							<img title="点击修改小说封面" width="120px" src="${requestScope.novelDetail.get('IMG') }">
						</label>
						<div class="col-sm-10">
							<input id="new_novel_face" class="form-control" type="file" name="novelFace" style="border: none">
						</div>
					</div>
					<!-- 小说名 -->
					<div class="form-group">
						<label for="new_novel_name" class="col-sm-2 control-label">小说名</label>
						<div class="col-sm-10">
							<input id="new_novel_name" name="new_novel_name" class="form-control" value="${requestScope.novelDetail.get('NOVEL_NAME') }"/>
						</div>
					</div>
					<!-- 作者信息 -->
					<div class="form-group">
						<label for="new_author_name" class="col-sm-2 control-label">作者</label>
						<div class="col-sm-10">
							<input disabled="disabled" id="new_author_name" name="new_author_name" class="form-control" value="${requestScope.novelDetail.get('AUTHOR_NAME') }"/>
						</div>
					</div>
					<!-- 描述 -->
					<div class="form-group">
						<label for="new_novel_info" class="col-sm-2 control-label">描述</label>
						<div class="col-sm-10">
							<textarea rows="7" id="new_novel_info" name="new_novel_info" class="form-control">${requestScope.novelDetail.get('INFO') }</textarea>
						</div>
					</div>
					<!-- 发布日期 -->
					<div class="form-group">
						<label for="new_birthday" class="col-sm-2 control-label">发布日期</label>
						<div class="col-sm-10">
							<input disabled="disabled" id="new_birthday" name="new_birthday" class="form-control" value="${requestScope.novelDetail.get('BIRTHDAY') }"/>
						</div>
					</div>
					<!--单元数目 -->
					<div class="form-group">
						<label for="new_units" class="col-sm-2 control-label">单元数目</label>
						<div class="col-sm-10">
							<input disabled="disabled" id="new_units" name="new_units" class="form-control" value="${requestScope.novelDetail.get('UNITS') }"/>
						</div>
					</div>
					<!-- 提交信息 -->
					<div class="form-group">
						<label class="col-sm-6 control-label">&nbsp;</label>
						<button class="btn btn-primary col-sm-1" type="submit">发布</button>
					</div>
				</form>
				<p/>
				<hr>
				<P/>
				<ul>
				<li style="list-style-type: none">修改：<a href="toUnitsDetail.action?novel=${requestScope.novelDetail.get('NOVEL_NAME') }">章节信息</a></li>
				<li style="list-style-type: none">新增：<a href="">章节信息</a></li>
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