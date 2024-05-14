<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
</script>
<body>
	<% session.invalidate(); %>
	<center style="margin-top:10%">
	<h1>로그인</h1>
	<hr width="300"><br>
	<form action="setProduct.jsp" method="post">
		<input type="text" name="name" > 
		<input type="submit" value="로그인">
	</form>
	</center>
</body>
</html>