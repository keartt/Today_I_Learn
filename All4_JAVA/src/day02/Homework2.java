package day02;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		String restart;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("원하는 별 숫자를 입력하세요 : ");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				star1();
				break;
			case 2:
				star2();
				break;
			case 3:
				star3();
				break;
			case 4:
				star4();
				break;
			case 5:
				star5();
				break;
			case 6:
				star6();
				break;

			default:
				System.out.println("1~6 사이의 수를 입력하세요");
				break;
			}
			System.out.println("continue? Y/N");
			restart = sc.next();
		} while (restart.equals("Y")||restart.equals("y"));
		System.out.println("====end====");
	}

	public static void star1() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star2() {
		for (int i = 0; i < 3; i++) {
			System.out.print("*");
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star3() {
		for (int i = 0; i < 3; i++) {

			for (int k = 0; k < 2 - i; k++) { // 공백찍기
				System.out.print(" ");
			}

			for (int j = 0; j < i + 1; j++) { // 별찍기
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈

		}

	}

	public static void star4() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2 - i; j++) { // 공백
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) { // 별 : 홀수
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
	}

	public static void star5() {
		// 위
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2 - i; j++) { // 공백
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) { // 별 : 홀수
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		// 아래
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < i + 1; j++) { // 공백
				System.out.print(" ");
			}
			for (int j = 3; j > 2 * i; j--) { // 별 : 홀수
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
	}

	public static void star6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("홀수를 입력하세요 : ");
		int input = sc.nextInt();

		for (int i = 1; i <= input; i++) {

			// 중앙 기준 위쪽 영역
			if (i - 1 <= input / 2) {
				System.out.print(" ".repeat(input / 2 - i + 1));
				System.out.print("*".repeat(i * 2 - 1));
			}

			// 중앙 기준 아래쪽 영역
			else {
				System.out.print(" ".repeat(i - input / 2 - 1));
				// 공백 반복
				System.out.print("*".repeat((input - i) * 2 + 1));
				// 공백 반복
			}
			System.out.println(); // 줄바꿈
		}
	}

}