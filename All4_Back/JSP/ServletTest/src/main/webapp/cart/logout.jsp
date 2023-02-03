<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
%>
<body>

	<script>
		window.onload = function() {
	<%session.invalidate();%>
		location.href = '../cart/Login.jsp'
		} // 세션 종료 후 반환
	</script>

</body>
</html>