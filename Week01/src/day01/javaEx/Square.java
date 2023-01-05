package day01.javaEx;

public class Square {

	public static void main(String[] args) {
		
//		int count = 0;
//		int square = 1;
//		
//		for (count = 0; square < 500 ; count++) {
//			square*=2;
//		}

		int count = 0;
		int square = 1;
		
		while (square < 500) {
			count++;
			square <<= 1;
		}
		
		System.out.println(count + " 번 접은 후 사각행 개수는");
		System.out.println(square + " 개 ");
	}

}
