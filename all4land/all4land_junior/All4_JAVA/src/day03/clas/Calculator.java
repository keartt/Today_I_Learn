package day03.clas;

import java.util.Scanner;

// 4칙연산 계산기 => 클래스화
public class Calculator {
	// 메인
	public static void main(String[] args) {
		Calculator a = new Calculator();
		a.start();
	}

	// 필드
	private Scanner sc = new Scanner(System.in);
	private float num1, num2, answer;
	private String sign;

	// 첫번째 숫자 입력
	public void setNum1() {
		System.out.print("input num1 : ");
		num1 = sc.nextInt();
	}
	// 첫번째 숫자 불러오기
	public float getNum1() {
		return num1;
	}
	// 두번째 숫자 입력
	public void setNum2() {
		System.out.print("input num2 : ");
		num2 = sc.nextInt();
	}
	// 두번째 숫자 불러오기
	public float getNum2() {
		return num2;
	}
	// 부호 입력
	public void setSign() {
		System.out.print("input sign : ");
		sign = sc.next();
	}
	// 부호 불러오기
	public String getSign() {
		return sign;
	}
	// 불러온 부호값에 따라 각 계산 메소드로 이동
	public void signPick(String sign) {
		this.sign = sign;

		switch (sign) {
		case "+":
			plus();
			break;
		case "-":
			minus();
			break;
		case "*":
			multiply();
			break;
		case "/":
			divide();
			break;
		default:
			System.out.println("error");
			break;
		}
	}
	// .+
	public void plus() {
		answer = num1 + num2;
		output(answer);
	}
	// .-
	public void minus() {
		answer = num1 - num2;
		output(answer);
	}
	// .*
	public void multiply() {
		answer = num1 * num2;
		output(answer);
	}
	// ./
	public void divide() {
		answer = num1 / num2;
		output(answer);
	}
	// 출력하기
	public void output(float answer) {
		this.answer = answer;
		System.out.printf("%f %s %f  = %f \n", num1, sign, num2, answer);
	}
	// 시작
	public void start() {
		repeat();
	}
	// 반복
	public void repeat() {
		String confirm;
		do {
			System.out.println("go ? if you want press Y");
			confirm = sc.next();

			if (confirm.equals("Y") || confirm.equals("y")) {
				setNum1();
				setSign();
				setNum2();

				signPick(getSign());
			} else {
				System.out.println("end");
			}

		} while (confirm.equals("Y") || confirm.equals("y"));

	}
}