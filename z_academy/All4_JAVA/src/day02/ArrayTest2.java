package day02;

import java.util.Scanner;


/*	성적 처리 프로그램
 * 1.입력 : 이름, 국, 영, 수
 * 2.연산 : 총점, 평균
 * 3.출력 : 이름, 국, 영, 수, 총점, 평균
 * 
 * 4.1명 성적 배열 할당
 * 4-1 여러 사람 입력
 */
public class ArrayTest2 {
	public static void main(String[] asergs) {
		String[] name;
		int[][] score;
		float[] avg;

		Scanner sc = new Scanner(System.in);

		System.out.println("how many people?");

		int people;
		people = sc.nextInt();
		score = new int[people][4];
		name = new String[people];
		avg = new float[people];

		for (int i = 0; i < people; i++) {
			System.out.println("name? :");
			name[i] = sc.next();

			System.out.println("score? :");

			for (int j = 0; j < 3; j++) {
				score[i][j] = sc.nextInt(); // 배열에 점수 저장
				score[i][3] += score[i][j]; // 합계 저장

			}
			avg[i] = score[i][3] / 3;

		}

		for (int i = 0; i < people; i++) {

			System.out.println("name : " + name[i] + ", score 1 : " + score[i][0] + ", score2 : " + score[i][1]
					+ ", score3 : " + score[i][2] + ", total : " + score[i][3] + ", average : " + avg[i]);
		}
		sc.close();
	}

}
