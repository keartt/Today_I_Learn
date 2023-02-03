<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>	
	<% 
	ArrayList <String> del = (ArrayList)session.getAttribute("product_List");
	
	//세션에 담긴 어레이리스트 또는 set 을 일단 가져와
	//가져온 다음에 삭제를 하면 되는데?
	
			session.removeAttribute("");
	
	%>
	

</body>
</html>