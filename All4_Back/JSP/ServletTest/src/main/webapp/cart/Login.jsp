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
<%
request.setCharacterEncoding("UTF-8");
%>
<body>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> 장바구니 과제 - 강성현 </a>
		</div>
	</nav>
	<!-- 뒤로가기 방지-->
	<%
response.setHeader("Pragma", "no-cache"); 
response.setHeader("Cache-Control", "no-cache"); 
response.setHeader("Cache-Control", "no-store"); 
response.setDateHeader("Expires", 0L); 
%>

	<%
	String name = null;
	if (session.getAttribute("name") != null) {
		// 유저 아이디에 세션 아이디를 할당해줌 
		name = (String) session.getAttribute("name");
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("history.back()");//이전 페이지로 돌려보냄
		script.println("</script>");
	}
	%>

	<div
		style="width: 300px; height: 300px; width: 300px; height: 300px; position: absolute; left: 50%; top: 50%; margin-left: -150px; margin-top: -150px;">
		<form action="../cart/LoginAction.jsp" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">아이디를
					입력해주세요</label> <input type="text" class="form-control"
					aria-describedby="emailHelp" id="name" name="name">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>