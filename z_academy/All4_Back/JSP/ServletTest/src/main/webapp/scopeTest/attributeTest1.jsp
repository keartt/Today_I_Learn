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
<% //�̸��� ���̵� getP �޼ҵ带 ����ؼ� �޾ƿ�
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
%>

<% // �޾ƿ� �Ķ���� ���� ���� ��� application ������ setAttribute �޼ҵ�� ���
	// ���ø����̼� ������ ��� ����?
	if( name!=null && id != null ){
									// ������, ��	
		application.setAttribute("name",name);
		application.setAttribute("id",id);
	}

	// application ������ ��ϵ� �Ӽ����� getA �� �о� ��
	// getAttribute �� ObJECT Ÿ���̹Ƿ� ����ȯ
	name=(String)application.getAttribute("name");
	id=(String)application.getAttribute("id");
%>

	<form action="attributeTest2.jsp" method="post">
		<h2><%=name %>�� �ݰ����ϴ�</h2>
		<h2><%=id %>�� �� ���̵�� <%=id %> �Դϴ�.</h2>

		<table>
			<tr>
				<td colspan="2">���� ������ ������ �����</td>
			</tr>
			<tr></tr>
			<td>email �ּ�</td>
			<td><input type="text" name="email"></td>
			<tr>
				<td>�� �ּ�</td>
				<td><input type="text" name="address"></td>
			</tr>
			<td>��ȭ��ȣ</td>
			<td><input type="text" name="tel"></td>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>


	</form>
</body>
</html>