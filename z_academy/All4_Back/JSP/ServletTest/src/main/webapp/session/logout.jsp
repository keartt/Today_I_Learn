<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script>
	
	window.onload = function () {
		 <% 
		 if( !session.isNew()) {
			session.invalidate();
		}	 
		 %>
		 location.href = 'session.jsp'	}	// ���� ���� �� ��ȯ
	
</script>
</body>
</html>