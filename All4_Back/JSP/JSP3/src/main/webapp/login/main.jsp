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
	<h1 align="center"><%=session.getAttribute("user_id") %> �� �ȳ��ϼ���</h1>
	
	<% 
		if((String)session.getAttribute("user_id") == "������") { %>
		<hr>
		
		<h3><a href="member_list.jsp"> ������������  �̵�</a></h3>
		
	<% } %>
	<button onclick="location.href='logout.jsp'">�α׾ƿ�</button>
	</center>
	

</body>
</html>