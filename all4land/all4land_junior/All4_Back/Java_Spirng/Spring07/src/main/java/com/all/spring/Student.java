package com.all.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 빈이 소멸, 생성되는 시점에서 자동생성, 
// 아래 두개를 override 해두면 자동으로 
public class Student implements InitializingBean, DisposableBean{
	private String name;
	private String age;

	public Student(String name, String age ) {
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	// 생성시점
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
	
	// 소멸시점
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
	
	
	

}
