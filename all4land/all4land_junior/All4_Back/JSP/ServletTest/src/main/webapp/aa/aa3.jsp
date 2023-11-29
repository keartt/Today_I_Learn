<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");
	String job = request.getParameter("job");
	String inter [] =request.getParameterValues("inter");
	%>
	<h2>결과</h2>
	<h3>
		이름 :
		<%=name%></h3>
	<h3>
		직업 :
		<%=job%></h3>
		
	<h3>
		취미 :
		<% for(int i=0; i < inter.length; i++) { %>
		<%=inter[i]%><br>
		<%} %></h3>
</body>
</html>