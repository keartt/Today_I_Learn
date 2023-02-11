package com.all.test01;

public class MyCalculator {

	Calculator calculator;
	private int num1;
	private int num2;

	// calculator 클래스를 변수로, 가짐
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	public void add() {
		calculator.add(num1, num2);
	}

	public void sub() {
		calculator.sub(num1, num2);
	}

	public void mul() {
		calculator.multi(num1, num2);
	}

	public void div() {
		calculator.div(num1, num2);
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
}
