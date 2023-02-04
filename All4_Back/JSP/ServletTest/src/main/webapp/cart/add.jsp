<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	if (session.getAttribute("name") == null) {
		out.println("<script>alert('로그인을 해주세요');</script>");
		out.println("<script>location.href='Login.jsp'</script>");
	}

	ArrayList<String> list = (ArrayList<String>) (session.getAttribute("list"));

	String car = request.getParameter("list");
	if (session.getAttribute("list") == null) {
		list = new ArrayList<String>();
	}

	list.add(car);
	session.setAttribute("list", list);
	%>
	<script>
		alert("<%=car%>  추가!");
		window.history.back();
	</script>
</body>
</html>