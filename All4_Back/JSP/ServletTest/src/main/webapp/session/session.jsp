<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<H2>session ����</H2>
<HR>
<% 
	if(session.isNew()) {
		out.println("<script> alert('������ �����Ǿ� �ٽ� �����մϴ�. ')</script>");
		session.setAttribute("login", "ȫ�浿");
	}	
%>
<%= session.getAttribute("login") %> �� ȯ���մϴ�. <br>
���� ���̵�  : <%= session.getId() %><br>
���� �����ð�  : <%= session.getMaxInactiveInterval() %> <br>

<button onclick="location.href = 'logout.jsp' ">�α׾ƿ� </button>

</body>
</html>