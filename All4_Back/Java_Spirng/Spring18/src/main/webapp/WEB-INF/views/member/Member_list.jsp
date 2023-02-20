<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align:center">회원 목록 입니다.</h3>
<hr>
	<center>
		<h1 align="center">로그인</h1>
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">

			<c:forEach items="${user_list}" var="dto">
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px"><a href="#">
							${dto.user_id} </a></td>
					<td align="center" bgcolor="red"
						style="font-weight: bold; font-size: 18px"><a href="#">
							삭제 하시꺄 </a></td>
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