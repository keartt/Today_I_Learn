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
		String[] arr = {"������", "������", "������", "Ȳ����"};
		
		for(int i=7; i< 11; i++) {
			stmt.setInt(1,i);
			stmt.setString(2, arr[i-7]);
			if(stmt.executeUpdate() != 0) {
				out.println("<h3>" + i + "�� ���ڵ带 ����Ͽ����ϴ�.  �̸� : "+ arr[i-7]+"</h3>");
			}
		}
	} catch (Exception e) {
		out.println("<h3>�ȵʤ� </h3>");
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