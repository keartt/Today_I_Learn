package day05;

interface Acc extends Aa, Bb {
}

interface Aa {
	int a = 100; // final static 생략되어 있음
	void disp1(); // abstaract 생략되어 있음 > interface 라 생략 가능
}

interface Bb {
	int a = 100; // final static 생략되어 있음
	void disp2(); // abstaract 생략되어 있음 > interface 라 생략 가능
}

//public class InterExam implements Aa, Bb{	// 인터페이스 상속
//
//	public static void main(String[] args) {
//		Aa aa = new InterExam();   // 동적 바인딩
//		aa.disp1();
////		aa.disp2();		> 동적 바인딩 시 주체가 알고 있는 범위 까지만 접근 가능 

public class InterExam implements Acc { // 인터페이스 상속

	public static void main(String[] args) {
		Acc aa = new InterExam(); // 동적 바인딩
		aa.disp1();
		aa.disp2(); // > 동적 바인딩 시 주체가 알고 있는 범위 까지만 접근 가능
		
		Aa a2 = new InterExam();
		a2.disp1();
//		a2.disp2();

	}

	@Override // 추상 메소드 오버라이딩
	public void disp1() {
		System.out.println("Aa");
	}

	@Override // 다중 상속
	public void disp2() {
	}

}
