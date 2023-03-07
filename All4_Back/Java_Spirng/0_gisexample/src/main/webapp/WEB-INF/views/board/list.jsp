<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 10px;
}

h2 {
	color: #6600ff;
}

.btn {
	background-color: #ccccff;
	border: none;
	border-radius: 5px;
	padding-left: 10px;
	padding-right: 10px;
	padding-top: 5px;
	padding-bottom: 5px;
}

hr {
	background: #6600ff;
	height: 1px;
	border: 0;
}
;
</style>
	<title>My Batis 게시판</title>
</head>

<body>
<%
	// 값 받아오기
	String id = (String)session.getAttribute("id");
	if(id == null){
	%>
		<script>
			alert("로그인 후 이용해주세요");
			location.href='../test01/login';
		</script>
	<%	
	}
	%>
<center>
<h2>My Batis 게시판</h2>
<hr>
<!-- 게시판 리스트 -->
<table width=50% border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="40%">
			<div align="center">제목</div>
		</td>
		<!-- <td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="15%">
			<div align="center">삭제</div> -->
		</td>
		<td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt; background-color: #ccccff" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	<c:forEach items="${list}" var="dto">
		<tr align="center" valign="middle" bordercolor="#333333" onmouseover="this.style.backgroundColor='F8F8F8'" onmouseout="this.style.backgroundColor=''">
			<td style="font-family:Tahoma;font-size:10pt;">${dto.bId}</td>
			<td style="font-family:Tahoma;font-size:10pt;">
				<c:forEach begin="1" end="${dto.bIndent}">▶</c:forEach>
				<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a></td>
			<!-- <td><a href="delete?bId=${dto.bId}">삭제</a></td> -->
			<td style="font-family:Tahoma;font-size:10pt;">${dto.bName}</td>
			<td style="font-family:Tahoma;font-size:10pt;">${dto.bDate}</td>
			<td style="font-family:Tahoma;font-size:10pt;">${dto.bHit}</td>
		</tr>
		</c:forEach>
</table>
<br>
<button class="btn" type="button" onclick="location.href='./writeForm';">글쓰기</button>

<button class="btn" type="button" onclick="location.href='../test01/login';">로그아웃</button>

</center>
</body>
</html>