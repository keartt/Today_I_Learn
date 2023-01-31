package day04.homework;

import java.util.Scanner;

// 정적 바인딩
public class MyProcess {
	public static void main(String[] args) {
		// 스택 큐 선택, 푸쉬 팝 선택
		int firstChoice, secondChoice;
		// 스택 불러오기
		MyStack stack = new MyStack();
		// 큐 불러오기
		MyQue que = new MyQue();
		Scanner sc = new Scanner(System.in);

		// 0이 입력되기 전까지 계속 반복
		do {
			System.out.println("스택 or 큐? =>  stack : 1  ||  que : 2  || end : 0");
			firstChoice = sc.nextInt();
			// 1 선택 = 스택 진행
			if (firstChoice == 1) {
				do {
					System.out.println("스택 진행");
					
					System.out.println("푸쉬 or 팝? =>  push : 1  ||  pop : 2  ||  back : 3");
					secondChoice = sc.nextInt();
					
					if (secondChoice == 1) {
						System.out.print("스택 _ 푸쉬 값 입력 : ");
						// 1 입력 = 스택의 푸쉬 진행. 매개변수 = 입력값 
						stack.push(sc.nextInt());
					} else if (secondChoice == 2) {
						// 2 입력 = 스택의 팝 진행
						System.out.println("스택 _ 팝 진행");
						stack.pop();
					} else
						break;
				  
				} while (secondChoice != 3);
			// 2 선택 = 큐 진행
			} else if (firstChoice == 2) {

				do {
					System.out.println("큐 진행");
					System.out.println("푸쉬 or 팝? =>  push : 1  ||  pop : 2  ||  back : 3");
					secondChoice = sc.nextInt();

					if (secondChoice == 1) {
						System.out.print("큐 _ 푸쉬 갑 입력 : ");
						// 1 입력 = 큐의 푸쉬 진행. 매개변수 = 입력값
						que.push(sc.nextInt());
					} else if (secondChoice == 2) {
						System.out.println("큐 _ 팝 진행");
						// 2 입력 = 큐의 팝 진행
						que.pop();
					} else
						break;

				} while (secondChoice != 3);

			} else
				break;

		} while (firstChoice != 0);
		System.out.println(" == 종료 == ");

	}
}
