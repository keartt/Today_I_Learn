<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="javax.naming.*" %>


<!DOCTYPE html>
<html>
<head>

<%
List<String> arr = (ArrayList<String>) request.getAttribute("memberList");
%>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align:center">회원 리스트</h3>
<hr>
<h1 align="center">로그인</h1>
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			
			<%  for(String id : arr){ %>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight:bold;font-size: 18px"><a href=Member_info.me?var=<%=id %>>아이디</a></td>
				<td><%=id %></td>
				<td align="center" bgcolor="red"
					style="font-weight: bold; font-size: 18px"><a href=Member_delete.me?var=<%=id %>>삭제</a></td>
			</tr>
<%	}%>

 </table>	
 <button onclick = "location.href='./logout.me'"> 로그아웃</button>		
</body>
</html>