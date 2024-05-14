
function 회원가입() {
  var 아이디 = document.getElementById('아이디')
  var 이름 = document.getElementById('이름')
  var 비밀번호 = document.getElementById('비밀번호')
  var 비번확인 = document.getElementById('비번확인')
  var 이메일 = document.getElementById('이메일')
  var 주민번호 = document.getElementById('주민번호')
  var 자기소개 = document.getElementById('자기소개')
  var 출생년도 = document.getElementById('출생년도')

  if (아이디.value.length < 4 | 아이디.value.length > 12 | 아이디.value == '') {
    alert('아이디 길이 확인바람');
    아이디.value = "";
    아이디.focus();
    return;
  }

    var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
        if (!idRegExp.test(아이디.value)) {
            alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
            아이디.value = "";
            아이디.focus();
            return ;


        }

  if (이름.value == '') {
    alert('이름 입력 안함.')
    이름.value = "";
    이름.focus();
    return;
  }

  if (비밀번호.value.length < 4 | 비밀번호.value.length > 12 | 비밀번호.value == '') {
    alert('비밀번호 길이 확인');
    비밀번호.value="";
    비밀번호.focus();
    return;
  }

  var password1RegExp = /^[a-zA-z0-9]{4,12}$/; //비밀번호 유효성 검사
        if (!password1RegExp.test(비밀번호.value)) {
            alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
            비밀번호.value = "";
            비밀번호.focus();
            return ;
        }

    if (비밀번호.value == 아이디.value) {
      alert('아이디랑 비밀번호 똑같아')
      비밀번호.value="";
      비밀번호.focus();
      return;
    }

  if (비번확인.value == '') {
    alert('비번확인 안함')
    비번확인.value="";
    비번확인.focus();
    return;
  }

  if (비밀번호.value != 비번확인.value) {
    alert('비번 다름')
    비번확인.value="";
    비번확인.focus();
    return;
  }

  if (이메일.value.length == 0) {
    alert("메일주소 안침");
    이메일.value="";
    이메일.focus();
    return false;
  }


  else if (이메일.value.indexOf("@") == -1 || 이메일.value.indexOf(".") == -1) {
    alert("이메일 확인바람.")
    이메일.value="";
    이메일.focus();
    return false;
  }


  if (주민번호.value == '') {
    alert('주민번호 안침')
    주민번호.value="";
    주민번호.focus();
    return;
  }

  if (주민번호.value.length != 13) {
    alert('주민번호 13 자리 쳐야함')
    주민번호.value="";
    주민번호.focus();
    return;
  }
 


  var 주민번호값 = 주민번호.value.split('');
  var 계산용 = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5];

  for (let i = 0; i < 주민번호값.length - 1; i++) {
    주민번호값[i] = 주민번호값[i] * 계산용[i];
  }
  var 마지막값 = 주민번호값[주민번호값.length - 1]

  var 계산값 = 0;
  for (let i = 0; i < 주민번호값.length - 1; i++) {
    계산값 += 주민번호값[i];
  }

  계산값 = 계산값 % 11;

  계산값 = 11 - 계산값;

  if (계산값 > 9) {
    계산값 = 계산값 % 10;
  }

  if (계산값 != 마지막값 && 마지막값 != undefined) {
    alert('유효하지 않은 주민번호입니다.');
    주민번호.value="";
    주민번호.focus();
    return;
  }


  //주민등록 번호로 생일 입력
  var 출생년도 = document.getElementById("출생년도");
  var 월 = document.getElementById("월");
  var 일 = document.getElementById("일");

  var firstCode = 주민번호.value.substring(6, 7);
  var birthYear = 주민번호.value.substring(0, 2);

  if (firstCode >= 3) {
    출생년도.value = "20" + birthYear
  } else if (firstCode < 3) {
    출생년도.value = "19" + birthYear;
  }
  월.value = 주민번호.value.substring(2, 4);
  일.value = 주민번호.value.substring(4, 6);




  // 체크박스 갯수 구하기
  var 체크갯수 = document.querySelectorAll('input[name="취미"]:checked').length;
  if (체크갯수 < 3) {
    alert('3개 이상 체크바람');
    document.getElementById('취미').focus();
    return;
  }

  var 자기소개길이 = 자기소개.value.length;
  if (자기소개길이 < 20 | 자기소개.value == '') {
    alert('12자 이상 입력 바람');
    자기소개.focus();
    return;
  }

  alert('통과')

}