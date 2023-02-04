<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산</title>
</head>

<body>
<center style="margin-top:10%; ">
	<p><%=session.getAttribute("name")%> 님의
	<h1>상품 목록</h1>
	<hr width="300">

	<%
	request.setCharacterEncoding("UTF-8");
	if (session.getAttribute("name") == null) {
		out.println("<script>alert('로그인을 해주세요');</script>");
		out.println("<script>location.href='Login.jsp'</script>");
	}

	ArrayList<String> list = (ArrayList) (session.getAttribute("list"));
	
	if (list == null) {
		out.println("<p>장바구니가 비어있습니다. <hr width=0>");
	} else {
	%>
	<table width="300" height="80" border="0" align="center" cellpadding="5" cellspacing="0">
		
		<%
		// 중복 값 개수를 세기 위해 arrayList -> HashSet //
		Set<String> set = new HashSet<String>(list);
		for (String str : set) {
		%>
		<tr style="text-align:center;">
				<td style="width=40%"><%=str %></td>
				<!-- Collection 객체에서 str 과 같은 값의 포함 빈도수를 반환  -->
				<td style="width=10%"><%=Collections.frequency(list, str) %>개</td>
				<!--  get 방식으로 url 에 이름을 담아서 delete 로 던진다  -->
				<td style="width=40%"><button onclick="location.href= 'delete.jsp?car=<%=str %>'" >하나빼기</button></td>
		</tr>
		<%		}
		} %>
		<tr style="text-align:center;">
			<td colspan=3>&nbsp;</td>
		</tr>
		<tr style="text-align:center;">
			<td colspan=2><button onclick="location.href= 'setProduct.jsp'"  >더담기</button></td>
			<td><button onclick="location.href= 'delete.jsp'"  >다지우기</button></td>
		</tr>
	</table>
	<hr width=0>
	<hr width="300">
	<h3><a href='logout.jsp'>로그아웃</a></h3>
</center>
</body>
</html>