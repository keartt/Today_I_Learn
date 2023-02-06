<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <form name=from1 method="post" action="List_sel.jsp">
        <jsp:useBean id="eltest" class="eltest.Eltest" scope="session"></jsp:useBean>

        <select name="sel">
            <%
                for (String item : eltest.getProductList()) {
                    out.println("<option>" + item + "</option>");
                }
            %>
        </select> <br> <input type="submit" value="선택" />
    </form>
</body>
</html>