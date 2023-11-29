package com.all.spring;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{
	// 어떤 클래스를 검증할건지 
	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.isAssignableFrom(arg0);
	}

	// 실제로 어떤 처리 할 건지 
	@Override
	public void validate(Object obj, Errors err) {
//		System.out.println("vlaidate()");
		Student student = (Student)obj;
		
		String studentName = student.getName();
//		if (studentName == null || studentName.trim().isEmpty() ) {
//			System.out.println("studentName is null or empty");
//			err.rejectValue("name", "trouble");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "trouble");
		int studentId = student.getId();
		if (studentId ==0) {
			System.out.println("student id is 0");
			err.rejectValue("id", "trouble");
		}
	}
}
