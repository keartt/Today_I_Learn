<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	//�Ķ���� �޾ƿ���
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int result = 0;

	Connection conn = null;
	String sql="SELECT COUNT(id) AS result FROM user_info WHERE id=? AND pw=?"; //������	

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			result = rs.getInt(1);
		}
		
		//���� Ȯ��
		if(result == 1 && id.equals("admin")){
			result +=1;
		}
		
		//���ǿ� ���� 1���� 2����
		if(result != 0){
			session.setAttribute("login", result);
			session.setAttribute("id", id);
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>

<%
if(result == 1){
	out.println("<script>alert('�α��� �Ǿ����ϴ�.');</script>");
	out.println("<script>location.href='Main.jsp'</script>");
} else if(result == 2) {
	out.println("<script>alert('������ �α��� �Դϴ�.');</script>");
	out.println("<script>location.href='Main.jsp'</script>");
} else {
	out.println("<script>alert('���̵�� ��й�ȣ�� Ȯ���ϼ���.');</script>");
	out.println("<script>location.href='loginForm.jsp'</script>");
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