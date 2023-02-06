<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql="SELECT * FROM user_info"; //������
	ArrayList<String> arr = new ArrayList<String>(); //��� ���� ����

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){			
			arr.add(rs.getString(1));
		}
		
		//������ ����Ʈ���� ����
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
<h3 style="text-align:center">ȸ�� ����Ʈ</h3>
<hr>
<h1 align="center">�α���</h1>
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			
			
			<%  for(String id : arr){ %>
			
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px"><a href=Member_info.jsp?var=<%=id %>>���̵�</a></td>
				<td><%=id %></td>
				<td align="center" bgcolor="red"
					style="font-weight: bold; font-size: 18px"><a href=Member_delete.jsp?var=<%=id %>>����</a></td>
			</tr>
			
<%	}
%>
 </table>			
</body>
</html>