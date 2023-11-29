<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<%
	Connection con = null;
	String sql = "INSERT INTO student (num,name) VALUES (?, ?)";
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		con = ds.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(sql);
		String[] arr = {"정대진", "이유진", "김종하", "황도현"};
		
		for(int i=7; i< 11; i++) {
			stmt.setInt(1,i);
			stmt.setString(2, arr[i-7]);
			if(stmt.executeUpdate() != 0) {
				out.println("<h3>" + i + "번 레코드를 등록하였습니다.  이름 : "+ arr[i-7]+"</h3>");
			}
		}
	} catch (Exception e) {
		out.println("<h3>안됨ㅋ </h3>");
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>