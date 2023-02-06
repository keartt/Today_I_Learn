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
    <h3>&lt;c:choose&gt;</h3>
    <form>
        <select name="select">
            <option>-</option>
            <option>a</option>
            <option>b</option>
            <option>c</option>
            <option>d</option>
        </select> <input type="submit">
    </form>

    <c:choose>
        <c:when test="${param.sel=='a' }">a를 선택</c:when>
        <c:when test="${param.sel=='b' }">b를 선택</c:when>
        <c:when test="${param.sel=='c' }">c를 선택</c:when>
        <c:when test="${param.sel=='d' }">a,b,c 외를 선택</c:when>
        <c:otherwise>a,b,c,d를 선택하시오</c:otherwise>
    </c:choose>
</body>
</html>