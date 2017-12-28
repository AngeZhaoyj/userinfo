<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function toSub(){
		var account = $("#account").val();
		var password = $("#password").val();
		if(account.trim().length==0){
			$("#msg").html("请输入账号！");
			return false;
		}
		if(password.trim().length==0){
			$("#msg").html("请输入密码！");
			return false;
		}
		$("#myForm").submit();
	}
</script>

</head>
<body>

<form action="login" method="post" id="myForm">
	账号：<input type="text" name="account" id="account"/>
	密码：<input type="password" name="password" id="password"/>
	<input type="button" value="登录" onclick="toSub()"/>
	<span id="msg">${message }</span>
</form>

</body>
</html>