<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style="text-align: center">글 작성 입니다.</h3>
	<hr>
	<center>

		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="write" method="post" enctype="multipart/form-data">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="bName" size="50"
						value="${user_id}" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" size="50"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="bContent" rows="10"></textarea></td>
				</Vtr>
				<tr>
					<td>파일 첨부</td>
					<td><input name="file" type="file" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">
						&nbsp;&nbsp; <a href="list">목록보기</a></td>
				</tr>
			</form>
		</table>
		<hr>
		<center>
			<button onclick="location.href='/logout'">로그아웃</button>
		</center>
	</center>
</body>
</html>