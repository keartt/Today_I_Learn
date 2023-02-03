<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">

<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
<!-- 뒤로가기 방지 -->
	<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0L);
	%>

	<!-- 로그인 안되어 있으면 해당 페이지 접근 불가 안내   -->
	<%
	String name = null;
	if (session.getAttribute("name") != null) {
		name = (String) session.getAttribute("name");
	}
	if (name == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = '../cart/Login.jsp'");
		script.println("</script>");
	}
	%>

<%
	// 제품 하나 선택할 때마다 그 값을 받아온다
	String product = request.getParameter("product");

	// 받아온 값을 넣을 ArrayLIST.   		 세션 set 은 아래 if 문에 있음 
	// 여기에 세션값에서 가져온 값을  먼저 넣어주는 이유는 이 페이지는 추가할때마다  계속 실행되기 때문
	ArrayList <String> arr = (ArrayList)session.getAttribute("product_List");
	
	// 제품 리스트의 세션값이 없으면
	if(session.getAttribute("product_List") == null ) {
		// 값 넣을 ArrayList 새로 생성 (new)
		arr = new ArrayList <String>();
	}
	arr.add(product);
	session.setAttribute("product_List", arr);
%>
	<script type="text/javascript">
		alert('<%=product%> 추가 완료');
		history.back();
	</script>	

</body>
</html>