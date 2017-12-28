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
		var name_spell = $("#name_spell").val();
		var dept_id = $("#dept_id").val();
		var telephone = $("#telephone").val();
		var email = $("#email").val();
		var state = $("#state").val();
		if(coded.trim().length==0){
			$("#msg").html("请输入编号！");
			return false;
		}
		if(name.trim().length==0){
			$("#msg").html("请输入姓名！");
			return false;
		}
		if(name_spell.trim().length==0){
			$("#msg").html("请输入姓名全拼！");
			return false;
		}
		if(telephone.trim().length==0){
			$("#msg").html("请输入手机号！");
			return false;
		}
		if(email.trim().length==0){
			$("#msg").html("请输入姓名全拼！");
			return false;
		}
		
		$("#myForm").submit();
	}
	
	function autoEmail(){
		var name_spell = $("#name_spell").val();
		if(name_spell.trim().length==0){
			$("#msg").html("请输入姓名全拼！");
			return false;
		}
		$("#email").val(name_spell+"@jit.com.cn");
	}
	
</script>

</head>
<body>
<h1>员工修改</h1>
	<form action="userinfo/update" method="post" id="myForm">
		<input type="hidden" name="userinfo_id" value="${userinfo.userinfo_id }"/>
		编号：<input type="text" value=${userinfo.coded } name="coded" id="coded"/><br>
		姓名：<input type="text" value=${userinfo.name } name="name" id="name"/><br>
		姓名全拼：<input type="text" value=${userinfo.name_spell } name="name_spell" id="name_spell"/><br>
		组织机构：<select id="dept_id" name="dept_id">
					<c:forEach items="${deptList }" var="dept">
						<option value="${dept.dept_id }"
						<c:if test="${dept.dept_id==userinfo.dept_id }">selected</c:if>
						>${dept.name }</option>
					</c:forEach>
			   </select><br>
		手机号：<input type="text" value=${userinfo.telephone } name="telephone" id="telephone"/><br>
		电子邮件:<input type="text" value=${userinfo.email } onFocus="autoEmail()" name="email" id="email"/><br>
		员工状态：<select id="state" name="state">
					<option value="0"
					<c:if test="${userinfo.state=='0' }">selected</c:if>
					>试用</option>
					<option value="1"
					<c:if test="${userinfo.state=='1' }">selected</c:if>
					>正式</option>
					<option value="2"
					<c:if test="${userinfo.state=='2' }">selected</c:if>
					>退休</option>
					<option value="3"
					<c:if test="${userinfo.state=='3' }">selected</c:if>
					>离职</option>
			   </select><br>
		<input type="button" onclick="toUpdate()" value="确认修改"/>
	</form>
	<span id="msg"></span>
</body>
</html>