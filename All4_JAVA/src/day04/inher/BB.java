package day04.inher;

public class BB extends AA {
	public void dispB() {
		System.out.println("BB");
	}
	public BB(){
		super();
		System.out.println("BB 생성자");
	}
}