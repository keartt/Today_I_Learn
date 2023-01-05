package day01;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input");
		
		int num1 = sc.nextInt();
		String operation = sc.next();
		int num2 = sc.nextInt();
		
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
	
	
		
	}
}
