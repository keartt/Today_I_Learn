<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
table, tr, td {
border-collapse: collapse; border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>������ �Ӽ� �׽�Ʈ</h1>
	<form action="attributeTest1.jsp" method="post">
		<table>
			<tr>
				<td colspan="2">������ �Ӽ� �׽�Ʈ</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>