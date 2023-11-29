package com.all.test01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Main 방식을 스프링 방식으로 바꿔서 계산기 클래스를 활용해보기 위한 Main2 
public class Main2 {
	public static void main(String[] args) {
        // 스프링 적용 
        String location = "classpath:applicationCTX.xml";
        AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
        
        MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
    
        myCalculator.add();
        myCalculator.sub();
        myCalculator.mul();
        myCalculator.div();
    }
}
