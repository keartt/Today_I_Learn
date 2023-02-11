package com.all.test01;

// 해당 main 은 자바 계산기 만드는 용으로써
// 스프링과는 관련없는 걍 100% 자바 코드임 
public class Main {
	public static void main(String[] args) {
		// myCalculator 생성자를 통해 호출 
		MyCalculator myCalculator = new MyCalculator();
		// myCalculator 에 계산을 위해 
		// Calculator 생성자를 통해 호출해서 set
		myCalculator.setCalculator(new Calculator());

		// 해당 클래스에 set 이용해서 num1, num2 대입하고 
		myCalculator.setNum1(10);
		myCalculator.setNum2(2);

		// 클래스 안에 변수로 들어있는 calculator 의 각 계산 메소드들을 가져와서 실행
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		
	}
}
