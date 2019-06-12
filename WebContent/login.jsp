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
	<link rel="stylesheet" href="css/comm.css" />
	<title>login.jsp</title>
	
		<style type="text/css">
			.form-container{margin-top: 70px;}
			.jumbotron{height: 500px;}
			
			.radio input{width:60px;}
			.radio label{width: 100px;}
		</style>
		
		
</head>
<body>
	<!-- 导航栏 -->
	<div class="nav_head"></div>
		<!-- 登陆表 -->
		<div class="container form-container">
			<div class="jumbotron">
				<form action="doLogin.action" method="post" class="form-horizontal">
					<div class="form-group has-warning has-feedback">
						<label for="inputName" class="col-sm-2 control-label">登陆名称</label>
						<div class="col-sm-10">
					    	<div class="input-group">
					    		<span class="input-group-addon">●</span>
					      		<input name="name" type="text" class="form-control" id="inputName" aria-describedby="inputNameStatus" placeholder="${requestScope.name_placeholder }">
					    	</div>
					    	<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
					    	<span id="inputNameStatus" class="sr-only">(success)</span>
				    	</div>
					</div>
					<div class="form-group has-warning has-feedback">
			    		<label for="inputPassword" class="col-sm-2 control-label">用户密码</label>
			    		<div class="col-sm-10">
				    		<div class="input-group">
				    			<span class="input-group-addon">●</span>
				      	 		<input name="password" type="password" class="form-control" id="inputPassword" aria-describedby="inputPasswordStatus" placeholder="${requestScope.pwd_placeholder }">
				    		</div>
				    		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
					    	<span id="inputPasswordStatus" class="sr-only">(success)</span>
			    		</div>
			  		</div>
			  		
			  		<div class="form-group has-warning has-feedback">
			    		<label for="" class="col-sm-2 control-label">选择类型</label>
			    		<div class="col-sm-10">
				    		<div class="radio" align="left">
				    			<input type="radio" id="user" name="type" value="user" checked="checked"/>
				    			<label for="user">普通读者</label>
				    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    			<input type="radio" id="author" name="type" value="author"/>
				    			<label for="author">专属作者</label>
				    		</div>
				    	</div>
			    	</div>
			    	
			    	<div class="form-group has-warning has-feedback">
			    		<label for="verify" class="col-sm-2 control-label">输入验证</label>
			    		<div class="col-sm-10">
					    	<input type="text" name="verify" id="verify" class="form-control" placeholder="${requestScope.verify_placeholder }"/>
					    	<img src="html/verify.jsp" id="ver" border="1px"/>
					    	<input type="button" class="btn btn-primary" onclick="change()" title="看不清，换一张？" value="换一张"/>	
				    	</div>
			    	</div>
			    	
			    	<div class="form-group has-success has-feedback">
			    		<div class="col-sm-offset-2 col-sm-10">
			      			<button type="submit" class="btn btn-success">提交</button>
			      			<button type="reset" class="btn btn-primary">重写</button>
			    		</div>
			  		</div>
				</form>
			</div>
		</div>
	
	
	<div class="footer"></div>
</body>

	
	<!--核心js插件：jquery-->
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<!--引入核心bootstrap 核心js文件,必须在引入js文件之后引入-->
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			// js加载导航网页
			$('.nav_head').load('html/nav_top_fixed.jsp');
		});
		$(document).ready(function(){
			// js加载底部页面
			$('.footer').load('html/footer.html');
		});
		
	   	function change(){
	   		window.location.href = "login.action";
	   	};
	</script>
</html>