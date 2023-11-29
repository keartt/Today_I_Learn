<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
table, tr, td {
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 테스트 결과</h2>
	<table>
		<tr>
			<td>이름</td>
			<td>직업</td>
			<td colspan="3">관심분야</td>
		</tr>
		<tr>
			<%
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length - 1; i++) {
					String cVal = cookies[i].getValue();
			%>
			<td>
				<%
				out.print(cVal);
				%>
			</td>
			<%}
			}
			%>
		</tr>
	</table>

</body>
</html>