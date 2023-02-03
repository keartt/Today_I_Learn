<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
	<%
	Connection con = null;
	String url="jdbc:postgresql://localhost:5432/postgres";
	String pID = "postgres";
	String PPw = "1234";
	
	Boolean connect = false;
	
	try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, pID, PPw);
		connect = true;
	} catch (Exception e) {
		connect= false;
		e.printStackTrace();
	}
	%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>
<%
	if(connect == true) { %>
		연결됨
<%	} else { %>
		안됨 ㅋ
<%	}  %>

</h3>
</body>
</html>