<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>������</h2>
<p>������ ����� ������ �ֵ����� ������ �������� �ѱ��.
<p> �׷��� �� ������ ȭ�鿡 ǥ�õ��� ���� 
<p> ������ url �� ���� ȣ��� forward �� ��
<hr>
	<jsp:forward page="footer2.jsp">
		<jsp:param name = "email" value = "test@test.net" />
		<jsp:param name = "tell" value = "000-000-0000" />
	</jsp:forward>
	

</body>
</html>