package com.all.ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.all.ex2.MyInfo;

public class Main {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		// student Info 는 항상 주입을 통해야 됨
		// 1번 방법 xml 을 통해서 주입해서  ~ 생성자를 통해 주입하고, 주입된 값을 불러옴
		// studentinfo 빈에 student1 을 getinfo 생성자로 대입하고 그거를 가져옴
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
		
		// 2번방법 
		Student student2 = ctx.getBean("student2", Student.class);
		// setter 통해서 자바로 주입한 것 
		// student 2 값만 가져오고 studentInfo 에는 setter 써서 넣음 
		studentInfo.setStudent(student2);
		studentInfo.getStudentInfo();
		
	}
}
