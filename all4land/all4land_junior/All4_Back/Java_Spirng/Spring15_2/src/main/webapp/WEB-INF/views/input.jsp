<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="/spring/student" method="post">
 student id : <input type="text" name="studentId">
 <button type="submit">@RequestParam 전송</button>
 </form>
 

</body>
</html>