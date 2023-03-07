<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		color: #6600ff;
	}
	.btn{
		background-color: #ccccff;
		border : none;
		border-radius: 5px;
		padding-left: 10px;
		padding-right: 10px;
		padding-top: 5px;
		padding-bottom: 5px;
	}
	hr{
		background:#6600ff;
    	height:1px;
    	border:0;
	}
</style>
</head>
<body>
<center>
<h2 >로그인</h2>
<hr>
<%
	session.invalidate();
	request.setCharacterEncoding("UTF-8");
%>
<form name="frm" method="post" action="loginCK">
	<input type="text" name="id" placeholder="id" required >
	<input type="password" name="pw" placeholder="pw" required ><Br><br>
	<input class="btn" type="submit" value="로그인">
	<a class="btn" href="/test01/join">회원가입</a>	
</form>
</center>
</body>
</html>