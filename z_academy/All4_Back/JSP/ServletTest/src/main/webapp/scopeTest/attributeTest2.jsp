<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2> ���� Ȯ��</h2>
<%
request.setCharacterEncoding("euc-kr");

String email=request.getParameter("email");
String address = request.getParameter("address");
String tel = request.getParameter("tel");

session.setAttribute("email", email);
session.setAttribute("address", address);
session.setAttribute("tel", tel);

String name=(String)application.getAttribute("name");
%>
<h3><%=name	 %> ���� ������ ��� ����Ǿ����ϴ�. </h3>
<a href="attributeTest3.jsp">Ȯ���Ϸ�����</a>
</body>
</html>