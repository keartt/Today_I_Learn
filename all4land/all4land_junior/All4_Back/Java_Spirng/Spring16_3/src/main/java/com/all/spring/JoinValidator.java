package com.all.spring;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JoinValidator implements Validator {


	@Override
	public boolean supports(Class<?> arg0) {
		return Member.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors err) {

		Member member = (Member) obj;
		String user_id = member.getUser_id();
		String user_pw = member.getUser_pw();
		String email = member.getEmail();
		String name = member.getName();
		String pw_chk = member.getPw_chk();
		String regi_num_front = member.getRegi_num_front();
		String regi_num_back = member.getRegi_num_back();
		String interest = member.getInterest();
		String introduce = member.getIntroduce();

		if (Pattern.matches("^[a-zA-Z0-9]{4,12}$", user_id) == false) {
			System.out.println("아이디 형식 오류!!");
			err.rejectValue("user_id", "trouble");
		} 
		
		else if (user_id == user_pw) {
			System.out.println("비번 아이디 같음!!");
			err.rejectValue("user_pw", "trouble");
		}
		
		else if (Pattern.matches("^[a-zA-Z0-9]+[a-zA-Z0-9]{3,11}$", user_pw) == false) {
			System.out.println("비번 형식 오류!!");
			err.rejectValue("user_pw", "trouble", "비밀번호 형식오류");
		} 
		
		else if (user_pw == pw_chk || pw_chk.isEmpty() || pw_chk ==null) {
			System.out.println("비밀번호 확인이 맞지 않습니다.");
			err.rejectValue("pw_chk", "trouble");
		} 
		
		else if (Pattern.matches(
				"^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$",
				email) == false) {
			System.out.println("이메일 생성 조건을 확인해 주세요!!");
			err.rejectValue("email", "trouble");
		}
		else if (regi_num_front.equals("") || regi_num_back.equals("")  ) {
			System.out.println("주민번호 넣어요!!");
			err.rejectValue("regi_num_front", "trouble");
		}
		

		else if (name ==null ) {
			System.out.println("이름 넣어요!!");
			err.rejectValue("name", "trouble");
		}
		
		else if (!RegiChk(regi_num_front,regi_num_back)) {
			System.out.println("주민번호 틀려요!!");
			err.rejectValue("regi_num_front", "trouble");
		}
		else if (interest ==null) {
			System.out.println("체크 해요!!");
			err.rejectValue("interest", "trouble");
		}
		else if ( interest.split(",").length <3 ) {
			System.out.println("체크 3개 이상!!");
			err.rejectValue("interest", "trouble");
		}
		else if (introduce.length() <20) {
			System.out.println("자기소개 20자 이상");
			err.rejectValue("introduce", "trouble");
		}
		
	}
	
	
	   
	public boolean RegiChk(String regi_num_front, String regi_num_back) {
		String[] num1 = regi_num_front.split("");
		String[] num2 = regi_num_back.split("");
		
		int tempSum = 0;

	 	for (int i = 0; i < num1.length; i++) {
	 		tempSum += Integer.parseInt(num1[i]) * (2 + i);
	 	} // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

	 	
	 	for (int i = 0; i < num1.length - 1; i++) {
	 		if (i >= 2) {
	 			tempSum +=  Integer.parseInt(num2[i]) * i;
	 		}
	 		else {
	 			tempSum +=  Integer.parseInt(num2[i]) * (8 + i);
	 		}
	 	} // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

	 	if ((11 - (tempSum % 11)) % 10 != Integer.parseInt(num2[6])) {
	 		
	 		return false;
	 	}
	 			
		return true;
	}

}
