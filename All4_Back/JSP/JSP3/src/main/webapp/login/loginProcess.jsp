<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import = "join.UsersDAO" %>
<jsp:useBean id="users" class="join.Users" scope="page" />
<jsp:setProperty name="users" property="user_id"/>
<jsp:setProperty name="users" property="user_pw"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
		String user_id= null;
		if(session.getAttribute("user_id") != null){
			// ���� ���̵� ���� ���̵� �Ҵ����� 
			user_id = (String)session.getAttribute("user_id");
		}
		if(user_id != null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�̹� �α����� �Ǿ��ֽ��ϴ�.')");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		
		int result = new UsersDAO().login(users.getUser_id(), users.getUser_pw());
		
		if(result == 1){
			session.setAttribute("user_id", users.getUser_id());//�ش� ���� ���̵� ���ǰ����� ����.
			PrintWriter script = response.getWriter();  
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(result == 2){
			session.setAttribute("user_id", "������");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		}
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('��й�ȣ�� Ʋ���ϴ�.')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
		else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�������� �ʴ� ���̵��Դϴ�.')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
		else if(result == -2){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�����ͺ��̽� ������ �߻��߽��ϴ�..')");
			script.println("location.href='loginForm.jsp'");
			script.println("</script>");
		}
	%>

</body>
</html>