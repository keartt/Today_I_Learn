<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%= session.getAttribute("id") %>���� �α����� �����Դϴ�. <br/>

<%
//�Ϲ�����1 ����2
int login = (int)session.getAttribute("login"); 
out.println("<a href='logOut.jsp'> �α׾ƿ� </a><br><br>"); %>
<%
if(login == 2){
	out.println("<a href='Member_list.jsp'>"+ "ȸ������ DB ��ȸ�ϱ�" +"</a>");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<hr>


</body>
</html>