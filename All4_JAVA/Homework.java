package day03;

import java.util.Arrays;
import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		Doing doing = new Doing();
		doing.run();
	}
}

//---------기능 구현 클래스---------//
class Doing {
	Scanner sc = new Scanner(System.in);
	Score score = new Score();

	// 실행하기
	public void run() {
		people();
		for (int i = 0; i < score.getPeople(); i++) {
			name();
			score();
			sum();
			avg();
			saved();
		}
		output();
	}

	// 사람수 입력 people
	public void people() {
		System.out.print("How many people? : ");
		score.setPeople(sc.nextInt());
	}

	// 이름 입력 name
	public void name() {
		System.out.print("name ? : ");
		score.setName(sc.next());
	}

	// 성적 입력 score1, score2, score3
	public void score() {
		System.out.print("score1 ? : ");
		score.setScore1(sc.nextInt());

		System.out.print("score2 ? : ");
		score.setScore2(sc.nextInt());

		System.out.print("score3 ? : ");
		score.setScore3(sc.nextInt());
	}

	// 계산하기
	// 합계 구하기 sum
	public void sum() {
		score.setSum(score.getScore1() + score.getScore2() + score.getScore3());
	}

	// 평균 구하기 avg
	public void avg() {
		score.setAvg((score.getScore1() + score.getScore2() + score.getScore3()) / (float) 3);
	}

	// 각 학생마다 저장하기 String 배열에 저장
	public void saved() {
		String[] save = new String[score.getPeople()];
		for (int i = 0; i < save.length; i++) {
			save[i] = "\n ===result===" + "\n name : " + score.getName() + "\n score1 : " + score.getScore1()
					+ "\n score2 : " + score.getScore2() + "\n score3 : " + score.getScore3() + "\n sum : "
					+ score.getSum() + "\n avg : " + score.getAvg();
		}
		score.setSave(save);

	}

	// 출력
	public void output() {
		System.out.println(Arrays.toString(score.getSave()));
	}
}

// 필드명과 get set 
class Score {
	// 필드명
	private int people; // 여러 객체가 people 을 사용하기에 static..?

	private String name;
	private int score1;
	private int score2;
	private int score3;
	private int sum;
	private float avg;

	private String[] save; // 출력값 저장할 배열

	// getter & setter
	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public String[] getSave() {
		return save;
	}

	public void setSave(String[] save) {
		this.save = save;
	}

}
