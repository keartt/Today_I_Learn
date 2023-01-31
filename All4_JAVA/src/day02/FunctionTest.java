package day02;

public class FunctionTest {

	public static void a() {
		System.out.println("A");
	}

	static int b(int num) {
		System.out.println("B : " + num);
		return num * 2;
	}

	static int[] c(int arr[]) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
		return arr;
	}

	public static void s(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		a();
		FunctionTest.a(); // static 함수임을 선언함과 동시에
		FunctionTest.b(100); //
		System.out.println(FunctionTest.b(100));

		int[] arr = new int[3];
		c(arr);

		int arr2[] = c(arr);
		for (int i : arr2) {
			System.out.print(i);
		}System.out.println();
		
		String str = "hda";
		FunctionTest.s(str);

	}

}
