<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<H2>session 예제</H2>
<HR>
<% 
	if(session.isNew()) {
		out.println("<script> alert('세션이 해제되어 다시 설정합니다. ')</script>");
		session.setAttribute("login", "홍길동");
	}	
%>
<%= session.getAttribute("login") %> 님 환영합니다. <br>
세션 아이디  : <%= session.getId() %><br>
세션 유지시간  : <%= session.getMaxInactiveInterval() %> <br>

<button onclick="location.href = 'logout.jsp' ">로그아웃 </button>

</body>
</html>