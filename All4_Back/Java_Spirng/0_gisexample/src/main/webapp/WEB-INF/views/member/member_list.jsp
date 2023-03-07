<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}

h2 {
	color: #6600ff;
}

.btn {
	background-color: #ccccff;
	border: none;
	border-radius: 5px;
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
}

hr {
	background: #6600ff;
	height: 1px;
	border: 0;
}
;
</style>
</head>
<body>
<%
	// 값 받아오기
	String id = (String)session.getAttribute("id");
	if(id == null){
	%>
		<script>
			alert("로그인 후 이용해주세요");
			location.href='../member/login';
		</script>
	<%	
	}
	%>
	<center>
		<h2>회원목록</h2>
		<hr><br>
		<table align="center">
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="/test01/admin/detail?id=${dto.member_id}">${dto.member_id}</a></td>
				<td><button class="btn" onclick="location.href='/test01/admin/delete?id=${dto.member_id}'">삭제</button></td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<button class="btn" type="button" onclick="history.back();">이전</button>
		<button class="btn" type="button" onclick="location.href='../login';">로그아웃</button>
		</center>
</body>


</html>
