<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
//�α����� �Ǿ� ������ 
// �α��� �Ǿ� ������ �� �������� ���� �Ұ� �ȳ� 
	
if (session.getAttribute("user_id") != null) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('�̹� �α����� �Ǿ��ֽ��ϴ�.')");
	script.println("location.href='main.jsp'");
	script.println("</script>");
}
%>

<body>
	<h1 align="center">�α���</h1>
	<FORM name="form" action="loginProcess.jsp" method="post">
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">���̵�</td>
				<td><input type="text" name="user_id"></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">��й�ȣ</td>
				<td><input type="text" name="user_pw"></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 13px;">
			<button type="submit">�α���</button>
			<button type="button" onclick="location.href='joinForm.jsp'">ȸ������</button>
		</div>

	</FORM>

</body>
</html>