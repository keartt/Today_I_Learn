<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<script  src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script></script>
<title>회원가입</title>
</head>
<body>
	<p>
	<h1 align="center">회원 가입</h1>
	<br>
	<FORM name="jForm" action="/spring/join_result" method="post"
		onsubmit="return join()">
		<table width="50%" height="80" border="1" align="center"
			cellpadding="5" cellspacing="0">
			<tr align="center">
				<td colspan="2" align="center" bgcolor="grey"
					style="font-weight: bold; font-size: 18px">회원기본정보</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id" id="user_id" size="12"
					maxlength="12"> 4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pw" id="user_pw"
					size="12" maxlength="12"> 4~12자의 영문 대소문자와 숫자로만 입력</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pw_chk" id="pw_chk" size="12"
					maxlength="12"></td>
			</tr>
			<tr>
				<td>메일주소</td>
				<td><input type="text" name="email" id="email">
					예)id@domain.com</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" size="10"
					maxlength="10"></td>
			</tr>
			<tr align="center">
				<td colspan="2" align="center" bgcolor="grey"
					style="font-weight: bold; font-size: 18px">개인 신상 정보</td>

			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="regi_num_front"
					id="regi_num_front" size="6" maxlength="6"> - &nbsp; <input
					type="password" name="regi_num_back" id="regi_num_back" size="7"
					maxlength="7"> 예)123456-1234567</td>
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="text" name="year" id="year" size="4"
					maxlength="4">년 <select id="month" name="month">
						<option value="01" selected="selected">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> 월 <select id="day" name="day">
						<option value="01" selected="selected">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
				</select>일</td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td id="interest"><input type="checkbox" name="interest"
					value="컴퓨터">컴퓨터 <input type="checkbox" name="interest"
					value="인터넷">인터넷 <input type="checkbox" name="interest"
					value="여행">여행 <input type="checkbox" name="interest"
					value="영화감상">영화감상 <input type="checkbox" name="interest"
					value="음악감상">음악감상</td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td><textarea name="introduce" id="introduce" cols="70"
						rows="5"></textarea></td>
			</tr>

		</table>
		<p align="center">
			<button type="submit">회원 가입</button>
			<input type="reset" value="다시 입력">
	</FORM>
 <script>
//정규화식 , 검사할 데이터 , 출력 메시지 
 function check(reg, data, message) {
 	if (reg.test(data.val())) {
 		return true;
 	}
 	alert(message);
 	data.val("");
 	data.focus();
 	return false;
 }

 function join() {
 	var user_id = $("#user_id");
 	var user_pw = $("#user_pw");
 	var pw_chk = $("#pw_chk");
 	var email = $("#email");
 	var name = $("#name");
 	var introduce = $("#introduce");
 	var regi_num_front = $("#regi_num_front");
 	var regi_num_back = $("#regi_num_back");

 	//아이디, 비번 정규화 식
 	var regul1 = /^[a-zA-Z0-9]{4,12}$/;
 	//이메일 정규식
 	var regEmail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);


 	if (user_id.val() == "") {
 		alert("아이디 입력바람");
 		user_id.focus();
 		return false;
 	}
 	//아이디 정규식 
 	if (!check(regul1, user_id, "아이디는 4~12자의 대소문자와 숫자로만")) {
 		return false;
 	}

 	if ((user_pw.val()) == "") {
 		alert("비밀번호 입력바람");
 		user_pw.focus();
 		return false;
 	}

 	if ((user_pw.val()) == (user_id.val())) {
 		alert("비밀번호는 아이디와 달라야함");
 		user_pw.focus();
 		return false;
 	}

 	//비번 정규식
 	if (!check(regul1, user_pw, "비밀번호는 4~12자의 대소문자와 숫자로만")) {
 		return false;
 	}

 	if ((user_pw.val()) != (pw_chk.val())) {
 		alert("비밀번호 불일치");
 		pw_chk.focus();
 		pw_chk.val("");
 		return false;
 	}

 	if ((email.val() == "")) {
 		alert("이메일 확인바람");
 		email.focus();
 		return false;
 	}

 	// 이메일 정규식 
 	if (!check(regEmail, email, "이메일 양식 안맞음")) {
 		return false;
 	}

 	if ((name.val()) == "") {
 		alert("이름 입력바람");
 		name.focus();
 		return false;
 	}

 	// 주민번호 유효한지 체크
 	var arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열
 	var arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

 	for (var i = 0; i < regi_num_front.val().length; i++) {
 		arrNum1[i] = regi_num_front.val().charAt(i);
 	} // 주민번호 앞자리를 배열에 순서대로 담는다.

 	for (var i = 0; i < regi_num_back.val().length; i++) {
 		arrNum2[i] = regi_num_back.val().charAt(i);
 	} // 주민번호 뒷자리를 배열에 순서대로 담는다.

 	var tempSum = 0;

 	for (var i = 0; i < regi_num_front.val().length; i++) {
 		tempSum += arrNum1[i] * (2 + i);
 	} // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

 	for (var i = 0; i < regi_num_back.val().length - 1; i++) {
 		if (i >= 2) {
 			tempSum += arrNum2[i] * i;
 		}
 		else {
 			tempSum += arrNum2[i] * (8 + i);
 		}
 	} // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

 	if ((11 - (tempSum % 11)) % 10 != arrNum2[6]) {
 		alert("주민번호 규칙에 맞지 않음");
 		regi_num_front.val("");
 		regi_num_back.val("");
 		regi_num_front.focus();
 		return false;
 	}

 	// 생일 구하기 
 	// regi_num_front 의 각 값 = arrNum1[ ]을 활용해 생년월일을 구한다
 	if (arrNum1[0] < 3) {
 		$("#year").val("20" + arrNum1[0] + arrNum1[1]);
 	} else {
 		$("#year").val("19" + arrNum1[0] + arrNum1[1]);
 	}
 	$("#month").val(arrNum1[2] + arrNum1[3]);
 	$("#day").val(arrNum1[4] + arrNum1[5]);


 	var chk_cout = $('input:checkbox[name=interest]:checked').length;
 	if (chk_cout < 3) {
 		alert('3개 이상 체크바람');
 		$('#interest').focus();
 		return false;
 	}

 	if (introduce.val().length < 20 | introduce.val() == '') {
 		alert('12자 이상 입력 바람');
 		introduce.focus();
 		return false;
 	}

 	alert('유효성 통과');
 }
 </script>
</body>
</html>