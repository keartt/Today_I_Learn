<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품선택</title>
</head>

<body>
<center style="margin-top:10%">
	<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");

	//이름이 ""이면 돌려보냄
	if (name == "") {
		out.println("<script>alert('이름을 입력해주세요.');</script>");
		out.println("<script>location.href='login.jsp'</script>");
	}

	if (session.getAttribute("name") == null) {
		session.setAttribute("name", name);
	}

	if (session.getAttribute("name") == null) {
		out.println("<script>alert('로그인을 해주세요');</script>");
		out.println("<script>location.href='Login.jsp'</script>");

	}
	%>


	<h1>상품선택</h1>
	<hr width="300">
	<hr width=0>
	<%=session.getAttribute("name")%> 님의 장바구니 
	<hr width=0>
	<form action="add.jsp" method="post">
		<select name="list">
			<option value="벤츠">벤츠</option>
			<option value="아우디">아우디</option>
			<option value="BMW">BMW</option>
		</select> 
		<input type="submit" value="추가"> 
		<hr width=0>
	</form>
	<hr width="300">
	<hr width=0>
	<button onclick="location.href= 'checkOut.jsp'">계산하기</button>
	<button onclick="location.href= 'logout.jsp'">로그아웃</button></div>
</body>
</html>