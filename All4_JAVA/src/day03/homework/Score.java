package day03.homework;

import java.util.Scanner;

public class Score {

	Scanner sc = new Scanner(System.in);
	Data data = new Data();
	
	public Score() {
		people();
		Data list[] = new Data[data.getPeople()];
		for (int i = 0; i < data.getPeople(); i++) {
			list[i] = inputList();
		}

		for (int i = 0; i < data.getPeople(); i++) {
			System.out.printf("name : %s, score1 : %d, score2 : %d, score3 : %d, sum : %d, avg : %f, \n",
					list[i].getName(), list[i].getScore1(), list[i].getScore2(), list[i].getScore3(), list[i].getSum(),
					data.getAvg());
		}
	}


	public void people() {
		System.out.print("How many people? : ");
		data.setPeople(sc.nextInt());
	}

	// 이름 입력 name
	public void name() {
		System.out.print("name ? : ");
		data.setName(sc.next());
	}

	// 성적 입력 score1, score2, score3
	public void score() {
		System.out.print("score1 ? : ");
		data.setScore1(sc.nextInt());

		System.out.print("score2 ? : ");
		data.setScore2(sc.nextInt());

		System.out.print("score3 ? : ");
		data.setScore3(sc.nextInt());
	}

	// 계산하기
	// 합계 구하기 sum
	public void sum() {
		data.setSum(data.getScore1() + data.getScore2() + data.getScore3());
	}

	// 평균 구하기 avg
	public void avg() {
		data.setAvg(data.getSum() / 3);
	}

	// 데이터 객체 배열
	public Data inputList() {
		name();
		score();
		sum();
		avg();
		Data list = new Data(data.getName(), data.getScore1(), data.getScore2(), data.getScore3(), data.getSum(),
				data.getAvg());
		return list;
	}

}
