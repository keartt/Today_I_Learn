<%@page import="java.util.Enumeration"%>
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
	<%
	request.setCharacterEncoding("euc-kr");

	String name = (String) application.getAttribute("name");
	String id = (String) application.getAttribute("id");
	
	String email=(String)session.getAttribute("email");
	String address=(String)session.getAttribute("address");
	String tel=(String)session.getAttribute("tel");		

	%>
	<h3>���ø����̼ǰ� ���ǿ��� �ҷ�����</h3>
	<table>
		<tr>
			<td colspan="2">���ø����̼� ����</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td><%=id%></td>
		</tr>
		<tr>
			<td colspan="2">���ǿ���</td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>�ּ�</td>
			<td><%=address%></td>
		</tr>
		<tr>
			<td>��ȭ��ȣ</td>
			<td><%=tel%></td>
		</tr>

	</table>
</body>
</html>