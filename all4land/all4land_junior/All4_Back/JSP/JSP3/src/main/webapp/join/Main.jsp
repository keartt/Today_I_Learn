<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%= session.getAttribute("id") %>님이 로그인한 상태입니다. <br/>

<%
//일반유저1 어드민2
int login = (int)session.getAttribute("login"); 
out.println("<a href='logOut.jsp'> 로그아웃 </a><br><br>"); %>
<%
if(login == 2){
	out.println("<a href='Member_list.jsp'>"+ "회원정보 DB 조회하기" +"</a>");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<hr>


</body>
</html>