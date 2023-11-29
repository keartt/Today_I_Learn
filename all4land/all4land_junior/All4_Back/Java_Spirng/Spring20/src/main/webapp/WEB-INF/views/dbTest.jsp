<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	
	<%
	Connection conn = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
      
		conn = ds.getConnection();
		
		out.println("<h3>연결되었습니다.</h3>");
	} catch(Exception e){
		out.println("<h3>실패</h3>");
		e.printStackTrace();
	}
%>

</body>
</html>