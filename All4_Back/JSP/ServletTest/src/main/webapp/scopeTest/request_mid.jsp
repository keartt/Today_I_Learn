<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
	// ��ü ��Ű �����ϱ�
	Cookie[] cookies = request.getCookies() ;
	if(cookies != null){
		for(int i=0; i < cookies.length; i++){
			// ��Ű�� ��ȿ�ð��� 0���� �����Ͽ� �����Ų��
			cookies[i].setMaxAge(0) ;
			// ���� ����� �߰��Ѵ�
			response.addCookie(cookies[i]) ;
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> �������ϴ�</h1>
<%
	request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("name");
	String job = request.getParameter("job");
	
	// ��Ű�� ����
	response.addCookie(new Cookie("name", name));
	response.addCookie(new Cookie("job", job));
	
	String inter [ ] = request.getParameterValues("inter");

	for(int i=0; i<inter.length; i++) {
		response.addCookie(new Cookie("inter"+i, inter[i] ) ); 
	}
	
%>
<form  action ="request_result.jsp" method="post">

	<button type=submit>��������~</button>
</form>


</body>
</html>