<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body>
	<h1 align="center">�α���</h1>
	<FORM name="form" action="loginProcess.jsp" method="post">
		<table width="300px" height="100px" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">���̵�</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr align="center">
				<td align="center" bgcolor="#eee"
					style="font-weight: bold; font-size: 18px">��й�ȣ</td>
				<td><input type="text" name=pw></td>
			</tr>
		</table>
		<div align="center" style="margin-top: 13px;">
			<button type="submit">�α���</button>
			<button type="button" onclick="location.href='joinForm.jsp'">ȸ������</button>
		</div>

	</FORM>

</body>
</html>