<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
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


	<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      장바구니 과제 - 강성현
    </a>
    <button class="btn btn-outline-success" onclick="location.href='../cart/logout.jsp' ">로그아웃</button>
  </div>
</nav>

<%
	ArrayList <String> arr = (ArrayList)session.getAttribute("product_List");
	%>

<br><h1 style="text-align:center"> <%=name %>님의 장바구니 </h1><br><hr>
	
		<%if(arr ==null) { %>
			<script type="text/javascript">
			alert('장바구니 비었는데요?');
			history.back();
			</script>	
		<%} else { %>
		
		<div class="d-flex justify-content-center">
		<ul class="list-group">
		<%
		// 중복 제거, 원소 빈도수 출력을 위해 HashSet 으로 변경 
		 Set<String> set = new HashSet<String>(arr);
		
		for(String i : set) { %>
		
		<li
			class="list-group-item d-flex justify-content-between align-items-center">
			<%=i %>&nbsp&nbsp&nbsp <span class="badge bg-primary rounded-pill"> <%= Collections.frequency(arr, i) %></span>
		</li>
		<
		<% } 
		}%>
		
	</ul>
	</div>
		
	<a class="btn btn-primary" href="../cart/setProduct.jsp"  style="margin-left:45%; margin-top:30px;">&nbsp&nbsp더 담기 &nbsp&nbsp</a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>