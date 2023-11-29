<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("var");
	Connection conn = null;
	String sql="DELETE FROM user_info where id = ?"; //쿼리문
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		if(pstmt.executeUpdate()!=0){
            out.println("<script>alert('삭제 성공');</script>");
            out.println("<script>location.href = 'Member_list.jsp'</script>");
        }

	} catch(Exception e){
		e.printStackTrace();
        out.println("<script>alert('삭제 실패');</script>");
        out.println("<script>location.href = 'Member_list.jsp'</script>");
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