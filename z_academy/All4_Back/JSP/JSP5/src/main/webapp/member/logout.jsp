<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
session.invalidate(); //���� �ʱ�ȭ �޼���
out.println("<script>alert('�α׾ƿ� �մϴ�.');</script>");
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