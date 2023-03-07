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
		<form action="/test01/modify_act" method="post" name="modifyform">
			<tr>
				<td style="background-color: #ccccff; width:120px;">아이디 :</td>
				<td><input type="text" name="member_id" id="member_id" minlength="4"
					maxlength="12" size="10" value="${content_view.member_id}" readonly/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">비밀번호 :</td>
				<td>
					<input type="text" name="member_pw" id="member_pw" minlength="4"
					maxlength="12" size="10" value="${content_view.member_pw}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">이름 :</td>
				<td><input type="text" name="member_name" id="member_name" minlength="4"
					maxlength="12" size="10" value="${content_view.member_name}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">이메일 :</td>
				<td><input type="email" name="member_email" id="member_email" value="${content_view.member_email}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">주민번호 :</td>
				<td><input type="text" name="member_pnumber" size="30" value="${content_view.member_pnumber}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">관심항목 :</td>
				<td><input type="text" name="member_favorite" size="30" value="${content_view.member_favorite}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">자기소개 :</td>
				<td><textarea name="member_introduce" id="member_introduce" cols="50" rows="4" >${content_view.member_introduce}</textarea></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">생년월일 :</td>
				<td>
					<input type="text" name="member_year" size="5" value="${content_view.member_year}"/>년
					<input type="text" name="member_month" size="5" value="${content_view.member_month}"/>월
					<input type="text" name="member_day" size="5" value="${content_view.member_day}"/>일</td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">우편번호 :</td>
				<td><input type="text" name="member_postcode" size="5" value="${content_view.member_postcode}"/></td>
			</tr>
			<tr>
				<td style="background-color: #ccccff">주소 :</td>
				<td><input type="text" name="member_address" size="100" value="${content_view.member_address}"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn"  type="submit" value="수정"/>
					<button class="btn" type="button" onclick="history.back();">이전</button>
		<button class="btn" type="button"
			onclick="location.href='../member/login';">로그아웃</button>
				</td>
			</tr>
			
			</form>
		</table>
		<br>
	</center>
</body>
</html>
