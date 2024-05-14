<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<c:set value="Hello World" var="msg" />
<body>
	msg: ${msg}<br>
	msg: <%=pageContext.getAttribute("msg") %> <br>
</body>
</html>