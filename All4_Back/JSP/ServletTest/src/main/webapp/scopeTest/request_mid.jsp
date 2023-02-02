<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
	// 전체 쿠키 삭제하기
	Cookie[] cookies = request.getCookies() ;
	if(cookies != null){
		for(int i=0; i < cookies.length; i++){
			// 쿠키의 유효시간을 0으로 설정하여 만료시킨다
			cookies[i].setMaxAge(0) ;
			// 응답 헤더에 추가한다
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
<h1> 지나갑니다</h1>
<%
	request.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("name");
	String job = request.getParameter("job");
	
	// 쿠키에 저장
	response.addCookie(new Cookie("name", name));
	response.addCookie(new Cookie("job", job));
	
	String inter [ ] = request.getParameterValues("inter");

	for(int i=0; i<inter.length; i++) {
		response.addCookie(new Cookie("inter"+i, inter[i] ) ); 
	}
	
%>
<form  action ="request_result.jsp" method="post">

	<button type=submit>누르세요~</button>
</form>


</body>
</html>