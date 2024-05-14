package com.all.spring06;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration

// xml 을 어노테이션에 포함 시키기 
@ImportResource("classpath:applicationCTX1.xml")
public class ApplicaitonConfig {
	
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
