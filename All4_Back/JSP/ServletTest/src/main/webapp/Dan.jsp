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
	<h1>������</h1>
	<table style ="border-collapse : collapse">
	<!-- i �� �� 0~9 ���� 10�� -->
	 <% for (int i = 0; i < 10; i++) { %>	
	<tr >
			<!-- J ��  �� 1~9 ���� 9�� -->
			<%for (int j=1; j< 10; j++) { %>
						<!-- 1�� 1�� ���� -->
						<% if(i ==0 && j==1) { %>
					 	<td bgcolor="green"></td>
					 	
					 	<!-- i=0 �� 1���� ���� �� ���� ��Ÿ�� �ش� -->
						<%}else  if(i ==0) { %>
						<td bgcolor="blue"><%= j +"��" %></td>
						
						<!-- 1�� 1��, 1�� �� �ƴϸ鼭, -->
						<!-- J �� 1�϶� �� 1���� 1~9 �� ���ڸ� �����Ѵ�. -->
					 	<%} else if(j ==1) { %>				
						<td bgcolor="red">	<%= i %></td>
						
						<!-- �������� ������ J * I -->
						<% } else { %>
						<td> <%=j +" * " + i +"=" + j*i %></td>
						<% } %>
				
			<%} %>
	</tr>
	<% } %>
	</table>
</body>
</html>