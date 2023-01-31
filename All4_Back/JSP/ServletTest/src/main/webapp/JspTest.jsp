<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<%
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	http://localhost/ServletTest/JspTest.jsp
	-> jsp 는 url 에 jsp 라고 뜸 
	<h1> 현재시간은 <%=hour %> 시 
	<%=minute %> 분 <%=second %> 초  입니다.</h1>
</body>
</html>