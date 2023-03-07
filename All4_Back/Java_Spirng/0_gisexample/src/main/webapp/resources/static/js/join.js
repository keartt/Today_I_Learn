//form 유효성 검사 
function checkAll() {
	// 아이디 확인
	if (!id_ck(form.id.value)) {
		return false;
	}
	// 비밀번호 확인
	if (!pw_ck(form.id.value, form.pw.value, form.pwRe.value)) {
		return false;
	}
	// 이메일 확인
	if (!mail_ck(form.mail.value)) {
		return false;
	}
	// 이름 확인
	if (!name_ck(form.name.value)) {
		return false;
	}
	// 주민번호 확인
	if (!jumin_ck(form.pnumber.value)) {
		return false;
	}
	// 생년월일 확인
	if (!birth_ck()) {
		return false;
	}
	// 관심분야 확인
	if (!likes_ck()) {
		return false;
	}
	// 자기소개 확인
	if (!intro_ck()) {
		return false;
	}

	// 주소 확인 - 점검 필요!
	if (document.getElementById("address").value == "") {
		alert("주소를 입력");
		form.zipcode.focus();
		return false;
	}

	//if (form.idDuplication.value != "idCheck"){
	//	alert("아이디 중복확인을 해주세요");
	//}

	return true;
}

// 공백확인
function ck_space(value, title) {
	if (value == "") {
		alert(title + " 입력해주세요.");
		return false;
	}
	return true;
}

// 주소 확인
function post() {
	console.log(">>>>>>>>>>>");
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("detailAddress").focus();
		}
	}).open();
}

// 아이디 확인
function id_ck(id) {
	// id가 공백일 경우
	if (!ck_space(id, "아이디를")) {
		form.id.focus();
		return false;
	}

	//아이디 유효성 검사
	var idRegExp = /^[a-zA-z0-9]{4,12}$/;
	if (!idRegExp.test(id)) {
		// test() : aoro 문자열이 정규 표현식을 만족하는지 판별하고, 그 여부를 true 또는 false로 반환합니다.
		alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
		form.id.value = ""; // 텍스트 값 초기화
		form.id.focus(); // 바로 입력할 수 있게 포커스
		return false;
	}
	return true; // 정규식과 일치 할 경우
}

//비밀번호 확인 
function pw_ck(id, pw, pwRe) {
	//비밀번호가 공백인 경우
	if (!ck_space(pw, "비밀번호를")) {
		form.pw.focus();
		return false;
	}

	// 비밀번호 확인이 공백인 경우
	if (!ck_space(pwRe, "비밀번호 확인을")) {
		form.pwRe.focus();
		return false;
	}

	//비밀번호 유효성 검사
	var pwRegExp = /^[a-zA-z0-9]{4,12}$/; //비밀번호 유효성 검사
	if (!pwRegExp.test(pw)) {
		alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다.");
		form.pw.value = "";
		form.pw.focus();
		return false;
	}

	// 두 비밀번호가 일치하지 않은 경우
	if (pw != pwRe) {
		alert("두 비밀번호가 일치하지 않습니다.");
		// form.pw.value = "";
		form.pwRe.value = "";
		form.pwRe.focus();
		return false;
	}

	//아이디와 비밀번호가 같을 경우
	if (id == pw) {
		alert("비밀번호는 ID와 동일하면 안됩니다.");
		form.pw.value = "";
		form.pwRe.value = "";
		form.pw.focus(); // 비밀번호를 변경해야 하므로 확인이 아닌 비밀번호에 포커스
		return false;
	}
	return true;
}

// 이메일 확인
function mail_ck(mail) {
	//mail이 공백일 경우
	if (!ck_space(mail, "이메일을")) {
		form.mail.focus();
		return false;
	}

	// 이메일 유효성 검사
	var mailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
	if (!mailRegExp.test(mail)) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.mail.value = "";
		form.mail.focus();
		return false;
	}
	return true;
}

// 이름 확인
function name_ck(name) {
	// 이름이 공백일 경우
	if (!ck_space(name, "이름을")) {
		form.name.focus();
		return false;
	}

	// 이름 글자 수 확인
	if (!(name.length >= 2 && name.length <= 4)) {
		alert("이름은 2~4글자로 입력해야합니다.");
	}

	// 이름 유효성 검사
	var nameRegExp = /^[가-힣]{2,4}$/;
	if (!nameRegExp.test(name)) {
		alert("이름이 올바르지 않습니다.");
		form.name.focus();
		return false;
	}
	return true;
}

// 주민등록번호 확인
function jumin_ck(pnumber) {
	var jnumArr = new Array(); // 입력 한 주민번호를 저장해줄 배열 선언
	var jumin = "";
	var jnumplus = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 1]; // 주민번호 계산할때 쓰이는 배열
	var jnumSum = 0; //pnumber[i] * jnumplus[i] 더한 값

	if (!checknull(pnumber, "주민번호를")) {
		return false;
	}

	// 주민번호 길이
	if (pnumber.length < 12) {
		alert("주민번호는 13자리 입니다.")
		form.pnumber.value = "";
		form.pnumber.focus();
		return false;
	}

	for (var i = 0; i < pnumber.length; i++) { // 입력받은 주민번호 jnumArr배열에 넣기
		jnumArr[i] = pnumber.charAt(i);
	}

	for (var i = 0; i < pnumber.length - 1; i++) { // 입력받은 주민번호 jnumArr배열에 넣기
		jnumSum += jnumArr[i] * jnumplus[i];
	}

	jnumSum = (11 - (jnumSum % 11)) % 10; //주민번호 계산

	//var y = parseInt(pnumber.subString(0,2));
	//var m = parseInt(pnumber.subString(2,4));
	//var d = parseInt(pnumber.subString(4,6));
	//console.log(jnumArr[4]+jnumArr[5]);
	//console.log(parseInt(jnumArr[4]+jnumArr[5]));

	if (jnumSum != jnumArr[12]) { // 계산되서 나온 결과값(jnumSum)과 입력한 주민번호의 마지막이 맞지 않으면 
		alert("주민번호가 올바르지 않습니다."); //alert 창 띄우기
		return false;
	} else { //형식이 올바르면 생년월일 자동으로 입력하기
		// 1900년대생
		if (jnumArr[6] == 1, 2) {
			form.birthday.value = "19" + jnumArr[0] + jnumArr[1];
			for (var i = 0; i < form.month.length; i++) {
				if (form.month[i].value == jnumArr[2] + jnumArr[3]) {
					form.month[i].selected = true;

				}
			}
			//console.log(jnumArr[4]+jnumArr[5]);
			for (var i = 0; i < form.day.length; i++) {
				if (form.day[i].value == jnumArr[4] + jnumArr[5]) {
					form.day[i].selected = true;
					return true;
				}
			}

		}
		// 2000년대생
		else {
			form.birthday.value = "20" + jnumArr[0] + jnumArr[1];
			for (var i = 0; i < form.month.length; i++) {
				if (form.month[i].value == jnumArr[2] + jnumArr[3]) {
					form.month[i].selected = true;

				}
			}
			for (var i = 0; i < form.day.length; i++) {
				if (form.day[i].value == jnumArr[4] + jnumArr[5]) {
					form.day[i].selected = true;
					return true;
				}
			}
		}

	}
	return true; //확인이 완료되었을 때
}

// 생년월일 검사
function birth_ck() {
	// 공백일 경우
	if (!ck_space(form.year.value, "생년월일")) {
		form.year.focus();
		return false;
	}

	var year = form.year.value;
	var month = form.month.value;
	var day = form.day.value;

	var birth = year + "-" + month + "-" + day;

	var chkdate = Date.parse(birth)

	if (isNaN(chkdate) == false) {
		var d = new Date(chkdate);
		return true;
	} else {
		alert("올바른 생년월일을 입력해주세요.")
		return false;
	};
}

// 관심분야 확인
function likes_ck() {
	var count = 0;
	var check = false;
	// 체크 박스 2개이상 체크
	for (var i = 0; i < 5; i++) {
		if (form.favorite[i].checked == true) {
			count += 1;
			if (count >= 2) {
				check = true;
			}
		}

	}
	if (check == false) {
		alert("관심분야를 2개 이상 체크해주세요.");
		return false;
	}
	return check;
}

//자기소개 확인
function intro_ck() {
	var intro = document.getElementById("intro");

	// 공백일 경우
	if (!ck_space(intro.value, "자기소개를")) {
		return false;
	} else {
		if (intro.value.length > 10) {
			return true;
		} else {
			alert("자기소개는 10글자 이상입니다.");
			return false;
		}
	}
}