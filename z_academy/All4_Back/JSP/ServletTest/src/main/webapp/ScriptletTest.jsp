<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Calendar" %>
<%!
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>����ð� <%=hour %> �� <%=minute %> �� <%=second %> ��</h1>
<%if(hour >= 12) { %>
<h2> �����Դϴ�.</h2>
<%} else { %>
<h2> �����Դϴ�.</h2>
<%} %>
</body>
</html>