package com.all.spring;

import javax.annotation.*;

public class OtherStudent {
	private String name;
	private String age;

	public OtherStudent(String name, String age ) {
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
	
	@PostConstruct
	public void init() {
		System.out.println("init Method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy Method");
	}
	
	
}
