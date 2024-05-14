<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
//로그인이 되어 있으면 
// 로그인 되어 있으면 본 페이지로 접근 불가 안내 
	
if (session.getAttribute("user_id") != null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('이미 로그인이 되어있습니다.')");
	script.println("location.href='main.jsp'");
	script.println("</script>");
}
%>

<body>
	<h1 align="center">로그인</h1>
	<FORM name="form" action="loginProcess.jsp" method="post">
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">아이디</td>
				<td><input type="text" name="user_id"></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">비밀번호</td>
				<td><input type="text" name="user_pw"></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 13px;">
			<button type="submit">로그인</button>
			<button type="button" onclick="location.href='joinForm.jsp'">회원가입</button>
		</div>

	</FORM>

</body>
</html>