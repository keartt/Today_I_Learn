package day05.generic;

public class GenericEx1Main {
	public static void main(String[] args) {
		GenricEx1<String> t = new GenricEx1<String>();

		String[] ss = { "애", "아", "서" };
		t.set(ss);
		t.print();

		// bad way
		GenricEx1 t1 = new GenricEx1();
		Integer[] a = {1,2,3};
		t1.set(a);
		t1.print();

	}

}
