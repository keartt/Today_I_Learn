<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ggDAN</title>
</head>
<style>
      table, th, td {
        border: 1px solid black;
      }
      table {
        width: 1000px;
        height: 200px;
      }
    </style>
<body>
	<h1>구구단</h1>
	<table style ="border-collapse : collapse">
	<!-- i 는 행 0~9 까지 10행 -->
	 <% for (int i = 0; i < 10; i++) { %>	
	<tr >
			<!-- J 는  열 1~9 까지 9행 -->
			<%for (int j=1; j< 10; j++) { %>
						<!-- 1행 1열 공백 -->
						<% if(i ==0 && j==1) { %>
					 	<td bgcolor="green"></td>
					 	
					 	<!-- i=0 즉 1행일 때는 각 단을 나타내 준다 -->
						<%}else  if(i ==0) { %>
						<td bgcolor="blue"><%= j +"단" %></td>
						
						<!-- 1행 1열, 1행 이 아니면서, -->
						<!-- J 가 1일때 즉 1열은 1~9 의 숫자를 기입한다. -->
					 	<%} else if(j ==1) { %>				
						<td bgcolor="red">	<%= i %></td>
						
						<!-- 나머지는 구구단 J * I -->
						<% } else { %>
						<td> <%=j +" * " + i +"=" + j*i %></td>
						<% } %>
				
			<%} %>
	</tr>
	<% } %>
	</table>
</body>
</html>