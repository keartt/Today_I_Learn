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
<span style="color:red">1. 서버정보 : </span><%=application.getServerInfo() %> <br>
<span style="color:red">2. 서블릿 api 버전 정보</span> <%= application.getMajorVersion()  + " 점 " +application.getMinorVersion() %> <br>
<span style="color:red">3. application.jsp 파일 경로 : </span><%= application.getRealPath("application.jsp") %> <br>



<%
// applicaion 에 number 라는 이름으로 숫자 0 할당
application.setAttribute("number",0); %>
<a href=application_result.jsp>확인하기</a>

</body>
</html>