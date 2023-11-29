package day04.scoreTest;

import java.util.Scanner;

// 한 사람의 성적 처리 프로그램
public class Score {
	// 이름 국 영 수 총 평
	// 이러한 데이터 내용은 여기서 필요함
	// 데이터 클래스에는 필드명과 get set 으로 충분
	Name name;
	Subject kor;
	Subject math;
	Subject eng;
	int sum;
	float avg;

	StudentMany studentMany;

	public Score() {
		studentMany = new StudentMany();
		name = new Name();
		kor = new Subject();
		math = new Subject();
		eng = new Subject();
	}

	public void setStudent(int people) {
		this.studentMany.setPeople(people);
	}

	public int getStudent() {
		return studentMany.getPeople();
	}

	public void setName(String name) {
		this.name.setName(name);
	}

	public void setKor(int kor) {
		this.kor.setScore(kor);
	}

	public void setMath(int math) {
		this.math.setScore(math);
	}

	public void setEng(int eng) {
		this.eng.setScore(eng);
	}

	public String getName() {
		return name.getName();
	}

	public int getKor() {
		return kor.getScore();
	}

	public int getMath() {
		return math.getScore();
	}

	public int getEng() {
		return eng.getScore();
	}

	public void setSum(int kor, int math, int eng) {
		this.sum = this.getKor() + this.getMath() + this.getEng();
	}

	public int getSum() {
		return this.sum;
	}

	public void setAvg(int sum) {
		this.avg = this.getSum() / (float) 3;
	}

	public float getAvg() {
		return this.avg;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Score score = new Score();
		System.out.print("학생 수 입력 ");
		score.setStudent(sc.nextInt());
		Score[] list = new Score[score.getStudent()];

		for (int i = 0; i < score.getStudent(); i++) {
			
			list[i] = new Score();
			System.out.print("이름 : ");
			list[i].setName(sc.next());

			System.out.print("국어 : ");
			list[i].setKor(sc.nextInt());
			System.out.print("수학 : ");
			list[i].setMath(sc.nextInt());
			System.out.print("영어 : ");
			list[i].setEng(sc.nextInt());

			
			list[i].setSum(score.getKor(), score.getMath(), score.getEng());
			list[i].setAvg(score.getSum());
			
			
		}
		
		for (int i = 0; i < score.getStudent(); i++) {
			System.out.printf("name : %s, score1 : %d, score2 : %d, score3 : %d, sum : %d, avg : %f, \n",
					list[i].getName(), list[i].getKor(), list[i].getMath(), list[i].getEng(), list[i].getSum(),
					list[i].getAvg());
		}
	}

}
