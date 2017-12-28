<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	function toUpdate(){
		var coded = $("#coded").val();
		var name = $("#name").val();
		if(coded.trim().length==0){
			$("#msg").html("请输入机构编号！");
			return false;
		}
		if(name.trim().length==0){
			$("#msg").html("请输入机构名称！");
			return false;
		}
		
		$("#myForm").submit();
	}
</script>

</head>
<body>
<h1>机构修改</h1>
	<form action="dept/update" method="post" id="myForm">
		<input type="hidden" name="dept_id" value="${dept.dept_id }"/>
		编号：<input type="text" value=${dept.coded } name="coded" id="coded"/><br>
		名称：<input type="text" value=${dept.name } name="name" id="name"/><br>
		<input type="button" onclick="toUpdate()" value="确认修改"/>
	</form>
	<span id="msg"></span>
</body>
</html>