<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<h3 style="text-align: center">회원 정보 수정</h3>
<hr>
<center>
	<body>

		<h1 align="center">회원정보</h1>
		<form action="mypageEdit" method="post" >
			<table width="600px" height="100px" border="1" align="center"
				cellpadding="5" cellspacing="0">
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px" width="30%">아이디</td>
					<td><input type="text" name="user_id" id="user_id" size="12"
					maxlength="12" value = "${member.user_id}" readonly>
					</td>
				</tr>
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">비밀번호</td>
					<td><input type="text" name="user_pw" id="user_pw"
					size="12" maxlength="12" value = "${member.user_pw}" ></td>
				</tr>
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">이메일 </td>
					<td><input type="text" name="email" id="email"
					value =" ${member.email}" >
					</td>
				</tr>
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">이름  </td>
					<td><input type="text" name="name" id="name" size="10"
					maxlength="10" value = " ${member.user_name}"></td>
				</tr>
				<tr align="center">
					<td  rowspan= "2" align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">관심분야  </td>
					<td><input type="text" name="name" id="name" 
					 value = " ${member.interest}"></td>
				</tr>
				<tr>
				<td id="interest"><input type="checkbox" name="interest"
					value="컴퓨터">컴퓨터 <input type="checkbox" name="interest"
					value="인터넷">인터넷 <input type="checkbox" name="interest"
					value="여행">여행 <input type="checkbox" name="interest"
					value="영화감상">영화감상 <input type="checkbox" name="interest"
					value="음악감상">음악감상</td>
			</tr>
				
				<tr align="center">
					<td align="center" bgcolor="#eee"
						style="font-weight: bold; font-size: 18px">자기소개</td>
					<td><textarea name="introduce" id="introduce" cols="70"
						rows="5"  > ${member.introduce}"</textarea ></td>
				</tr>
			</table>
			<input type ="submit" value="수정하기">
		</form>
		<hr>
		<button onclick="location.href='/logout'">로그아웃</button>

	</body>
</html>