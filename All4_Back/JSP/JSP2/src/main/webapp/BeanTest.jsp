<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<jsp:useBean id="beantest" class="test.BeanTest" scope="page"/>
<%-- �ڹ� �� ��ü�� ��������� ���� �����ϴ� ���� �ƴ϶� setter ȣ�� 
<jsp:setProperty name="beantest" property="name" value="BeanTest!"/>
--%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ڹ� �� �׽�Ʈ</title>
</head>
<body>
<b>�ڹٺ� ��� ����</b>
<h3><%=beantest.getName() %></h3>
<%-- �ڹٺ� ��ü�� ��������� ���� �ϴ� ���� �ƴ϶� getter ȣ�� 
<h3><jsp:getProperty name="beantest" property="name"/></h3>
--%>
</body>
</html>