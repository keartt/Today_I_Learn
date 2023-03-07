<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript">
	function addboard() {
		boardform.submit();
	}
</script>

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
			location.href='../test01/login';
		</script>
	<%
	}
	%>
	<center>
		<h2>My Batis 게시판</h2>
		<hr>
		<br>
		<table cellpadding="0" cellspacing="0">
		<form action="write" method="post" ><!-- enctype="multipart/form-data"  -->
			<tr>
				<td style="font-family: 돋음; font-size: 12; bordercolor: #333333"
					height="16">
					<div align="center">글쓴이</div>
				</td>
				<td>
					<div><input type="text" name="bName" size = "50" value="<%=id%>" readonly="readonly"></div>
				</td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12; bordercolor: #333333"
					height="16">
					<div align="center">비밀번호</div>
				</td>
				<td><input name="bPw" type="password" size="10"
					maxlength="10" value="" /></td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12; bordercolor: #333333"
					height="16">
					<div align="center">제 목</div>
				</td>
				<td><input name="bTitle" type="text" size ="50"></td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12; bordercolor: #333333">
					<div align="center">내 용</div>
				</td>
				<td><textarea name="bContent" rows="10" ></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input class="btn" type="submit" value="등록">
					<button class="btn" type="button"
			onclick="location.href='javascript:history.go(-1)';">뒤로</button>
			<button class="btn" type="button"
			onclick="location.href='../member/login';">로그아웃</button>
				</td>
			<tr>
			</form>
		</table>
		<br>
		
		
	</center>
	<!-- 게시판 등록 -->
</body>
</html>