<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import="join.UsersDAO"%>
<%@ page import="join.Users"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	String id = (String) request.getAttribute("user_id");
	Users users = new UsersDAO().getUsers(id);
	%>
	<p><%=users.getUser_id() %>
	<p><%=users.getUser_pw() %>
	<p><%=users.getEmail() %>
	<p><%=users.getName() %>
	<p><%=users.getRegi_num_front() %>
	<p><%=users.getRegi_num_back() %>
	<p><%=users.getYear() %>
	<p><%=users.getMonth() %>
	<p><%=users.getDay() %>
	<p><%=users.getIntroduce() %>
	<p><%=users.getInterest() %>
	 
</body>
</html>