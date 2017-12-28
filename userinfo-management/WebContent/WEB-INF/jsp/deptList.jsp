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

<a href="dept/add" target="mainFrame">添加机构</a>

<form action="dept/query" id="mainForm" method="post">
	<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
	编号：<input type="text" name="coded" value="${queryDept.coded }"/>
	名称：<input type="text" name="name" value="${queryDept.name }"/>
	<input type="submit" value="查询"/>

	<table border="1" width="100%">
		<caption>机构列表</caption>
		<thead>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty deptList }">
				<c:forEach items="${deptList }" var="dept">
					<tr>
						<td>${dept.coded }</td>
						<td>${dept.name }</td>
						<td>
						<a href="dept/update?id=${dept.dept_id }" >编辑</a>
						<a href="dept/delete?id=${dept.dept_id }" >删除</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty deptList }">
				<tr>
					<td colspan="3">没有数据</td>
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