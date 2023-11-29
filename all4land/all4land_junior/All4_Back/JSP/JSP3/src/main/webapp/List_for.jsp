<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <form name=from1 method="post" action="List_for_sel.jsp">
        <jsp:useBean id="eltest_forEach" class="eltest.Eltest"
            scope="session"></jsp:useBean>

        <select name="sel">
            <c:forEach var="item" items="${eltest_forEach.getProductList()}">
                <option>${item }</option>
            </c:forEach>
        </select> <br> <input type="submit" value="선택" />
    </form>
</body>
</html>