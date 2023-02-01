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
	String select = request.getParameter("pages");
	if (select == null) {
		select = "bestitem.jsp";
	}
	%>
	<table border="1"
		style="width: 700px; height: 200px; text-align: center;">
		<tr>
			<td colspan="2" style="width: 100%; height: 30%"><%@ include
					file="top.jsp"%></td>
		</tr>

		<tr>
			<td style="width: 30%; height: 40%""><%@ include
					file="left.jsp"%></td>
			<td><jsp:include page="<%=select%>" /></td>
		</tr>

		<tr>
			<td colspan="2" style="height: 30%"><%@ include
					file="bottom.jsp"%></td>
		</tr>

	</table>




</body>
</html>