package com.all.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		MyInfo myInfo = ctx.getBean("myinfo", MyInfo.class);
		
		myInfo.getInfo();
		
		
		ctx.close();
	}
}
