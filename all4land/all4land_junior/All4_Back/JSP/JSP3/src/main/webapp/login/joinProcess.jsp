<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="join.UsersDAO"%>
<jsp:useBean id="users" class="join.Users" scope="page" />
<jsp:setProperty property="*" name="users" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%request.setCharacterEncoding("UTF-8");
 %>
<body>
	<%
	int result = new UsersDAO().join(users);
	if (result == -1) {
		
		out.print("<script>alert('이미 존재하는 아이디 입니다.');history.back();</script>");

	} else {

			out.print("<script>alert('회원가입 되었습니다.'); location.href=\"loginForm.jsp\"</script>");
	}
	%>

</body>
</html>