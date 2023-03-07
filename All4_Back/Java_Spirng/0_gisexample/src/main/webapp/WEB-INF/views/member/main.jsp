<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import.jsp</title>
<style type="text/css">
	h2{
		color: #6600ff;
	}
	.btn{
		background-color: #ccccff;
		border : none;
		border-radius: 5px;
		padding-left: 10px;
		padding-right: 10px;
		padding-top: 5px;
		padding-bottom: 5px;
	}
	hr{
		background:#6600ff;
    	height:1px;
    	border:0;
	}
</style>
</head>
<body>
<center>
<h2 >mainPage</h2>
<hr>
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
	// 관리자일 경우
	if(id.equals("admin")){
%>
			
	<h1><%=id%> 로그인하셨습니다.</h1>
	<a class="btn" href="/test01/admin/list">관리자모드 접속(회원 목록 보기)</a>
	<%} else{ // 관리자가 아닐 경우 
	%>
	<h2><%=id%> 로그인하셨습니다.</h2>
		<a class="btn" href="../test01/list">게시판으로 이동</a>
		<button class="btn" onclick="location.href='/test01/modify_view?id=<%=id%>'">내 정보 수정</button>
	<%} 
%>

</center>
</body>
</html>