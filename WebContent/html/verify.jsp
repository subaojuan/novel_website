<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.xatu.novel.util.VerifyCode" %>
<%@page import="java.awt.image.BufferedImage"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>verify</title>
</head>
<body>

	<!-- 
		该页面，只用于生成图片。
	
	 -->
	<%
 	VerifyCode verify = new VerifyCode();
  	//得到验证码图片
  	BufferedImage image = verify.getImage();
  		
  	session.setAttribute("session_verifyCode", verify.getText());
  		
  	out.clearBuffer();
  	out = pageContext.pushBody();
  		
  	//把图片响应到客户端
  	verify.output(image, response.getOutputStream());
	%>
</body>
</html>