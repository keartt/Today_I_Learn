package day01;
import java.util.Scanner;

public class Hello2 {
	public static void main(String[] args) {
		System.out.println();
		Scanner sc ; 				// reference variable
		
		sc = new Scanner(System.in); // 객체 생성자 호출		 System.in = 키보드 인식
		
		int num1 = sc.nextInt();
		System.out.println(num1);
	}

}
