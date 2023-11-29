<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<h1><%=getStr() %></h1>
<%!
private String getStr(){
	str+=" + getStr()";
	return str;	
}
private String str = "str";
%>

