<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>request 테스트 폼</h1>
	<form action="request_mid.jsp " method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><select name="job" >
					<option value="전문직" >전문직</option>
					<option value="회사원" >회사원</option>
					<option value="학생" >학생</option>
					<option value="무직" >무직</option>
			</select></td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td><input type="checkbox" name="inter" value="정치">정치 
				<input type="checkbox" name="inter" value="사회">사회 
				<input type="checkbox" name="inter" value="정보통신">정보통신
				</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">확인</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>