<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!--  url 과 다른점 : 이새끼는 그냥 바로 그 페이지로 이동 -->
    <h3>%lt;c:redirect&gt;</h3>
    <c:redirect url="choice.jsp">
        <c:param name="sel">a</c:param>
    </c:redirect>
</body>
</html>