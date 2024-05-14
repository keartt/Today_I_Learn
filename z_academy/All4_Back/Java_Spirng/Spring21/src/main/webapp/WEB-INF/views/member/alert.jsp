<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 뭐하는 페이지인지 궁금하셨어요?
	
	본 페이지는 에러 또는 성공 alert 창을 띄우기 위한 페이지로
	본 페이지에 model 값으로 msg 와 url 을 보내면
	msg 내용을 alert 로 표시하고 성공 url 로 이동시킴  -->
	
	<script type="text/javascript">
		var message = "${msg}";
		var url = "${url}";
		alert(message);
		document.location.href = url;
	</script>
</body>
</html>