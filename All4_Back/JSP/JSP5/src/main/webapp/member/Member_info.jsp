<%@page import="java.util.List"%>
<%@page import="net.member.db.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="net.member.db.MemberBean"%>
<%@ page import="net.member.db.MemberDAO"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>



<body>

	<%
	String id = null;
	if (request.getParameter("id") != null) {
		id = request.getParameter("id");
	}

	MemberBean me = (MemberBean) request.getAttribute("member");
	%>

	<h1 align="center">ȸ������</h1>
	<table width="600px" height="100px" border="1" align="center"
		cellpadding="5" cellspacing="0">
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px" width="100px">���̵�</td>
			<td><%=me.getUser_id()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">��й�ȣ</td>
			<td><%=me.getUser_pw()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">�̸���</td>
			<td><%=me.getEmail()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">�̸�</td>
			<td><%=me.getName()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">�������</td>
			<td><%=me.getBirth()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">���</td>
			<td><%=me.getHobby()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">�ڱ�Ұ�</td>
			<td><%=me.getIntro()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">�ּ�</td>
			<td><%=me.getAddress()%></td>
		</tr>
	</table>
<hr>
<button onclick = "location.href='./logout.me'"> �α׾ƿ�</button>

</body>
</html>