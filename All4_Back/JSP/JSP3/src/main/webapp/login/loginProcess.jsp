<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "join.UsersDAO" %>
<jsp:useBean id="users" class="join.Users" scope="page" />
<jsp:setProperty name="users" property="user_id"/>
<jsp:setProperty name="users" property="user_pw"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
		String user_id= null;
		if(session.getAttribute("user_id") != null){
			// 유저 아이디에 세션 아이디를 할당해줌 
			user_id = (String)session.getAttribute("user_id");
		}
		if(user_id != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어있습니다.')");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		
		int result = new UsersDAO().login(users.getUser_id(), users.getUser_pw());
		
		if(result == 1){
			session.setAttribute("user_id", users.getUser_id());//해당 유저 아이디를 세션값으로 넣음.
			PrintWriter script = response.getWriter();  
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(result == 2){
			session.setAttribute("user_id", "관리자");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
		else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
		else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다..')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
	%>

</body>
</html>