package com.all.spring04;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicaitonConfi {
	
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
	
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영2");
		hobbys.add("요리2");
		
		Student student = new Student("홍길자", "21", hobbys);
		student.setHeight("181");
		student.setWeight("81");
		return student;
	}

}
