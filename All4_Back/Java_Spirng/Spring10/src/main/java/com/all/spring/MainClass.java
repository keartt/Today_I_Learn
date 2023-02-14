package com.all.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		 
		AdminConnection adminConnection = ctx.getBean("adminConfig", AdminConnection.class);
		
		
		System.out.println("admin id :" + adminConnection.getAdminId());
		System.out.println("admin id :" + adminConnection.getAdminPw());
		System.out.println("sub admin id :" + adminConnection.getSub_adminId());
		System.out.println("sub admin id :" + adminConnection.getSub_adminPw());
		
		ctx.close();
	}
}
