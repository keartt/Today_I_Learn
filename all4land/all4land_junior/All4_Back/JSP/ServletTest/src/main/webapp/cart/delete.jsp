<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<%
	String car = request.getParameter("car");

	ArrayList<String> list = (ArrayList) session.getAttribute("list");

	if (car == null) {
		// 리스트 세션 삭제 
		session.removeAttribute("list");
		out.println("<script>location.href='checkOut.jsp'</script>");
	} else {
		// 받아온 값에 대응하는 arrayList 값 하나 지우고 나서
		list.remove(car);
		// 지운 리스트를 다시 세션에 삽입
		session.setAttribute("list", list);
		out.println("<script>location.href='checkOut.jsp'</script>");
	}
	%>
</body>
</html>