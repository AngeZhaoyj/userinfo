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
	function toAdd(){
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
		if(dept_id.trim().length==0){
			$("#msg").html("请选择组织机构！");
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
		if(state.trim().length==0){
			$("#msg").html("请选择用户状态！");
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

	function checkCoded(){
		var coded = $("#coded").val();
		$.post("userinfo/checkCoded",{coded:coded},function(data){
			if(data.msg){
				 $("#accmsg").css("color","#00ff00");
				 $("#accmsg").html("编号可用！");
				 $("#btn").attr("disabled",false);
			}else{
				 $("#accmsg").css("color","#ff0000");
				 $("#accmsg").html("编号不可用！");
				 $("#btn").attr("disabled",true);
			}
		},"json");
	}

	function checkTelephone(){
		var telephone = $("#telephone").val();
		$.post("userinfo/checkTelephone",{telephone:telephone},function(data){
			if(data.msg){
				 $("#telmsg").css("color","#00ff00");
				 $("#telmsg").html("手机号可用！");
				 $("#btn").attr("disabled",false);
			}else{
				 $("#telmsg").css("color","#ff0000");
				 $("#telmsg").html("手机号不可用！");
				 $("#btn").attr("disabled",true);
			}
		},"json");
	}
</script>

</head>
<body>
<h1>员工添加</h1>
	<form action="userinfo/add" method="post" id="myForm">
		编号：<input type="text" name="coded" onchange="checkCoded()" id="coded"/>
			<span id="accmsg"></span><br>
		姓名：<input type="text" name="name" id="name"/><br>
		姓名全拼：<input type="text" name="name_spell" id="name_spell"/><br>
		组织机构：<select id="dept_id" name="dept_id">
					<option value="">请选择部门</option>
					<c:forEach items="${deptList }" var="dept">
						<option value="${dept.dept_id }">${dept.name }</option>
					</c:forEach>
			   </select><br>
		手机号：<input type="text" name="telephone" onchange="checkTelephone()" id="telephone"/>
		<span id="telmsg"></span><br>
		电子邮件:<input type="text" onFocus="autoEmail()" name="email" id="email"/><br>
		员工状态：<select id="state" name="state">
					<option value="">请选择状态</option>
					<option value="0">试用</option>
					<option value="1">正式</option>
					<option value="2">退休</option>
					<option value="3">离职</option>
			   </select><br>
		<input type="button" id="btn" onclick="toAdd()" value="确认添加"/>
	</form>
	<span id="msg"></span>
</body>
</html>