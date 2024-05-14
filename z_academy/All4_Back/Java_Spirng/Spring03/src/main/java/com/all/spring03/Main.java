package com.all.spring03;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String config1 = "classpath:applicationCTX1.xml";
		String config2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config1, config2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2 ");
		}
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		if (student1.equals(student3)) {
			System.out.println("s1 == s3");
		}else {
			System.out.println("s1 != s3");
		}
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());

		ctx.close();
	}

}
