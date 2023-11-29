<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="users.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="users.Users" scope="page" />
<jsp:setProperty name="user" property="userId"/>
<jsp:setProperty name="user" property="userPassword"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		// 세션을 이용해서 로그인 된 유저는 회원가입 창에 들어갈 수 없게 해준다.
		String userID= null;
		if(session.getAttribute("userId") != null){
			// 유저 아이디에 세션 아이디를 할당해줌 
			userID = (String)session.getAttribute("userId");
		}
		if(userID != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어있습니다.')");
			script.println("location.href = 'main.jsp'");//이전(로그인) 페이지로 돌려보냄
			script.println("</script>");
		}
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(user.getUserId(), user.getUserPassword());
		if(result == 1){
			session.setAttribute("userId", user.getUserId());//해당 유저 아이디를 세션값으로 넣음.
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'");//로그인 성공 시 main.jsp로 이동
			script.println("</script>");
		}
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");//이전(로그인) 페이지로 돌려보냄
			script.println("</script>");
		}
		else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");//이전(로그인) 페이지로 돌려보냄
			script.println("</script>");
		}
		else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다..')");
			script.println("history.back()");//이전(로그인) 페이지로 돌려보냄
			script.println("</script>");
		}
	%>
</body>
</html>