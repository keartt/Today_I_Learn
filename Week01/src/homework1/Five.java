package homework1;

public class Five {
	public static void main(String[] args) {
		//위 3줄 = 피라미드
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2-i; j++) {		// 공백
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i +1; j++) {	//별 : 홀수
				System.out.print("*");
			}
			System.out.println(); 			// 쥴버뀸
		}
		
		//아래
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < i+1; j++) {		// 공백
				System.out.print(" ");
			}
			for (int j = 3; j > 2*i ; j--) {	//별 : 홀수
				System.out.print("*");
			}
			System.out.println(); 			// 쥴버뀸
		}
		
		
	}

}
