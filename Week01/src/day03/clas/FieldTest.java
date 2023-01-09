package day03.clas;

public class FieldTest {
	private int a; // field 멤버변수 이므로 private 필수

	// D.I 의존성 주입 ... Call by Value : 선학습
	public void setA(int a) { 	// = public void setA(FieldTest this, int aa)
		this.a =a;
//		a = aa;				// 필드명a =  지역변수명 aa  해야 함
	}

	public int getA() {			// = public int getA(FieldTest this)
		return a;			// = return this.a;
	}

	
	public FieldTest getThis(FieldTest this) {
		return this;	// 자기 자신 (FieldTest) 을 리턴할 때 
	}
	
	// 작업 시 main 은 외부라고 생각하고 항상 작업!
	// java > divide
	public static void main(String[] args) {
		FieldTest h = new FieldTest();

		h.setA(1000); // h.a = 1000;
		System.out.println(h.getA());

	}

}

// 코드 영역에 SET과 GET 을생성.. 메모리가 아닌?
// 어떤 A인지 확인하기 위해..?