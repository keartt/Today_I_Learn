package com.all.spring05;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1개 이상 빈을 등록하고 있음을 명시해줌
@Configuration
public class ApplicationConfi{
	
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", "20", hobbys);
		student.setHeight("180");
		student.setWeight("80");
		return student;
	}
	
	
}
