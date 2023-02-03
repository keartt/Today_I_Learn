<%@page import="java.io.PrintWriter"%>
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
	<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      장바구니 과제 - 강성현
    </a>
    <button class="btn btn-outline-success" onclick="location.href='../cart/logout.jsp' ">로그아웃</button>
  </div>
</nav>
<%
response.setHeader("Pragma", "no-cache"); 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setDateHeader("Expires", 0L); 
%>
	
	
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
	
	<br><h1 style="text-align:center"><%=name%> 님 안녕하세요 </h1><br><hr>

		<div
			style="width: 300px; height: 300px; position: absolute; left: 50%; top: 50%; margin-top: -150px;">
			<form action="../cart/add.jsp" method="post" >
				<select class="select" aria-label="Default select example"
					name="product">
					<option value="사과">사과</option>
					<option value="멜론">멜론</option>
					<option value="바나나">바나나</option>
					<option value="귤">귤</option>
				</select>
				<button type="submit">추가하기</button>
			</form>
			<button type="button" class="btn btn-secondary btn-lg"
			onclick="location.href='../cart/checkOut.jsp' " >장바구니 보기</button>
		</div>


		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"></script>
</body>
</html>