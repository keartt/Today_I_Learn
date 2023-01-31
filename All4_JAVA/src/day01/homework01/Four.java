package day01.homework01;

public class Four {
	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2-i; j++) {		// 공백
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i +1; j++) {	//별 : 홀수
				System.out.print("*");
			}
			System.out.println(); 			// 쥴버뀸
		}
	}

}
