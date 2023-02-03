<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = request.getParameter("name");
	session.setAttribute("name", name);
	%>

	<script>
		window.onload = function() {
			location.href = '../cart/setProduct.jsp'
		}
	</script>

</body>
</html>