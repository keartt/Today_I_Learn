<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

		


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>



<body>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("var");
	Connection conn = null;
	String sql="SELECT * FROM user_info WHERE id=?"; //������

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){			
		%>

	<h1 align="center">ȸ������</h1>
		<table width="600px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px" width="100px">���̵�</td>
				<td><%=rs.getString(1) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">��й�ȣ</td>
				<td><%=rs.getString(2) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">�̸���</td>
				<td><%=rs.getString(3) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">�̸�</td>
				<td><%=rs.getString(4) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">�������</td>
				<td><%=rs.getString(5) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">���</td>
				<td><%=rs.getString(6) %></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">�ڱ�Ұ�</td>
				<td><%=rs.getString(7) %></td>
			</tr>
		</table>
	
	<%  } 	
		} catch(Exception e){
		e.printStackTrace();
	}
%>

</body>
</html>