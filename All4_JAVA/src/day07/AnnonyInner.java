package day07;

interface TestInner {
	int data = 1000;

	public void print();
}

// 이렇게 하던걸
//class A implements TestInner {
//	@Override
//	public void print() {
//		System.out.println(data);
//	}
//}

// 이렇게
public class AnnonyInner {

	public void test() {
		new TestInner() { // anonymous Inner class
							// 추상클래스는 객체를 만들 수 없엇으나
							// 위 방법을 이용하면 상속 없이 구체화 가능
			@Override
			public void print() {
				System.out.println(data);
			}
		}.print();
		;
	}

	public static void main(String[] args) {
		AnnonyInner a = new AnnonyInner();
		a.test();

	}

}
