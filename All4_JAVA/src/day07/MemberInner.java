package day07;

public class MemberInner {
	int a = 10;
	private int b = 20;
	static int c = 30;
	
// 1. 이너클래스
	class Inner {
	public void disp() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
	
//	//2. static 정적 클래스
// static class Inner {
//	 void disp() {
//		// static 은 일반 인스턴스 사용 불가
//		System.out.println(c);
//	}
// }
	
// 3. 매소드 속 이너 클래스
//	public void output() {
//		class Inner {
//			public void disp() {
//				System.out.println(a);
//				System.out.println(b);
//				System.out.println(c);
//			}
//		}
//		Inner inner = new Inner();
//		inner.disp();
//	}
	
	public static void main(String[] args) {
		// 1번
		MemberInner.Inner inner = new MemberInner(). new Inner();
		inner.disp();
		
//		//2번
//		// Inner 만 new 안하면 됌 -- static 이기에
//		MemberInner.Inner inner = new MemberInner.Inner();
//		inner.disp();
		
		// 3번
//		MemberInner m = new MemberInner();
//		m.output();

	}

}
