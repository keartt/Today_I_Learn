<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
session.invalidate(); //세션 초기화 메서드
out.println("<script>alert('로그아웃 합니다.');</script>");
response.sendRedirect("MemberLogin.me");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>