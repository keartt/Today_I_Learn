package Test;

public class Testt {
	public static void main(String[] args) {
		B b = new B();
	}
}

class A {
	A() {
		this(3);
		System.out.println("기본생성자");
	}
	A(int a) {
		System.out.println("기본생성자2");
	}
}

class B extends A {
	public B() {
		System.out.println("b");
	}
}
