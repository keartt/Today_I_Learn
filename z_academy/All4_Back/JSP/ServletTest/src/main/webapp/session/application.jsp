<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>application ����</h2>

<hr>
<span style="color:red">1. �������� : </span><%=application.getServerInfo() %> <br>
<span style="color:red">2. ���� api ���� ����</span> <%= application.getMajorVersion()  + " �� " +application.getMinorVersion() %> <br>
<span style="color:red">3. application.jsp ���� ��� : </span><%= application.getRealPath("application.jsp") %> <br>



<%
// applicaion �� number ��� �̸����� ���� 0 �Ҵ�
application.setAttribute("number",0); %>
<a href=application_result.jsp>Ȯ���ϱ�</a>

</body>
</html>