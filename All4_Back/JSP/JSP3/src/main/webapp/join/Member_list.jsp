<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql="SELECT * FROM user_info"; //쿼리문
	ArrayList<String> arr = new ArrayList<String>(); //결과 담을 변수

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){			
			arr.add(rs.getString(1));
		}
		
		//어드민은 리스트에서 제거
		arr.remove("admin");
		
	} catch(Exception e){
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
<h3 style="text-align:center">회원 리스트</h3>
<hr>
<h1 align="center">로그인</h1>
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			
			
			<%  for(String id : arr){ %>
			
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px"><a href=Member_info.jsp?var=<%=id %>>아이디</a></td>
				<td><%=id %></td>
				<td align="center" bgcolor="red"
					style="font-weight: bold; font-size: 18px"><a href=Member_delete.jsp?var=<%=id %>>삭제</a></td>
			</tr>
			
<%	}
%>
 </table>			
</body>
</html>