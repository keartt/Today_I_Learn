<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="join.UsersDAO"%>
<%@ page import="join.Users"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<String> user_id_list = new UsersDAO().getUserID();
	for(String user_id : user_id_list) { %>
		<p><%=user_id %> <a href="member_info.jsp?user_id=<%=user_id%>">��������</a>
		
			<%	 
	}%>

</body>
</html>