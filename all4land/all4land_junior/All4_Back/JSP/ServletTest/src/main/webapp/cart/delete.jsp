<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<%
	String car = request.getParameter("car");

	ArrayList<String> list = (ArrayList) session.getAttribute("list");

	if (car == null) {
		// ����Ʈ ���� ���� 
		session.removeAttribute("list");
		out.println("<script>location.href='checkOut.jsp'</script>");
	} else {
		// �޾ƿ� ���� �����ϴ� arrayList �� �ϳ� ����� ����
		list.remove(car);
		// ���� ����Ʈ�� �ٽ� ���ǿ� ����
		session.setAttribute("list", list);
		out.println("<script>location.href='checkOut.jsp'</script>");
	}
	%>
</body>
</html>