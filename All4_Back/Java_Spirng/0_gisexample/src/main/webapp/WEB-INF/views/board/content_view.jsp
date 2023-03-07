<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>

<body>
<%
	// 값 받아오기
	String id = (String)session.getAttribute("id");
	
	String name = request.getParameter("content_view.bName");

	if(id == null){
	%>
		<script>
			alert("로그인 후 이용해주세요");
			location.href='../test01/login';
		</script> 
	<%
	}
	%>
	<table cellpadding="0" cellspacing="0">
		<form action="modify" method="post">
		<tr align="center" valign="middle">
			<td colspan="5">My Batis 게시판</td>
		</tr>
		<tr>
			<td>번호</td>
			<td><input type="text" name="bId"
				value="${content_view.bId}" readonly="readonly"></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${content_view.bHit}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="bName"
				value="${content_view.bName}" readonly="readonly"></td>
		</tr>
		<tr>
			<td style="font-family: 돋음; font-size: 12" height="16">
				<div align="center">제 목&nbsp;&nbsp;</div>
			</td>

			<td style="font-family: 돋음; font-size: 12"><input type="text"
				name="bTitle" value="${content_view.bTitle}"></td>
		</tr>

		<tr bgcolor="cccccc">
			<td colspan="2" style="height: 1px;"></td>
		</tr>

		<tr>
			<td style="font-family: 돋음; font-size: 12">
				<div align="center">내 용</div>
			</td>
			<td style="font-family: 돋음; font-size: 12">
				<table border=0 width=490 height=250 style="table-layout: fixed">
					<tr>
						<td valign=top style="font-family: 돋음; font-size: 12"><textarea
								rows="10" name="bContent">${content_view.bContent}</textarea></td>
					</tr>
				</table>
			</td>
		</tr>
	</tr> 
		<tr bgcolor="cccccc">
			<td colspan="2" style="height: 1px;"></td>
		</tr>

		<tr align="center" valign="middle">
			<td colspan="2">
		
					
				 
				<a href="list">목록보기</a> &nbsp;&nbsp; 
				
				<%
					String check = (String)request.getAttribute("userCheck");
					if(check.equals("true")){
				%>
				<input class="btn" type="submit" value="수정">	&nbsp;&nbsp;
				<a class="btn" href="delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; 
		<%} %>		
				<a href="reply_view?bId=${content_view.bId}">답변</a>
				<button class="btn" type="button" onclick="location.href='../test01/login';">로그아웃</button>
			</td>
		</tr>
		</form>
	</table>
</body>
</html>