<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<h3 style="text-align: center">회원 정보입니다.</h3>
<hr>
<center>
	<body>

		<h1 align="center">회원정보</h1>
		<table width="600px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px" width="100px">아이디</td>
				<td>아이디</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">비밀번호</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">이메일</td>
				<td>이메일</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">이름</td>
				<td>이름</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">생년월일</td>
				<td>생년월일</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">취미</td>
				<td>취미</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">자기소개</td>
				<td>자기소개</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">주소</td>
				<td>주소</td>
			</tr>
		</table>
		<hr>
		<button onclick="logout">로그아웃</button>

	</body>
</html>