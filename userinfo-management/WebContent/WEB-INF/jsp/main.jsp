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
function changeCurrentPage(currentPage){
	var currentPage = $("#currentPage").val(currentPage).val();
	$("#mainForm").submit();
}
</script>
</head>
<body>

<a href="userinfo/add" target="mainFrame">添加用户</a>

<form action="userinfo/query" id="mainForm" method="post">
	<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
	编号：<input type="text" name="coded" value="${queryUser.coded }"/>
	姓名：<input type="text" name="name" value="${queryUser.name }"/>
	手机号：<input type="text" name="telephone" value="${queryUser.telephone }"/>
	员工状态：  <select name="state">
				<option value=""
					<c:if test="${queryUser.state==null }">selected</c:if>
				>全部</option>
				<option value="0"
					<c:if test="${queryUser.state==0 }">selected</c:if>
				>试用</option>
				<option value="1"
					<c:if test="${queryUser.state==1 }">selected</c:if>
				>正式</option>
				<option value="2"
					<c:if test="${queryUser.state==2 }">selected</c:if>
				>退休</option>
				<option value="3"
					<c:if test="${queryUser.state==3 }">selected</c:if>
				>离职</option>
			</select>
	<input type="submit" value="查询"/>

	<table border="1" width="100%">
		<caption>员工列表</caption>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>姓名全拼</th>
				<th>组织机构</th>
				<th>手机号</th>
				<th>电子邮件</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty userinfoList }">
				<c:forEach items="${userinfoList }" var="user">
					<tr>
						<td>${user.coded }</td>
						<td>${user.name }</td>
						<td>${user.name_spell }</td>
						<td>
							<c:forEach items="${deptList }" var="dept">
								<c:if test="${user.dept_id==dept.dept_id }">${dept.name }</c:if>
							</c:forEach>
						</td>
						<td>${user.telephone }</td>
						<td>${user.email }</td>
						<td>
							<c:if test="${user.state==0 }">试用</c:if>
							<c:if test="${user.state==1 }">正式</c:if>
							<c:if test="${user.state==2 }">退休</c:if>
							<c:if test="${user.state==3 }">离职</c:if>
						</td>
						<td>${user.gmt_create }</td>
						<td>
						<a href="userinfo/update?id=${user.userinfo_id }" >编辑</a>
						<a href="userinfo/delete?id=${user.userinfo_id }" >删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty userinfoList }">
				<tr>
					<td colspan="9">没有数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	
	<div>  
		共 <b>${page.totalNumber}</b> 条  
		共<b>${page.totalPage }</b>页  
		<c:if test="${page.currentPage > 1}">  
		<a href="javascript:changeCurrentPage('1')">首页</a>  
		<a href="javascript:changeCurrentPage('${page.currentPage-1}')">上一页</a>  
		</c:if>  
		当前第<span>${page.currentPage}/${page.totalPage}</span>页  
		<c:if test="${page.currentPage < page.totalPage}">  
		<a href="javascript:changeCurrentPage('${page.currentPage+1}')">下一页</a>  
		<a href="javascript:changeCurrentPage('${page.totalPage}')">末页</a>  
		</c:if>  
	</div> 

</form>	
</body>
</html>