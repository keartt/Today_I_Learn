<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��Ŭ��� ��� ����</h2>
<p>��Ŭ��� ����� footer�� ������ �� �������� ���Խ��Ѽ� �����ش�.,
<hr>

	<jsp:include page="footer2.jsp">
		<jsp:param name = "email" value = "test@test.net" />
		<jsp:param name = "tell" value = "000-000-0000" />
	</jsp:include>
	

</body>
</html>