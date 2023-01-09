package day03.Homework;

public class Data {

	private String name;
	private int people, score1, score2, score3, sum;
	private float avg;

	public Data() {
		
	}

	public Data(String name, int score1, int score2, int score3, int sum, float avg) {
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.sum = sum;
		this.avg = avg;

	}

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
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

}
