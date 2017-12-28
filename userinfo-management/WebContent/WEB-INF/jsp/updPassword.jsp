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
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	function toSub(){
		var password = $("#password").val();
		if(password.trim().length==0){
			$("#msg").html("请输入新密码！");
			return false;
		}
		$("#myForm").submit();
	}
</script>
</head>
<body>
<form action="userinfo/updPassword" method="post" id="myForm">
	账号：<input type="text" name="account" value="admin" readonly/>
	新密码：<input type="password" name="password" id="password"/>
	<input type="button" value="确认" onclick="toSub()"/>
	<span id="msg"></span>
</form>
</body>
</html>