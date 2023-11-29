package day02;

import java.util.Scanner;

public class FunctionTest2 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		people();
	}

	// 사람 수 입력
	public static void people() {
		System.out.print("몇명?");
		int people;
		people = sc.nextInt();

		input(people);

	}

	// 이름과 성적 입력
	static void input(int people) {

		String[] name;
		int[][] score;

		score = new int[people][4];
		name = new String[people];

		for (int i = 0; i < people; i++) {
			System.out.print("name? :");
			name[i] = sc.next();

			System.out.print("score? :");
			for (int j = 0; j < 3; j++) {
				score[i][j] = sc.nextInt(); // 배열에 점수 저장
			}
		}

		FunctionTest2.calculate(people, name, score);
	}
	
	
	// 계산
	static void calculate(int people, String[] name, int[][] score) {
		float[] avg = new float[people];

		for (int i = 0; i < people; i++) {
			for (int j = 0; j < 3; j++) {
				score[i][3] += score[i][j]; // 합계 저장
			}
			avg[i] = score[i][3] / (float)3;
		}

		FunctionTest2.output(people, avg, score, name);
	}
	
	// 출력
	static void output(int people, float avg[], int[][] score, String[] name) {

		for (int i = 0; i < people; i++) {

			System.out.println("name : " + name[i] + ", score 1 : " + score[i][0] + ", score2 : " + score[i][1]
					+ ", score3 : " + score[i][2] + ", total : " + score[i][3] + ", average : " + avg[i]);
		}
	}

}
