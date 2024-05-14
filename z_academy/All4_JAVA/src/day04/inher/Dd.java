package day04.inher;

public class Dd extends CC {
	
	public Dd() {
		super();
		System.out.println("Dd 생성자");
		// 생성자의 첫번째 라인에는 항상 super() 호출이 존재함
	}
	
	@Override
	public void dispC() {				// 오버라이딩. 부모걸 재정의
		super.dispC();					// 부모 멤버 접근. 
		System.out.println("cD");
	}
	
	public static void main(String[] args) {
		Dd Dd = new Dd();	//1. dd 생성자 호출

//		Dd.dispA(); // aa
//		Dd.dispB(); // bb
		Dd.dispC(); // cc
		
		

	}

}
