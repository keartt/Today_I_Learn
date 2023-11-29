<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>인클루드 방식 내용</h2>
<p>인클루드 방식은 footer의 내용을 이 페이지에 포함시켜서 보여준다.,
<hr>

	<jsp:include page="footer2.jsp">
		<jsp:param name = "email" value = "test@test.net" />
		<jsp:param name = "tell" value = "000-000-0000" />
	</jsp:include>
	

</body>
</html>