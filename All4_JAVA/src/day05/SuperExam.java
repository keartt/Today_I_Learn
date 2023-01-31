package day05;

public class SuperExam extends D {
	public static void main(String[] args) {
		SuperExam se = new SuperExam(1, 2, 3, 4);

		System.out.println(se.getA()); // 1 A 클래스의 getA
		System.out.println(se.getB()); // 2 B 클래스의 getB
		System.out.println(se.getC()); // 3 C 클래스의 getC
		System.out.println(se.getD()); // 4 D 클래스의 getD
	}
	
	public SuperExam(int a, int b, int c, int d) {
		super(a, b, c, d);
	}
}

class D extends C {
	private int d;
	public int getD() {
		return d;
	}
	public D(int a, int b, int c, int d) {
		super(a, b, c);
		this.d=d;
	}

}

class C extends B {
	private int c;

	public int getC() {
		return c;
	}

	public C(int a, int b, int c) {
		super(a, b);
		this.c=c;
	}
}

class B extends A {
	private int b;

	public int getB() {
		return b;
	}

	public B(int a, int b) {
		super(a);
		this.b=b;
	}

}

class A {
	private int a;

	public int getA() {
		return a;
	}

	public A(int a) {
		this.a = a;
	}
}
