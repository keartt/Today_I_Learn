<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>application 예제</h2>
<hr>

<%
	// num 에 어플리케이션 number 값 넣기
	int num = (Integer)application.getAttribute("number");

	// 새로고침마다 실행댐, num 증가시킴
	num ++;
	
	// 어플리케이션에 증가된 num 값 저장함
	application.setAttribute("number", num);
	%>
					<!-- 그거 뽑아옴  이거는 유지댐-->
<h3>number : <%=application.getAttribute("number") %></h3>

</body>
</html>