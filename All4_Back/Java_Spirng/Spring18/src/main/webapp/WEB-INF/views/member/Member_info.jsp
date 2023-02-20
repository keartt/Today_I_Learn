<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<td>${member.user_id}</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">비밀번호</td>
				<td>${member.user_pw}</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">이메일</td>
				<td>${member.email}</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">이름</td>
				<td>${member.name}</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">생년월일</td>
				<td>${member.year} - ${member.month}  -  ${member.day} </td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">취미</td>
				<td>${member.interest}</td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">자기소개</td>
				<td>${member.introduce}</td>
			</tr>
		</table>
		<hr>
		<button onclick="location.href='/logout'">로그아웃</button>

	</body>
</html>