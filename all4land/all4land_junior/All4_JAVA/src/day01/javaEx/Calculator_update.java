package day01.javaEx;

import java.util.Scanner;

public class Calculator_update {
	public static void main(String[] args) {
		
		int num1, num2;
		String operation, restart;
		
do {
	Scanner sc = new Scanner(System.in);
	System.out.println("input");
	
	 num1 = sc.nextInt();
	 operation = sc.next();
	 num2 = sc.nextInt();
	
	double result = 0;

	
	if (operation.equals("+")) {
		result = num1+num2;
	}else if (operation.equals("-")) {
		result = num1-num2;
	}else if (operation.equals("*")) {
		result = num1*num2;
	}else if (operation.equals("/")) {
		result = (double)num1/num2;
	}else {System.out.println("잘못된 입력");
	}
	
	System.out.println(num1 +" " + operation + " " + num2 + " =  " + result);
	System.out.println("continue? Y/N");
	restart = sc.next();
} 	while (restart.equals("Y")||restart.equals("y"));

	System.out.println("end");
	
	}
}
