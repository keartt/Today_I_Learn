<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align: center">회원 목록 입니다.</h3>
	<hr>
	<center>
		<h1 align="center"> - </h1>
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td>유저 아이디</td>
				<td colspan="2">관리자 기능</td>
			</tr>
			<c:forEach items="${user_list}" var="dto">
				<tr align="center">
					<td align="center"  
						style="font-weight: bold; font-size: 18px">
							${dto.user_id}</td>
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">
						<a href="member_view?user_id=${dto.user_id}"> 조회 </a>
							</td>
					<td align="center" bgcolor="red"
						style="font-weight: bold; font-size: 18px">
						<a href="member_delete?user_id=${dto.user_id}"> 삭제 </a>
						</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
		<center>
			<button onclick="/logout">로그아웃</button>
		</center>
	</center>
</body>
</html>