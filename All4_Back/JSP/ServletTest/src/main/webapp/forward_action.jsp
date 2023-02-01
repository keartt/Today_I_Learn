<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>포워드</h2>
<p>포워드 방식은 페이지 주도권을 포워드 페이지로 넘긴다.
<p> 그래서 이 문장은 화면에 표시되지 않음 
<p> 하지만 url 은 최초 호출된 forward 가 뜸
<hr>
	<jsp:forward page="footer2.jsp">
		<jsp:param name = "email" value = "test@test.net" />
		<jsp:param name = "tell" value = "000-000-0000" />
	</jsp:forward>
	

</body>
</html>