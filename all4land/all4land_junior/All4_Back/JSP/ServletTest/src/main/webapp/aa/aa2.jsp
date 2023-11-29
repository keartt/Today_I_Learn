<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function(){
	var submitF = document.getElementById("aa");
	submitF.submit();
}
</script>
</head>
<% 
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String job=request.getParameter("job");
String inter [] =request.getParameterValues("inter");
String interS="";

for(int i = 0; i< inter.length; i++){
	interS += inter[i] +" ";
} 

%>
<h1>지나가세요~</h1>
<!-- get 방식 -->
<a href="aa3.jsp?name=<%=name%>&job=<%=job%>&inter=<%=interS%>"> 지나갈게요~ </a>

<!--  hidden  -->
<form id="aa" action="aa3.jsp" method="post">
<input type="hidden" name="name"  value='<%=request.getParameter("name")%>'>
<input type="hidden" name="job"  value='<%=request.getParameter("job")%>'>
<input type="hidden" name="inter"  value='<%=interS%>'>
</form>


<!-- forward  -->
<jsp:forward page="aa3.jsp"/>



</body>
</html>