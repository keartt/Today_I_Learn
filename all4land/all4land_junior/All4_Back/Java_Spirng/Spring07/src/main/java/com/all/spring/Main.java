package com.all.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX1.xml");

//		OtherStudent otherStudent = ctx.getBean("otherStudent", OtherStudent.class);
//		System.out.println("이름 : " + otherStudent.getName());
//		System.out.println("나이 : " + otherStudent.getAge());
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("햄버거");
		student2.setAge("10,000원");
		
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		
		if (student1.equals(student2)) {
			System.out.println("s1 == s2");
		}else {
			System.out.println("s1 != s2");
		}
		
		ctx.close();
	}
}
