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
<title>nav_top_fixed.jsp</title>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="types.action">宝儿小说网</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="types.action">主页</a></li>
        <li><a href="type.action?type=1">${types.get(0) }</a></li>
        <li><a href="type.action?type=2">${types.get(1) }</a></li>
        <li><a href="type.action?type=3">${types.get(2) }</a></li>
        <li><a href="type.action?type=4">${types.get(3) }</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他类型 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="type.action?type=5">${types.get(4) }</a></li>
            <li><a href="type.action?type=6">${types.get(5) }</a></li>
            <li><a href="type.action?type=7">${types.get(6) }</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="type.action?type=8">${types.get(7) }</a></li>
            <li><a href="type.action?type=9">${types.get(8) }</a></li>
			<li><a href="type.action?type=10">${types.get(9) }</a></li>
            <li><a href="type.action?type=11">${types.get(10) }</a></li>
          </ul>
        </li>
      </ul>
      <!-- 使用表单提交需要查找的小说的名字，然后进行后台处理数据 -->
      <form class="navbar-form navbar-left" role="search" action="select.action">
        <div class="form-group">
          <input type="text" name="novel_name" class="form-control" placeholder="请输入完整的小说名字……">
        </div>
        <button type="submit" class="btn btn-success">点我查找</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      	<c:choose>
      		<c:when test="${sessionScope.username != null}">
      			<li><a href="usermain.action" title="已登录用户：${sessionScope.username }，点击查看个人信息"><img class="img-circle" style="height: 20px" src="./${sessionScope.detailMap.get('display')}"></a></li>
      			<li><a href="logout.action" title="退出登陆状态">注销</a></li>
      		</c:when>
      		<c:otherwise>
      			<li><a href="login.action">登陆</a></li>
        		<li><a href="register.action">注册</a></li>
      		</c:otherwise>
      	</c:choose>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">名站推荐<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a target="_blank" href="https://m.qidian.com/">起点中文网</a></li>
            <li><a target="_blank" href="http://h5.17k.com/">17k小说</a></li>
            <li><a target="_blank" href="http://www.7878xs.com/">7878小说</a></li>
            <li><a target="_blank" href="http://hao.xsldh.com">小森林导航</a></li>
            <li><a target="_blank" href="https://www.duanwenxue.com">短文学</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>