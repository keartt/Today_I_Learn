<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<% request.setCharacterEncoding("UTF-8"); %>
<body>
 <table>
 	<tr>
 		<td>아이디 </td>
 		<td> ${aa.user_id}</td>
 	</tr>
 	<tr>
 		<td>비번 </td>
 		<td> ${aa.user_pw}</td>
 	</tr>
 	<tr>
 		<td>메일 </td>
 		<td> ${aa.email}</td>
 	</tr>
 	<tr>
 		<td>이름 </td>
 		<td> ${aa.name}</td>
 	</tr>
 	<tr>
 		<td>생년월일</td>
 		<td> ${aa.year} ${aa.month} ${aa.day} </td>
 	</tr>
 	<tr>
 		<td> 관심사 </td>
 		<td> ${aa.interest}</td>
 	</tr>
 	<tr>
 		<td> 자기소개 </td>
 		<td> ${aa.introduce}</td>
 	</tr>
 	
 
 
 </table>

</body>
</html>