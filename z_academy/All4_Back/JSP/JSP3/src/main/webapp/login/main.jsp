<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<body>
	<center>
	<h1 align="center"><%=session.getAttribute("user_id") %> 님 안녕하세요</h1>
	
	<% 
		if((String)session.getAttribute("user_id") == "관리자") { %>
		<hr>
		
		<h3><a href="member_list.jsp"> 관리자페이지  이동</a></h3>
		
	<% } %>
	<button onclick="location.href='logout.jsp'">로그아웃</button>
	</center>
	

</body>
</html>