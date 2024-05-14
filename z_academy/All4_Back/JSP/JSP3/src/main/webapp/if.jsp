<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<c:set value="Hello World" var="msg" />
<body>
	<c:set value = "superman" var= "msg" />
	msg : ${msg} <br>
	<c:if test="${msg == 'superman' }" var = "result" />
	test result : ${result }

</body>
</html>