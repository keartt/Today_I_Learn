<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

h2 {
	color: #6600ff;
}

.btn {
	background-color: #ccccff;
	border: none;
	border-radius: 5px;
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
}

hr {
	background: #6600ff;
	height: 1px;
	border: 0;
}
;
</style>
</head>
<body>
<%
	// 값 받아오기
	String id = (String)session.getAttribute("id");
	if(id == null){
	%>
		<script>
			alert("로그인 후 이용해주세요");
			location.href='../member/login';
		</script>
	<%	
	}
	%>	
	<center>
		<h2>${content_view.member_id}님의 정보입니다.
		</h2>
		<hr>
		<table align="center" style="width: 900px; height: 150px;">
			<tr>
				<td style="background-color: #ccccff; width:120px;">아이디 :</td>
				<td>${content_view.member_id}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">비밀번호 :</td>
				<td>${content_view.member_pw}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">이름 :</td>
				<td>${content_view.member_name}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">이메일 :</td>
				<td>${content_view.member_email}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">주민번호 :</td>
				<td>${content_view.member_pnumber}</td>
			</tr>

			<tr>
				<td style="background-color: #ccccff">관심항목 :</td>
				<td>${content_view.member_favorite}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">자기소개 :</td>
				<td>${content_view.member_introduce}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">생년월일 :</td>
				<td>${content_view.member_year}년${content_view.member_month}월
					${content_view.member_day}일</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">우편번호 :</td>
				<td>${content_view.member_postcode}</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">주소 :</td>
				<td>${content_view.member_address}</td>
			</tr>
		</table>
		<br>
		<button class="btn" type="button" onclick="history.back();">이전</button>
		<button class="btn" type="button"
			onclick="location.href='../member/login';">로그아웃</button>
	</center>
</body>
</html>
