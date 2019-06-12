<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success.jsp</title>
</head>
<body>
	<div>${sessionScope.emailMessage}</div>
	
	<div>${sessionScope.activateMessage}</div>
	
	<div><a href="http://localhost:8080/springmvc-mybatis01/types.action">返回主页</a></div>
</body>
</html>