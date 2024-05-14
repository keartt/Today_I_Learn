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

	<h1 align="center">회원정보</h1>
	<table width="600px" height="100px" border="1" align="center"
		cellpadding="5" cellspacing="0">
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px" width="100px">아이디</td>
			<td><%=me.getUser_id()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">비밀번호</td>
			<td><%=me.getUser_pw()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">이메일</td>
			<td><%=me.getEmail()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">이름</td>
			<td><%=me.getName()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">생년월일</td>
			<td><%=me.getBirth()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">취미</td>
			<td><%=me.getHobby()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">자기소개</td>
			<td><%=me.getIntro()%></td>
		</tr>
		<tr align="center">
			<td align="center" bgcolor="#eee"
				style="font-weight: bold; font-size: 18px">주소</td>
			<td><%=me.getAddress()%></td>
		</tr>
	</table>
<hr>
<button onclick = "location.href='./logout.me'"> 로그아웃</button>

</body>
</html>