<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set value="batman" var="msg" />
	
	
	msg: <c:out value="${msg}" /> <br>
	<c:remove var = "msg"/>
	after remove : <c:out value="${msg}" />
	
</body>
</html>