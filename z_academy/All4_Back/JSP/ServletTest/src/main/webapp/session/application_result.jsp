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

<%
	// num �� ���ø����̼� number �� �ֱ�
	int num = (Integer)application.getAttribute("number");

	// ���ΰ�ħ���� �����, num ������Ŵ
	num ++;
	
	// ���ø����̼ǿ� ������ num �� ������
	application.setAttribute("number", num);
	%>
					<!-- �װ� �̾ƿ�  �̰Ŵ� ������-->
<h3>number : <%=application.getAttribute("number") %></h3>

</body>
</html>