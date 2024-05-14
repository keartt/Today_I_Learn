package day01.homework01;

import java.util.Scanner;

public class Six {
	public static void main(String[] args) {

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
				System.out.print("*".repeat((input-i)*2 + 1));
			}
			System.out.println(); // 줄바꿈
		}

	}
}
