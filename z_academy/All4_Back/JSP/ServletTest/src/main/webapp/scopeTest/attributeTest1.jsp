<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>table, tr, td {
border-collapse: collapse; border: 1px solid black;
} </style>
<title>Insert title here</title>
</head>
<body>
<% //이름과 아이디를 getP 메소드를 사용해서 받아옴
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
%>

<% // 받아온 파라미터 값이 있을 경우 application 영역에 setAttribute 메소드로 등록
	// 어플리케이션 영역은 모든 공간?
	if( name!=null && id != null ){
									// 변수명, 값	
		application.setAttribute("name",name);
		application.setAttribute("id",id);
	}

	// application 영역에 등록된 속성들을 getA 로 읽어 옴
	// getAttribute 는 ObJECT 타입이므로 형변환
	name=(String)application.getAttribute("name");
	id=(String)application.getAttribute("id");
%>

	<form action="attributeTest2.jsp" method="post">
		<h2><%=name %>님 반갑습니다</h2>
		<h2><%=id %>님 의 아이디는 <%=id %> 입니다.</h2>

		<table>
			<tr>
				<td colspan="2">세션 영역에 저장할 내용들</td>
			</tr>
			<tr></tr>
			<td>email 주소</td>
			<td><input type="text" name="email"></td>
			<tr>
				<td>집 주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<td>전화번호</td>
			<td><input type="text" name="tel"></td>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>


	</form>
</body>
</html>