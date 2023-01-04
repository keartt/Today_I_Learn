import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input");
		
		int num1 = sc.nextInt();
		String operation = sc.next();
		int num2 = sc.nextInt();
		
		double result = 0;

		
		switch (operation) {
		case "+": result = num1 + num2; 	break;
		case "-": result = num1 - num2; 	break;
		case "*": result = num1 * num2; 	break;
		case "/": result = num1 / num2; 	break;

		default:	System.out.println("wrong"); 	break;
		}
		
		System.out.println(num1 +" " + operation + " " + num2 + " =  " + result);
		
	}
	
}
