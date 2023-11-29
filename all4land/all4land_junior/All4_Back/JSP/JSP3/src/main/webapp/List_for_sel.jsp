<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
    선택한 상품 : ${param.sel}
    <br> num1 값 : ${eltest_forEach.num1 }
    <br> num2 값 : ${eltest_forEach.num2 }
    <br> num1 + num2 = ${eltest_forEach.num1 + eltest_forEach.num2 }
</body>
</html>