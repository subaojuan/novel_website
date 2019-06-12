<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%--引入JSTL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
		<title>注册页面</title>
	</head>
	
	<style type="text/css">
		.form-container{margin-top: 70px;}
		.jumbotron{height: 600px;}
		.checkbox{line-height: 100%;}
	</style>
<body>
		<!-- 顶部导航栏 -->
	<div class="nav_head"></div>
	
	<div class="container form-container">
		<div class="jumbotron">
			<form action="doRegister.action" method="post" class="form-horizontal"  onsubmit="checkInput()">
				<!-- 隐藏主键  -->
				<input name="id" type="text" id="inputId" hidden="true"/>
				<div class="form-group has-success has-feedback">
				    <label for="inputName" class="col-sm-2 control-label">用户昵称(必填)</label>
				    <div class="col-sm-10">
				    	<div class="input-group">
				    		<span class="input-group-addon">❁</span>
				      		<input name="name" type="text" class="form-control" id="inputName" aria-describedby="inputNameStatus" placeholder='${sessionScope.name_placeholder }'>
				    	</div>
				    	<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
				    	<span id="inputNameStatus" class="sr-only">(success)</span>
				    </div>
  				</div>
				<div class="form-group has-success has-feedback">
				    <label for="inputEmail" class="col-sm-2 control-label">电子邮箱(必填)</label>
				    <div class="col-sm-10">
				    	<div class="input-group">
				    		<span class="input-group-addon">✉</span>
				      		<input type="email" name="email" class="form-control" id="inputEmail" aria-describedby="inputEmailStatus" placeholder='${sessionScope.email_placeholder }'>
				    	</div> 
				    	<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
				    	<span id="inputEmailStatus" class="sr-only">(success)</span>
				    </div>
  				</div>
			  	<div class="form-group has-success has-feedback">
			    	<label for="inputPassword" class="col-sm-2 control-label">用户密码(必填)</label>
			    	<div class="col-sm-10">
			    		<div class="input-group">
			    			<span class="input-group-addon">※</span>
			      	 		<input name="password" type="password" class="form-control" id="inputPassword" aria-describedby="inputPasswordStatus" placeholder='${sessionScope.password_placeholder }'>
			    		</div>
			    		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
				    	<span id="inputPasswordStatus" class="sr-only">(success)</span>
			    	</div>
			  	</div>
			  	<div class="form-group has-feedback">
			    	<label for="inputTel" class="col-sm-2 control-label">联系电话(可选)</label>
			    	<div class="col-sm-10">
			    		<div class="input-group">
			    			<span class="input-group-addon">☏</span>
			      	 		<input name="telephone" type="tel" class="form-control" id="inputTel" placeholder='${sessionScope.tel_placeholder }'>
			    		</div>
			    		<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
				    	<span id="inputPasswordStatus" class="sr-only">(success)</span>
			    	</div>
			  	</div>
  				<div class="form-group has-feedback">
				    <label for="" class="col-sm-2 control-label">喜欢类型(可选)</label>
				    <div class="col-sm-10">
			      		<div class="checkbox">
				      		<c:forEach var="type" items="${sessionScope.types }" varStatus="v">
				      			<label for="checkbox-${v.count }" class="label label-primary">
				      				<input name="like${v.count }" type="checkbox" id="checkbox-${v.count }" value="${v.count }">${type }
				      			</label>&nbsp;&nbsp;
				      		</c:forEach>
			      		</div>			   
				    </div>
  				</div>
  				<div  class="form-group">
  					<label for="inputInfo" class="col-sm-2 control-label">自我介绍(可选)</label>
  					<div class="col-sm-10">
  						<textarea id="inputInfo" name="info" class="form-control" rows="5">什么都没写呢…</textarea>
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



	<!-- 底部信息 -->
	<div class="footer"></div>
</body>

	<!--核心js插件：jquery-->
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<!--引入核心bootstrap 核心js文件,必须在引入js文件之后引入-->
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	<!-- 自定义js -->
	<script type="text/javascript" src="js/checking.js"></script>
	<script type="text/javascript" src="js/register/register.js"></script>
	<script>
		$(document).ready(function(){
			// js加载导航网页
			$('.nav_head').load('html/nav_top_fixed.jsp');
		});
		$(document).ready(function(){
			// js加载底部页面
			$('.footer').load('html/footer.html');
		});
		
	</script>
</html>