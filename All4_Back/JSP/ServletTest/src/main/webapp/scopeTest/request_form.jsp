<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>request �׽�Ʈ ��</h1>
	<form action="request_mid.jsp " method="post">
	<table>
		<tr>
			<td>�̸�</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>����</td>
			<td><select name="job" >
					<option value="������" >������</option>
					<option value="ȸ���" >ȸ���</option>
					<option value="�л�" >�л�</option>
					<option value="����" >����</option>
			</select></td>
		</tr>
		<tr>
			<td>���ɺо�</td>
			<td><input type="checkbox" name="inter" value="��ġ">��ġ 
				<input type="checkbox" name="inter" value="��ȸ">��ȸ 
				<input type="checkbox" name="inter" value="�������">�������
				</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">Ȯ��</button>
				<button type="reset">���</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>