// 정규화식 , 검사할 데이터 , 출력 메시지 
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
	// ajax 전송을 위해, 체크박스 선택값 배열로 생성
	var interChk = new Array();

	$("input[name=interest]:checked").each(function () {
		var tmpVal = $(this).val();
		interChk.push(tmpVal);
		console.log(interChk)
	});


	if (introduce.val().length < 20 | introduce.val() == '') {
		alert('12자 이상 입력 바람');
		introduce.focus();
		return false;
	}

	alert('유효성 통과');
}